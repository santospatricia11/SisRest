 package com.sisrest.dto.contaBeneficiario;

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
public class ContaBeneficiarioRequest {
	@NotNull
	private String senha;
	@NotNull
	private String nome;
	
	@NotNull
	private String email;
	@NotNull
	private long matricula;
	
	

}


