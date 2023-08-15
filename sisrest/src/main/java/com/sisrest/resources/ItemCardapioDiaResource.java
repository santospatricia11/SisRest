package com.sisrest.resources;

import com.sisrest.dto.itemCardapioDia.ItemCardapioDiaRequest;
import com.sisrest.dto.itemCardapioDia.ItemCardapioDiaResponse;
import com.sisrest.services.ItemCardapioDiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/itemCardapioDia")
public class ItemCardapioDiaResource {

    @Autowired(required = true)
    private ItemCardapioDiaService itemCardapioDiaService;


    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<ItemCardapioDiaResponse> deleteItemCardapioDia(@PathVariable("id") long id) {
        try {
            ItemCardapioDiaResponse itemCardapioDiaResponse = itemCardapioDiaService.deleteItemCardapioDiaById(id);
            return new ResponseEntity<>(itemCardapioDiaResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/buscarPorID/{id}")
    public ResponseEntity<ItemCardapioDiaResponse> getByIdItemCardapioDia(@PathVariable("id") long id) {
        ItemCardapioDiaResponse itemCardapioDiaResponse = itemCardapioDiaService.findItemCardapioDiaById(id);
        if (itemCardapioDiaResponse != null) {
            return new ResponseEntity<>(itemCardapioDiaResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<List<ItemCardapioDiaResponse>> getAllItemCardapioDia() {
        try {
            List<ItemCardapioDiaResponse> itemCardapioDiaReponse = itemCardapioDiaService.findAllItemCardapioDia();
            if (itemCardapioDiaReponse.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(itemCardapioDiaReponse, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<ItemCardapioDiaResponse> updateItemCardapioDia(@PathVariable("id") long id, @RequestBody @Valid ItemCardapioDiaRequest dto) {
        ItemCardapioDiaResponse itemCardapioDiaResponse = itemCardapioDiaService.updateItemCardapioDia(id, dto);
        if (itemCardapioDiaResponse != null) {
            return new ResponseEntity<>(itemCardapioDiaResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
