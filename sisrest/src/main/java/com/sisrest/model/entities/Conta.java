package com.sisrest.model.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.sisrest.dto.contaServidor.ContaServidorRequest;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("C")
public abstract class Conta {

    @NotNull
    @NotEmpty
    @NotBlank(message = "Campo não informado")
    @Column
    @Pattern(regexp = "^[A-Z]+(.)*", message = "Campo nome deve iniciar com letra maiúscula")
    private String nome;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private long id;

    @NotNull
    @Email(message = "Campo inválido")
    @Column
    private String email;

    @NotNull
    @Column
    private String campus;

	  @Column
	  @Size(min = 8, max = 30)
	  @Pattern(regexp = "^[^\\s]+$", message = "Campo inválido")
	  private String senha;
}
