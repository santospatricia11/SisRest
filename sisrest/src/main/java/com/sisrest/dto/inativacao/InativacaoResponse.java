package com.sisrest.dto.inativacao;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sisrest.model.entities.Beneficiario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InativacaoResponse {
	
	private Date inicio;

	private Date termino;
	
	private String motivo;

	private Beneficiario beneficiario;

}