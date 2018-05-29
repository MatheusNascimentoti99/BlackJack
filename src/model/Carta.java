/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe <b>Carta</b>, a classe para os objetos do tipo Carta.
 *
 * @author Matheus Nascimento e Elvis Serafim
 * @since May 2018
 * @version 1.0
 */
public class Carta implements Comparable, Serializable {

    private String value;
    private String naipe;

    /**
     * Construtor da classe <b>Carta</b> tem como parâmetro o valor da carta e o
     * naipe. Atribui os valores passados para os atributos da classe.
     *
     * @param value Valor da carta.
     * @param naipe Naipe da carta.
     */
    public Carta(String value, String naipe) {
        this.value = value;
        this.naipe = naipe;
    }

    /**
     *
     * /**
     * Método para retorno do valor da carta.
     *
     * @return Valor da carta.
     */
    public String getValue() {
        return value;
    }

    /**
     * Método para designar um novo valor para a carta.
     *
     * @param value Novo valor da carta.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Método para retorno do naipe da carta.
     *
     * @return Naipe da carta.
     */
    public String getNaipe() {
        return naipe;
    }

    /**
     * Método para designar um novo naipe para a carta.
     *
     * @param naipe Novo naipe da carta.
     */
    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    /**
     * Método que retorna uma representação string do objeto carta.
     *
     * @return Naipe e valor da carta.
     */
    @Override
    public String toString() {
        return ("[Naipe:" + naipe + " Valor:" + value + "]");
    }

    /**
     * Método para comparar objetos da classe.
     *
     * @param obj objeto a ser comparado.
     * @return booleano, true ou false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return Objects.equals(this.naipe, other.naipe);
    }

    @Override
    public int compareTo(Object o) {
        return naipe.compareTo(((Carta) o).getNaipe());

    }

}
