/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Clases;

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
public class AdministradorTest {
    
    public AdministradorTest() {
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
     * Test of getNuevoID method, of class Administrador.
     */
    @Test
    public void testGetNuevoID() {
        System.out.println("getNuevoID");
        int expResult = 1;
        int result = Administrador.getNuevoID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getIdAdmin method, of class Administrador.
     */
    @Test
    public void testGetIdAdmin() {
        System.out.println("getIdAdmin");
        Administrador instance = new Administrador(0, "contrasenia", "nombre", "apellido");
        int expResult = 0;
        int result = instance.getIdAdmin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
