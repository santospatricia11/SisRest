package com.sisrest.dto.acessoDiaRefeicao;

import com.sisrest.model.enums.DiaDaSemana;
import com.sisrest.model.enums.TipoDeRefeicao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcessoDiaRefeicaoResponse {

    private Long id;

    private DiaDaSemana diaDaSemana;

    private TipoDeRefeicao tipoDeRefeicao;
}
