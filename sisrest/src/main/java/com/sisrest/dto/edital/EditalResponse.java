package com.sisrest.dto.edital;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditalResponse {

	private long id;

	private int numero;

	private String ano;

	private String nome;

	private Date vigenteInicio;

	private Date vigenteFinal;
}
