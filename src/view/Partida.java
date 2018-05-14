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
    Croupier croupier;
    public Partida(Baralho baralho) {
        this.baralho = baralho;
        croupier = new Croupier();
    }

    public void partida() throws Exception{
        System.out.println(" Jogo BlackJack \n");
        ControllerUser controleUser = new ControllerUser();

        controleUser.loginJogador();

        controleUser.loginJogador();
        
    }

    public Baralho getBaralho() {
        return baralho;
    }

    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
    }

}
