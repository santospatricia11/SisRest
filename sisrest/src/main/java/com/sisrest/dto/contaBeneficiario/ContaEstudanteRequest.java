package com.sisrest.dto.contaBeneficiario;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ContaEstudanteRequest {

	private String senha;

	private String nome;

	private String email;

	private String matricula;

}
