/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.Clases.Canal;
import Logica.Clases.ListaDeReproduccion;
import Logica.Clases.Usuario;
import Logica.Clases.Video;
import Logica.DataType.DtCanal;
import Logica.DataType.DtVideo;
//import Logica.DataType.DtComentario;
import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoListaDeReproduccion;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
//import java.io.EOFException;
//import java.util.ArrayList;
//import jdk.internal.util.xml.impl.Parser;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Facu
 */
public class CanalTest {
    Canal c = new Canal(0, "nombre", "descripcion", Privacidad.PRIVADO);
    Canal c1 = new Canal(0, "nombre", "descripcion", Privacidad.PRIVADO);
    
    ListaDeReproduccion ldr = new ListaDeReproduccion(0, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "categoria");
    
    Video v1 = new Video(0, "_nombre", "_descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "_urlVideoOriginal", "_categoria");
    
    Usuario u;
    
    public CanalTest() {
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

    @Test
    public void testGetNuevoId() {
        System.out.println("getNuevoId");
        int expResult = 1;
        int result = Canal.getNuevoId();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testGetNuevoId2() {
        System.out.println("getNuevoId2");
        int expResult = 2;
        int result = Canal.getNuevoId();
        assertEquals(expResult, result);

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
//
//@Test
//    public void testListarComentariosDeVideo() {
//        System.out.println("listarComentariosDeVideo");
//        ArrayList<DtComentario> expResult = new ArrayList();
//        ArrayList<DtComentario> result = c.listarComentariosDeVideo(c.getId());
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

@Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Canal instance = c;
        String expResult = "nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Canal instance = c;
        String expResult = "descripcion";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetPrivacidad() {
        System.out.println("getPrivacidad");
        Canal instance = c;
        Privacidad expResult = Privacidad.PRIVADO;
        Privacidad result = instance.getPrivacidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
  public void testGetId() {
        System.out.println("testGetId");
        Canal instance = c;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
  
  public void testGetDT() {
        System.out.println("getDT");
        Canal instance = c;
        DtCanal expResult = new DtCanal(0, "nombre", "descripcion", Privacidad.PRIVADO);
        DtCanal result = c.getDT();
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

  
   @Test
    public void testSetPrivacidad() {
        System.out.println("setPrivacidad");
        Canal instance = c;
        instance.setPrivacidad(Privacidad.PUBLICO);
        assertEquals(Privacidad.PUBLICO, c.getPrivacidad());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        instance.setPrivacidad(Privacidad.PRIVADO);
    }
   
    
    @Test
    public void testObtenerDtVideo() {
        System.out.println("obtenerDtVideo");
        Canal instance = c;
        Video expResult = null;//new DtVideo(0, "nombre", "descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "urlVideoOriginal", Privacidad.PRIVADO, "categoria", 0, 0);
        Video result = null;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    @Test
    public void testListarVideos() {
        System.out.println("listarVideos");
        Canal instance = c;
        instance.agregarVideo(v1.getDt());
        
        ArrayList<DtVideo> expResult = new ArrayList();
        expResult.add(v1.getDt());
        
        ArrayList<DtVideo> result = instance.listarVideos();
        assertEquals(expResult.size(), result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
    }
 
    @Test
    public void testListarVideosDeListaDeReproduccion() {
        System.out.println("listarVideosDeListaDeReproduccion");
        Canal instance = c;
        c.agregarListaParticular(ldr.getDt());
        ldr.agregarVideoA(v1);
        ArrayList<DtVideo> expResult = new ArrayList();
        expResult.add(v1.getDt());


        
        ArrayList<DtVideo> result = instance.listarVideosDeListaDeReproduccion(1);
        assertEquals(expResult.size(), result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
    }
    

}
