package com.sisrest.model.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
@DiscriminatorValue(value = "A")
public class AssistenteSocial extends ContaServidor implements Serializable{

	private static final long serialVersionUID = 1L;

}
