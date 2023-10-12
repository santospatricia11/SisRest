package testesUnitarios;

import com.sisrest.model.entities.Beneficiario;
import com.sisrest.model.entities.Inativacao;
import org.junit.jupiter.api.Test;

import java.util.Date;

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
