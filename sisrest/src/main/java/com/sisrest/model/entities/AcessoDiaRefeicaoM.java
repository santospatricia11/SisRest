package com.sisrest.model.entities;

import com.sisrest.model.enums.DiaDaSemana;
import com.sisrest.model.enums.TipoDeRefeicao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class AcessoDiaRefeicaoM implements Serializable {

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