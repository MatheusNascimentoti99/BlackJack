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
import java.io.PrintWriter;
import java.util.LinkedList;
import model.Baralho;
import model.MaoDeCarta;
import util.IStack;
import util.SelectionSort;
import util.Stack;

/**
 * A classe <b>ControllerFileJogadores</b> faz o gerenciamento dos arquivos
 * utilizados no programa
 *
 * @author Matheus Nascimento
 * @since May 2018
 * @version 1.0
 */
public class ControllerFile {

    /**
     * <b>salvarJogador</b> é utilidado para gravar as informações da lista de
     * jogadores no arquivo binário <i>Dados.data</i>.<p>
     * <b>Exemple:</b> salvarJogador(listaDeJogadores);
     *
     * @param dados Parâmetro utilizado para obter a lista de jogadores
     * cadastrados
     * @throws Exception Exceções ao abrir/ler o arquivo.
     *
     */
    public void salvarArquivo(Object dados, String local) throws Exception {
        try {
            FileOutputStream arquivoGrav;
            arquivoGrav = new FileOutputStream(local);             //Arquivo onde será salvo todos os dados dos jogadores
            try (ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav)) {
                objGravar.writeObject(dados);

                objGravar.flush();
            } catch (Exception e) {
            }

            arquivoGrav.flush();
        } catch (IOException e) {
        }
    }

    public LinkedList recuperarJogadores() {
        LinkedList jogadores;
        LinkedList jogadoresAux = new LinkedList();
        jogadores = (LinkedList) lerArquivo("Resources/Dados.data");
        for (Object aux : jogadores) {                              //Percorre a lista de jogadores resetando a mão de carta.
            ((Jogador) aux).setMao(new MaoDeCarta());
            ((Jogador) aux).setFlagBlackJack(false);
            jogadoresAux.add(aux);

        }
        jogadores = jogadoresAux;
        return jogadores;

    }

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

            try ( //Carrega o arquivo
                    FileInputStream arquivoLeitura = new FileInputStream(local); ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura)) {

                dado = objLeitura.readObject();       //recebe os dados gravados no disco e passa para memória
            }

        } catch (IOException | ClassNotFoundException e) {
        }
        return dado;
    }

    public void imprimirPontuacao(LinkedList jogadores) throws IOException {
        jogadores = ordenar(jogadores);                                       //Chama um algoritmo de ordenação para ordenar os jogadores por pontuação
        FileWriter arqPontuacao = new FileWriter("Resources/Pontuação.txt");        //Arquivo que será salvo a pontuação
        try (PrintWriter gravarArq = new PrintWriter(arqPontuacao)) {
            gravarArq.println("Pontuação geral de jogadores:");
            for (Object aux : jogadores) {                                             //Laço para imprimir todos os jogadores da lista
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
