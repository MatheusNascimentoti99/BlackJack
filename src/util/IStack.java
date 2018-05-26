
package util;

/**
 *A classe <b>ISatck</b> é uma interface para o desenvolvimento da estrutuda <i>pilha</i>. Estrutura essa que só é possível adicionar objetos no final e remover no final.
 * @author Matheus Nascimento e Elvis Serafim.
 * @since May 2018.
 * @version 1.0.
 */


public interface IStack {

    /**
     *O método <b>push</b> adiciona uma célula no final da pilha.
     * @param data É o objeto que será guardado dentro de uma célula.
     */
    public void push(Object data);

    /**
     *O método <b>pop</b> remove a última célula da pilha.
     * @return Retorna o objeto que está na celula que foi removida.
     */
    public Object pop();

    /**
     *O método <b>peek</b> possibilita capturar o último objeto que está na pilha.
     * @return Retorna o objeto que está na última célula da <i>pilha</i>.
     */
    public Object peek();

    /**
     *O método <i>isEmpty</i> verifica se a pilha está vazia.
     * @return Caso a pilha esteja vazia, então é retornado <i>true</i>, se não retorna <i>false</i>. 
     */
    public boolean isEmpty();
    
    /**
     *
     * @return Retorna o tamanho da pilha.
     */
    public int size();
}

