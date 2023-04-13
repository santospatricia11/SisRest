package com.sisrest.dto.inativacao;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sisrest.model.entities.Beneficiario;

public class InativacaoRequest {
	
	
	@NotBlank
	@NotNull
	private Date inicio;

	@NotBlank
	@NotNull
	private Date termino;
	
	@NotBlank
	@NotNull
	private String motivo;
	
	@NotBlank
	@NotNull
	private Beneficiario beneficiario;


}
