package com.sisrest.resources;

import com.sisrest.dto.beneficiario.BeneficiarioRequest;
import com.sisrest.dto.beneficiario.BeneficiarioResponse;
import com.sisrest.services.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/beneficiario")
public class BeneficiarioResource {
    @Autowired
    private BeneficiarioService beneficiarioService;


    @Autowired
    private BeneficiarioService beneficiarioService;

    @PostMapping(value = "/criar")
    public ResponseEntity<BeneficiarioResponse> createBeneficiario(@RequestBody @Valid BeneficiarioRequest dto) {
        try {
            BeneficiarioResponse beneficiarioResponse = beneficiarioService.save(dto);
            return new ResponseEntity(beneficiarioResponse, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity(dto, HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<BeneficiarioResponse> delete(@PathVariable("id") long id) {
        try {
            BeneficiarioResponse beneficiarioResponse = beneficiarioService.deleteById(id);
            return new ResponseEntity<>(beneficiarioResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/buscarPorID/{id}")
    public ResponseEntity<BeneficiarioResponse> getById(@PathVariable("id") long id) {
        BeneficiarioResponse beneficiarioResponse = beneficiarioService.findById(id);
        if (beneficiarioResponse != null) {
            return new ResponseEntity<>(beneficiarioResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<List<BeneficiarioResponse>> getAllConta() {
        try {
            List<BeneficiarioResponse> beneficiarioReponse = beneficiarioService.findAll();
            if (beneficiarioReponse.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(beneficiarioReponse, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<BeneficiarioResponse> update(@PathVariable("id") long id,
                                                       @RequestBody @Valid BeneficiarioRequest dto) {
        BeneficiarioResponse beneficiarioResponse = beneficiarioService.update(id, dto);
        if (beneficiarioResponse != null) {
            return new ResponseEntity<>(beneficiarioResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
