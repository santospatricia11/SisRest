package com.sisrest.model.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "edital")
public class Edital implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edital_id")
    private long id;

    @Column(name = "edital_ano")
    private int ano;

    @Column(name = "edital_numero")
    private int numero;

    @Column(name = "edital_nome")
    @Pattern(regexp = "^[A-Z]+(.)*", message = "Campo nome deve iniciar com letra maiúscula")
    private String nome;

    @Column(name = "edital_link")
    private String link;

    @Column(name = "edital_vigente_inicio")
    private Date vigenteInicio;

    @Column(name = "edital_vigente_final")
    private Date vigenteFinal;

}
