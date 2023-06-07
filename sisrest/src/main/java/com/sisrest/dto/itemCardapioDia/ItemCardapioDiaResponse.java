package com.sisrest.dto.itemCardapioDia;

import com.sisrest.dto.cardapioSemanal.CardapioSemanalResponse;
import com.sisrest.dto.refeicao.RefeicaoResponse;
import com.sisrest.model.enums.DiaDaSemana;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemCardapioDiaResponse {

    private Long id;
    private DiaDaSemana diaDaSemana;
    private boolean isAtual;
    private CardapioSemanalResponse cardapioSemanal;
    private List<RefeicaoResponse> refeicoes;
}
