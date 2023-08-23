package com.sisrest.repositories;

import com.sisrest.model.entities.ListaDiaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaDiariaRepository extends JpaRepository<ListaDiaria, Long> {
}
