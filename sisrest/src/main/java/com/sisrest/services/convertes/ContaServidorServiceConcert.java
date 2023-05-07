package com.sisrest.services.convertes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.dto.contaBeneficiario.ContaEstudanteRequest;
import com.sisrest.dto.contaBeneficiario.ContaEstudanteResponse;
import com.sisrest.dto.contaServidor.ContaServidorRequest;
import com.sisrest.dto.contaServidor.ContaServidorResponse;
import com.sisrest.model.entities.ContaEstudante;
import com.sisrest.model.entities.ContaServidor;
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
