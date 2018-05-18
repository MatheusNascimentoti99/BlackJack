/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelTest;

import model.Carta;
import model.Jogador;
import model.MaoDeCarta;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

/**
 *
 * @author Matheus Nascimento
 */
public class MaoDeCartaTest {

    Jogador a;
    MaoDeCarta mao1;
    Carta carta;

    @Before
    public void setUp() throws Exception {
        a = new Jogador("José", "1234abc");
        mao1 = new MaoDeCarta();
        carta = new Carta("♣", "10");
    }

    public void testBasic() {

        assertEquals(true, a.getMao().equals(mao1));

    }
}
