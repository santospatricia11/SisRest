package com.sisrest.services;

import com.sisrest.dto.contaServidor.ContaServidorRequest;
import com.sisrest.dto.contaServidor.ContaServidorResponse;
import com.sisrest.exception.EmailEmUsoException;
import com.sisrest.exception.MatriculaEmUsoException;
import com.sisrest.model.entities.ContaServidor;
import com.sisrest.repositories.ContaServidorRepository;
import com.sisrest.services.convertes.ContaServidorServiceConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaServidorService {

    @Autowired
    private ContaServidorRepository contaServidorRepository;

    @Autowired
    private ContaServidorServiceConvert contaServidorServiceConvert;

    public ContaServidorResponse save(ContaServidorRequest contaServidorDto) throws EmailEmUsoException, MatriculaEmUsoException {
        ContaServidor contaServidor = contaServidorServiceConvert.dtoToContaServidor(contaServidorDto);
        boolean verificarEmail = contaServidorRepository.existsByEmail(contaServidorDto.getEmail());
        boolean verificarMatricula = contaServidorRepository.existsByMatricula(contaServidorDto.getEmail());
        if (verificarEmail)
            throw new EmailEmUsoException(contaServidorDto.getEmail());
        else if (verificarMatricula) {
            throw new MatriculaEmUsoException(contaServidorDto.getMatriculaSIAPE());
        } else {
            contaServidorRepository.save(contaServidor);
            ContaServidorResponse contaServidorResponse = contaServidorServiceConvert
                    .contaServidorToDTO(contaServidor);
            return contaServidorResponse;
        }
    }

    public ContaServidorResponse deleteById(long id) {
        Optional<ContaServidor> contaServidor = contaServidorRepository.findById(id);
        contaServidorRepository.deleteById(id);
        ContaServidorResponse contaServidorResponse = contaServidorServiceConvert
                .contaServidorToDTO(contaServidor.get());
        return contaServidorResponse;
    }

    public ContaServidorResponse findById(long id) {
        Optional<ContaServidor> contaServidor = contaServidorRepository.findById(id);
        ContaServidorResponse contaServidorResponse = contaServidorServiceConvert
                .contaServidorToDTO(contaServidor.get());
        return contaServidorResponse;

    }

    public List<ContaServidorResponse> findAll() {
        return contaServidorServiceConvert.usersToResponses(contaServidorRepository.findAll());
    }

    public ContaServidorResponse update(long id, ContaServidorRequest contaServidorDto) {
        Optional<ContaServidor> contaServidor = contaServidorRepository.findById(id);
        ContaServidor original = contaServidor.get();
        ContaServidor atualizar = contaServidorServiceConvert.dtoToContaServidor(contaServidorDto);
        boolean verificado = contaServidorRepository.existsById(contaServidor.get().getId());

        if (verificado)
            atualizar.setId(contaServidor.get().getId());

        if (atualizar.getNome() == null) {
            atualizar.setNome(original.getNome());
        } else if (atualizar.getEmail() == null) {
            atualizar.setEmail(original.getEmail());
        } else if (atualizar.getCampus() == null) {
            atualizar.setCampus(original.getCampus());
        } else if (atualizar.getMatriculaSIAPE() == 0) {
            atualizar.setMatriculaSIAPE(original.getMatriculaSIAPE());
        }
        ContaServidorResponse contaServidorResponse = contaServidorServiceConvert
                .contaServidorToDTO(contaServidorRepository.save(atualizar));
        return contaServidorResponse;
    }
}
