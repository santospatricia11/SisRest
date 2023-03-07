package com.sisrest.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class Aluno {

	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	@Pattern(regexp = "^[A-Z]+(.)*", message = "Campo nome deve iniciar com letra maiúscula")
	private String nome;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column
	private long id;

	@Column(unique = true)
	@NotNull
	@NotEmpty
	private String matricula;

	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column(unique = true)
	private String email;

	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column(unique = true)
	private String CPF;

	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String curso;

	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String classificacao;

	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String situacao;

	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String valor;

	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String cota;
	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String quantidade;
	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String modalidade;
	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String renda;
	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String pontuacao;
	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String nascimento;
	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String percapta;

	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String programa;

}
