package com.sisrest.configuration.batch;

import com.sisrest.dto.contaBeneficiario.ContaEstudanteRequest;
import com.sisrest.model.entities.ContaEstudante;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContaEstudanteStepConfig {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step contaEstudanteStep(@Qualifier("contaEstudanteReader") FlatFileItemReader<ContaEstudante> contaEstudanteReader, @Qualifier("contaEstudanteWriter") ItemWriter<ContaEstudante> contaEstudanteWriter) {
        return stepBuilderFactory.get("contaEstudanteStep")
                .<ContaEstudante, ContaEstudante>chunk(100)
                .reader(contaEstudanteReader)
                .writer(contaEstudanteWriter)
                .build();
    }
}
