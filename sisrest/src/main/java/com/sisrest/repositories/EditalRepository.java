package com.sisrest.repositories;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisrest.model.entities.Edital;
import com.sisrest.model.entities.User;

@Repository
public interface EditalRepository extends JpaRepository<Edital, Long> {
	// verificar se existe Edital por nome
	boolean existsByNome(String nome);

	// verificar se existe Edital por numero e ano
	boolean existsByNumeroAno(int numero, String ano);

	// buscar Editais por nome
	Optional<User> findByNome(String nome);

	// Buscar Editais por Data Vigente
	Optional<User> findByDataVigenteInicioEFinal(Date vigenteInicio, Date vigenteFinal);
}
