package com.sisrest.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class AlunoResponse {
	private String nome;
	private String id;
	private String matricula;
	private String email;
	private String CPF;

}
