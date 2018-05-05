package model;

import util.*;

public class Baralho {

    private IStack cartas = new Stack();

    public IStack getCartas() {
        return cartas;
    }

    public void setCartas(IStack cartas) {
        this.cartas = cartas;
    }

    public Baralho() {
        cartas = create();
    }


    public final Stack create() {
        String naipe;
        IStack naipes = new Stack();
        naipes.push("Espadas");
        naipes.push("Copas");
        naipes.push("Ouros");
        naipes.push("Paus");
        int numNaipes = 0;
        Carta nova;
        while (!naipes.isEmpty()) {
            int numCarta = 0;
            while (numCarta < 13) {

                switch (numCarta) {
                    case 9:
                        nova = new Carta("J", (String) naipes.peek());
                        cartas.push(nova);
                        break;
                    case 10:
                        nova = new Carta("Q", (String) naipes.peek());
                        cartas.push(nova);
                        break;
                    case 11:
                        nova = new Carta("K", (String) naipes.peek());
                        cartas.push(nova);
                        break;
                    case 12:
                        nova = new Carta("A", (String) naipes.peek());
                        cartas.push(nova);
                        break;
                    default:
                        nova = new Carta(Integer.toString(numCarta + 2), (String) naipes.peek());
                        cartas.push(nova);
                        break;
                }
                numCarta++;
            }
            naipes.pop();
        }
        return (Stack) cartas;
    }

    public class Carta {

        private String value;
        private String naipe;

        public Carta(String value, String naipe) {
            this.value = value;
            this.naipe = naipe;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getNaipe() {
            return naipe;
        }

        public void setNaipe(String naipe) {
            this.naipe = naipe;
        }

    }
}
