/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Croupier extends Jogador {
    MaoDeCarta maoDeCarta;
    public Croupier() {
        super("crouper", "");
        maoDeCarta = new MaoDeCarta();
    }

    public MaoDeCarta getMaoDeCarta() {
        return maoDeCarta;
    }

    public void setMaoDeCarta(MaoDeCarta maoDeCarta) {
        this.maoDeCarta = maoDeCarta;
    }

   public Carta DarCarta(Carta carta){
        return carta;
    }
    public boolean querCarta(){
        return 21 >= this.getMaoDeCarta().getPontosEmMao();
    }

}
