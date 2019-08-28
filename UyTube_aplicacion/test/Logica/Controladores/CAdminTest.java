/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Controladores;

import Logica.Clases.ListaDeReproduccion;
import Logica.Clases.Usuario;
import Logica.DataType.*;
import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoListaDeReproduccion;
import Logica.Enumerados.TipoValoracion;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.management.RuntimeErrorException;
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
public class CAdminTest {
    private static boolean sistemaInicializado = false;
    private IAdmin instance = null;

    public CAdminTest() {
        Fabrica f = Fabrica.getInstancia();
        instance = f.getIAdmin();
        
        if (sistemaInicializado){
            return;
        }
        
        System.out.println("Agregando usuarios");
        instance.altaUsuarioCanal(
                new DtUsuario("usu1", "contrasenia1", "nombre1", "apellido1", "correo1", new Date(86, 5, 18), "imagen1", 0),
                new DtCanal(0, "canal1", "descripcion1", Privacidad.PUBLICO)
        );
        instance.altaUsuarioCanal(
                new DtUsuario("usu2", "contrasenia2", "nombre2", "apellido2", "correo2", new Date(95, 9, 23), "imagen2", 0),
                new DtCanal(0, "canal2", "descripcion2", Privacidad.PUBLICO)
        );
        instance.altaUsuarioCanal(
                new DtUsuario("usu3", "contrasenia3", "nombre3", "apellido3", "correo3", new Date(95, 10, 3), "imagen3", 0),
                new DtCanal(0, "canal3", "descripcion3", Privacidad.PUBLICO)
        );

        System.out.println("Agregando categoria y lista por defecto");
        instance.altaCategoria("UNDEFINED");
        instance.altaListaDeReproduccionPorDefecto(
                new DtListaDeReproduccion(0, "Favoritos", Privacidad.PRIVADO, TipoListaDeReproduccion.POR_DEFECTO, "UNDEFINED")
        );

        System.out.println("Agregando a usu1 3 videos y una lista");
        instance.seleccionarUsuario("usu1");
        instance.altaVideo(
                new DtVideo(0, "video1", "descripcion", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        instance.altaVideo(
                new DtVideo(0, "video2", "descripcion", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        instance.altaVideo(
                new DtVideo(0, "video3", "descripcion", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        instance.altaListaDeReproduccionParticular(
                new DtListaDeReproduccion(0, "mi lista", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED")
        );

        System.out.println("Agregando a usu2 3 videos y una lista");
        instance.seleccionarUsuario("usu2");
        instance.altaVideo(
                new DtVideo(0, "video1", "descripcion", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        instance.altaVideo(
                new DtVideo(0, "video2", "descripcion", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        instance.altaVideo(
                new DtVideo(0, "video3", "descripcion", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        instance.altaListaDeReproduccionParticular(
                new DtListaDeReproduccion(0, "mi lista", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED")
        );

        System.out.println("Agregando a usu3 3 videos y una lista");
        instance.seleccionarUsuario("usu3");
        instance.altaVideo(
                new DtVideo(0, "video1", "descripcion", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        instance.altaVideo(
                new DtVideo(0, "video2", "descripcion", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        instance.altaVideo(
                new DtVideo(0, "video3", "descripcion", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        instance.altaListaDeReproduccionParticular(
                new DtListaDeReproduccion(0, "mi lista", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED")
        );

        System.out.println("--- Carga de datos de prueba finalizada ---");
        sistemaInicializado = true;
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance.liberarMemoriaListaDeReproduccion();
        instance.liberarMemoriaUsuario();
        instance.liberarMemoriaUsuarioActual();
        instance.liberarMemoriaVideo();
    }

    @After
    public void tearDown() {
        instance.liberarMemoriaListaDeReproduccion();
        instance.liberarMemoriaUsuario();
        instance.liberarMemoriaUsuarioActual();
        instance.liberarMemoriaVideo();
    }

    /**
     * Test of getInstancia method, of class CAdmin.
     */
    @Test
    public void testGetInstancia_1() {
        System.out.println("getInstancia");
        CAdmin result = null;
        try {
            result = CAdmin.getInstancia();
            assertNotNull(result);
        } catch (Exception e) {
            assertNull(null);
        }
    }
    @Test
    public void testGetInstancia_2() {
        System.out.println("getInstancia");
        CAdmin expResult = CAdmin.getInstancia();
        CAdmin result = null;
        try {
            result = CAdmin.getInstancia();
            assertSame(expResult, result);
        } catch (Exception e) {
            assertNull(null);
        }
    }

    /**
     * Test of agregarVideoAListaDeReproduccion method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_AgregarVideoAListaDeReproduccion() {
        System.out.println("agregarVideoAListaDeReproduccion");
        // el sistema no tiene ningun usuario seleccionado, 
        // osea, apunta a null
        // entonces debe saltar una excepcion
        instance.agregarVideoAListaDeReproduccion();
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_AgregarVideoAListaDeReproduccion() {
        System.out.println("agregarVideoAListaDeReproduccion");
        instance.seleccionarUsuario("usu1");
        instance.agregarVideoAListaDeReproduccion();
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_3_AgregarVideoAListaDeReproduccion() {
        System.out.println("agregarVideoAListaDeReproduccion");
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu2");
        instance.agregarVideoAListaDeReproduccion();
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_4_AgregarVideoAListaDeReproduccion() {
        System.out.println("agregarVideoAListaDeReproduccion");
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu2");
        instance.seleccionarVideo(1);
        instance.agregarVideoAListaDeReproduccion();
    }
    @Test
    public void test_AgregarVideoAListaDeReproduccion() {
        System.out.println("agregarVideoAListaDeReproduccion");
        
        instance.seleccionarUsuario("usu2");
        instance.seleccionarListaDeReproduccion(5);
        int antes = instance.listarVideosDeListaDeReproduccion().size();
        
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu2");
        instance.seleccionarVideo(1);
        
        instance.agregarVideoAListaDeReproduccion();
        
        instance.seleccionarUsuario("usu2");
        int despues = instance.listarVideosDeListaDeReproduccion().size();
        
        assertNotEquals(antes, despues);
    }
    
    
    /**
     * Test of altaCategoria method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_AltaCategoria() {
        System.out.println("altaCategoria");
        String categoria = "";
        instance.altaCategoria(categoria);

    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_AltaCategoria() {
        System.out.println("altaCategoria");
        String categoria = "UNDEFINED";
        instance.altaCategoria(categoria);
    }
    @Test
    public void test_AltaCategoria() {
        System.out.println("altaCategoria");
        String categoria = "MUSICA";
        instance.altaCategoria(categoria);
        assertNull(null);
    }

    /**
     * Test of altaComentario method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_AltaComentario_DtComentario() {
        System.out.println("altaComentario");
        DtComentario dtCom = null;
        instance.altaComentario(dtCom);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_AltaComentario_DtComentario() {
        System.out.println("altaComentario");
        DtComentario dtCom = null;
        instance.seleccionarUsuario("usu1");
        instance.altaComentario(dtCom);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_3_AltaComentario_DtComentario() {
        System.out.println("altaComentario");
        DtComentario dtCom = null;
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu2");
        instance.altaComentario(dtCom);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_4_AltaComentario_DtComentario() {
        System.out.println("altaComentario");
        DtComentario dtCom = new DtComentario(0, "esto no deberia aparecer", new Date(119, 8, 24), "texto del comentario", 0);
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu2");
        instance.altaComentario(dtCom);
    }
    @Test
    public void test_AltaComentario_DtComentario() {
        System.out.println("altaComentario");
        DtComentario dtCom = new DtComentario(0, "esto no deberia aparecer", new Date(119, 8, 24), "texto del comentario", 0);
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu2");
        instance.seleccionarVideo(1);
        instance.altaComentario(dtCom);
        ArrayList<DtComentario> result = instance.listarComentariosDeVideo();
        for (int i = 0; i < result.size(); i++){
            if (result.get(i).getTexto().equals("texto del comentario")){
                assertTrue(true);
                return;
            }
        }
        assertTrue(false);
    }

    /**
     * Test of altaComentario method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_AltaComentario_DtComentario_int() {
        System.out.println("altaComentario");
        DtComentario dtCom = null;
        instance.altaComentario(dtCom, 0);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_AltaComentario_DtComentario_int() {
        System.out.println("altaComentario");
        DtComentario dtCom = null;
        instance.seleccionarUsuario("usu1");
        instance.altaComentario(dtCom, 0);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_3_AltaComentario_DtComentario_int() {
        System.out.println("altaComentario");
        DtComentario dtCom = null;
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu2");
        instance.altaComentario(dtCom, 0);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_4_AltaComentario_DtComentario_int() {
        System.out.println("altaComentario");
        DtComentario dtCom = new DtComentario(0, "esto no deberia aparecer", new Date(119, 8, 24), "texto del comentario", 0);
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu2");
        instance.altaComentario(dtCom, 0);
    }
    @Test
    public void test_AltaComentario_DtComentario_int() {
        System.out.println("altaComentario");
        DtComentario dtCom = new DtComentario(0, "esto no deberia aparecer", new Date(119, 8, 24), "texto del comentario", 0);
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu2");
        instance.seleccionarVideo(1);
        instance.altaComentario(dtCom, 0);
        ArrayList<DtComentario> result = instance.listarComentariosDeVideo();
        for (int i = 0; i < result.size(); i++){
            if (result.get(i).getTexto().equals("texto del comentario")){
                assertTrue(false);
                return;
            }
        }
        assertTrue(true);
    }
    
    /**
     * Test of altaListaDeReproduccionParticular method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_AltaListaDeReproduccionParticular() {
        System.out.println("altaListaDeReproduccionParticular");
        DtListaDeReproduccion lista = null;
        instance.altaListaDeReproduccionParticular(lista);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_AltaListaDeReproduccionParticular() {
        System.out.println("altaListaDeReproduccionParticular");
        DtListaDeReproduccion lista = null;
        instance.seleccionarUsuario("usu1");
        instance.altaListaDeReproduccionParticular(lista);
    }
    @Test
    public void test_AltaListaDeReproduccionParticular() {
        System.out.println("altaListaDeReproduccionParticular");
        DtListaDeReproduccion lista = new DtListaDeReproduccion(0, "Videos de maincraf", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED");
        instance.seleccionarUsuario("usu1");
        instance.altaListaDeReproduccionParticular(lista);
    }
    
    /**
     * Test of altaListaDeReproduccionPorDefecto method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_AltaListaDeReproduccionPorDefecto() {
        System.out.println("altaListaDeReproduccionPorDefecto");
        DtListaDeReproduccion lista = null;
        instance.altaListaDeReproduccionPorDefecto(lista);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_AltaListaDeReproduccionPorDefecto() {
        System.out.println("altaListaDeReproduccionPorDefecto");
        DtListaDeReproduccion lista = new DtListaDeReproduccion(0, "", Privacidad.PRIVADO, TipoListaDeReproduccion.POR_DEFECTO, "UNDEFINED");
        instance.altaListaDeReproduccionPorDefecto(lista);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_3_AltaListaDeReproduccionPorDefecto() {
        System.out.println("altaListaDeReproduccionPorDefecto");
        DtListaDeReproduccion lista = new DtListaDeReproduccion(0, "Ver mas tarde", Privacidad.PRIVADO, TipoListaDeReproduccion.POR_DEFECTO, "UNDEFINED");
        instance.altaListaDeReproduccionPorDefecto(lista);
    }
    @Test
    public void test_AltaListaDeReproduccionPorDefecto() {
        System.out.println("altaListaDeReproduccionPorDefecto");
        DtListaDeReproduccion lista = new DtListaDeReproduccion(0, "Tutoriales", Privacidad.PRIVADO, TipoListaDeReproduccion.POR_DEFECTO, "UNDEFINED");
        instance.altaListaDeReproduccionPorDefecto(lista);
        
        boolean agregadoAClase = ListaDeReproduccion.listarNombresDeListasPorDefecto().contains("Tutoriales");
        instance.seleccionarUsuario("usu3");
        ArrayList<DtListaDeReproduccion> lsts = instance.listarListasDeReproduccionDeUsuario("usu3");
        boolean agregadoACanal = false;
        for (int i = 0; i < lsts.size(); i++){
            if (lsts.get(i).getNombre().equals(lista.getNombre())){
                agregadoACanal = true;
                break;
            }
        }
        assertTrue(agregadoAClase && agregadoACanal);
    }
    
    
    
    /**
     * Test of altaUsuarioCanal method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_AltaUsuarioCanal() {
        System.out.println("altaUsuarioCanal");
        DtUsuario usr = null;
        DtCanal canal = null;
        instance.altaUsuarioCanal(usr, canal);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_AltaUsuarioCanal() {
        System.out.println("altaUsuarioCanal");
        DtUsuario usr = new DtUsuario("usu4", "contrasenia2", "nombre2", "apellido2", "correo2", new Date(95, 9, 23), "imagen2", 0);
        DtCanal canal = null;
        instance.altaUsuarioCanal(usr, canal);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_3_AltaUsuarioCanal() {
        System.out.println("altaUsuarioCanal");
        DtUsuario usr = new DtUsuario("", "contrasenia2", "nombre2", "apellido2", "correo2", new Date(95, 9, 23), "imagen2", 0);
        DtCanal canal = new DtCanal(0, "canal2", "descripcion2", Privacidad.PUBLICO);
        instance.altaUsuarioCanal(usr, canal);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_4_AltaUsuarioCanal() {
        System.out.println("altaUsuarioCanal");
        DtUsuario usr = new DtUsuario("usu4", "contrasenia2", "nombre2", "apellido2", "correo2", new Date(95, 9, 23), "imagen2", 0);
        DtCanal canal = new DtCanal(0, "canal2", "descripcion2", Privacidad.PUBLICO);
        instance.altaUsuarioCanal(usr, canal);
    }
    
    @Test
    public void testThrow_5_AltaUsuarioCanal() {
        System.out.println("altaUsuarioCanal");
        DtUsuario usr = new DtUsuario("usu4", "contrasenia4", "nombre4", "apellido4", "correo4", new Date(95, 9, 23), "imagen4", 0);
        DtCanal canal = new DtCanal(0, "canal4", "descripcion4", Privacidad.PRIVADO);
        instance.altaUsuarioCanal(usr, canal);
    }

    
    /**
     * Test of altaValoracion method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_AltaValoracion() {
        System.out.println("altaValoracion");
        DtValoracion val = null;
        instance.altaValoracion(val);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_AltaValoracion() {
        System.out.println("altaValoracion");
        DtValoracion val = null;
        instance.seleccionarUsuario("usu1");
        instance.altaValoracion(val);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_3_AltaValoracion() {
        System.out.println("altaValoracion");
        DtValoracion val = null;
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu2");
        instance.altaValoracion(val);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_4_AltaValoracion() {
        System.out.println("altaValoracion");
        DtValoracion val = new DtValoracion(TipoValoracion.LIKE, "");
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu2");
        instance.altaValoracion(val);
    }
    @Test
    public void test_AltaValoracion() {
        System.out.println("altaValoracion");
        DtValoracion val = new DtValoracion(TipoValoracion.LIKE, "");
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu2");
        instance.seleccionarVideo(1);
        instance.altaValoracion(val);
    }
    
    /**
     * Test of altaVideo method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_AltaVideo() {
        System.out.println("altaVideo");
        DtVideo video = null;
        instance.altaVideo(video);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_AltaVideo() {
        System.out.println("altaVideo");
        DtVideo video = null;
        instance.seleccionarUsuario("usu1");
        instance.altaVideo(video);
    }
    @Test
    public void test_AltaVideo() {
        System.out.println("altaVideo");
        DtVideo video = new DtVideo(0, "video4", "descripcio4", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "UNDEFINED", 0, 0);
        instance.seleccionarUsuario("usu1");
        int antes = instance.listarVideosDeUsuario().size();
        instance.altaVideo(video);
        int despues = instance.listarVideosDeUsuario().size();
        assertNotEquals(antes, despues);
    }
    
    
    /**
     * Test of existeCategoria method, of class CAdmin.
     */
    @Test
    public void test_1_ExisteCategoria() {
        System.out.println("existeCategoria");
        String cat = "DEPORTES";
        boolean expResult = false;
        boolean result = instance.existeCategoria(cat);
        assertEquals(expResult, result);
    }
    @Test
    public void test_2_ExisteCategoria() {
        System.out.println("existeCategoria");
        String cat = "UNDEFINED";
        boolean expResult = true;
        boolean result = instance.existeCategoria(cat);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of existeEmail method, of class CAdmin.
     */
    @Test
    public void test_1_ExisteEmail() {
        System.out.println("existeEmail");
        String email = "correo1111";
        boolean expResult = false;
        boolean result = instance.existeEmail(email);
        assertEquals(expResult, result);
    }
    @Test
    public void test_2_ExisteEmail() {
        System.out.println("existeEmail");
        String email = "correo2";
        boolean expResult = true;
        boolean result = instance.existeEmail(email);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of existeNickname method, of class CAdmin.
     */
    @Test
    public void test_1_ExisteNickname() {
        System.out.println("existeNickname");
        String nickname = "usu0";
        boolean expResult = false;
        boolean result = instance.existeNickname(nickname);
        assertEquals(expResult, result);
    }
    @Test
    public void test_2_ExisteNickname() {
        System.out.println("existeNickname");
        String nickname = "usu3";
        boolean expResult = true;
        boolean result = instance.existeNickname(nickname);
        assertEquals(expResult, result);
    }

    /**
     * Test of iniciarSesionAdministrador method, of class CAdmin.
     */
    @Test
    public void test_1_IniciarSesionAdministrador() {
        System.out.println("iniciarSesionAdministrador");
        int id = 5;
        String pass = "passwd";
        boolean expResult = false;
        boolean result = instance.iniciarSesionAdministrador(id, pass);
        assertEquals(expResult, result);
    }
    @Test
    public void test_2_IniciarSesionAdministrador() {
        System.out.println("iniciarSesionAdministrador");
        int id = 0;
        String pass = "passwd";
        boolean expResult = false;
        boolean result = instance.iniciarSesionAdministrador(id, pass);
        assertEquals(expResult, result);
    }
    @Test
    public void test_3_IniciarSesionAdministrador() {
        System.out.println("iniciarSesionAdministrador");
        int id = 0;
        String pass = "admin";
        boolean expResult = true;
        boolean result = instance.iniciarSesionAdministrador(id, pass);
        assertEquals(expResult, result);
    }

    /**
     * Test of iniciarSesionUsuario method, of class CAdmin.
     */
    @Test
    public void test_1_IniciarSesionUsuario() {
        System.out.println("iniciarSesionUsuario");
        String nickname = "usu777";
        String pass = "usu777";
        CAdmin ins = CAdmin.getInstancia();
        boolean expResult = false;
        boolean result = ins.iniciarSesionUsuario(nickname, pass);
        assertEquals(expResult, result);
    }
    @Test
    public void test_2_IniciarSesionUsuario() {
        System.out.println("iniciarSesionUsuario");
        String nickname = "usu3";
        String pass = "usu777";
        CAdmin ins = CAdmin.getInstancia();
        boolean expResult = false;
        boolean result = ins.iniciarSesionUsuario(nickname, pass);
        assertEquals(expResult, result);
    }
    @Test
    public void test_3_IniciarSesionUsuario() {
        System.out.println("iniciarSesionUsuario");
        String nickname = "usu3";
        String pass = "contrasenia3";
        CAdmin ins = CAdmin.getInstancia();
        boolean expResult = true;
        boolean result = ins.iniciarSesionUsuario(nickname, pass);
        assertEquals(expResult, result);
    }

    /**
     * Test of liberarMemoriaListaDeReproduccion method, of class CAdmin.
     */
    @Test
    public void testThrow_1_LiberarMemoriaListaDeReproduccion() {
        System.out.println("liberarMemoriaListaDeReproduccion");
        instance.liberarMemoriaListaDeReproduccion();
    }

    /**
     * Test of liberarMemoriaUsuario method, of class CAdmin.
     */
    @Test
    public void testThrow_1_LiberarMemoriaUsuario() {
        System.out.println("liberarMemoriaUsuario");
        instance.liberarMemoriaUsuario();
    }

    /**
     * Test of liberarMemoriaUsuarioActual method, of class CAdmin.
     */
    @Test
    public void testThrow_1_LiberarMemoriaUsuarioActual() {
        System.out.println("liberarMemoriaUsuarioActual");
        instance.liberarMemoriaUsuarioActual();
    }

    /**
     * Test of liberarMemoriaVideo method, of class CAdmin.
     */
    @Test
    public void testThrow_1_LiberarMemoriaVideo() {
        System.out.println("liberarMemoriaVideo");
        instance.liberarMemoriaVideo();
    }
    
    /**
     * Test of listarCategorias method, of class CAdmin.
     */
    @Test
    public void testThrow_1_ListarCategorias() {
        System.out.println("listarCategorias");
        ArrayList<String> result = instance.listarCategorias();
        assertTrue(result.size() > 0 && result.contains("UNDEFINED"));
    }

    /**
     * Test of listarComentariosDeVideo method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ListarComentariosDeVideo() {
        System.out.println("listarComentariosDeVideo");
        ArrayList<DtComentario> expResult = null;
        ArrayList<DtComentario> result = instance.listarComentariosDeVideo();
    }
    @Test(expected = RuntimeException.class)
    public void testThrow__ListarComentariosDeVideo() {
        System.out.println("listarComentariosDeVideo");
        ArrayList<DtComentario> expResult = null;
        instance.seleccionarUsuario("usu1");
        ArrayList<DtComentario> result = instance.listarComentariosDeVideo();
    }
    @Test
    public void test_ListarComentariosDeVideo() {
        System.out.println("listarComentariosDeVideo");
        
        DtComentario dtCom = new DtComentario(0, "esto no deberia aparecer", new Date(119, 8, 24), "test_ListarComentariosDeVideo", 0);
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu2");
        instance.seleccionarVideo(1);
        instance.altaComentario(dtCom);
        
        ArrayList<DtComentario> result = instance.listarComentariosDeVideo();
        for (int i = 0; i < result.size(); i++){
            if (result.get(i).getTexto().equals(dtCom.getTexto())){
                assertTrue(true);
                return;
            }
        }
        assertTrue(false);
    }

    /**
     * Test of listarListasDeReproduccionEnCategoria method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ListarListasDeReproduccionEnCategoria() {
        System.out.println("listarListasDeReproduccionEnCategoria");
        String cat = "";
        ArrayList<DtListaDeReproduccion> expResult = null;
        ArrayList<DtListaDeReproduccion> result = instance.listarListasDeReproduccionEnCategoria(cat);
        assertEquals(expResult, result);
    }
    @Test
    public void test_1_ListarListasDeReproduccionEnCategoria() {
        System.out.println("listarListasDeReproduccionEnCategoria");
        String cat = "UNDEFINED";
        ArrayList<DtListaDeReproduccion> result = instance.listarListasDeReproduccionEnCategoria(cat);
        
        for (int i = 0; i < result.size(); i++) {
            if ("UNDEFINED" != result.get(i).getCategoria()) {
                assertTrue(true);
                assertTrue(false);
                return;
            }
        }
        assertTrue(true);
    }
    @Test
    public void test_2_ListarListasDeReproduccionEnCategoria() {
        System.out.println("listarListasDeReproduccionEnCategoria");
        String cat = "ASTRONOMIA";
        ArrayList<DtListaDeReproduccion> result = instance.listarListasDeReproduccionEnCategoria(cat);
        assertEquals(0, result.size());
    }

    
    /**
     * Test of listarListasDeReproduccionDeUsuario method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ListarListasDeReproduccionDeUsuario() {
        System.out.println("listarListasDeReproduccionDeUsuario");
        String nickname = "";
        ArrayList<DtListaDeReproduccion> result = instance.listarListasDeReproduccionDeUsuario(nickname);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_ListarListasDeReproduccionDeUsuario() {
        System.out.println("listarListasDeReproduccionDeUsuario");
        String nickname = "nickname";
        ArrayList<DtListaDeReproduccion> result = instance.listarListasDeReproduccionDeUsuario(nickname);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_3_ListarListasDeReproduccionDeUsuario() {
        System.out.println("listarListasDeReproduccionDeUsuario");
        String nickname = "nickname";
        instance.seleccionarUsuario("usu1");
        ArrayList<DtListaDeReproduccion> result = instance.listarListasDeReproduccionDeUsuario(nickname);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_4_ListarListasDeReproduccionDeUsuario() {
        System.out.println("listarListasDeReproduccionDeUsuario");
        String nickname = "nickname";
        instance.seleccionarUsuarioActual("usu2");
        ArrayList<DtListaDeReproduccion> result = instance.listarListasDeReproduccionDeUsuario(nickname);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_5_ListarListasDeReproduccionDeUsuario() {
        System.out.println("listarListasDeReproduccionDeUsuario");
        String nickname = "nickname";
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu2");
        ArrayList<DtListaDeReproduccion> result = instance.listarListasDeReproduccionDeUsuario(nickname);
    }
    @Test
    public void testThrow_7_ListarListasDeReproduccionDeUsuario() {
        System.out.println("listarListasDeReproduccionDeUsuario");
        String nickname = "usu2";
        instance.seleccionarUsuario("usu2");
        ArrayList<DtListaDeReproduccion> result = instance.listarListasDeReproduccionDeUsuario(nickname);
        assertTrue(result.get(0).getId() == 2);
    }
    @Test
    public void testThrow_9_ListarListasDeReproduccionDeUsuario() {
        System.out.println("listarListasDeReproduccionDeUsuario");
        String nickname = "usu2";
        instance.seleccionarUsuarioActual("usu2");
        ArrayList<DtListaDeReproduccion> result = instance.listarListasDeReproduccionDeUsuario(nickname);
        assertTrue(result.get(0).getId() == 2);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
