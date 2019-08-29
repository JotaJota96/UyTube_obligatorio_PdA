/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DataType;

import Logica.Clases.Categoria;
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
public class DtCategoriaTest {
    
    public DtCategoriaTest() {
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
     * Test of getNombre method, of class DtCategoria.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        DtCategoria instance = new DtCategoria("MUSICA");
        String expResult = "MUSICA";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class DtCategoria.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DtCategoria instance = new DtCategoria("MUSICA");
        String expResult = "DtCategoria{nombre=MUSICA}";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
