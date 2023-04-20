package com.sisrest.configuration.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;

import com.sisrest.dto.contaBeneficiario.ContaEstudanteRequest;
import com.sisrest.services.ContaEstudanteService;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ContaEstudanteService contaEstudanteService;

    @Bean
    public FlatFileItemReader<ContaEstudanteRequest> contaEstudanteReader(@Value("#{jobParameters[caminhoArquivo]}") String caminhoArquivo) {
        FlatFileItemReader<ContaEstudanteRequest> reader = new FlatFileItemReader<>();
        reader.setResource(new PathResource(caminhoArquivo)); // Especifique o caminho do arquivo CSV
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<ContaEstudanteRequest>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[]{"nome", "matricula", "email", "campus", "curso"});
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<ContaEstudanteRequest>() {
                    {
                        setTargetType(ContaEstudanteRequest.class);
                    }
                });
            }
        });
        return reader;
    }

    @Bean
    public ItemWriter<ContaEstudanteRequest> contaEstudanteWriter() {
        return itens -> {
            for (ContaEstudanteRequest estudante : itens) {
                contaEstudanteService.save(estudante);
            }
        };
    }

    @Bean
    public Step contaEstudanteStep(String caminhoArquivo) {
        return stepBuilderFactory.get("contaEstudanteStep").<ContaEstudanteRequest, ContaEstudanteRequest>chunk(1000)
                .reader(contaEstudanteReader(caminhoArquivo)).writer(this.contaEstudanteWriter()).build();
    }


    @Bean
    public String jobName() {
        return "contaEstudanteJob";
    }

    @Bean
    public Job contaEstudanteJob(String caminhoArquivo, JobBuilderFactory jobBuilderFactory) {
        return jobBuilderFactory.get(jobName()).incrementer(new RunIdIncrementer()).start(this.contaEstudanteStep(caminhoArquivo))
                .build();
    }

    @Bean
    public JobLauncher jobLauncher(JobRepository jobRepository) throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository);
        jobLauncher.afterPropertiesSet();
        return jobLauncher;
    }
}
