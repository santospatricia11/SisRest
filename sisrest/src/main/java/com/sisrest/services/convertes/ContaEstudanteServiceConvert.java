package com.sisrest.services.convertes;

import com.sisrest.dto.contaEstudante.ContaEstudanteRequest;
import com.sisrest.dto.contaEstudante.ContaEstudanteResponse;
import com.sisrest.model.entities.ContaEstudante;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContaEstudanteServiceConvert {

    @Autowired
    private ModelMapper mapper;

    public List<ContaEstudanteResponse> usersToResponses(List<ContaEstudante> contasEstudantes) {
        return contasEstudantes.stream().map(this::contaEstudanteToDTO).collect(Collectors.toList());
    }

    public ContaEstudante dtoToContaEstudante(ContaEstudanteRequest dto) {
        ContaEstudante contaEstudante = mapper.map(dto, ContaEstudante.class);
        return contaEstudante;
    }

    public ContaEstudanteResponse contaEstudanteToDTO(ContaEstudante contaEstudante) {
        ContaEstudanteResponse contaEstudanteResponse = mapper.map(contaEstudante, ContaEstudanteResponse.class);
        return contaEstudanteResponse;
    }

}
