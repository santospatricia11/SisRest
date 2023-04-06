package com.sisrest.resources;

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

	
	@Autowired
	private ContaBeneficiarioService contaBeneficiarioService;
	
	
	//SAVE
	@PostMapping
	public ResponseEntity save(@RequestBody @Valid BeneficiarioResponse dto) {
		try {
			if (dto.getId() == 0) {
				throw new IllegalStateException("beneficiarioId cannot be null");
			}
			
			Long beneficiarioId = dto.getId();
			Beneficiario beneficiario =  beneficiarioService.findById(beneficiarioId);
						
			if(beneficiario == null) {
				throw new IllegalStateException(String.format("Cound not find any beneficiario with id=%1", beneficiarioId));
			}
			
			Beneficiario entity = beneficiarioServiceConvert.dtoToBeneficiario(dto);
			
		
			
		} catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return null;
	}
	
}
