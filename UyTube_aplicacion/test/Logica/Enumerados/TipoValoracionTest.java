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
public class TipoValoracionTest {
    
    public TipoValoracionTest() {
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
     * Test of values method, of class TipoValoracion.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        TipoValoracion[] expResult = {TipoValoracion.LIKE, TipoValoracion.DISLIKE};
        TipoValoracion[] result = TipoValoracion.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class TipoValoracion.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "LIKE";
        TipoValoracion expResult = TipoValoracion.LIKE;
        TipoValoracion result = TipoValoracion.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
