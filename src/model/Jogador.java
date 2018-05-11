/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Matheus Nascimento
 */
public class Jogador {
    private String user;
    private String passeword;
    private int pontuacao;
    private int partidaVencidas;
    private MaoDeCarta mao;

    public Jogador(String user, String passeword) {
        this.user = user;
        this.passeword = passeword;
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

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getPartidaVencidas() {
        return partidaVencidas;
    }

    public void setPartidaVencidas(int partidaVencidas) {
        this.partidaVencidas = partidaVencidas;
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
            return -1;
        }
        if (this.pontuacao < jogador.getPontuacao()) {
            return 1;
        }
        return 0;
    }
}
