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

import com.sisrest.dto.contaBeneficiario.ContaBeneficiarioRequest;
import com.sisrest.dto.contaBeneficiario.ContaBeneficiarioResponse;
import com.sisrest.exception.EmailEmUsoException;
import com.sisrest.model.entities.ContaBeneficiario;
import com.sisrest.services.ContaBeneficiarioService;
import com.sisrest.services.convertes.ContaBeneficiarioServiceConvert;

@RestController
@RequestMapping("/api/contaBeneficiario")
public class ContaBeneficiarioResource {

	@Autowired
	private ContaBeneficiarioService beneficiarioService;

	@Autowired
	private ContaBeneficiarioServiceConvert beneficiarioServiceConvert;

	@PostMapping(value = "/criar")
	public ResponseEntity<ContaBeneficiarioResponse> create(@RequestBody @Valid ContaBeneficiarioResponse dto)
			throws EmailEmUsoException {
		ContaBeneficiario beneficiario;
		beneficiario = beneficiarioService.save(dto);
		ContaBeneficiarioResponse responseDto = beneficiarioServiceConvert.beneficiarioToDTO(beneficiario);
		return new ResponseEntity(responseDto, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		try {
			beneficiarioService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/buscarPorID/{id}")
	public ResponseEntity<ContaBeneficiarioResponse> getById(@PathVariable("id") long id) {
		ContaBeneficiario beneficiario = beneficiarioService.findById(id);
		ContaBeneficiarioResponse responseDto = beneficiarioServiceConvert.beneficiarioToDTO(beneficiario);
		if (responseDto != null) {
			return new ResponseEntity<>(responseDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/buscarTodos")
	public ResponseEntity<List<ContaBeneficiarioResponse>> getAllConta() {
		try {
			List<ContaBeneficiario> beneficiarios = beneficiarioService.findAll();
			List<ContaBeneficiarioResponse> beneficiariosResponse = beneficiarioServiceConvert
					.usersToResponses(beneficiarios);
			if (beneficiariosResponse.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(beneficiariosResponse, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<ContaBeneficiarioResponse> update(@PathVariable("id") long id,
			@RequestBody @Valid ContaBeneficiarioRequest dto) throws EmailEmUsoException {
		ContaBeneficiario beneficiario = beneficiarioServiceConvert.dtoToBeneficiario(dto);
		beneficiario.setId(id);
		ContaBeneficiario atualizado = beneficiarioService.update(id, beneficiario);
		ContaBeneficiarioResponse responseDto = beneficiarioServiceConvert.beneficiarioToDTO(atualizado);

		if (responseDto != null) {
			return new ResponseEntity<>(responseDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
