package com.sisrest.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter

public class AlunoRequest {

    @NotBlank
    @NotNull
    private String nome;

    @NotBlank
    @NotNull
    private long id;

    @NotBlank
    @NotNull
    private long matricula;

    private String email;

    @NotBlank
    @NotNull
    private long CPF;
}
