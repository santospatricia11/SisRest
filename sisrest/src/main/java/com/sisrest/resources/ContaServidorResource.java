package com.sisrest.resources;

import java.util.List;

import javax.persistence.Convert;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sisrest.dto.contaBeneficiario.ContaEstudanteRequest;
import com.sisrest.dto.contaBeneficiario.ContaEstudanteResponse;
import com.sisrest.dto.contaServidor.ContaServidorRequest;
import com.sisrest.dto.contaServidor.ContaServidorResponse;
import com.sisrest.exception.EmailEmUsoException;
import com.sisrest.model.entities.ContaServidor;
import com.sisrest.services.ContaEstudanteService;
import com.sisrest.services.ContaServidorService;
import com.sisrest.services.convertes.ContaEstudanteServiceConvert;
import com.sisrest.services.convertes.ContaServidorServiceConcert;

@RestController
@RequestMapping("/api/contaServidor")
public class ContaServidorResource {

	@Autowired
	private ContaServidorService contaServidorService;
	@Autowired
	private ContaServidorServiceConcert contaServidorServiceConcert;

	@PostMapping(value = "/criar")

	public ResponseEntity save(@RequestBody @Valid ContaServidorRequest dto) {
		try {
			if (contaServidorService.existsEmail(dto.getEmail())) {
				throw new IllegalArgumentException("O cadastro não pode ser concluído. Email já registrado!");
			}
			ContaServidor contaServidor = contaServidorServiceConcert.dtoToContaServidor(dto);
			// passEncoder.encryptPassword(contaServidor);
			contaServidor = contaServidorService.save(contaServidor);

			ContaServidorResponse dtoToReturn = contaServidorServiceConcert.contaServidorToDTO(contaServidor);

			return new ResponseEntity(dtoToReturn, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	/*
	 * public ResponseEntity<ContaServidorResponse>
	 * createContaServidor(@RequestBody @Valid ContaServidorRequest dto) { try {
	 * ContaServidorResponse contaServidorResponse = contaServidorService.save(dto);
	 * return new ResponseEntity(contaServidorResponse, HttpStatus.CREATED); } catch
	 * (EmailEmUsoException ex) { return new ResponseEntity(dto,
	 * HttpStatus.CONFLICT); }
	 * 
	 * }
	 */
	
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

	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<ContaServidorResponse> delete(@PathVariable("id") long id) {
		try {
			ContaServidorResponse contaServidorResponse = contaServidorService.deleteById(id);
			return new ResponseEntity<>(contaServidorResponse, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
