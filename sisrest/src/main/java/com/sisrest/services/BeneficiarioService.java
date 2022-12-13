package com.sisrest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.sisrest.model.entities.Beneficiario;
import com.sisrest.repositories.BeneficiarioRepository;

@Service

public class BeneficiarioService {

	@Autowired
	private BeneficiarioRepository beneficiarioRepository;

	public BeneficiarioRepository save(Beneficiario beneficiario) {
		return beneficiarioRepository.save(beneficiarioRepository);
	}

<<<<<<< HEAD
	public void deleteById(long id) {
		Beneficiario beneficiario = findById(id);
=======
	public void deleteById(long matricula) {
		Beneficiario beneficiario = findById(matricula);
>>>>>>> gabriel
		if (beneficiario == null) {
			throw new IllegalStateException(String.format("Could not find a entity with id=%1", id));

		}
		beneficiarioRepository.deleteById(id);
	}

<<<<<<< HEAD
	private Beneficiario findById(long id) {
		// TODO Auto-generated method stub
		return null;
=======
	public Beneficiario findById(long id) {
		Beneficiario beneficiario = (Beneficiario) beneficiarioRepository.getById(id);
		return beneficiario;
>>>>>>> gabriel
	}

	private Beneficiario update(long id) {
		Beneficiario beneficiario = (Beneficiario) beneficiarioRepository.getById(id);
<<<<<<< HEAD
		if (id == null) {
			throw new IllegalStateException("Id cannot be null");
=======
		if (id == 0) {
			throw new IllegalStateException("Matricula cannot be null");
>>>>>>> gabriel
		}
		return beneficiarioRepository.save(beneficiario);
	}

	public List<Beneficiario> find(Beneficiario filter) {

		Example example = Example.of(filter,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));

		return beneficiarioRepository.findAll(example);

	}

}
