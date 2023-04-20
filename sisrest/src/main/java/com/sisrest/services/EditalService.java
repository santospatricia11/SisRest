package com.sisrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.dto.edital.EditalRequest;
import com.sisrest.dto.edital.EditalResponse;
import com.sisrest.exception.edital.EditalJaCadastradoException;
import com.sisrest.model.entities.Edital;
import com.sisrest.repositories.EditalRepository;
import com.sisrest.services.convertes.EditalServiceConvert;

@Service
public class EditalService {

    @Autowired
    private EditalRepository editalRepository;

    @Autowired
    private EditalServiceConvert editalServiceConvert;

    public EditalResponse save(EditalRequest editalDto) throws EditalJaCadastradoException {
        Edital edital = editalServiceConvert.dtoToEdital(editalDto);
        boolean verificado = editalRepository.existsByNumeroAndAno(editalDto.getNumero(), editalDto.getAno());

        if (verificado) {
            throw new EditalJaCadastradoException("Edital já cadastrado!");
        } else {
            editalRepository.save(edital);
            EditalResponse responseDto = editalServiceConvert.editalToDTO(edital);
            return responseDto;
        }
    }

    public EditalResponse deleteById(long id) {
        Optional<Edital> edital = editalRepository.findById(id);
        editalRepository.deleteById(id);
        EditalResponse responseDto = editalServiceConvert.editalToDTO(edital.get());
        return responseDto;
    }

    public EditalResponse findById(long id) {
        Optional<Edital> edital = editalRepository.findById(id);
        EditalResponse responseDto = editalServiceConvert.editalToDTO(edital.get());
        return responseDto;
    }

    public List<EditalResponse> findAll() {
        return editalServiceConvert.editaisToResponses(editalRepository.findAll());
    }

    public EditalResponse update(long id, EditalRequest editalDto) {
        Optional<Edital> edital = editalRepository.findById(id);
        Edital original = edital.get();
        Edital atualizar = editalServiceConvert.dtoToEdital(editalDto);
        boolean verificado = editalRepository.existsById(edital.get().getId());

        if (verificado)
            atualizar.setId(edital.get().getId());

        if (atualizar.getNome() == null) {
            atualizar.setNome(original.getNome());
        } else if (atualizar.getNumero() == 0) {
            atualizar.setNumero(original.getNumero());
        } else if (atualizar.getAno() == 0) {
            atualizar.setAno(original.getAno());
        } else if (atualizar.getVigenteInicio() == null) {
            atualizar.setVigenteInicio(original.getVigenteInicio());
        } else if (atualizar.getVigenteFinal() == null) {
            atualizar.setVigenteFinal(original.getVigenteFinal());
        }
        EditalResponse responseDto = editalServiceConvert.editalToDTO(editalRepository.save(atualizar));
        return responseDto;
    }
}
