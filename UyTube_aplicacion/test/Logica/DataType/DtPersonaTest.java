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
public class DtPersonaTest {
    
    public DtPersonaTest() {
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
     * Test of getNombre method, of class DtPersona.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNickname");
        DtUsuario instance = new DtUsuario(
                "nickname", 
                "contrasenia", 
                "nombre", 
                "apellido", 
                "correo", 
                new Date(2019-1900, 1, 1), 
                "imagen", 
                0);
        String expResult = "nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getApellido method, of class DtPersona.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getNickname");
        DtUsuario instance = new DtUsuario(
                "nickname", 
                "contrasenia", 
                "nombre", 
                "apellido", 
                "correo", 
                new Date(2019-1900, 1, 1), 
                "imagen", 
                0);
        String expResult = "apellido";
        String result = instance.getApellido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContrasenia method, of class DtPersona.
     */
    @Test
    public void testGetContrasenia() {
        System.out.println("getNickname");
        DtUsuario instance = new DtUsuario(
                "nickname", 
                "contrasenia", 
                "nombre", 
                "apellido", 
                "correo", 
                new Date(2019-1900, 1, 1), 
                "imagen", 
                0);
        String expResult = "contrasenia";
        String result = instance.getContrasenia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
