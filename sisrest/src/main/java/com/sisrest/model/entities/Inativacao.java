package com.sisrest.model.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
