package model;

import java.util.Objects;
import util.*;
import java.util.Random;

public class Baralho {

    private final int quantidaDeBaralho;
    private IStack cartas = new Stack();

    public IStack getCartas() {
        return cartas;
    }

    public void setCartas(IStack cartas) {
        this.cartas = cartas;
    }

    public Baralho(int quantidadeBaralho) {

        this.quantidaDeBaralho = quantidadeBaralho;
        cartas = create(quantidadeBaralho);
    }

    private enum Value {

        A("Ás", 1),
        J("J", 10),
        Q("Q", 10),
        K("K", 10),
        Dez("Dez", 10);
        private int valor;
        private String tipo;

        Value(String tipo, int valor) {
            this.valor = valor;
            this.tipo = tipo;
        }

        public String getTipo() {
            return this.tipo;
        }

        public int getValor() {
            return this.valor;
        }
    }

    private Stack create(int quantidadeBaralho) {
        String naipe;
        IStack naipes = new Stack();
        for (int i = 0; i < quantidadeBaralho; i++) {
            naipes.push("♠");
            naipes.push("♥");
            naipes.push("♦");
            naipes.push("♣");
            int numNaipes = 0;
            Carta nova;
            while (!naipes.isEmpty()) {
                int numCarta = 1;
                while (numCarta <= 13) {

                    switch (numCarta) {
                        case 10:
                            nova = new Carta(Value.Dez.getTipo(), (String) naipes.peek());
                            cartas.push(nova);
                            break;
                        case 11:
                            nova = new Carta(Value.J.getTipo(), (String) naipes.peek());
                            cartas.push(nova);
                            break;
                        case 12:
                            nova = new Carta(Value.Q.getTipo(), (String) naipes.peek());
                            cartas.push(nova);
                            break;
                        case 13:
                            nova = new Carta(Value.K.getTipo(), (String) naipes.peek());
                            cartas.push(nova);
                            break;
                        case 1:
                            nova = new Carta(Value.A.getTipo(), (String) naipes.peek());
                            cartas.push(nova);
                            break;
                        default:
                            nova = new Carta(Integer.toString(numCarta), (String) naipes.peek());
                            cartas.push(nova);
                            break;
                    }
                    numCarta++;
                }
                naipes.pop();
            }
        }
        return (Stack) cartas;
    }

    public void resetaBaralho() {
        cartas = create(quantidaDeBaralho);
    }

    public void imprimeBaralho() {
        IStack temp = new Stack();
        
        while (!cartas.isEmpty()) {
            System.out.println(((Carta) cartas.peek()).toString());
            temp.push(cartas.pop());
        }
        cartas = temp;
    }

    public void ordenarCartas() {
        selectSort(cartas);
    }

    public static void selectSort(IStack a) {
        Carta[] cartasO = new Carta[a.size()];
        for (int i = 0; !a.isEmpty(); i++) {
            cartasO[i] = (Carta) a.pop();
        }
        for (int i = 1; i < cartasO.length; i++) {
            int j = i;
            while (j > 0 && cartasO[j].compareTo(cartasO[j - 1]) <= 0) {
                Carta aux = cartasO[j - 1];
                cartasO[j - 1] = cartasO[j];
                cartasO[j] = aux;
                j--;
            }

        }
        for (int i = 1; i < cartasO.length; i++) {
            int j = i;
            while (j > 0 && cartasO[j].compareTo(cartasO[j - 1]) == 0) {
                if (cartasO[j].getValue().compareTo(cartasO[j - 1].getValue()) < 0) {
                    
                    Carta aux = cartasO[j - 1];
                    cartasO[j - 1] = cartasO[j];
                    cartasO[j] = aux;
                }
                j--;
            }

        }
        for (Carta aux : cartasO) {
            a.push(aux);
        }
    }
    //Metodo embaralhar

    public void embaralhar() {

        Carta[] cartasEmbara = new Carta[cartas.size()];
        int tamanho = cartas.size();
        for (int i = 0; i < tamanho; i++) {
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
