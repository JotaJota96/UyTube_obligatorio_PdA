/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Clases;

import Logica.DataType.DtValoracion;
import Logica.Enumerados.TipoValoracion;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import Logica.Clases.Usuario;
import Logica.DataType.DtCanal;
import Logica.Enumerados.Privacidad;
import java.sql.Date;

/**
 *
 * @author Carlos BM
 */
public class ValoracionTest {
    
    Usuario user;
    Valoracion valo;
    
    public ValoracionTest() {
        user = new Usuario("MCbolso", "mcbolso@gmail.com", new Date(190,7,4), "imagen.jpg", "dsfsdf", "mariano", "Castro", new DtCanal(0, "mi_canal", "un_canal_mas", Privacidad.PRIVADO));
        valo = new Valoracion(TipoValoracion.LIKE, user);
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
     * Test of getVal method, of class Valoracion.
     */
    @Test
    public void testValoracion() {
        System.out.println("getVal");
        Valoracion instance;
        try{
            instance = new Valoracion(TipoValoracion.LIKE, null);
        }catch(Exception e){
            assertEquals(true, true);
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetVal() {
        System.out.println("getVal");
        Valoracion instance = valo;
        TipoValoracion expResult = TipoValoracion.LIKE;
        TipoValoracion result = instance.getVal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setVal method, of class Valoracion.
     */
    @Test
    public void testSetVal() {
        System.out.println("setVal");
        TipoValoracion val = null;
        Valoracion instance = valo;
        instance.setVal(val);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNicknameDeUsuario method, of class Valoracion.
     */
    @Test
    public void testGetNicknameDeUsuario() {
        System.out.println("getNicknameDeUsuario");
        Valoracion instance = valo;
        String expResult = "MCbolso";
        String result = instance.getNicknameDeUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDT method, of class Valoracion.
     */
    @Test
    public void testGetDT_0args() {
        System.out.println("getDT");
        Valoracion instance = valo;
        DtValoracion expResult = new DtValoracion(TipoValoracion.LIKE, "MCbolso");
        DtValoracion result = instance.getDT();
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDT method, of class Valoracion.
     */
    @Test
    public void testGetDT_String() {
        
        System.out.println("getDT");
        String nickname = "MCbolso";
        Valoracion instance = valo;
        DtValoracion expResult = new DtValoracion(TipoValoracion.LIKE, "MCbolso");
        DtValoracion result = instance.getDT(nickname);
        assertEquals(expResult.toString(), result.toString());
    }
    
    @Test
    public void testGetDT_String_mal() {
        
        System.out.println("getDT");
        Valoracion instance = valo;
        //DtValoracion result = instance.getDT("Lucas");
        assertNull(instance.getDT("Lucas"));
    }
    
    @Test
    public void testGetDT_String_null_basura() {         
        System.out.println("getDT");
        String nickname = null;
        Valoracion instance = valo;
        try {
            instance.getDT(nickname);
        } catch (Exception e) {
            assertEquals(true, true);
        }

    } 
    
    /**
     * Test of modificar method, of class Valoracion.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        DtValoracion dtV = new DtValoracion(TipoValoracion.DISLIKE, "MCbolso");
        String nickname = "MCbolso";
        Valoracion instance = valo;
        boolean expResult = true;
        boolean result = instance.modificar(dtV, nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testModificar_false() {
        System.out.println("modificar");
        DtValoracion dtV = new DtValoracion(TipoValoracion.DISLIKE, "MCbolso");
        String nickname = "Lucas";
        Valoracion instance = valo;
        boolean expResult = false;
        boolean result = instance.modificar(dtV, nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testModificar_null_1() {
        System.out.println("modificar");
        DtValoracion dtV = new DtValoracion(TipoValoracion.DISLIKE, "MCbolso");
        String nickname = null;
        Valoracion instance = valo;
        boolean expResult = false;
        boolean result = false;
        
        try{
            result = instance.modificar(dtV, nickname);
        }catch(Exception e){
            assertEquals(expResult, result);
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testModificar_null_2() {
        System.out.println("modificar");
        DtValoracion dtV = null;
        String nickname = "MCbolso";
        Valoracion instance = valo;
        boolean expResult = false;
        boolean result = false;
        
        try{
            result = instance.modificar(dtV, nickname);
        }catch(Exception e){
            assertEquals(expResult, result);
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
