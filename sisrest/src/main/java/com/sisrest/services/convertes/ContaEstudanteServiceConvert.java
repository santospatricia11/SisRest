 package com.sisrest.services.convertes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.dto.contaBeneficiario.ContaEstudanteRequest;
import com.sisrest.dto.contaBeneficiario.ContaEstudanteResponse;
import com.sisrest.model.entities.ContaEstudante;

@Service
public class ContaEstudanteServiceConvert {

	@Autowired
	private ModelMapper mapper;

	public List<ContaEstudanteResponse> usersToResponses(List<ContaEstudante> contasEstudantes) {
		return contasEstudantes.stream().map(this::contaEstudanteToDTO).toList();
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
