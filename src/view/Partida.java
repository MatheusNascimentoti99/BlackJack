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

    public static void main(String args[]) {
        Croupier croupier = new Croupier();
        ControllerUser controleUser = new ControllerUser();
        ControllerPartida controlePartida = new ControllerPartida();
        System.out.println(" Jogo BlackJack \n");
        croupier.setBaralho(controlePartida.escolherPartida());
        controleUser.cadastro();
        controleUser.cadastro();
        controleUser.mostrarJogadores();
        System.out.println(((Carta)croupier.getBaralho().getCartas().peek()).toString());
    }

}
