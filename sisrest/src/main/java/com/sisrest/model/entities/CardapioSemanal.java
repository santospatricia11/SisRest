package com.sisrest.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class CardapioSemanal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private short sequenciaSemanal;

    private boolean isAtual;

    @ManyToOne
    @JoinColumn(name = "edital_id")
    private Edital edital;

    public void isAtualFalse() {
        this.isAtual = false;
    }

    public void isAtualTrue() {
        this.isAtual = true;
    }
}
