package com.sisrest.services;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.sisrest.model.entities.Conta;
import com.sisrest.repositories.ContaRepository;

@Service
public class ContaService {

	
	@Autowired
	private ContaRepository contaRepository;
	
	public Conta save(Conta conta) {
		return contaRepository.save(conta);
	}

	public Conta deleteById(long id) {
		return null;
	}

	public Optional<Conta> findById(long id) {
		return Optional.of(contaRepository.findById(id).get());
	}

	public List<Conta> findAll() {
		return (List<Conta>) contaRepository.findAll();
	}

	public Conta update(long id, Conta conta) {
		return contaRepository.save(conta);
	}
	

}
