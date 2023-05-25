package com.sisrest.repositories;

import com.sisrest.model.entities.PedidoDeAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDeAcessoRepository extends JpaRepository<PedidoDeAcesso, Long> {
}
