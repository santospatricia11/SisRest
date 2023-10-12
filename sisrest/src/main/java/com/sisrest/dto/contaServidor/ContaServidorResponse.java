package com.sisrest.dto.contaServidor;

import com.sisrest.model.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaServidorResponse {

    private long id;
    private String nome;
    private String email;
    private String campus;
    private long matriculaSIAPE;
    private boolean isAdmin;
    private Role role;
}
