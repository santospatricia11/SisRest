package com.sisrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisrest.model.entities.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}
