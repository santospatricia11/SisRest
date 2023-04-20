package com.sisrest.dto.contaBeneficiario;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ContaEstudanteRequest {

    private String nome;

    private String matricula;

    private String email;

    private String campus;

    private String curso;

}
