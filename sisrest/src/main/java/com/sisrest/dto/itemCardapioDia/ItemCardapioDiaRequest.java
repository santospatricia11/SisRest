package com.sisrest.dto.itemCardapioDia;

import com.sisrest.dto.cardapioSemanal.CardapioSemanalRequest;
import com.sisrest.dto.refeicao.RefeicaoResponse;
import com.sisrest.model.enums.DiaDaSemana;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemCardapioDiaRequest {

    private DiaDaSemana diaDaSemana;
    private CardapioSemanalRequest cardapioSemanal;
    private List<RefeicaoResponse> refeicoes;
}
