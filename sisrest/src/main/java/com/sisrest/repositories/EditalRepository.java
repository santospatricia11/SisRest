package com.sisrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisrest.model.entities.Edital;

@Repository

public interface EditalRepository extends JpaRepository<EditalRepository, String> {

	Edital save(Edital edital);
}
