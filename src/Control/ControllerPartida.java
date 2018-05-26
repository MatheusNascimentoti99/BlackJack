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
    Partida partida;
   

    public Boolean baralhosDaPartida(int escolha) {                                                                       
            Baralho baralho = new Baralho(escolha);
            partida = new Partida(baralho);
            return true;
        
    }

    public int quantBaralho(String nomePartida) {
        switch (nomePartida) {
            case "simples":
                return 2;
            case "regular":
                return 4;
            case "longa":
                return 8;
            case "personalizada":
                return 0;            

        }
        return -1;
    }



}
