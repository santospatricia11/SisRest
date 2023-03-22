package com.sisrest.services.convertes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.sisrest.dto.edital.EditalRequest;
import com.sisrest.dto.edital.EditalResponse;
import com.sisrest.model.entities.Edital;

public class EditalServiceConvert {

	@Autowired
	private ModelMapper mapper;

	public List<EditalResponse> editaisToResponses(List<Edital> editais) {
		return editais.stream().map(this::editalToDTO).toList();
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
