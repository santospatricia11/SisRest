package com.sisrest.repositories;

import com.sisrest.model.entities.RestricaoAlimentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestricaoAlimentarRepository extends JpaRepository<RestricaoAlimentar, Long> {
}
