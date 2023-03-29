package com.sisrest.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.dto.beneficiario.BeneficiarioRequest;
import com.sisrest.dto.contaBeneficiario.ContaBeneficiarioRequest;
import com.sisrest.exception.EmailEmUsoException;
import com.sisrest.model.entities.Beneficiario;
import com.sisrest.model.entities.Conta;
import com.sisrest.model.entities.ContaBeneficiario;
import com.sisrest.repositories.BeneficiarioRepository;
import com.sisrest.repositories.ContaBeneficiarioRepository;
import com.sisrest.repositories.ContaRepository;
@Service
public class BeneficiarioService {
	@Autowired
	private BeneficiarioRepository beneficiarioRepository;

	@Autowired
	private ModelMapper mapper;

	public Beneficiario save(BeneficiarioRequest beneficiarioDto)  {
		Beneficiario beneficiario = mapper.map(beneficiarioDto, Beneficiario.class);
		
		return beneficiarioRepository.save(beneficiario);
	}

	public Beneficiario deleteById(long id) {
		Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(id);
		beneficiarioRepository.deleteById(id);
		return beneficiario.get();
	}

	public Beneficiario findById(long id) {
		Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(id);
		return beneficiario.get();

	}

	public List<Beneficiario> findAll() {
		return (List<Beneficiario>) beneficiarioRepository.findAll();
	}

	public Beneficiario update(long id, Beneficiario beneficiarioDto)  {
		Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(id);

		Beneficiario original = beneficiario.get();
		Beneficiario atualizar = mapper.map(beneficiarioDto,Beneficiario.class);
		

		atualizar.setId(beneficiario.get().getId());
		if (atualizar.isAtivo() == false) {
			atualizar.setAtivo(true);
		} 
		return beneficiarioRepository.save(atualizar);
	}

}
