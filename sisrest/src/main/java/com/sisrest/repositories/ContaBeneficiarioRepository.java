package com.sisrest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisrest.model.entities.ContaBeneficiario;

@Repository
public interface BeneficiarioRepository extends JpaRepository<ContaBeneficiario, Long> {

	Optional<ContaBeneficiario> findByEmail(String email);

	boolean existsByEmail(String email);
}