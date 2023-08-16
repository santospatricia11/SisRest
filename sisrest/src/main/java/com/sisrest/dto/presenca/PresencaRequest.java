package com.sisrest.dto.presenca;

import java.util.Date;

import com.sisrest.model.entities.ListaDiaria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PresencaRequest {
    private Date confirmadoEm;
    private Date compareceuEm;
	private ListaDiaria listaDiaria;
}
