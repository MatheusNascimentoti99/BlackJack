
package util;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;



public class StackTest {
    
        Stack pilha;
	Object dado1, dado2, dado3;

	@Before
	public void setUp() throws Exception {
		pilha = new Stack();
		dado1 = "Objeto 1";
		dado2 = "Objeto 2";
		dado3 = "Objeto 3";
	}
          
    // Teste do método Push, da classe Stack.
    @Test
    public void testPush() {
        
      assertTrue(pilha.isEmpty());
      
      pilha.push(dado1);
      assertFalse(pilha.isEmpty());
      assertSame(dado1, pilha.peek());
      
      pilha.push(dado2);
      assertFalse(pilha.isEmpty());
      assertSame(dado2, pilha.peek());
      
      pilha.push(dado3);
      assertFalse(pilha.isEmpty());
      assertSame(dado3, pilha.peek());
      
      pilha.pop();
      pilha.pop();
      pilha.pop();
        
      assertTrue(pilha.isEmpty());
        
    }

    // Teste do método Pop, da classe Stack.
    @Test
    public void testPop() {
        
        pilha.push(dado1);
        pilha.push(dado2);
        pilha.push(dado3);
        
        assertFalse(pilha.isEmpty());
        
        assertSame(dado3, pilha.pop());
        assertFalse(pilha.isEmpty());
        
        assertSame(dado2, pilha.pop());
        assertFalse(pilha.isEmpty());
        
        assertSame(dado1, pilha.pop());
        assertTrue(pilha.isEmpty());
      
        
    }

    // Teste do método Peek, da classe Stack.
    @Test
    public void testPeek() {
        
        pilha.push(dado1);
        pilha.push(dado2);
        pilha.push(dado3);
        
        assertFalse(pilha.isEmpty());
        assertSame(dado3, pilha.peek());
        pilha.pop();
        
        assertFalse(pilha.isEmpty());
        assertSame(dado2, pilha.peek());
        pilha.pop();
        
        assertFalse(pilha.isEmpty());
        assertSame(dado1, pilha.peek());
        pilha.pop();
        
        assertTrue(pilha.isEmpty());
        
    }

    // Teste do método isEmpty, da classe Stack.
    @Test
    public void testIsEmpty() {
        
        assertTrue(pilha.isEmpty());
    }

    // Teste do método Size, da classe Stack.
    @Test
    public void testSize() {
        
        assertEquals(0, pilha.size());
        
        pilha.push(dado1);
        assertEquals(1, pilha.size());
        
        pilha.push(dado2);
        pilha.push(dado2);
        assertEquals(3, pilha.size());
        
        pilha.pop();
        assertEquals(2, pilha.size());
        
        pilha.pop();
        pilha.pop();
        assertEquals(0, pilha.size());
    }
    
}
