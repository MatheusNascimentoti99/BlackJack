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
import model.MaoDeCarta;

/**
 *A classe <b>ControllerFileJogadores</b> faz o gerenciamento dos arquivos utilizados no programa
 * @author Matheus Nascimento
 * @since May 2018
 * @version 1.0
 */
public class ControllerFileJogadores {

    /**
     *
     * @param jogadores Parâmetro utilizado para obter a lista de jogadores cadastrados 
     * @throws Exception Exceções ao abrir/ler o arquivo.
     */
    public void salvarJogador(LinkedList jogadores) throws Exception {
        try {
            FileOutputStream arquivoGrav;
            arquivoGrav = new FileOutputStream("Resources/Dados.data");             //Arquivo onde será salvo todos os dados dos jogadores
            try (ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav)) {
                objGravar.writeObject(jogadores);

                objGravar.flush();
            } catch (Exception e) {
            }

            arquivoGrav.flush();
        } catch (IOException e) {
        }
    }

    public LinkedList lerJogadores() {
        LinkedList jogadores = new LinkedList();
        LinkedList jogadoresAux = new LinkedList();
        try {

            try ( //Carrega o arquivo
                    FileInputStream arquivoLeitura = new FileInputStream("Resources/Dados.data"); ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura)) {

                jogadores = (LinkedList) objLeitura.readObject();       //recebe a lista de jogadores gravada no disco e passa para memória
            }

        } catch (IOException | ClassNotFoundException e) {
        }
        for (Object aux : jogadores) {                              //Percorre a lista de jogadores resetando a mão de carta.
            ((Jogador) aux).setMao(new MaoDeCarta());
            ((Jogador) aux).setFlagBlackJack(false);
            jogadoresAux.add(aux);
            
        }
        jogadores = jogadoresAux;
        return jogadores;

    }

    public void imprimirPontuacao(LinkedList jogadores) throws IOException {        
        jogadores = selectionSort(jogadores);                                       //Chama um algoritmo de ordenação para ordenar os jogadores por pontuação
        FileWriter arqPontuacao = new FileWriter("Resources/Pontuação.txt");        //Arquivo que será salvo a pontuação
        try (PrintWriter gravarArq = new PrintWriter(arqPontuacao)) {
            gravarArq.println("Pontuação geral de jogadores:");
            for(Object aux: jogadores){                                             //Laço para imprimir todos os jogadores da lista
                gravarArq.println(((Jogador)aux).toString());
            }
        }catch(Exception exe){
        }
    }

    private LinkedList selectionSort(LinkedList jogadores) {                        
        Jogador[] jogadoresArray = new Jogador[jogadores.size()];

        for (int i = 0; !jogadores.isEmpty(); i++) {
            jogadoresArray[i] = (Jogador) jogadores.remove();
        }
        for (int i = 0; i < jogadoresArray.length; i++) {

            {
                int minIndex = i;
                for (int j = i + 1; j < jogadoresArray.length; j++) {
                    if (jogadoresArray[j].compareTo(jogadoresArray[minIndex]) == 1) {
                        minIndex = j;
                    }
                }
                Jogador temp = jogadoresArray[i];
                jogadoresArray[i] = jogadoresArray[minIndex];
                jogadoresArray[minIndex] = temp;
            }
        }
        for(int i = 0; jogadoresArray.length > i; i++){
            jogadores.add(jogadoresArray[i]);
        }
        return jogadores;
    }

}
