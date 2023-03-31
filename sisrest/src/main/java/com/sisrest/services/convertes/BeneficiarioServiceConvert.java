package com.sisrest.services.convertes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.sisrest.dto.beneficiario.BeneficiarioResponse;
import com.sisrest.model.entities.Beneficiario;

public class BeneficiarioServiceConvert {
	@Autowired
	private ModelMapper mapper;

	public List<BeneficiarioResponse> beneficiariosToResponses(List<Beneficiario> beneficiarios) {
		return beneficiarios.stream().map(this::beneficiarioToDTO).toList();

	}

	public Beneficiario dtoToBeneficiario(Beneficiario dto) {
		Beneficiario beneficiario = mapper.map(dto, Beneficiario.class);
		return beneficiario;
	}

	public BeneficiarioResponse beneficiarioToDTO(Beneficiario beneficiario) {
		BeneficiarioResponse response = mapper.map(beneficiario, BeneficiarioResponse.class);
		return response;
	}

}
