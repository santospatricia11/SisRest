package com.sisrest.resources;

import com.sisrest.dto.presenca.PresencaRequest;
import com.sisrest.dto.presenca.PresencaResponse;
import com.sisrest.services.PresencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/presenca")
public class PresencaResource {

    @Autowired(required = true)
    private PresencaService presencaService;

    @PostMapping(value = "/criar")
    public ResponseEntity<PresencaResponse> create(@RequestBody @Valid PresencaRequest dto) {
        PresencaResponse responseDto = presencaService.save(dto);
        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<PresencaResponse> delete(@PathVariable("id") long id) {
        try {
            PresencaResponse responseDto = presencaService.deleteById(id);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PresencaResponse> getById(@PathVariable("id") long id) {
        PresencaResponse responseDto = presencaService.findById(id);
        if (responseDto != null) {
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<List<PresencaResponse>> getAll() {
        try {
            List<PresencaResponse> presencaResponses = presencaService.findAll();
            if (presencaResponses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(presencaResponses, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<PresencaResponse> update(@PathVariable("id") long id, @RequestBody PresencaRequest dto) {
        PresencaResponse responseDto = presencaService.update(id, dto);
        if (responseDto != null) {
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
