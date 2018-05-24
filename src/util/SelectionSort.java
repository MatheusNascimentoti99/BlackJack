/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.Jogador;

/**
 *
 * @author Matheus Nascimento
 */
public class SelectionSort {

    public void selectionsSorte(Comparable[] obj) {
        for (int i = 0; i < obj.length; i++) {

            {
                int minIndex = i;
                for (int j = i + 1; j < obj.length; j++) {
                    if (obj[j].compareTo(obj[minIndex]) == 1) {
                        minIndex = j;
                    }
                }
                Comparable temp = obj[i];
                obj[i] = obj[minIndex];
                obj[minIndex] = temp;
            }
        }
    }
}
