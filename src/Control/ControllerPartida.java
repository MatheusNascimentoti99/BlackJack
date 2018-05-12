/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

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
        System.out.println("Partida rápida - Partida com 2 Baralho");
        System.out.println("Partida regular - Partida com 4 Baralho");
        System.out.println("Partida longa - Partida com 8 Baralho \n");
        System.out.println("Partida personalizada - Personalize a quantidade de cartas da partida \n");
        System.out.println("Digita sua escolha:");
        Scanner input = new Scanner(System.in);
        partidaEscolha = input.next();
        int escolha = partidaEscolhida(partidaEscolha);
        if (escolha > 0) {
            Baralho baralho = new Baralho(escolha);
            return new Partida(baralho);
        } 
        else{
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
                return this.partidaPersonalizada();

        }
        return 0;
    }

    //imcompleto//////////////
    private int partidaPersonalizada() {
        System.out.println("Digite a quantidade desejada de cartas[1 a 8]:");
        Scanner input = new Scanner(System.in);
        int partidaEscolha = input.nextInt();
        if(partidaEscolha >=1 && partidaEscolha <= 8)
            return partidaEscolha;
        else
            return partidaPersonalizada();
                    
    }
}
