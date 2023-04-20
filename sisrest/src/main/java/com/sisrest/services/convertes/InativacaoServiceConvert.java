package com.sisrest.services.convertes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.dto.inativacao.InativacaoRequest;
import com.sisrest.dto.inativacao.InativacaoResponse;
import com.sisrest.model.entities.Inativacao;

@Service
public class InativacaoServiceConvert {

    @Autowired
    private ModelMapper mapper;

    public List<InativacaoResponse> inativacoesToResponses(List<Inativacao> inativacoes) {
        return inativacoes.stream().map(this::inativacaoToDTO).collect(Collectors.toList());
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
