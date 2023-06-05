package com.sisrest.dto.cardapioSemanal;

import com.sisrest.dto.edital.EditalResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardapioSemanalResponse {

    private Long id;

    private short sequenciaSemanal;

    private boolean isAtual;

    private EditalResponse edital;
}
