package com.sisrest.dto.beneficiario;

import javax.persistence.Column;
import javax.validation.constraints.Email;
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
public class BeneficiarioRequest {

	@NotBlank
	@NotNull
	private String nome;

	@NotNull
	private long matricula;

	@Email
	@NotBlank
	@NotNull
	private String email;

	@NotBlank
	@NotNull
	@Size(min = 8, max = 30)
	@Pattern(regexp = "^[^\\s]+$", message = "Campo inválido")
	private String senha;

	@NotNull
	private boolean isAdmin;
	
	
	@NotNull
	private boolean vinculo;
	
	
	@NotNull
	private String motivo;
}


