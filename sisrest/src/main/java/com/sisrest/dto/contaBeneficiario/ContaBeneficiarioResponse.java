package com.sisrest.dto.contaBeneficiario;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaBeneficiarioResponse {

	private String nome;
	
	private String senha;
	private String email;
	
	private long matricula;
}
