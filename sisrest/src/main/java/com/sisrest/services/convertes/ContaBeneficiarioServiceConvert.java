package com.sisrest.services.convertes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.dto.contaBeneficiario.ContaBeneficiarioRequest;
import com.sisrest.dto.contaBeneficiario.ContaBeneficiarioResponse;
import com.sisrest.model.entities.ContaBeneficiario;

@Service
public class ContaBeneficiarioServiceConvert {

	@Autowired
	private ModelMapper mapper;

	public List<ContaBeneficiarioResponse> usersToResponses(List<ContaBeneficiario> users) {
		return users.stream().map(this::beneficiarioToDTO).toList();
	}

	public ContaBeneficiario dtoToBeneficiario(ContaBeneficiarioRequest dto) {
		ContaBeneficiario beneficiario = mapper.map(dto, ContaBeneficiario.class);
		return beneficiario;
	}

	public ContaBeneficiarioResponse beneficiarioToDTO(ContaBeneficiario beneficiario) {
		ContaBeneficiarioResponse response = mapper.map(beneficiario, ContaBeneficiarioResponse.class);
		return response;
	}

}
