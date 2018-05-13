/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelTest;

import model.Baralho;
import model.Jogador;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matheus Nascimento
 */
public class JogadorTest {

    Jogador a;

    @Before
    public void setUp() throws Exception {
        a = new Jogador("José", "1234abc");
    }

    @Test
    public void testBasic() {
        Jogador b = new Jogador("Marcos", "123456");
        
        //Verificar a saida dos dados
        assertEquals("José",a.getUser());
        assertEquals("1234abc", a.getPasseword());
        assertEquals(0, a.getPontuacao());
        assertEquals(0, a.getPartidaVencidas());
        
        
        //Verificar os requisitos para considerar um jogador diferente do outro
        assertFalse(a.equals(b));
        
        assertEquals(0, a.compareTo(b));
        b.setPontuacao(50);
        assertEquals(-1, a.compareTo(b));
        
        b.setUser("José");
        b.setPasseword("1234abc");
        assertTrue(a.equals(b));
        
        a.setPontuacao(10);
        assertTrue(a.equals(b));
    }
}
