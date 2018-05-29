package model;

import java.io.Serializable;
import java.util.Objects;
import util.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe <b>Baralho</b>, a classe para os objetos do tipo Baralho.
 *
 * @author Matheus Nascimento e Elvis Serafim
 * @since May 2018
 * @version 1.0
 */
public class Baralho implements Serializable {

    private int quantidaDeBaralho;
    private IStack cartas = new Stack();

    /**
     * Construtor de <b>Baralho</b> que não tem parâmetros, apenas para
     * inicializar os atributos.
     *
     */
    public Baralho() {

    }

    /**
     * Método para retorno da pilha de cartas do baralho.
     *
     * @return Pilha de cartas.
     */
    public IStack getCartas() {
        return cartas;
    }

    /**
     *
     * /**
     * Método para designar um novo conjunto para a pilha de cartas do baralho.
     *
     * @param cartas Pilha de cartas.
     */
    public void setCartas(IStack cartas) {
        this.cartas = cartas;
    }

    /**
     * Segundo Construtor de <b>Baralho</b>, tem como parâmetro a quantidade de
     * baralhos que serão criados para a partida. Ele atribui o valor passado
     * para a quantidade de baralho da classe e cria uma pilha de cartas.
     *
     * @param quantidadeBaralho Quantidade de baralhos que serão gerados para a
     * partida.
     */
    public Baralho(int quantidadeBaralho) {

        this.quantidaDeBaralho = quantidadeBaralho;
        cartas = create(quantidadeBaralho);
    }

    private Stack create(int quantidadeBaralho) {           //Método para criar o(s) baralho(s)
        String naipe;
        IStack naipes = new Stack();                        //Pilha para adicionar os naipes das cartas
        for (int i = 0; i < quantidadeBaralho; i++) {       //Controla a quantidade de baralhos a ser criado
            naipes.push("♠");
            naipes.push("♥");
            naipes.push("♦");
            naipes.push("♣");
            int numNaipes = 0;
            Carta nova;
            while (!naipes.isEmpty()) {                     //Enquanto houver naipes
                int numCarta = 1;
                while (numCarta <= 13) {

                    switch (numCarta) {                     //Adiciona o valor da carta
                        case 10:
                            nova = new Carta(Value.Dez.getTipo(), (String) naipes.peek());
                            cartas.push(nova);
                            break;
                        case 11:
                            nova = new Carta(Value.J.getTipo(), (String) naipes.peek());
                            cartas.push(nova);
                            break;
                        case 12:
                            nova = new Carta(Value.Q.getTipo(), (String) naipes.peek());
                            cartas.push(nova);
                            break;
                        case 13:
                            nova = new Carta(Value.K.getTipo(), (String) naipes.peek());
                            cartas.push(nova);
                            break;
                        case 1:
                            nova = new Carta(Value.A.getTipo(), (String) naipes.peek());
                            cartas.push(nova);
                            break;
                        default:
                            nova = new Carta(Integer.toString(numCarta), (String) naipes.peek());
                            cartas.push(nova);
                            break;
                    }
                    numCarta++;
                }
                naipes.pop();
            }
        }
        return (Stack) cartas;                              //retorna uma pilha de cartas
    }

    /**
     * Método para criar um baralho com a mesma quantidade escolhida.
     */
    public void resetaBaralho() {                           //Método não utilizado no projeto, mas que pode ser aproveitado futuramente. Método para criar novo baralho
        cartas = create(quantidaDeBaralho);
    }

    private void imprimeBaralho() {                          //Imprime todas as cartas
        IStack temp = new Stack();

        while (!cartas.isEmpty()) {                         //enquanto houver cartas o loop ira imprimir as informações de cada carta                   
            System.out.println(((Carta) cartas.peek()).toString());
            temp.push(cartas.pop());                        //Pega a carta removida de cima e coloca em uma pilha auxiliar
        }
        cartas = temp;                                      //A pilha original recupera todas as cartas removidas
    }

    /**
     * Método que imprime as cartas, ordenadas ou na ordem que iam ser retiradas
     * do baralho, ao final da partida.
     *
     */
    public void imprimirCartas() {
        System.out.println("Imprimir cartas[1 para desordenadas e 2 para ordenadas]:");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        switch (input) {
            case "1":
                System.out.println("\n \n Restante das cartas: ");
                imprimeBaralho();
                break;
            case "2":
                System.out.println("\n \n Ordenado:");
                ordenarCartas();
                imprimeBaralho();

        }
    }

    /**
     * Método que ordena as cartas do baralho, utilizando o algoritmo Selection
     * Sort.
     *
     */
    public void ordenarCartas() {
        Carta[] cartasO = new Carta[cartas.size()];
        for (int i = 0; !cartas.isEmpty(); i++) {                //Passa as informações da pilha para um array, para que se possa implementar um algoritmos mais simples de ordenação
            cartasO[i] = (Carta) cartas.pop();
        }
        for (int i = 1; i < cartasO.length; i++) {          //Utilizando o método SelectionSort para ordenar de acordo com o naipe
            int j = i;
            while (j > 0 && cartasO[j].compareTo(cartasO[j - 1]) <= 0) {
                Carta aux = cartasO[j - 1];
                cartasO[j - 1] = cartasO[j];
                cartasO[j] = aux;
                j--;
            }

        }
        for (int i = 1; i < cartasO.length; i++) {          //Segunda critério de ordenação, utilizando o SelectionSort para ordenar de acordo com o valor da carta
            int j = i;
            while (j > 0 && cartasO[j].compareTo(cartasO[j - 1]) == 0) {
                if (cartasO[j].getValue().compareTo(cartasO[j - 1].getValue()) < 0) {

                    Carta aux = cartasO[j - 1];
                    cartasO[j - 1] = cartasO[j];
                    cartasO[j] = aux;
                }
                j--;
            }

        }
        for (Carta aux : cartasO) {                         //Repassa todas as cartas para a pilha
            cartas.push(aux);
        }
    }

    /**
     * Método que embaralha as cartas do baralho.
     */
    public void embaralhar() {

        Carta[] cartasEmbara = new Carta[cartas.size()];
        int tamanho = cartas.size();
        for (int i = 0; i < tamanho; i++) {                 //Passa a pilha para um vetor, para poder utilizar de forma mais facíl o objeto Random e assim misturar as cartas
            cartasEmbara[i] = (Carta) cartas.pop();

        }

        Random novoIndice = new Random();

        for (int i = 0; i < cartasEmbara.length * (3 / 2); i++) {      // o 3/2 é só para poder embaralhar mais. 

            int num = novoIndice.nextInt(cartasEmbara.length - 1);
            Carta temp = cartasEmbara[i];
            cartasEmbara[i] = cartasEmbara[num];
            cartasEmbara[num] = temp;

        }
        for (Carta cartasEmbara1 : cartasEmbara) {
            cartas.push(cartasEmbara1);
        }

    }

    /**
     * Método equals para comparar objetos da classe.
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
        final Baralho other = (Baralho) obj;
        return Objects.equals(this.cartas, other.cartas);
    }

    // Método que predefine valor das cartas.
    private enum Value {

        A("Ás", 1),
        J("J", 10),
        Q("Q", 10),
        K("K", 10),
        Dez("Dez", 10);
        private final int valor;
        private final String tipo;

        Value(String tipo, int valor) {
            this.valor = valor;
            this.tipo = tipo;
        }

        public String getTipo() {
            return this.tipo;
        }

        public int getValor() {
            return this.valor;
        }
    }

}
