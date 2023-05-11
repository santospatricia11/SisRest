package com.sisrest.model.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue(value = "N")
public class Nutricionista extends ContaServidor implements Serializable {

	private static final long serialVersionUID = 1L;

}
