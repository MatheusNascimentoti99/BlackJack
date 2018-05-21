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

import model.Croupier;

/**
 *
 * @author Matheus Nascimento
 */
public class App {

    public static void main(String args[]) throws IOException, Exception {
        String escolha;

        do {
            Croupier croupier = new Croupier();
            ControllerPartida controlePartida = new ControllerPartida();
            ControllerJogador controleUser = new ControllerJogador();
            System.out.println("Digite 1 para Cadastrar jogador ");
            System.out.println("Digite 2 para iniciar uma partida");
            System.out.println("Digite 3 para mostrar placar");
            System.out.println("Digite 4 para sair do jogo");
            Partida partida;
            Scanner input = new Scanner(System.in);
            escolha = input.next();

            switch (escolha) {
                case "1":
                    controleUser.cadastrar();
                    break;
                case "2":
                    partida = controlePartida.escolherPartida();
                    partida.partida(controleUser);
                    break;
                case "3":
                    controleUser.mostrarJogadores();
                default:
                    break;
            }
            System.out.println("");
            controleUser.getControleFile().imprimirPontuacao(controleUser.getListaJogadores());
            controleUser.getControleFile().salvarJogador(controleUser.getListaJogadores());
        } while (!escolha.equals("4"));

    }
}
