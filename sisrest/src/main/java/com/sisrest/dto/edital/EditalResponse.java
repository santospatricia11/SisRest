package com.sisrest.dto.edital;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class EditalResponse {

    private long id;

    private int numero;

    private int ano;

    private String nome;

    private String link;

    private Date vigenteInicio;

    private Date vigenteFinal;
}
