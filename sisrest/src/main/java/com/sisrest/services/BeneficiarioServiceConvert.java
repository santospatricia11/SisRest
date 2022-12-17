package com.sisrest.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.sisrest.dto.BeneficiarioDto;
import com.sisrest.model.entities.Beneficiario;

public class BeneficiarioServiceConvert {
	
	@Autowired
	private ModelMapper mapper;
	
	public List<BeneficiarioDto> commentToDTOList(List<Beneficiario> entities) {
		List<BeneficiarioDto> dtos = new ArrayList<>();
		
		for (Beneficiario dto : entities) {
			BeneficiarioDto entity = beneficiarioToDTO(dto);
			dtos.add(entity);
		}
		return dtos;
	}

	public Beneficiario dtoToBeneficiario(BeneficiarioDto dto) {
		
		Beneficiario  entity = new Beneficiario();
		
		entity.setMatricula(dto.getMatricula());
		
		return entity;
	}


	public BeneficiarioDto beneficiarioToDTO(Beneficiario entity) {
		
		BeneficiarioDto  dto = new BeneficiarioDto();
			dto.setMatricula(entity.getMatricula());
			
				
		 return dto;
	}

}
