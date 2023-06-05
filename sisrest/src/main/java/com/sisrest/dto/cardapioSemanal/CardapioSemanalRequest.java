package com.sisrest.dto.cardapioSemanal;

import com.sisrest.dto.itemCardapioDia.ItemCardapioDiaRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CardapioSemanalRequest {

    private short sequenciaSemanal;
    private long edital;
    private List<ItemCardapioDiaRequest> itensCardapioDia;



}
