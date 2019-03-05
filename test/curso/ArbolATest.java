package curso;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Victor
 */
public class ArbolATest {
    
    public ArbolATest() {
    }

    /**
     * Test of buscar method, of class ArbolA.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        ArbolA instance = new ArbolA(38);
        // N(38 - [R, A, A, B, A])
        String expResult = "N(38 - [R, A, A, B, A])";
        NodoA result = instance.buscar();
        assertEquals(expResult, result.toString());
    }
    
}
