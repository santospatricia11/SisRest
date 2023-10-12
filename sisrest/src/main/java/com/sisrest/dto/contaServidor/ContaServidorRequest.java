package com.sisrest.dto.contaServidor;

import com.sisrest.model.enums.Role;
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
    private String campus;
    private long matriculaSIAPE;
    private boolean isAdmin;
    private Role role;
}
