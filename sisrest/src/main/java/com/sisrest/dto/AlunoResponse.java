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
	public AlunoResponse(String nome, String id, String matricula, String email, String CPF) {
		
		this.nome = nome;
		this.id = id;
		this.matricula = matricula;
		this.email = email;
		CPF = CPF;
	}
	public AlunoResponse(String string) {
		// TODO Auto-generated constructor stub
	}

}
