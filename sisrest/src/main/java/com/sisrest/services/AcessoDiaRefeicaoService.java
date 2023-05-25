package com.sisrest.services;

import com.sisrest.dto.acessoDiaRefeicao.AcessoDiaRefeicaoRequest;
import com.sisrest.dto.acessoDiaRefeicao.AcessoDiaRefeicaoResponse;
import com.sisrest.model.entities.AcessoDiaRefeicaoM;
import com.sisrest.repositories.AcessoDiaRefeicaoRepository;
import com.sisrest.services.convertes.AcessoDiaRefeicaoServiceConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcessoDiaRefeicaoService {

    @Autowired
    private AcessoDiaRefeicaoRepository acessoDiaRefeicaoRepository;

    @Autowired
    private AcessoDiaRefeicaoServiceConvert acessoDiaRefeicaoServiceConvert;


    public AcessoDiaRefeicaoResponse save(AcessoDiaRefeicaoRequest acessoDiaRefeicaoDto) {
        AcessoDiaRefeicaoM acessoDiaRefeicaoM = acessoDiaRefeicaoServiceConvert.dtoToAcessoDiaRefeicao(acessoDiaRefeicaoDto);
        acessoDiaRefeicaoRepository.save(acessoDiaRefeicaoM);
        AcessoDiaRefeicaoResponse responseDto = acessoDiaRefeicaoServiceConvert.acessoDiaRefeicaoToDTO(acessoDiaRefeicaoM);
        return responseDto;
    }

    public AcessoDiaRefeicaoResponse deleteById(long id) {
        Optional<AcessoDiaRefeicaoM> acessoDiaRefeicao = acessoDiaRefeicaoRepository.findById(id);
        acessoDiaRefeicaoRepository.deleteById(id);
        AcessoDiaRefeicaoResponse responseDto = acessoDiaRefeicaoServiceConvert.acessoDiaRefeicaoToDTO(acessoDiaRefeicao.get());
        return responseDto;
    }

    public AcessoDiaRefeicaoResponse findById(long id) {
        Optional<AcessoDiaRefeicaoM> acessoDiaRefeicao = acessoDiaRefeicaoRepository.findById(id);
        AcessoDiaRefeicaoResponse responseDto = acessoDiaRefeicaoServiceConvert.acessoDiaRefeicaoToDTO(acessoDiaRefeicao.get());
        return responseDto;
    }

    public List<AcessoDiaRefeicaoResponse> findAll() {
        return acessoDiaRefeicaoServiceConvert.acessoDiaRefeicaoToResponses(acessoDiaRefeicaoRepository.findAll());
    }

    public AcessoDiaRefeicaoResponse update(long id, AcessoDiaRefeicaoRequest acessoDiaRefeicaoDto) {
        Optional<AcessoDiaRefeicaoM> acessoDiaRefeicao = acessoDiaRefeicaoRepository.findById(id);
        AcessoDiaRefeicaoM original = acessoDiaRefeicao.get();
        AcessoDiaRefeicaoM atualizar = acessoDiaRefeicaoServiceConvert.dtoToAcessoDiaRefeicao(acessoDiaRefeicaoDto);
        boolean verificado = acessoDiaRefeicaoRepository.existsById(acessoDiaRefeicao.get().getId());

        if (verificado) atualizar.setId(acessoDiaRefeicao.get().getId());

        if (atualizar.getDiaDaSemana() == null) {
            atualizar.setDiaDaSemana(original.getDiaDaSemana());
        } else if (atualizar.getTipoDeRefeicao() == null) {
            atualizar.setTipoDeRefeicao(original.getTipoDeRefeicao());
        } else if (atualizar.getPedidoDeAcesso() == null) {
            atualizar.setPedidoDeAcesso(original.getPedidoDeAcesso());
        }

        AcessoDiaRefeicaoResponse responseDto = acessoDiaRefeicaoServiceConvert.acessoDiaRefeicaoToDTO(acessoDiaRefeicaoRepository.save(atualizar));
        return responseDto;
    }
}
