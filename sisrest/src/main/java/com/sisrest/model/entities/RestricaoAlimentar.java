package com.sisrest.model.entities;

import com.sisrest.model.enums.TipoDeRestricaoAlimentar;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.Date;

@Entity
@Table(name = "restricao_alimentar")
public class RestricaoAlimentar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restricao_alimentar_id")
    private Long id;

    @NotNull
    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "anexo")
    private File anexo;

    @Column(name = "tipo_de_restricao_alimentar")
    private TipoDeRestricaoAlimentar tipoDeRestricaoAlimentar;

    @Column
    private boolean resultadoAnalise;

    private String justificativaAnalise;

    private Date analisadeEm;

    @ManyToOne
    @JoinColumn(name = "pedido_de_acesso_id")
    private PedidoDeAcesso pedidoDeAcesso;
}