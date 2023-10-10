package testesUnitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.sisrest.model.entities.Conta;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TestConta {

	@Mock
	private Conta contaMock = mock(Conta.class);

	
	@Test
	public void testCampusValido() {
		when(contaMock.getCampus()).thenReturn("Campus A");

		assertEquals("Campus A", contaMock.getCampus());
	}
	
	 @Test
	    public void testEmailVali() {
	        Conta contaMock = mock(Conta.class);
	        when(contaMock.getEmail()).thenReturn("joao@example.com");

	        String resultado = contaMock.getEmail();

	        assertEquals("joao@example.com", resultado);
	    }


	    @Test
	    public void testNomeValido() {
	        Conta contaMock = mock(Conta.class);
	        when(contaMock.getNome()).thenReturn("João");

	        String resultado = contaMock.getNome();

	        assertEquals("João", resultado);
	    }
}
