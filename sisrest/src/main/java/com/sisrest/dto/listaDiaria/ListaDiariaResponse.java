package com.sisrest.dto.listaDiaria;

import java.util.Date;
import java.util.List;

import com.sisrest.model.entities.Refeicao;

public class ListaDiariaResponse {
	private Long id;

	private Date data;

	private List<Refeicao> refeicoes;

}
