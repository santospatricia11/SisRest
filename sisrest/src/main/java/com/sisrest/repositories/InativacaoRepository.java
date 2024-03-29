package com.sisrest.repositories;

import com.sisrest.model.entities.Inativacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InativacaoRepository extends JpaRepository<Inativacao, Long> {

}
