/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Control.ControllerPartida;
import Control.ControllerJogador;
import java.io.IOException;
import java.util.Scanner;
import model.Baralho;

import model.Croupier;
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
            ControllerJogador controleUser = new ControllerJogador();
            System.out.println("Digite 1 para Cadastrar jogador ");
            System.out.println("Digite 2 para iniciar uma partida");
            System.out.println("Digite 3 para mostrar placar");
            System.out.print("Digite 4 para imprmir cartas da última partida \t\t");
            System.out.println("Digite 5 para sair");
            Partida partida = null;
            Scanner input = new Scanner(System.in);                         //Entrada do usuário
            escolha = input.next();

            switch (escolha) {
                case "1":
                    controleUser.cadastrar();                               //Aba para novo cadastro
                    break;
                case "2":
                    partida = controlePartida.escolherPartida();            //Aba para nova partida
                    partida.partida(controleUser);
                    break;
                case "3":
                    controleUser.mostrarJogadores();                        //Aba para mostrar placar
                    break;                        
                case "4":

                    Baralho baralhoLast = new Baralho();
                    baralhoLast.setCartas(controleUser.getControleFile().recuperarBaralho());
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

            controleUser.getControleFile().imprimirPontuacao(controleUser.getListaJogadores());     //Atualiza o rank de pontuação ao fim de qualquer execução do programa
            controleUser.getControleFile().salvarArquivo(controleUser.getListaJogadores(), "Resources/Dados.data");         //Atualiza os dados dos jogadores ao fim de qualquer execução do programa 
        } while (!escolha.equals("5"));                                                             //Executa o programa até o usuário digitar 4 entre as opções do menu principal

    }
}
