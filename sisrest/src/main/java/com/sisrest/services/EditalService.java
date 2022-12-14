package com.sisrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.model.entities.Edital;
import com.sisrest.repositories.EditalRepository;

@Service
public class EditalService {

	@Autowired
	private EditalRepository editalRepository;

	public Edital save(Edital edital) {
		return editalRepository.save(edital);
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

	public Edital update(long id, Edital edital) {
		return editalRepository.save(edital);
	}
}
