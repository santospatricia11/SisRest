package com.sisrest.model.entities;

import java.awt.Image;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.OneToOne;
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
@Table(name = "beneficiario")
public class Beneficiario  implements Serializable{

	
	private static final long serialVersionUID = 1L;

	//private Image QRCode;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "beneficiario_id")
	private long id;
	
	@Column
	@NotNull
	private boolean ativo;
	
	@ManyToOne
    @JoinColumn(name = "edital_id")
    private Edital edital;
	
	@OneToOne
    @JoinColumn(name = "contaBeneficiario_id")
    private ContaBeneficiario contaBeneficiario;
}
