package com.sisrest.dto.edital;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class EditalRequest {
	
	
	@NotNull
	private int numero;
	
	@NotBlank(message = "Ano não informado!")
	@NotNull
	@Size(min = 4, max = 4)
	private String ano;
	
	@NotBlank(message = "Nome não informado!")
	@NotNull
	@Pattern(regexp = "^[A-Z]+(.)*", message = "Nome deve iniciar com letra maiúscula")
	private String nome;
	
	@NotBlank
	@NotNull
	@Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/(19|20)\\d\\d$", message = "Data inválida")
	private Date vigenteInicio;
	
	@NotBlank
	@NotNull
	@Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/(19|20)\\d\\d$", message = "Data inválida")
	private Date vigenteFinal;
}
