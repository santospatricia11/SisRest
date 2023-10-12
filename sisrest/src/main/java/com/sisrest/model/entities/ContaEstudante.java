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
public class ContaEstudante extends Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    @NotNull
    private long matricula;

    @NotNull
    @Column
    private String curso;


}