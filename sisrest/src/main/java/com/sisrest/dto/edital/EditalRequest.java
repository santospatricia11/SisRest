package com.sisrest.dto.edital;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class EditalRequest {

    @NotNull
    private int numero;


    @NotNull
    @Digits(integer = 4, fraction = 0, message = "O ano deve ter no máximo 4 dígitos")
    private int ano;

    @NotBlank(message = "Nome não informado!")
    @NotNull
    @Pattern(regexp = "^[A-Z]+(.)*", message = "Nome deve iniciar com letra maiúscula")
    private String nome;

    @NotBlank(message = "Link não informado!")
    @NotNull
    private String link;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "A data deve estar no formato dd-MM-yyyy")
    private String vigenteInicio;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "A data deve estar no formato dd-MM-yyyy")
    private String vigenteFinal;

}
