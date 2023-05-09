package com.sisrest.configuration.batch;

import com.sisrest.model.entities.ContaEstudante;
import com.sisrest.repositories.ContaEstudanteRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ContaEstudanteRepository contaEstudanteRepository;

    @Bean
    @StepScope
    public FlatFileItemReader<ContaEstudante> itemReader(@Value("#{jobParameters['arquivo']}") String arquivo) {
        FlatFileItemReader<ContaEstudante> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource(arquivo));
        reader.setLineMapper(new DefaultLineMapper<ContaEstudante>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setDelimiter(",");
                setNames("numero", "matricula", "nome", "campus", "curso", "situacao", "situacaoNoUltimoPeriodo", "email");
            }});
            setFieldSetMapper(new ContaEstudanteFieldSetMapper());
        }});
        return reader;
    }

    @Bean
    public ItemWriter<ContaEstudante> itemWriter() {
        return new ItemWriter<ContaEstudante>() {
            @Override
            public void write(List<? extends ContaEstudante> items) throws Exception {
                for (ContaEstudante contaEstudante : items) {
                    contaEstudanteRepository.save(contaEstudante);
                }
            }
        };
    }

    @Bean
    public Step step() {
        return stepBuilderFactory.get("step")
                .<ContaEstudante, ContaEstudante>chunk(10)
                .reader(itemReader(null))
                .writer(itemWriter())
                .build();
    }

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job")
                .incrementer(new RunIdIncrementer())
                .flow(step())
                .end()
                .build();
    }
}

