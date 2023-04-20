package com.sisrest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisrest.model.entities.ContaEstudante;

@Repository
public interface ContaEstudanteRepository extends JpaRepository<ContaEstudante, Long> {

    Optional<ContaEstudante> findByEmail(String email);

    boolean existsByEmail(String email);
}