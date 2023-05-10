package com.sisrest.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeneficiarioRaw {
    private String nome;
    private String matricula;
    private String cpf;
    private String curso;
    private String programa;
    private String modalidade;
    private String situacao;
    private String classificacao;
    private String pontuacao;
    private String rendaBruta;
    private String qtdePessoas;
    private String percapta;
    private String cota;
    private String nascimento;
    private String valor;
}

