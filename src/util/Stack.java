/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

public class Stack implements IStack{
    private Celula head;
    private int size;
    @Override
    public void push(Object data) {
        Celula novo = new Celula(data);
        novo.next = head;
        head = novo;
        size++;
    }

    @Override
    public Object pop() {
        if(!isEmpty()){
            
            Celula temp = head;
            head = head.next;
            size--;
            return temp.data;
            
        }
        return null;
    }

    @Override
    public Object peek() {
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head== null;
    }

    @Override
    public int size() {
        return size;
    }
    
    private class Celula{
        Object data;
        Celula next;
        private Celula(Object data){
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

