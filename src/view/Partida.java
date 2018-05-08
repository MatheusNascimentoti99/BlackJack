package view;

import model.Baralho;
import model.Baralho.Carta;
import util.IStack;
import util.Stack;

public class Partida {

    public static void main(String args[]) {
        Baralho novo = new Baralho();
        System.out.println(":D");
        System.out.println(":D");
        System.out.println(":D");System.out.println(":)");
        IStack temp = new Stack();
            while (!novo.getCartas().isEmpty()){
                temp.push((Carta)novo.getCartas().pop());
                System.out.println("naipe:" + ((Carta)temp.peek()).getNaipe() + "Valor:" + ((Carta)temp.peek()).getValue());
            }
            novo.setCartas(temp);
            novo.embaralhar();
            while (!novo.getCartas().isEmpty()){
                Carta carta = (Carta) novo.getCartas().pop();
                System.out.println("naipe:" + carta.getNaipe() + "Valor:" + carta.getValue());
            }

    }

}
