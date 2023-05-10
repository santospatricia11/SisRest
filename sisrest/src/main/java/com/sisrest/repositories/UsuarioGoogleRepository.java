package com.sisrest.repositories;

import com.sisrest.model.entities.UsuarioGoogle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioGoogleRepository extends JpaRepository<UsuarioGoogle, Long> {

    Optional<UsuarioGoogle> findByEmail(String email);

    Boolean existsByEmail(String email);
}
