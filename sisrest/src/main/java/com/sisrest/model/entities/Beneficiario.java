package com.sisrest.model.entities;

import java.awt.Image;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
@AllArgsConstructor
@ToString
@Entity
public class Beneficiario extends ContaBeneficiario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Image QRCode;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column
	private long id;
	@Column
	@NotNull
	private boolean ativo;
}
