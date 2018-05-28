package model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Classe <b>MaoDeCarta</b>, a classe para os objetos do tipo MaoDeCarta.
 * 
 * @author Matheus Nascimento e Elvis Serafim
 * @since May 2018
 * @version 1.0
 */
public class MaoDeCarta implements Serializable {

    private LinkedList cartasNaMao;
    private int pontosEmMao;

    /**
     * Construtor da classe <b>MaoDeCarta</b>, não tem parâmetros. Ele cria uma nova lista encadeada para cartaNaMao.
     *
     */
    public MaoDeCarta() {
        cartasNaMao = new LinkedList();
        pontosEmMao = 0;
    }

    /**
     * Método para o retorno da LinkedList das cartas na mão.
     * @return 
     */
    public LinkedList getCartasNaMao() {
        return cartasNaMao;
    }

    /**
     *Método para designar uma nova LinkedList para a mão.
     * @param cartasNaMao Nova LinkedList de cartas.
     */
    public void setCartasNaMao(LinkedList cartasNaMao) {
        this.cartasNaMao = cartasNaMao;
    }

    /**
     * Método que tem como retorno o total de pontos na mão.
     * @return total de pontos na mão.
     */
    public int getPontosEmMao() {
        pontosEmMao = 0;
        Iterator iterador = cartasNaMao.iterator();
        pontosEmMao = calcPontosEmMao(iterador);
        return pontosEmMao;
    }


    /**
     * Método que mostra as cartas da mão.
     */
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

    /**
     * Método que retorna uma representação string do objeto MãoDeCarta.
     * @return cartas em mão.
     */
    @Override
    public String toString() {
        return "Cartas na mão: " + cartasNaMao.size();
    }

    /**
     * Métodopara designar um novo total de pontos na mão.
     * @param pontos pontos a serem designados
     */
    public void setPontosEmMao(int pontos) {
        this.pontosEmMao = pontos;
    }


}
