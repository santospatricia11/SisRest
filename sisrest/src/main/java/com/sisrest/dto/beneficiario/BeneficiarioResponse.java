package com.sisrest.dto.beneficiario;

import com.sisrest.model.entities.ContaBeneficiario;
import com.sisrest.model.entities.Edital;
import com.sisrest.model.entities.Inativacao;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BeneficiarioResponse {

	// private Image QRCode;

	private long id;
	private boolean ativo;
	private Edital edital;
	private ContaBeneficiario contaBeneficiario;
	

}
