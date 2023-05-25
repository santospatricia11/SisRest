package com.sisrest.services.convertes;

import com.sisrest.dto.acessoDiaRefeicao.AcessoDiaRefeicaoRequest;
import com.sisrest.dto.acessoDiaRefeicao.AcessoDiaRefeicaoResponse;
import com.sisrest.model.entities.AcessoDiaRefeicaoM;
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

    public List<AcessoDiaRefeicaoResponse> acessoDiaRefeicaoToResponses(List<AcessoDiaRefeicaoM> acessos) {
        return acessos.stream().map(this::acessoDiaRefeicaoToDTO).collect(Collectors.toList());
    }

    public List<AcessoDiaRefeicaoM> acessoRequestToAcessoDiaList(List<AcessoDiaRefeicaoRequest> acessosRequest, PedidoDeAcesso pedidoDeAcesso) {
        List<AcessoDiaRefeicaoM> acessos = acessosRequest.stream().map(this::dtoToAcessoDiaRefeicao).collect(Collectors.toList());
        acessos.stream().forEach(acessoDiaRefeicaoM -> acessoDiaRefeicaoM.setPedidoDeAcesso(pedidoDeAcesso));
        return acessos;
    }

    public AcessoDiaRefeicaoM dtoToAcessoDiaRefeicao(AcessoDiaRefeicaoRequest dto) {
        AcessoDiaRefeicaoM acessoDiaRefeicaoM = mapper.map(dto, AcessoDiaRefeicaoM.class);
        return acessoDiaRefeicaoM;
    }

    public AcessoDiaRefeicaoResponse acessoDiaRefeicaoToDTO(AcessoDiaRefeicaoM acesso) {
        AcessoDiaRefeicaoResponse response = mapper.map(acesso, AcessoDiaRefeicaoResponse.class);
        return response;
    }
}




