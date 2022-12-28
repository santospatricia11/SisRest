package com.sisrest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisrest.model.entities.Aluno;
import com.sisrest.model.entities.Beneficiario;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	Optional<Aluno> findByEmail(String email);

	boolean existsByEmail(String email);

}
