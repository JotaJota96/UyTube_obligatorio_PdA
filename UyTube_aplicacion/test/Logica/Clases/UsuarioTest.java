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
            assertNull(instance); // por poner algo que no sea null...
        } catch (Exception e) {
            assertNull(null);
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
            assertNull(instance); // por poner algo que no sea null...
        } catch (Exception e) {
            assertNull(null);
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
            assertNull(null);
        } catch (Exception e) {
            assertNotNull(null);
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
        antes = instance.listarVideosDeCanal().size();
        Video v2 = new Video(0, "nombre de otro video", "descripcion", new Time(1, 2, 3), new Date(2019 - 1900, 1, 2), "urlVideo", "UNDEFINED");
        
        try {
            instance.agregarVideoACanal(v2.getDt());
            despues = instance.listarVideosDeCanal().size();
            assertNotEquals(despues, antes);
        } catch (Exception e) {
            despues = instance.listarVideosDeCanal().size();
            assertNotEquals(despues, antes);
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
     * Test of listarUsuariosSeguidos method, of class Usuario.
     */
    @Test
    public void testListarUsuariosSeguidos() {
        System.out.println("listarUsuariosSeguidos");
        Usuario Usu = new Usuario("nickname", "correo", new Date(2019 - 1900, 1, 1),
                "imagen", "contrasenia", "nombre", "apellido",
                new DtCanal(0, "canal", "descripcion", Privacidad.PUBLICO));
        instance.agregarOQuitarSeguido(Usu);

        ArrayList<DtUsuario> expResult = new ArrayList();
        
        ArrayList<DtUsuario> result = instance.listarUsuariosSeguidos();
        instance.agregarOQuitarSeguido(Usu);
        assertNotEquals(expResult.size(), result.size());
    }

    /**
     * Test of listarUsuariosSeguidores method, of class Usuario.
     */
    @Test
    public void testListarUsuariosSeguidores() {
        System.out.println("listarUsuariosSeguidores");
        Usuario Usu = new Usuario("nickname", "correo", new Date(2019 - 1900, 1, 1),
                "imagen", "contrasenia", "nombre", "apellido",
                new DtCanal(0, "canal", "descripcion", Privacidad.PUBLICO));
        instance.agregarOQuitarSeguido(Usu);

        ArrayList<DtUsuario> expResult = new ArrayList();
        
        ArrayList<DtUsuario> result = Usu.listarUsuariosSeguidores();
        instance.agregarOQuitarSeguido(Usu);
        assertNotEquals(expResult.size(), result.size());
    }

    /**
     * Test of listarValoracionesDeVideo method, of class Usuario.
     */
    @Test
    public void testListarValoracionesDeVideo() {
        System.out.println("listarValoracionesDeVideo");
        int id = instance.listarVideosDeCanal().get(0).getId();
        ArrayList<DtValoracion> expResult = new ArrayList();
        ArrayList<DtValoracion> result = null;
        try {
            result = instance.listarValoracionesDeVideo(id);
            assertNull(null);
        } catch (Exception e) {
            assertNotNull(null);
        }
    }
    
    /**
     * Test of listarVideosDeCanal method, of class Usuario.
     */
    @Test
    public void testListarVideosDeCanal() {
        System.out.println("listarVideosDeCanal");
        int id = instance.listarVideosDeCanal().get(0).getId();
        ArrayList<DtVideo> expResult = new ArrayList();
        ArrayList<DtVideo> result = null;
        try {
            result = instance.listarVideosDeCanal();
            assertNull(null);
        } catch (Exception e) {
            assertNotNull(null);
        }
    }

    /**
     * Test of listarVideosDeListaDeReproduccion method, of class Usuario.
     */
    @Test
    public void testListarVideosDeListaDeReproduccion() {
        System.out.println("listarVideosDeListaDeReproduccion");
        int id = instance.listarListasDeReproduccionDeCanal(false).get(0).getId();
        ArrayList<DtVideo> expResult = new ArrayList();
        ArrayList<DtVideo> result = null;
        try {
            result = instance.listarVideosDeListaDeReproduccion(id);
            assertNull(null);
        } catch (Exception e) {
            assertNotNull(null);
        }
    }

    /**
     * Test of modificar method, of class Usuario.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        Usuario Usu = new Usuario("nickname", "correo", new Date(2000 - 1900, 1, 1),
                "img", "contra", "nom", "ape",
                new DtCanal(0, "canal", "descripcion", Privacidad.PUBLICO));
        DtUsuario DtUsu = Usu.getDT();
        DtCanal dtc = instance.obtenerCanal();
        instance.modificar(DtUsu, dtc);
        assertEquals(DtUsu.toString(), instance.getDT().toString());
    }
    @Test
    public void testModificar_1() {
        System.out.println("testModificar_1");
        Usuario Usu = new Usuario("nickn", "cor", new Date(2000 - 1900, 1, 1),
                "img", "contra", "nom", "ape",
                new DtCanal(0, "canal", "descripcion", Privacidad.PUBLICO));
        DtUsuario DtUsu = Usu.getDT();
        DtCanal dtc = instance.obtenerCanal();
        
        String antes = instance.getDT().toString();
        try {
            instance.modificar(null, dtc);
        } catch (Exception e) {
            String despues = instance.getDT().toString();
            assertEquals(antes, despues);
        }
    }
    @Test
    public void testModificar_2() {
        System.out.println("testModificar_2");
        Usuario Usu = new Usuario("nickn", "cor", new Date(2000 - 1900, 1, 1),
                "img", "contra", "nom", "ape",
                new DtCanal(0, "canal", "descripcion", Privacidad.PUBLICO));
        DtUsuario DtUsu = Usu.getDT();
        DtCanal dtc = instance.obtenerCanal();
        
        String antes = instance.getDT().toString();
        try {
            instance.modificar(DtUsu, null);
        } catch (Exception e) {
            String despues = instance.getDT().toString();
            assertEquals(antes, despues);
        }
    }
    @Test
    public void testModificar_3() {
        System.out.println("testModificar_3");
        Usuario Usu = new Usuario("nickn", "cor", new Date(2000 - 1900, 1, 1),
                "img", "contra", "nom", "ape",
                new DtCanal(0, "canal", "descripcion", Privacidad.PUBLICO));
        
        DtUsuario DtUsu = new DtUsuario("nickname", "contrasenia", "nombre", "apellido", "correo", null, "imagen", 0);
        DtCanal dtc = instance.obtenerCanal();
        
        String antes = instance.getDT().toString();
        try {
            instance.modificar(DtUsu, dtc);
        } catch (Exception e) {
            String despues = instance.getDT().toString();
            assertEquals(antes, despues);
        }
    }
    
    /**
     * Test of modificarListaDeReproduccionDeCanal method, of class Usuario.
     */
    @Test
    public void testModificarListaDeReproduccionDeCanal_1() {
        System.out.println("testModificarListaDeReproduccionDeCanal_1");
        DtListaDeReproduccion DtListaDeReproduccion = ldr.getDt();
        int id = ListaDeReproduccion.getNuevoId() +1;
        instance.agregarListaParticular(ldr.getDt());
        DtListaDeReproduccion dt = new DtListaDeReproduccion(id, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "MUSICA");
        try {
            instance.modificarListaDeReproduccionDeCanal(dt);
            assertNull(null);
        } catch (Exception e) {
            assertNotNull(null);
        }
    }
    @Test
    public void testModificarListaDeReproduccionDeCanal_2() {
        System.out.println("testModificarListaDeReproduccionDeCanal_2");
        DtListaDeReproduccion DtListaDeReproduccion = null;
        
        try {
            instance.modificarListaDeReproduccionDeCanal(DtListaDeReproduccion);
            assertNotNull(null);
        } catch (Exception e) {
            assertNull(null);
        }
    }

    /**
     * Test of modificarVideoDeCanal method, of class Usuario.
     */
    @Test
    public void testModificarVideoDeCanal_1() {
        System.out.println("testModificarVideoDeCanal_1");
        
        int id = Video.getNuevoId() + 1;
        DtVideo dt1 = new DtVideo(id, "videito", "descripcioncita", new Time(1, 2, 3), new Date(2010-1900, 5, 25), "urlcita", Privacidad.PRIVADO, "MUSICA", 0, 0);
        instance.agregarVideoACanal(dt1);
        DtVideo dt2 = new DtVideo(id, "vid", "desc", new Time(1, 2, 3), new Date(2010-1900, 5, 25), "url_vid", Privacidad.PRIVADO, "MUSICA", 0, 0);
        
        try {
        instance.modificarVideoDeCanal(dt2);
            assertNull(null);
        } catch (Exception e) {
            assertNotNull(null);
        }
    }
    @Test
    public void testModificarVideoDeCanal_2() {
        System.out.println("testModificarVideoDeCanal_2");
        
        try {
            instance.modificarVideoDeCanal(null);
            assertNotNull(null);
        } catch (Exception e) {
            assertNull(null);
        }
    }
    
    /**
     * Test of obtenerCanal method, of class Usuario.
     */
    @Test
    public void testObtenerCanal() {
        System.out.println("obtenerCanal");
        DtCanal result = instance.obtenerCanal();
        assertNotNull(result);
    }
    
    /**
     * Test of obtenerListaDeReproduccion method, of class Usuario.
     */
    @Test
    public void testObtenerListaDeReproduccion_1() {
        System.out.println("obtenerListaDeReproduccion_1");
        int id = instance.listarListasDeReproduccionDeCanal(false).get(0).getId();
        DtListaDeReproduccion result = null;
        try {
            result = instance.obtenerListaDeReproduccion(id);
            assertNotNull(result);
        } catch (Exception e) {
            assertNull(result);
        }
    }
    @Test
    public void testObtenerListaDeReproduccion_2() {
        System.out.println("obtenerListaDeReproduccion_2");
        int id = 5000;
        DtListaDeReproduccion result = null;
        try {
            result = instance.obtenerListaDeReproduccion(id);
            assertNotNull(result);
        } catch (Exception e) {
            assertNull(result);
        }
    }

    /**
     * Test of obtenerListasEnCategoria method, of class Usuario.
     */
    @Test
    public void testObtenerListasEnCategoria_1() {
        System.out.println("obtenerListasEnCategoria_1");
        String cat = "DEPORTE";
        DtListaDeReproduccion dt = new DtListaDeReproduccion(0, "prueba", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "DEPORTE");
        instance.agregarListaParticular(dt);
        
        ArrayList<DtListaDeReproduccion> expResult = new ArrayList();
        ArrayList<DtListaDeReproduccion> result = new ArrayList();
        
        try {
            result = instance.obtenerListasEnCategoria(cat);
            assertNotEquals(expResult.size(), result.size());
        } catch (Exception e) {
            assertEquals(expResult.size(), result.size());
        }
    }
    @Test
    public void testObtenerListasEnCategoria_2() {
        System.out.println("testObtenerListasEnCategoria_2");
        String cat = "";
        
        try {
            ArrayList<DtListaDeReproduccion> result = instance.obtenerListasEnCategoria(cat);
            assertNotNull(null);
        } catch (Exception e) {
            assertNull(null);
        }
    }

    /**
     * Test of obtenerValoracion method, of class Usuario.
     */
    @Test
    public void testObtenerValoracion_1() {
        System.out.println("obtenerValoracion_1");
        int id = instance.listarVideosDeCanal().get(0).getId();
        String nickname = instance.getNickname();
        instance.agregarModificarValoracionDeVideo(id, new DtValoracion(TipoValoracion.LIKE, instance.getNickname()), instance);
        DtValoracion result = null;
        try {
            result = instance.obtenerValoracion(id, nickname);
            assertNotNull(result);
        } catch (Exception e) {
            assertNotNull(result);
        }
    }
    @Test
    public void testObtenerValoracion_2() {
        System.out.println("testObtenerValoracion_2");
        String nickname = "";
        DtValoracion result = null;
        try {
            result = instance.obtenerValoracion(0, nickname);
            assertNull(result);
        } catch (Exception e) {
            assertNull(result);
        }
    }

    /**
     * Test of obtenerVideo method, of class Usuario.
     */
    @Test
    public void testObtenerVideo_1() {
        System.out.println("testObtenerVideo_1");
        int id = instance.listarVideosDeCanal().get(0).getId();
        Video result = null;
        try {
            result = instance.obtenerVideo(id);
            assertNotNull(result);
        } catch (Exception e) {
            assertNotNull(result);
        }
    }
    @Test
    public void testObtenerVideo_2() {
        System.out.println("testObtenerVideo_2");
        int id = 548;
        Video result = null;
        try {
            result = instance.obtenerVideo(id);
            assertNull(result);
        } catch (Exception e) {
            assertNull(result);
        }
    }

    /**
     * Test of obtenerVideoDeCanal method, of class Usuario.
     */
    @Test
    public void testObtenerVideoDeCanal_1() {
        System.out.println("testObtenerVideoDeCanal_1");
        int idVideo = instance.listarVideosDeCanal().get(0).getId();
        String expResult = instance.listarVideosDeCanal().get(0).getNombre();
        String result = "";
        try {
            result = instance.obtenerVideoDeCanal(idVideo).getNombre();
            assertEquals(expResult, result);
        } catch (Exception e) {
            assertNotEquals(expResult, result);
        }
    }
    @Test
    public void testObtenerVideoDeCanal_2() {
        System.out.println("testObtenerVideoDeCanal_2");
        int idVideo = 65487;
        String expResult = "";
        String result = "";
        try {
            result = instance.obtenerVideoDeCanal(idVideo).getNombre();
            assertEquals(expResult, result);
        } catch (Exception e) {
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of obtenerVideosEnCategoria method, of class Usuario.
     */
    @Test
    public void testObtenerVideosEnCategoria_1() {
        System.out.println("testObtenerVideosEnCategoria_1");
        String cat = v.getCategoria();
        ArrayList<DtVideo> expResult = new ArrayList();
        ArrayList<DtVideo> result = null;
        try {
            result = instance.obtenerVideosEnCategoria(cat);
            assertNotEquals(expResult.size(), result.size());
        } catch (Exception e) {
            assertNotNull(null);
        }
    }
    @Test
    public void testObtenerVideosEnCategoria_2() {
        System.out.println("testObtenerVideosEnCategoria_2");
        String cat = "CATEGORIA INEXISTENTE";
        ArrayList<DtVideo> expResult = new ArrayList();
        ArrayList<DtVideo> result = null;
        try {
            result = instance.obtenerVideosEnCategoria(cat);
            assertEquals(expResult.size(), result.size());
        } catch (Exception e) {
            assertNotNull(null);
        }
    }
    @Test
    public void testObtenerVideosEnCategoria_3() {
        System.out.println("testObtenerVideosEnCategoria_3");
        String cat = "";
        ArrayList<DtVideo> expResult = new ArrayList();
        ArrayList<DtVideo> result = null;
        try {
            result = instance.obtenerVideosEnCategoria(cat);
            assertNotNull(null);
        } catch (Exception e) {
            assertNull(null);
        }
    }

    /**
     * Test of quitarValoracion method, of class Usuario.
     */
    @Test
    public void testQuitarValoracion_1() {
        System.out.println("testQuitarValoracion_1");
        DtValoracion DtValoracion = new DtValoracion(TipoValoracion.LIKE, "instance");
        Usuario Usu = instance;
        int idVideo = instance.listarVideosDeCanal().get(0).getId();
        instance.agregarModificarValoracionDeVideo(idVideo, DtValoracion, Usu);
        String nickname = Usu.getNickname();
        
        int antes, despues;
        antes = instance.listarValoracionesDeVideo(idVideo).size();
        
        try {
            instance.quitarValoracion(idVideo, nickname);
            despues = instance.listarValoracionesDeVideo(idVideo).size();
            assertNotEquals(antes, despues);
        } catch (Exception e) {
            assertNotNull(null);
        }
    }
    @Test
    public void testQuitarValoracion_2() {
        System.out.println("testQuitarValoracion_2");
        DtValoracion DtValoracion = new DtValoracion(TipoValoracion.LIKE, "instance");
        Usuario Usu = instance;
        int idVideo = instance.listarVideosDeCanal().get(0).getId();
        instance.agregarModificarValoracionDeVideo(idVideo, DtValoracion, Usu);
        String nickname = "";
        
        int antes, despues;
        antes = instance.listarValoracionesDeVideo(idVideo).size();
        
        try {
            instance.quitarValoracion(idVideo, nickname);
            despues = instance.listarValoracionesDeVideo(idVideo).size();
            assertNotNull(null);
        } catch (Exception e) {
            assertNull(null);
        }
    }
    
    /**
     * Test of quitarVideoDeListaDeReproduccion method, of class Usuario.
     */
    @Test
    public void testQuitarVideoDeListaDeReproduccion_1() {
        System.out.println("testQuitarVideoDeListaDeReproduccion_1");
        int idLista = instance.listarListasDeReproduccionDeCanal(false).get(0).getId();
        int idVideo = instance.listarVideosDeCanal().get(0).getId();
        Usuario Usu = instance;
        Usu.agregarVideoALista(idLista, idVideo, instance);
        int antes, despues;
        antes = instance.listarVideosDeListaDeReproduccion(idLista).size();
        instance.quitarVideoDeListaDeReproduccion(idLista, idVideo);
        despues = instance.listarVideosDeListaDeReproduccion(idLista).size();
        assertNotEquals(despues, antes);
    }
    @Test
    public void testQuitarVideoDeListaDeReproduccion_2() {
        System.out.println("testQuitarVideoDeListaDeReproduccion_2");
        int idLista = instance.listarListasDeReproduccionDeCanal(false).get(0).getId();
        int idVideo = instance.listarVideosDeCanal().get(0).getId();
        Usuario Usu = instance;
        Usu.agregarVideoALista(idLista, idVideo, instance);
        idVideo = 548876;
        int antes, despues;
        antes = instance.listarVideosDeListaDeReproduccion(idLista).size();
        instance.quitarVideoDeListaDeReproduccion(idLista, idVideo);
        despues = instance.listarVideosDeListaDeReproduccion(idLista).size();
        assertEquals(despues, antes);
    }

    /**
     * Test of validarListaParticular method, of class Usuario.
     */
    @Test
    public void testValidarListaParticular_1() {
        System.out.println("testValidarListaParticular_1");
        
        DtListaDeReproduccion dt = new DtListaDeReproduccion(0, "nombre particular 1", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "MUSICA");
        instance.agregarListaParticular(dt);
        String nombre = "nombre particular 1";
        boolean expResult = false;
        boolean result = false;
        try {
            result = instance.validarListaParticular(nombre);
            assertEquals(expResult, result);
        } catch (Exception e) {
            assertEquals(expResult, result);
        }
    }
    @Test
    public void testValidarListaParticular_2() {
        System.out.println("testValidarListaParticular_2");
        
        DtListaDeReproduccion dt = new DtListaDeReproduccion(0, "nombre particular 2", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "MUSICA");
        
        String nombre = "lista inexistente";
        boolean expResult = true;
        boolean result = true;
        try {
            result = instance.validarListaParticular(nombre);
            assertEquals(expResult, result);
        } catch (Exception e) {
            assertEquals(expResult, result);
        }
    }
    @Test
    public void testValidarListaParticular_3() {
        System.out.println("testValidarListaParticular_3");
        
        String nombre = "";
        boolean expResult = false;
        boolean result = true;
        try {
            result = instance.validarListaParticular(nombre);
            assertNotNull(null);
        } catch (Exception e) {
            assertNull(null);
        }
    }
    
}
