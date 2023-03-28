package com.sisrest.dto.beneficiario;

import java.awt.Image;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BeneficiarioResponse {
	
	private Image QRCode;
	
	private long id;
	private boolean ativo;

}
