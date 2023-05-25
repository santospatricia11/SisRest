package com.sisrest.repositories;

import com.sisrest.model.entities.AcessoDiaRefeicaoM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessoDiaRefeicaoRepository extends JpaRepository<AcessoDiaRefeicaoM, Long> {
}
