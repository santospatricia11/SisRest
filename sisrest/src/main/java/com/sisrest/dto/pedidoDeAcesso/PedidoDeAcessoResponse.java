package com.sisrest.dto.pedidoDeAcesso;

import com.sisrest.dto.acessoDiaRefeicao.AcessoDiaRefeicaoResponse;
import com.sisrest.dto.beneficiario.BeneficiarioResponse;
import com.sisrest.dto.restricaoAlimentar.RestricaoAlimentarResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PedidoDeAcessoResponse {

    private Long id;

    private Date solicitadoEm;

    private Date analisadoEm;

    private String justificativaAnalise;

    private boolean isAprovado;

    private BeneficiarioResponse beneficiario;

    private List<RestricaoAlimentarResponse> restricoesAlimentares;

    private List<AcessoDiaRefeicaoResponse> acessosDiaRefeicao;
}
