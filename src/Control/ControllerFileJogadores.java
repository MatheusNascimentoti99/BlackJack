/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import model.Jogador;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;
import java.util.LinkedList;
import model.MaoDeCarta;

/**
 *
 * @author Matheus Nascimento
 */
public class ControllerFileJogadores {

    public void salvarJogador(LinkedList jogadores) throws Exception {
        try {
            FileOutputStream arquivoGrav;
            arquivoGrav = new FileOutputStream("Resources/arq.data");
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
        try {

            try ( //Carrega o arquivo
                    FileInputStream arquivoLeitura = new FileInputStream("Resources/arq.data"); ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura)) {

                jogadores = (LinkedList) objLeitura.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
        }
        for( Object aux: jogadores){
            ((Jogador)aux).setMao(new MaoDeCarta());
        }
        return jogadores; 

    }

}
