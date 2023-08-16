package com.sisrest.model.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Getter
@Setter
@Entity
public class Presenca {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotNull
	private Date confirmadoEm = null;
	@NotNull
	private Date compareceuEm = null;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "lista_diaria_id")
	private ListaDiaria listaDiaria;
}
