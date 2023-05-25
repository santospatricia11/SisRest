package com.sisrest.dto.restricaoAlimentar;

import com.sisrest.model.enums.TipoDeRestricaoAlimentar;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.Date;

@Getter
@Setter
public class RestricaoAlimentarResponse {

    private Long id;

    private String observacoes;

    private File anexo;

    private TipoDeRestricaoAlimentar tipoDeRestricaoAlimentar;

    private boolean resultadoAnalise;

    private String justificativaAnalise;

    private Date analisadeEm;
}
