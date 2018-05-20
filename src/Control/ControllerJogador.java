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
public class ControllerJogador {

    LinkedList listaJogadores = new LinkedList();                       //Lista de todos os jogadores cadastrados no jogo
    LinkedList jogadoresNaPartida = new LinkedList();                   //Lista com jogadores apenas que estão em uma partida
    ControllerFileJogadores controleFile = new ControllerFileJogadores();       //Para poder ter recuperação de dados dos arquivos

    public ControllerFileJogadores getControleFile() {
        return controleFile;
    }

    public ControllerJogador() {
        controleFile = new ControllerFileJogadores();
        listaJogadores = controleFile.lerJogadores();
    }

    public boolean verificacao(String user, String senha, LinkedList listaJogadores) {
        if (listaJogadores == null) {       //Verifica se há lista de jogadores
            return false;
        }
        Iterator iterador = listaJogadores.iterator();

        while (iterador.hasNext()) {            //Percorre toda a lista até encontrar o jogador

            Jogador procurado = (Jogador) iterador.next();

            if (procurado.getUser().equals(user) && procurado.getPasseword().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificacao(String user, LinkedList listaJogadores) {        //Para verificar se o usuário já está cadastrado, essa verificação é feita procurando pelo nome
        if (listaJogadores == null) {
            return false;
        }
        Iterator iterador = listaJogadores.iterator();

        while (iterador.hasNext()) {

            Jogador procurado = (Jogador) iterador.next();

            if (!procurado.getUser().equals(user)) {
            } else {
                return true;
            }
        }
        return false;
    }

    public Object recuperarJogador(String user, String senha) {                 //Retorna o jogador que tever o mesmo nome e senha que foi passado por parâmetro.

        Iterator iterador = listaJogadores.iterator();

        while (iterador.hasNext()) {

            Jogador procurado = (Jogador) iterador.next();

            if (procurado.getUser().equals(user) && procurado.getPasseword().equals(senha)) {   //Verifica a senha e o nome do usuário
                return procurado;
            }
        }
        return null;
    }

    public Jogador cadastrar() throws Exception {
        System.out.println("## Bora se cadastrar ##");
        System.out.println("Digita seu nome \n");
        String nome = input();
        System.out.println("Escolha uma senha\n");
        String senha = input();
        if (verificacao(nome, listaJogadores)) {        //Faz a verificação para ver se o jogador já está na lista
            System.out.println("Você já está cadastrado");
            return null;
        } else {                                        //Se não estiver, então o usuário é adicionado na lista
            Jogador novoJogador = new Jogador(nome, senha);
            listaJogadores.add(novoJogador);
            controleFile.salvarJogador(listaJogadores);     //Grava a lista de jogadores atualizada no arquivo binário
            listaJogadores = controleFile.lerJogadores();
            return novoJogador;

        }

    }

    public void loginJogador() throws Exception {           //Método que será chamado para adicionar o jogodor na partida
        String user;
        String senha;
        boolean flagJogadorCadastr = false;
        System.out.println("Bora fazer login \n");
        System.out.print("Digita seu nome:");
        user = input();
        System.out.print("Senha:");
        senha = input();
        flagJogadorCadastr = verificacao(user, senha, listaJogadores);
        Boolean flagJogadorPartida = verificacao(user, senha, jogadoresNaPartida);     //Verifica se o jogador já faz o login na partida
        if (flagJogadorPartida) {
            System.out.println("Tentativa invalida! " + user + " já está na partida.");
            tentarLogin();
        } else if (flagJogadorCadastr && !flagJogadorPartida) {                          //Se jogador estiver cadastrado e não estiver na partida, então o login será aceito
            System.out.println("Login aceito!");
            Jogador jogadorLogin = (Jogador) recuperarJogador(user, senha);
            jogadoresNaPartida.add(jogadorLogin);
            tentarLogin();
        } else {
            System.out.println("Login invalido! \n Digite 1 para tentar novamente \n Digite 2 para novo cadastro");
            String opcaoS = input();
            switch (opcaoS) {
                case "2":
                    cadastrar();

                    break;
                case "1":
                    loginJogador();
                    break;
                default:
                    loginJogador();
            }
        }

    }

    private String input() {
        Scanner opcao = new Scanner(System.in);
        return opcao.nextLine();
    }

    private void tentarLogin() throws Exception {
        System.out.println("Dejese adicionar mais um jogador? sim ou sair:");
        String opcao = input();
        switch (opcao) {
            case "sim":
                if (jogadoresNaPartida.size() == 5) {
                    System.out.println("Partida sem vagas");
                } else {
                    loginJogador();
                }
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

    public LinkedList getListaJogadores() {
        return listaJogadores;
    }

    public LinkedList getJogadoresNaPartida() {
        return jogadoresNaPartida;
    }

}
