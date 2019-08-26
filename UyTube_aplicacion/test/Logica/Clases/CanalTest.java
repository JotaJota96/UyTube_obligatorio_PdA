/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Clases;

import Logica.DataType.DtCanal;
import Logica.DataType.DtComentario;
import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtValoracion;
import Logica.DataType.DtVideo;
import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoListaDeReproduccion;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc01
 */
public class CanalTest {
    
    Canal c; 
    Canal c1; 
    
    ListaDeReproduccion ldr;
    
    Video v1;
    
    Usuario u1;
    
    Comentario com;
    
    public CanalTest() {
        c = new Canal(0, "nombre", "descripcion", Privacidad.PRIVADO);
        c1 = new Canal(0, "nombre", "descripcion", Privacidad.PRIVADO);
        ldr = new ListaDeReproduccion(0, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "categoria");
        v1 = new Video(0, "_nombre", "_descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "_urlVideoOriginal", "_categoria");
        u1 = new Usuario("nickname","email" ,new Date(2019-1900, 2, 2), "imagen", "contrasenia", "nombre","apellido" , c1.getDT());
        com = new Comentario(12,new Date(2019-1900, 2, 2) , "texto", 0, u1);
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
     * Test of getId method, of class Canal.
     */
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
    public void testSetNombre() {
        System.out.println("setNombre");
        Canal instance = c;
        instance.setNombre("nombre");
        String expResult = "nombre";
        assertEquals(expResult, instance.getNombre());
    }
    
      @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        Canal instance = c;
        instance.setDescripcion("descripcion");
        String expResult = "descripcion";
        assertEquals(expResult, instance.getDescripcion());
    }
    
    @Test
  public void testGetDT() {
        System.out.println("getDT");
        Canal instance = c;
        DtCanal expResult = new DtCanal(0, "nombre", "descripcion", Privacidad.PRIVADO);
        DtCanal result = instance.getDT();
        assertEquals(expResult.toString(), result.toString());
    }
    
    @Test
    public void testGetNuevoId() {
        System.out.println("getNuevoId");
        int expResult = Canal.getNuevoId() + 1;
        int result = Canal.getNuevoId();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
//    
//    @Test
//    public void testGetNuevoId2() {
//        System.out.println("getNuevoId2");
//        int expResult = 2;
//        int result = Canal.getNuevoId();
//        assertEquals(expResult, result);
//
//    }

  
    @Test
    public void testActualizarListasPorDefecto() {
        System.out.println("actualizarListasPorDefecto");
        Canal instance = null;
        instance.actualizarListasPorDefecto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarComentarioAVideo method, of class Canal.
     */
    @Test
    public void testAgregarComentarioAVideo_3args() {
        System.out.println("agregarComentarioAVideo");
        DtComentario comentario = com.getDT();
        Usuario usuario = u1;
        Canal instance = c1;
        instance.agregarComentarioAVideo(v1.getId(), comentario, usuario);
        assertNull(null);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of agregarComentarioAVideo method, of class Canal.
     */
    @Test
    public void testAgregarComentarioAVideo_4args() {
        System.out.println("agregarComentarioAVideo");
        int id = 0;
        int idComentario = 0;
        DtComentario comentario = null;
        Usuario usuario = null;
        Canal instance = null;
        instance.agregarComentarioAVideo(id, idComentario, comentario, usuario);
        // TODO review the generated test code and remove the default call to fail.
       //**************************************** fail("The test case is a prototype.");
    }

    /**
     * Test of agregarListaParticular method, of class Canal.
     */
    @Test
    public void testAgregarListaParticular() {
        System.out.println("agregarListaParticular");
        DtListaDeReproduccion listaReproduccion = null;
        Canal instance = null;
        instance.agregarListaParticular(listaReproduccion);
        // TODO review the generated test code and remove the default call to fail.
       //**************************************** fail("The test case is a prototype.");
    }

    /**
     * Test of quitarValoracion method, of class Canal.
     */
    @Test
    public void testQuitarValoracion() {
        System.out.println("quitarValoracion");
        int idVideo = 0;
        String nickname = "";
        Canal instance = null;
        instance.quitarValoracion(idVideo, nickname);
        // TODO review the generated test code and remove the default call to fail.
       //**************************************** fail("The test case is a prototype.");
    }

    /**
     * Test of agregarModificarValoracion method, of class Canal.
     */
    @Test
    public void testAgregarModificarValoracion() {
        System.out.println("agregarModificarValoracion");
        int id = 0;
        DtValoracion valoracion = null;
        Usuario usuario = null;
        Canal instance = null;
        instance.agregarModificarValoracion(id, valoracion, usuario);
        // TODO review the generated test code and remove the default call to fail.
      //****************************************  fail("The test case is a prototype.");
    }

    /**
     * Test of agregarVideo method, of class Canal.
     */
    @Test
    public void testAgregarVideo() {
        System.out.println("agregarVideo");
        DtVideo video = null;
        Canal instance = null;
        instance.agregarVideo(video);
        // TODO review the generated test code and remove the default call to fail.
       //**************************************** fail("The test case is a prototype.");
    }

    /**
     * Test of agregarVideoALista method, of class Canal.
     */
    @Test
    public void testAgregarVideoALista() {
        System.out.println("agregarVideoALista");
        int id = 0;
        Video video = null;
        Canal instance = null;
        instance.agregarVideoALista(id, video);
        // TODO review the generated test code and remove the default call to fail.
     //****************************************   fail("The test case is a prototype.");
    }

 
    @Test
    public void testListarComentariosDeVideo() {
        System.out.println("listarComentariosDeVideo");
        int id = 0;
        Canal instance = null;
        ArrayList<DtComentario> expResult = null;
        ArrayList<DtComentario> result = instance.listarComentariosDeVideo(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //****************************************fail("The test case is a prototype.");
    }

    /**
     * Test of listarListasDeReproduccion method, of class Canal.
     */
    @Test
    public void testListarListasDeReproduccion() {
        System.out.println("listarListasDeReproduccion");
        boolean porDefecto = false;
        Canal instance = null;
        ArrayList<DtListaDeReproduccion> expResult = null;
        ArrayList<DtListaDeReproduccion> result = instance.listarListasDeReproduccion(porDefecto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       //**************************************** fail("The test case is a prototype.");
    }

    /**
     * Test of listarValoracionesDeVideo method, of class Canal.
     */
    @Test
    public void testListarValoracionesDeVideo() {
        System.out.println("listarValoracionesDeVideo");
        int id = 0;
        Canal instance = null;
        ArrayList<DtValoracion> expResult = null;
        ArrayList<DtValoracion> result = instance.listarValoracionesDeVideo(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       //**************************************** fail("The test case is a prototype.");
    }

    /**
     * Test of listarVideos method, of class Canal.
     */
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
 
    /**
     * Test of listarVideosDeListaDeReproduccion method, of class Canal.
     */
  
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
    
    /**
     * Test of modificar method, of class Canal.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        DtCanal canal = null;
        Canal instance = null;
        instance.modificar(canal);
        // TODO review the generated test code and remove the default call to fail.
       //**************************************** fail("The test case is a prototype.");
    }

    /**
     * Test of modificarListaDeReproduccion method, of class Canal.
     */
    @Test
    public void testModificarListaDeReproduccion() {
        System.out.println("modificarListaDeReproduccion");
        DtListaDeReproduccion ldr = null;
        Canal instance = null;
        instance.modificarListaDeReproduccion(ldr);
        // TODO review the generated test code and remove the default call to fail.
       //**************************************** fail("The test case is a prototype.");
    }

    /**
     * Test of modificarVideo method, of class Canal.
     */
    @Test
    public void testModificarVideo() {
        System.out.println("modificarVideo");
        DtVideo video = null;
        Canal instance = null;
        instance.modificarVideo(video);
        // TODO review the generated test code and remove the default call to fail.
       //**************************************** fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerListaDeReproduccion method, of class Canal.
     */
    @Test
    public void testObtenerListaDeReproduccion() {
        System.out.println("obtenerListaDeReproduccion");
        int id = 0;
        Canal instance = null;
        DtListaDeReproduccion expResult = null;
        DtListaDeReproduccion result = instance.obtenerListaDeReproduccion(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //****************************************  fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerListasEnCategoria method, of class Canal.
     */
    @Test
    public void testObtenerListasEnCategoria() {
        System.out.println("obtenerListasEnCategoria");
        String cat = "";
        Canal instance = null;
        ArrayList<DtListaDeReproduccion> expResult = null;
        ArrayList<DtListaDeReproduccion> result = instance.obtenerListasEnCategoria(cat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //****************************************  fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDtVideo method, of class Canal.
     */
    @Test
    public void testObtenerDtVideo() {
        System.out.println("obtenerDtVideo");
        Canal instance = c;
        DtVideo expResult = new DtVideo(0, "nombre", "descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "urlVideoOriginal", Privacidad.PRIVADO, "categoria", 0, 0);
        DtVideo result = instance.obtenerDtVideo(v1.getId());
        assertEquals(expResult.toString(), result.toString());
     
    }

    /**
     * Test of obtenerVideo method, of class Canal.
     */
    @Test
    public void testObtenerVideo() {
        System.out.println("obtenerVideo");
        int id = 0;
        Canal instance = null;
        Video expResult = null;
        Video result = instance.obtenerVideo(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       //**************************************** fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerVideosEnCategoria method, of class Canal.
     */
    @Test
    public void testObtenerVideosEnCategoria() {
        System.out.println("obtenerVideosEnCategoria");
        String cat = "";
        Canal instance = null;
        ArrayList<DtVideo> expResult = null;
        ArrayList<DtVideo> result = instance.obtenerVideosEnCategoria(cat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //****************************************   fail("The test case is a prototype.");
    }

    /**
     * Test of quitarVideoDeListaDeReproduccion method, of class Canal.
     */
    @Test
    public void testQuitarVideoDeListaDeReproduccion() {
        System.out.println("quitarVideoDeListaDeReproduccion");
        int idLista = 0;
        int idVideo = 0;
        Canal instance = null;
        instance.quitarVideoDeListaDeReproduccion(idLista, idVideo);
        // TODO review the generated test code and remove the default call to fail.
     //****************************************   fail("The test case is a prototype.");
    }

    /**
     * Test of validarListaParticular method, of class Canal.
     */
    @Test
    public void testValidarListaParticular() {
        System.out.println("validarListaParticular");
        String nombreLista = "";
        Canal instance = null;
        boolean expResult = false;
        boolean result = instance.validarListaParticular(nombreLista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //****************************************fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerValoracion method, of class Canal.
     */
    @Test
    public void testObtenerValoracion() {
        System.out.println("obtenerValoracion");
        int id = 0;
        String nickname = "";
        Canal instance = null;
        DtValoracion expResult = null;
        DtValoracion result = instance.obtenerValoracion(id, nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       //**************************************** fail("The test case is a prototype.");
    }
    
}
