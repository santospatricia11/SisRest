package com.sisrest.dto.listaDiaria;

import com.sisrest.dto.refeicao.RefeicaoResponse;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class ListaDiariaResponse {
    private long id;
    private Date data;
    private RefeicaoResponse refeicao;
}
