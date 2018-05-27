/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Croupier;
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
public class CroupierTest {
    Croupier b;
    @Before
    public void setUp() throws Exception {
        b = new Croupier();     
    }
   
     @Test
     public void testBasic(){
         
       assertEquals(0, b.getPontuacao());
       assertEquals(0, b.getPartidaVencidas());
       assertEquals(false, b.getFlagBlackJack());
       
       b.setPartidaVencidas(1);
       b.pontuacao(3);
       b.setFlagBlackJack(true);
       

       assertEquals(1, b.getPartidaVencidas());
       assertEquals(3, b.getPontuacao());
       assertEquals(true, b.getFlagBlackJack());
       
       Croupier c = new Croupier();
       
       assertFalse(c.equals(b));
      
       c.setPartidaVencidas(1);
       c.pontuacao(3);
       c.setFlagBlackJack(true);
       
       assertTrue(c.equals(b));
       
     }

}
