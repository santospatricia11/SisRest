package testesUnitarios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.validation.ValidationUtils;

import com.sisrest.model.entities.Beneficiario;
import com.sisrest.model.entities.Inativacao;

class InativacaoTest {

	 @Test
	    public void testInativacaoValida() {
	        Inativacao inativacao = new Inativacao();
	        inativacao.setInicio(new Date());
	        inativacao.setTermino(new Date());
	        inativacao.setMotivo("Motivo válido");

	        Beneficiario beneficiario = new Beneficiario();
	        inativacao.setBeneficiario(beneficiario);

	    }
	 
	 @Test
	    public void testMotivoNulo() {
	        Inativacao inativacao = new Inativacao();
	        inativacao.setInicio(new Date());
	        inativacao.setTermino(new Date());
	        inativacao.setMotivo(null); 

	        Beneficiario beneficiario = new Beneficiario();
	        inativacao.setBeneficiario(beneficiario);

	    }
}
