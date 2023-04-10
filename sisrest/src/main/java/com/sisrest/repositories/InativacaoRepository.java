package com.sisrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisrest.model.entities.Beneficiario;
import com.sisrest.model.entities.Inativacao;

public interface InativacaoRepository extends JpaRepository<Inativacao, Long> {

}
