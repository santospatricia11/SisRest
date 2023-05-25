package com.sisrest.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class PedidoDeAcesso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date solicitadoEm;

    private Date analisadoEm;

    private String justificativaAnalise;

    private boolean isAprovado;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;

    @OneToMany(mappedBy = "pedidoDeAcesso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RestricaoAlimentar> restricoesAlimentares = new ArrayList<>();

    @OneToMany(mappedBy = "pedidoDeAcesso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AcessoDiaRefeicao> acessosDiaRefeicao = new ArrayList<>();

    public void isAprovadoTrue() {
        this.isAprovado = true;
    }

    public void isAprovadoFalse() {
        this.isAprovado = false;
    }
}
