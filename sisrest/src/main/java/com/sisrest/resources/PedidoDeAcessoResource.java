package com.sisrest.resources;

import com.sisrest.dto.pedidoDeAcesso.PedidoDeAcessoRequest;
import com.sisrest.dto.pedidoDeAcesso.PedidoDeAcessoResponse;
import com.sisrest.exception.PedidoDeAcessoJaAnalisadoException;
import com.sisrest.services.PedidoDeAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pedidoDeAcesso")
public class PedidoDeAcessoResource {
    @Autowired
    private PedidoDeAcessoService pedidoDeAcessoService;

    @PostMapping(value = "/criar")
    public ResponseEntity<PedidoDeAcessoResponse> createPedidoDeAcesso(@RequestBody @Valid PedidoDeAcessoRequest dto) {
        try {
            PedidoDeAcessoResponse pedidoDeAcessoResponse = pedidoDeAcessoService.save(dto);
            return new ResponseEntity(pedidoDeAcessoResponse, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity(dto, HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<PedidoDeAcessoResponse> deletePedidoDeAcesso(@PathVariable("id") long id) {
        try {
            PedidoDeAcessoResponse pedidoDeAcessoResponse = pedidoDeAcessoService.deleteById(id);
            return new ResponseEntity<>(pedidoDeAcessoResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/buscarPorID/{id}")
    public ResponseEntity<PedidoDeAcessoResponse> getByIdPedidoDeAcesso(@PathVariable("id") long id) {
        PedidoDeAcessoResponse pedidoDeAcessoResponse = pedidoDeAcessoService.findById(id);
        if (pedidoDeAcessoResponse != null) {
            return new ResponseEntity<>(pedidoDeAcessoResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<List<PedidoDeAcessoResponse>> getAllPedidoDeAcesso() {
        try {
            List<PedidoDeAcessoResponse> pedidoDeAcessoReponse = pedidoDeAcessoService.findAll();
            if (pedidoDeAcessoReponse.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(pedidoDeAcessoReponse, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/avaliar/{id}/{isAprovado}")
    public ResponseEntity<PedidoDeAcessoResponse> updatePedidoDeAcesso(@PathVariable("id") long id, @PathVariable("isAprovado") boolean isAprovado) {
        PedidoDeAcessoResponse pedidoDeAcessoResponse = null;
        try {
            pedidoDeAcessoResponse = pedidoDeAcessoService.aprovarPedido(id, isAprovado);
            if (pedidoDeAcessoResponse != null) {
                return new ResponseEntity<>(pedidoDeAcessoResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (PedidoDeAcessoJaAnalisadoException e) {
            throw new RuntimeException(e);
        }
    }
}
