package com.sisrest.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sisrest.dto.BeneficiarioDto;
import com.sisrest.model.entities.Beneficiario;
import com.sisrest.model.entities.Conta;
import com.sisrest.repositories.BeneficiarioRepository;
import com.sisrest.services.BeneficiarioService;
import com.sisrest.services.ContaService;

import io.micrometer.core.ipc.http.HttpSender.Response;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/beneficiario")
public class BeneficiarioResource {
	@Autowired(required=true)
	private BeneficiarioService beneficiarioService;

	@PostMapping(value="beneficiario")
	
	public ResponseEntity<Beneficiario> create(@RequestBody Beneficiario beneficiario) {
		try {
			Beneficiario dest =beneficiarioService.save(beneficiario);
			
			return new ResponseEntity<>(dest, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value="/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		try {
			beneficiarioService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value="/beneficiario/{id}")
	public ResponseEntity<Beneficiario> getDetinoById(@PathVariable("id") long id) {
		Optional<Beneficiario> informacoesContas = beneficiarioService.findById(id);
		if (informacoesContas.isPresent()) {
			return new ResponseEntity<>(informacoesContas.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value="/beneficiario")
	
	public ResponseEntity<List<Beneficiario>> getAllConta() {
		try {
			List<Beneficiario> beneficiarios = new ArrayList<Beneficiario>();

			if (beneficiarios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(beneficiarios, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value="/beneficiarios/{id}")
	public ResponseEntity<Beneficiario> update(@PathVariable("id") long id, @RequestBody Beneficiario beneficiario) {
		Optional<Beneficiario> informacoesBeneficiarios = beneficiarioService.findById(id);
		if (informacoesBeneficiarios.isPresent()) {
			Beneficiario bene = informacoesBeneficiarios.get();

			bene.setNome(beneficiario.getNome());
			bene.setEmail(beneficiario.getEmail());
			bene.setMatricula(beneficiario.getMatricula());
			bene.setAdmin(false);
			bene.setId(beneficiario.getId());
			
		

			return new ResponseEntity<>(beneficiarioService.save(bene), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
