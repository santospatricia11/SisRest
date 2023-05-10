package com.sisrest.model.entities;

import javax.persistence.DiscriminatorValue;
import java.io.Serializable;

@DiscriminatorValue(value = "A")
public class AssistenteSocial extends ContaServidor implements Serializable {

    private static final long serialVersionUID = 1L;

}
