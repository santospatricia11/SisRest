package com.sisrest.repositories;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisrest.dto.contaServidor.ContaServidorResponse;
import com.sisrest.model.entities.ContaServidor;

@Repository
public interface ContaServidorRepository extends JpaRepository<ContaServidor, Long> {

	/*
	 * ContaServidor findByEmailOrMatriculaSIAPE(String email);
	 * 
	 * 
	 * 
	 * 
	 * ContaServidorResponse salvarPorEmail(String email);
	 */
	boolean existsByEmail(String email);

	Optional<ContaServidor> findByEmail(String email);
}
