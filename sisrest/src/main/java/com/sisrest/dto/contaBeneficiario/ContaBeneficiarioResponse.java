package com.sisrest.dto.contaBeneficiario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaBeneficiarioResponse {

	private String nome;

	private long id;

	private String email;

	private boolean isAdmin;

	private String tipo;

	private long matricula;
}
