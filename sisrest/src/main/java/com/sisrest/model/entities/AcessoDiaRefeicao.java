package com.sisrest.model.entities;

import com.sisrest.model.enums.DiaDaSemana;
import com.sisrest.model.enums.TipoDeRefeicao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "acesso_dia_refeicao")
public class AcessoDiaRefeicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acesso_dia_refeicao_id")
    private Long id;

    @NotNull
    @Column(name = "dia_da_semana")
    private DiaDaSemana diaDaSemana;

    @NotNull
    @Column(name = "tipo_de_refeicao")
    private TipoDeRefeicao tipoDeRefeicao;

    @ManyToOne
    @JoinColumn(name = "pedido_de_acesso_id")
    private PedidoDeAcesso pedidoDeAcesso;
}