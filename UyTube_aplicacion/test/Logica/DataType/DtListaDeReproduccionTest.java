/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DataType;

import Logica.Clases.ListaDeReproduccion;
import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoListaDeReproduccion;
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
public class DtListaDeReproduccionTest {
    
    public DtListaDeReproduccionTest() {
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
     * Test of getId method, of class DtListaDeReproduccion.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        DtListaDeReproduccion instance = new DtListaDeReproduccion(0, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED");
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class DtListaDeReproduccion.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        DtListaDeReproduccion instance = new DtListaDeReproduccion(0, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED");
        String expResult = "nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrivacidad method, of class DtListaDeReproduccion.
     */
    @Test
    public void testGetPrivacidad() {
        System.out.println("getPrivacidad");
        DtListaDeReproduccion instance = new DtListaDeReproduccion(0, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED");
        Privacidad expResult = Privacidad.PRIVADO;
        Privacidad result = instance.getPrivacidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class DtListaDeReproduccion.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        DtListaDeReproduccion instance = new DtListaDeReproduccion(0, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED");
        TipoListaDeReproduccion expResult = TipoListaDeReproduccion.PARTICULAR;
        TipoListaDeReproduccion result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoria method, of class DtListaDeReproduccion.
     */
    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        DtListaDeReproduccion instance = new DtListaDeReproduccion(0, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED");
        String expResult = "UNDEFINED";
        String result = instance.getCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class DtListaDeReproduccion.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DtListaDeReproduccion instance = new DtListaDeReproduccion(0, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED");
        String expResult = "DtListaDeReproduccion{id=0, nombre=nombre, privacidad=PRIVADO, tipo=PARTICULAR, categoria=UNDEFINED}";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
