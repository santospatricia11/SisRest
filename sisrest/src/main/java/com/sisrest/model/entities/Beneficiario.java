package com.sisrest.model.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Beneficiario extends Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(columnDefinition = "matricula_id")

	private long matricula;

	public Beneficiario(Long matricula) {
		super();
		this.matricula = matricula;

	}

	public Beneficiario() {

	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

}
