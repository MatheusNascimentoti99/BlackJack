/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe <b>MaoDeCarta</b>, a classe para os objetos do tipo MaoDeCarta.
 * 
 * @author Matheus Nascimento e Elvis Serafim
 * @since May 2018
 * @version 1.0
 */
public class Jogador implements Serializable, Comparable {

    private String user;
    private String passeword;
    private int pontuacao;
    private int partidaVencidas;
    private MaoDeCarta mao;
    private boolean flagBlackJack;// Atributo para verificar se o jogador tem um blackJack ou não.

    /**
     * Construtor da classe <b>Jogador</b>, tem como parâmetros, o usuário e a senha do jogador. 
     * Atribui os valores passados para os atributos da classe e cria uma nova mão de carta.
     * 
     * @param user Usuário do jogador.
     * @param passeword Senha do jogador.
     */
    public Jogador(String user, String passeword) {
        this.user = user;
        this.passeword = passeword;
        this.mao = new MaoDeCarta();
    }

    @Override
    public String toString() {
        return "\nNome: " + user + " --- Pontuação: " + pontuacao + " -- Partidas vencidas: " + partidaVencidas;

    }

    /**
     * Método para retorno da mão de carta do jogador.
     * 
     * @return a mão de carta do jogador.
     */
    public MaoDeCarta getMao() {
        return mao;
    }

    /**
     * Método para designar uma nova mão de carta para o jogador.
     * 
     * @param mao Mão de Carta.
     */
    public void setMao(MaoDeCarta mao) {
        this.mao = mao;
    }

    /**
     * Método para retorno da pontuação do jogador.
     * 
     * @return pontuação do jogador.
     */
    public int getPontuacao() {
        return pontuacao;
    }

    /**
     * Método para retorno da quantidade de partidas vencidas pelo jogador.
     * 
     * @return partida vencidas pelo jogador.
     */
    public int getPartidaVencidas() {
        return partidaVencidas;
    }

    /**
     * Método para somar a quantidade de partidas vencidas com a quantidade de partida vencida passado por parâmetro.
     * 
     * @param partidaGanhas partidas ganhas a serem somadas.
     */
    public void setPartidaVencidas(int partidaGanhas) {
        this.partidaVencidas = partidaVencidas + partidaGanhas;
    }

    /**
     * Método para retorno do usuário do jogador.
     * 
     * @return usuário do jogador.
     */
    public String getUser() {
        return user;
    }

    /**
     * Método para designar um novo usuário para o jogador.
     * 
     * @param user novo usuário do jogador.
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Método para retorno da senha do jogador.
     * 
     * @return senha do jogador.
     */
    public String getPasseword() {
        return passeword;
    }

    /**
     * Método para designar uma nova senha para o jogador.
     * 
     * @param passeword nova senha do jogador.
     */
    public void setPasseword(String passeword) {
        this.passeword = passeword;
    }

    
    /**
     * Método booleano em que o jogador pede carta ou não. Se retornar true, o jogador deseja mais carta, se retornar false,
     * o jogador não deseja mais carta.
     * @param escolha escolha do jogador, se deseja ou não mais cartas.
     * @return boolean, true ou false.
     */
      public boolean pedirCarta(String escolha) {
        switch (escolha) {
            case "pedir":
                return true;
            case "parar":
                return true;
            }
        
        return false;
    }

    /**
     * Método para retorno do atributo flagBlackJack. Se retornar true, o jogador tem um blackJack, se retornar false,
     *  o jogador não tem um blackJack.
     * @return o flagBlackJack, true ou false.
     */
    public boolean getFlagBlackJack() {
        return flagBlackJack;
    }

    /**
     * Método para designar um novo valor, true ou false, para FlagBlackJack.
     * 
     * @param flagBlackJack valor booleano, true ou false.
     */
    public void setFlagBlackJack(boolean flagBlackJack) {
        this.flagBlackJack = flagBlackJack;
    }

    /**
     * Método para somar a pontuação do jogador com os pontos passados por parâmetros.
     * @param pontos pontos a serem somados.
     */
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


