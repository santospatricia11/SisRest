package com.sisrest.services.convertes;

import com.sisrest.dto.beneficiario.BeneficiarioRequest;
import com.sisrest.dto.beneficiario.BeneficiarioResponse;
import com.sisrest.model.entities.Beneficiario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeneficiarioServiceConvert {

    @Autowired
    private ModelMapper mapper;

    public List<BeneficiarioResponse> beneficiariosToResponses(List<Beneficiario> beneficiarios) {
        return beneficiarios.stream().map(this::beneficiarioToDTO).collect(Collectors.toList());
    }

    public Beneficiario dtoToBeneficiario(BeneficiarioRequest dto) {
        Beneficiario beneficiario = mapper.map(dto, Beneficiario.class);
        return beneficiario;
    }

    public BeneficiarioResponse beneficiarioToDTO(Beneficiario beneficiario) {
        BeneficiarioResponse response = mapper.map(beneficiario, BeneficiarioResponse.class);
        return response;
    }

}
