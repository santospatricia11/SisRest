package com.sisrest.dto.beneficiario;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.sisrest.model.entities.ContaBeneficiario;
import com.sisrest.model.entities.Edital;
import com.sisrest.model.entities.Inativacao;

import lombok.Getter;
import lombok.Setter;

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

	@NotNull
	@Column
	private ContaBeneficiario contaBeneficiario;

	

}
