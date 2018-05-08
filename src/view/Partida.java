package view;

import model.Baralho;
import model.Baralho.Carta;
import util.IStack;
import util.Stack;

public class Partida {

    public static void main(String args[]) {
        Baralho novo = new Baralho();
        System.out.println(":D");
        System.out.println(":D");
        System.out.println(":D");
        System.out.println(":)");
        novo.imprimeBaralho();
        novo.embaralhar();
        System.out.println("\n");
        novo.imprimeBaralho();

    }

}
