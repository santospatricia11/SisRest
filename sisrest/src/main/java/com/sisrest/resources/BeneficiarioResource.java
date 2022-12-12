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

import com.sisrest.dto.BeneficiarioDto;
import com.sisrest.model.entities.Beneficiario;
import com.sisrest.repositories.BeneficiarioRepository;
import com.sisrest.services.BeneficiarioService;

@RestController
@RequestMapping("/api/beneficiario")
public class BeneficiarioResource {

	@Autowired
	private BeneficiarioRepository beneficiarioRepository;

	@Autowired
	private BeneficiarioDto beneficiarioDto;

	@Autowired
	private BeneficiarioService beneficiarioService;

	public Beneficiario save(Beneficiario beneficiario) {
		return beneficiarioRepository.save(beneficiario);
	}

	@PostMapping(value = "beneficiario")
	public ResponseEntity<Beneficiario> createBeneficiario(@RequestBody Beneficiario beneficiario) {
		try {
			Beneficiario destino = (Beneficiario) beneficiarioService.save(beneficiario);
			return new ResponseEntity<>(destino, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/{matricula}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("matricula") long matricula) {
		try {
			beneficiarioService.deleteById(matricula);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/beneficiario")
	public ResponseEntity<List<Beneficiario>> getAllBeneficiario() {
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

	@PutMapping(value = "/beneficiario/{matricula}")
	public ResponseEntity<Beneficiario> updateConta(@PathVariable("matricula") long matricula, @RequestBody Beneficiario beneficiario) {
		Optional<Beneficiario> informacoesBeneficiario = beneficiarioService.findById(matricula);
				
		if (informacoesBeneficiario.isPresent()) {
			Beneficiario auxiliar = informacoesBeneficiario.get();
			
			auxiliar.setAdmin(false);
			auxiliar.setMatricula(beneficiario.getMatricula());
			auxiliar.setEmail(beneficiario.getEmail());
			auxiliar.setNome(beneficiario.getNome());
			auxiliar.setSenha(beneficiario.getSenha());
			return new ResponseEntity<>(beneficiarioService.save(auxiliar),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return null;
	}
}
