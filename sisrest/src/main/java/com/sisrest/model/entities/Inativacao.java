package com.sisrest.model.entities;

import java.util.Date;

import javax.persistence.Column;
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
public class Inativacao {
	
	@Id
	@Column
	private long id;
	@Column
	@NotNull
	private Date inicio;
	@Column
	@NotNull
	private Date termino;
	@Column
	@NotNull
	private String motivo;

}
