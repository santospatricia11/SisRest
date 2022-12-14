package com.sisrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

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
		Optional<Conta> conta = contaRepository.findById(id);
		contaRepository.deleteById(id);
		return conta.get();
	}

	public Conta findById(long id) {
		Optional<Conta> conta = contaRepository.findById(id);
		return conta.get();
	}

	public List<Conta> findAll() {
		return (List<Conta>) contaRepository.findAll();
	}

	public Conta update(long id, Conta conta) {
		return contaRepository.save(conta);
	}

}
