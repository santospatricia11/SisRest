package com.sisrest.dto.restricaoAlimentar;

import com.sisrest.model.enums.TipoDeRestricaoAlimentar;

import java.io.File;
import java.util.Date;

public class RestricaoAlimentarResponse {

    private Long id;
    
    private String observacoes;

    private File anexo;

    private TipoDeRestricaoAlimentar tipoDeRestricaoAlimentar;

    private boolean resultadoAnalise;

    private String justificativaAnalise;

    private Date analisadeEm;
}
