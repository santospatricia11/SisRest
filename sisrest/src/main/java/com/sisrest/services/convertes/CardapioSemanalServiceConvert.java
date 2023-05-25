package com.sisrest.services.convertes;

import com.sisrest.dto.cardapioSemanal.CardapioSemanalRequest;
import com.sisrest.dto.cardapioSemanal.CardapioSemanalResponse;
import com.sisrest.model.entities.CardapioSemanal;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardapioSemanalServiceConvert {
    @Autowired
    private ModelMapper mapper;

    public List<CardapioSemanalResponse> cardapiosToResponses(List<CardapioSemanal> cardapios) {
        return cardapios.stream().map(this::cardapioSemanalToDTO).collect(Collectors.toList());
    }

    public CardapioSemanal dtoToCardapioSemanal(CardapioSemanalRequest dto) {
        CardapioSemanal cardapioSemanal = mapper.map(dto, CardapioSemanal.class);
        return cardapioSemanal;
    }

    public CardapioSemanalResponse cardapioSemanalToDTO(CardapioSemanal cardapio) {
        CardapioSemanalResponse response = mapper.map(cardapio, CardapioSemanalResponse.class);
        return response;
    }
}
