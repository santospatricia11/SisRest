package com.sisrest.model.entities;

import com.sisrest.model.enums.DiaDaSemana;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
public class ItemCardapioDia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DiaDaSemana diaDaSemana;

    private boolean isAtual;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cardapio_semanal_id")
    private CardapioSemanal cardapioSemanal;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "item_cardapio_dia_refeicao",
            joinColumns = @JoinColumn(name = "item_cardapio_dia_id"),
            inverseJoinColumns = @JoinColumn(name = "refeicao_id"))
    private List<Refeicao> refeicoes;
}
