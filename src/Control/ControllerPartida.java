/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.Iterator;
import model.Baralho;
import model.Carta;
import model.Jogador;
import model.Partida;

/**
 * A classe <b>ControllerPartida</b> faz o gerenciamento da partida.
 *
 * @author Matheus Nascimento e Elvis Serafim
 * @since May 2018
 * @version 1.0
 */
public class ControllerPartida {

    Partida partida;

    /**
     * Método para retorno da partida a ser gerenciada.
     *
     * @return Uma Partida.
     */
    public Partida getPartida() {
        return partida;
    }

    /**
     * Método para designar uma nova partida para ser gerenciada.
     *
     * @param partida Nova Partida.
     */
    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    /**
     * Método booleano que cria um baralho com a quantidade escolhida e cria uma
     * partida com o baralho.
     *
     * @param escolha quantidade de baralhos.
     * @return booleano, true.
     */
    public Boolean baralhosDaPartida(int escolha) {
        Baralho baralho = new Baralho(escolha);
        partida = new Partida(baralho);
        return true;

    }

    /**
     * Método para indicar a quantidade de baralhos da partida.
     *
     * @param nomePartida escolha do modo da partida.
     * @return quantidade de baralhos pelo modo da partida.
     */
    public int quantBaralho(String nomePartida) {
        switch (nomePartida) {
            case "simples":
                return 2;
            case "regular":
                return 4;
            case "longa":
                return 8;
            case "personalizada":
                return 0;

        }
        return -1;
    }

    /**
     * Método para distribuir as cartas aos jogadores e ao croupier.
     *
     * @param controleJogador ControllerJogador, onde contém a lista de
     * jogadores na partida.
     */
    public void darCartas(ControllerJogador controleJogador) {
        Iterator iteradorCarta1 = controleJogador.getJogadoresNaPartida().iterator();
        while (iteradorCarta1.hasNext()) {
            Jogador jogador = (Jogador) iteradorCarta1.next();
            Carta carta1 = partida.getCroupier().DarCarta(partida.getBaralho());
            jogador.getMao().getCartasNaMao().add(carta1);

        }
        partida.getCroupier().getMao().getCartasNaMao().add(partida.getCroupier().DarCarta(partida.getBaralho()));
    }

    /**
     * Método para verificar se algum jogador tem um blackJack.
     *
     * @param controleJogador ControllerJogador, onde contém a lista de
     * jogadores na partida.
     */
    public void temBlackJack(ControllerJogador controleJogador) {
        // Verificando se algum jogador tem um blackJack.
        Iterator iterador = controleJogador.getJogadoresNaPartida().iterator();
        while (iterador.hasNext()) {
            Jogador jogador = (Jogador) iterador.next();
            if (jogador.getMao().getPontosEmMao() == 21) {
                jogador.setFlagBlackJack(true);
            }
        }
    }

    /**
     * Método para verificar se o croupier da partida tem um blackJack.
     */
    public void blackJackCroupier() {
        // Condicional para verificar se o croupier tem um blackJack.
        if (partida.getCroupier().getMao().getPontosEmMao() == 21) {
            partida.getCroupier().setFlagBlackJack(true);
        }
    }

}
