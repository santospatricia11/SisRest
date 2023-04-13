package com.sisrest.resources;

import java.util.List;

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
import com.sisrest.exception.EmailEmUsoException;
import com.sisrest.services.ContaEstudanteService;

@RestController
@RequestMapping("/api/contaEstudante")
public class ContaEstudanteResource {

	@Autowired
	private ContaEstudanteService contaEstudanteService;

	@PostMapping(value = "/criar")
	public ResponseEntity<ContaEstudanteResponse> createContaEstudante(@RequestBody @Valid ContaEstudanteRequest dto) {
		try {
			ContaEstudanteResponse contaEstudanteResponse = contaEstudanteService.save(dto);
			return new ResponseEntity(contaEstudanteResponse, HttpStatus.CREATED);
		} catch (EmailEmUsoException ex) {
			return new ResponseEntity(dto, HttpStatus.CONFLICT);
		}

	}

	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<ContaEstudanteResponse> delete(@PathVariable("id") long id) {
		try {
			ContaEstudanteResponse contaEstudanteResponse = contaEstudanteService.deleteById(id);
			return new ResponseEntity<>(contaEstudanteResponse, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/buscarPorID/{id}")
	public ResponseEntity<ContaEstudanteResponse> getById(@PathVariable("id") long id) {
		ContaEstudanteResponse contaEstudanteResponse = contaEstudanteService.findById(id);
		if (contaEstudanteResponse != null) {
			return new ResponseEntity<>(contaEstudanteResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/buscarTodos")
	public ResponseEntity<List<ContaEstudanteResponse>> getAllConta() {
		try {
			List<ContaEstudanteResponse> contaEstudanteReponse = contaEstudanteService.findAll();
			if (contaEstudanteReponse.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(contaEstudanteReponse, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<ContaEstudanteResponse> update(@PathVariable("id") long id,
			@RequestBody @Valid ContaEstudanteRequest dto){
		ContaEstudanteResponse contaEstudanteResponse = contaEstudanteService.update(id, dto);
		if (contaEstudanteResponse != null) {
			return new ResponseEntity<>(contaEstudanteResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
