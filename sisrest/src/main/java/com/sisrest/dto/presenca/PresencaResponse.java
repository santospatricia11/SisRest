package com.sisrest.dto.presenca;

import java.util.Date;

import com.sisrest.model.entities.ListaDiaria;

import lombok.Getter;
import lombok.Setter;

public class PresencaResponse {
	private Long id;
	private Date confirmadoEm;
	private Date compareceuEm;
	private ListaDiaria listaDiaria;
}
