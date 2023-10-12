package testesUnitarios;

import com.sisrest.model.entities.ContaEstudante;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaEstudanteTest {

    @Test
    public void testContaEstudanteValida() {
        ContaEstudante contaEstudante = new ContaEstudante();
        contaEstudante.setMatricula(12345);
        contaEstudante.setCurso("Engenharia");
        assertNotNull(contaEstudante);
        assertTrue(contaEstudante.getMatricula() > 0);
        assertNotNull(contaEstudante.getCurso());
        assertFalse(contaEstudante.getCurso().isEmpty());
    }

    @Test
    public void testContaEstudanteInvalida() {
        ContaEstudante contaEstudante = new ContaEstudante();
        contaEstudante.setMatricula(0);
        contaEstudante.setCurso("");
        assertNotNull(contaEstudante);
        assertTrue(contaEstudante.getMatricula() <= 0);
        assertNotNull(contaEstudante.getCurso());
        assertTrue(contaEstudante.getCurso().isEmpty());
    }

    @Test
    public void testCursoNulo() {
        ContaEstudante contaEstudante = new ContaEstudante();
        contaEstudante.setMatricula(12345);
        contaEstudante.setCurso(null);
        assertNotNull(contaEstudante);
        assertTrue(contaEstudante.getMatricula() > 0);
        assertNull(contaEstudante.getCurso());
    }
}
