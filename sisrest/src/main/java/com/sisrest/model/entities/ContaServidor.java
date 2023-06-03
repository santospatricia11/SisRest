package com.sisrest.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
@AllArgsConstructor
@ToString
@Entity
public class ContaServidor extends Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column
    private long matriculaSIAPE;

    @NotNull
    @Column
    private boolean isAdmin;

    public void isAdminTrue() {
        this.isAdmin = true;
    }

    public void isAdminFalse() {
        this.isAdmin = false;
    }
}
