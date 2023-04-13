package com.sisrest.dto.contaBeneficiario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaEstudanteResponse {

	private String nome;
	private String senha;
	private String email;
	private long matricula;
}
