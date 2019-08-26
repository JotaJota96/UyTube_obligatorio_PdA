/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Clases;

import Logica.DataType.DtListaDeReproduccion;
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
 * @author Juan
 */
public class ListaDeReproduccionTest {
    private ListaDeReproduccion ldrParticular = null;
    private ListaDeReproduccion ldrPorDefecto = null;
    Video v = null;
    
    public ListaDeReproduccionTest() {
        ldrParticular = new ListaDeReproduccion(0, "mi lista", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED");
        ldrPorDefecto = new ListaDeReproduccion(0, "mi lista", Privacidad.PRIVADO, TipoListaDeReproduccion.POR_DEFECTO, "UNDEFINED");
        
        v = new Video(0, "_nombre",  "_descripcion", new Time(0, 10, 15),  new Date(2019-1900, 5, 15), "_urlVideoOriginal", "UNDEFINED");
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
     * Test of getNuevoId method, of class ListaDeReproduccion.
     */
    @Test
    public void testGetNuevoId() {
        System.out.println("getNuevoId");
        int expResult = 1;
        int result = ListaDeReproduccion.getNuevoId();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testGetNuevoId2() {
        System.out.println("getNuevoId2");
        int expResult = 2;
        int result = ListaDeReproduccion.getNuevoId();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of listarNombresDeListasPorDefecto method, of class ListaDeReproduccion.
     */
    @Test
    public void testListarNombresDeListasPorDefecto() {
        System.out.println("listarNombresDeListasPorDefecto");
        ArrayList<String> expResult = new ArrayList();
        expResult.add("Ver mas tarde");
        ArrayList<String> result = ListaDeReproduccion.listarNombresDeListasPorDefecto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of agregarListaPorDefecto method, of class ListaDeReproduccion.
     */
    @Test
    public void testAgregarListaPorDefecto() {
        System.out.println("agregarListaPorDefecto");
        ArrayList<String> expResult = new ArrayList();
        expResult.add("Ver mas tarde");
        expResult.add("Favoritos");
        ListaDeReproduccion.agregarListaPorDefecto("Favoritos");
        ArrayList<String> result = ListaDeReproduccion.listarNombresDeListasPorDefecto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testAgregarListaPorDefecto2() {
            System.out.println("agregarListaPorDefecto2");
            ArrayList<String> expResult = new ArrayList();
            ArrayList<String> result = null;
            expResult.add("Ver mas tarde");
            
            // TODO review the generated test code and remove the default call to fail.
            //fail("The test case is a prototype.");
        try {
            ListaDeReproduccion.agregarListaPorDefecto("");
            assertEquals(expResult, result);
        } catch (Exception e) {
            result = ListaDeReproduccion.listarNombresDeListasPorDefecto();
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of getId method, of class ListaDeReproduccion.
     */
    @Test
    public void testGetId() {
        System.out.println("testGetId");
        ListaDeReproduccion instance = ldrParticular;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of getNombre method, of class ListaDeReproduccion.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        ListaDeReproduccion instance = ldrParticular;
        String expResult = "mi lista";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrivacidad method, of class ListaDeReproduccion.
     */
    @Test
    public void testGetPrivacidad() {
        System.out.println("getPrivacidad");
        ListaDeReproduccion instance = ldrParticular;
        Privacidad expResult = Privacidad.PRIVADO;
        Privacidad result = instance.getPrivacidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrivacidad method, of class ListaDeReproduccion.
     */
    @Test
    public void testSetPrivacidad() {
        System.out.println("setPrivacidad");
        ListaDeReproduccion instance = ldrParticular;
        instance.setPrivacidad(Privacidad.PUBLICO);
        assertEquals(Privacidad.PUBLICO, ldrParticular.getPrivacidad());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        instance.setPrivacidad(Privacidad.PRIVADO);
    }

    /**
     * Test of getTipo method, of class ListaDeReproduccion.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        ListaDeReproduccion instance = ldrParticular;
        TipoListaDeReproduccion expResult = TipoListaDeReproduccion.PARTICULAR;
        TipoListaDeReproduccion result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ListaDeReproduccion.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ListaDeReproduccion instance = ldrParticular;
        String expResult = "ListaDeReproduccion{id=0, nombre=mi lista, privacidad=PRIVADO, tipo=PARTICULAR, categoria=UNDEFINED, misVideos.size=0}";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    /**
     * Test of getCategoria method, of class ListaDeReproduccion.
     */
    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        ListaDeReproduccion instance = ldrParticular;
        String expResult = "UNDEFINED";
        String result = instance.getCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDt method, of class ListaDeReproduccion.
     */
    @Test
    public void testGetDt() {
        System.out.println("getDt");
        ListaDeReproduccion instance = null;
        DtListaDeReproduccion expResult = new DtListaDeReproduccion(0, "mi lista", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED");
        DtListaDeReproduccion result = ldrParticular.getDt();
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    
    /**
     * Test of agregarVideoA method, of class ListaDeReproduccion.
     */
    @Test
    public void testAgregarVideoA_null() {
        System.out.println("agregarVideoA");
        ListaDeReproduccion instance = ldrParticular;
        int expResult = instance.listarVideos().size();
        
        try {
            instance.agregarVideoA(null);
        } catch (Exception e) {
            assertEquals(expResult, instance.listarVideos().size());
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    /**
     * Test of agregarVideoA method, of class ListaDeReproduccion.
     */
    @Test
    public void testAgregarVideoA() {
        System.out.println("agregarVideoA");
        int expResult = ldrParticular.listarVideos().size() +1;
        ListaDeReproduccion instance = ldrParticular;
        instance.agregarVideoA(v);
        assertEquals(expResult, ldrParticular.listarVideos().size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of constructor method, of class ListaDeReproduccion.
     */
    @Test
    public void testListaDeReproduccion_1() {
        System.out.println("agregarVideoA");
        
        try {
            ListaDeReproduccion instance = new ListaDeReproduccion(0, "", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED");
        } catch (Exception e) {
            assertEquals(true, true);
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testListaDeReproduccion_2() {
        System.out.println("agregarVideoA");
        
        try {
            ListaDeReproduccion instance = new ListaDeReproduccion(0, "mi lista", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "");
        } catch (Exception e) {
            assertEquals(true, true);
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testListaDeReproduccion_3() {
        System.out.println("agregarVideoA");
        
        try {
            ListaDeReproduccion instance = new ListaDeReproduccion(0, "mi lista", Privacidad.PUBLICO, TipoListaDeReproduccion.POR_DEFECTO, "UNDEFINED");
        } catch (Exception e) {
            assertEquals(true, true);
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testListaDeReproduccion_4() {
        System.out.println("agregarVideoA");
        
        try {
            ListaDeReproduccion instance = new ListaDeReproduccion(0, "mi lista", Privacidad.PRIVADO, TipoListaDeReproduccion.POR_DEFECTO, "MUSICA");
        } catch (Exception e) {
            assertEquals(true, true);
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of listarVideos method, of class ListaDeReproduccion.
     */
    
    @Test
    public void testListarVideos() {
        System.out.println("listarVideos");
        ListaDeReproduccion instance = new ListaDeReproduccion(0, "mi lista", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED");;
        instance.agregarVideoA(v);
        
        ArrayList<DtVideo> expResult = new ArrayList();
        expResult.add(v.getDt());
        
        ArrayList<DtVideo> result = instance.listarVideos();
        assertEquals(expResult.size(), result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
    }
    
    /**
     * Test of modificar method, of class ListaDeReproduccion.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        DtListaDeReproduccion ldr = new DtListaDeReproduccion(0, "mi musica", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "MUSICA");
        ListaDeReproduccion instance = ldrParticular;
        instance.modificar(ldr);
        assertEquals(ldr.toString(), instance.getDt().toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testModificar_exp_1() {
        System.out.println("testModificar_exp_1");
        ListaDeReproduccion instance = ldrPorDefecto;
        DtListaDeReproduccion esperado = instance.getDt();
        try {
            DtListaDeReproduccion ldr = new DtListaDeReproduccion(0, "mi musica", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "MUSICA");
            instance.modificar(ldr);
        } catch (Exception e) {
            assertEquals(esperado.toString(), instance.getDt().toString());
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testModificar_exp_2() {
        System.out.println("testModificar_exp_1");
        ListaDeReproduccion instance = ldrParticular;
        DtListaDeReproduccion esperado = instance.getDt();
        try {
            instance.modificar(null);
        } catch (Exception e) {
            assertEquals(esperado.toString(), instance.getDt().toString());
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testModificar_exp_3() {
        System.out.println("testModificar_exp_1");
        ListaDeReproduccion instance = ldrParticular;
        DtListaDeReproduccion esperado = instance.getDt();
        try {
            DtListaDeReproduccion ldr = new DtListaDeReproduccion(0, "", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "MUSICA");
            instance.modificar(ldr);
        } catch (Exception e) {
            assertEquals(esperado.toString(), instance.getDt().toString());
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of quitarVideo method, of class ListaDeReproduccion.
     */
    
    @Test
    public void testQuitarVideo() {
        System.out.println("quitarVideo");
        ListaDeReproduccion instance = new ListaDeReproduccion(0, "mi lista", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED");;
        instance.agregarVideoA(v);
        
        ArrayList<DtVideo> expResult = new ArrayList();
        
        instance.quitarVideo(v.getId());
        assertEquals(expResult.size(), instance.listarVideos().size());
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
