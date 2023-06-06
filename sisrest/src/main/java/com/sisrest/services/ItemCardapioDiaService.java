package com.sisrest.services;

import com.sisrest.dto.itemCardapioDia.ItemCardapioDiaRequest;
import com.sisrest.dto.itemCardapioDia.ItemCardapioDiaResponse;
import com.sisrest.model.entities.ItemCardapioDia;
import com.sisrest.repositories.ItemCardapioDiaRepository;
import com.sisrest.services.convertes.ItemCardapioDiaServiceConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemCardapioDiaService {
    @Autowired
    private ItemCardapioDiaRepository itemCardapioDiaRepository;
    @Autowired
    private ItemCardapioDiaServiceConvert itemCardapioDiaServiceConvert;

    public ItemCardapioDiaResponse saveItemCardapioDia(ItemCardapioDiaRequest itemCardapioDiaDto) {
        ItemCardapioDia item = itemCardapioDiaServiceConvert.dtoToItemCardapioDia(itemCardapioDiaDto);
        itemCardapioDiaRepository.save(item);
        ItemCardapioDiaResponse responseDto = itemCardapioDiaServiceConvert.itemCardapioDiaToDTO(item);
        return responseDto;
    }

    public ItemCardapioDiaResponse deleteItemCardapioDiaById(long id) {
        Optional<ItemCardapioDia> item = itemCardapioDiaRepository.findById(id);
        itemCardapioDiaRepository.deleteById(id);
        ItemCardapioDiaResponse responseDto = itemCardapioDiaServiceConvert.itemCardapioDiaToDTO(item.get());
        return responseDto;
    }

    public ItemCardapioDiaResponse findItemCardapioDiaById(long id) {
        Optional<ItemCardapioDia> item = itemCardapioDiaRepository.findById(id);
        ItemCardapioDiaResponse responseDto = itemCardapioDiaServiceConvert.itemCardapioDiaToDTO(item.get());
        return responseDto;
    }

    public List<ItemCardapioDiaResponse> findAllItemCardapioDia() {
        return itemCardapioDiaServiceConvert.itensCardapioDiaToResponses(itemCardapioDiaRepository.findAll());
    }

    public ItemCardapioDiaResponse updateItemCardapioDia(long id, ItemCardapioDiaRequest itemCardapioDiaDto) {
        Optional<ItemCardapioDia> item = itemCardapioDiaRepository.findById(id);
        ItemCardapioDia original = item.get();
        ItemCardapioDia atualizar = itemCardapioDiaServiceConvert.dtoToItemCardapioDia(itemCardapioDiaDto);
        boolean verificado = itemCardapioDiaRepository.existsById(item.get().getId());

        if (verificado)
            atualizar.setId(item.get().getId());

//        if (atualizar.getDescricao() == null) {
//            atualizar.setDescricao(original.getDescricao());
//        } else if (atualizar.getTipoDeRefeicao() == null) {
//            atualizar.setTipoDeRefeicao(original.getTipoDeRefeicao());
//        } else if (atualizar.getRestricoes() == null) {
//            atualizar.setRestricoes(original.getRestricoes());
//        }
        ItemCardapioDiaResponse responseDto = itemCardapioDiaServiceConvert.itemCardapioDiaToDTO(itemCardapioDiaRepository.save(atualizar));
        return responseDto;
    }
}
