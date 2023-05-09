package com.sisrest.configuration.batch;

import com.sisrest.model.entities.ContaEstudante;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;

@Configuration
public class ContaEstudanteReaderConfig {

    @Value("#{jobParameters['nomeArquivo']}")
    private String nomeArquivo;

    @Bean
    public FlatFileItemReader<ContaEstudante> contaEstudanteReader() {
        FlatFileItemReader<ContaEstudante> reader = new FlatFileItemReader<>();
        reader.setResource(new PathResource("D:\\GitHub\\SisRest\\sisrest\\src\\main\\resources\\files" + this.nomeArquivo));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<ContaEstudante>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames("nome", "matricula", "email", "campus", "curso");
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<ContaEstudante>() {
                    {
                        setTargetType(ContaEstudante.class);
                    }
                });
            }
        });
        return reader;
    }
}
