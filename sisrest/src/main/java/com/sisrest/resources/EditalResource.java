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
import com.sisrest.model.entities.Edital;
import com.sisrest.services.ContaService;
import com.sisrest.services.EditalService;

@RestController
@RequestMapping("/api/edital")
public class EditalResource {
	

	@Autowired(required=true)
	private EditalService editalService;

	@PostMapping(value="edital")
	
	public ResponseEntity<Edital> create(@RequestBody Edital edital) {
		try {
			Edital dest = editalService.save(edital);
			return new ResponseEntity<>(dest, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value="/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		try {
			editalService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value="/edital/{id}")
	public ResponseEntity<Edital> getById(@PathVariable("id") long id) {
		Optional<Edital> informacoesEditais = editalService.findById(id);
		if (informacoesEditais.isPresent()) {
			return new ResponseEntity<>(informacoesEditais.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value="/edital")
	
	public ResponseEntity<List<Edital>> getAll() {
		try {
			List<Edital> editals = new ArrayList<Edital>();

			if (editals.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(editals, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value="/edital/{id}")
	public ResponseEntity<Edital> update(@PathVariable("id") long id, @RequestBody Edital edital) {
		Optional<Edital> informacoesEditais = editalService.deleteById(id);
				//contaService.findById(id);
		if (informacoesEditais.isPresent()) {
			Edital edt = informacoesEditais.get();

		
			edt.setNome(edital.getNome());
			edt.setNumero(edital.getNumero());
			edt.setVigenteInicio(edital.getVigenteInicio());
			edt.setVigenteFinal(edital.getVigenteFinal());
			edt.setAno(edital.getAno());
			
			
		

			return new ResponseEntity<>(editalService.save(edt), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
