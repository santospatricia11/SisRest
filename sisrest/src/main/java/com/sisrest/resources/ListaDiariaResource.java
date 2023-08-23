package com.sisrest.resources;

import com.sisrest.dto.listaDiaria.ListaDiariaRequest;
import com.sisrest.dto.listaDiaria.ListaDiariaResponse;
import com.sisrest.services.ListaDiariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/listaDiaria")
public class ListaDiariaResource {

    @Autowired(required = true)
    private ListaDiariaService listaDiariaService;

    @PostMapping(value = "/criar")
    public ResponseEntity<ListaDiariaResponse> create(@RequestBody @Valid ListaDiariaRequest dto) {
        ListaDiariaResponse responseDto = listaDiariaService.save(dto);
        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<ListaDiariaResponse> delete(@PathVariable("id") long id) {
        try {
            ListaDiariaResponse responseDto = listaDiariaService.deleteById(id);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ListaDiariaResponse> getById(@PathVariable("id") long id) {
        ListaDiariaResponse responseDto = listaDiariaService.findById(id);
        if (responseDto != null) {
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<List<ListaDiariaResponse>> getAll() {
        try {
            List<ListaDiariaResponse> listaDiariaResponses = listaDiariaService.findAll();
            if (listaDiariaResponses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(listaDiariaResponses, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<ListaDiariaResponse> update(@PathVariable("id") long id, @RequestBody ListaDiariaRequest dto) {
        ListaDiariaResponse responseDto = listaDiariaService.update(id, dto);
        if (responseDto != null) {
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
