package com.sisrest.services.convertes;

import com.sisrest.dto.restricaoAlimentar.RestricaoAlimentarRequest;
import com.sisrest.dto.restricaoAlimentar.RestricaoAlimentarResponse;
import com.sisrest.model.entities.RestricaoAlimentar;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestricaoAlimentarServiceConvert {
    @Autowired
    private ModelMapper mapper;

    public List<RestricaoAlimentarResponse> restricaoAlimentarToResponses(List<RestricaoAlimentar> restricoes) {
        return restricoes.stream().map(this::restricaoAlimentarToDTO).collect(Collectors.toList());
    }

    public RestricaoAlimentar dtoToRestricaoAlimentar(RestricaoAlimentarRequest dto) {
        RestricaoAlimentar restricaoAlimentar = mapper.map(dto, RestricaoAlimentar.class);
        return restricaoAlimentar;
    }

    public RestricaoAlimentarResponse restricaoAlimentarToDTO(RestricaoAlimentar restricao) {
        RestricaoAlimentarResponse response = mapper.map(restricao, RestricaoAlimentarResponse.class);
        return response;
    }
}
