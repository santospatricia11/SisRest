package testesUnitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sisrest.model.entities.ContaServidor;

class ContaServidorTest {


    private ContaServidor contaServidor;

    @BeforeEach
    public void setUp() {
        contaServidor = new ContaServidor();
    }

    @Test
    public void testMatriculaSIAPE() {
        long matricula = 12345;
        contaServidor.setMatriculaSIAPE(matricula);

        assertEquals(matricula, contaServidor.getMatriculaSIAPE());
    }
    
    @Test
    public void testIsAdminTrue() {
        contaServidor.isAdminTrue();
        assertTrue(contaServidor.isAdmin());
    }

    @Test
    public void testIsAdminFalse() {
        contaServidor.isAdminFalse();
        assertFalse(contaServidor.isAdmin());
    }
    @Test
    public void testIsAdminDefault() {
        assertFalse(contaServidor.isAdmin());
    }
}
