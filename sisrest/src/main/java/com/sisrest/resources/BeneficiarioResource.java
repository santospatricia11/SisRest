package com.sisrest.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sisrest.dto.BeneficiarioDto;
import com.sisrest.model.entities.Beneficiario;
import com.sisrest.repositories.BeneficiarioRepository;
import com.sisrest.services.BeneficiarioService;

import io.micrometer.core.ipc.http.HttpSender.Response;
import jakarta.validation.Valid;

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

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<HttpStatus> deleteBeneficiario(@PathVariable("id") long id) {
		try {
			beneficiarioService.deleteById(id);
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
	
	

//	@PutMapping(value = "/beneficiario/{id}")
//	public ResponseEntity<Beneficiario> updateBeneficiario(@PathVariable("id") long id, @RequestBody Beneficiario beneficiario) {
//		Optional<Beneficiario> informacoesBeneficiario = beneficiarioService.findById(id);
//				
//		if (informacoesBeneficiario.isPresent()) {
//			Beneficiario auxiliar = informacoesBeneficiario.get();
//			
//			auxiliar.setAdmin(false);
//			auxiliar.setMatricula(beneficiario.getMatricula());
//			auxiliar.setEmail(beneficiario.getEmail());
//			auxiliar.setNome(beneficiario.getNome());
//			auxiliar.setSenha(beneficiario.getSenha());
//			return new ResponseEntity<>(beneficiarioService.save(auxiliar),HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return null;
//	}
}
