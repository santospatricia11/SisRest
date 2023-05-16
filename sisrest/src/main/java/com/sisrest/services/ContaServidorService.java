package com.sisrest.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sisrest.dto.contaBeneficiario.ContaEstudanteRequest;
import com.sisrest.dto.contaBeneficiario.ContaEstudanteResponse;
import com.sisrest.dto.contaServidor.ContaServidorRequest;
import com.sisrest.dto.contaServidor.ContaServidorResponse;
import com.sisrest.exception.EmailEmUsoException;
import com.sisrest.model.entities.Conta;
import com.sisrest.model.entities.ContaEstudante;
import com.sisrest.model.entities.ContaServidor;
import com.sisrest.repositories.ContaEstudanteRepository;
import com.sisrest.repositories.ContaServidorRepository;
import com.sisrest.services.convertes.ContaEstudanteServiceConvert;
import com.sisrest.services.convertes.ContaServidorServiceConcert;

@Service
public class ContaServidorService {

	@Autowired
	private ContaServidorRepository contaServidorRepository;

	@Autowired
	private ContaServidorServiceConcert contaServidorServiceConvert;

	public ContaServidorResponse save(ContaServidorRequest contaServidorDto) throws EmailEmUsoException {
		ContaServidor contaServidor = contaServidorServiceConvert.dtoToContaServidor(contaServidorDto);
		boolean verificado = contaServidorRepository.existsByEmail(contaServidorDto.getEmail());

		if (verificado)
			throw new EmailEmUsoException(contaServidorDto.getEmail());
		else {
			contaServidorRepository.save(contaServidor);
			ContaServidorResponse contaServidorResponse = contaServidorServiceConvert.contaServidorToDTO(contaServidor);
			return contaServidorResponse;
		}
	}

	public ContaServidor save(ContaServidor contaServidor) {
		return contaServidorRepository.save(contaServidor);
	}

	public boolean existsEmail(String email) {
		return contaServidorRepository.existsByEmail(email);
	}

	public ContaServidor findByEmail(String email) throws ObjectNotFoundException {
		return contaServidorRepository.findByEmail(email).orElseThrow(
				() -> new ObjectNotFoundException("ContaServidor  não encontrada/ email: " + email, email));
	}

	public ContaServidorResponse deleteById(long id) {
		Optional<ContaServidor> contaEstudante = contaServidorRepository.findById(id);
		contaServidorRepository.deleteById(id);
		ContaServidorResponse contaServidorResponse = contaServidorServiceConvert
				.contaServidorToDTO(contaEstudante.get());
		return contaServidorResponse;

	}

	public ContaServidorResponse update(long id, ContaServidorRequest contaServidorDto) {
		Optional<ContaServidor> contaServidor = contaServidorRepository.findById(id);
		ContaServidor original = contaServidor.get();
		ContaServidor atualizar = contaServidorServiceConvert.dtoToContaServidor(contaServidorDto);
		boolean verificado = contaServidorRepository.existsById(contaServidor.get().getId());

		if (verificado)
			atualizar.setId(contaServidor.get().getId());

		if (atualizar.getNome() == null) {
			atualizar.setNome(original.getNome());
		} else if (atualizar.getEmail() == null) {
			atualizar.setEmail(original.getEmail());
		} else if (atualizar.getMatriculaSIAPE() == 0) {
			atualizar.setMatriculaSIAPE(original.getMatriculaSIAPE());
		}
		ContaServidorResponse contaServidorResponse = contaServidorServiceConvert
				.contaServidorToDTO(contaServidorRepository.save(atualizar));
		return contaServidorResponse;
	}

	public List<ContaServidorResponse> findAll() {
		return contaServidorServiceConvert.usersToResponses(contaServidorRepository.findAll());
	}

	public ContaServidorResponse findById(long id) {
		Optional<ContaServidor> contaServidor = contaServidorRepository.findById(id);
		ContaServidorResponse contaServidorResponse = contaServidorServiceConvert
				.contaServidorToDTO(contaServidor.get());
		return contaServidorResponse;

	}
	/*
	 * @Autowired private ContaServidorRepository contaServidorRepository;
	 */
	/*
	 * public ContaServidorRequest salvarContaPorEmail(String email) {
	 * ContaServidorResponse response =
	 * contaServidorRepository.salvarPorEmail(email); if (response == null) { // a
	 * conta do servidor não existe para o e-mail fornecido return null; }
	 * 
	 * // cria uma instância do DTO para transferir os dados return new
	 * ContaServidorRequest(response.getId(), response.getNome(),
	 * response.getEmail(), response.getMatriculaSIAPE(), response.isAdmin()); }
	 */

}
