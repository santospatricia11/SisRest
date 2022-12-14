package com.sisrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.sisrest.model.entities.Beneficiario;
import com.sisrest.model.entities.Conta;
import com.sisrest.repositories.BeneficiarioRepository;
import com.sisrest.repositories.ContaRepository;

@Service

public class BeneficiarioService {

	@Autowired
	private BeneficiarioRepository beneficiarioRepository;

	
	public Beneficiario save(Beneficiario beneficiario) {
		return beneficiarioRepository.save(beneficiario);
	}

	public Beneficiario deleteById(long id) {
		return null;
	}

	public Optional<Beneficiario> findById(long id) {
		return Optional.of(beneficiarioRepository.findById(id).get());
				
	}

	public List<Beneficiario> findAll() {
		return (List<Beneficiario>) beneficiarioRepository.findAll();
	}

	public Beneficiario update(long id, Beneficiario beneficiario) {
		return beneficiarioRepository.save(beneficiario);
	}

}
