package testesUnitarios;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.sisrest.model.entities.Edital;

import static org.junit.Assert.*;

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
