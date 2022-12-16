package com.sisrest.resources;

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

import com.sisrest.model.entities.Conta;
import com.sisrest.services.ContaService;

@RestController
@RequestMapping("/api/conta")
public class ContaResource {

	@Autowired(required = true)
	private ContaService contaService;
	
	//Não funcionou!
	@PostMapping(value = "/conta")
	public ResponseEntity<Conta> create(@RequestBody Conta conta) {
		try {
			Conta dest = contaService.save(conta);
			return new ResponseEntity<>(dest, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/conta/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		try {
			contaService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/conta/{id}")
	public ResponseEntity<Conta> getDetinoById(@PathVariable("id") long id) {
		Conta informacoesContas = contaService.findById(id);
		if (informacoesContas != null) {
			return new ResponseEntity<>(informacoesContas, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Não funcionou!
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
	//Não funcionou!
	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<Conta> update(@PathVariable("id") long id, @RequestBody Conta conta) {
		Conta informacoesContas = contaService.findById(id);
		if (informacoesContas != null) {

			return new ResponseEntity<>(contaService.save(informacoesContas), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
