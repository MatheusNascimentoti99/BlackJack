/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.Baralho;
import view.Partida;

/**
 *
 * @author Matheus Nascimento
 */
public class ControllerPartida {

    public Partida escolherPartida() {
        String partidaEscolha;
        System.out.println(" simples - Partida com 2 Baralho");
        System.out.println(" regular - Partida com 4 Baralho");
        System.out.println(" longa - Partida com 8 Baralho");
        System.out.println(" personalizada - Personalize a quantidade de baralhos da partida \n");
        System.out.println(" sua escolha:");
        Scanner input = new Scanner(System.in);
        partidaEscolha = input.next();                              //Entrada do usuário
        int escolha = partidaEscolhida(partidaEscolha);             //Retorna um inteiro que conrresponde a escolha do usuário
        if (escolha > 0) {                                          //Verifica se a escolha é um número real
            Baralho baralho = new Baralho(escolha);
            return new Partida(baralho);
        } else {
            System.out.println("Valor inválido!");
            return escolherPartida();
        }
    }

    private int partidaEscolhida(String nomePartida) {
        switch (nomePartida) {
            case "simples":
                return 2;
            case "regular":
                return 4;
            case "longa":
                return 8;
            case "personalizada":
                return this.partidaPersonalizada();             //Chama o método que o usuário pode digitar a quantidade de baralhos

        }
        return 0;
    }

    private int partidaPersonalizada() {

        System.out.println("Digite a quantidade desejada de cartas[1 a 8]:");
        Scanner input = new Scanner(System.in);
        try {
            int partidaEscolha = input.nextInt();
            if (partidaEscolha >= 1 && partidaEscolha <= 8) {                   //Controla o mínimo e máximo de baralhos que uma partida pode ter 
                return partidaEscolha;
            }

        } catch (Exception exe) {                                               //Caso o usuário digite letras
            System.out.println("Valor invalido");
            return partidaPersonalizada();                                      //repete o método novamente, caso algo esteja errado
        }
        System.out.println("Valor invalido");

        return partidaPersonalizada();                          
    }

}
