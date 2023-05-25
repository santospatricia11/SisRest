package com.sisrest.services.convertes;

import com.sisrest.dto.acessoDiaRefeicao.AcessoDiaRefeicaoRequest;
import com.sisrest.dto.acessoDiaRefeicao.AcessoDiaRefeicaoResponse;
import com.sisrest.model.entities.AcessoDiaRefeicao;
import com.sisrest.model.entities.PedidoDeAcesso;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcessoDiaRefeicaoServiceConvert {
    @Autowired
    private ModelMapper mapper;

    public List<AcessoDiaRefeicaoResponse> acessoDiaRefeicaoToResponses(List<AcessoDiaRefeicao> acessos) {
        return acessos.stream().map(this::acessoDiaRefeicaoToDTO).collect(Collectors.toList());
    }

    public List<AcessoDiaRefeicao> acessoRequestToAcessoDiaList(List<AcessoDiaRefeicaoRequest> acessosRequest, PedidoDeAcesso pedidoDeAcesso) {
        List<AcessoDiaRefeicao> acessos = acessosRequest.stream().map(this::dtoToAcessoDiaRefeicao).collect(Collectors.toList());
        acessos.stream().forEach(acessoDiaRefeicao -> acessoDiaRefeicao.setPedidoDeAcesso(pedidoDeAcesso));
        return acessos;
    }

    public AcessoDiaRefeicao dtoToAcessoDiaRefeicao(AcessoDiaRefeicaoRequest dto) {
        AcessoDiaRefeicao acessoDiaRefeicao = mapper.map(dto, AcessoDiaRefeicao.class);
        return acessoDiaRefeicao;
    }

    public AcessoDiaRefeicaoResponse acessoDiaRefeicaoToDTO(AcessoDiaRefeicao acesso) {
        AcessoDiaRefeicaoResponse response = mapper.map(acesso, AcessoDiaRefeicaoResponse.class);
        return response;
    }
}




