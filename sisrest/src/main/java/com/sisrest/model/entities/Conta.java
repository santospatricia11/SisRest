package com.sisrest.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
@Inheritance(strategy = InheritanceType.JOINED)
public  class Conta {
	
	@NotNull
	@NotEmpty

    @Column
	private String nome;
	@Id
	@Column
	private long id;
	
	@NotNull
	@NotEmpty

    @Column
	private String email;
	
	@NotNull
	@NotEmpty

    @Column
	private String senha;
	
	@NotNull
	@NotEmpty

    @Column
	private boolean isAdmin;

}
