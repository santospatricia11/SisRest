package com.sisrest.resources;

import java.util.List;

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

import com.sisrest.dto.BeneficiarioRequest;
import com.sisrest.dto.BeneficiarioResponse;
import com.sisrest.model.entities.Beneficiario;
import com.sisrest.services.BeneficiarioService;
import com.sisrest.services.ContaService;
import com.sisrest.services.convertes.BeneficiarioServiceConvert;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/beneficiario")
public class BeneficiarioResource {

	@Autowired
	private BeneficiarioService beneficiarioService;

	@Autowired
	private BeneficiarioServiceConvert beneficiarioServiceConvert;

	@PostMapping(value = "/criar")

	public ResponseEntity<BeneficiarioResponse> create(@RequestBody @Valid BeneficiarioRequest dto) {

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
	public ResponseEntity<Beneficiario> getDetinoById(@PathVariable("id") long id) {
		Beneficiario informacoesContas = beneficiarioService.findById(id);
		if (informacoesContas != null) {
			return new ResponseEntity<>(informacoesContas, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/buscarTodos")
	public ResponseEntity<List<Beneficiario>> getAllConta() {
		try {
			List<Beneficiario> beneficiarios = beneficiarioService.findAll();
			if (beneficiarios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(beneficiarios, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<Beneficiario> update(@PathVariable("id") long id, @RequestBody Beneficiario beneficiario) {
		Beneficiario informacoesBeneficiarios = beneficiarioService.findById(id);
		if (informacoesBeneficiarios != null) {
			return new ResponseEntity<>(informacoesBeneficiarios, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
