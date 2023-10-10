package testesUnitarios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sisrest.model.entities.ListaDiaria;
import com.sisrest.model.entities.Refeicao;

class ListadiariaTest {

	private ListaDiaria listaDiaria;
    private Refeicao refeicao;

    @BeforeEach
    public void setUp() {
        listaDiaria = new ListaDiaria();
        refeicao = new Refeicao();
    }
    @Test
    public void testId() {
        assertNull(listaDiaria.getId()); 
        Long id = 1L;
        listaDiaria.setId(id);
        assertEquals(id, listaDiaria.getId());
    }
    
    @Test
    public void testRefeicao() {
        assertNull(listaDiaria.getRefeicao()); 
        listaDiaria.setRefeicao(refeicao);
        assertEquals(refeicao, listaDiaria.getRefeicao());
    }

}
