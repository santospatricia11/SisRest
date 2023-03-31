package com.sisrest.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@DiscriminatorValue(value = "B")
public class ContaBeneficiario extends Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column
	@NotNull
	private long matricula;
	
	@OneToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;
	
}