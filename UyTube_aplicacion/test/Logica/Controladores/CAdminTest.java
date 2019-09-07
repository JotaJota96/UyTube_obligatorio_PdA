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
        instance.altaCategoria("ARTE");
        instance.altaListaDeReproduccionPorDefecto(
                new DtListaDeReproduccion(0, "Favoritos", Privacidad.PRIVADO, TipoListaDeReproduccion.POR_DEFECTO, "UNDEFINED")
        );

        System.out.println("Agregando a usu1 3 videos y una lista");
        instance.seleccionarUsuario("usu1");
        instance.altaVideo(
                new DtVideo(0, "video1", "descripcion", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        instance.altaVideo(
                new DtVideo(0, "video2", "descripcion", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "ARTE", 0, 0)
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
                new DtVideo(0, "video2", "descripcion", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "ARTE", 0, 0)
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
                new DtVideo(0, "video1", "descripcion", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "ARTE", 0, 0)
        );
        instance.altaVideo(
                new DtVideo(0, "video2", "descripcion", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        instance.altaVideo(
                new DtVideo(0, "video3", "descripcion", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "ARTE", 0, 0)
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
        instance.agregarVideoAListaDeReproduccion(0);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_AgregarVideoAListaDeReproduccion() {
        System.out.println("agregarVideoAListaDeReproduccion");
        instance.seleccionarUsuario("usu1");
        instance.agregarVideoAListaDeReproduccion(0);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_3_AgregarVideoAListaDeReproduccion() {
        System.out.println("agregarVideoAListaDeReproduccion");
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu2");
        instance.agregarVideoAListaDeReproduccion(0);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_4_AgregarVideoAListaDeReproduccion() {
        System.out.println("agregarVideoAListaDeReproduccion");
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu2");
        instance.seleccionarVideo(1);
        instance.agregarVideoAListaDeReproduccion(0);
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
        
        instance.agregarVideoAListaDeReproduccion(5);
        
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
    @Test(expected = RuntimeException.class)
    public void testThrow_3_AltaListaDeReproduccionParticular() {
        System.out.println("altaListaDeReproduccionParticular");
        DtListaDeReproduccion lista = new DtListaDeReproduccion(0, "Videos de maincraf", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "deporte");
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
    @Test(expected = RuntimeException.class)
    public void testThrow_3_AltaVideo() {
        System.out.println("altaVideo");
        DtVideo video = new DtVideo(0, "video4", "descripcio4", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "DEPORTE", 0, 0);
        instance.seleccionarUsuario("usu1");
        int antes = instance.listarVideosDeUsuario().size();
        instance.altaVideo(video);
        int despues = instance.listarVideosDeUsuario().size();
        assertNotEquals(antes, despues);
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
        assertTrue(result.size() == 3);
    }
    
    
    /**
     * Test of listarListasDeReproduccionParticularesDeUsuario method, of class
     * CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ListarListasDeReproduccionParticularesDeUsuario() {
        System.out.println("listarListasDeReproduccionParticularesDeUsuario");
        ArrayList<DtListaDeReproduccion> result = instance.listarListasDeReproduccionParticularesDeUsuario();
    }
    @Test
    public void test_ListarListasDeReproduccionParticularesDeUsuario() {
        System.out.println("listarListasDeReproduccionParticularesDeUsuario");
        instance.seleccionarUsuario("usu3");
        ArrayList<DtListaDeReproduccion> result = instance.listarListasDeReproduccionParticularesDeUsuario();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getTipo() != TipoListaDeReproduccion.PARTICULAR) {
                assertTrue(false);
                return;
            }
        }
        assertTrue(true);
    }

    /**
     * Test of listarUsuarioSeguidores method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ListarUsuarioSeguidores() {
        System.out.println("listarUsuarioSeguidores");
        ArrayList<DtUsuario> result = instance.listarUsuarioSeguidores();
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_ListarUsuarioSeguidores() {
        System.out.println("listarUsuarioSeguidores");
        instance.seleccionarUsuarioActual("usu1");
        ArrayList<DtUsuario> result = instance.listarUsuarioSeguidores();
    }
    @Test
    public void test_ListarUsuarioSeguidores() {
        System.out.println("listarUsuarioSeguidores");
        // usuarios 1 y 2 siguen al 3
        instance.seleccionarUsuario("usu3");
        instance.seleccionarUsuarioActual("usu1");
        instance.seguirUsuario();
        instance.seleccionarUsuarioActual("usu2");
        instance.seguirUsuario();
        
        instance.seleccionarUsuario("usu3");
        ArrayList<DtUsuario> result = instance.listarUsuarioSeguidores();
        
        // deshago que usuarios 1 y 2 siguen al 3
        instance.seleccionarUsuario("usu3");
        instance.seleccionarUsuarioActual("usu1");
        instance.seguirUsuario();
        instance.seleccionarUsuarioActual("usu2");
        instance.seguirUsuario();
        
        for (int i = 0; i < result.size(); i++){
            if (result.get(i).getNickname() != "usu1" && result.get(i).getNickname() != "usu2") {
                assertTrue(false);
                return;
            }
        }
        assertTrue(true);
    }
    
    
    
    /**
     * Test of listarUsuarioNoSeguidos method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ListarUsuarioNoSeguidos() {
        System.out.println("listarUsuarioSeguidos");
        ArrayList<DtUsuario> result = instance.listarUsuarioNoSeguidos();
    }
    @Test
    public void test_ListarUsuarioNoSeguidos() {
        System.out.println("listarUsuarioSeguidos");
        
        instance.seleccionarUsuario("usu3");
        ArrayList<DtUsuario> seguidos = instance.listarUsuarioSeguidos();
        instance.seleccionarUsuarioActual("usu3");
        for (DtUsuario u : seguidos){
            instance.seleccionarUsuario(u.getNickname());
            instance.seguirUsuario();
        }
        
        // usuarios 3 sige a 1
        instance.seleccionarUsuarioActual("usu3");
        instance.seleccionarUsuario("usu1");
        instance.seguirUsuario();
        
        instance.seleccionarUsuario("usu3");
        ArrayList<DtUsuario> result = instance.listarUsuarioNoSeguidos();
        
        for (DtUsuario u : result){
            if (u.getNickname().equals("usu1") || u.getNickname().equals("usu3")){
                assertTrue(false);
            }
        }
        assertTrue(true);
    }
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Test of listarUsuarioSeguidos method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ListarUsuarioSeguidos() {
        System.out.println("listarUsuarioSeguidos");
        ArrayList<DtUsuario> result = instance.listarUsuarioSeguidos();
    }
    @Test
    public void test_ListarUsuarioSeguidos() {
        System.out.println("listarUsuarioSeguidos");
        
        // usuarios 3 sige a 1 y 2
        instance.seleccionarUsuarioActual("usu3");
        instance.seleccionarUsuario("usu1");
        instance.seguirUsuario();
        instance.seleccionarUsuario("usu2");
        instance.seguirUsuario();
        
        ArrayList<DtUsuario> result = instance.listarUsuarioSeguidos();
        
        // deshago que usuarios 3 sige a 1 y 2
        instance.seleccionarUsuario("usu1");
        instance.seguirUsuario();
        instance.seleccionarUsuario("usu2");
        instance.seguirUsuario();
        
        for (int i = 0; i < result.size(); i++){
            if (result.get(i).getNickname() != "usu1" || result.get(i).getNickname() != "usu2") {
                assertTrue(false);
                return;
            }
        }
        assertTrue(true);
        
    }
    
    
    /**
     * Test of listarUsuarios method, of class CAdmin.
     */
    @Test
    public void testThrow_1_ListarUsuarios() {
        System.out.println("listarUsuarios");
        ArrayList<DtUsuario> result = instance.listarUsuarios();
        assertTrue(result.size() == 3);
    }
    
    
    /**
     * Test of listarVideosEnCategoria method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ListarVideosEnCategoria() {
        System.out.println("listarVideosEnCategoria");
        String cat = "";
        ArrayList<DtVideo> result = instance.listarVideosEnCategoria(cat);
    }
    @Test
    public void testThrow_2_ListarVideosEnCategoria() {
        System.out.println("listarVideosEnCategoria");
        String cat = "DEPORTE";
        ArrayList<DtVideo> result = instance.listarVideosEnCategoria(cat);
        assertTrue(result.size() == 0);
    }
    @Test
    public void test_ListarVideosEnCategoria() {
        System.out.println("listarVideosEnCategoria");
        String cat = "ARTE";
        ArrayList<DtVideo> result = instance.listarVideosEnCategoria(cat);
        
        for (int i = 0; i < result.size(); i++){
            if (result.get(i).getCategoria() != "ARTE") {
                assertTrue(false);
                return;
            }
        }
        assertTrue(true);
    }

    
    /**
     * Test of listarVideosDeUsuario method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ListarVideosDeUsuario() {
        System.out.println("listarVideosDeUsuario");
        ArrayList<DtVideo> result = instance.listarVideosDeUsuario();
    }
    @Test
    public void test_ListarVideosDeUsuario() {
        System.out.println("listarVideosDeUsuario");
        instance.seleccionarUsuario("usu1");
        ArrayList<DtVideo> result = instance.listarVideosDeUsuario();
        assertTrue(result.size() == 3);
    }
    
    
    /**
     * Test of listarVideosDeListaDeReproduccion method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ListarVideosDeListaDeReproduccion() {
        System.out.println("listarVideosDeListaDeReproduccion");
        ArrayList<DtVideo> result = instance.listarVideosDeListaDeReproduccion();
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_ListarVideosDeListaDeReproduccion() {
        System.out.println("listarVideosDeListaDeReproduccion");
        instance.seleccionarUsuario("usu3");
        ArrayList<DtVideo> result = instance.listarVideosDeListaDeReproduccion();
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_3_ListarVideosDeListaDeReproduccion() {
        System.out.println("listarVideosDeListaDeReproduccion");
        instance.seleccionarUsuario("usu3");
        instance.seleccionarVideo(555);
        ArrayList<DtVideo> result = instance.listarVideosDeListaDeReproduccion();
    }
    @Test
    public void test_ListarVideosDeListaDeReproduccion() {
        System.out.println("listarVideosDeListaDeReproduccion");
        instance.seleccionarUsuario("usu3");
        instance.seleccionarListaDeReproduccion(9);
        ArrayList<DtVideo> result = instance.listarVideosDeListaDeReproduccion();
        assertTrue(result.size() == 0);
    }

    /**
     * Test of modificarListaDeReproduccion method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ModificarListaDeReproduccion() {
        System.out.println("modificarListaDeReproduccion");
        instance.modificarListaDeReproduccion(null);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_ModificarListaDeReproduccion() {
        System.out.println("modificarListaDeReproduccion");
        instance.seleccionarUsuario("usu1");
        instance.modificarListaDeReproduccion(null);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_3_ModificarListaDeReproduccion() {
        System.out.println("modificarListaDeReproduccion");
        instance.seleccionarUsuario("usu1");
        instance.seleccionarListaDeReproduccion(7);
        instance.modificarListaDeReproduccion(null);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_4_ModificarListaDeReproduccion() {
        System.out.println("modificarListaDeReproduccion");
        DtListaDeReproduccion dt = new DtListaDeReproduccion(0, "Favoritos", Privacidad.PUBLICO, TipoListaDeReproduccion.POR_DEFECTO, "DEPORTE");
        instance.seleccionarUsuario("usu1");
        instance.seleccionarListaDeReproduccion(7);
        instance.modificarListaDeReproduccion(dt);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_5_ModificarListaDeReproduccion() {
        System.out.println("modificarListaDeReproduccion");
        DtListaDeReproduccion dt = new DtListaDeReproduccion(0, "Favoritos", Privacidad.PUBLICO, TipoListaDeReproduccion.POR_DEFECTO, "UNDEFINED");
        instance.seleccionarUsuario("usu1");
        instance.seleccionarListaDeReproduccion(7);
        instance.modificarListaDeReproduccion(dt);
    }
    @Test
    public void test_ModificarListaDeReproduccion() {
        System.out.println("modificarListaDeReproduccion");
        DtListaDeReproduccion dt = new DtListaDeReproduccion(0, "Alfa-jores", Privacidad.PUBLICO, TipoListaDeReproduccion.POR_DEFECTO, "ARTE");
        instance.seleccionarUsuario("usu1");
        instance.seleccionarListaDeReproduccion(7);
        instance.modificarListaDeReproduccion(dt);
        assertTrue(instance.seleccionarListaDeReproduccion(7).getNombre() == "Alfa-jores");
        
    }

    /**
     * Test of modificarUsuarioYCanal method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ModificarUsuarioYCanal() {
        System.out.println("modificarUsuarioYCanal");
        DtUsuario usr = null;
        DtCanal canal = null;
        instance.modificarUsuarioYCanal(usr, canal);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_ModificarUsuarioYCanal() {
        System.out.println("modificarUsuarioYCanal");
        instance.seleccionarUsuario("usu1");
        DtUsuario usr = null;
        DtCanal canal = null;
        instance.modificarUsuarioYCanal(usr, canal);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_3_ModificarUsuarioYCanal() {
        System.out.println("modificarUsuarioYCanal");
        instance.seleccionarUsuario("usu1");
        DtUsuario usr = new DtUsuario("usuario1", "pass1", "nombre mod", "apellido mod", "correo mod", new Date(55, 11, 21), "imagen mod", 123456);
        DtCanal canal = null;
        instance.modificarUsuarioYCanal(usr, canal);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_4_ModificarUsuarioYCanal() {
        System.out.println("modificarUsuarioYCanal");
        instance.seleccionarUsuario("usu1");
        DtUsuario usr = new DtUsuario("usuario1", "pass1", "nombre mod", "apellido mod", "correo mod", new Date(55, 11, 21), "imagen mod", 123456);
        DtCanal canal = new DtCanal(0, "canal mod", "descripcion3 mod", Privacidad.PRIVADO);
        instance.modificarUsuarioYCanal(usr, canal);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_5_ModificarUsuarioYCanal() {
        System.out.println("modificarUsuarioYCanal");
        instance.seleccionarUsuario("usu1");
        DtUsuario usr = new DtUsuario("usu1", "pass1", "nombre mod", "apellido mod", "correo mod", new Date(55, 11, 21), "imagen mod", 123456);
        DtCanal canal = new DtCanal(0, "canal mod", "descripcion3 mod", Privacidad.PRIVADO);
        instance.modificarUsuarioYCanal(usr, canal);
    }
    @Test
    public void test_ModificarUsuarioYCanal() {
        System.out.println("modificarUsuarioYCanal");
        DtUsuario usuRef = instance.seleccionarUsuario("usu1");
        DtCanal canRef = instance.obtenerCanalDeUsuario();
        DtUsuario usr = new DtUsuario("usu1", "pass1", "nombre mod", "apellido mod", "correo1", new Date(55, 11, 21), "imagen mod", 123456);
        DtCanal canal = new DtCanal(0, "canal mod", "descripcion3 mod", Privacidad.PRIVADO);
        instance.modificarUsuarioYCanal(usr, canal);
        DtUsuario usuPost = instance.seleccionarUsuario("usu1");
        DtCanal canPost = instance.obtenerCanalDeUsuario();
        
        assertTrue(
                usuRef.toString() != usuPost.toString() &&
                canRef.toString() != canPost.toString()
        );
    }
    
    
    /**
     * Test of modificarVideo method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ModificarVideo() {
        System.out.println("modificarVideo");
        DtVideo video = null;
        instance.modificarVideo(video);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_ModificarVideo() {
        System.out.println("modificarVideo");
        DtVideo video = null;
        instance.seleccionarUsuario("usu1");
        instance.modificarVideo(video);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_3_ModificarVideo() {
        System.out.println("modificarVideo");
        DtVideo video = null;
        instance.seleccionarUsuario("usu1");
        instance.seleccionarVideo(1);
        instance.modificarVideo(video);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_4_ModificarVideo() {
        System.out.println("modificarVideo");
        DtVideo video = new DtVideo(0, "video2", "descripcion", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "DEPORTE", 0, 0);
        instance.seleccionarUsuario("usu1");
        instance.seleccionarVideo(1);
        instance.modificarVideo(video);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_5_ModificarVideo() {
        System.out.println("modificarVideo");
        DtVideo video = new DtVideo(0, "video2", "descripcion", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "ARTE", 1000, 5);
        instance.seleccionarUsuario("usu1");
        instance.seleccionarVideo(1);
        instance.modificarVideo(video);
    }
    @Test
    public void test_ModificarVideo() {
        System.out.println("modificarVideo");
        DtVideo video = new DtVideo(0, "video2", "descripcion modificada", new Time(1, 2, 3), new Date(11, 1, 1), "url", Privacidad.PRIVADO, "ARTE", 1000, 5);
        instance.seleccionarUsuario("usu1");
        DtVideo antes = instance.seleccionarVideo(2);
        instance.modificarVideo(video);
        DtVideo despues = instance.seleccionarVideo(2);
        assertNotEquals(antes.toString(), despues.toString());
    }

    
    
    /**
     * Test of obtenerPropietarioDeVideo method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ObtenerPropietarioDeVideo() {
        System.out.println("obtenerCanalDeUsuario");
        DtUsuario dtu = instance.obtenerPropietarioDeVideo(500);
    }
    @Test
    public void test_ObtenerPropietarioDeVideo() {
        System.out.println("obtenerCanalDeUsuario");
        DtUsuario dtu = instance.obtenerPropietarioDeVideo(8);
        assertTrue(dtu.getNickname().equals("usu3"));
    }
    
    
    
    /**
     * Test of obtenerCanalDeUsuario method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ObtenerCanalDeUsuario() {
        System.out.println("obtenerCanalDeUsuario");
        DtCanal expResult = null;
        DtCanal result = instance.obtenerCanalDeUsuario();
    }
    
    
    /**
     * Test of obtenerValoracionesDeVideo method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ObtenerValoracionesDeVideo() {
        System.out.println("obtenerValoracionesDeVideo");
        ArrayList<DtValoracion> expResult = null;
        ArrayList<DtValoracion> result = instance.obtenerValoracionesDeVideo();
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_ObtenerValoracionesDeVideo() {
        System.out.println("obtenerValoracionesDeVideo");
        ArrayList<DtValoracion> expResult = null;
        instance.seleccionarUsuario("usu1");
        ArrayList<DtValoracion> result = instance.obtenerValoracionesDeVideo();
    }
    @Test
    public void test_ObtenerValoracionesDeVideo() {
        System.out.println("obtenerValoracionesDeVideo");
        
        instance.seleccionarUsuario("usu3");
        instance.seleccionarUsuarioActual("usu2");
        instance.seleccionarVideo(8);
        instance.altaValoracion(new DtValoracion(TipoValoracion.LIKE, "nickname"));
        
        instance.seleccionarUsuario("usu3");
        instance.seleccionarVideo(8);
        ArrayList<DtValoracion> result = instance.obtenerValoracionesDeVideo();
        
        for (int i = 0; i < result.size(); i++){
            if (result.get(i).getNickname().equals("usu2")){
                assertTrue(true);
                return;
            }
        }
        assertTrue(false);
    }

    /**
     * Test of obtenerValoracionDada method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ObtenerValoracionDada() {
        System.out.println("obtenerValoracionDada");
        DtValoracion expResult = null;
        DtValoracion result = instance.obtenerValoracionDada();
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_ObtenerValoracionDada() {
        System.out.println("obtenerValoracionDada");
        instance.seleccionarUsuarioActual("usu2");
        DtValoracion expResult = null;
        DtValoracion result = instance.obtenerValoracionDada();
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_3_ObtenerValoracionDada() {
        System.out.println("obtenerValoracionDada");
        instance.seleccionarUsuarioActual("usu2");
        instance.seleccionarUsuario("usu2");
        DtValoracion expResult = null;
        DtValoracion result = instance.obtenerValoracionDada();
    }
    @Test
    public void test_1_ObtenerValoracionDada() {
        System.out.println("obtenerValoracionDada");
        instance.seleccionarUsuarioActual("usu2");
        instance.seleccionarUsuario("usu2");
        instance.seleccionarVideo(5);
        
        DtValoracion expResult = null;
        DtValoracion result = instance.obtenerValoracionDada();
        assertEquals(expResult, result);
    }
    @Test
    public void test_2_ObtenerValoracionDada() {
        System.out.println("obtenerValoracionDada");
        
        instance.seleccionarUsuario("usu2");
        instance.seleccionarUsuarioActual("usu2");
        instance.seleccionarVideo(5);
        instance.altaValoracion(new DtValoracion(TipoValoracion.DISLIKE, "nickname"));
        
        instance.seleccionarUsuarioActual("usu2");
        instance.seleccionarUsuario("usu2");
        instance.seleccionarVideo(5);
        
        DtValoracion expResult = new DtValoracion(TipoValoracion.DISLIKE, "usu2");
        DtValoracion result = instance.obtenerValoracionDada();
        assertEquals(expResult.toString(), result.toString());
    }
    
    /**
     * Test of quitarVideoDeListaDeReproduccion method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_QuitarVideoDeListaDeReproduccion() {
        System.out.println("quitarVideoDeListaDeReproduccion");
        instance.quitarVideoDeListaDeReproduccion(5);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_QuitarVideoDeListaDeReproduccion() {
        System.out.println("quitarVideoDeListaDeReproduccion");
        instance.seleccionarUsuario("usu1");
        instance.quitarVideoDeListaDeReproduccion(5);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_3_QuitarVideoDeListaDeReproduccion() {
        System.out.println("quitarVideoDeListaDeReproduccion");
        instance.seleccionarUsuario("usu1");
        instance.seleccionarListaDeReproduccion(1);
        instance.quitarVideoDeListaDeReproduccion(0);
    }
    @Test
    public void test_1_QuitarVideoDeListaDeReproduccion() {
        System.out.println("quitarVideoDeListaDeReproduccion");
        instance.seleccionarUsuario("usu1");
        instance.seleccionarListaDeReproduccion(1);
        instance.quitarVideoDeListaDeReproduccion(5);
        assertEquals(0, instance.listarVideosDeListaDeReproduccion().size());
    }
    @Test
    public void test_2_QuitarVideoDeListaDeReproduccion() {
        System.out.println("quitarVideoDeListaDeReproduccion");
        
        instance.seleccionarUsuario("usu2");
        instance.seleccionarUsuarioActual("usu1");
        instance.seleccionarVideo(5);
        instance.agregarVideoAListaDeReproduccion(1);
        
        instance.seleccionarUsuario("usu1");
        instance.seleccionarListaDeReproduccion(1);
        int antes = instance.listarVideosDeListaDeReproduccion().size();
        
        instance.seleccionarUsuario("usu1");
        instance.seleccionarListaDeReproduccion(1);
        instance.quitarVideoDeListaDeReproduccion(5);
        int despues = instance.listarVideosDeListaDeReproduccion().size();
        
        assertEquals(antes-1, despues);
    }
    
    
    /**
     * Test of seleccionarUsuario method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_SeleccionarUsuario() {
        System.out.println("seleccionarUsuario");
        String nickname = "";
        DtUsuario result = instance.seleccionarUsuario(nickname);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_SeleccionarUsuario() {
        System.out.println("seleccionarUsuario");
        String nickname = "nickname inexistente";
        DtUsuario result = instance.seleccionarUsuario(nickname);
    }
    @Test
    public void test_SeleccionarUsuario() {
        System.out.println("seleccionarUsuario");
        String nickname = "usu3";
        DtUsuario result = instance.seleccionarUsuario(nickname);
        assertNotNull(result);
    }

    /**
     * Test of seleccionarUsuarioActual method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_SeleccionarUsuarioActual() {
        System.out.println("seleccionarUsuario");
        String nickname = "";
        DtUsuario result = instance.seleccionarUsuarioActual(nickname);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_SeleccionarUsuarioActual() {
        System.out.println("seleccionarUsuario");
        String nickname = "nickname inexistente";
        DtUsuario result = instance.seleccionarUsuarioActual(nickname);
    }
    @Test
    public void test_SeleccionarUsuarioActual() {
        System.out.println("seleccionarUsuario");
        String nickname = "usu3";
        DtUsuario result = instance.seleccionarUsuarioActual(nickname);
        assertNotNull(result);
    }
    
    
    /**
     * Test of seleccionarVideo method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_SeleccionarVideo() {
        System.out.println("seleccionarVideo");
        int idVideo = 0;
        DtVideo expResult = null;
        DtVideo result = instance.seleccionarVideo(idVideo);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_SeleccionarVideo() {
        System.out.println("seleccionarVideo");
        int idVideo = 9;
        instance.seleccionarUsuario("usu1");
        DtVideo expResult = null;
        DtVideo result = instance.seleccionarVideo(idVideo);
    }
    @Test
    public void test_SeleccionarVideo() {
        System.out.println("seleccionarVideo");
        int idVideo = 9;
        instance.seleccionarUsuario("usu3");
        DtVideo expResult = null;
        DtVideo result = instance.seleccionarVideo(idVideo);
        assertTrue(result.getId() == 9);
    }

    
    /**
     * Test of seleccionarListaDeReproduccion method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_SeleccionarListaDeReproduccion() {
        System.out.println("seleccionarListaDeReproduccion");
        int idLista = 0;
        DtListaDeReproduccion result = instance.seleccionarListaDeReproduccion(idLista);
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_SeleccionarListaDeReproduccion() {
        System.out.println("seleccionarListaDeReproduccion");
        int idLista = 3;
        instance.seleccionarUsuario("usu1");
        DtListaDeReproduccion result = instance.seleccionarListaDeReproduccion(idLista);
    }
    @Test
    public void test_SeleccionarListaDeReproduccion() {
        System.out.println("seleccionarListaDeReproduccion");
        int idLista = 4;
        instance.seleccionarUsuario("usu1");
        DtListaDeReproduccion result = instance.seleccionarListaDeReproduccion(idLista);
        assertTrue(result.getId() == 4);
    }


    /**
     * Test of seguirUsuario method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_SeguirUsuario() {
        System.out.println("seguirUsuario");
        instance.seguirUsuario();
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_2_SeguirUsuario() {
        System.out.println("seguirUsuario");
        instance.seleccionarUsuarioActual("usu1");
        instance.seguirUsuario();
    }
    @Test(expected = RuntimeException.class)
    public void testThrow_3_SeguirUsuario() {
        System.out.println("seguirUsuario");
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu1");
        instance.seguirUsuario();
    }
    @Test
    public void test_SeguirUsuario() {
        System.out.println("seguirUsuario");
        instance.seleccionarUsuario("usu1");
        ArrayList<DtUsuario> seguidos = instance.listarUsuarioSeguidores();
        for (DtUsuario u : seguidos){
            instance.seleccionarUsuarioActual(u.getNickname());
            instance.seguirUsuario();
        }
        instance.seleccionarUsuario("usu1");
        instance.seleccionarUsuarioActual("usu3");
        
        int antes = instance.listarUsuarioSeguidores().size();
        instance.seguirUsuario();
        int despues = instance.listarUsuarioSeguidores().size();
        
        assertEquals(antes+1, despues);
    }

    
    
    /**
     * Test of validarNuevaListaParticular method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void testThrow_1_ValidarNuevaListaParticular() {
        System.out.println("validarNuevaListaParticular");
        String nombre = "";
        boolean expResult = false;
        boolean result = instance.validarNuevaListaParticular(nombre);
    }
    @Test
    public void test_1_ValidarNuevaListaParticular() {
        System.out.println("validarNuevaListaParticular");
        String nombre = "Favoritos";
        instance.seleccionarUsuario("usu1");
        boolean expResult = false;
        boolean result = instance.validarNuevaListaParticular(nombre);
        assertEquals(expResult, result);
    }
    @Test
    public void test_2_ValidarNuevaListaParticular() {
        System.out.println("validarNuevaListaParticular");
        String nombre = "terraplanismo";
        instance.seleccionarUsuario("usu1");
        boolean expResult = true;
        boolean result = instance.validarNuevaListaParticular(nombre);
        assertEquals(expResult, result);
    }

    /**
     * Test of validarNuevaListaPorDefecto method, of class CAdmin.
     */
    @Test(expected = RuntimeException.class)
    public void test_1_ValidarNuevaListaPorDefecto() {
        System.out.println("validarNuevaListaPorDefecto");
        String nombre = "";
        boolean expResult = false;
        boolean result = instance.validarNuevaListaPorDefecto(nombre);
        assertEquals(expResult, result);
    }
    @Test
    public void test_2_ValidarNuevaListaPorDefecto() {
        System.out.println("validarNuevaListaPorDefecto");
        String nombre = "Ver mas tarde";
        boolean expResult = false;
        boolean result = instance.validarNuevaListaPorDefecto(nombre);
        assertEquals(expResult, result);
    }
    @Test
    public void test_3_ValidarNuevaListaPorDefecto() {
        System.out.println("validarNuevaListaPorDefecto");
        String nombre = "mi lista";
        boolean expResult = false;
        boolean result = instance.validarNuevaListaPorDefecto(nombre);
        assertEquals(expResult, result);
    }
    @Test
    public void test_4_ValidarNuevaListaPorDefecto() {
        System.out.println("validarNuevaListaPorDefecto");
        String nombre = "Reviews de Yerba";
        boolean expResult = true;
        boolean result = instance.validarNuevaListaPorDefecto(nombre);
        assertEquals(expResult, result);
    }

    
    
    
    

}
