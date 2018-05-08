package model;

import java.util.Objects;
import util.*;
import java.util.Random;

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

    private Stack create() {
        String naipe;
        IStack naipes = new Stack();
        naipes.push("Espadas ♠");
        naipes.push("Copas   ♥");
        naipes.push("Ouros   ♦");
        naipes.push("Paus    ♣");
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
                        nova = new Carta(Integer.toString(numCarta + 1), (String) naipes.peek());
                        cartas.push(nova);
                        break;
                }
                numCarta++;
            }
            naipes.pop();
        }
        return (Stack) cartas;
    }

    public void resetaBaralho() {
        cartas = create();
    }

    public void imprimeBaralho() {
        IStack temp = new Stack();
        
        while(!cartas.isEmpty()) {
            System.out.println(((Carta)cartas.peek()).toString());
            temp.push(cartas.pop());
        }
        cartas = temp;
    }

    //Metodo embaralhar
    public void embaralhar() {

        Carta[] cartasEmbara = new Carta[52];

        for (int i = 0; i < 52; i++) {
            cartasEmbara[i] = (Carta) cartas.pop();

        }

        Random novoIndice = new Random();

        for (int i = 0; i < cartasEmbara.length * (3 / 2); i++) {      // o 3/2 é só para poder embaralhar mais. 

            int num = novoIndice.nextInt(cartasEmbara.length - 1);
            Carta temp = cartasEmbara[i];
            cartasEmbara[i] = cartasEmbara[num];
            cartasEmbara[num] = temp;

        }
        for (Carta cartasEmbara1 : cartasEmbara) {
            cartas.push(cartasEmbara1);
        }

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

        @Override
        public String toString() {
            return ("[Naipe:" + naipe + " Valor:" + value+"]");
        }


        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Carta other = (Carta) obj;
            if (!Objects.equals(this.value, other.value)) {
                return false;
            }
            return Objects.equals(this.naipe, other.naipe);
        }
        
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Baralho other = (Baralho) obj;
        return Objects.equals(this.cartas, other.cartas);
    }

 

}
