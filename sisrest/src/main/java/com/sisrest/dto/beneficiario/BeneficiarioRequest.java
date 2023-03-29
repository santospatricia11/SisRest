package com.sisrest.dto.beneficiario;

import java.awt.Image;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class BeneficiarioRequest {
	
	//private Image QRCode;

	
	@Id
	@Column
	private long id;
	@Column
	@NotNull
	private boolean ativo;

}
