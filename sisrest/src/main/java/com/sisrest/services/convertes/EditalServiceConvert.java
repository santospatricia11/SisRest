package com.sisrest.services.convertes;

import com.sisrest.dto.edital.EditalRequest;
import com.sisrest.dto.edital.EditalResponse;
import com.sisrest.model.entities.Edital;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditalServiceConvert {

    @Autowired
    private ModelMapper mapper;

    public List<EditalResponse> editaisToResponses(List<Edital> editais) {
        return editais.stream().map(this::editalToDTO).collect(Collectors.toList());
    }

    public Edital dtoToEdital(EditalRequest dto) {
        Edital edital = mapper.map(dto, Edital.class);
        return edital;
    }

    public EditalResponse editalToDTO(Edital edital) {
        EditalResponse response = mapper.map(edital, EditalResponse.class);
        return response;
    }
}
