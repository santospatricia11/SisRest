package com.sisrest.services;

import java.util.List;

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

	public ContaRepository save(Conta conta) {
		return contaRepository.save(contaRepository);
	}

	public void deleteById(String email) {
		Conta conta = findById(email);
		if (conta == null) {
			throw new IllegalStateException(String.format("Could not find a entity with id=%1", email));

		}
		contaRepository.deleteById(email);

	}

	private Conta findById(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	private Conta update(String email) {
		Conta conta = (Conta) contaRepository.getById(email);
		if (email == null) {
			throw new IllegalStateException("Email cannot be null");
		}
		return contaRepository.save(conta);
	}

	public List<Conta> find(Conta filter) {

		Example example = Example.of(filter,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));

		return contaRepository.findAll(example);

	}


}
