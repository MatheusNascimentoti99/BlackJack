
package model;

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

    /**
     *
     * @return  
     */
    @Override
    public String toString(){
        return "Cartas na mãe: " +cartasNaMao.size();
    }
    
}
