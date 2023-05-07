package com.sisrest.repositories;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisrest.model.entities.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {


}
