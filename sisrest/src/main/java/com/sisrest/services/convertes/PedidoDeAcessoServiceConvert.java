package com.sisrest.services.convertes;

import com.sisrest.dto.pedidoDeAcesso.PedidoDeAcessoRequest;
import com.sisrest.dto.pedidoDeAcesso.PedidoDeAcessoResponse;
import com.sisrest.model.entities.PedidoDeAcesso;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoDeAcessoServiceConvert {
    @Autowired
    private ModelMapper mapper;

    public List<PedidoDeAcessoResponse> pedidoDeAcessoToResponses(List<PedidoDeAcesso> pedidos) {
        return pedidos.stream().map(this::pedidoDeAcessoToDTO).collect(Collectors.toList());
    }

    public PedidoDeAcesso dtoToPedidoDeAcesso(PedidoDeAcessoRequest dto) {
        PedidoDeAcesso pedidoDeAcesso = mapper.map(dto, PedidoDeAcesso.class);
        return pedidoDeAcesso;
    }

    public PedidoDeAcessoResponse pedidoDeAcessoToDTO(PedidoDeAcesso pedido) {
        PedidoDeAcessoResponse response = mapper.map(pedido, PedidoDeAcessoResponse.class);
        return response;
    }
}
