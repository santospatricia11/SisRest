package com.sisrest.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.dto.contaBeneficiario.ContaBeneficiarioRequest;
import com.sisrest.exception.EmailEmUsoException;
import com.sisrest.model.entities.ContaBeneficiario;
import com.sisrest.repositories.ContaBeneficiarioRepository;

@Service
public class ContaBeneficiarioService {

	@Autowired
	private ContaBeneficiarioRepository contaBeneficiarioRepository;

	@Autowired
	private ModelMapper mapper;

	public ContaBeneficiario save(ContaBeneficiarioRequest beneficiarioDto) throws EmailEmUsoException {
		ContaBeneficiario beneficiario = mapper.map(beneficiarioDto, ContaBeneficiario.class);
		boolean verificado = contaBeneficiarioRepository.existsByEmail(beneficiarioDto.getEmail());

		if (verificado)
			throw new EmailEmUsoException(beneficiarioDto.getEmail());

		return contaBeneficiarioRepository.save(beneficiario);
	}

	public ContaBeneficiario deleteById(long id) {
		Optional<ContaBeneficiario> beneficiario = contaBeneficiarioRepository.findById(id);
		contaBeneficiarioRepository.deleteById(id);
		return beneficiario.get();
	}

	public ContaBeneficiario findById(long id) {
		Optional<ContaBeneficiario> beneficiario = contaBeneficiarioRepository.findById(id);
		return beneficiario.get();

	}

	public List<ContaBeneficiario> findAll() {
		return (List<ContaBeneficiario>) contaBeneficiarioRepository.findAll();
	}

	public ContaBeneficiario update(long id, ContaBeneficiario beneficiarioDto) throws EmailEmUsoException {
		Optional<ContaBeneficiario> beneficiario = contaBeneficiarioRepository.findById(id);

		ContaBeneficiario original = beneficiario.get();
		ContaBeneficiario atualizar = mapper.map(beneficiarioDto, ContaBeneficiario.class);
		boolean verificado = contaBeneficiarioRepository.existsByEmail(beneficiarioDto.getEmail());

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
		return contaBeneficiarioRepository.save(atualizar);
	}

}
