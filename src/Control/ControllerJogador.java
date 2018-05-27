/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.Iterator;
import java.util.LinkedList;
import model.Jogador;

/**
 * A classe <b>ControllerJogador</b> faz o gerenciamento de jogadores.
 *
 * @author Matheus Nascimento e Elvis Serafim
 * @since May 2018
 * @version 1.0
 */
public class ControllerJogador {

    private LinkedList listaJogadores = new LinkedList();                       //Lista de todos os jogadores cadastrados no jogo
    private LinkedList jogadoresNaPartida = new LinkedList();                   //Lista com jogadores apenas que estão em uma partida
    private ControllerFile controleFile = new ControllerFile();                 //Para poder ter recuperação de dados dos arquivos

    /**
     * O construtor de <b>ControllerJo</b> cria um novo genrenciador de arquivo
     * e recupera a lista de jogadores que está no arquivo binário.
     */
    public ControllerJogador() {
        controleFile = new ControllerFile();
        listaJogadores = controleFile.recuperarJogadores();
    }

    /**
     * O método <b>verificacao</b> procura um jogador na lista de jogadores que
     * tenha o mesmo usuário e senha.
     *
     * @param user Parâmetro utilizado para identificar o nome do usuário.
     * @param senha Parâmetro utilizado para identificar a senha do usuário.
     * @param listaJogadores Parâmetro utilizado para percorrer uma dada lista de jogadores para verificar se há um determinado jogador com o mesmo nome e senha.
     * @return Retorna um valor booleano, se o usuário existir na lista é
     * retornado <i>true</i>, se não for encontrado retorna <i>false</i>.
     */
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

    /**
     * O método <b>verificacao</b> procura um jogador na lista de jogadores que
     * tenha o mesmo usuário. Método utilizado para não ter usuários com o mesmo
     * nome.
     *
     * @param user Parâmetro utilizado para identificar o nome do usuário.
     * @param listaJogadores Parâmetro utilizado para percorrer uma dada lista de jogadores para verificar se há um determinado jogador com o mesmo nome e senha.
     * @return Retorna um valor booleano, se o usuário existir na lista é
     * retornado <i>true</i>, se não for encontrado retorna <i>false</i>.
     */
    public boolean verificacao(String user, LinkedList listaJogadores) {        //Para verificar se o usuário já está cadastrado, essa verificação é feita procurando pelo nome
        if (listaJogadores == null) {
            return false;
        }
        Iterator iterador = listaJogadores.iterator();

        while (iterador.hasNext()) {            //Percorre toda a lista até encontrar o jogador

            Jogador procurado = (Jogador) iterador.next();

            if (procurado.getUser().equals(user)) {
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

    public Boolean cadastrar(String nome, String senha) throws Exception {

        if (verificacao(nome, listaJogadores)) {        //Faz a verificação para ver se o jogador já está na lista 
            return false;
        } else {                                        //Se não estiver, então o usuário é adicionado na lista
            Jogador novoJogador = new Jogador(nome, senha);
            listaJogadores.add(novoJogador);
            controleFile.salvarArquivo(listaJogadores, "Resources/Dados.data");     //Grava a lista de jogadores atualizada no arquivo binário
            listaJogadores = controleFile.recuperarJogadores();
            return true;

        }

    }

    public boolean loginJogador(String user, String senha) throws Exception {           //Método que será chamado para adicionar o jogodor na partida.

        if (verificacao(user, jogadoresNaPartida)) {
            return false;
        } else if(!verificacao(user, senha, listaJogadores)){
            return false;
        }                        
        Jogador jogadorLogin = (Jogador) recuperarJogador(user, senha);
        jogadoresNaPartida.add(jogadorLogin);
        return true;

    }

    public Iterator mostrarJogadores() {
        return listaJogadores.iterator();

    }

    public LinkedList getListaJogadores() {
        return listaJogadores;
    }

    public void setListaJogadores(LinkedList listaJogadores) {
        this.listaJogadores = listaJogadores;
    }
    
    

    public LinkedList getJogadoresNaPartida() {
        return jogadoresNaPartida;
    }

    public ControllerFile getControleFile() {
        return controleFile;
    }
}
