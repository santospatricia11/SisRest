package com.sisrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisrest.model.entities.Beneficiario;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {

}
