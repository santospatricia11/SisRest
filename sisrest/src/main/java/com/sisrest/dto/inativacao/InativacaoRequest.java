package com.sisrest.dto.inativacao;

import com.sisrest.model.entities.Beneficiario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class InativacaoRequest {


    @NotBlank
    @NotNull
    private Date inicio;

    @NotBlank
    @NotNull
    private Date termino;

    @NotBlank
    @NotNull
    private String motivo;

    @NotBlank
    @NotNull
    private Beneficiario beneficiario;


}
