package com.sisrest.dto.itemCardapioDia;

import com.sisrest.model.enums.DiaDaSemana;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemCardapioDiaRequest {

    private DiaDaSemana diaDaSemana;
    private Long cardapioSemanal;
    private List<Long> refeicoes;
}
