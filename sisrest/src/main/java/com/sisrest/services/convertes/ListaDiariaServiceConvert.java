package com.sisrest.services.convertes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.dto.listaDiaria.ListaDiariaRequest;
import com.sisrest.dto.listaDiaria.ListaDiariaResponse;
import com.sisrest.model.entities.ListaDiaria;
import com.sisrest.model.entities.Refeicao;

@Service
public class ListaDiariaServiceConvert {
	  @Autowired
	    private ModelMapper mapper;

	    public List<ListaDiariaResponse> listaDiariaToResponses(List<ListaDiaria> listaDiarias) {
	        return listaDiarias.stream().map(this::listaDiariaToDTO).collect(Collectors.toList());
	    }

		/*
		 * public ListaDiaria dtoToListaDiaria(ListaDiariaRequest dto, Refeicao
		 * refeicao) { ListaDiaria listaDiaria = mapper.map(dto, ListaDiaria.class);
		 * listaDiaria.setRefeicoes(refeicao); return listaDiaria; }
		 */

	    public ListaDiaria dtoToListaDiaria(ListaDiariaRequest dto) {
	    	ListaDiaria listaDiaria = mapper.map(dto, ListaDiaria.class);
	        return listaDiaria;
	    }

	    public ListaDiariaResponse listaDiariaToDTO(ListaDiaria listaDiaria) {
	    	ListaDiariaResponse response = mapper.map(listaDiaria, ListaDiariaResponse.class);
	        return response;
	    }
}
