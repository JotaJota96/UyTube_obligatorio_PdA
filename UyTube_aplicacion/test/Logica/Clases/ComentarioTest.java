/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Clases;

import Logica.DataType.DtCanal;
import Logica.DataType.DtComentario;
import Logica.Enumerados.Privacidad;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos BM
 */
public class ComentarioTest {
    
    Usuario user;
    Comentario com;
    Date fecha;
    public ComentarioTest() {
        fecha = new Date(190,7,4);
        user = new Usuario("MCbolso", "mcbolso@gmail.com",fecha, "imagen.jpg", "dsfsdf", "mariano", "Castro", new DtCanal(0, "mi_canal", "un_canal_mas", Privacidad.PRIVADO));
        com = new Comentario(0, fecha, "una cagada", 0, user);
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
     * Test of getNuevoID method, of class Comentario.
     */
    @Test
    public void testGetNuevoID() {
        System.out.println("getNuevoID");
        Comentario instance = com;
        int expResult = 1;
        int result = instance.getNuevoID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Comentario.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Comentario instance = com;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFecha method, of class Comentario.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Comentario instance = com;
        Date expResult = fecha;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTexto method, of class Comentario.
     */
    @Test
    public void testGetTexto() {
        System.out.println("getTexto");
        Comentario instance = com;
        String expResult = "una cagada";
        String result = instance.getTexto();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNivelSubComentario method, of class Comentario.
     */
    @Test
    public void testGetNivelSubComentario() {
        System.out.println("getNivelSubComentario");
        Comentario instance = com;
        int expResult = 0;
        int result = instance.getNivelSubComentario();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsr method, of class Comentario.
     */
    @Test
    public void testGetUsr() {
        System.out.println("getUsr");
        Comentario instance = com;
        Usuario expResult = user;
        Usuario result = instance.getUsr();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Comentario.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Comentario instance = com;
        String expResult = "Comentario{id=0, fecha=2090-08-04, texto=una cagada, nivelSubComentario=0}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testComentario_basuraFecha() {
        System.out.println("comentario");
        try {
            Comentario comy = new Comentario(0, null, "una cagada", 0, user);
        } catch (Exception e) {
            assertEquals(true, true);
        }
    }
    
    @Test
    public void testComentario_basura_usuario() {
        System.out.println("comentario");
        try {
            Comentario comy = new Comentario(5, fecha, "una cagada", 0, null);
        } catch (Exception e) {
            assertEquals(true, true);
        }
    }

    /**
     * Test of agregarSubComentario method, of class Comentario.
     */
    @Test
    public void testAgregarSubComentario() {
        System.out.println("agregarSubComentario");
        int idComPadre = 0;
        DtComentario dtC = new DtComentario(1, "otroNickname", fecha, "otra cagada", 1);
        Usuario usr = user;
        Comentario instance = com;
        boolean expResult = true;
        boolean result = instance.agregarSubComentario(idComPadre, dtC, usr);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAgregarSubComentarioNoagrega() {
        System.out.println("agregarSubComentario");
        com.agregarSubComentario(1, new DtComentario(1, "otroNickname", fecha, "otra cagada", 1), user);
        int idComPadre = 1;
        DtComentario dtC = new DtComentario(2, "otroNickname", fecha, "otra cagada", 1);
        Usuario usr = user;
        Comentario instance = com;
        boolean expResult = false;
        boolean result = instance.agregarSubComentario(idComPadre, dtC, usr);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAgregarSubComentarioNoagrega_basura_1() {
        System.out.println("agregarSubComentario");
        int idComPadre = 1;
        Usuario usr = user;
        Comentario instance = com;
        boolean expResult = false;
        boolean result =false;
        try{
            result = instance.agregarSubComentario(idComPadre, null, usr);
        }catch(Exception e){
            assertEquals(true, true);
        }
    }
    
    @Test
    public void testAgregarSubComentarioNoagrega_basura_2() {
        System.out.println("agregarSubComentario");
        int idComPadre = 1;
        DtComentario dtC = new DtComentario(2, "otroNickname", fecha, "otra cagada", 1);
        Comentario instance = com;
        boolean expResult = false;
        boolean result = false;
        try{
            result = instance.agregarSubComentario(idComPadre, dtC, null);
        }catch(Exception e){
            assertEquals(true, true);
        }
    }

    /**
     * Test of getDT method, of class Comentario.
     */
    @Test
    public void testGetDT() {
        System.out.println("getDT");
        Comentario instance = com;
        DtComentario expResult = new DtComentario(0, "MCbolso", fecha, "una cagada", 0);
        DtComentario result = instance.getDT();
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of listarSubComentarios method, of class Comentario.
     */
    @Test
    public void testListarSubComentarios() {
        System.out.println("listarSubComentarios");
        Comentario instance = com;
        com.agregarSubComentario(0, new DtComentario(1, "otroNickname", fecha, "otra cagada", 1), user);
        com.agregarSubComentario(0, new DtComentario(1, "otroNickname2", fecha, "otra cagada", 1), user);
        com.agregarSubComentario(0, new DtComentario(1, "otroNickname3", fecha, "otra cagada", 1), user);
        com.agregarSubComentario(2, new DtComentario(1, "otroNickname4", fecha, "otra cagada", 1), user);
        com.agregarSubComentario(4, new DtComentario(1, "otroNickname5", fecha, "otra cagada", 1), user);
        com.agregarSubComentario(3, new DtComentario(1, "otroNickname6", fecha, "otra cagada", 1), user);
        
        ArrayList<DtComentario> expResult = new ArrayList();
        ArrayList<DtComentario> result = instance.listarSubComentarios();
        assertEquals(6, result.size());
    }
    
}
