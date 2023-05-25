package com.sisrest.dto.pedidoDeAcesso;

import com.sisrest.dto.acessoDiaRefeicao.AcessoDiaRefeicaoRequest;
import com.sisrest.dto.restricaoAlimentar.RestricaoAlimentarRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PedidoDeAcessoRequest {

    private Date solicitadoEm;

    private String justificativaAnalise;

    private long beneficiario;

    private List<AcessoDiaRefeicaoRequest> diasAcessoRefeicao;

    private List<RestricaoAlimentarRequest> restricaoAlimentar;
}
