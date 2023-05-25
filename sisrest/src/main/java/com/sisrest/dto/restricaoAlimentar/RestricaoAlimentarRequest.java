package com.sisrest.dto.restricaoAlimentar;

import com.sisrest.model.enums.TipoDeRestricaoAlimentar;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class RestricaoAlimentarRequest {

    private String observacoes;

    private File anexo;

    private TipoDeRestricaoAlimentar tipoDeRestricaoAlimentar;
}
