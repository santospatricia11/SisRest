package testesUnitarios;

import com.sisrest.model.entities.AcessoDiaRefeicao;
import com.sisrest.model.entities.Beneficiario;
import com.sisrest.model.entities.PedidoDeAcesso;
import com.sisrest.model.entities.RestricaoAlimentar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PedidoDeAcessoTest {

    private PedidoDeAcesso pedidoDeAcesso;

    @BeforeEach
    public void setUp() {
        pedidoDeAcesso = new PedidoDeAcesso();
    }

    @Test
    public void testSolicitadoEm() {
        assertNull(pedidoDeAcesso.getSolicitadoEm());
        Date dataSolicitacao = new Date();
        pedidoDeAcesso.setSolicitadoEm(dataSolicitacao);
        assertEquals(dataSolicitacao, pedidoDeAcesso.getSolicitadoEm());
    }

    @Test
    public void testBeneficiario() {
        assertNull(pedidoDeAcesso.getBeneficiario());
        Beneficiario beneficiario = new Beneficiario();
        pedidoDeAcesso.setBeneficiario(beneficiario);
        assertEquals(beneficiario, pedidoDeAcesso.getBeneficiario());
    }

    @Test
    public void testRestricoesAlimentares() {
        RestricaoAlimentar restricao = new RestricaoAlimentar();
        pedidoDeAcesso.getRestricoesAlimentares().add(restricao);

        assertTrue(pedidoDeAcesso.getRestricoesAlimentares().contains(restricao));

        pedidoDeAcesso.getRestricoesAlimentares().remove(restricao);

        assertFalse(pedidoDeAcesso.getRestricoesAlimentares().contains(restricao));
    }

    @Test
    public void testAcessosDiaRefeicao() {
        AcessoDiaRefeicao acesso = new AcessoDiaRefeicao();
        pedidoDeAcesso.getAcessosDiaRefeicao().add(acesso);

        assertTrue(pedidoDeAcesso.getAcessosDiaRefeicao().contains(acesso));

        pedidoDeAcesso.getAcessosDiaRefeicao().remove(acesso);

        assertFalse(pedidoDeAcesso.getAcessosDiaRefeicao().contains(acesso));
    }
}
