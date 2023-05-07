package com.sisrest.resources;

import com.sisrest.dto.edital.EditalRequest;
import com.sisrest.dto.edital.EditalResponse;
import com.sisrest.exception.edital.EditalJaCadastradoException;
import com.sisrest.services.EditalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/edital")
public class EditalResource {

    @Autowired(required = true)
    private EditalService editalService;

    @PostMapping(value = "/criar")
    public ResponseEntity<EditalResponse> createEdital(@RequestBody @Valid EditalRequest dto) {
        try {
            EditalResponse responseDto = editalService.save(dto);
            return new ResponseEntity(responseDto, HttpStatus.CREATED);
        } catch (EditalJaCadastradoException ex) {
            return new ResponseEntity(dto, HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<EditalResponse> deleteEdital(@PathVariable("id") long id) {
        try {
            EditalResponse responseDto = editalService.deleteById(id);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EditalResponse> getEditalById(@PathVariable("id") long id) {
        EditalResponse responseDto = editalService.findById(id);
        if (responseDto != null) {
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<List<EditalResponse>> getAllEdital() {
        try {
            List<EditalResponse> editaisReponse = editalService.findAll();
            if (editaisReponse.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(editaisReponse, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<EditalResponse> update(@PathVariable("id") long id, @RequestBody EditalRequest dto) {
        EditalResponse responseDto = editalService.update(id, dto);
        if (responseDto != null) {
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
