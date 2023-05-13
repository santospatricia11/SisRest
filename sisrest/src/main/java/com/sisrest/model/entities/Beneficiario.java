package com.sisrest.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.sisrest.dto.contaBeneficiario.ContaEstudanteResponse;
import com.sisrest.dto.edital.EditalResponse;

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
public class Beneficiario implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "beneficiario_id")
	private long id;

	@Column
	@NotNull
	private boolean ativo;

	@NotNull
	@Column
	@NotEmpty
	private long CPF;

	@Column
	private String programa;

	@Column
	private String situacao;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "edital_id")
	private Edital edital;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "contaEstudante_id")
	private ContaEstudante contaEstudante;

}
