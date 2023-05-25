package com.sisrest.dto.refeicao;

import com.sisrest.model.enums.TipoDeRefeicao;
import com.sisrest.model.enums.TipoDeRestricaoAlimentar;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RefeicaoRequest {

    private String descricao;

    private TipoDeRefeicao tipoDeRefeicao;

    private List<TipoDeRestricaoAlimentar> restricoes;

}
