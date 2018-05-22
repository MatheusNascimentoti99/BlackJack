/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Croupier extends Jogador {
    public Croupier() {
        super("crouper", "");
    }

   public Carta DarCarta(Baralho baralho){                  //Método para retirar e retornar a ultima carta do baralho que o Croupier receber
        return (Carta) baralho.getCartas().pop();
    }

  

    @Override
    public String getUser() {
        return "croupier";
    }

   


}
