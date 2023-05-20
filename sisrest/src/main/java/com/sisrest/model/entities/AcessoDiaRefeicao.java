package com.sisrest.model.entities;

import com.sisrest.model.enums.DiaDaSemana;
import com.sisrest.model.enums.TipoDeRefeicao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class AcessoDiaRefeicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private DiaDaSemana diaDaSemana;

    @NotNull
    private TipoDeRefeicao tipoDeRefeicao;

    @ManyToOne
    @JoinColumn(name = "pedido_de_acesso_id")
    private PedidoDeAcesso pedidoDeAcesso;
}