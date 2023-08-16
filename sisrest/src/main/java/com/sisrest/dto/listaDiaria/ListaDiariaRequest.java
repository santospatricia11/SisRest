package com.sisrest.dto.listaDiaria;

import java.util.Date;
import java.util.List;

import com.sisrest.model.entities.Refeicao;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ListaDiariaRequest {
	private Date data;
	
	private List<Refeicao> refeicoes;
}
