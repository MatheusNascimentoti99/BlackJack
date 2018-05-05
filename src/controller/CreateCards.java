package controller;

import model.Carta;
import util.*;

public class CreateCards implements ICreateCards {

    private String naipe;
    private IStack cartas = new Stack();
    private IStack naipes = new Stack();

    public CreateCards() {
        cartas = new Stack();
        naipes = new Stack();
        naipes.push("Espadas");
        naipes.push("Copas");
        naipes.push("Ouros");
        naipes.push("Paus");

    }

    @Override
    public Stack create() {
        int numNaipes = 0;
        Carta nova;
        while (!naipes.isEmpty()) {
            int numCarta = 0;
            while (numCarta < 13) {

                if (numCarta == 9) {
                    nova = new Carta("J", (String) naipes.peek());
                    cartas.push(nova);
                } else if (numCarta == 10) {
                    nova = new Carta("Q", (String) naipes.peek());
                    cartas.push(nova);
                } else if (numCarta == 11) {
                    nova = new Carta("K", (String) naipes.peek());
                    cartas.push(nova);
                } else if (numCarta == 12) {
                    nova = new Carta("A", (String) naipes.peek());
                } else {
                    nova = new Carta(Integer.toString(numCarta + 2), (String) naipes.peek());
                    cartas.push(nova);
                }
                numCarta++;
            }
            naipes.pop();
        }
        return (Stack) cartas;
    }

    @Override
    public boolean IsBiggerTen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
