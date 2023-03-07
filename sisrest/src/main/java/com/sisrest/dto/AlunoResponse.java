package com.sisrest.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class AlunoResponse {

	private Integer id;
	private String nome;
	private String matricula;
	private String email;
	private String CPF;
	private String valor;
	private String classificacao;
	private String cota;
	private String quantidade;
	private String curso;
	private String modalidade;
	private String situacao;
	private String renda;
	private String pontuacao;
	private String nascimento;
	private String percapta;
	private String programa;
}
