package com.sisrest.dto.inativacao;

import com.sisrest.model.entities.Beneficiario;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InativacaoResponse {

    private Date inicio;

    private Date termino;

    private String motivo;

    private Beneficiario beneficiario;

}
