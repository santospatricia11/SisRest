package com.sisrest.resources;

import com.sisrest.dto.acessoDiaRefeicao.AcessoDiaRefeicaoRequest;
import com.sisrest.dto.acessoDiaRefeicao.AcessoDiaRefeicaoResponse;
import com.sisrest.services.AcessoDiaRefeicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/acessoDiaRefeicao")
public class AcessoDiaRefeicaoResource {

    @Autowired
    private AcessoDiaRefeicaoService acessoDiaRefeicaoService;

    @PostMapping(value = "/criar")
    public ResponseEntity<AcessoDiaRefeicaoResponse> createAcessoDiaRefeicao(@RequestBody @Valid AcessoDiaRefeicaoRequest dto) {
        try {
            AcessoDiaRefeicaoResponse acessoDiaRefeicaoResponse = acessoDiaRefeicaoService.save(dto);
            return new ResponseEntity(acessoDiaRefeicaoResponse, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity(dto, HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<AcessoDiaRefeicaoResponse> deleteAcessoDiaRefeicao(@PathVariable("id") long id) {
        try {
            AcessoDiaRefeicaoResponse acessoDiaRefeicaoResponse = acessoDiaRefeicaoService.deleteById(id);
            return new ResponseEntity<>(acessoDiaRefeicaoResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/buscarPorID/{id}")
    public ResponseEntity<AcessoDiaRefeicaoResponse> getByIdAcessoDiaRefeicao(@PathVariable("id") long id) {
        AcessoDiaRefeicaoResponse acessoDiaRefeicaoResponse = acessoDiaRefeicaoService.findById(id);
        if (acessoDiaRefeicaoResponse != null) {
            return new ResponseEntity<>(acessoDiaRefeicaoResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<List<AcessoDiaRefeicaoResponse>> getAllAcessoDiaRefeicao() {
        try {
            List<AcessoDiaRefeicaoResponse> acessoDiaRefeicaoReponse = acessoDiaRefeicaoService.findAll();
            if (acessoDiaRefeicaoReponse.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(acessoDiaRefeicaoReponse, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<AcessoDiaRefeicaoResponse> updateAcessoDiaRefeicao(@PathVariable("id") long id, @RequestBody @Valid AcessoDiaRefeicaoRequest dto) {
        AcessoDiaRefeicaoResponse acessoDiaRefeicaoResponse = acessoDiaRefeicaoService.update(id, dto);
        if (acessoDiaRefeicaoResponse != null) {
            return new ResponseEntity<>(acessoDiaRefeicaoResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
