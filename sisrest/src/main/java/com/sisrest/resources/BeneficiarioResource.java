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

import com.sisrest.dto.beneficiario.BeneficiarioRequest;
import com.sisrest.dto.beneficiario.BeneficiarioResponse;
import com.sisrest.exception.EmailEmUsoException;
import com.sisrest.model.entities.Beneficiario;
import com.sisrest.services.BeneficiarioService;
import com.sisrest.services.convertes.BeneficiarioServiceConvert;

@RestController
@RequestMapping("/api/beneficiario")
public class BeneficiarioResource {

	@Autowired
	private BeneficiarioService beneficiarioService;

	@Autowired
	private BeneficiarioServiceConvert beneficiarioServiceConvert;

	@PostMapping(value = "/criar")
	public ResponseEntity<BeneficiarioResponse> create(@RequestBody @Valid BeneficiarioRequest dto)
			throws EmailEmUsoException {
		Beneficiario beneficiario;
		beneficiario = beneficiarioService.save(dto);
		BeneficiarioResponse responseDto = beneficiarioServiceConvert.beneficiarioToDTO(beneficiario);
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
	public ResponseEntity<BeneficiarioResponse> getById(@PathVariable("id") long id) {
		Beneficiario beneficiario = beneficiarioService.findById(id);
		BeneficiarioResponse responseDto = beneficiarioServiceConvert.beneficiarioToDTO(beneficiario);
		if (responseDto != null) {
			return new ResponseEntity<>(responseDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/buscarTodos")
	public ResponseEntity<List<BeneficiarioResponse>> getAllConta() {
		try {
			List<Beneficiario> beneficiarios = beneficiarioService.findAll();
			List<BeneficiarioResponse> beneficiariosResponse = beneficiarioServiceConvert
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
	public ResponseEntity<BeneficiarioResponse> update(@PathVariable("id") long id,
			@RequestBody @Valid BeneficiarioRequest dto) throws EmailEmUsoException {
		Beneficiario beneficiario = beneficiarioServiceConvert.dtoToBeneficiario(dto);
		beneficiario.setId(id);
		Beneficiario atualizado = beneficiarioService.update(id, beneficiario);
		BeneficiarioResponse responseDto = beneficiarioServiceConvert.beneficiarioToDTO(atualizado);

		if (responseDto != null) {
			return new ResponseEntity<>(responseDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
