package com.sisrest.dto.beneficiario;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.sisrest.model.entities.Edital;
import com.sisrest.model.entities.Inativacao;

public class BeneficiarioRequest {
	
	//private Image QRCode;

	
	@Id
	@Column
	private long id;
	@Column
	@NotNull
	private boolean ativo;
	
	@Column
	@NotNull
    private Edital edital;
	
	@Column
	@NotNull
    private Inativacao inativacao;

}
