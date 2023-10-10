package testesUnitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import com.sisrest.model.entities.Beneficiario;

public class BeneficiarioTest {
	 private Beneficiario beneficiario;

	    @BeforeEach
	    public void setUp() {
	        beneficiario = new Beneficiario();
	    }
	    @Test
	    public void testAtivo() {
	        Beneficiario beneficiario = new Beneficiario();
	        beneficiario.setAtivo(true);
	        assertTrue(beneficiario.isAtivo());

	        beneficiario.setAtivo(false);
	        assertFalse(beneficiario.isAtivo());
	    }
	 
	    
	    @Test
	    public void testCPF() {
	        long cpf = 12345678901L;
	        beneficiario.setCPF(cpf);

	        assertEquals(cpf, beneficiario.getCPF());
	    }
}
