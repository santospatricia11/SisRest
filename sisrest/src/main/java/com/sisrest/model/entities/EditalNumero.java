package com.sisrest.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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
@AllArgsConstructor
@ToString
@Embeddable
public class EditalNumero implements Serializable {

	@Column(name = "edital_numero")
	private int numero;

	@Column(name = "edital_ano")
	private int ano;
}
