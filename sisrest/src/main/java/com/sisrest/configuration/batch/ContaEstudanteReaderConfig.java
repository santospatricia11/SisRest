package com.sisrest.configuration.batch;

import com.sisrest.dto.contaBeneficiario.ContaEstudanteRequest;
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
    @Bean
    public FlatFileItemReader<ContaEstudanteRequest> contaEstudanteReader(@Value("#{jobParameters[caminhoArquivo]}") String caminhoArquivo) {
        FlatFileItemReader<ContaEstudanteRequest> reader = new FlatFileItemReader<>();
        reader.setResource(new PathResource("\"C:\\Users\\gabri\\Downloads\\" + caminhoArquivo)); // Especifique o caminho do arquivo CSV
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<ContaEstudanteRequest>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames("nome", "matricula", "email", "campus", "curso");
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
}
