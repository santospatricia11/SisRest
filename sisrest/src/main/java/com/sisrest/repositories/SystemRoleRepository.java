package com.sisrest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisrest.model.entities.SystemRole;


public interface SystemRoleRepository  extends JpaRepository<SystemRole, Long>{

	Optional<SystemRole> findByName(String name);

}
