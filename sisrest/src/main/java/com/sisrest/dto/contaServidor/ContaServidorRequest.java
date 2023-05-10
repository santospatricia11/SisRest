package com.sisrest.dto.contaServidor;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class ContaServidorRequest {

    private String nome;
    private String email;
    private long matriculaSIAPE;
    private boolean isAdmin;
    private String campus;


}
