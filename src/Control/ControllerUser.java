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
public class ControllerUser {

    LinkedList listaJogadores = new LinkedList();
    LinkedList jogadoresNaPartida = new LinkedList();
    ControllerFileJogadores controleFile;

    public ControllerUser() {
        controleFile = new ControllerFileJogadores();
        listaJogadores = controleFile.lerJogadores();
    }

    public void recuperarJogadores() {
        ControllerFileJogadores bancoDados = new ControllerFileJogadores();
    }

    public boolean verificacao(String user, String senha) {
        if(listaJogadores == null){
            return false;
        }
        Iterator iterador = listaJogadores.iterator();

        while (iterador.hasNext()) {

            Jogador procurado = (Jogador) iterador.next();

            if (procurado.getUser().equals(user) && procurado.getPasseword().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public Object recuperarJogador(String user, String senha) {

        Iterator iterador = listaJogadores.iterator();

        while (iterador.hasNext()) {

            Jogador procurado = (Jogador) iterador.next();

            if (procurado.getUser().equals(user) && procurado.getPasseword().equals(senha)) {
                return procurado;
            }
        }
        return null;
    }

    //imcompleto//////////////
    public Jogador cadastrar() throws Exception {
        System.out.println("Bora se cadastrar \n");
        System.out.println("Digita seu nome \n");
        String nome = scanf();
        System.out.println("Escolha uma senha\n");
        String senha = scanf();
        if (verificacao(nome, senha)) {
            System.out.println("Você já está cadastrado");
            return null;
        } else {
            Jogador novoJogador = new Jogador(nome, senha);
            ControllerFileJogadores controleArq = new ControllerFileJogadores();
            listaJogadores.add(novoJogador);
            controleArq.salvarJogador(listaJogadores);
            listaJogadores = controleArq.lerJogadores();
            return novoJogador;

        }

    }
    //imcompleto//////////////

    public void loginJogador() throws Exception {
        String user;
        String senha;
        boolean flag = false;
        System.out.println("Bora fazer login \n");
        System.out.print("Digita seu nome:");
        user = scanf();
        System.out.print("Senha:");
        senha = scanf();
        flag = verificacao(user, senha);
        if (flag) {
            System.out.println("Login aceito!");
            Jogador jogadorLogin = (Jogador) recuperarJogador(user, senha);
            jogadoresNaPartida.add(jogadorLogin);
            tentarLogin();
        } else {
            System.out.println("Login invalido! \n Digite 1 para tentar novamente \n Digite 2 para novo cadastro");
            String opcaoS = scanf();
            switch (opcaoS) {
                case "2":
                    cadastrar();
                    loginJogador();
                    break;
                default:
                    loginJogador();

            }
        }

    }

    private String scanf() {
        Scanner opcao = new Scanner(System.in);
        return opcao.nextLine();
    }

    private void tentarLogin() throws Exception {
        System.out.println("Dejese adicionar mais um jogador? sim ou sair:");
        String opcao = scanf();
        switch (opcao) {
            case "sim":
                loginJogador();
                break;
            case "sair":
                break;
            default:
                System.out.println("Opção inválida!");
                tentarLogin();
                break;
        }
    }

    public void mostrarJogadores() {
        Iterator itera = listaJogadores.iterator();
        while (itera.hasNext()) {
            Jogador jogador = (Jogador) itera.next();
            System.out.println(jogador.getUser());
        }
    }
}
