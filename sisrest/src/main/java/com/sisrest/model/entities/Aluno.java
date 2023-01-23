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

	@Column
	@NotNull
	@NotEmpty
	private long matricula;

	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String email;

	@NotNull
	@NotEmpty
	@NotBlank(message = "Campo não informado")
	@Column
	private String CPF;

	public static String[] fields() {
		return new String[] { "id", "nome", "matricula", "email", "CPF" };
	}

}
