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

import com.sisrest.dto.edital.EditalRequest;
import com.sisrest.dto.edital.EditalResponse;

import com.sisrest.services.EditalService;
import com.sisrest.services.convertes.EditalServiceConvert;

@RestController
@RequestMapping("/api/edital")
public class EditalResource {

	@Autowired(required = true)
	private EditalService editalService;

	@Autowired
	private EditalServiceConvert editalServiceConvert;

	@PostMapping(value = "/criar")
	public ResponseEntity<EditalResponse> createEdital(@RequestBody @Valid EditalRequest dto) {
		EditalResponse responseDto = editalService.save(dto);
		return new ResponseEntity(responseDto, HttpStatus.CREATED);

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

	@GetMapping(value = "/buscarPorID/{id}")
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

	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<EditalResponse> update(@PathVariable("id") long id, @RequestBody EditalRequest dto) {
		EditalResponse responseDto = editalService.update(id, dto);
		if (responseDto != null) {
			return new ResponseEntity<>(responseDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}
