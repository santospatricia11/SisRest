package com.sisrest.repositories;

import com.sisrest.model.entities.ItemCardapioDia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCardapioDiaRepository extends JpaRepository<ItemCardapioDia, Long> {
}
