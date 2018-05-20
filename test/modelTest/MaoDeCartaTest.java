/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelTest;

import java.util.LinkedList;
import model.Baralho;
import model.Carta;
import model.MaoDeCarta;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import util.IStack;
import util.Stack;

/**
 *
 * @author Matheus Nascimento
 */
public class MaoDeCartaTest {
 private MaoDeCarta mao;

    @Before
    public void setUp() throws Exception {
        mao = new MaoDeCarta();
    }

    @Test
    public void testBasic() {   
        assertEquals(0,mao.getPontosEmMao());
        
        Carta c1 = new Carta("99", "Teste");
        //Verifica se está adicionando cartas corretamente
        mao.getCartasNaMao().add(c1);
        assertEquals(c1, mao.getCartasNaMao().getFirst());
        assertEquals(99, mao.getPontosEmMao());
        
        //verifica se é possivel alterar a lista de cartas
        LinkedList cartas = new LinkedList();
        mao.setCartasNaMao(cartas);
        Carta c2 = new Carta("99", "Teste2");
        mao.getCartasNaMao().add(c2);
        assertTrue(mao.getCartasNaMao().equals(cartas));
        assertEquals(cartas, mao.getCartasNaMao());
        
        //Verifica se a pontuação na mão do jogador está sendo alterada corretamente ao receber mais de uma carta
        mao.getCartasNaMao().add(c1);
        assertEquals(198, mao.getPontosEmMao());
        
    }
}
