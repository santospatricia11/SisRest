package com.sisrest.repositories;

import java.util.Optional;

import com.sisrest.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
}
