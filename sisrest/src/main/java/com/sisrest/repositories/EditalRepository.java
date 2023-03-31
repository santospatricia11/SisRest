package com.sisrest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sisrest.model.entities.Edital;

@Repository
public interface EditalRepository extends JpaRepository<Edital, Long> {

	// verificar se existe Edital por nome
	@Query("SELECT e FROM Edital e WHERE e.nome = :nome AND e.numero = :numero AND e.ano = :ano")
    Optional<Edital> findByNomeNumeroAno(String nome, int numero, int ano);

	// buscar Editais por nome
//	@Query("SELECT e FROM Edital e WHERE e.edital_numero = :nome")
//	Optional<Edital> findByNome(String nome);

	// Buscar Editais por Data Vigente
//	@Query("SELECT e FROM Edital e WHERE e.edital_vigente_inicio = :vigenteInicio AND e.edital_vigente_final = :vigenteFinal")
//	Optional<Edital> findByDataVigenteInicioEFinal(@Param("vigenteInicio") Date vigenteInicio,
//			@Param("vigenteFinal") Date vigenteFinal);
}
