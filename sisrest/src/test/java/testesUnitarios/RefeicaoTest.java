package testesUnitarios;

import com.sisrest.model.entities.Refeicao;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

class RefeicaoTest {


    private Refeicao refeicao;

    @BeforeEach
    public void setUp() {
        refeicao = mock(Refeicao.class);
    }


}



