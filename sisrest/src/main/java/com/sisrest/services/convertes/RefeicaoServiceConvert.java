package com.sisrest.services.convertes;

import com.sisrest.dto.refeicao.RefeicaoRequest;
import com.sisrest.dto.refeicao.RefeicaoResponse;
import com.sisrest.model.entities.Refeicao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RefeicaoServiceConvert {
    @Autowired
    private ModelMapper mapper;

    public List<RefeicaoResponse> refeicoesToResponses(List<Refeicao> refeicoes) {
        return refeicoes.stream().map(this::refeicaoToDTO).collect(Collectors.toList());
    }

    public Refeicao dtoToRefeicao(RefeicaoRequest dto) {
        Refeicao refeicao = mapper.map(dto, Refeicao.class);
        return refeicao;
    }

    public RefeicaoResponse refeicaoToDTO(Refeicao refeicao) {
        RefeicaoResponse response = mapper.map(refeicao, RefeicaoResponse.class);
        return response;
    }
}
