package com.sisrest.configuration.batch;

import com.sisrest.dto.contaBeneficiario.ContaEstudanteRequest;
import com.sisrest.services.ContaEstudanteService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContaEstudanteWriterConfig {
    @Autowired
    private ContaEstudanteService contaEstudanteService;

    @Bean
    public ItemWriter<ContaEstudanteRequest> contaEstudanteWriter() {
        return itens -> {
            for (ContaEstudanteRequest estudante : itens) {
                contaEstudanteService.save(estudante);
            }
        };
    }
}
