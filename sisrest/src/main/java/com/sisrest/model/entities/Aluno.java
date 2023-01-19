package com.sisrest.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	@Id
	@Column
	@NotNull
	@NotEmpty
	private long id;
	
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
