/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Enumerados;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class TipoListaDeReproduccionTest {
    
    public TipoListaDeReproduccionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class TipoListaDeReproduccion.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        TipoListaDeReproduccion[] expResult = {TipoListaDeReproduccion.POR_DEFECTO, TipoListaDeReproduccion.PARTICULAR};
        TipoListaDeReproduccion[] result = TipoListaDeReproduccion.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class TipoListaDeReproduccion.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "POR_DEFECTO";
        TipoListaDeReproduccion expResult = TipoListaDeReproduccion.POR_DEFECTO;
        TipoListaDeReproduccion result = TipoListaDeReproduccion.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
