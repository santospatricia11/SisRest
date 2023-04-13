package com.sisrest.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@DiscriminatorValue(value = "E")
public class ContaEstudante extends Conta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private long id;

	@Column
	@NotNull
	private long matricula;

}