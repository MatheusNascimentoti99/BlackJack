/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Control.ControllerJogador;
import Control.ControllerPartida;
import model.Baralho;
import model.Carta;
import model.Croupier;
import model.Partida;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Usuário 01
 */
public class ControllerPartidaTest {
    
    Baralho baralho1;
    Partida partida;
    boolean test;
    ControllerPartida controlerPartida;
    
   @Before
    public void setUp(){
        controlerPartida = new ControllerPartida();
    }


    /**
     * Test of baralhosDaPartida method, of class ControllerPartida.
     */
    @Test
    public void testBaralhosDaPartida() {
                
        test = controlerPartida.baralhosDaPartida(1);
        assertEquals(true, test);
        test = controlerPartida.baralhosDaPartida(3);
        assertEquals(true, test);
        test = controlerPartida.baralhosDaPartida(5);
        assertEquals(true, test);
        
    }

    /**
     * Test of quantBaralho method, of class ControllerPartida.
     */
    @Test
    public void testQuantBaralho() {
    
        int retorno = controlerPartida.quantBaralho("simples");
        assertEquals(2, retorno);
        retorno = controlerPartida.quantBaralho("total");
        assertEquals(-1, retorno);
        retorno = controlerPartida.quantBaralho("regular");
        assertEquals(4, retorno);
        retorno = controlerPartida.quantBaralho("longa");
        assertEquals(8, retorno);
        retorno = controlerPartida.quantBaralho("personalizada");
        assertEquals(0, retorno);
        retorno = controlerPartida.quantBaralho("Inacabavel");
        assertEquals(-1, retorno);

    }

    /**
     * Test of darCartas method, of class ControllerPartida.
     */
    @Test
    public void testDarCartas() {
        
        
    }

    /**
     * Test of temBlackJack method, of class ControllerPartida.
     */
    @Test
    public void testTemBlackJack() {
        
        
    }

    /**
     * Test of blackJackCroupier method, of class ControllerPartida.
     */
    @Test
    public void testBlackJackCroupier() {
        partida = new Partida(baralho1);
        Croupier croupier = new Croupier();
        controlerPartida.setPartida(partida);
        controlerPartida.getPartida().setCroupier(croupier);
        assertEquals(0, controlerPartida.getPartida().getCroupier().getMao().getPontosEmMao());
        controlerPartida.getPartida().getCroupier().getMao().setPontosEmMao(21);
        controlerPartida.blackJackCroupier();
        
        //tal método sempre conta os pontos na mão para verificar se fez blackJack ou não, não importa se foi feito um setPontos alterando para 21
        assertEquals(false, controlerPartida.getPartida().getCroupier().getFlagBlackJack());
        controlerPartida.getPartida().getCroupier().getMao().setPontosEmMao(20);
    }
    
}
