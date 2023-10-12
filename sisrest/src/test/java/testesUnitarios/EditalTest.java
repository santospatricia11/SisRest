package testesUnitarios;

import com.sisrest.model.entities.Edital;
import org.junit.jupiter.api.Test;

import java.util.Date;

class EditalTest {
    @Test
    public void testValidadorNome() {
        Edital edital = new Edital();
        edital.setNome("edital");
        ;
    }


    public void testEditalInvalido() {
        Edital edital = new Edital();
        edital.setAno(0);
        edital.setNumero(0);
        edital.setNome("edital");
        edital.setLink(null);
        edital.setVigenteInicio((java.sql.Date) new Date());
        edital.setVigenteFinal((java.sql.Date) new Date());


    }


}
