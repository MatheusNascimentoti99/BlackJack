package view;

import model.Baralho;
import model.Baralho.Carta;
import util.IStack;

public class Partida {

    public static void main(String args[]) {
        Baralho novo = new Baralho();
        System.out.println(":D");
        System.out.println(":D");
        System.out.println(":D");System.out.println(":)");
        
        if (args.equals("cartas")) {
            while (!novo.getCartas().isEmpty()) {
                Carta carta = (Carta) novo.getCartas().pop();
                System.out.println("naipe:" + carta.getNaipe() + "Valor:" + carta.getValue());
            }
        } else {
            System.out.println(":)");
        }
    }

}
