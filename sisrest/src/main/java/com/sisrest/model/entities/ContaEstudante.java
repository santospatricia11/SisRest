package com.sisrest.model.entities;

import lombok.*;

import javax.persistence.*;
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
@DiscriminatorValue(value = "E")
public class ContaEstudante extends Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column
    private long id;

    @Column
    @NotNull
    private long matricula;
    
    @NotNull
    @Column
    private String curso;
}