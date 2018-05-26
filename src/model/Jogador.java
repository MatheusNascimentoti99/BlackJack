/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Matheus Nascimento
 */
public class Jogador implements Serializable, Comparable {

    private String user;
    private String passeword;
    private int pontuacao;
    private int partidaVencidas;
    private MaoDeCarta mao;
    private boolean flagBlackJack;// Atributo para verificar se o jogador tem um blackJack ou não.

    public Jogador(String user, String passeword) {
        this.user = user;
        this.passeword = passeword;
        this.mao = new MaoDeCarta();
    }

    @Override
    public String toString() {
        return "\nNome: " + user + " --- Pontuação: " + pontuacao + " -- Partidas vencida: " + partidaVencidas;

    }

    public MaoDeCarta getMao() {
        return mao;
    }

    public void setMao(MaoDeCarta mao) {
        this.mao = mao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public int getPartidaVencidas() {
        return partidaVencidas;
    }

    public void setPartidaVencidas(int partidaGanhas) {
        this.partidaVencidas = partidaVencidas + partidaGanhas;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasseword() {
        return passeword;
    }

    public void setPasseword(String passeword) {
        this.passeword = passeword;
    }

    public int compareTo(Jogador jogador) {
        if (pontuacao > jogador.getPontuacao()) {
            return 1;
        } else if (pontuacao < jogador.getPontuacao()) {
            return -1;
        }
        return 0;
    }
    
    // Método que retorna true se o jogador desejar mais carta e false caso não.
    public boolean pedirCarta(String escolha) {
        
        switch (escolha) {

            case "pedir":
                return true;
            case "parar":
                return true;

        }
        
        return false;
    }

    public boolean getFlagBlackJack() {
        return flagBlackJack;
    }

    public void setFlagBlackJack(boolean flagBlackJack) {
        this.flagBlackJack = flagBlackJack;
    }

    public void pontuacao(int pontos) {
        pontuacao = pontuacao + pontos;
    }

    @Override
    public boolean equals(Object obj) {
        final Jogador other = (Jogador) obj;
        if (this.partidaVencidas != other.partidaVencidas) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return Objects.equals(this.passeword, other.passeword);
    }

    @Override
    public int compareTo(Object o) {
        Jogador outro = (Jogador) o;
        if (pontuacao < outro.getPontuacao()) {
            return -1;

        } else if (pontuacao > outro.getPontuacao()) {
            return 1;
        } else {
            return 0;
        }
    }

}
