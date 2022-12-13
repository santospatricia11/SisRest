package com.sisrest.resources;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.sisrest.dto.ContaDto;
import com.sisrest.model.entities.Conta;
import com.sisrest.repositories.ContaRepository;
import com.sisrest.services.ContaService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/conta")
public class ContaResource {
	@Autowired
	private ContaRepository contaRepository;

	@Autowired

	private ContaDto contaDto;

	@Autowired
	private ContaService contaService;
	
	

	public ContaResource(ContaRepository contaRepository) {
		super();
		this.contaRepository = contaRepository;
	}

	public Conta save(Conta conta) {
		return contaRepository.save(conta);

	}

	@PostMapping(value = "conta")

	public ResponseEntity<Conta> createPessoa(@RequestBody Conta conta) {
		try {
			Conta dest = (Conta) contaService.save(conta);

			return new ResponseEntity<>(dest, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		try {
			contaService.deleteById(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/conta")
	public ResponseEntity<List<Conta>> getAllConta() {
		try {
			List<Conta> contas = new ArrayList<Conta>();

			if (contas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(contas, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



	
	@PutMapping(value = "/conta/{id}")

	public ResponseEntity<Object> updateConta(@RequestBody Conta conta, @PathVariable long id) {

		Optional<ContaRepository> contOptional = contaRepository.findById(id);

		if (( (List<Conta>) contaRepository).isEmpty())
			return ResponseEntity.notFound().build();

		conta.setId(id);
		
		contaRepository.save(conta);

		return ResponseEntity.noContent().build();
	}
}
