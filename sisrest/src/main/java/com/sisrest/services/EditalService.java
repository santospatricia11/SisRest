package com.sisrest.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.dto.edital.EditalRequest;
import com.sisrest.model.entities.Edital;
import com.sisrest.repositories.EditalRepository;

@Service
public class EditalService {

	@Autowired
	private EditalRepository editalRepository;

	@Autowired
	private ModelMapper mapper;

	public Edital save(EditalRequest editalDto) {
		Edital edital = mapper.map(editalDto, Edital.class);
		boolean verificado = editalRepository.existsByNome(editalDto.getNome());
		if (verificado)
			return editalRepository.save(edital);
		return null;
	}

	public Edital deleteById(long id) {
		Optional<Edital> edital = editalRepository.findById(id);
		editalRepository.deleteById(id);
		return edital.get();
	}

	public Edital findById(long id) {
		Optional<Edital> edital = editalRepository.findById(id);
		return edital.get();
	}

	public List<Edital> findAll() {
		return (List<Edital>) editalRepository.findAll();
	}

	public Edital update(long id, EditalRequest editalDto) {
		Optional<Edital> edital = editalRepository.findById(id);
		Edital original = edital.get();
		Edital atualizar = mapper.map(editalDto, Edital.class);
		boolean verificado = editalRepository.existsByNome(editalDto.getNome());

		if (verificado)
			atualizar.setId(edital.get().getId());

		if (atualizar.getNome() == null) {
			atualizar.setNome(original.getNome());
		} else if (atualizar.getNumero() == 0) {
			atualizar.setNumero(original.getNumero());
		} else if (atualizar.getAno() == null) {
			atualizar.setAno(original.getAno());
		} else if (atualizar.getVigenteInicio() == null) {
			atualizar.setVigenteInicio(original.getVigenteInicio());
		} else if (atualizar.getVigenteFinal() == null) {
			atualizar.setVigenteFinal(original.getVigenteFinal());
		}
		return editalRepository.save(atualizar);
	}

}
