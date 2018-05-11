package view;

import Control.ControllerPartida;
import Control.ControllerUser;
import java.util.LinkedList;
import java.util.Scanner;
import model.Baralho;
import util.IStack;
import util.Stack;

public class Partida {

    public static void main(String args[]) {
        Scanner lerEscolha = new Scanner(System.in);
        Scanner lerUser = new Scanner(System.in);
        Scanner lerSenha = new Scanner(System.in);
        ControllerUser controleUser = new ControllerUser();
        ControllerPartida controlePartida = new ControllerPartida();
        controlePartida.escolherPartida();
        System.out.println(" Jogo BlackJack \n");
        controlePartida.escolherPartida();
        controleUser.cadastro();
    }

}
