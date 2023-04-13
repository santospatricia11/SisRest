package com.sisrest.dto.beneficiario;

import com.sisrest.dto.contaBeneficiario.ContaEstudanteResponse;
import com.sisrest.dto.edital.EditalResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeneficiarioResponse {

	private long id;
	private boolean ativo;
	private EditalResponse edital;
	private ContaEstudanteResponse contaEstudante;

}
