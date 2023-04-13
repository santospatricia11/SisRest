package com.sisrest.dto.beneficiario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeneficiarioRequest {

	private boolean ativo;

	private long edital;

	private long contaEstudante;

}
