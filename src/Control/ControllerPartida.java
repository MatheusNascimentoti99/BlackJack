/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.Scanner;
import model.Baralho;

/**
 *
 * @author Matheus Nascimento
 */
public class ControllerPartida {
    public Baralho escolherPartida(){
        String partidaEscolha;
        System.out.println("Partida rápida - Partida com 2 Baralho");
        System.out.println("Partida regular - Partida com 4 Baralho");
        System.out.println("Partida longa - Partida com 8 Baralho \n");
        System.out.println("Partida personalizada - Personalize a quantidade de cartas da partida \n");        
        System.out.println("Digita sua escolha:");
        Scanner lerNome = new Scanner(System.in);
        partidaEscolha = lerNome.next();
        Baralho baralho = this.partidaEscolhida(partidaEscolha);
        return baralho;
    }
    
    private Baralho partidaEscolhida(String nomePartida){
        switch(nomePartida){
            case "rápida": return new Baralho(2);
            case "regular": return new Baralho(4);
            case "longa": return new Baralho(8);
            case "personalizada": return new Baralho(8);
        }
        System.out.println("Opção invalida");
        this.escolherPartida();
        return null;
    }
}
