
package model;

import java.util.Iterator;
import java.util.LinkedList;

public class MaoDeCarta {
    private LinkedList  cartasNaMao;
    private int pontosEmMao;
    public MaoDeCarta() {
        cartasNaMao = new LinkedList();
    }

    public LinkedList getCartasNaMao() {
        return cartasNaMao;
    }

    public void setCartasNaMao(LinkedList cartasNaMao) {
        this.cartasNaMao = cartasNaMao;
    }

    public int getPontosEmMao() {
        return pontosEmMao;
    }

    public void setPontosEmMao(int pontosEmMao) {
        this.pontosEmMao = pontosEmMao;
    }
    
    
    public void mostrarCartas(){
        
        Iterator iterador = cartasNaMao.iterator();
        while(iterador.hasNext()){
            Carta carta = (Carta) iterador.next();
            System.out.println(""+carta.toString());
        }
    }
    
    public void pontosNaMão(){
        
        Iterator iterador = cartasNaMao.iterator();
        while(iterador.hasNext()){
            
           Carta carta = (Carta) iterador.next();
            switch (carta.getValue()) {
                case "K":
                case "J":
                case "Q":
                    pontosEmMao = pontosEmMao + 10;
                    break;
                
                case "Ás":
                    if (pontosEmMao > 10)
                        pontosEmMao = pontosEmMao + 1;
                    
                    else if (pontosEmMao <= 10)
                        pontosEmMao = pontosEmMao + 11;
                    break;
                
                default:
                    pontosEmMao = pontosEmMao + Integer.parseInt(carta.getValue());
                    break;
            }      
        }
    }
    
    @Override
    public String toString(){
        return "Cartas na mão: " +cartasNaMao.size();
    }
    
}
