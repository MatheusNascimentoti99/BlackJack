/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Control.ControllerFile;
import java.io.File;
import java.util.LinkedList;
import model.Baralho;
import model.Jogador;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import util.IStack;

/**
 *
 * @author Matheus Nascimento
 */
public class ControllerFileTest {

    ControllerFile controleFile;
    String palavra, palavra2;
    String diretorio;
    Jogador jogador, jogador2;
    LinkedList jogadores, jogadores2;
    Baralho baralho;

    @Before
    public void setUp() {
        controleFile = new ControllerFile();
        palavra = "teste";
        diretorio = "Resources/teste.teste";
        jogador = new Jogador("José", "teste123");
        jogadores = new LinkedList();
        baralho = new Baralho(1);
    }

    @Test
    public void salvarArquivo() throws Exception {
        controleFile.salvarArquivo(palavra, diretorio);
        File arquivo = new File(diretorio);
        assertEquals(true, arquivo.exists());
        arquivo.delete();
    }

    @Test
    public void lerArquivo() throws Exception {
        controleFile.salvarArquivo(palavra, diretorio);
        palavra2 = (String) controleFile.lerArquivo(diretorio);
        assertTrue(palavra.equals(palavra2));
        File arquivo = new File(diretorio);
        arquivo.delete();
    }

    @Test
    public void recuperarJogadores() throws Exception {
        jogadores.add(jogador);
        controleFile.salvarArquivo(jogadores, diretorio);
        jogadores2 = (LinkedList) controleFile.recuperarJogadores();
        jogador2 = (Jogador) jogadores.getLast();
        assertTrue(jogador.equals(jogador2));

        controleFile.salvarArquivo(jogadores, diretorio);
        jogadores2 = (LinkedList) controleFile.recuperarJogadores();
        jogador2 = (Jogador) jogadores.getLast();
        assertTrue(jogador.equals(jogador2));

        assertEquals(0, jogador.compareTo(jogador2));
        File arquivo = new File(diretorio);
        arquivo.delete();
    }

    @Test
    public void recuperarCartas() throws Exception {
        assertEquals(52, baralho.getCartas().size());
        controleFile.salvarArquivo(baralho.getCartas(), diretorio);
        baralho.setCartas((IStack) controleFile.lerArquivo(diretorio));
        assertEquals(52, baralho.getCartas().size());
        File arquivo = new File(diretorio);
        arquivo.delete();
    }

}

/**
 *
 * @author Matheus Nascimento
 */
