package com.sisrest.services.convertes;

import com.sisrest.dto.itemCardapioDia.ItemCardapioDiaRequest;
import com.sisrest.dto.itemCardapioDia.ItemCardapioDiaResponse;
import com.sisrest.model.entities.CardapioSemanal;
import com.sisrest.model.entities.ItemCardapioDia;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemCardapioDiaServiceConvert {
    @Autowired
    private ModelMapper mapper;

    public List<ItemCardapioDiaResponse> itensCardapioDiaToResponses(List<ItemCardapioDia> itens) {
        return itens.stream().map(this::itemCardapioDiaToDTO).collect(Collectors.toList());
    }

    public ItemCardapioDia dtoToItemCardapioDia(ItemCardapioDiaRequest dto, CardapioSemanal cardapio) {
        ItemCardapioDia itemCardapioDia = mapper.map(dto, ItemCardapioDia.class);
        itemCardapioDia.setCardapioSemanal(cardapio);
        return itemCardapioDia;
    }

    public ItemCardapioDia dtoToItemCardapioDia(ItemCardapioDiaRequest dto) {
        ItemCardapioDia itemCardapioDia = mapper.map(dto, ItemCardapioDia.class);
        return itemCardapioDia;
    }

    public ItemCardapioDiaResponse itemCardapioDiaToDTO(ItemCardapioDia item) {
        ItemCardapioDiaResponse response = mapper.map(item, ItemCardapioDiaResponse.class);
        return response;
    }
}
