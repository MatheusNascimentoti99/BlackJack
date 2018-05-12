package view;

import Control.ControllerPartida;
import Control.ControllerUser;
import java.util.LinkedList;
import java.util.Scanner;
import model.Baralho;
import model.Carta;
import model.Croupier;
import util.IStack;
import util.Stack;

public class Partida {

    private Baralho baralho;

    public Partida(Baralho baralho) {
        this.baralho = baralho;
    }

    public void novaPartida(){
        Croupier croupier = new Croupier();
        ControllerUser controleUser = new ControllerUser();
        System.out.println(" Jogo BlackJack \n");
        controleUser.loginJogador();

    }

    public Baralho getBaralho() {
        return baralho;
    }

    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
    }

}
