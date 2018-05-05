/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

public class Stack implements IStack{
    Celula head;
    
    @Override
    public void push(Object data) {
        Celula novo = new Celula(data);
        novo.next = head;
        head = novo;
    }

    @Override
    public Object pop() {
        if(!isEmpty()){
            
            Celula temp = head;
            head = head.next;
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

