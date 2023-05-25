package com.sisrest.dto.restricaoAlimentar;

import com.sisrest.model.enums.TipoDeRestricaoAlimentar;

import java.io.File;

public class RestricaoAlimentarRequest {

    private String observacoes;

    private File anexo;

    private TipoDeRestricaoAlimentar tipoDeRestricaoAlimentar;

    private String justificativaAnalise;
}
