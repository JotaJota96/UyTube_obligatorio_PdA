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
public class PersonaTest {
    
    public PersonaTest() {
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
     * Test of constructor method, of class Persona.
     */
    @Test
    public void testPersona() {
        System.out.println("getNombre");
        Administrador instance = null;
        try {
            instance = new Administrador(0, "", "nombre", "apellido");
        } catch (Exception e) {
            assertNull(instance);
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Persona.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Administrador instance = new Administrador(0, "contrasenia", "nombre", "apellido");
        String expResult = "nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getApellido method, of class Persona.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        Administrador instance = new Administrador(0, "contrasenia", "nombre", "apellido");
        String expResult = "apellido";
        String result = instance.getApellido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validarContrasenia method, of class Persona.
     */
    @Test
    public void testValidarContrasenia_correcta() {
        System.out.println("testValidarContrasenia_correcta");
        String pass = "contrasenia";
        Administrador instance = new Administrador(0, "contrasenia", "nombre", "apellido");
        boolean expResult = true;
        boolean result = instance.validarContrasenia(pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of validarContrasenia method, of class Persona.
     */
    @Test
    public void testValidarContrasenia_incorrecta() {
        System.out.println("testValidarContrasenia_correcta");
        String pass = "contrasenia mala";
        Administrador instance = new Administrador(0, "contrasenia", "nombre", "apellido");
        boolean expResult = false;
        boolean result = instance.validarContrasenia(pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
