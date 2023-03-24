package com.sisrest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisrest.model.entities.UsuarioGoogle;

@Repository
public interface UsuarioGoogleRepository extends JpaRepository<UsuarioGoogle, Long> {

	Optional<UsuarioGoogle> findByEmail(String email);

	Boolean existsByEmail(String email);
}
