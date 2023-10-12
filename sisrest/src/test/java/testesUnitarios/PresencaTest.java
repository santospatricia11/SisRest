package testesUnitarios;

import com.sisrest.model.entities.Beneficiario;
import com.sisrest.model.entities.ListaDiaria;
import com.sisrest.model.entities.Presenca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PresencaTest {
    private Presenca presenca;

    @BeforeEach
    public void setUp() {
        presenca = new Presenca();
    }

    @Test
    public void testBeneficiario() {
        Beneficiario beneficiario = new Beneficiario();
        presenca.setBeneficiario(beneficiario);

        assertEquals(beneficiario, presenca.getBeneficiario());
    }

    @Test
    public void testListaDiaria() {
        ListaDiaria listaDiaria = new ListaDiaria();
        presenca.setListaDiaria(listaDiaria);

        assertEquals(listaDiaria, presenca.getListaDiaria());
    }


}
