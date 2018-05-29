package model;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import util.IStack;
import util.Stack;

public class BaralhoTest {

    private Baralho baralho;
    private IStack b;

    @Before
    public void setUp() throws Exception {
        baralho = new Baralho(1);
        b = new Stack();
    }

    @Test
    public void testBasic() {
        Carta c = (Carta) baralho.getCartas().peek();
        //Verificando a quantidade certas de cartas por baralho
        assertEquals(52, baralho.getCartas().size());

        //Verificar se removeu uma carta do baralho
        baralho.getCartas().pop();
        assertFalse(c.equals(baralho.getCartas().pop()));

        //Verificar se manteu a mesma quantidade de cartas.
        baralho.embaralhar();
        assertEquals(50, baralho.getCartas().size());

        assertFalse(baralho.getCartas().isEmpty());

        baralho.setCartas(b);
        assertFalse(baralho.getCartas().equals(c));

        //Verificar os getters e setters das cartas.
        c.setValue("TesteValor");
        assertEquals("TesteValor", c.getValue());
        c.setNaipe("TesteNaipe");
        assertEquals("TesteNaipe", c.getNaipe());

        baralho.resetaBaralho();
        assertEquals(52, baralho.getCartas().size());
        baralho.embaralhar();
        assertEquals(52, baralho.getCartas().size());

    }

}
