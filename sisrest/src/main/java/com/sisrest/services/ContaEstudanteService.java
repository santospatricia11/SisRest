package com.sisrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.dto.contaBeneficiario.ContaEstudanteRequest;
import com.sisrest.dto.contaBeneficiario.ContaEstudanteResponse;
import com.sisrest.exception.EmailEmUsoException;
import com.sisrest.model.entities.ContaEstudante;
import com.sisrest.repositories.ContaEstudanteRepository;
import com.sisrest.services.convertes.ContaEstudanteServiceConvert;

@Service
public class ContaEstudanteService {

	@Autowired
	private ContaEstudanteRepository contaEstudanteRepository;

	@Autowired
	private ContaEstudanteServiceConvert contaEstudanteServiceConvert;

	public ContaEstudanteResponse save(ContaEstudanteRequest contaEstudanteDto) throws EmailEmUsoException {
		ContaEstudante contaEstudante = contaEstudanteServiceConvert.dtoToContaEstudante(contaEstudanteDto);
		boolean verificado = contaEstudanteRepository.existsByEmail(contaEstudanteDto.getEmail());

		if (verificado)
			throw new EmailEmUsoException(contaEstudanteDto.getEmail());
		else {
			contaEstudanteRepository.save(contaEstudante);
			ContaEstudanteResponse contaEstudanteResponse = contaEstudanteServiceConvert
					.contaEstudanteToDTO(contaEstudante);
			return contaEstudanteResponse;
		}
	}

	public ContaEstudanteResponse deleteById(long id) {
		Optional<ContaEstudante> contaEstudante = contaEstudanteRepository.findById(id);
		contaEstudanteRepository.deleteById(id);
		ContaEstudanteResponse contaEstudanteResponse = contaEstudanteServiceConvert
				.contaEstudanteToDTO(contaEstudante.get());
		return contaEstudanteResponse;

	}

	public ContaEstudanteResponse findById(long id) {
		Optional<ContaEstudante> contaEstudante = contaEstudanteRepository.findById(id);
		ContaEstudanteResponse contaEstudanteResponse = contaEstudanteServiceConvert
				.contaEstudanteToDTO(contaEstudante.get());
		return contaEstudanteResponse;

	}

	public List<ContaEstudanteResponse> findAll() {
		return contaEstudanteServiceConvert.usersToResponses(contaEstudanteRepository.findAll());
	}

	public ContaEstudanteResponse update(long id, ContaEstudanteRequest contaEstudanteDto){
		Optional<ContaEstudante> contaEstudante = contaEstudanteRepository.findById(id);
		ContaEstudante original = contaEstudante.get();
		ContaEstudante atualizar = contaEstudanteServiceConvert.dtoToContaEstudante(contaEstudanteDto);
		boolean verificado = contaEstudanteRepository.existsById(contaEstudante.get().getId());

		if (verificado)
			atualizar.setId(contaEstudante.get().getId());

		if (atualizar.getNome() == null) {
			atualizar.setNome(original.getNome());
		} else if (atualizar.getEmail() == null) {
			atualizar.setEmail(original.getEmail());
		} else if (atualizar.getSenha() == null) {
			atualizar.setSenha(original.getSenha());
		} else if (atualizar.getMatricula() == 0) {
			atualizar.setMatricula(original.getMatricula());
		}
		ContaEstudanteResponse contaEstudanteResponse = contaEstudanteServiceConvert
				.contaEstudanteToDTO(contaEstudanteRepository.save(atualizar));
		return contaEstudanteResponse;
	}
}
