
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
    
    @Override
    public String toString(){
        return "Cartas na mão: " +cartasNaMao.size();
    }
    
}
