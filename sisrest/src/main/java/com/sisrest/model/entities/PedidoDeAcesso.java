package com.sisrest.model.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class PedidoDeAcesso {
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

}
