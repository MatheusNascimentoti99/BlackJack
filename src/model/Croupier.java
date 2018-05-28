/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 * Classe <b>Croupier</b>, a classe para os objetos do tipo Croupier.
 * 
 * @author Matheus Nascimento e Elvis Serafim
 * @since May 2018
 * @version 1.0
 */
public class Croupier extends Jogador {
    
    /**
     * Construtor da classe <b>Croupier</b>, não tem parâmetros, apenas é inicializado o seu usuário e senha.
     */
    public Croupier() {
        super("croupier", "");
    }

     /**
     *Método para retirar a última carta da pilha de cartas do Baralho, passado por parâmetro para o método.
     * @param baralho Um Baralho.
     * @return Uma carta da pilha de cartas do baralho.
     */
   public Carta DarCarta(Baralho baralho){                  //Método para retirar e retornar a ultima carta do baralho que o Croupier receber
        return (Carta) baralho.getCartas().pop();
    }


     /**     
     * Método para retorno do usuário do Croupier.
     * 
     * @return O nome do usuário do croupier.
     */
    @Override
    public String getUser() {
        return "croupier";
    }

   


}
