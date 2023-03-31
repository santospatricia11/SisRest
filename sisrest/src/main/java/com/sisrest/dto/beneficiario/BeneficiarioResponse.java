package com.sisrest.dto.beneficiario;

import java.awt.Image;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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

	private Inativacao inativacao;

}
