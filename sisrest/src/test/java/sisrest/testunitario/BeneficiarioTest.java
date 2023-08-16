package sisrest.testunitario;

import static org.junit.jupiter.api.Assertions.*;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.xml.bind.Validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.sisrest.model.entities.Beneficiario;
import com.sisrest.model.entities.PedidoDeAcesso;

class BeneficiarioTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	 @Test
	    public void testCreateBeneficiario() {
	        Beneficiario beneficiario = new Beneficiario();

	        assertNotNull(beneficiario);
	        assertEquals(0, beneficiario.getId());
	        assertTrue(beneficiario.isAtivo());
	        assertEquals(0L, beneficiario.getCPF()); 
	        assertNull(beneficiario.getPrograma());
	        assertNull(beneficiario.getSituacao());
	        assertNotNull(beneficiario.getPedidosDeAcesso());
	        assertNotNull(beneficiario.getEdital());
	        assertNotNull(beneficiario.getContaEstudante());
	    }
	  @Test
	    public void testInvalidCPF() {
	        Beneficiario beneficiario = new Beneficiario();
	        beneficiario.setCPF(123456789); 

			/*
			 * ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			 * Validator validator = factory.getValidator();
			 * Set<ConstraintViolation<Beneficiario>> violations =
			 * validator.validate(beneficiario);
			 * 
			 * assertFalse(violations.isEmpty());
			 */
	    }

    @Test
    public void testAddPedidoDeAcesso() {
        Beneficiario beneficiario = new Beneficiario();
        PedidoDeAcesso pedido = new PedidoDeAcesso();
        
        beneficiario.getPedidosDeAcesso().add(pedido);
        pedido.setBeneficiario(beneficiario);

        assertEquals(1, beneficiario.getPedidosDeAcesso().size());
        assertEquals(beneficiario, pedido.getBeneficiario());
    }

	@Test
	public void testRemovePedidoDeAcesso() {
		Beneficiario beneficiario = new Beneficiario();
		PedidoDeAcesso pedido = new PedidoDeAcesso();

		beneficiario.getPedidosDeAcesso().add(pedido);
		beneficiario.getPedidosDeAcesso().remove(pedido);

		assertEquals(0, beneficiario.getPedidosDeAcesso().size());
		assertNull(pedido.getBeneficiario());
	}
}
