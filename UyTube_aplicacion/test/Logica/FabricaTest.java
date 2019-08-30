/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Interfaces.IAdmin;
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
public class FabricaTest {
    
    public FabricaTest() {
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
     * Test of getInstancia method, of class Fabrica.
     */
    @Test
    public void testGetInstancia_1() {
        System.out.println("testGetInstancia_1");
        Fabrica result = Fabrica.getInstancia();
        assertNotNull(result);
    }
    @Test
    public void testGetInstancia_2() {
        System.out.println("testGetInstancia_1");
        Fabrica expResult = Fabrica.getInstancia();
        Fabrica result = Fabrica.getInstancia();
        assertSame(expResult, result);
    }

    /**
     * Test of getIAdmin method, of class Fabrica.
     */
    @Test
    public void testGetIAdmin_1() {
        System.out.println("testGetIAdmin_1");
        Fabrica instance = Fabrica.getInstancia();
        IAdmin result = instance.getIAdmin();
        assertNotNull(result);
    }
    @Test
    public void testGetIAdmin_2() {
        System.out.println("testGetIAdmin_2");
        Fabrica instance = Fabrica.getInstancia();
        IAdmin expResult = instance.getIAdmin();
        IAdmin result = instance.getIAdmin();
        assertSame(expResult, result);
    }
    
}
