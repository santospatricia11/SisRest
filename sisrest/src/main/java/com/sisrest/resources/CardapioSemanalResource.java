package com.sisrest.resources;

import com.sisrest.dto.cardapioSemanal.CardapioSemanalRequest;
import com.sisrest.dto.cardapioSemanal.CardapioSemanalResponse;
import com.sisrest.services.CardapioSemanalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cardapioSemanal")
public class CardapioSemanalResource {

    @Autowired(required = true)
    private CardapioSemanalService cardapioSemanalService;

    @PostMapping(value = "/criar")
    public ResponseEntity<CardapioSemanalResponse> createCardapioSemanal(@RequestBody @Valid CardapioSemanalRequest dto) {
        try {
            CardapioSemanalResponse cardapioSemanalResponse = cardapioSemanalService.saveCardapioSemanal(dto);
            return new ResponseEntity(cardapioSemanalResponse, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity(dto, HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<CardapioSemanalResponse> deleteCardapioSemanal(@PathVariable("id") long id) {
        try {
            CardapioSemanalResponse cardapioSemanalResponse = cardapioSemanalService.deleteCardapioSemanalById(id);
            return new ResponseEntity<>(cardapioSemanalResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/buscarPorID/{id}")
    public ResponseEntity<CardapioSemanalResponse> getByIdCardapioSemanal(@PathVariable("id") long id) {
        CardapioSemanalResponse cardapioSemanalResponse = cardapioSemanalService.findCardapioSemanalById(id);
        if (cardapioSemanalResponse != null) {
            return new ResponseEntity<>(cardapioSemanalResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<List<CardapioSemanalResponse>> getAllCardapioSemanal() {
        try {
            List<CardapioSemanalResponse> cardapioSemanalReponse = cardapioSemanalService.findAllCardapioSemanal();
            if (cardapioSemanalReponse.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(cardapioSemanalReponse, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<CardapioSemanalResponse> updateCardapioSemanal(@PathVariable("id") long id, @RequestBody @Valid CardapioSemanalRequest dto) {
        CardapioSemanalResponse cardapioSemanalResponse = cardapioSemanalService.updateCardapioSemanal(id, dto);
        if (cardapioSemanalResponse != null) {
            return new ResponseEntity<>(cardapioSemanalResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
