package com.sisrest.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Aluno {
	
	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	@Pattern(regexp = "^[A-Z]+(.)*", message = "Campo nome deve iniciar com letra maiúscula")
	private String nome;

	@Id
	@Column
	@NotNull
	@NotEmpty
	private long matricula;

	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	@Pattern(regexp = "^[A-Z]+(.)*", message = "Campo nome deve iniciar com letra maiúscula")
	private String curso;
	
	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String email;
	
	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private long CPF;
	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String programa;
	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String modalidade;
	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String classificacao;
	

}
