package com.sisrest.services;

import com.sisrest.dto.restricaoAlimentar.RestricaoAlimentarRequest;
import com.sisrest.dto.restricaoAlimentar.RestricaoAlimentarResponse;
import com.sisrest.model.entities.RestricaoAlimentar;
import com.sisrest.repositories.RestricaoAlimentarRepository;
import com.sisrest.services.convertes.RestricaoAlimentarServiceConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestricaoAlimentarService {

    @Autowired
    private RestricaoAlimentarRepository restricaoAlimentarRepository;

    @Autowired
    private RestricaoAlimentarServiceConvert restricaoAlimentarServiceConvert;

    public RestricaoAlimentarResponse save(RestricaoAlimentarRequest restricaoAlimentarDto) {
        RestricaoAlimentar restricaoAlimentar = restricaoAlimentarServiceConvert.dtoToRestricaoAlimentar(restricaoAlimentarDto);
        restricaoAlimentar.resultadoAnaliseFalse();
        restricaoAlimentarRepository.save(restricaoAlimentar);
        RestricaoAlimentarResponse responseDto = restricaoAlimentarServiceConvert.restricaoAlimentarToDTO(restricaoAlimentar);
        return responseDto;
    }

    public RestricaoAlimentarResponse deleteById(long id) {
        Optional<RestricaoAlimentar> restricaoAlimentar = restricaoAlimentarRepository.findById(id);
        restricaoAlimentarRepository.deleteById(id);
        RestricaoAlimentarResponse responseDto = restricaoAlimentarServiceConvert.restricaoAlimentarToDTO(restricaoAlimentar.get());
        return responseDto;
    }

    public RestricaoAlimentarResponse findById(long id) {
        Optional<RestricaoAlimentar> restricaoAlimentar = restricaoAlimentarRepository.findById(id);
        RestricaoAlimentarResponse responseDto = restricaoAlimentarServiceConvert.restricaoAlimentarToDTO(restricaoAlimentar.get());
        return responseDto;
    }

    public List<RestricaoAlimentarResponse> findAll() {
        return restricaoAlimentarServiceConvert.restricaoAlimentarToResponses(restricaoAlimentarRepository.findAll());
    }

    public RestricaoAlimentarResponse update(long id, RestricaoAlimentarRequest restricaoAlimentarDto) {
        Optional<RestricaoAlimentar> restricaoAlimentar = restricaoAlimentarRepository.findById(id);
        RestricaoAlimentar original = restricaoAlimentar.get();
        RestricaoAlimentar atualizar = restricaoAlimentarServiceConvert.dtoToRestricaoAlimentar(restricaoAlimentarDto);
        boolean verificado = restricaoAlimentarRepository.existsById(restricaoAlimentar.get().getId());

        if (verificado) atualizar.setId(restricaoAlimentar.get().getId());

        if (atualizar.getObservacoes() == null) {
            atualizar.setObservacoes(original.getObservacoes());
        } else if (atualizar.getAnexo() == null) {
            atualizar.setAnexo(original.getAnexo());
        } else if (atualizar.getTipoDeRestricaoAlimentar() == null) {
            atualizar.setTipoDeRestricaoAlimentar(original.getTipoDeRestricaoAlimentar());
        } else if (atualizar.getJustificativaAnalise() == null) {
            atualizar.setJustificativaAnalise(original.getJustificativaAnalise());
        } else if (atualizar.getAnalisadeEm() == null) {
            atualizar.setAnalisadeEm(original.getAnalisadeEm());
        } else if (atualizar.getPedidoDeAcesso() == null) {
            atualizar.setPedidoDeAcesso(original.getPedidoDeAcesso());
        }

        RestricaoAlimentarResponse responseDto = restricaoAlimentarServiceConvert.restricaoAlimentarToDTO(restricaoAlimentarRepository.save(atualizar));
        return responseDto;
    }

    public RestricaoAlimentarResponse aprovarPedido(Long id) {
        Optional<RestricaoAlimentar> restricaoAlimentar = restricaoAlimentarRepository.findById(id);
        RestricaoAlimentar restricao = restricaoAlimentar.get();
        restricao.resultadoAnaliseTrue();
        RestricaoAlimentarResponse responseDto = restricaoAlimentarServiceConvert.restricaoAlimentarToDTO(restricaoAlimentarRepository.save(restricao));
        return responseDto;
    }
}
