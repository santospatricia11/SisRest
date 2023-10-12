package com.sisrest.dto.cardapioSemanal;

import com.sisrest.dto.edital.EditalResponse;
import com.sisrest.dto.itemCardapioDia.ItemCardapioDiaResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CardapioSemanalResponse {

    private Long id;
    private short sequenciaSemanal;
    private boolean isAtual;
    private EditalResponse edital;
    private List<ItemCardapioDiaResponse> itensCardapioDia;
}
