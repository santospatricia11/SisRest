package com.sisrest.repositories;

import com.sisrest.model.entities.Edital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EditalRepository extends JpaRepository<Edital, Long> {

    @Query("SELECT COUNT(e) > 0 FROM Edital e WHERE e.numero = :numero AND e.ano = :ano")
    boolean existsByNumeroAndAno(int numero, int ano);

}
