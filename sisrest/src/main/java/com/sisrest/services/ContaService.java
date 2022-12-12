package com.sisrest.services;

import java.awt.print.Pageable;
import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> 3bd3c569d1f574638f4d016acaf065776f0aa26c

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

	public Conta deleteById(String email) {
		return null;
	}

	public Optional<Optional<ContaRepository>> findById(String email) {
		return Optional.of(contaRepository.findById(email));
	}

	public Optional<List<ContaRepository>> findAll() {
		
		return Optional.of(contaRepository.findAll());
	}

	public Conta update(String email, Conta conta) {
		return contaRepository.save(conta);
	}

}
