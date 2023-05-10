package com.sisrest.model.entities;

import javax.persistence.DiscriminatorValue;
import java.io.Serializable;

@DiscriminatorValue(value = "N")
public class Nutricionista extends ContaServidor implements Serializable {

    private static final long serialVersionUID = 1L;

}
