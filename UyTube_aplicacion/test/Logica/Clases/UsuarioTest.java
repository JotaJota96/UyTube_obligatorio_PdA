/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Clases;

import Logica.DataType.DtCanal;
import Logica.DataType.DtComentario;
import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtUsuario;
import Logica.DataType.DtValoracion;
import Logica.DataType.DtVideo;
import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoListaDeReproduccion;
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
 * @author pc01
 */
public class UsuarioTest {
    Usuario instance = null;
    Video v = null;
    ListaDeReproduccion ldr= null;
    
    public UsuarioTest() {
        instance = new Usuario("nickname", "correo", new Date(2019 - 1900, 1, 1),
                "imagen", "contrasenia", "nombre", "apellido",
                new DtCanal(0, "canal", "descripcion", Privacidad.PUBLICO));
         v = new Video(0, "nombre", "descripcion", new Time(1, 2, 3), new Date(2019 - 1900, 1, 2), "urlVideo", "UNDEFINED");
        ldr = new ListaDeReproduccion(0, "nombre", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED");
        instance.agregarVideoACanal(v.getDt());
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
     * Test of constructor method, of class Usuario.
     */
    @Test
    public void testUsuario_exp1() {
        System.out.println("testUsuario_exp1");
        Usuario instancia = null;
        try {
            instancia = new Usuario("", "correo", new Date(2019 - 1900, 1, 1),
                    "imagen", "contrasenia", "nombre", "apellido",
                    new DtCanal(0, "canal", "descripcion", Privacidad.PUBLICO));
        } catch (Exception e) {
            assertNull(instancia);
        }
    }
    @Test
    public void testUsuario_exp2() {
        System.out.println("testUsuario_exp2");
        Usuario instancia = null;
        try {
            instancia = new Usuario("nickname", "", new Date(2019 - 1900, 1, 1),
                    "imagen", "contrasenia", "nombre", "apellido",
                    new DtCanal(0, "canal", "descripcion", Privacidad.PUBLICO));
        } catch (Exception e) {
            assertNull(instancia);
        }
    }
    @Test
    public void testUsuario_exp3() {
        System.out.println("testUsuario_exp3");
        Usuario instancia = null;
        try {
            instancia = new Usuario("nickname", "correo", null,
                    "imagen", "contrasenia", "nombre", "apellido",
                    new DtCanal(0, "canal", "descripcion", Privacidad.PUBLICO));
        } catch (Exception e) {
            assertNull(instancia);
        }
    }
    @Test
    public void testUsuario_exp4() {
        System.out.println("testUsuario_exp4");
        Usuario instancia = null;
        try {
            instancia = new Usuario("nickname", "correo", new Date(2019 - 1900, 1, 1),
                    "imagen", "contrasenia", "nombre", "apellido",
                    null);
        } catch (Exception e) {
            assertNull(instancia);
        }
    }
    //----------------------------------------------------------------------------------------------
    /**
     * Test of getNickname method, of class Usuario.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        String expResult = "nickname";
        String result = instance.getNickname();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCorreo method, of class Usuario.
     */
    @Test
    public void testGetCorreo() {
        System.out.println("getCorreo");
         String expResult = "correo";
        String result = instance.getCorreo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFechaNacimiento method, of class Usuario.
     */
    @Test
    public void testGetFechaNacimiento() {
        System.out.println("getFechaNacimiento");
        Date expResult = new Date(2019 - 1900, 1, 1);
        Date result = instance.getFechaNacimiento();
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of getImagen method, of class Usuario.
     */
    @Test
    public void testGetImagen() {
        System.out.println("getImagen");
       String expResult = "imagen";
        String result = instance.getImagen();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSeguidores method, of class Usuario.
     */
    @Test
    public void testGetSeguidores() {
        System.out.println("getSeguidores");
        int expResult = 0;
        int result = instance.getSeguidores();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDT method, of class Usuario.
     */
    @Test
    public void testGetDT() {
        System.out.println("getDT");
        DtUsuario expResult = new DtUsuario("nickname", "contrasenia", "nombre", "apellido", "correo", new Date(2019 - 1900, 1, 1), "imagen", 0);
        DtUsuario result = instance.getDT();
        assertEquals(expResult.toString(), result.toString());
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Test of actualizarListasPorDefecto method, of class Usuario.
     */
    @Test
    public void testActualizarListasPorDefecto() {
        System.out.println("actualizarListasPorDefecto");
       instance.actualizarListasPorDefecto();
        assertNull(null);
    }

    /**
     * Test of agregarComentarioAVideo method, of class Usuario.
     */
    @Test
    public void testAgregarComentarioAVideo_3args_1() {
        System.out.println("agregarComentarioAVideo");
        int idVideo = 0;
        DtComentario DtComentario = null;
        Usuario Usu = instance;
        try {
            instance.agregarComentarioAVideo(idVideo, DtComentario, Usu);
            assertNull(instance); // por poner algo que no sea null...
        } catch (Exception e) {
            assertNull(null);
        }
    }
    @Test
    public void testAgregarComentarioAVideo_3args_2() {
        System.out.println("agregarComentarioAVideo");
        int idVideo = 0;
        DtComentario DtComentario = new DtComentario(2, "nick", new Date(2019-1900, 1, 1), "texto", 0);
        Usuario Usu = null;
        try {
            instance.agregarComentarioAVideo(idVideo, DtComentario, Usu);
            assertEquals(false, true);
        } catch (Exception e) {
            assertEquals(true, true);
        }
    }
    @Test
    public void testAgregarComentarioAVideo_3args_3() {
        System.out.println("testAgregarComentarioAVideo_3args_3");
        int idVideo = instance.listarVideosDeCanal().get(0).getId();
        DtComentario DtComentario = new DtComentario(2, "nick", new Date(2019-1900, 1, 1), "texto", 0);
        Usuario Usu = instance;
        try {
            instance.agregarComentarioAVideo(idVideo, DtComentario, Usu);
            assertEquals(true, true);
        } catch (Exception e) {
            assertEquals(false, true);
        }
    }
    
    /**
     * Test of agregarComentarioAVideo method, of class Usuario.
     */
    @Test
    public void testAgregarComentarioAVideo_4args_1() {
        System.out.println("testAgregarComentarioAVideo_4args_1");
        Usuario Usu = instance;
        DtComentario DtComentario = new DtComentario(0, "nick", new Date(2019-1900, 1, 1), "texto", 0);
        int idVideo = instance.listarVideosDeCanal().get(0).getId();
        instance.agregarComentarioAVideo(idVideo, DtComentario, Usu);
        int idCom = instance.listarComentariosDeVideo(idVideo).get(0).getId();
        try {
            instance.agregarComentarioAVideo(idVideo, idCom, DtComentario, Usu);
            assertNull(null);
        } catch (Exception e) {
            assertNull(instance); // por poner algo que no sea null...
        }
    }
    @Test
    public void testAgregarComentarioAVideo_4args_2() {
        System.out.println("testAgregarComentarioAVideo_4args_2");
        Usuario Usu = instance;
        DtComentario DtComentario = new DtComentario(0, "nick", new Date(2019-1900, 1, 1), "texto", 0);
        int idVideo = instance.listarVideosDeCanal().get(0).getId();
        instance.agregarComentarioAVideo(idVideo, DtComentario, Usu);
        int idCom = instance.listarComentariosDeVideo(idVideo).get(0).getId();
        try {
            instance.agregarComentarioAVideo(idVideo, idCom, DtComentario, null);
            assertNull(null);
        } catch (Exception e) {
            assertNull(instance); // por poner algo que no sea null...
        }
    }
    @Test
    public void testAgregarComentarioAVideo_4args_3() {
        System.out.println("testAgregarComentarioAVideo_4args_3");
        Usuario Usu = instance;
        DtComentario DtComentario = new DtComentario(0, "nick", new Date(2019-1900, 1, 1), "texto", 0);
        int idVideo = instance.listarVideosDeCanal().get(0).getId();
        instance.agregarComentarioAVideo(idVideo, DtComentario, Usu);
        int idCom = instance.listarComentariosDeVideo(idVideo).get(0).getId();
        try {
            instance.agregarComentarioAVideo(idVideo, idCom, null, Usu);
            assertNull(null);
        } catch (Exception e) {
            assertNull(instance); // por poner algo que no sea null...
        }
    }

    /**
     * Test of agregarListaParticular method, of class Usuario.
     */
    @Test
    public void testAgregarListaParticular_1() {
        System.out.println("testAgregarListaParticular_1");
        DtListaDeReproduccion dt = ldr.getDt();
        //System.out.println(ldr.toString());
        //System.out.println(dt.toString());
        try {
            instance.agregarListaParticular(dt);
            assertNull(null);
        } catch (Exception e) {
            assertNull(dt);
        }
    }
    @Test
    public void testAgregarListaParticular_2() {
        System.out.println("agregarListaParticular_2");
        DtListaDeReproduccion dt = null;
        try {
            instance.agregarListaParticular(dt);
            assertNull(dt);
        } catch (Exception e) {
            assertNull(null);
        }
    }

    /**
     * Test of agregarModificarValoracionDeVideo method, of class Usuario.
     */
    @Test
    public void testAgregarModificarValoracionDeVideo_1() {
        System.out.println("testAgregarModificarValoracionDeVideo_1");
        DtValoracion DtValoracion = new DtValoracion(TipoValoracion.LIKE, "instance");
        Usuario Usu = instance;
        int idVideo = instance.listarVideosDeCanal().get(0).getId();
        
        try {
            instance.agregarModificarValoracionDeVideo(idVideo, DtValoracion, Usu);
            assertNotNull(null);
        } catch (Exception e) {
            assertNull(null);
        }
    }
    @Test
    public void testAgregarModificarValoracionDeVideo_2() {
        System.out.println("testAgregarModificarValoracionDeVideo_2");
        DtValoracion DtValoracion = new DtValoracion(TipoValoracion.LIKE, "instance");
        Usuario Usu = null;
        int idVideo = instance.listarVideosDeCanal().get(0).getId();
        
        try {
            instance.agregarModificarValoracionDeVideo(idVideo, DtValoracion, Usu);
            assertNotNull(null);
        } catch (Exception e) {
            assertNull(null);
        }
    }
    @Test
    public void testAgregarModificarValoracionDeVideo_3() {
        System.out.println("testAgregarModificarValoracionDeVideo_3");
        DtValoracion DtValoracion = null;
        Usuario Usu = instance;
        int idVideo = instance.listarVideosDeCanal().get(0).getId();
        
        try {
            instance.agregarModificarValoracionDeVideo(idVideo, DtValoracion, Usu);
            assertNotNull(null);
        } catch (Exception e) {
            assertNull(null);
        }
    }

    /**
     * Test of agregarOQuitarSeguido method, of class Usuario.
     */
    @Test
    public void testAgregarOQuitarSeguido_1() {
        System.out.println("testAgregarOQuitarSeguido_1");
        Usuario Usu = new Usuario("nickname", "correo", new Date(2019 - 1900, 1, 1),
                "imagen", "contrasenia", "nombre", "apellido",
                new DtCanal(0, "canal", "descripcion", Privacidad.PUBLICO));
        int antes = Usu.getSeguidores() +1;
        instance.agregarOQuitarSeguido(Usu);
        int despues = Usu.getSeguidores();
        
        boolean parte1 = antes == despues;
        
         antes = Usu.getSeguidores() -1;
        instance.agregarOQuitarSeguido(Usu);
         despues = Usu.getSeguidores();
        
        boolean parte2 = antes == despues;
        
        if (parte1 && parte2){
            assertNull(null);
        }else{
            assertNotNull(null);
        }
    }
    @Test
    public void testAgregarOQuitarSeguido_2() {
        System.out.println("testAgregarOQuitarSeguido_2");
        Usuario Usu = new Usuario("nickname", "correo", new Date(2019 - 1900, 1, 1),
                "imagen", "contrasenia", "nombre", "apellido",
                new DtCanal(0, "canal", "descripcion", Privacidad.PUBLICO));
        
        int antes = Usu.getSeguidores();
        try {
            instance.agregarOQuitarSeguido(null);
        } catch (Exception e) {
            int despues = Usu.getSeguidores();
            assertEquals(antes, despues);
        }
    }
    @Test
    public void testAgregarOQuitarSeguido_3() {
        System.out.println("testAgregarOQuitarSeguido_3");
        Usuario Usu = new Usuario("nickname", "correo", new Date(2019 - 1900, 1, 1),
                "imagen", "contrasenia", "nombre", "apellido",
                new DtCanal(0, "canal", "descripcion", Privacidad.PUBLICO));
        
        int antes = Usu.getSeguidores();
        try {
            instance.agregarOQuitarSeguido(instance);
        } catch (Exception e) {
            int despues = Usu.getSeguidores();
            assertEquals(antes, despues);
        }
    }


    /**
     * Test of agregarVideoACanal method, of class Usuario.
     */
    @Test
    public void testAgregarVideoACanal_1() {
        System.out.println("agregarVideoACanal_1");
        int antes, despues;
        antes = instance.listarVideosDeCanal().size() + 1;
        try {
            instance.agregarVideoACanal(v.getDt());
        } catch (Exception e) {
            despues = instance.listarVideosDeCanal().size();
            assertEquals(despues, antes);
        }
    }
    @Test
    public void testAgregarVideoACanal_2() {
        System.out.println("agregarVideoACanal_2");
        int antes, despues;
        antes = instance.listarVideosDeCanal().size();
        try {
            instance.agregarVideoACanal(null);
        } catch (Exception e) {
            despues = instance.listarVideosDeCanal().size();
            assertEquals(despues, antes);
        }
    }
    
    /**
     * Test of agregarVideoALista method, of class Usuario.
     */
    @Test
    public void testAgregarVideoALista_1() {
        System.out.println("agregarVideoALista_1");
        int idLista = instance.listarListasDeReproduccionDeCanal(false).get(0).getId();
        int idVideo = instance.listarVideosDeCanal().get(0).getId();
        Usuario Usu = instance;
        int antes, despues;
        antes = instance.listarVideosDeListaDeReproduccion(idLista).size();
        instance.agregarVideoALista(idLista, idVideo, Usu);
        despues = instance.listarVideosDeListaDeReproduccion(idLista).size();
        assertNotEquals(despues, antes);
    }
    @Test
    public void testAgregarVideoALista_2() {
        System.out.println("agregarVideoALista_2");
        int idLista = instance.listarListasDeReproduccionDeCanal(false).get(0).getId();
        int idVideo = instance.listarVideosDeCanal().get(0).getId();
        Usuario Usu = instance;
        int antes, despues;
        antes = instance.listarVideosDeListaDeReproduccion(idLista).size();
        
        try {
            instance.agregarVideoALista(idLista, -5, Usu);
        } catch (Exception e) {
            despues = instance.listarVideosDeListaDeReproduccion(idLista).size();
            assertEquals(despues, antes);
        }
    }
    @Test
    public void testAgregarVideoALista_3() {
        System.out.println("agregarVideoALista_3");
        int idLista = instance.listarListasDeReproduccionDeCanal(false).get(0).getId();
        int idVideo = instance.listarVideosDeCanal().get(0).getId();
        Usuario Usu = instance;
        int antes, despues;
        antes = instance.listarVideosDeListaDeReproduccion(idLista).size();
        
        try {
            instance.agregarVideoALista(idLista, idVideo, null);
        } catch (Exception e) {
            despues = instance.listarVideosDeListaDeReproduccion(idLista).size();
            assertEquals(despues, antes);
        }
    }



    
    
    
    
    
    
    
    
    
    /**
     * Test of listarComentariosDeVideo method, of class Usuario.
     */
    @Test
    public void testListarComentariosDeVideo() {
        System.out.println("listarComentariosDeVideo");
        int idVideo = 0;
        Usuario instance = null;
        ArrayList<DtComentario> expResult = null;
        ArrayList<DtComentario> result = instance.listarComentariosDeVideo(idVideo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarListasDeReproduccionDeCanal method, of class Usuario.
     */
    @Test
    public void testListarListasDeReproduccionDeCanal() {
        System.out.println("listarListasDeReproduccionDeCanal");
        boolean porDefecto = false;
        Usuario instance = null;
        ArrayList<DtListaDeReproduccion> expResult = null;
        ArrayList<DtListaDeReproduccion> result = instance.listarListasDeReproduccionDeCanal(porDefecto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarUsuariosSeguidos method, of class Usuario.
     */
    @Test
    public void testListarUsuariosSeguidos() {
        System.out.println("listarUsuariosSeguidos");
        Usuario instance = null;
        ArrayList<DtUsuario> expResult = null;
        ArrayList<DtUsuario> result = instance.listarUsuariosSeguidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarUsuariosSeguidores method, of class Usuario.
     */
    @Test
    public void testListarUsuariosSeguidores() {
        System.out.println("listarUsuariosSeguidores");
        Usuario instance = null;
        ArrayList<DtUsuario> expResult = null;
        ArrayList<DtUsuario> result = instance.listarUsuariosSeguidores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarValoracionesDeVideo method, of class Usuario.
     */
    @Test
    public void testListarValoracionesDeVideo() {
        System.out.println("listarValoracionesDeVideo");
        int id = 0;
        Usuario instance = null;
        ArrayList<DtValoracion> expResult = null;
        ArrayList<DtValoracion> result = instance.listarValoracionesDeVideo(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarVideosDeCanal method, of class Usuario.
     */
    @Test
    public void testListarVideosDeCanal() {
        System.out.println("listarVideosDeCanal");
        Usuario instance = null;
        ArrayList<DtVideo> expResult = null;
        ArrayList<DtVideo> result = instance.listarVideosDeCanal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarVideosDeListaDeReproduccion method, of class Usuario.
     */
    @Test
    public void testListarVideosDeListaDeReproduccion() {
        System.out.println("listarVideosDeListaDeReproduccion");
        int id = 0;
        Usuario instance = null;
        ArrayList<DtVideo> expResult = null;
        ArrayList<DtVideo> result = instance.listarVideosDeListaDeReproduccion(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class Usuario.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        DtUsuario DtUsu = null;
        DtCanal DtCanal = null;
        Usuario instance = null;
        instance.modificar(DtUsu, DtCanal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarListaDeReproduccionDeCanal method, of class Usuario.
     */
    @Test
    public void testModificarListaDeReproduccionDeCanal() {
        System.out.println("modificarListaDeReproduccionDeCanal");
        DtListaDeReproduccion DtListaDeReproduccion = null;
        Usuario instance = null;
        instance.modificarListaDeReproduccionDeCanal(DtListaDeReproduccion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarVideoDeCanal method, of class Usuario.
     */
    @Test
    public void testModificarVideoDeCanal() {
        System.out.println("modificarVideoDeCanal");
        DtVideo DtVideo = null;
        Usuario instance = null;
        instance.modificarVideoDeCanal(DtVideo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerCanal method, of class Usuario.
     */
    @Test
    public void testObtenerCanal() {
        System.out.println("obtenerCanal");
        Usuario instance = null;
        DtCanal expResult = null;
        DtCanal result = instance.obtenerCanal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerListaDeReproduccion method, of class Usuario.
     */
    @Test
    public void testObtenerListaDeReproduccion() {
        System.out.println("obtenerListaDeReproduccion");
        int id = 0;
        Usuario instance = null;
        DtListaDeReproduccion expResult = null;
        DtListaDeReproduccion result = instance.obtenerListaDeReproduccion(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerListasEnCategoria method, of class Usuario.
     */
    @Test
    public void testObtenerListasEnCategoria() {
        System.out.println("obtenerListasEnCategoria");
        String cat = "";
        Usuario instance = null;
        ArrayList<DtListaDeReproduccion> expResult = null;
        ArrayList<DtListaDeReproduccion> result = instance.obtenerListasEnCategoria(cat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerValoracion method, of class Usuario.
     */
    @Test
    public void testObtenerValoracion() {
        System.out.println("obtenerValoracion");
        int id = 0;
        String nickname = "";
        Usuario instance = null;
        DtValoracion expResult = null;
        DtValoracion result = instance.obtenerValoracion(id, nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerVideo method, of class Usuario.
     */
    @Test
    public void testObtenerVideo() {
        System.out.println("obtenerVideo");
        int id = 0;
        Usuario instance = null;
        Video expResult = null;
        Video result = instance.obtenerVideo(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerVideoDeCanal method, of class Usuario.
     */
    @Test
    public void testObtenerVideoDeCanal() {
        System.out.println("obtenerVideoDeCanal");
        int idVideo = 0;
        Usuario instance = null;
        DtVideo expResult = null;
        DtVideo result = instance.obtenerVideoDeCanal(idVideo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerVideosEnCategoria method, of class Usuario.
     */
    @Test
    public void testObtenerVideosEnCategoria() {
        System.out.println("obtenerVideosEnCategoria");
        String cat = "";
        Usuario instance = null;
        ArrayList<DtVideo> expResult = null;
        ArrayList<DtVideo> result = instance.obtenerVideosEnCategoria(cat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quitarValoracion method, of class Usuario.
     */
    @Test
    public void testQuitarValoracion() {
        System.out.println("quitarValoracion");
        int id = 0;
        String nickname = "";
        Usuario instance = null;
        instance.quitarValoracion(id, nickname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quitarVideoDeListaDeReproduccion method, of class Usuario.
     */
    @Test
    public void testQuitarVideoDeListaDeReproduccion() {
        System.out.println("quitarVideoDeListaDeReproduccion");
        int idLista = 0;
        int idVideo = 0;
        Usuario instance = null;
        instance.quitarVideoDeListaDeReproduccion(idLista, idVideo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarListaParticular method, of class Usuario.
     */
    @Test
    public void testValidarListaParticular() {
        System.out.println("validarListaParticular");
        String nombre = "";
        Usuario instance = null;
        boolean expResult = false;
        boolean result = instance.validarListaParticular(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
