package com.sisrest.repositories;

import com.sisrest.model.entities.CardapioSemanal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioSemanalRepository extends JpaRepository<CardapioSemanal, Long> {

}
