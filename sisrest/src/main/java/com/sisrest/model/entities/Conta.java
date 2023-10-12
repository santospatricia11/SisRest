package com.sisrest.model.entities;

import lombok.*;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.security.core.userdetails.UserDetails;

import com.sisrest.model.enums.Role;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Campo não informado")
    @Column
    @Pattern(regexp = "^[A-Z]+(.)*", message = "Campo nome deve iniciar com letra maiúscula")
    private String nome;

    @NotNull
    @Email(message = "Campo inválido")
    @Column
    private String email;

    @NotNull
    @Column
    private String campus;
    
    @NotNull
    @Column
    private Role role;
    
	
}