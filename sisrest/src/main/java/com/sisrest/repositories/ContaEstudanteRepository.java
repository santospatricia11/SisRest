package com.sisrest.repositories;


import com.sisrest.model.entities.ContaEstudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaEstudanteRepository extends JpaRepository<ContaEstudante, Long> {

    Optional<ContaEstudante> findByEmail(String email);

    Optional<ContaEstudante> findByMatricula(long matricula);

    boolean existsByEmail(String email);


}