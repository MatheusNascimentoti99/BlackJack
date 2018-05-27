/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelTest;

import model.Baralho;
import model.Carta;
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
        
        //Verificar a saida dos dados
        assertEquals("José",a.getUser());
        assertEquals("1234abc", a.getPasseword());
        assertEquals(0, a.getPontuacao());
        assertEquals(0, a.getPartidaVencidas());
        
        
        //Verificar os requisitos para considerar um jogador diferente do outro
        Jogador b = new Jogador("Marcos", "123456");
        assertFalse(a.equals(b));
        
        assertEquals(0, a.compareTo(b));
        b.pontuacao(10);
        assertEquals(-1, a.compareTo(b));
        //Verificar os setters do jogador
        b.setUser("José");
        b.setPasseword("1234abc");
        assertTrue(a.equals(b));

        //Verificar se jogador tem mão de carta e se as cartas estão sendo inseridas corretamente
        Carta cart1 = new Carta("teste", "teste");
        a.getMao().getCartasNaMao().add(cart1);
        assertTrue(a.getMao().getCartasNaMao().getFirst().equals(cart1));
        
        
        assertEquals(false, a.getFlagBlackJack());
        a.setFlagBlackJack(true);
        assertEquals(true, a.getFlagBlackJack());
        
        assertEquals(true,a.pedirCarta("pedir"));
        assertEquals(false, a.pedirCarta("parar"));
       
    }
}
