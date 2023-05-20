package com.sisrest.model.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido_de_acesso")
public class PedidoDeAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_de_acesso_id")
    private Long id;

    private Date solicitadoEm;

    private Date analisadoEm;

    private String justificativaAnalise;

    private boolean isAprovado;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;

    @OneToMany(mappedBy = "pedido_de_acesso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RestricaoAlimentar> restricoesAlimentares = new ArrayList<>();

    @OneToMany(mappedBy = "pedido_de_acesso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AcessoDiaRefeicao> acessosDiaRefeicao = new ArrayList<>();

}
