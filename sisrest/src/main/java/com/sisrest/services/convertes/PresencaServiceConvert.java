package com.sisrest.services.convertes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.dto.presenca.PresencaRequest;
import com.sisrest.dto.presenca.PresencaResponse;
import com.sisrest.model.entities.ListaDiaria;
import com.sisrest.model.entities.Presenca;
@Service
public class PresencaServiceConvert {
    @Autowired
    private ModelMapper mapper;

    public List<PresencaResponse> presencaToResponses(List<Presenca> presencas) {
        return presencas.stream().map(this::presencaToDTO).collect(Collectors.toList());
    }

    public Presenca dtoToPresenca(PresencaRequest dto, ListaDiaria listaDiaria) {
    	Presenca presenca = mapper.map(dto, Presenca.class);
    	presenca.setListaDiaria(listaDiaria);
        return presenca;
    }

    public Presenca dtoToPresenca(PresencaRequest dto) {
    	Presenca presenca = mapper.map(dto, Presenca.class);
        return presenca;
    }

    public PresencaResponse presencaToDTO(Presenca presenca) {
    	PresencaResponse response = mapper.map(presenca, PresencaResponse.class);
        return response;
    }
}
