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

	@DeleteMapping(value = "/{email}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("email") String email) {
		try {
			contaService.deleteById(email);

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



	
	@PutMapping(value = "/conta/{email}")
	
	public ResponseEntity<Conta> updateConta(@PathVariable("email") String email, @RequestBody Conta conta) {
		Optional<Conta> informacoesConta = contaService.findById(email);
		if (informacoesConta.isPresent()) {
			Conta con = informacoesConta.get();

			con.setNome(conta.getNome());
			con.setEmail(conta.getEmail());
			con.setAdmin(conta.isAdmin());
			con.setSenha(conta.getSenha());

			return new ResponseEntity<>(contaService.save(con), HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return null;
	}
}
