package com.sisrest.repositories;


import com.sisrest.model.entities.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {

    @Query(nativeQuery = true, value = "SELECT conta.nome " + "FROM conta JOIN beneficiario "
            + "ON beneficiario.conta_estudante_id = conta.id "
            + "WHERE beneficiario.ativo = true AND UPPER(conta.nome) = UPPER(nome)")
    List<Beneficiario> findByNomeAtivo(String Nome);

}
