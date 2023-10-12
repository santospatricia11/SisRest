package com.sisrest.services;

import com.sisrest.dto.presenca.PresencaRequest;
import com.sisrest.dto.presenca.PresencaResponse;
import com.sisrest.model.entities.Beneficiario;
import com.sisrest.model.entities.ListaDiaria;
import com.sisrest.model.entities.Presenca;
import com.sisrest.repositories.BeneficiarioRepository;
import com.sisrest.repositories.ListaDiariaRepository;
import com.sisrest.repositories.PresencaRepository;
import com.sisrest.services.convertes.PresencaServiceConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresencaService {
    @Autowired
    private PresencaRepository presencaRepository;

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private ListaDiariaRepository listaDiariaRepository;

    @Autowired
    private PresencaServiceConvert presencaServiceConvert;

    public PresencaResponse save(PresencaRequest presencaRequest) {
        Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(presencaRequest.getBeneficiario());
        Optional<ListaDiaria> listaDiaria = listaDiariaRepository.findById(presencaRequest.getListaDiaria());

        Presenca presenca = presencaServiceConvert.dtoToPresenca(presencaRequest);
        presenca.setBeneficiario(beneficiario.get());
        presenca.setListaDiaria(listaDiaria.get());

        presencaRepository.save(presenca);
        PresencaResponse responseDto = presencaServiceConvert.presencaToDTO(presenca);
        return responseDto;
    }

    public PresencaResponse deleteById(long id) {
        Optional<Presenca> presenca = presencaRepository.findById(id);
        presencaRepository.deleteById(id);
        PresencaResponse presencaResponse = presencaServiceConvert.presencaToDTO(presenca.get());
        return presencaResponse;
    }

    public PresencaResponse findById(long id) {
        Optional<Presenca> presenca = presencaRepository.findById(id);
        PresencaResponse presencaResponse = presencaServiceConvert.presencaToDTO(presenca.get());
        return presencaResponse;
    }

    public List<PresencaResponse> findAll() {
        return presencaServiceConvert.presencasToResponses(presencaRepository.findAll());
    }

    public PresencaResponse update(long id, PresencaRequest presencaRequest) {
        Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(presencaRequest.getBeneficiario());
        Optional<ListaDiaria> listaDiaria = listaDiariaRepository.findById(presencaRequest.getListaDiaria());

        Optional<Presenca> presenca = presencaRepository.findById(id);
        Presenca original = presenca.get();
        Presenca atualizar = presencaServiceConvert.dtoToPresenca(presencaRequest);
        boolean verificado = presencaRepository.existsById(presenca.get().getId());

        if (verificado) atualizar.setId(presenca.get().getId());
        if (atualizar.getBeneficiario() == null) {
            atualizar.setBeneficiario(original.getBeneficiario());
        } else if (atualizar.getListaDiaria() == null) {
            atualizar.setListaDiaria(original.getListaDiaria());
        } else if (atualizar.getConfirmadoEm() == null) {
            atualizar.setConfirmadoEm(original.getConfirmadoEm());
        } else if (atualizar.getCompareceuEm() == null) {
            atualizar.setCompareceuEm(original.getCompareceuEm());
        }
        PresencaResponse presencaResponse = presencaServiceConvert.presencaToDTO(presencaRepository.save(atualizar));
        return presencaResponse;
    }
}
