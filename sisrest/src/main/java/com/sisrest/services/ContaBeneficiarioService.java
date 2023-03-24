package com.sisrest.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.dto.contaBeneficiario.ContaBeneficiarioRequest;
import com.sisrest.exception.EmailEmUsoException;
import com.sisrest.model.entities.ContaBeneficiario;
import com.sisrest.repositories.BeneficiarioRepository;

@Service
public class ContaBeneficiarioService {

	@Autowired
	private BeneficiarioRepository beneficiarioRepository;

	@Autowired
	private ModelMapper mapper;

	public ContaBeneficiario save(ContaBeneficiarioRequest beneficiarioDto) throws EmailEmUsoException {
		ContaBeneficiario beneficiario = mapper.map(beneficiarioDto, ContaBeneficiario.class);
		boolean verificado = beneficiarioRepository.existsByEmail(beneficiarioDto.getEmail());

		if (verificado)
			throw new EmailEmUsoException(beneficiarioDto.getEmail());

		return beneficiarioRepository.save(beneficiario);
	}

	public ContaBeneficiario deleteById(long id) {
		Optional<ContaBeneficiario> beneficiario = beneficiarioRepository.findById(id);
		beneficiarioRepository.deleteById(id);
		return beneficiario.get();
	}

	public ContaBeneficiario findById(long id) {
		Optional<ContaBeneficiario> beneficiario = beneficiarioRepository.findById(id);
		return beneficiario.get();

	}

	public List<ContaBeneficiario> findAll() {
		return (List<ContaBeneficiario>) beneficiarioRepository.findAll();
	}

	public ContaBeneficiario update(long id, ContaBeneficiario beneficiarioDto) throws EmailEmUsoException {
		Optional<ContaBeneficiario> beneficiario = beneficiarioRepository.findById(id);

		ContaBeneficiario original = beneficiario.get();
		ContaBeneficiario atualizar = mapper.map(beneficiarioDto, ContaBeneficiario.class);
		boolean verificado = beneficiarioRepository.existsByEmail(beneficiarioDto.getEmail());

		if (verificado)
			throw new EmailEmUsoException(beneficiarioDto.getEmail());

		atualizar.setId(beneficiario.get().getId());
		if (atualizar.getEmail() == null) {
			atualizar.setEmail(original.getEmail());
		} else if (atualizar.getMatricula() == 0) {
			atualizar.setMatricula(original.getMatricula());
		} else if (atualizar.getNome() == null) {
			atualizar.setNome(original.getNome());
		} else if (atualizar.getSenha() == null) {
			atualizar.setSenha(original.getSenha());
		} else if (atualizar.getTipo() == null) {
			atualizar.setTipo(original.getTipo());
		}
		return beneficiarioRepository.save(atualizar);
	}

}
