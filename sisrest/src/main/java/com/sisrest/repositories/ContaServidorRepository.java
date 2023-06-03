package com.sisrest.repositories;

import com.sisrest.model.entities.ContaServidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaServidorRepository extends JpaRepository<ContaServidor, Long> {
    boolean existsByEmail(String email);

    boolean existsByMatricula(String email);

    Optional<ContaServidor> findByEmail(String email);


}
