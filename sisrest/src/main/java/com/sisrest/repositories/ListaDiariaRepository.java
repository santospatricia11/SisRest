package com.sisrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisrest.model.entities.ListaDiaria;
import com.sisrest.model.entities.RestricaoAlimentar;
@Repository
public interface ListaDiariaRepository extends JpaRepository<ListaDiaria, Long> {

}
