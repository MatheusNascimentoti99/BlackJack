/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 * A classe <b>SelectionSort</b> tem a ação de ordenar objetos comparaveis,
 * usando como estrutura de ordenação o próprio <i>Selectionsort</i>
 *
 * @since May 2018
 * @version 1.0
 * @author Matheus Nascimento
 */
public class SelectionSort {

    /**
     * O método <b>selectionSort</b> é o responsavel pela estrutura de ordenação
     * utilizada pela classe.
     *
     * @param obj É o conjuto de <i>objetos</i> comparaveis que a estrutura de
     * ordenação utilizará.
     */
    public void selectionSort(Comparable[] obj) {
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
