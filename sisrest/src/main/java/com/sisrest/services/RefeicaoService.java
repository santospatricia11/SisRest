package com.sisrest.services;

import com.sisrest.dto.refeicao.RefeicaoRequest;
import com.sisrest.dto.refeicao.RefeicaoResponse;
import com.sisrest.model.entities.Refeicao;
import com.sisrest.repositories.RefeicaoRepository;
import com.sisrest.services.convertes.RefeicaoServiceConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefeicaoService {
    @Autowired
    private RefeicaoRepository refeicaoRepository;

    @Autowired
    private RefeicaoServiceConvert refeicaoServiceConvert;

    public RefeicaoResponse saveRefeicao(RefeicaoRequest refeicaoDto) {
        Refeicao refeicao = refeicaoServiceConvert.dtoToRefeicao(refeicaoDto);
        refeicaoRepository.save(refeicao);
        RefeicaoResponse responseDto = refeicaoServiceConvert.refeicaoToDTO(refeicao);
        return responseDto;
    }

    public RefeicaoResponse deleteRefeicaoById(long id) {
        Optional<Refeicao> refeicao = refeicaoRepository.findById(id);
        refeicaoRepository.deleteById(id);
        RefeicaoResponse responseDto = refeicaoServiceConvert.refeicaoToDTO(refeicao.get());
        return responseDto;
    }

    public RefeicaoResponse findRefeicaoById(long id) {
        Optional<Refeicao> refeicao = refeicaoRepository.findById(id);
        RefeicaoResponse responseDto = refeicaoServiceConvert.refeicaoToDTO(refeicao.get());
        return responseDto;
    }

    public List<RefeicaoResponse> findAllRefeicoes() {
        return refeicaoServiceConvert.refeicoesToResponses(refeicaoRepository.findAll());
    }

    public RefeicaoResponse updateRefeicao(long id, RefeicaoRequest refeicaoDto) {
        Optional<Refeicao> refeicao = refeicaoRepository.findById(id);
        Refeicao original = refeicao.get();
        Refeicao atualizar = refeicaoServiceConvert.dtoToRefeicao(refeicaoDto);
        boolean verificado = refeicaoRepository.existsById(refeicao.get().getId());

        if (verificado)
            atualizar.setId(refeicao.get().getId());

        if (atualizar.getDescricao() == null) {
            atualizar.setDescricao(original.getDescricao());
        } else if (atualizar.getTipoDeRefeicao() == null) {
            atualizar.setTipoDeRefeicao(original.getTipoDeRefeicao());
        } else if (atualizar.getRestricoes() == null) {
            atualizar.setRestricoes(original.getRestricoes());
        }
        RefeicaoResponse responseDto = refeicaoServiceConvert.refeicaoToDTO(refeicaoRepository.save(atualizar));
        return responseDto;
    }
}
