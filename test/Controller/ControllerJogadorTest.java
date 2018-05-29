/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Control.ControllerJogador;
import java.util.Iterator;
import java.util.LinkedList;
import model.Jogador;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *<b>ControllerJogadorTest<b/> alterará as informações do arquivo, então recomenda-se não fazer esse teste de forma desnecessária.
 * @author Usuário 01
 */
public class ControllerJogadorTest {
    
    ControllerJogador controlerJogador;
    LinkedList jogadores;
    LinkedList jogadores2;
    Jogador jogador1, jogador2, jogador3;
    boolean test;
    
    @Before
    public void setUp(){
        controlerJogador = new ControllerJogador();
        jogadores = new LinkedList();
        jogador1 = new Jogador("Antonio", "123");
        jogador2 = new Jogador("Jose", "1345");
        jogador3 = new Jogador("Fernando", "fernando123");
        
    }
    
    /**
     *Test of verificacao method, of class ControllerJogador.
     */
    @Test
    public void testVerificacaoLogin() {
        
        jogadores.add(jogador1);
        jogadores.add(jogador2);
        jogadores.add(jogador3);
        
        test = controlerJogador.verificacao("Antonio", "123", jogadores);
        assertEquals(true, test);
        test = controlerJogador.verificacao("Fernando", "1345", jogadores);
        assertEquals(false, test);
        test = controlerJogador.verificacao("Jose", "1345", jogadores);
        assertEquals(true, test);
        test = controlerJogador.verificacao("Jose", "fernando123", jogadores);
        assertEquals(false, test);
        
        jogadores.removeAll(jogadores);
        assertEquals(0, jogadores.size());
    }

    /**
     * Test of verificacao method, of class ControllerJogador.
     */
    @Test
    public void testVerificacaoJogadorDuplicado() {
        
        test = controlerJogador.verificacao("Maicon", jogadores);
        assertEquals(false, test);
        jogadores.add(jogador1);
        test = controlerJogador.verificacao("Antonio", jogadores);
        assertEquals(true, test);
        jogadores.add(jogador2);
        test = controlerJogador.verificacao("Francisco", jogadores);
        assertEquals(false, test);
        jogadores.add(jogador3);
        test = controlerJogador.verificacao("Fernando", jogadores);
        assertEquals(true, test);
        
        jogadores.removeAll(jogadores);
        assertEquals(0, jogadores.size());
    }

    /**
     * Test of recuperarJogador method, of class ControllerJogador.
     */
    @Test
    public void testRecuperarJogador() {
        
        jogadores.add(jogador1);
        jogadores.add(jogador2);
        jogadores.add(jogador3);
        
        controlerJogador.setListaJogadores(jogadores);
        Jogador jogador = (Jogador) controlerJogador.recuperarJogador("Antonio", "2334");
        assertSame(jogador, null);
        Jogador proximoJogador = (Jogador) controlerJogador.recuperarJogador("Fernando", "fernando123");
        assertSame(proximoJogador, jogador3);
        Jogador outroJogador = (Jogador) controlerJogador.recuperarJogador("Antonio", "123");
        assertSame(outroJogador, jogador1);
        Jogador maisUmJogador = (Jogador) controlerJogador.recuperarJogador("Jose", "jose123");
        assertSame(maisUmJogador, null);
        Jogador ultimoJogador = (Jogador) controlerJogador.recuperarJogador("Jose", "1345");
        assertSame(ultimoJogador, jogador2);
        
        jogadores.removeAll(jogadores);
        assertEquals(0, jogadores.size());
        
    }

    /**
     * Test of cadastrar method, of class ControllerJogador.
     */
    @Test
    public void testCadastrar() throws Exception {
        
        jogadores.add(jogador1);
        jogadores.add(jogador2);
        jogadores.add(jogador3);
        
        controlerJogador.setListaJogadores(jogadores);
        
        test = controlerJogador.cadastrar("Antonio", "abc");
        assertEquals(false, test);
        test = controlerJogador.cadastrar("Guilherme", "123a");    
        assertEquals(true, test);
        test = controlerJogador.cadastrar("Glauber", "gs23");
        assertEquals(true, test);
        test = controlerJogador.cadastrar("Guilherme", "23gu");
        assertEquals(false, test);
        
        jogadores.removeAll(jogadores);
        assertEquals(0, jogadores.size());
    }

    /**
     * Test of loginJogador method, of class ControllerJogador.
     */
    @Test
    public void testLoginJogador() throws Exception {
        
        jogadores.add(jogador1);
        jogadores.add(jogador2);
        jogadores.add(jogador3);
        
        controlerJogador.setListaJogadores(jogadores);
        
        test = controlerJogador.loginJogador("Antonio", "abc");
        assertEquals(false, test);
        test = controlerJogador.loginJogador("Antonio", "123");
        assertEquals(true, test);
        test = controlerJogador.loginJogador("Guilherme", "abc");
        assertEquals(false, test);
        test = controlerJogador.loginJogador("Fernando", "fernando123");
        assertEquals(true, test);
        test = controlerJogador.loginJogador("Fernando", "1267");
        assertEquals(false, test);
        
        jogadores.removeAll(jogadores);
        assertEquals(0, jogadores.size());
        
    }

    /**
     * Test of mostrarJogadores method, of class ControllerJogador.
     */
    @Test
    public void testMostrarJogadores() {
        
        jogadores.add(jogador1);
        jogadores.add(jogador2);
        jogadores.add(jogador3);
        
        controlerJogador.setListaJogadores(jogadores);
        
        Iterator iterador = controlerJogador.mostrarJogadores();
        assertTrue(iterador.hasNext());
        Jogador jogador = (Jogador) iterador.next();
        assertSame(jogador, jogador1);
        assertTrue(iterador.hasNext());
        Jogador outroJogador = (Jogador) iterador.next();
        assertSame(outroJogador, jogador2);
        assertTrue(iterador.hasNext());
        Jogador ultimoJogador = (Jogador) iterador.next();
        assertSame(ultimoJogador, jogador3);
        assertFalse(iterador.hasNext());
        
    }
    
}
