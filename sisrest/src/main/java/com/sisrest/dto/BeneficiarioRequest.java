package com.sisrest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

}
