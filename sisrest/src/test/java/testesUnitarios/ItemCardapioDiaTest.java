package testesUnitarios;

import com.sisrest.model.entities.CardapioSemanal;
import com.sisrest.model.entities.ItemCardapioDia;
import com.sisrest.model.enums.DiaDaSemana;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ItemCardapioDiaTest {

    private ItemCardapioDia itemCardapioDia;
    private CardapioSemanal cardapioSemanal;

    @BeforeEach
    public void setUp() {
        itemCardapioDia = new ItemCardapioDia();
        cardapioSemanal = new CardapioSemanal();
    }

    @Test
    public void testId() {
        assertNull(itemCardapioDia.getId());
        Long id = 1L;
        itemCardapioDia.setId(id);
        assertEquals(id, itemCardapioDia.getId());
    }

    @Test
    public void testDiaDaSemana() {
        assertNull(itemCardapioDia.getDiaDaSemana());
        DiaDaSemana diaDaSemana = DiaDaSemana.SEGUNDA;
        itemCardapioDia.setDiaDaSemana(diaDaSemana);
        assertEquals(diaDaSemana, itemCardapioDia.getDiaDaSemana());
    }

    @Test
    public void testCardapioSemanal() {
        assertNull(itemCardapioDia.getCardapioSemanal());
        itemCardapioDia.setCardapioSemanal(cardapioSemanal);
        assertEquals(cardapioSemanal, itemCardapioDia.getCardapioSemanal());
    }

}
