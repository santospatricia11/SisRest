package com.sisrest.configuration.batch;

import com.sisrest.dto.contaBeneficiario.ContaEstudanteRequest;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContaEstudanteStepConfig {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step contaEstudanteStep(FlatFileItemReader<ContaEstudanteRequest> contaEstudanteReader, ItemWriter<ContaEstudanteRequest> contaEstudanteWriter) {
        return stepBuilderFactory.get("contaEstudanteStep")
                .<ContaEstudanteRequest, ContaEstudanteRequest>chunk(100)
                .reader(contaEstudanteReader)
                .writer(contaEstudanteWriter)
                .build();
    }
}
