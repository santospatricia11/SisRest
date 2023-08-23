package com.sisrest.dto.presenca;

import com.sisrest.dto.beneficiario.BeneficiarioResponse;
import com.sisrest.dto.listaDiaria.ListaDiariaResponse;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class PresencaResponse {

    private Long id;
    private Date confirmadoEm;
    private Date compareceuEm;
    private BeneficiarioResponse beneficiario;
    private ListaDiariaResponse listaDiaria;
}
