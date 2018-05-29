/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matheus Nascimento
 */
public class PartidaTest {

    Partida partida;
    Baralho baralho;

    @Before
    public void setUp() throws Exception {
        baralho = new Baralho(1);
        partida = new Partida(baralho);

    }

    @Test
    public void testBasic() {

        //Verificar a saida dos dados
        assertEquals("croupier", partida.getCroupier().getUser());
        assertEquals(52, partida.getBaralho().getCartas().size());

        partida.setBaralho(new Baralho(2));
        assertFalse(partida.getBaralho().getCartas().size() == 52);

    }
}
