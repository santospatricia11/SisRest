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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sisrest.dto.beneficiario.BeneficiarioRequest;
import com.sisrest.dto.beneficiario.BeneficiarioResponse;
import com.sisrest.dto.edital.EditalResponse;
import com.sisrest.exception.EmailEmUsoException;
import com.sisrest.model.entities.Beneficiario;
import com.sisrest.model.entities.ContaBeneficiario;
import com.sisrest.model.entities.Edital;
import com.sisrest.repositories.BeneficiarioRepository;
import com.sisrest.services.BeneficiarioService;
import com.sisrest.services.ContaBeneficiarioService;
import com.sisrest.services.EditalService;
import com.sisrest.services.InativacaoService;
import com.sisrest.services.convertes.BeneficiarioServiceConvert;

@RestController
@RequestMapping("/api/beneficiario")
public class BeneficiarioResource {

	@Autowired
	private EditalService editalService;

	@Autowired
	private BeneficiarioServiceConvert beneficiarioServiceConvert;

	@Autowired
	private BeneficiarioService beneficiarioService;

	@Autowired
	private ContaBeneficiarioService contaBeneficiarioService;

	@GetMapping("/{id}")
	public ResponseEntity<BeneficiarioResponse> getById(@PathVariable Long id) {
		BeneficiarioResponse beneficiarioDTO = beneficiarioService.getById(id);
		return ResponseEntity.ok(beneficiarioDTO);
	}

	@PostMapping("/{criar}")
	public ResponseEntity<BeneficiarioResponse> create(@RequestBody BeneficiarioResponse beneficiarioDTO,
			@RequestParam("edital") Edital edital,
			@RequestParam("contaBeneficiario") ContaBeneficiario contaBeneficiario) {

		beneficiarioDTO.setEdital(edital);
		beneficiarioDTO.setContaBeneficiario(contaBeneficiario);

		BeneficiarioResponse novoBeneficiario = beneficiarioService.save(beneficiarioDTO, edital, contaBeneficiario);

		return ResponseEntity.status(HttpStatus.CREATED).body(novoBeneficiario);
	}

	// PUT
	@PutMapping("{id}")

	// DELETE
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		try {
			beneficiarioService.deleteById(id);

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
