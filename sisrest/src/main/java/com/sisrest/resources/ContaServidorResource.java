package com.sisrest.resources;

import com.sisrest.dto.contaServidor.ContaServidorRequest;
import com.sisrest.dto.contaServidor.ContaServidorResponse;
import com.sisrest.exception.EmailEmUsoException;
import com.sisrest.services.ContaServidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/contaServidor")
public class ContaServidorResource {

    @Autowired
    private ContaServidorService contaServidorService;

    @PostMapping(value = "/criar")
    public ResponseEntity<ContaServidorResponse> createContaServidor(@RequestBody @Valid ContaServidorRequest dto) {
        try {
            ContaServidorResponse contaServidorResponse = contaServidorService.save(dto);
            return new ResponseEntity(contaServidorResponse, HttpStatus.CREATED);
        } catch (EmailEmUsoException ex) {
            return new ResponseEntity(dto, HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<ContaServidorResponse> deleteContaServidor(@PathVariable("id") long id) {
        try {
            ContaServidorResponse contaServidorResponse = contaServidorService.deleteById(id);
            return new ResponseEntity<>(contaServidorResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/buscarPorID/{id}")
    public ResponseEntity<ContaServidorResponse> getByIdContaServidor(@PathVariable("id") long id) {
        ContaServidorResponse contaServidorResponse = contaServidorService.findById(id);
        if (contaServidorResponse != null) {
            return new ResponseEntity<>(contaServidorResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<List<ContaServidorResponse>> getAllContaServidor() {
        try {
            List<ContaServidorResponse> contaServidorResponse = contaServidorService.findAll();
            if (contaServidorResponse.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(contaServidorResponse, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<ContaServidorResponse> update(@PathVariable("id") long id,
                                                        @RequestBody @Valid ContaServidorRequest dto) {
        ContaServidorResponse contaServidorResponse = contaServidorService.update(id, dto);
        if (contaServidorResponse != null) {
            return new ResponseEntity<>(contaServidorResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
