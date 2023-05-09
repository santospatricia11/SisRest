package com.sisrest.configuration.batch;

import com.sisrest.model.entities.ContaEstudante;
import com.sisrest.repositories.ContaEstudanteRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContaEstudanteWriterConfig {
    @Autowired
    private ContaEstudanteRepository contaEstudanteRepository;

    @Bean
    public ItemWriter<ContaEstudante> contaEstudanteWriter() {
        return itens -> {
            for (ContaEstudante estudante : itens) {
                contaEstudanteRepository.save(estudante);
            }
        };
    }
}
