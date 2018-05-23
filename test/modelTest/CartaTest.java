/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelTest;

import model.Carta;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matheus Nascimento
 */
public class CartaTest {
    Carta c1;

    @Before
    public void setUp() throws Exception {
        c1 = new Carta("10", "♥");
        
    }

    @Test
    public void testBasic() {
        
        assertEquals("10", c1.getValue());
        assertEquals("♥", c1.getNaipe());

        Carta c2 = new Carta("2", "♠");
        assertFalse(c1.equals(c2));
        c2.setNaipe("♥");
        c2.setValue("10");
        
        assertTrue(c1.equals(c2));
        
        assertTrue(c1.compareTo(c2) == 0);
        c2.setNaipe("♦");
        assertFalse(c1.compareTo(c2) == 0);
       
    }
}
