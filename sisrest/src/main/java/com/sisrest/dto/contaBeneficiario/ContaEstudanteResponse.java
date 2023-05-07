package com.sisrest.dto.contaBeneficiario;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ContaEstudanteResponse {

	   private long id;

	    private String nome;

	    private String email;

	    private String campus;

	    private String curso;

	    private long matricula;
}
