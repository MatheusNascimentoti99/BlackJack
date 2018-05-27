package model;

import Control.ControllerJogador;
import model.Baralho;
import model.Baralho;
import model.Croupier;
import model.Croupier;

/**
 * Classe <b>Partida</b>, a classe para os objetos do tipo Partida.
 * 
 * @author Matheus Nascimento e Elvis Serafim
 * @since May 2018
 * @version 1.0
 */
public class Partida {

    private Baralho baralho;
    private Croupier croupier;
    private ControllerJogador controleUser;
    
    /**
     * Método para retorno do croupier da partida.
     * @return Croupier da partida
     */
    public Croupier getCroupier() {
        return croupier;
    }

    /**
     * Método para designar um novo croupier para a partida.
     * @param croupier Novo croupier.
     */
    public void setCroupier(Croupier croupier) {
        this.croupier = croupier;
    }

    /**
     * Método para retorno do Controller do jogador da partida.
     * @return Controller do jogador.
     */
    public ControllerJogador getControleUser() {
        return controleUser;
    }

    /**
     * Método para designar um novo Controller de jogador para a partida.
     * @param controleUser Controller de jogador.
     */
    public void setControleUser(ControllerJogador controleUser) {
        this.controleUser = controleUser;
    }
    
    /**
     * Construtor da classe <b>Partida</b>, tem como parâmetro o baralho para a partida. E cria um novo croupier.
     * @param baralho Baralho para a partida.
     */
    public Partida(Baralho baralho) {
        this.baralho = baralho;
        croupier = new Croupier();
    }

    /**
     * Método para retorno do Baralho da partida.
     * @return Um Baralho.
     */
    public Baralho getBaralho() {
        return baralho;
    }

    /**
     * Método para designar um novo Baralho para a partida.
     * @param baralho Novo baralho.
     */
    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
    }
}
