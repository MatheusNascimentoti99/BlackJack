package view;

import Control.Controller;
import java.util.LinkedList;
import java.util.Scanner;
import model.Baralho;
import model.Baralho.Carta;
import util.IStack;
import util.Stack;

public class Partida {

    public static void main(String args[]) {
        Scanner lerescolha = new Scanner(System.in);
        Scanner leruser = new Scanner(System.in);
        Scanner lersenha = new Scanner(System.in);
        Controller control = new Controller();
        int escolha;
        System.out.println(" Jogo BlackJack \n");
        
        //for só pra testar mano se aparecia que se tava cadastrado.
        for (int i = 0; i <2;i++){
        System.out.println("Deseja fazer login ou se cadastrar no jogo ? Tecle 1 para login e 2 para cadastro \n");
        escolha = lerescolha.nextInt();
        
        
        if (escolha == 1) {
            System.out.println("Vamos verificar se tu ta cadastrado \n");
            System.out.println("Digite seu usuario e sua senha \n");
            String user;
            String senha;
            user = leruser.next();
            senha = lersenha.next();

            boolean verifica = control.verificacao(user, senha);
            if (verifica == true) {
                System.out.println("Tu ta cadastrado mesmo bicho");
            } else {
                System.out.println("Jogador não encontrado, tentar novamente ou se cadastrar ? \n");
            }

        } else if (escolha == 2) {
            System.out.println("Bora se cadastrar \n");
            System.out.println("Digita seu nome \n");
            String nome;
            Scanner lernome = new Scanner(System.in);
            nome = lernome.next();
            control.cadastro(nome);
        }

        Baralho novo = new Baralho();
        System.out.println(":D");
        System.out.println(":D");
        System.out.println(":D");
        System.out.println(":)");
        novo.imprimeBaralho();
        novo.embaralhar();
        System.out.println("\n");
        novo.imprimeBaralho();
        }
    }

}
