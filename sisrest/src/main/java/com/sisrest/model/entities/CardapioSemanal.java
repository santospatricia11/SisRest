package com.sisrest.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class CardapioSemanal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private short sequenciaSemanal;

    private boolean isAtual;

    public void isAtualFalse() {
        this.isAtual = false;
    }

    public void isAtualTrue() {
        this.isAtual = true;
    }
}
