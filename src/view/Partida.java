package view;

import Control.ControllerJogador;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import model.Baralho;
import model.Carta;
import model.Croupier;
import model.Jogador;

public class Partida {

    private Baralho baralho;
    Croupier croupier;
    ControllerJogador controleUser = new ControllerJogador();

    public Partida(Baralho baralho) {
        this.baralho = baralho;
        croupier = new Croupier();
    }

    public void imprimirCartas() {
        System.out.println("Deseja imprmir cartas(desordenadas ordenadas):");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        switch (input) {
            case "desordenadas":
                System.out.println("\n \n Restante das cartas: ");
                baralho.imprimeBaralho();
                break;
            case "ordenadas":
                System.out.println("\n \n Ordenado:");
                baralho.ordenarCartas();
                baralho.imprimeBaralho();

        }
    }

    public void partida(ControllerJogador controleUser) throws Exception {
        System.out.println("-------------------------Login----------------------------------  \n");
        controleUser.loginJogador();

        baralho.embaralhar();
        System.out.println("-------------------------Início da partida----------------------------------");

        Iterator iteradorCarta1 = controleUser.getJogadoresNaPartida().iterator();
        while (iteradorCarta1.hasNext()) {
            Jogador jogador = (Jogador) iteradorCarta1.next();
            Carta carta1 = croupier.DarCarta(baralho);
            jogador.getMao().getCartasNaMao().add(carta1);
        }

        croupier.getMao().getCartasNaMao().add(croupier.DarCarta(baralho));

        Iterator iteradorCarta2 = controleUser.getJogadoresNaPartida().iterator();
        while (iteradorCarta2.hasNext()) {
            Jogador jogador = (Jogador) iteradorCarta2.next();
            Carta carta2 = croupier.DarCarta(baralho);
            jogador.getMao().getCartasNaMao().add(carta2);
        }

        croupier.getMao().getCartasNaMao().add(croupier.DarCarta(baralho));

        Iterator iterador = controleUser.getJogadoresNaPartida().iterator();
        while (iterador.hasNext()) {
            Jogador jogador = (Jogador) iterador.next();
            if (jogador.getMao().getPontosEmMao() == 21) {
                System.out.println("Você tem um BlackJack");
                jogador.setFlagBlackJack(true);
            }
        }

        if (croupier.getMao().getPontosEmMao() == 21) {
            croupier.setFlagBlackJack(true);
        }

        String escolha2;
        boolean flag = false;
        Iterator BlackJack = controleUser.getJogadoresNaPartida().iterator();
        while (BlackJack.hasNext()) {
            Jogador jogador = (Jogador) BlackJack.next();
            if (croupier.getFlagBlackJack() == true || jogador.getFlagBlackJack() == true) {

                if (jogador.getFlagBlackJack() == true && croupier.getFlagBlackJack() == true) {
                    System.out.println("Você e o croupier tem um BlackJack, empataram");
                    System.out.println("Cartas de " + jogador.getUser());
                    jogador.pontuacao(1);
                    jogador.getMao().mostrarCartas();

                } else if (jogador.getFlagBlackJack() == false && croupier.getFlagBlackJack() == true) {
                    System.out.println("Você perdeu, o Croupier tem um BlackJack !!");
                    jogador.pontuacao(0);
                    System.out.println("Cartas de " + jogador.getUser());
                    jogador.getMao().mostrarCartas();

                } else if (jogador.getFlagBlackJack() == true) {
                    System.out.println("[" + jogador.getUser() + "] Você tem um BlackJack !!");
                    jogador.pontuacao(3);
                    jogador.setPartidaVencidas(1);
                    System.out.println("Cartas de " + jogador.getUser());
                    System.out.print("Pontos na mão: " + jogador.getMao().getPontosEmMao());
                    jogador.getMao().mostrarCartas();

                }
            } else {

                do {
                    System.out.print(jogador.getUser());
                    System.out.println(", suas cartas:");
                    jogador.getMao().mostrarCartas();
                    System.out.print("Pontos na mão: " + jogador.getMao().getPontosEmMao() + "\t");
                    System.out.print("Carta vísivel do Croupier: ");
                    System.out.println(((Carta) croupier.getMao().getCartasNaMao().getLast()).toString());

                    if (jogador.pedirCarta() == true && jogador.getMao().getPontosEmMao() <= 21) {
                        flag = true;
                        Carta carta = croupier.DarCarta(baralho);
                        jogador.getMao().getCartasNaMao().add(carta);

                        if (jogador.getMao().getPontosEmMao() == 21) {

                            System.out.println("[" + jogador.getUser() + "] Você tem 21 pontos na mão");
                            jogador.getMao().mostrarCartas();
                            flag = false;

                        } else if (jogador.getMao().getPontosEmMao() > 21) {
                            System.out.println("[" + jogador.getUser() + "] Você ultrapassou os 21 pontos na mão");
                            jogador.pontuacao(0);
                            flag = false;
                            System.out.println("Cartas de " + jogador.getUser());
                            System.out.print("Pontos na mão: " + jogador.getMao().getPontosEmMao() + "\t");
                            jogador.getMao().mostrarCartas();

                        }
                    } else {
                        flag = false;
                    }

                } while (flag == true);
                System.out.println("\n");
            }
        }
        
        if (croupier.getFlagBlackJack() == false) {
            LinkedList softCarta = croupier.getMao().getCartasNaMao();
            while (!softCarta.isEmpty()) {
                Carta carta = (Carta) softCarta.remove();
                if (carta.getValue().equals("Ás")) {
                    croupier.getMao().getCartasNaMao().add(croupier.DarCarta(baralho));
                }
            }
        }

        while (croupier.getMao().getPontosEmMao() < 17) {
            croupier.getMao().getCartasNaMao().add(croupier.DarCarta(baralho));
        }
        Boolean croupierEstourou = false;
        if (croupier.getMao().getPontosEmMao() > 21) {
            croupierEstourou = true;
            System.out.println("O croupier estourou, todos jogadores ganham pontos");
            Iterator iteradorPontos = controleUser.getJogadoresNaPartida().iterator();
            while (iteradorPontos.hasNext()) {
                Jogador jogador = (Jogador) iteradorPontos.next();
                jogador.pontuacao(3);
                jogador.setPartidaVencidas(1);
            }
        }

        Iterator ganhadores = controleUser.getJogadoresNaPartida().iterator();
        while (ganhadores.hasNext() && !croupierEstourou) {
            Jogador jogador = (Jogador) ganhadores.next();
            if (jogador.getMao().getPontosEmMao() <= 21 && jogador.getFlagBlackJack() == false && croupier.getMao().getPontosEmMao()
                    <= 21 && croupier.getFlagBlackJack() == false) {
                if (jogador.getMao().getPontosEmMao() > croupier.getMao().getPontosEmMao()) {
                    System.out.print(jogador.getUser());
                    System.out.println(", Você ganhou !!");
                    System.out.println("Suas Cartas");
                    jogador.getMao().mostrarCartas();
                    jogador.pontuacao(3);
                    jogador.setPartidaVencidas(1);

                } else if (jogador.getMao().getPontosEmMao() < croupier.getMao().getPontosEmMao()) {
                    System.out.print(jogador.getUser());
                    System.out.println(", Você perdeu !!");
                    System.out.println("Suas cartas ");
                    jogador.getMao().mostrarCartas();
                    jogador.pontuacao(0);

                } else {
                    System.out.print(jogador.getUser());
                    System.out.println(", Você empatou !!");
                    System.out.println("Suas cartas");
                    jogador.pontuacao(1);
                    jogador.getMao().mostrarCartas();

                }
                System.out.println("");
            }
            
        }
        System.out.println("Cartas do Crupier:");
        croupier.getMao().mostrarCartas();

        imprimirCartas();
    }

    public Baralho getBaralho() {
        return baralho;
    }

    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
    }

}
