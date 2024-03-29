package testesUnitarios;

import com.sisrest.model.entities.PedidoDeAcesso;
import com.sisrest.model.entities.RestricaoAlimentar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class RestricaoAlimentarTest {


    private RestricaoAlimentar restricaoAlimentar;

    @BeforeEach
    public void setUp() {
        restricaoAlimentar = new RestricaoAlimentar();
    }

    @Test
    public void testResultadoAnaliseFalse() {
        restricaoAlimentar.resultadoAnaliseFalse();
        assertFalse(restricaoAlimentar.isResultadoAnalise());
    }

    @Test
    public void testResultadoAnaliseTrue() {
        restricaoAlimentar.resultadoAnaliseTrue();
        assertTrue(restricaoAlimentar.isResultadoAnalise());
    }

    @Test
    public void testObservacoesNotNull() {
        restricaoAlimentar.setObservacoes("Observações de teste");
        assertNotNull(restricaoAlimentar.getObservacoes());
    }

    @Test
    public void testAnexo() {
        File anexo = new File("caminho/para/o/arquivo.txt");
        restricaoAlimentar.setAnexo(anexo);
        assertEquals(anexo, restricaoAlimentar.getAnexo());
    }


    @Test
    public void testPedidoDeAcesso() {
        PedidoDeAcesso pedidoDeAcesso = new PedidoDeAcesso();
        restricaoAlimentar.setPedidoDeAcesso(pedidoDeAcesso);
        assertEquals(pedidoDeAcesso, restricaoAlimentar.getPedidoDeAcesso());
    }
}



