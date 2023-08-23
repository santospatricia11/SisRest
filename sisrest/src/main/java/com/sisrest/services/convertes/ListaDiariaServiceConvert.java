package com.sisrest.services.convertes;

import com.sisrest.dto.listaDiaria.ListaDiariaRequest;
import com.sisrest.dto.listaDiaria.ListaDiariaResponse;
import com.sisrest.model.entities.ListaDiaria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListaDiariaServiceConvert {
    @Autowired
    private ModelMapper mapper;

    public List<ListaDiariaResponse> listasToResponses(List<ListaDiaria> listas) {
        return listas.stream().map(this::listaToDTO).collect(Collectors.toList());
    }

    public ListaDiaria dtoToListaDiaria(ListaDiariaRequest dto) {
        ListaDiaria lista = mapper.map(dto, ListaDiaria.class);
        return lista;
    }

    public ListaDiariaResponse listaToDTO(ListaDiaria lista) {
        ListaDiariaResponse response = mapper.map(lista, ListaDiariaResponse.class);
        return response;
    }
}
