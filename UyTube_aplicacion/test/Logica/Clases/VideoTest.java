/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Clases;

import Logica.DataType.DtCanal;
import Logica.DataType.DtComentario;
import Logica.DataType.DtValoracion;
import Logica.DataType.DtVideo;
import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoValoracion;
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
 * @author administrador
 */
public class VideoTest {
    Usuario usrActual;
    Usuario usrSeleccionado;
    Video videoPrueba;
    
    Categoria miCategoria = new Categoria("Prueba");
    public VideoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Date fecha1 = new Date(1976,1,31);
        Time duracion1 = new Time(0, 2, 40);
        videoPrueba = new Video(1, "MiVideo", "Video para comentar",duracion1, fecha1,"url","categoria");        
        DtCanal canalusractual = new DtCanal(Canal.getNuevoId(), "usractual", "Canal de usuario actual", Privacidad.PUBLICO);
        usrActual = new Usuario("usrActual", "usractual@gmail.com", fecha1, "url:imagen", "password", "usractual", "actual", canalusractual );
        DtVideo dtVideoTest = new DtVideo(Video.getNuevoId(), "videoTest", "video de pruebas", duracion1, fecha1, "http://video.com", Privacidad.PRIVADO, miCategoria.getNombre(), 0, 0);
        usrActual.agregarVideoACanal(dtVideoTest);
        Date fecha2 = new Date(1998,5,12);
        DtCanal canalusrseleccionado = new DtCanal(Canal.getNuevoId(), "usrseleccionado", "Canal de usuario seleccionado", Privacidad.PUBLICO);
        usrSeleccionado = new Usuario("usrseleccionado", "usrseleccionado@gmail.com", fecha2, "url:imagen","password","usrseleccionado","seleccionado",canalusrseleccionado);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test ok
     */
    @Test
    public void testAgregarComentario_DtComentario_Usuario() {
        System.out.println("agregarComentario");
        Date fecha = new Date(2019, 8, 25);
        DtComentario dtComentario = new DtComentario(1, "usrseleccionado", fecha, "comentario del video", 0);        
        videoPrueba.agregarComentario(dtComentario, usrSeleccionado);
        ArrayList<DtComentario> listaComentarios = videoPrueba.listarComentarios();
        String esperado = dtComentario.toString();
        String resultado = new String();
        for (DtComentario item : listaComentarios) {              
            if(item.getId() == dtComentario.getId()){//Obtengo el comentario recien ingresado 
                resultado = item.toString();              
            }
        }
        assertEquals(esperado, resultado);
    }

    /**
     * Test OK
     */
    @Test
    public void testAgregarComentario_3args() {
        System.out.println("agregarComentario");        
        Date fecha = new Date(2019,07,10);
        DtComentario dtComentario = new DtComentario(Comentario.getNuevoID(), "usrseleccionado", fecha, "un desastre el 1", 1);
        DtComentario dtComentario2 = new DtComentario(Comentario.getNuevoID(), "usrseleccionado", fecha, "un desastre el 2", 2);
        videoPrueba.agregarComentario(dtComentario, usrSeleccionado);      
        videoPrueba.agregarComentario(5, dtComentario2, usrSeleccionado);       
        ArrayList<DtComentario> listaCom = videoPrueba.listarComentarios();        
        String esperado = dtComentario2.getTexto();
        String resultado = new String();        
        for (DtComentario item : listaCom) {
           if(item.getTexto() == dtComentario2.getTexto()){
                resultado = item.getTexto();
            }
        }
        assertEquals(esperado, resultado);
    }

    /**
     * Test of agregarModificarValoracion method, of class Video.
     */
    @Test
    public void testAgregarModificarValoracion() {
        System.out.println("agregarModificarValoracion");
        DtValoracion val = new DtValoracion(TipoValoracion.LIKE, "usrac");
        videoPrueba.agregarModificarValoracion(val, usrSeleccionado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test ok
     */
    @Test
    public void testGetDt() {
        System.out.println("getDt");
        Date fecha1 = new Date(1976,1,31);
        Time duracion1 = new Time(0, 2, 40);
        DtVideo expResult = new DtVideo(1, "MiVideo", "Video para comentar",duracion1, fecha1,"url",Privacidad.PUBLICO,"categoria",1,0);
        DtVideo result = videoPrueba.getDt();
        assertEquals(expResult, result);
    }

    /**
     * Test OK
     */
    @Test
    public void testListarComentarios() {
        System.out.println("listarComentarios");
        Date fecha1 = new Date(1976,1,31);
        DtComentario dtComentario = new DtComentario(2, "usrseleccionado", fecha1, "comentario del video", 0); 
        ArrayList<DtComentario> expResult = new ArrayList<>();
        expResult.add(dtComentario);
        videoPrueba.agregarComentario(dtComentario, usrSeleccionado);
        ArrayList<DtComentario> result = videoPrueba.listarComentarios();
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of listarValoraciones method, of class Video.
     */
    @Test
    public void testListarValoraciones() {
        System.out.println("listarValoraciones");
        ArrayList<DtValoracion> expResult = null;
        ArrayList<DtValoracion> result = videoPrueba.listarValoraciones();
        assertEquals(expResult, result);
    }

    /**
     * Test OK
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
         Date fecha1 = new Date(1976,1,31);
        Time duracion1 = new Time(0, 2, 40);
        DtVideo dtVideo = new DtVideo(1, "MiVideo", "Video modificado",duracion1, fecha1,"url",Privacidad.PRIVADO,"categoria",0,0);
        videoPrueba.modificar(dtVideo);
        Video video2 = new Video(1, "MiVideo", "Video modificado",duracion1, fecha1,"url","categoria");
        String esperado = video2.toString();
        String resultado = videoPrueba.toString();
        assertEquals(esperado, resultado);
    }

    /**
     * Test of obtenerValoracion method, of class Video.
     */
    @Test
    public void testObtenerValoracion() {
        System.out.println("obtenerValoracion");
        String nickname = "usrseleccionado";
        DtValoracion val = new DtValoracion(TipoValoracion.LIKE, nickname);
        videoPrueba.agregarModificarValoracion(val, usrSeleccionado);
        String expResult = val.toString();
        String result = videoPrueba.obtenerValoracion(nickname).toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of quitarValoracion method, of class Video.
     */
    @Test
    public void testQuitarValoracion() {
        System.out.println("quitarValoracion");
        String nickname = "usrseleccionado";
        videoPrueba.quitarValoracion(nickname);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNuevoId method, of class Video.
     */
    @Test
    public void testGetNuevoId() {
        System.out.println("getNuevoId");
        int expResult = 7;
        int result = Video.getNuevoId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Video.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int expResult = 1;
        int result = videoPrueba.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Video.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Video instance = new Video();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getNombre method, of class Video.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");        
        String expResult = "MiVideo";
        String result = videoPrueba.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test ok
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "Nuevo nombre";
        videoPrueba.setNombre(nombre);
        assertEquals(nombre, videoPrueba.getNombre());
    }

    /**
     * Test of getDescripcion method, of class Video.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Video instance = new Video();
        String expResult = "Video para comentar";
        String result = videoPrueba.getDescripcion();
        assertEquals(expResult, result);
    }

    /**
     * Tes ok
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "Nueva Descripcion";
        videoPrueba.setDescripcion(descripcion);
        assertEquals(descripcion, videoPrueba.getDescripcion());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test ok
     */
    @Test
    public void testGetDuracion() {
        System.out.println("getDuracion"); 
        Time expResult = new Time(0, 2, 40);
        Time result = videoPrueba.getDuracion();
        assertEquals(expResult, result);
    }

    /**
     * Test ok
     */
    @Test
    public void testSetDuracion() {
        System.out.println("setDuracion");
        Time expResult = new Time(0,4,30);
        videoPrueba.setDuracion(expResult);
        assertEquals(expResult, videoPrueba.getDuracion());
    }

    /**
     * Test of getFechaPublicacion method, of class Video.
     */
    @Test
    public void testGetFechaPublicacion() {
        System.out.println("getFechaPublicacion");
        Video instance = new Video();
        Date expResult = null;
        Date result = instance.getFechaPublicacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaPublicacion method, of class Video.
     */
    @Test
    public void testSetFechaPublicacion() {
        System.out.println("setFechaPublicacion");
        Date fechaPublicacion = null;
        Video instance = new Video();
        instance.setFechaPublicacion(fechaPublicacion);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUrlVideoOriginal method, of class Video.
     */
    @Test
    public void testGetUrlVideoOriginal() {
        System.out.println("getUrlVideoOriginal");
        Video instance = new Video();
        String expResult = "";
        String result = instance.getUrlVideoOriginal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setUrlVideoOriginal method, of class Video.
     */
    @Test
    public void testSetUrlVideoOriginal() {
        System.out.println("setUrlVideoOriginal");
        String urlVideoOriginal = "";
        Video instance = new Video();
        instance.setUrlVideoOriginal(urlVideoOriginal);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrivacidad method, of class Video.
     */
    @Test
    public void testGetPrivacidad() {
        System.out.println("getPrivacidad");
        Video instance = new Video();
        Privacidad expResult = null;
        Privacidad result = instance.getPrivacidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrivacidad method, of class Video.
     */
    @Test
    public void testSetPrivacidad() {
        System.out.println("setPrivacidad");
        Privacidad privacidad = null;
        Video instance = new Video();
        instance.setPrivacidad(privacidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test OK
     */
    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        Video instance = new Video();
        String expResult = "categoria";
        String result = videoPrueba.getCategoria();
        assertEquals(expResult, result);
    }

    /**
     * Test OK
     */
    @Test
    public void testSetCategoria() {
        System.out.println("setCategoria");
        String categoria = "Nueva Categoria";
        videoPrueba.setCategoria(categoria);
        assertEquals(categoria, videoPrueba.getCategoria());
    }

    /**
     * Test of getCantLikes method, of class Video.
     */
    @Test
    public void testGetCantLikes() {
        System.out.println("getCantLikes");
        Video instance = new Video();
        int expResult = 0;
        int result = instance.getCantLikes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCantLikes method, of class Video.
     */
    @Test
    public void testSetCantLikes() {
        System.out.println("setCantLikes");
        int cantLikes = 0;
        Video instance = new Video();
        instance.setCantLikes(cantLikes);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCantDisLikes method, of class Video.
     */
    @Test
    public void testGetCantDisLikes() {
        System.out.println("getCantDisLikes");
        Video instance = new Video();
        int expResult = 0;
        int result = instance.getCantDisLikes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCantDisLikes method, of class Video.
     */
    @Test
    public void testSetCantDisLikes() {
        System.out.println("setCantDisLikes");
        
    }
    
    /**
     * Test of toString method, of class Video.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Video instance = new Video();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }
    
}
