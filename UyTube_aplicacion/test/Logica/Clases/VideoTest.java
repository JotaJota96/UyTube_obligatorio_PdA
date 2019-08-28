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
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author administrador
 */
public class VideoTest {
    Usuario usrActual;
    Usuario usrSeleccionado;
    Usuario usrSeleccionado2;
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
        DtCanal canalusrseleccionado2 = new DtCanal(Canal.getNuevoId(), "usrseleccionado2", "Canal de usuario seleccionado2", Privacidad.PUBLICO);
        usrSeleccionado2 = new Usuario("usrseleccionado2", "usrseleccionado2@gmail.com", fecha2, "url:imagen","password","usrseleccionado2","seleccionado2",canalusrseleccionado2);
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test constructor id negativo
     */
    @Test(expected = RuntimeException.class)
    public void testCostructorVideo(){
        System.out.println("testCostructorVideo");
        Date fecha1 = new Date(1976,1,31);
        Time duracion1 = new Time(0, 2, 40);
        Video video = new Video(-1, "MiVideo", "Video para comentar",duracion1, fecha1,"url","categoria");
    }
    
    /**
     * Test constructor nombre vacio
     */
    @Test(expected = RuntimeException.class)
    public void testCostructorVideo2(){
        System.out.println("testCostructorVideo2");
        Date fecha1 = new Date(1976,1,31);
        Time duracion1 = new Time(0, 2, 40);
        Video video = new Video(3, "", "Video para comentar",duracion1, fecha1,"url","categoria");
    }
    
    /**
     * Test constructor con descripcion vacia
     */
    @Test
    public void testCostructorVideo3(){
        System.out.println("testCostructorVideo3");
        Date fecha1 = new Date(1976,1,31);
        Time duracion1 = new Time(0, 2, 40);
        Video video = new Video(3, "MiVideo", "",duracion1, fecha1,"url","categoria");
    }
    
    /**
     * Test constructor con duracion null
     */
    @Test(expected = RuntimeException.class)
    public void testCostructorVideo4(){
        System.out.println("testCostructorVideo4");
        Date fecha1 = new Date(1976,1,31);
        Time duracion1 = null;
        Video video = new Video(3, "MiVideo", "Video para comentar",duracion1, fecha1,"url","categoria");
    }
    
    /**
     * Test constructor con fecha null
     */
    @Test(expected = RuntimeException.class)
    public void testCostructorVideo5(){
        System.out.println("testCostructorVideo5");
        Date fecha1 = null;
        Time duracion1 = new Time(0, 2, 40);
        Video video = new Video(3, "MiVideo", "Video para comentar",duracion1, fecha1,"url","categoria");
    }
    
    /**
     * Test constructor con url vacia
     */
    @Test(expected = RuntimeException.class)
    public void testCostructorVideo6(){
        System.out.println("testCostructorVideo6");
        Date fecha1 = new Date(1976,1,31);
        Time duracion1 = new Time(0, 2, 40);
        Video video = new Video(3, "MiVideo", "Video para comentar",duracion1, fecha1,"","categoria");
    }
    
    /**
     * Test constructor con categoria vacia
     */
    @Test(expected = RuntimeException.class)
    public void testCostructorVideo7(){
        System.out.println("testCostructorVideo7");
        Date fecha1 = new Date(1976,1,31);
        Time duracion1 = new Time(0, 2, 40);
        Video video = new Video(3, "MiVideo", "Video para comentar",duracion1, fecha1,"url","");
    }
    
    /**
     * Test ok
     */
    @Test
    public void testAgregarComentario_DtComentario_Usuario() {
        System.out.println("agregarComentario");
        Date fecha = new Date(2019, 8, 25);
        DtComentario dtComentario = new DtComentario(2, "usrseleccionado", fecha, "comentario de prueba", 0);        
        videoPrueba.agregarComentario(dtComentario, usrSeleccionado);
        ArrayList<DtComentario> listaComentarios = videoPrueba.listarComentarios();
        String esperado = dtComentario.toString();
        String resultado = new String();
        for (DtComentario item : listaComentarios) { //Obtengo el comentario recien ingresado, lo busca por texto             
            if(item.getTexto() == dtComentario.getTexto()){
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
        DtComentario dtComentario = new DtComentario(Comentario.getNuevoID(), "usrseleccionado", fecha, "texto1", 1);
        DtComentario dtComentario2 = new DtComentario(Comentario.getNuevoID(), "usrseleccionado", fecha, "texto2", 2);
        videoPrueba.agregarComentario(dtComentario, usrSeleccionado);
        ArrayList<DtComentario> listaCom1 = videoPrueba.listarComentarios();
        int id = 0;
        for (DtComentario item : listaCom1) {//Obtiene el id del comentario1 que se agrego (lo busca por el texto)
            if(item.getTexto() == dtComentario.getTexto()){
                id = item.getId();
            }
        }
        videoPrueba.agregarComentario(id, dtComentario2, usrSeleccionado);       
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
     * Test OK dtComentario null 
     */
    @Test(expected = RuntimeException.class)
    public void testAgregarComentario_3args2() {
        System.out.println("agregarComentario_3args2");        
        Date fecha = new Date(2019,07,10);
        DtComentario dtComentario = new DtComentario(Comentario.getNuevoID(), "usrseleccionado", fecha, "texto1", 1);
        DtComentario dtComentario2 = null;
        videoPrueba.agregarComentario(dtComentario, usrSeleccionado);
        ArrayList<DtComentario> listaCom1 = videoPrueba.listarComentarios();
        int id = 0;
        for (DtComentario item : listaCom1) {//Obtiene el id del comentario1 que se agrego (lo busca por el texto)
            if(item.getTexto() == dtComentario.getTexto()){
                id = item.getId();
            }
        }
        videoPrueba.agregarComentario(id, dtComentario2, usrSeleccionado);
    }
    
     /**
     * Test OK dtComentario null 
     */
    @Test(expected = RuntimeException.class)
    public void testAgregarComentario_3args4() {
        System.out.println("agregarComentario_3args4");        
        Date fecha = new Date(2019,07,10);
        DtComentario dtComentario = new DtComentario(Comentario.getNuevoID(), "usrseleccionado", fecha, "texto1", 1);
        DtComentario dtComentario2 = new DtComentario(Comentario.getNuevoID(), "usrseleccionado", fecha, "texto2", 2);
        Usuario usuario = null;
        videoPrueba.agregarComentario(dtComentario, usrSeleccionado);
        ArrayList<DtComentario> listaCom1 = videoPrueba.listarComentarios();
        int id = 0;
        for (DtComentario item : listaCom1) {//Obtiene el id del comentario1 que se agrego (lo busca por el texto)
            if(item.getTexto() == dtComentario.getTexto()){
                id = item.getId();
            }
        }
        videoPrueba.agregarComentario(id, dtComentario2, usuario);
    }
    
     /**
     * Test OK dtComentario null
     */
    @Test(expected = RuntimeException.class)
    public void testAgregarComentario4() {
        System.out.println("agregarComentario4");        
        DtComentario dtComentario = null;
        videoPrueba.agregarComentario(dtComentario, usrSeleccionado);
    }
    
     /**
     * Test OK usuario null
     */
    @Test(expected = RuntimeException.class)
    public void testAgregarComentario5() {
        System.out.println("agregarComentario5");        
        Date fecha = new Date(2019,07,10);
        DtComentario dtComentario = new DtComentario(Comentario.getNuevoID(), "usrseleccionado", fecha, "un desastre el 1", 1);
        Usuario usuario = null;
        videoPrueba.agregarComentario(dtComentario, usuario);
    }

    /**
     * Test OK
     */
    @Test
    public void testAgregarModificarValoracion() {
        System.out.println("agregarModificarValoracion");
        DtValoracion val1 = new DtValoracion(TipoValoracion.DISLIKE, "usrseleccionado");
        videoPrueba.agregarModificarValoracion(val1, usrSeleccionado);
        TipoValoracion resultado = videoPrueba.obtenerValoracion("usrseleccionado").getVal();
        assertEquals(resultado, TipoValoracion.DISLIKE);
    }
    
    /**
     * Test OK DtValoracion = null
     */
    @Test(expected = RuntimeException.class)
    public void testAgregarModificarValoracion2() {
        System.out.println("agregarModificarValoracion2");
        DtValoracion val1 = null;
        videoPrueba.agregarModificarValoracion(val1, usrSeleccionado);
    }
    
    /**
     * Test OK Usuario = null
     */
    @Test(expected = RuntimeException.class)
    public void testAgregarModificarValoracion3() {
        System.out.println("agregarModificarValoracion3");
        DtValoracion val1 = new DtValoracion(TipoValoracion.DISLIKE, "usrseleccionado");
        Usuario usuario = null;
        videoPrueba.agregarModificarValoracion(val1, usuario);
    }
    
    /**
     * Test OK modificando la valoracion de dislike a like
     */
    @Test
    public void testAgregarModificarValoracion4() {
        System.out.println("agregarModificarValoracion4");
        DtValoracion val1 = new DtValoracion(TipoValoracion.DISLIKE, "usrseleccionado");
        videoPrueba.agregarModificarValoracion(val1, usrSeleccionado);//Agrega una valoración
        DtValoracion val2 = new DtValoracion(TipoValoracion.LIKE, "usrseleccionado");
        videoPrueba.agregarModificarValoracion(val2, usrSeleccionado);//modifica la valoración
        TipoValoracion resultado = videoPrueba.obtenerValoracion("usrseleccionado").getVal();
        assertEquals(resultado, TipoValoracion.LIKE);        
    }
    
     /**
     * Test OK modificando la valoracion de like a dislike
     */
    @Test
    public void testAgregarModificarValoracion5() {
        System.out.println("agregarModificarValoracion5");
        DtValoracion val1 = new DtValoracion(TipoValoracion.LIKE, "usrseleccionado");
        videoPrueba.agregarModificarValoracion(val1, usrSeleccionado);//Agrega una valoración
        DtValoracion val2 = new DtValoracion(TipoValoracion.DISLIKE, "usrseleccionado");
        videoPrueba.agregarModificarValoracion(val2, usrSeleccionado);//modifica la valoración
        TipoValoracion resultado = videoPrueba.obtenerValoracion("usrseleccionado").getVal();
        assertEquals(resultado, TipoValoracion.DISLIKE);        
    }

    /**
     * Test ok
     */
    @Test
    public void testGetDt() {
        System.out.println("getDt");
        Date fecha1 = new Date(1976,1,31);
        Time duracion1 = new Time(0, 2, 40);
        DtVideo expResult = new DtVideo(1, "MiVideo", "Video para comentar",duracion1, fecha1,"url",Privacidad.PRIVADO,"categoria",0,0);
        DtVideo result = videoPrueba.getDt();
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test OK
     */
    @Test
    public void testListarComentarios() {
        System.out.println("listarComentarios");
        Date fecha1 = new Date(1976,1,31);
        DtComentario dtComentario = new DtComentario(3, "usrseleccionado", fecha1, "comentario del video", 0); 
        ArrayList<DtComentario> expResult = new ArrayList<>();
        expResult.add(dtComentario);
        videoPrueba.agregarComentario(dtComentario, usrSeleccionado);
        ArrayList<DtComentario> result = videoPrueba.listarComentarios();
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test OK
     */
    @Test
    public void testListarValoraciones() {
        System.out.println("listarValoraciones");
        DtValoracion dtValoracion1 = new DtValoracion(TipoValoracion.LIKE, "usrseleccionado");
        videoPrueba.agregarModificarValoracion(dtValoracion1, usrSeleccionado);
        DtValoracion dtValoracion2 = new DtValoracion(TipoValoracion.LIKE, "usrseleccionado2");
        videoPrueba.agregarModificarValoracion(dtValoracion2, usrSeleccionado2);
        ArrayList<DtValoracion> listaVal = new ArrayList<>();
        listaVal.add(dtValoracion1);
        listaVal.add(dtValoracion2);
        ArrayList<DtValoracion> result = videoPrueba.listarValoraciones();
        boolean esperado=true, resultado=false;
        for (int i = 0; i < result.size(); i++) {
            if(listaVal.get(i).getVal()==result.get(i).getVal()){
                resultado = true;
            }else{
                resultado = false;
                break;
            }
        }
        assertEquals(esperado, resultado);
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
     * Test OK con dtVideo null
     */
    @Test(expected = RuntimeException.class)
    public void testModificar2() {
        System.out.println("modificar2");
        DtVideo dtVideo = null;
        videoPrueba.modificar(dtVideo);
    }
    
    /**
     * Test OK nombre vacio
     */
    @Test(expected = RuntimeException.class)
    public void testModificar3() {
        System.out.println("modificar3");
        Date fecha1 = new Date(1976,1,31);
        Time duracion1 = new Time(0, 2, 40);
        DtVideo dtVideo = new DtVideo(1, "", "Video modificado",duracion1, fecha1,"url",Privacidad.PRIVADO,"categoria",0,0);
        videoPrueba.modificar(dtVideo);
    }
    
    /**
     * Test OK duracion es null
     */
    @Test(expected = RuntimeException.class)
    public void testModificar4() {
        System.out.println("modificar4");
        Date fecha1 = new Date(1976,1,31);
        Time duracion1 = null;
        DtVideo dtVideo = new DtVideo(1, "MiVideo", "Video modificado",duracion1, fecha1,"url",Privacidad.PRIVADO,"categoria",0,0);
        videoPrueba.modificar(dtVideo);
    }
        
    /**
     * Test OK categoria es vacía
     */
    @Test(expected = RuntimeException.class)
    public void testModificar5() {
        System.out.println("modificar5");
        Date fecha1 = new Date(1976,1,31);
        Time duracion1 = new Time(00,29,00);
        DtVideo dtVideo = new DtVideo(1, "MiVideo", "Video modificado",duracion1, fecha1,"url",Privacidad.PRIVADO,"",0,0);
        videoPrueba.modificar(dtVideo);
    }
    
     /**
     * Test OK fecha null
     */
    @Test(expected = RuntimeException.class)
    public void testModificar6() {
        System.out.println("modificar6");
        Date fecha1 = null;
        Time duracion1 = new Time(00,29,00);
        DtVideo dtVideo = new DtVideo(1, "MiVideo", "Video modificado",duracion1, fecha1,"url",Privacidad.PRIVADO,"categoria",0,0);
        videoPrueba.modificar(dtVideo);
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
     * Test ok nickname vacio
     */
    @Test(expected = RuntimeException.class)
    public void testObtenerValoracion2() {
        System.out.println("obtenerValoracion2");
        String nickname = "usrseleccionado";
        DtValoracion val = new DtValoracion(TipoValoracion.LIKE, nickname);
        videoPrueba.agregarModificarValoracion(val, usrSeleccionado);
        videoPrueba.obtenerValoracion("");        
    }

    /**
     * Test OK
     */
    @Test
    public void testQuitarValoracion() {
        System.out.println("quitarValoracion");
        String nickname = "usrseleccionado";
        DtValoracion dtValoracion = new DtValoracion(TipoValoracion.LIKE, nickname);
        videoPrueba.agregarModificarValoracion(dtValoracion, usrSeleccionado);       
        videoPrueba.quitarValoracion(nickname);
        int esperado = 0, resultado = videoPrueba.listarValoraciones().size();
        assertEquals(esperado, resultado);
    }
    
        /**
     * Test OK
     */
    @Test
    public void testQuitarValoracion2() {
        System.out.println("quitarValoracion2");
        String nickname = "usrseleccionado";
        DtValoracion dtValoracion = new DtValoracion(TipoValoracion.DISLIKE, nickname);
        videoPrueba.agregarModificarValoracion(dtValoracion, usrSeleccionado);       
        videoPrueba.quitarValoracion(nickname);
        int esperado = 0, resultado = videoPrueba.listarValoraciones().size();
        assertEquals(esperado, resultado);
    }
    
    /**
     * Test OK nickname vacio
     */
    @Test(expected = RuntimeException.class)
    public void testQuitarValoracion3() {
        System.out.println("quitarValoracion3");
        DtValoracion dtValoracion = new DtValoracion(TipoValoracion.LIKE, "usrseleccionado");
        videoPrueba.agregarModificarValoracion(dtValoracion, usrSeleccionado);       
        videoPrueba.quitarValoracion("");
    }

    /**
     * Test of getNuevoId method, of class Video.
     */
    @Test
    public void testGetNuevoId() {
        System.out.println("getNuevoId");
        int expResult = 11;
        int result = Video.getNuevoId();
        assertEquals(expResult, result);
    }

    /**
     * Test OK
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int expResult = 1;
        int result = videoPrueba.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test OK
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 100;
        Video instance = new Video();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test OK
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");        
        String expResult = "MiVideo";
        String result = videoPrueba.getNombre();
        assertEquals(expResult, result);
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
     * Test OK
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
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
    }

    /**
     * Test ok
     */
    @Test
    public void testGetDuracion() {
        System.out.println("getDuracion"); 
        Time expResult = new Time(0, 2, 40);
        videoPrueba.setDuracion(expResult);
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
     * Test OK
     */
    @Test
    public void testGetFechaPublicacion() {
        System.out.println("getFechaPublicacion");
        Video instance = new Video();
        Date expResult = new Date(1978,1,31);
        videoPrueba.setFechaPublicacion(expResult);
        Date result = videoPrueba.getFechaPublicacion();
        assertEquals(expResult, result);
    }

    /**
     * Test OK
     */
    @Test
    public void testSetFechaPublicacion() {
        System.out.println("setFechaPublicacion");
        Date fechaPublicacion = new Date(1999,6,4);
        videoPrueba.setFechaPublicacion(fechaPublicacion);
        assertEquals(fechaPublicacion, videoPrueba.getFechaPublicacion());
    }

    /**
     * Test OK
     */
    @Test
    public void testGetUrlVideoOriginal() {
        System.out.println("getUrlVideoOriginal");
        String expResult = "url test";
        videoPrueba.setUrlVideoOriginal(expResult);
        String result = videoPrueba.getUrlVideoOriginal();
        assertEquals(expResult, result);
    }

    /**
     * Test OK
     */
    @Test
    public void testSetUrlVideoOriginal() {
        System.out.println("setUrlVideoOriginal");
        String urlVideoOriginal = "url test2";
        videoPrueba.setUrlVideoOriginal(urlVideoOriginal);
        assertEquals(urlVideoOriginal, videoPrueba.getUrlVideoOriginal());
    }

    /**
     * Test OK
     */
    @Test
    public void testGetPrivacidad() {
        System.out.println("getPrivacidad");
        Privacidad expResult = Privacidad.PRIVADO;
        videoPrueba.setPrivacidad(expResult);
        Privacidad result = videoPrueba.getPrivacidad();
        assertEquals(expResult, result);
    }

    /**
     * Test OK
     */
    @Test
    public void testSetPrivacidad() {
        System.out.println("setPrivacidad");
        Privacidad expPrivacidad;
        if(videoPrueba.getPrivacidad() == Privacidad.PRIVADO){
            expPrivacidad = Privacidad.PUBLICO;
            videoPrueba.setPrivacidad(expPrivacidad);
        }else{
            expPrivacidad = Privacidad.PRIVADO;
            videoPrueba.setPrivacidad(expPrivacidad);
        }
        assertEquals(expPrivacidad, videoPrueba.getPrivacidad());
    }

    /**
     * Test OK
     */
    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
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
    }

    /**
     * Test of setCantLikes method, of class Video.
     */
    @Test
    public void testSetCantLikes() {
        System.out.println("setCantLikes");
        int cantLikes = videoPrueba.getCantLikes();
        cantLikes++;
        videoPrueba.setCantLikes(cantLikes);
        assertEquals(cantLikes, videoPrueba.getCantLikes());
    }

    /**
     * Test of getCantDisLikes method, of class Video.
     */
    @Test
    public void testGetCantDisLikes() {
        System.out.println("getCantDisLikes");
        int expResult = 0;
        
        int result = videoPrueba.getCantDisLikes();
        assertEquals(expResult, result);
    }

    /**
     * Test OK
     */
    @Test
    public void testSetCantDisLikes() {
        System.out.println("setCantDisLikes");
        int expResult = videoPrueba.getCantDisLikes();
        expResult++;
        videoPrueba.setCantDisLikes(expResult);
        assertEquals(expResult, videoPrueba.getCantDisLikes());
    }
    
    /**
     * Test OK
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Video{id=1, nombre=MiVideo, descripcion=Video para comentar, duracion=00:02:40, fechaPublicacion=3876-03-02, urlVideoOriginal=url, privacidad=PRIVADO, categoria=categoria, cantLikes=0, cantDisLikes=0}";
        String result = videoPrueba.toString();
        assertEquals(expResult, result);        
    }
    
    @RunWith(Parameterized.class)
    public class VideoTestParemetrizado{

    }
    
}


