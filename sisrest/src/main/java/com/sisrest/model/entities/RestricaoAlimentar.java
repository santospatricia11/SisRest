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
    private Long id;

    @NotNull
    private String observacoes;

    private File anexo;

    private TipoDeRestricaoAlimentar tipoDeRestricaoAlimentar;

    private boolean resultadoAnalise;

    private String justificativaAnalise;

    private Date analisadeEm;

    @ManyToOne
    @JoinColumn(name = "pedido_de_acesso_id")
    private PedidoDeAcesso pedidoDeAcesso;
}