/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import model.Jogador;

/**
 *
 * @author Usuário 01
 */
public class Controller {
    
    LinkedList listaJogadores = new LinkedList();
    
    public Controller() {
        
    }
    
    public boolean verificacao(String user, String senha) {
        
        Iterator iterador = listaJogadores.iterator();
        
        while (iterador.hasNext()) {
            
            Jogador procurado = (Jogador) iterador.next();
            
            if (procurado.getUser().equals(user) && procurado.getPasseword().equals(senha)) {
                return true;
            }
        }
        return false;
    }
    
    public void cadastro(String nome) {
        
        System.out.println("Escolha uma senha\n");
        Scanner leitura = new Scanner(System.in);
        String senha;
        senha = leitura.nextLine();
        
        Jogador novoJogador = new Jogador(nome, senha);
        listaJogadores.add(novoJogador);
        
        Iterator itera = listaJogadores.iterator();
        while (itera.hasNext()) {
            Jogador jogador = (Jogador) itera.next();
            System.out.println(jogador.getUser());
        }
    }
}
