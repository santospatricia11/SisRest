package com.sisrest.repositories;


import com.sisrest.model.entities.ContaEstudante;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaEstudanteRepository extends JpaRepository<ContaEstudante, Long> {

    Optional<ContaEstudante> findByEmail(String email);

    Optional<ContaEstudante> findByMatricula(long matricula);

    boolean existsByEmail(String email);


}