package view;

import Control.ControllerJogador;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import model.Baralho;
import model.Carta;
import model.Croupier;
import model.Jogador;

/**
 *
 * @author Matheus Nascimento
 */
public class Partida {

    private Baralho baralho;
    private Croupier croupier;
    private ControllerJogador controleUser;
    
    public Croupier getCroupier() {
        return croupier;
    }

    public void setCroupier(Croupier croupier) {
        this.croupier = croupier;
    }

    public ControllerJogador getControleUser() {
        return controleUser;
    }

    public void setControleUser(ControllerJogador controleUser) {
        this.controleUser = controleUser;
    }
    

    public Partida(Baralho baralho) {
        this.baralho = baralho;
        croupier = new Croupier();
    }

    public Baralho getBaralho() {
        return baralho;
    }

    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
    }

    // Inicio da partida.
    public void partida(ControllerJogador controleUser) throws Exception {

        

       


        

        

        
        boolean flag = false; 
        //´Percorrendo a lista de jogadores para saber se algum jogador tem blackJack. 
        Iterator BlackJack = controleUser.getJogadoresNaPartida().iterator();
        while (BlackJack.hasNext()) {
            Jogador jogador = (Jogador) BlackJack.next();

            // Somente entrará se o jogador ou o croupier tiverem um blackJack.
            if (croupier.getFlagBlackJack() == true || jogador.getFlagBlackJack() == true) {

                // Se o croupier e o jogador tiverem um blackJack, eles empatam e o jogador ganha 1 ponto.
                if (jogador.getFlagBlackJack() == true && croupier.getFlagBlackJack() == true) {
                    System.out.println("Você e o croupier tem um BlackJack, empataram");
                    System.out.println("Cartas de " + jogador.getUser());
                    jogador.pontuacao(1);
                    jogador.getMao().mostrarCartas();

                    // Se somente o croupier tiver um blackJack, o jogador perde a partida.
                } else if (jogador.getFlagBlackJack() == false && croupier.getFlagBlackJack() == true) {
                    System.out.println("Você perdeu, o Croupier tem um BlackJack !!");
                    jogador.pontuacao(0);
                    System.out.println("Cartas de " + jogador.getUser());
                    jogador.getMao().mostrarCartas();

                    // Se somente o jogador tiver um blackJack, o jogador ganha a partida e ganha 3 pontos.
                } else if (jogador.getFlagBlackJack() == true) {
                    System.out.println("[" + jogador.getUser() + "] Você tem um BlackJack !");
                    jogador.pontuacao(3);
                    jogador.setPartidaVencidas(1);
                    System.out.println("Cartas de " + jogador.getUser());
                    System.out.println("Pontos na mão: " + jogador.getMao().getPontosEmMao());
                    jogador.getMao().mostrarCartas();

                }
                System.out.println("");
            } else { // Se o jogador e nem o croupier tiverem um blackJack.

                do {
                    System.out.print(jogador.getUser());
                    System.out.println(", suas cartas:");
                    jogador.getMao().mostrarCartas();
                    System.out.print("Pontos na mão: " + jogador.getMao().getPontosEmMao() + "\t");
                    System.out.print("Carta vísivel do Croupier: ");
                    System.out.println(((Carta) croupier.getMao().getCartasNaMao().getLast()).toString());

//                   // Se o método pedir carta de jogador retorna true, ou seja o jogador deseja mais carta e tem menos ou 21 pontos,
//                   // É adicionado mais uma carta na mão do jogador.
                    if (jogador.pedirCarta() == true && jogador.getMao().getPontosEmMao() <= 21) {
                        flag = true;
                        Carta carta = croupier.DarCarta(baralho);
                        jogador.getMao().getCartasNaMao().add(carta);

                        // Se o jogador tem 21 pontos na mão, o laço termina e o jogador não poderá mais pedir carta.
                        if (jogador.getMao().getPontosEmMao() == 21) {

                            System.out.println("[" + jogador.getUser() + "] Você tem 21 pontos na mão");
                            jogador.getMao().mostrarCartas();
                            flag = false;

                            // Se o jogador ultrapassar os 21 pontos na mão, ele perde a partida.
                        } else if (jogador.getMao().getPontosEmMao() > 21) {
                            System.out.println("[" + jogador.getUser() + "] Você ultrapassou os 21 pontos na mão");
                            jogador.pontuacao(0);
                            flag = false;
                            System.out.println("Cartas de " + jogador.getUser());
                            System.out.println("Pontos na mão: " + jogador.getMao().getPontosEmMao() + "\t");
                            jogador.getMao().mostrarCartas();

                        }
                    } else {
                        flag = false;
                    }

                } while (flag == true);
                System.out.println("\n");
            }
        }

        // Se o croupier tem um soft, ou seja um Ás e uma carta entre 2 e 9 na mão, é adicionado mais uma carta a sua mão.
        if (croupier.getFlagBlackJack() == false) {
            Iterator softCarta = croupier.getMao().getCartasNaMao().iterator();
            while (!softCarta.hasNext()) {
                if (softCarta.next().equals("Ás")) {
                    croupier.getMao().getCartasNaMao().add(croupier.DarCarta(baralho));
                }
            }
        }

        // Enquanto o croupier tiver menos que 17 pontos, será adicionado cartas á mão dele.
        while (croupier.getMao().getPontosEmMao() < 17) {
            croupier.getMao().getCartasNaMao().add(croupier.DarCarta(baralho));
        }
        Boolean croupierEstourou = false;

        // Se o croupier ultrapassou os 21 pontos, estourou, todos jogadores vencem a partida e ganham 3 pontos.
        if (croupier.getMao().getPontosEmMao() > 21) {
            croupierEstourou = true;
            System.out.println("O croupier estourou, todos jogadores que não estouraram ganham pontos");
            Iterator iteradorPontos = controleUser.getJogadoresNaPartida().iterator();
            while (iteradorPontos.hasNext()) {
                Jogador jogador = (Jogador) iteradorPontos.next();
                if (jogador.getMao().getPontosEmMao() <= 21) {
                    jogador.pontuacao(3);
                    jogador.setPartidaVencidas(1);
                }
            }
        }

        Iterator ganhadores = controleUser.getJogadoresNaPartida().iterator();

        // Se o croupier não estourou os 21 pontos, percorre-se a lista de jogadores da partida.
        while (ganhadores.hasNext() && !croupierEstourou) {
            Jogador jogador = (Jogador) ganhadores.next();

            // Entrará somente se o jogador e o croupier não tiverem um blackJack, e tiverem 21 pontos ou menos.
            if (jogador.getMao().getPontosEmMao() <= 21 && jogador.getFlagBlackJack() == false && croupier.getMao().getPontosEmMao()
                    <= 21 && croupier.getFlagBlackJack() == false) {

                // Se o jogador tiver mais pontos que o croupier, ele ganha a partida e ganha 3 pontos.
                if (jogador.getMao().getPontosEmMao() > croupier.getMao().getPontosEmMao()) {
                    System.out.print(jogador.getUser());
                    System.out.println(", Você ganhou !!");
                    System.out.println("Suas Cartas");
                    jogador.getMao().mostrarCartas();
                    jogador.pontuacao(3);
                    jogador.setPartidaVencidas(1);

                    // Se o croupier tiver maias pontos que o jogador, o jogador perde a partida.
                } else if (jogador.getMao().getPontosEmMao() < croupier.getMao().getPontosEmMao()) {
                    System.out.print(jogador.getUser());
                    System.out.println(", Você perdeu !!");
                    System.out.println("Suas cartas ");
                    jogador.getMao().mostrarCartas();
                    jogador.pontuacao(0);

                    // Se o jogador e o croupier tiverem mesma pontuação, o jogador empata a partida.
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
        System.out.println("Pontos na mão: " + croupier.getMao().getPontosEmMao());
        // Chamada do método onde serão imprimidas as cartas ao final do jogo, ordenadas ou na ordem que iam sair do baralho.
        controleUser.getControleFile().salvarArquivo(baralho.getCartas(), "Resources/baralho.data");
    }

}
