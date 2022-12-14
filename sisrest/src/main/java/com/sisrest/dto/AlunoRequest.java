package com.sisrest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class AlunoRequest {
	

	@NotBlank
	@NotNull
	private String nome;
	
	@NotBlank
	@NotNull
	private long id;
	
	@NotBlank
	@NotNull
	private long matricula;

	
	private String email;

	@NotBlank
	@NotNull
	private long CPF;
}
