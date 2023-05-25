package com.sisrest.resources;

import com.sisrest.dto.restricaoAlimentar.RestricaoAlimentarRequest;
import com.sisrest.dto.restricaoAlimentar.RestricaoAlimentarResponse;
import com.sisrest.services.RestricaoAlimentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/restricaoAlimentar")
public class RestricaoAlimentarResource {


    @Autowired
    private RestricaoAlimentarService restricaoAlimentarService;

    @PostMapping(value = "/criar")
    public ResponseEntity<RestricaoAlimentarResponse> createRestricaoAlimentar(@RequestBody @Valid RestricaoAlimentarRequest dto) {
        try {
            RestricaoAlimentarResponse restricaoAlimentarResponse = restricaoAlimentarService.save(dto);
            return new ResponseEntity(restricaoAlimentarResponse, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity(dto, HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<RestricaoAlimentarResponse> deleteRestricaoAlimentar(@PathVariable("id") long id) {
        try {
            RestricaoAlimentarResponse restricaoAlimentarResponse = restricaoAlimentarService.deleteById(id);
            return new ResponseEntity<>(restricaoAlimentarResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/buscarPorID/{id}")
    public ResponseEntity<RestricaoAlimentarResponse> getByIdRestricaoAlimentar(@PathVariable("id") long id) {
        RestricaoAlimentarResponse restricaoAlimentarResponse = restricaoAlimentarService.findById(id);
        if (restricaoAlimentarResponse != null) {
            return new ResponseEntity<>(restricaoAlimentarResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<List<RestricaoAlimentarResponse>> getAllRestricaoAlimentar() {
        try {
            List<RestricaoAlimentarResponse> restricaoAlimentarReponse = restricaoAlimentarService.findAll();
            if (restricaoAlimentarReponse.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(restricaoAlimentarReponse, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<RestricaoAlimentarResponse> updateRestricaoAlimentar(@PathVariable("id") long id, @RequestBody @Valid RestricaoAlimentarRequest dto) {
        RestricaoAlimentarResponse restricaoAlimentarResponse = restricaoAlimentarService.update(id, dto);
        if (restricaoAlimentarResponse != null) {
            return new ResponseEntity<>(restricaoAlimentarResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
