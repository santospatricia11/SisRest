package com.sisrest.model.entities;

import com.sisrest.model.enums.TipoDeRestricaoAlimentar;

import java.io.File;
import java.util.Date;

public class RestricaoAlimentar {
    private String observacoes;
    private File anexo;
    private TipoDeRestricaoAlimentar tipoDeRestricaoAlimentar;
    private boolean resultadoAnalise;
    private String justificativaAnalise;
    private Date analisadeEm;
}
