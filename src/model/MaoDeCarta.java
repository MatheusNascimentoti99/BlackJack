package model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Matheus Nascimento
 */
public class MaoDeCarta implements Serializable {

    private LinkedList cartasNaMao;
    private int pontosEmMao;

    public MaoDeCarta() {
        cartasNaMao = new LinkedList();
        pontosEmMao = 0;
    }

    public LinkedList getCartasNaMao() {
        return cartasNaMao;
    }

    public void setCartasNaMao(LinkedList cartasNaMao) {
        this.cartasNaMao = cartasNaMao;
    }

    public int getPontosEmMao() {
        pontosEmMao = 0;
        Iterator iterador = cartasNaMao.iterator();
        pontosEmMao = calcPontosEmMao(iterador);
        return pontosEmMao;
    }

    public void setPontosEmMao(int pontosEmMao) {
        this.pontosEmMao = pontosEmMao;
    }

    public void mostrarCartas() {

        Iterator iterador = cartasNaMao.iterator();
        while (iterador.hasNext()) {
            Carta carta = (Carta) iterador.next();
            System.out.println("" + carta.toString());
        }
    }

    
    // Método que calcula a pontuação da mão de cartas.
    private int calcPontosEmMao(Iterator iterador) {
        int aces = 0;
        int total = 0;
        while (iterador.hasNext()) {

            Carta carta = (Carta) iterador.next();
            switch (carta.getValue()) {
                case "K":
                case "J":
                case "Q":
                case "Dez":
                    total = total + 10;
                    break;

                case "Ás":
                    aces++;
                    break;

                default:
                    total = total + Integer.parseInt(carta.getValue());

                    break;
            }
            
        }
        
            if (aces != 0){
                for (int i = 0; i < aces; i++){

                    if (total > 10){
                        total += 1;
                    }
                    else{
                        total += 11;
                    }
                }
            }

        return total;
    }

    @Override
    public String toString() {
        return "Cartas na mão: " + cartasNaMao.size();
    }

}
