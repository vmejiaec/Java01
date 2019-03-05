package curso;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Victor
 */
public class NodoATest {
    
    public NodoATest() {
    }
    
    /**
     * Test of Generar cuando es el nodo raiz
     */
    @Test
    public void testGenerar_0args() {
        System.out.println("Generar");
        NodoA instance = new NodoA();
        //[N(6 - [R, A]), N(3 - [R, B])]
        NodoA[] expResult = new NodoA[]{
            new NodoA(6,new NodoA.RamaTipo[]{NodoA.RamaTipo.R,NodoA.RamaTipo.A}),
            new NodoA(3,new NodoA.RamaTipo[]{NodoA.RamaTipo.R,NodoA.RamaTipo.B})
        };        
        //
        NodoA[] result = instance.Generar();
        assertArrayEquals(expResult, result);        
    }

    /**
     * Test of Generar cuando tiene límite
     */
    @Test
    public void testGenerar_int() {
        System.out.println("Generar");        
        int limite = 4;
        NodoA instance = new NodoA();
        NodoA[] expResult = new NodoA[]{
            //new NodoA(6,new NodoA.RamaTipo[]{NodoA.RamaTipo.R,NodoA.RamaTipo.A}),
            new NodoA(3,new NodoA.RamaTipo[]{NodoA.RamaTipo.R,NodoA.RamaTipo.B})
        };    
        NodoA[] result = instance.Generar(limite);
        
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of Verifica method, of class NodoA.
     */
    @Test
    public void testVerifica() {
        System.out.println("Verifica");
        int test = 6;
        NodoA instance = new NodoA();
        instance = instance.Generar()[0];
        boolean expResult = true;
        boolean result = instance.Verifica(test);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class NodoA.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        NodoA instance = new NodoA();
        String expResult = "N(1 - [R])";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
