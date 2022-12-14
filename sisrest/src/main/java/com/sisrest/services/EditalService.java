package com.sisrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.model.entities.Conta;
import com.sisrest.model.entities.Edital;
import com.sisrest.repositories.ContaRepository;
import com.sisrest.repositories.EditalRepository;

@Service
public class EditalService {

	@Autowired
	private EditalRepository editalRepository;
	
	public Edital save(Edital edital) {
		return editalRepository.save(edital);
	}

	public Edital deleteById(long id) {
		return null;
	}

	public Optional<Optional<Edital>> findById(long id) {
		return Optional.of(editalRepository.findById(id));
				//of(editalRepository.findById(id));
	}

	public List<Edital> findAll() {
		return (List<Edital>) editalRepository.findAll();
	}

	public Edital update(long id, Edital edital) {
		return editalRepository.save(edital);
	}
}
