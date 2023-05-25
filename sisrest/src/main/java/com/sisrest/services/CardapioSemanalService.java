package com.sisrest.services;

import com.sisrest.dto.cardapioSemanal.CardapioSemanalRequest;
import com.sisrest.dto.cardapioSemanal.CardapioSemanalResponse;
import com.sisrest.model.entities.CardapioSemanal;
import com.sisrest.repositories.CardapioSemanalRepository;
import com.sisrest.services.convertes.CardapioSemanalServiceConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardapioSemanalService {

    @Autowired
    private CardapioSemanalRepository cardapioSemanalRepository;

    @Autowired
    private CardapioSemanalServiceConvert cardapioSemanalServiceConvert;

    public CardapioSemanalResponse saveCardapioSemanal(CardapioSemanalRequest cardapioSemanalDto) {
        CardapioSemanal cardapioSemanal = cardapioSemanalServiceConvert.dtoToCardapioSemanal(cardapioSemanalDto);
        cardapioSemanalRepository.save(cardapioSemanal);
        CardapioSemanalResponse responseDto = cardapioSemanalServiceConvert.cardapioSemanalToDTO(cardapioSemanal);
        return responseDto;
    }

    public CardapioSemanalResponse deleteCardapioSemanalById(long id) {
        Optional<CardapioSemanal> cardapioSemanal = cardapioSemanalRepository.findById(id);
        cardapioSemanalRepository.deleteById(id);
        CardapioSemanalResponse responseDto = cardapioSemanalServiceConvert.cardapioSemanalToDTO(cardapioSemanal.get());
        return responseDto;
    }

    public CardapioSemanalResponse findCardapioSemanalById(long id) {
        Optional<CardapioSemanal> cardapioSemanal = cardapioSemanalRepository.findById(id);
        CardapioSemanalResponse responseDto = cardapioSemanalServiceConvert.cardapioSemanalToDTO(cardapioSemanal.get());
        return responseDto;
    }

    public List<CardapioSemanalResponse> findAllCardapioSemanal() {
        return cardapioSemanalServiceConvert.cardapiosToResponses(cardapioSemanalRepository.findAll());
    }

    public CardapioSemanalResponse updateCardapioSemanal(long id, CardapioSemanalRequest cardapioSemanalDto) {
        Optional<CardapioSemanal> cardapioSemanal = cardapioSemanalRepository.findById(id);
        CardapioSemanal original = cardapioSemanal.get();
        CardapioSemanal atualizar = cardapioSemanalServiceConvert.dtoToCardapioSemanal(cardapioSemanalDto);
        boolean verificado = cardapioSemanalRepository.existsById(cardapioSemanal.get().getId());

        if (verificado)
            atualizar.setId(cardapioSemanal.get().getId());

        if (atualizar.getSequenciaSemanal() == 0) {
            atualizar.setSequenciaSemanal(original.getSequenciaSemanal());
        }
        CardapioSemanalResponse responseDto = cardapioSemanalServiceConvert.cardapioSemanalToDTO(cardapioSemanalRepository.save(atualizar));
        return responseDto;
    }

    public CardapioSemanalResponse isAtualTrue(Long id) {
        Optional<CardapioSemanal> cardapioSemanal = cardapioSemanalRepository.findById(id);
        CardapioSemanal cardapio = cardapioSemanal.get();
        cardapio.isAtualTrue();
        CardapioSemanalResponse responseDto = cardapioSemanalServiceConvert.cardapioSemanalToDTO(cardapioSemanalRepository.save(cardapio));
        return responseDto;
    }
}
