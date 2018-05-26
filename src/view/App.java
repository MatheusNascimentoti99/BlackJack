/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Control.ControllerPartida;
import Control.ControllerJogador;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import model.Baralho;
import model.Carta;

import model.Croupier;
import model.Jogador;
import util.IStack;

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

    private static void cadastro(ControllerJogador controleUser) throws Exception {
        System.out.println("## Bora se cadastrar ##");
        System.out.println("Digita seu nome \n");
        String nome = input();
        System.out.println("Escolha uma senha\n");
        String senha = input();
        //Aba para novo cadastro
        if (controleUser.cadastrar(nome, senha) == null) {
            System.out.println("Você já está cadastrado");
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
        int quantidade = quantidade();
        for (int i = 0; i < quantidade; i++) {
            System.out.println("## Bora fazer login ##");
            System.out.print(i + 1 + " - ");
            entrarLogin(controleJogador);

        }
        for (int i = 0; i < 2; i++) {
            controlePartida.darCartas(controleJogador);
        }
        controlePartida.temBlackJack(controleJogador);
        controlePartida.blackJackCroupier();
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

    private static void entrarLogin(ControllerJogador controleUser) throws Exception {

        System.out.println("Digite seu nome:");
        String user = input();
        System.out.println("Digite sua senha:");
        String senha = input();
        if (controleUser.loginJogador(user, senha) == false) {
            System.out.println("O jogador não está cadastrado ou já está na partida!");
            System.out.println("Deseja adicionar jogador?(sim ou não):");

            if ("sim".equals(input())) {
                entrarLogin(controleUser);
            }
        }

    }

    private static int quantidade() {
        System.out.println("Insira a quantidade de jogadores na partida:");
        Scanner input = new Scanner(System.in);
        int quantidade = 0;

        try {
            quantidade = input.nextInt();
        } catch (NumberFormatException exe) {
            System.out.println("Valor inválido!");
        }
        return quantidade == 0 ? quantidade() : quantidade;

    }

}
