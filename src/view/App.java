/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Control.ControllerPartida;
import Control.ControllerJogador;
import java.io.IOException;
import java.util.InputMismatchException;
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
        String escolha;

        do {                                                                    //Laço para manter a execução do programa após o termino das principais operações do mesmo.            
            ControllerPartida controlePartida = new ControllerPartida();
            ControllerJogador controleJogador = new ControllerJogador();
            System.out.println("Digite 1 para Cadastrar jogador ");
            System.out.println("Digite 2 para iniciar uma partida");
            System.out.println("Digite 3 para mostrar placar");
            System.out.print("Digite 4 para imprmir cartas da última partida \t\t");
            System.out.println("Digite 5 para sair");
            Scanner input = new Scanner(System.in);                         //Entrada do usuário
            escolha = input.next();

            switch (escolha) {
                case "1":
                    cadastro(controleJogador);
                    break;
                case "2":
                    partida(controlePartida, controleJogador);

                    break;
                case "3":
                    mostrarJogadores(controleJogador);
                    break;
                case "4":

                    Baralho baralhoLast = new Baralho();
                    baralhoLast.setCartas(controleJogador.getControleFile().recuperarBaralho());
                    if (baralhoLast.getCartas() == null) {
                        System.out.println("Não há baralho");
                    } else {
                        baralhoLast.imprimirCartas();
                    }
                    break;
                default:
                    break;
            }
            System.out.println("");

            controleJogador.getControleFile().imprimirPontuacao(controleJogador.getListaJogadores());     //Atualiza o rank de pontuação ao fim de qualquer execução do programa
            controleJogador.getControleFile().salvarArquivo(controleJogador.getListaJogadores(), "Resources/Dados.data");         //Atualiza os dados dos jogadores ao fim de qualquer execução do programa 
        } while (!escolha.equals("5"));                                                             //Executa o programa até o usuário digitar 4 entre as opções do menu principal

    }
    
    private static String input() {                //Para resumir as entradas do teclado;
        Scanner opcao = new Scanner(System.in);
        return opcao.nextLine();
    }

    private static void cadastro(ControllerJogador controleJogador) throws Exception {
        System.out.println("## Bora se cadastrar ##");
        System.out.println("Digita seu nome \n");
        String nome = input();
        System.out.println("Escolha uma senha\n");
        String senha = input();
        //Aba para novo cadastro
        if (controleJogador.cadastrar(nome, senha) == false) {
            System.out.println("Você já está cadastrado");
        } else {
            System.out.println("Cadastrado com sucesso!");
        }
    }

    private static void mostrarJogadores(ControllerJogador controleJogador) {
        System.out.println("################### Lista de Jogadores cadastrados ###################");
        controleJogador.getListaJogadores().forEach((aux) -> {
            System.out.println(((Jogador) aux).toString());
        });
    }

    private static void partida(ControllerPartida controlePartida, ControllerJogador controleJogador) throws Exception {
        controlePartida.baralhosDaPartida(escolherPartida(controlePartida));
        controlePartida.getPartida().getBaralho().embaralhar();
        int quantidade = quantidade();
        Boolean sucessoLogin = true;
        int numJogador = 0;
        while (numJogador < quantidade) {

            numJogador++;

            System.out.println("## Bora fazer login ##");
            System.out.print(numJogador + " - ");
            entrarLogin(controleJogador);

        }
        System.out.println("");
        for (int i = 0; i < 2; i++) {
            controlePartida.darCartas(controleJogador);
        }
        controlePartida.temBlackJack(controleJogador);
        controlePartida.blackJackCroupier();
        dinamicaPartida(controleJogador, controlePartida);
    }

    private static int escolherPartida(ControllerPartida controlePartida) {
        System.out.println(" simples - Partida com 2 Baralho");
        System.out.println(" regular - Partida com 4 Baralho");
        System.out.println(" longa - Partida com 8 Baralho");
        System.out.println(" personalizada - Personalize a quantidade de baralhos da partida");
        System.out.println("Sua escolha:");
        String escolha = input();
        if (controlePartida.quantBaralho(escolha) == -1) {
            System.out.println("Opção inválida! Tente novamente");
            escolherPartida(controlePartida);
        } else if (controlePartida.quantBaralho(escolha) == 0) {
            System.out.println("Partida personalizada");
            return partidaPersonalizada();

        }
        return controlePartida.quantBaralho(escolha);
    }

    private static int partidaPersonalizada() {
        System.out.println("Digite a quantidade desejada de cartas[1 a 8]:");
        String input = input();

        int partidaEscolha = Integer.parseInt(input);
        if (partidaEscolha >= 1 && partidaEscolha <= 8) {                   //Controla o mínimo e máximo de baralhos que uma partida pode ter 
            return partidaEscolha;
        }
        return partidaPersonalizada();
    }

    private static void entrarLogin(ControllerJogador controleJogador) throws Exception {

        System.out.println("Digite seu nome:");
        String user = input();
        System.out.println("Digite sua senha:");
        String senha = input();
        if (controleJogador.loginJogador(user, senha) == false) {
            if (controleJogador.verificacao(user, controleJogador.getJogadoresNaPartida())) {
                System.out.println("Jogador já está na partida!");
            } else if (controleJogador.verificacao(user, senha, controleJogador.getListaJogadores()) == false) {
                System.out.println("Jogador não está cadastrado!");
                System.out.println("Deseja cadastrar " + user + "?(sim ou não):");

                if ("sim".equals(input())) {
                    if (controleJogador.cadastrar(user, senha)) {
                        System.out.println("Cadastrado com sucesso!\n");
                    }

                }

            }
            entrarLogin(controleJogador);
        }

    }

    private static int quantidade() {
        System.out.println("Insira a quantidade de jogadores na partida[ máximo 5]:");
        Scanner input = new Scanner(System.in);
        int quantidade = 0;

        try {
            quantidade = input.nextInt();
        } catch (InputMismatchException exe) {
            System.out.println("Valor inválido!");
        }
        if (quantidade == 0 || quantidade > 5) {
            System.out.println("Quantidade inválida!");
            quantidade = quantidade();
        }
        return quantidade;

    }

    private static void dinamicaPartida(ControllerJogador controleJogador, ControllerPartida controlePartida) throws Exception {
        Iterator BlackJack = controleJogador.getJogadoresNaPartida().iterator();
        Boolean flag;

        while (BlackJack.hasNext()) {
            System.out.println("------------------------------------------------------------------------");
            Jogador jogador = (Jogador) BlackJack.next();
            // Somente entrará se o jcontroleUserogador ou o croupier tiverem um blackJack.
            if (controlePartida.getPartida().getCroupier().getFlagBlackJack() == true || jogador.getFlagBlackJack() == true) {

                // Se o croupier e o jogador tiverem um blackJack, eles empatam e o jogador ganha 1 ponto.
                if (jogador.getFlagBlackJack() == true && controlePartida.getPartida().getCroupier().getFlagBlackJack() == true) {
                    System.out.println("Você e o croupier tem um BlackJack, empataram");
                    System.out.println("Cartas de " + jogador.getUser());
                    jogador.pontuacao(1);
                    jogador.getMao().mostrarCartas();

                    // Se somente o croupier tiver um blackJack, o jogador perde a partida.
                } else if (jogador.getFlagBlackJack() == false && controlePartida.getPartida().getCroupier().getFlagBlackJack() == true) {
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
                    System.out.println(((Carta) controlePartida.getPartida().getCroupier().getMao().getCartasNaMao().getLast()).toString());

//                   // Se o método pedir carta de jogador retorna true, ou seja o jogador deseja mais carta e tem menos ou 21 pontos,
//                   // É adicionado mais uma carta na mão do jogador.
                    if (pedirCarta(jogador) && jogador.getMao().getPontosEmMao() <= 21) {
                        flag = true;
                        Carta carta = controlePartida.getPartida().getCroupier().DarCarta(controlePartida.getPartida().getBaralho());
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
            System.out.println("------------------------------------------------------------------------");
        }

        // Se o croupier tem um soft, ou seja um Ás e uma carta entre 2 e 9 na mão, é adicionado mais uma carta a sua mão.
        if (controlePartida.getPartida().getCroupier().getFlagBlackJack() == false) {
            Iterator softCarta = controlePartida.getPartida().getCroupier().getMao().getCartasNaMao().iterator();
            while (!softCarta.hasNext()) {
                if (softCarta.next().equals("Ás")) {
                    controlePartida.getPartida().getCroupier().getMao().getCartasNaMao().add(controlePartida.getPartida().getCroupier().DarCarta(controlePartida.getPartida().getBaralho()));
                }

            }
        }

        // Enquanto o croupier tiver menos que 17 pontos, será adicionado cartas á mão dele.
        while (controlePartida.getPartida().getCroupier().getMao().getPontosEmMao() < 17) {
            controlePartida.getPartida().getCroupier().getMao().getCartasNaMao().add(controlePartida.getPartida().getCroupier().DarCarta(controlePartida.getPartida().getBaralho()));

        }
        Boolean croupierEstourou = false;
        // Se o croupier ultrapassou os 21 pontos, estourou, todos jogadores vencem a partida e ganham 3 pontos.
        if (controlePartida.getPartida().getCroupier().getMao().getPontosEmMao() > 21) {
            croupierEstourou = true;
            System.out.println("O croupier estourou, todos jogadores que não estouraram ganham pontos");
            Iterator iteradorPontos = controleJogador.getJogadoresNaPartida().iterator();
            while (iteradorPontos.hasNext()) {
                Jogador jogador = (Jogador) iteradorPontos.next();
                if (jogador.getMao().getPontosEmMao() <= 21) {
                    jogador.pontuacao(3);
                    jogador.setPartidaVencidas(1);
                }
            }
        }

        Iterator ganhadores = controleJogador.getJogadoresNaPartida().iterator();

        // Se o croupier não estourou os 21 pontos, percorre-se a lista de jogadores da partida.
        while (ganhadores.hasNext() && !croupierEstourou) {
            Jogador jogador = (Jogador) ganhadores.next();

            // Entrará somente se o jogador e o croupier não tiverem um blackJack, e tiverem 21 pontos ou menos.
            if (jogador.getMao().getPontosEmMao() <= 21 && jogador.getFlagBlackJack() == false && controlePartida.getPartida().getCroupier().getMao().getPontosEmMao()
                    <= 21 && controlePartida.getPartida().getCroupier().getFlagBlackJack() == false) {

                // Se o jogador tiver mais pontos que o croupier, ele ganha a partida e ganha 3 pontos.
                if (jogador.getMao().getPontosEmMao() > controlePartida.getPartida().getCroupier().getMao().getPontosEmMao()) {
                    System.out.print(jogador.getUser());
                    System.out.println(", Você ganhou !!");
                    System.out.println("Suas Cartas");
                    jogador.getMao().mostrarCartas();
                    jogador.pontuacao(3);
                    jogador.setPartidaVencidas(1);

                    // Se o croupier tiver maias pontos que o jogador, o jogador perde a partida.
                } else if (jogador.getMao().getPontosEmMao() < controlePartida.getPartida().getCroupier().getMao().getPontosEmMao()) {
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
        controlePartida.getPartida().getCroupier().getMao().mostrarCartas();
        System.out.println("Pontos na mão: " + controlePartida.getPartida().getCroupier().getMao().getPontosEmMao());
        // Chamada do método onde serão imprimidas as cartas ao final do jogo, ordenadas ou na ordem que iam sair do baralho.
        controleJogador.getControleFile().salvarArquivo(controlePartida.getPartida().getBaralho().getCartas(), "Resources/baralho.data");
        controleJogador.getControleFile().imprimirPontuacao(controleJogador.getListaJogadores());     //Atualiza o rank de pontuação ao fim de qualquer execução do programa
        controleJogador.getControleFile().salvarArquivo(controleJogador.getListaJogadores(), "Resources/Dados.data");
    }

    private static Boolean pedirCarta(Jogador jogador) {
        System.out.println("Deseja carta? Digite pedir ou parar");
        String escolha = input();
        if (jogador.pedirCarta(escolha)) {
            switch (escolha) {
                case "pedir": return true;
                case "parar": return false;
            }
        }
        return pedirCarta(jogador);
    }
}
