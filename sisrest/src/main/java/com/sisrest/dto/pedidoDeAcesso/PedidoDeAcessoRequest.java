package com.sisrest.dto.pedidoDeAcesso;

import com.sisrest.dto.acessoDiaRefeicao.AcessoDiaRefeicaoRequest;
import com.sisrest.model.entities.AcessoDiaRefeicao;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PedidoDeAcessoRequest {

    private Date solicitadoEm;

    private Date analisadoEm;

    private String justificativaAnalise;

    private boolean isAprovado;

    private List<AcessoDiaRefeicaoRequest> diasAcessoRefeicao;

}
