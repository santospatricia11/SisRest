package com.sisrest.resources;

import com.sisrest.dto.refeicao.RefeicaoRequest;
import com.sisrest.dto.refeicao.RefeicaoResponse;
import com.sisrest.services.RefeicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/refeicao")
public class RefeicaoResource {

    @Autowired(required = true)
    private RefeicaoService refeicaoService;

    @PostMapping(value = "/criar")
    public ResponseEntity<RefeicaoResponse> createRefeicao(@RequestBody @Valid RefeicaoRequest dto) {
        try {
            RefeicaoResponse refeicaoResponse = refeicaoService.saveRefeicao(dto);
            return new ResponseEntity(refeicaoResponse, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity(dto, HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<RefeicaoResponse> deleteRefeicao(@PathVariable("id") long id) {
        try {
            RefeicaoResponse refeicaoResponse = refeicaoService.deleteRefeicaoById(id);
            return new ResponseEntity<>(refeicaoResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/buscarPorID/{id}")
    public ResponseEntity<RefeicaoResponse> getByIdRefeicao(@PathVariable("id") long id) {
        RefeicaoResponse refeicaoResponse = refeicaoService.findRefeicaoById(id);
        if (refeicaoResponse != null) {
            return new ResponseEntity<>(refeicaoResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<List<RefeicaoResponse>> getAllRefeicao() {
        try {
            List<RefeicaoResponse> refeicaoReponse = refeicaoService.findAllRefeicoes();
            if (refeicaoReponse.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(refeicaoReponse, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<RefeicaoResponse> updateRefeicao(@PathVariable("id") long id, @RequestBody @Valid RefeicaoRequest dto) {
        RefeicaoResponse refeicaoResponse = refeicaoService.updateRefeicao(id, dto);
        if (refeicaoResponse != null) {
            return new ResponseEntity<>(refeicaoResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}