package com.sisrest.model.entities;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import com.sisrest.enums.DiaDaSemana;
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
public class AcessoDiaRefeicao {
	private DiaDaSemana diaSemana;
	private TipoDeRefeicao tipoRefeicao;

}
