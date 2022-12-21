package com.sisrest.services.convertes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.dto.BeneficiarioRequest;
import com.sisrest.dto.BeneficiarioResponse;
import com.sisrest.model.entities.Beneficiario;

@Service
public class BeneficiarioServiceConvert {

	@Autowired
	private ModelMapper mapper;

	public List<BeneficiarioResponse> usersToResponses(List<Beneficiario> users) {
		return users.stream().map(this::beneficiarioToDTO).toList();
	}

	public Beneficiario dtoToBeneficiario(BeneficiarioRequest dto) {
		Beneficiario beneficiario = mapper.map(dto, Beneficiario.class);
		return beneficiario;
	}

	public BeneficiarioResponse beneficiarioToDTO(Beneficiario beneficiario) {
		BeneficiarioResponse response = mapper.map(beneficiario, BeneficiarioResponse.class);
		return response;
	}

}
