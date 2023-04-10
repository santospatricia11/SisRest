package com.sisrest.services.convertes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.sisrest.dto.edital.EditalRequest;
import com.sisrest.dto.edital.EditalResponse;
import com.sisrest.dto.inativacao.InativacaoRequest;
import com.sisrest.dto.inativacao.InativacaoResponse;
import com.sisrest.model.entities.Edital;
import com.sisrest.model.entities.Inativacao;

public class InativacaoServiceConvert {
	
	@Autowired
	private ModelMapper mapper;

	public List<InativacaoResponse> inativacaoToResponses(List<Inativacao> inativacoes) {
		return inativacoes.stream().map(this::inativacaoToDTO).toList();
	}

	public Inativacao dtoToInativacao(InativacaoRequest dto) {
		Inativacao inativacao = mapper.map(dto, Inativacao.class);
		return inativacao;
	}

	public InativacaoResponse inativacaoToDTO(Inativacao inativacao) {
		InativacaoResponse response = mapper.map(inativacao, InativacaoResponse.class);
		return response;
	}

}
