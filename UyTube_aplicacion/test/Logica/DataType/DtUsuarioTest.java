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
public class DtUsuarioTest {
    
    public DtUsuarioTest() {
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
     * Test of getNickname method, of class DtUsuario.
     */
    @Test
    public void testGetNickname() {
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
        String expResult = "nickname";
        String result = instance.getNickname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    /**
     * Test of getCorreo method, of class DtUsuario.
     */
    @Test
    public void testGetCorreo() {
        System.out.println("getCorreo");
        DtUsuario instance = new DtUsuario(
                "nickname", 
                "contrasenia", 
                "nombre", 
                "apellido", 
                "correo", 
                new Date(2019-1900, 1, 1), 
                "imagen", 
                0);
        String expResult = "correo";
        String result = instance.getCorreo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaNacimiento method, of class DtUsuario.
     */
    @Test
    public void testGetFechaNacimiento() {
        System.out.println("getFechaNacimiento");
        DtUsuario instance = new DtUsuario(
                "nickname", 
                "contrasenia", 
                "nombre", 
                "apellido", 
                "correo", 
                new Date(2019-1900, 1, 1), 
                "imagen", 
                0);
        Date expResult = new Date(2019-1900, 1, 1);
        Date result = instance.getFechaNacimiento();
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getImagen method, of class DtUsuario.
     */
    @Test
    public void testGetImagen() {
        System.out.println("getImagen");
        DtUsuario instance = new DtUsuario(
                "nickname", 
                "contrasenia", 
                "nombre", 
                "apellido", 
                "correo", 
                new Date(2019-1900, 1, 1), 
                "imagen", 
                0);
        String expResult = "imagen";
        String result = instance.getImagen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCantSeguidores method, of class DtUsuario.
     */
    @Test
    public void testGetCantSeguidores() {
        System.out.println("getCantSeguidores");
        DtUsuario instance = new DtUsuario(
                "nickname", 
                "contrasenia", 
                "nombre", 
                "apellido", 
                "correo", 
                new Date(2019-1900, 1, 1), 
                "imagen", 
                0);
        int expResult = 0;
        int result = instance.getCantSeguidores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class DtUsuario.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DtUsuario instance = new DtUsuario(
                "nickname", 
                "contrasenia", 
                "nombre", 
                "apellido", 
                "correo", 
                new Date(2019-1900, 1, 1), 
                "imagen", 
                0);
        String expResult = "DtUsuario{DtPersona{nombre=nombre, apellido=apellido, contrasenia=contrasenia}, nickname=nickname, correo=correo, fechaNacimiento=2019-02-01, imagen=imagen, cantSeguidores=0}";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
