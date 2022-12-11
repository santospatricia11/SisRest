package com.sisrest.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.sisrest.model.entities.Beneficiario;



public class BeneficiarioDto {
private Long matricula;
	
	
	public BeneficiarioDto() {
		
	}
	public BeneficiarioDto(Beneficiario beneficiario) {
		this.matricula=beneficiario.getMatricula();
	}
	
	public static List<BeneficiarioDto>converter(List<Beneficiario> beneficiarios){
		return beneficiarios.stream().map(BeneficiarioDto::new).collect(Collectors.toList());
		
	}
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	
	
}
