package com.sisrest.model.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "edital")
public class Edital implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "edital_id")
	private long id;

	@Column(name = "edital_numero")
	private int numero;

	@Column(name = "edital_ano")
	private String ano;

	@Column(name = "edital_nome")
	private String nome;

	@Column(name = "edital_vigente_inicio")
	private Date vigenteInicio;

	@Column(name = "edital_vigente_final")
	private Date vigenteFinal;

}
