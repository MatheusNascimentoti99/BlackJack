/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import model.Baralho;
import model.Carta;
import model.Jogador;
import model.Partida;

/**
 *
 * @author Matheus Nascimento
 */
public class ControllerPartida {
    Partida partida;

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
   

    public Boolean baralhosDaPartida(int escolha) {                                                                       
            Baralho baralho = new Baralho(escolha);
            partida = new Partida(baralho);
            return true;
        
    }

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
    
     public void darCartas(ControllerJogador controleJogador){
        //Distribuindo a 1° carta aos jogadores e ao croupier.
        Iterator iteradorCarta1 = controleJogador.getJogadoresNaPartida().iterator();
        while (iteradorCarta1.hasNext()) {
            Jogador jogador = (Jogador) iteradorCarta1.next();
            Carta carta1 = partida.getCroupier().DarCarta(partida.getBaralho());
            jogador.getMao().getCartasNaMao().add(carta1);
             partida.getCroupier().getMao().getCartasNaMao().add(partida.getCroupier().DarCarta(partida.getBaralho()));
        }
    }
     
     public void temBlackJack(ControllerJogador controleJogador){
         // Verificando se algum jogador tem um blackJack.
        Iterator iterador = controleJogador.getJogadoresNaPartida().iterator();
        while (iterador.hasNext()) {
            Jogador jogador = (Jogador) iterador.next();
            if (jogador.getMao().getPontosEmMao() == 21) {
                jogador.setFlagBlackJack(true);
            }
        }
     }
     public void blackJackCroupier(){
         // Condicional para verificar se o croupier tem um blackJack.
        if (partida.getCroupier().getMao().getPontosEmMao() == 21) {
            partida.getCroupier().setFlagBlackJack(true);
        }
     }
     
     



}
