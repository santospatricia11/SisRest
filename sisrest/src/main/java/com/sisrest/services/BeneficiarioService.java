package com.sisrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.google.zxing.NotFoundException;

import com.sisrest.dto.beneficiario.BeneficiarioRequest;
import com.sisrest.dto.beneficiario.BeneficiarioResponse;
import com.sisrest.model.entities.Beneficiario;
import com.sisrest.model.entities.ContaEstudante;
import com.sisrest.model.entities.Edital;
import com.sisrest.repositories.BeneficiarioRepository;
import com.sisrest.repositories.ContaEstudanteRepository;
import com.sisrest.repositories.EditalRepository;
import com.sisrest.services.convertes.BeneficiarioServiceConvert;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private EditalRepository editalRepository;

    @Autowired
    private ContaEstudanteRepository contaEstudanteRepository;

    @Autowired
    private BeneficiarioServiceConvert beneficiarioServiceConvert;

    public BeneficiarioResponse save(BeneficiarioRequest beneficiarioDto) {
        Optional<Edital> edital = editalRepository.findById(beneficiarioDto.getEdital());
        Optional<ContaEstudante> contaEstudante = contaEstudanteRepository.findById(beneficiarioDto.getContaEstudante());

        Beneficiario beneficiario = beneficiarioServiceConvert.dtoToBeneficiario(beneficiarioDto);
        beneficiario.setContaEstudante(contaEstudante.get());
        beneficiario.setEdital(edital.get());
        boolean verificado = false;

        if (verificado) {
            return null;
        } else {
            beneficiarioRepository.save(beneficiario);
            BeneficiarioResponse responseDto = beneficiarioServiceConvert.beneficiarioToDTO(beneficiario);
            return responseDto;
        }
    }

    public BeneficiarioResponse deleteById(long id) {
        Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(id);
        beneficiarioRepository.deleteById(id);
        BeneficiarioResponse beneficiarioResponse = beneficiarioServiceConvert.beneficiarioToDTO(beneficiario.get());
        return beneficiarioResponse;
    }

    public BeneficiarioResponse findById(long id) {
        Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(id);
        BeneficiarioResponse beneficiarioResponse = beneficiarioServiceConvert.beneficiarioToDTO(beneficiario.get());
        return beneficiarioResponse;
    }

    public List<BeneficiarioResponse> findAll() {
        return beneficiarioServiceConvert.beneficiariosToResponses(beneficiarioRepository.findAll());
    }

    public BeneficiarioResponse update(long id, BeneficiarioRequest beneficiarioDto) {
        Optional<Edital> edital = editalRepository.findById(beneficiarioDto.getEdital());
        Optional<ContaEstudante> contaEstudante = contaEstudanteRepository.findById(beneficiarioDto.getContaEstudante());

        Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(id);
        Beneficiario original = beneficiario.get();
        Beneficiario atualizar = beneficiarioServiceConvert.dtoToBeneficiario(beneficiarioDto);
        boolean verificado = beneficiarioRepository.existsById(beneficiario.get().getId());

        if (verificado)
            atualizar.setId(beneficiario.get().getId());
        if (atualizar.getEdital() == null) {
            atualizar.setEdital(original.getEdital());
        } else if (atualizar.getContaEstudante() == null) {
            atualizar.setContaEstudante(original.getContaEstudante());
        }
        atualizar.setContaEstudante(contaEstudante.get());
        atualizar.setEdital(edital.get());
        BeneficiarioResponse beneficiarioResponse = beneficiarioServiceConvert
                .beneficiarioToDTO(beneficiarioRepository.save(atualizar));
        return beneficiarioResponse;
    }
}
