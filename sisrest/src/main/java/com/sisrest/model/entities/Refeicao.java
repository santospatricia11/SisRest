package com.sisrest.model.entities;

import com.sisrest.model.enums.TipoDeRefeicao;
import com.sisrest.model.enums.TipoDeRestricaoAlimentar;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Refeicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private TipoDeRefeicao tipoDeRefeicao;

    @ElementCollection
    @CollectionTable(name = "refeicao_restricoes", joinColumns = @JoinColumn(name = "refeicao_id"))
    private List<TipoDeRestricaoAlimentar> restricoes;

}
