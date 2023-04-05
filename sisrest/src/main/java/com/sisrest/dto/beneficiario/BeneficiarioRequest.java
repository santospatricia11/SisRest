package com.sisrest.dto.beneficiario;

import java.awt.Image;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.sisrest.model.entities.Edital;
import com.sisrest.model.entities.Inativacao;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
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
