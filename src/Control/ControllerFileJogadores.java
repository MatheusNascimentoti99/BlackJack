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

/**
 *
 * @author Matheus Nascimento
 */
public class ControllerFileJogadores {

    public void salvarJogador(LinkedList jogadores) throws Exception {
        try {
            FileOutputStream arquivoGrav;
            arquivoGrav = new FileOutputStream("Resources/arq.txt");
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
        LinkedList jogador = null;
        try {

            try ( //Carrega o arquivo
                    FileInputStream arquivoLeitura = new FileInputStream("Resources/arq.txt"); ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura)) {
                
                jogador = (LinkedList) objLeitura.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
        }

        return jogador;

    }

}


