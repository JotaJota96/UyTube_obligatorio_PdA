/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DataType;

import java.sql.Date;
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
public class DtComentarioTest {
    
    public DtComentarioTest() {
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
     * Test of getId method, of class DtComentario.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        DtComentario instance = new DtComentario(0, "nickname", new Date(2019-1900, 1, 1), "texto", 1);
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNickname method, of class DtComentario.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        DtComentario instance = new DtComentario(0, "nickname", new Date(2019-1900, 1, 1), "texto", 1);
        String expResult = "nickname";
        String result = instance.getNickname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class DtComentario.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        DtComentario instance = new DtComentario(0, "nickname", new Date(2019-1900, 1, 1), "texto", 1);
        Date expResult = new Date(2019-1900, 1, 1);
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTexto method, of class DtComentario.
     */
    @Test
    public void testGetTexto() {
        System.out.println("getTexto");
        DtComentario instance = new DtComentario(0, "nickname", new Date(2019-1900, 1, 1), "texto", 1);
        String expResult = "texto";
        String result = instance.getTexto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNivelSubComentario method, of class DtComentario.
     */
    @Test
    public void testGetNivelSubComentario() {
        System.out.println("getNivelSubComentario");
        DtComentario instance = new DtComentario(0, "nickname", new Date(2019-1900, 1, 1), "texto", 1);
        int expResult = 1;
        int result = instance.getNivelSubComentario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class DtComentario.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DtComentario instance = new DtComentario(0, "nickname", new Date(2019-1900, 1, 1), "texto", 1);
        String expResult = "DtComentario{id=0, nickname=nickname, fecha=2019-02-01, texto=texto, nivelSubComentario=1}";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
