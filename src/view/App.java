/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Control.ControllerFileJogadores;
import Control.ControllerPartida;
import Control.ControllerUser;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import model.Baralho;
import model.Carta;
import model.Croupier;
import model.Jogador;

/**
 *
 * @author Matheus Nascimento
 */
public class App {

    public static void main(String args[]) throws IOException, Exception {
        ControllerPartida controlePartida = new ControllerPartida();
        ControllerUser controleUser = new ControllerUser();
        String escolha;
        Croupier croupier = new Croupier();
        do {
            System.out.println("Digite 1 para Cadastrar jogador ");
            System.out.println("Digite 2 para iniciar uma partida");
            System.out.println("Digite 3 para sair do Jogo");
            Partida partida;
            Scanner input = new Scanner(System.in);
            escolha = input.next();

            if (escolha.equals("1")) {
                controleUser.cadastrar();
            } else if (escolha.equals("2")) {
                partida = controlePartida.escolherPartida();
                partida.partida();
                partida.getBaralho().embaralhar();
                System.out.println("Embaralhado");

                Iterator iteradorCarta1 = controleUser.getJogadoresNaPartida().iterator();
                while (iteradorCarta1.hasNext()) {
                    Jogador jogador = (Jogador) iteradorCarta1.next();
                    Carta carta1 = croupier.DarCarta(partida.getBaralho());
                    jogador.getMao().getCartasNaMao().add(carta1);
                }

                croupier.getMaoDeCarta().getCartasNaMao().add(croupier.DarCarta(partida.getBaralho()));

                Iterator iteradorCarta2 = controleUser.getJogadoresNaPartida().iterator();
                while (iteradorCarta2.hasNext()) {
                    Jogador jogador = (Jogador) iteradorCarta2.next();
                    Carta carta2 = croupier.DarCarta(partida.getBaralho());
                    jogador.getMao().getCartasNaMao().add(carta2);
                }

                croupier.getMaoDeCarta().getCartasNaMao().add(croupier.DarCarta(partida.getBaralho()));

              
                Iterator iterador = controleUser.getJogadoresNaPartida().iterator();
                while (iterador.hasNext()) {
                    Jogador jogador = (Jogador) iterador.next();
                    if (jogador.getMao().getPontosEmMao() == 21) {
                        System.out.println("Você tem um BlackJack");
                        jogador.setFlagBlackJack(true);
                    }
                }

                if (croupier.getMaoDeCarta().getPontosEmMao() == 21) {
                    croupier.setFlagBlackJack(true);
                }
                
                String escolha2;
                boolean flag;
                Iterator BlackJack = controleUser.getJogadoresNaPartida().iterator();
                while (BlackJack.hasNext()) {
                    Jogador jogador = (Jogador) BlackJack.next();
                    if(croupier.getFlagBlackJack() == true || jogador.getFlagBlackJack() == true){ 
                        
                        if (jogador.getFlagBlackJack() == true && croupier.getFlagBlackJack() == true) {
                            System.out.println("Você e o croupier tem um BlackJack, empataram");
                        }else if (jogador.getFlagBlackJack() == false && croupier.getFlagBlackJack() == true) {
                            System.out.println("Você perdeu, o Croupier tem um BlackJack !!");
                            jogador.pontuacao(-10);
                        }else{
                            System.out.println("Você ganhou, BlackJack !!");
                            jogador.pontuacao(10);
                            jogador.setPartidaVencidas(1);
                        }
                    }else{
                        
                         do {
                            System.out.println("Deseja carta jogador ? Digite sim ou não");
                            System.out.println("Suas cartas");
                            jogador.getMao().mostrarCartas();
                            System.out.println("Pontos na mão: " + jogador.getMao().getPontosEmMao());
                            escolha2 = input.nextLine();
                            flag = jogador.pedirCarta(escolha);

                            if (flag == true) {
                                Carta carta = croupier.DarCarta(partida.getBaralho());
                                jogador.getMao().getCartasNaMao().add(carta);

                                if (jogador.getMao().getPontosEmMao() > 21) {
                                    System.out.println("Você ultrapassou os 21 pontos na mão");
                                    jogador.pontuacao(-10);
                                    flag = false;
                                }
                                if (jogador.getMao().getPontosEmMao() == 21) {
                                    System.out.println(" Você tem 21 pontos na mão");
                                    flag = false;
                                }
                            }
                        } while (flag == true);
                    }
                }
                
                
                    
                    if (croupier.getFlagBlackJack() == false){
                        Iterator softCarta = croupier.getMaoDeCarta().getCartasNaMao().iterator();
                        while (softCarta.hasNext()){
                            Carta carta = (Carta) softCarta.next();
                            if (carta.getValue().equals("Ás")){
                                croupier.getMaoDeCarta().getCartasNaMao().add(croupier.DarCarta(partida.getBaralho()));
                            }
                        }
                    }

                    while (croupier.getMaoDeCarta().getPontosEmMao() < 17) {
                        croupier.getMaoDeCarta().getCartasNaMao().add(croupier.DarCarta(partida.getBaralho()));
                    }

                    if (croupier.getMaoDeCarta().getPontosEmMao() > 21) {
                        System.out.println("O croupier estourou, todos jogadores ganham pontos");
                        Iterator iteradorPontos = controleUser.getJogadoresNaPartida().iterator();
                        while (iteradorPontos.hasNext()) {
                            Jogador jogador = (Jogador) iteradorPontos.next();
                            jogador.pontuacao(10);
                        }
                    }
                

                Iterator ganhadores = controleUser.getJogadoresNaPartida().iterator();
                while (ganhadores.hasNext()) {
                    Jogador jogador = (Jogador) ganhadores.next();
                    if (jogador.getMao().getPontosEmMao() <= 21 && jogador.getFlagBlackJack() == false && croupier.getMaoDeCarta().getPontosEmMao()
                            <= 21 && croupier.getFlagBlackJack() == false) {
                        if (jogador.getMao().getPontosEmMao() > croupier.getMaoDeCarta().getPontosEmMao()) {
                            System.out.println("Você ganhou !!");
                            System.out.println("Suas Cartas");
                            jogador.getMao().mostrarCartas();
                            jogador.pontuacao(10);
                            jogador.setPartidaVencidas(1);
                        } else if (jogador.getMao().getPontosEmMao() < croupier.getMaoDeCarta().getPontosEmMao()) {
                            System.out.println("Você perdeu !!");
                            System.out.println("Suas cartas ");
                            jogador.getMao().mostrarCartas();
                            jogador.pontuacao(-10);
                        } else {
                            System.out.println("Você empatou !!");
                            System.out.println("Suas cartas");
                            jogador.getMao().mostrarCartas();
                        }
                    }
                }
                System.out.println("\n \n Restante das cartas ");
                partida.getBaralho().imprimeBaralho();
                System.out.println("\n \n Ordenado");
                partida.getBaralho().ordenarCartas();
                partida.getBaralho().imprimeBaralho();
            }

        } while (!escolha.equals("3"));

    }
}
