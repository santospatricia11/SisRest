package com.sisrest.services.convertes;

import com.sisrest.dto.contaServidor.ContaServidorRequest;
import com.sisrest.dto.contaServidor.ContaServidorResponse;
import com.sisrest.model.entities.ContaServidor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServidorServiceConcert {

    @Autowired
    private ModelMapper mapper;

    public List<ContaServidorResponse> usersToResponses(List<ContaServidor> contaServidores) {
        return contaServidores.stream().map(this::contaServidorToDTO).toList();
    }

    public ContaServidor dtoToContaServidor(ContaServidorRequest dto) {
        ContaServidor contaServidor = mapper.map(dto, ContaServidor.class);
        return contaServidor;
    }

    public ContaServidorResponse contaServidorToDTO(ContaServidor contaServidor) {
        ContaServidorResponse contaServidorResponse = mapper.map(contaServidor, ContaServidorResponse.class);
        return contaServidorResponse;
    }

}
