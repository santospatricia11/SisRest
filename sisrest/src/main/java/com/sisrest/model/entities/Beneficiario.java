package com.sisrest.model.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
@AllArgsConstructor
@ToString
@Entity
@Table(name = "beneficiario")
public class Beneficiario implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "beneficiario_id")
    private long id;

    @Column
    @NotNull
    private boolean ativo;

    @NotNull
    @Column
    private long CPF;

    @NotNull
    @Column
    private String programa;

    @NotNull
    @Column
    private String situacao;

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoDeAcesso> pedidosDeAcesso = new ArrayList<>();

    @NotNull
    @ManyToOne
    @JoinColumn(name = "edital_id")
    private Edital edital;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "contaEstudante_id")
    private ContaEstudante contaEstudante;
}
