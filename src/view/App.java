/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Control.ControllerPartida;
import Control.ControllerUser;
import java.util.Scanner;

/**
 *
 * @author Matheus Nascimento
 */
public class App {

    public static void main(String args[]) {
        ControllerPartida controlePartida = new ControllerPartida();
        ControllerUser controleUser = new ControllerUser();
        System.out.println("Digite 1 para Cadastrar jogador ");
        System.out.println("Digite 2 para iniciar uma partida");
        Partida partida;
        Scanner input = new Scanner(System.in);
        String escolha = input.next();
        if(escolha.equals("1")){
            controleUser.cadastro();
        }
        else if(escolha.equals("2")){
            partida = controlePartida.escolherPartida();
            partida.novaPartida();
            partida.getBaralho().imprimeBaralho();
        }
    }
}
