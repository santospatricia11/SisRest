package com.sisrest.model.entities;

import com.sisrest.model.enums.DiaDaSemana;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
}
