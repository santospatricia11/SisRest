package com.sisrest.beneficiario;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import javax.validation.Validator;

import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;

import com.sisrest.model.entities.Beneficiario;
import com.sisrest.repositories.BeneficiarioRepository;

@Testable
@DisplayName("Beneficiario")
@TestClassOrder(org.junit.jupiter.api.ClassOrderer.OrderAnnotation.class)
class BeneficiarioTest {
	@Autowired
	private static Validator validator;
	private Beneficiario beneficiario;
	private BeneficiarioRepository repository;
	
	@Test
	
	@DisplayName("╯°□°）╯")
	void testNameCharacters() {
	}


}
