/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DataType;

import Logica.Enumerados.TipoValoracion;
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
public class DtValoracionTest {
    
    public DtValoracionTest() {
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
     * Test of getNickname method, of class DtValoracion.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        DtValoracion instance = new DtValoracion(TipoValoracion.LIKE, "nickname");
        String expResult = "nickname";
        String result = instance.getNickname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getVal method, of class DtValoracion.
     */
    @Test
    public void testGetVal() {
        System.out.println("getVal");
        DtValoracion instance = new DtValoracion(TipoValoracion.LIKE, "nickname");
        TipoValoracion expResult = TipoValoracion.LIKE;
        TipoValoracion result = instance.getVal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class DtValoracion.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DtValoracion instance = new DtValoracion(TipoValoracion.LIKE, "nickname");
        String expResult = "DtValoracion{val=LIKE, nickname=nickname}";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
