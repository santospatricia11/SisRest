package com.sisrest.dto.cardapioSemanal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardapioSemanalResponse {

    private Long id;

    private short sequenciaSemanal;

    private boolean isAtual;
}
