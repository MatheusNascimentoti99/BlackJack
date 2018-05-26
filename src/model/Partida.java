package model;

import Control.ControllerJogador;
import model.Baralho;
import model.Croupier;

/**
 *
 * @author Matheus Nascimento
 */
public class Partida {

    private Baralho baralho;
    private Croupier croupier;
    private ControllerJogador controleUser;
    
    public Croupier getCroupier() {
        return croupier;
    }

    public void setCroupier(Croupier croupier) {
        this.croupier = croupier;
    }

    public ControllerJogador getControleUser() {
        return controleUser;
    }

    public void setControleUser(ControllerJogador controleUser) {
        this.controleUser = controleUser;
    }
    

    public Partida(Baralho baralho) {
        this.baralho = baralho;
        croupier = new Croupier();
    }

    public Baralho getBaralho() {
        return baralho;
    }

    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
    }
}
