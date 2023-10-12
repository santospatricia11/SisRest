package testesUnitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sisrest.model.entities.CardapioSemanal;
import com.sisrest.model.entities.Edital;

class CardapioSemanalTest {

	 private CardapioSemanal cardapioSemanal;

	    @BeforeEach
	    public void setUp() {
	        cardapioSemanal = new CardapioSemanal();
	    }

	    @Test
	    public void testIsAtualFalse() {
	        cardapioSemanal.isAtualTrue();
	        assertTrue(cardapioSemanal.isAtual());

	        cardapioSemanal.isAtualFalse();
	        assertFalse(cardapioSemanal.isAtual());
	    }
	    
	    @Test
	    public void testIsAtualTrue() {
	        cardapioSemanal.isAtualTrue();
	        assertTrue(cardapioSemanal.isAtual());
	    }

	    @Test
	    public void testIsAtualDefault() {
	        assertFalse(cardapioSemanal.isAtual());
	    }

	    @Test
	    public void testSetAndGetEdital() {
	        Edital edital = new Edital();
	        cardapioSemanal.setEdital(edital);

	        assertEquals(edital, cardapioSemanal.getEdital());
	    }
	    @Test
	    public void testSequenciaSemanal() {
	        short sequencia = 5;
	        cardapioSemanal.setSequenciaSemanal(sequencia);

	        assertEquals(sequencia, cardapioSemanal.getSequenciaSemanal());
	    }


}
