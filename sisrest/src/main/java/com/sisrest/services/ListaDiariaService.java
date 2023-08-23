package com.sisrest.services;

import com.sisrest.dto.listaDiaria.ListaDiariaRequest;
import com.sisrest.dto.listaDiaria.ListaDiariaResponse;
import com.sisrest.model.entities.ListaDiaria;
import com.sisrest.model.entities.Refeicao;
import com.sisrest.repositories.ListaDiariaRepository;
import com.sisrest.repositories.RefeicaoRepository;
import com.sisrest.services.convertes.ListaDiariaServiceConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaDiariaService {

    @Autowired
    private ListaDiariaRepository listaDiariaRepository;

    @Autowired
    private RefeicaoRepository refeicaoRepository;

    @Autowired
    private ListaDiariaServiceConvert listaDiariaServiceConvert;

    public ListaDiariaResponse save(ListaDiariaRequest listaDiariaDto) {
        Optional<Refeicao> refeicao = refeicaoRepository.findById(listaDiariaDto.getRefeicao());
        ListaDiaria lista = listaDiariaServiceConvert.dtoToListaDiaria(listaDiariaDto);
        lista.setRefeicao(refeicao.get());
        listaDiariaRepository.save(lista);
        ListaDiariaResponse responseDto = listaDiariaServiceConvert.listaToDTO(lista);
        return responseDto;
    }

    public ListaDiariaResponse deleteById(long id) {
        Optional<ListaDiaria> lista = listaDiariaRepository.findById(id);
        listaDiariaRepository.deleteById(id);
        ListaDiariaResponse listaDiariaResponse = listaDiariaServiceConvert.listaToDTO(lista.get());
        return listaDiariaResponse;
    }

    public ListaDiariaResponse findById(long id) {
        Optional<ListaDiaria> listaDiaria = listaDiariaRepository.findById(id);
        ListaDiariaResponse listaDiariaResponse = listaDiariaServiceConvert.listaToDTO(listaDiaria.get());
        return listaDiariaResponse;
    }

    public List<ListaDiariaResponse> findAll() {
        return listaDiariaServiceConvert.listasToResponses(listaDiariaRepository.findAll());
    }

    public ListaDiariaResponse update(long id, ListaDiariaRequest listaDiariaDto) {
        Optional<Refeicao> refeicao = refeicaoRepository.findById(listaDiariaDto.getRefeicao());

        Optional<ListaDiaria> listaDiaria = listaDiariaRepository.findById(id);
        ListaDiaria original = listaDiaria.get();
        ListaDiaria atualizar = listaDiariaServiceConvert.dtoToListaDiaria(listaDiariaDto);
        boolean verificado = listaDiariaRepository.existsById(listaDiaria.get().getId());

        if (verificado)
            atualizar.setId(listaDiaria.get().getId());
        if (atualizar.getRefeicao() == null) {
            atualizar.setRefeicao(original.getRefeicao());
        } else if (atualizar.getData() == null) {
            atualizar.setData(original.getData());
        }

        ListaDiariaResponse listaDiariaResponse = listaDiariaServiceConvert
                .listaToDTO(listaDiariaRepository.save(atualizar));
        return listaDiariaResponse;
    }
}
