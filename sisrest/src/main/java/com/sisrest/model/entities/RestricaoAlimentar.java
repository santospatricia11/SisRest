package com.sisrest.model.entities;

import com.sisrest.model.enums.TipoDeRestricaoAlimentar;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.Date;

@Getter
@Setter
@Entity
public class RestricaoAlimentar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String observacoes;

    private File anexo;

    private TipoDeRestricaoAlimentar tipoDeRestricaoAlimentar;

    private boolean resultadoAnalise;

    private String justificativaAnalise;

    private Date analisadeEm;

    @ManyToOne
    @JoinColumn(name = "pedido_de_acesso_id")
    private PedidoDeAcesso pedidoDeAcesso;

    public void resultadoAnaliseFalse() {
        this.resultadoAnalise = false;
    }

    public void resultadoAnaliseTrue() {
        this.resultadoAnalise = true;
    }
}