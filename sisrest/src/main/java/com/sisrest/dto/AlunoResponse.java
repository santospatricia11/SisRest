package com.sisrest.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class AlunoResponse {
	private String nome;
	private long id;
	private long matricula;
	private String email;
	private long CPF;

}
