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
import java.util.Scanner;

/**
 *
 * @author Matheus Nascimento
 */
public class App {

    public static void main(String args[]) throws IOException, Exception {
        ControllerPartida controlePartida = new ControllerPartida();
        ControllerUser controleUser = new ControllerUser();
        String escolha;
        do{
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
            }
            
        }while (!escolha.equals("3"));
        
    }
}
