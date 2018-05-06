package modelTest;

import model.Baralho;
import model.Baralho.Carta;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BaralhoTest {

    private Baralho b;

    @Before
    public void setUp() throws Exception {
        b = new Baralho();
    }

    @Test
    public void testBasic() {
        Carta c = (Carta) b.getCartas().peek();
        //Verificando a quantidade certas de cartas por baralho
        assertEquals(52, b.getCartas().size());

        //Verificar se removeu uma carta do baralho
        b.getCartas().pop();
        assertFalse(c.equals(b.getCartas().pop()));
    }

}
