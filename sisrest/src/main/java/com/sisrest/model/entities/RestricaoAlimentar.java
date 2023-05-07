package com.sisrest.model.entities;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.sisrest.enums.TipoDeRefeicao;
import com.sisrest.enums.TipoDeRestricaoAlimentar;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
@AllArgsConstructor
@ToString
@Entity
@Table(name = "restricao")

public class RestricaoAlimentar {
	private String obcervacao;
	private TipoDeRestricaoAlimentar tipo;
	private boolean resultadoAnalise;
	private String justificativaAnalise;
	private Date analisadoEm;
}
