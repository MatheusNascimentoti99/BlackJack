
package model;

import java.util.LinkedList;

public class MaoDeCarta {
    private LinkedList  cartasNaMao;
    
    public MaoDeCarta() {
        cartasNaMao = new LinkedList();
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
