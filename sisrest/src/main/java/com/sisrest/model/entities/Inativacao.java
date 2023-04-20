package com.sisrest.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
@AllArgsConstructor
@ToString
@Entity
@Table(name = "inativacao")
public class Inativacao {

    @Id
    @Column(name = "inativacao_id")
    private long id;

    @NotNull
    @Column(name = "inativacao_data_inicio")
    private Date inicio;

    @NotNull
    @Column(name = "inativacao_data_termino")
    private Date termino;

    @NotNull
    @Column(name = "inativacao_motivo")
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;

}
