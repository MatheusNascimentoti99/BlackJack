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
    
    //Metodo embaralhar man
    private Stack embaralhar(){
        
        Carta[] cartasEmbara = new Carta[52];
        
        for (int i = 0; i < cartas.size(); i++){
            
            cartasEmbara[i] = (Carta) cartas.pop();
        }
        
        Random novoIndice = new Random();
        
        for (int i = 0; i < cartasEmbara.length; i++){

            int num = (int) novoIndice.nextInt(cartasEmbara.length);
            Carta temp = cartasEmbara[i];
            cartasEmbara[i] = cartasEmbara[num];
            cartasEmbara[num] = temp;
            
        }
        
        for (int i = 0; i < cartasEmbara.length; i++){
            cartas.push(cartasEmbara[i]);
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
        if (!Objects.equals(this.cartas, other.cartas)) {
            return false;
        }
        return true;
    }
    
}
