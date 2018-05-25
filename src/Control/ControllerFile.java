/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import model.Jogador;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;
import java.io.PrintWriter;/**
 * A classe <b>ControllerFileJogadores</b> faz o gerenciamento dos arquivos
 * utilizados no programa.
 *
 * @author Matheus Nascimento e Elvis Serafim
 * @since May 2018
 * @version 1.0
 */
import java.util.LinkedList;
import model.MaoDeCarta;
import util.IStack;
import util.SelectionSort;

/**
 * A classe <b>ControllerFileJogadores</b> faz o gerenciamento dos arquivos
 * utilizados no programa.
 *
 * @author Matheus Nascimento e Elvis Serafim
 * @since May 2018
 * @version 1.0
 */
public class ControllerFile {

    /**
     * <b>salvarJogador</b> é utilidado para gravar as informações da lista de
     * jogadores no arquivo binário <i>Dados.data</i>.<p>
     * <b>Exemple:</b> salvarJogador(listaDeJogadores);
     *
     * @param dados Parâmetro utilizado para obter a lista de jogadores cadastrados.
     * @param local Parâmetro utilizado para informar o diretório do arquivo.
     * @throws Exception Exceções ao abrir/gravar o arquivo.
     *
     */
    public void salvarArquivo(Object dados, String local) throws Exception {
        try {
            FileOutputStream arquivoGrav;
            arquivoGrav = new FileOutputStream(local);             
            try (ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav)) {
                objGravar.writeObject(dados);

                objGravar.flush();
            } catch (Exception e) {
            }

            arquivoGrav.flush();
        } catch (IOException e) {
        }
    }

    /**
     * <b>recuperarJogadores</b> é utilidado para recuperar as informações da lista de jogadores no arquivo binário <i>Dados.data</i>.<p>     
     *
     * @return  Retorna a lista de jogadores que está no arquivo binário.
     */
    public LinkedList recuperarJogadores() {
        LinkedList jogadores;
        LinkedList jogadoresAux = new LinkedList();
        jogadores = (LinkedList) lerArquivo("Resources/Dados.data");
        for (Object aux : jogadores) {                              
            ((Jogador) aux).setMao(new MaoDeCarta());
            ((Jogador) aux).setFlagBlackJack(false);
            jogadoresAux.add(aux);

        }
        jogadores = jogadoresAux;
        return jogadores;

    }

    /**
     * <b>recuperarBaralho</b> É utilidado para recuperar as informações da pilha de baralhos no arquivo binário <i>baralho.data</i>.<p>     
     *
     * @return  Retorna uma pilha de cartas.
     */
    public IStack recuperarBaralho() {
        IStack cartas;
        try {
            cartas = (IStack) lerArquivo("Resources/baralho.data");
        } catch (ClassCastException exe) {
            return  null;
        }

        return cartas;
    }

    private Object lerArquivo(String local) {
        Object dado = new Object();
        try {

            try ( 
                    FileInputStream arquivoLeitura = new FileInputStream(local); ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura)) {

                dado = objLeitura.readObject();       
            }

        } catch (IOException | ClassNotFoundException e) {
        }
        return dado;
    }

    /**
     *<b>imprimirPontuacao</b> é utilidado para imprimir as informações de todos os jogadores no arquivo de texto <i>pontuação.txt</i>.<p>     
     * @param jogadores É a lista atualizada com todos os jogadores cadastrados no sistema.
     * @throws IOException Exceções ao abrir/gravar o arquivo.
     */
    public void imprimirPontuacao(LinkedList jogadores) throws IOException {
        jogadores = ordenar(jogadores);                                       
        FileWriter arqPontuacao = new FileWriter("Resources/Pontuação.txt");        
        try (PrintWriter gravarArq = new PrintWriter(arqPontuacao)) {
            gravarArq.println("Pontuação geral de jogadores:");
            for (Object aux : jogadores) {                                             
                gravarArq.println(((Jogador) aux).toString());
            }
        } catch (Exception exe) {
        }
    }

    private LinkedList ordenar(LinkedList jogadores) {
        Jogador[] jogadoresArray = new Jogador[jogadores.size()];
        SelectionSort ordenacao = new SelectionSort();
        for (int i = 0; !jogadores.isEmpty(); i++) {
            jogadoresArray[i] = (Jogador) jogadores.remove();
        }
        ordenacao.selectionsSorte(jogadoresArray);
        for (int i = 0; jogadoresArray.length > i; i++) {
            jogadores.add(jogadoresArray[i]);
        }
        return jogadores;
    }

}
