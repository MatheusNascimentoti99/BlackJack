/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Matheus Nascimento
 */
public class Stack implements IStack, Serializable {

    private Celula head;
    private int size;

    @Override
    public void push(Object data) {                             //Adiciona um node na pilha
        Celula novo = new Celula(data);
        novo.next = head;
        head = novo;
        size++;
    }

    @Override
    public Object pop() {                                       //Remove um node da pilha e retorna o objeto que estava dentro desse node removido
        if (!isEmpty()) {

            Celula temp = head;
            head = head.next;
            size--;
            return temp.data;

        }
        return null;
    }

    @Override
    public Object peek() {                                      //Pega o primeiro objeto da pilha
        return head.data;
    }

    @Override
    public boolean isEmpty() {                                      //Verifica se a pilha está vazia
        return head == null;
    }

    @Override
    public int size() {                                             //Retorna o tamanho da pilha
        return size;
    }

    private class Celula implements Serializable {                                           //Subclasse para o funcionamento da pilha

        Object data;
        Celula next;

        private Celula(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Celula getNext() {
            return next;
        }

        public void setNext(Celula next) {
            this.next = next;
        }

    }
}
