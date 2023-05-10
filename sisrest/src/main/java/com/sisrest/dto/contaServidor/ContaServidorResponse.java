package com.sisrest.dto.contaServidor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaServidorResponse {

    private long id;
    private String nome;
    private String email;
    private long matriculaSIAPE;
    private boolean isAdmin;
    private String campus;

}
