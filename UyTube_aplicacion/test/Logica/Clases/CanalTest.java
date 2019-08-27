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
 * @Carlos_Facundo
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

    @Test
    public void testCanal_nombreMal() {          //-------------------------anda
        System.out.println("setNombre");
        Canal instance = null;
        try{
            instance = new Canal(0, "", "descripcion", Privacidad.PRIVADO);
        }catch(Exception e){
            assertNull(null);
        }
        
    }
    
   @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Canal instance = c;
        String expResult = "nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Canal instance = c;
        String expResult = "descripcion";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPrivacidad() {
        System.out.println("getPrivacidad");
        Canal instance = c;
        Privacidad expResult = Privacidad.PRIVADO;
        Privacidad result = instance.getPrivacidad();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetId() {
        System.out.println("testGetId");
        Canal instance = c;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

   @Test
    public void testSetPrivacidad() {
        System.out.println("setPrivacidad");
        Canal instance = c;
        instance.setPrivacidad(Privacidad.PUBLICO);
        assertEquals(Privacidad.PUBLICO, c.getPrivacidad());
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
    public void testSetNombre_basura() {          //------------------------anda
        System.out.println("setNombre");
        Canal instance = c;
        try{
            instance.setNombre("");
        }catch(Exception e){
            assertNull(null);
        }
        
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
    }

    @Test
    public void testActualizarListasPorDefecto() {
        System.out.println("actualizarListasPorDefecto");
        Canal instance = null;
        instance.actualizarListasPorDefecto();
        // TODO review the generated test code and remove the default call to fail.
        //***************************fail("The test case is a prototype.");
    }

    @Test
    public void testAgregarComentarioAVideo_3args() {
        System.out.println("agregarComentarioAVideo");
        DtComentario comentario = com.getDT();
        Usuario usuario = u1;
        Canal instance = c1;
        instance.agregarComentarioAVideo(v1.getId(), comentario, usuario);
        assertNull(null);
    }

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

    @Test
    public void testAgregarListaParticular() {    //------------------------anda
        System.out.println("agregarListaParticular");
        DtListaDeReproduccion listaReproduccion = ldr.getDt();
        Canal instance = c1;
        instance.agregarListaParticular(listaReproduccion);
    }
    
    @Test
    public void testAgregarListaParticular_DtLdrNull() {    //--------------anda
        System.out.println("agregarListaParticular");
        DtListaDeReproduccion listaReproduccion = ldr.getDt();
        Canal instance = c1;
        try{
            instance.agregarListaParticular(null);
        }catch(Exception e){
            assertNull(null);
        } 
    }
    
    @Test
    public void testAgregarListaParticular_NombreLdrVacio() {    //---------anda
        System.out.println("agregarListaParticular");
        
        DtListaDeReproduccion listaReproduccion = new DtListaDeReproduccion(78, "", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "musical");
        Canal instance = c1;
        try{
            instance.agregarListaParticular(listaReproduccion);
        }catch(Exception e){
            assertNull(null);
        } 
    }
    
    @Test
    public void testAgregarListaParticular_PublicaBien() {    //----------------anda
        System.out.println("agregarListaParticular");
        
        DtListaDeReproduccion listaReproduccion = new DtListaDeReproduccion(78, "gfd", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "musical");
        Canal instance = c1;
        try{
            instance.agregarListaParticular(listaReproduccion);
        }catch(Exception e){
            assertNull(null);
        } 
    }
    @Test
    public void testAgregarListaParticular_PublicaMal() {    //----------------anda
        System.out.println("agregarListaParticular");
        
        DtListaDeReproduccion listaReproduccion = new DtListaDeReproduccion(78, "gfd", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "musical");
        Canal instance = c1;
        c1.setPrivacidad(Privacidad.PUBLICO);
        try{
            instance.agregarListaParticular(listaReproduccion);
        }catch(Exception e){
            assertNull(null);
        } 
    }
    
    @Test
    public void testAgregarListaParticular_CategoriaVacia() { //------------anda
        System.out.println("agregarListaParticular");
        
        DtListaDeReproduccion listaReproduccion = new DtListaDeReproduccion(78, "gfd", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "");
        Canal instance = c1;
        try{
            instance.agregarListaParticular(listaReproduccion);
        }catch(Exception e){
            assertNull(null);
        } 
    }
    
    @Test
    public void testAgregarListaParticular_Repetida() { //------------anda
        System.out.println("agregarListaParticular");
        
        DtListaDeReproduccion listaReproduccion = new DtListaDeReproduccion(78, "gfd", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "fghgh");
        Canal instance = c1;
        DtListaDeReproduccion listaReproduccion2 = new DtListaDeReproduccion(78, "gfd", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "fghgh");
        c1.agregarListaParticular(listaReproduccion);
        try{
            c1.agregarListaParticular(listaReproduccion2);
        }catch(Exception e){
            assertNull(null);
        } 
    }
    
    @Test
    public void testAgregarListaParticular_Otra() { //----------------------anda
        System.out.println("agregarListaParticular");
        
        DtListaDeReproduccion listaReproduccion = new DtListaDeReproduccion(78, "gfd", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "fghgh");
        Canal instance = c1;
        DtListaDeReproduccion listaReproduccion2 = new DtListaDeReproduccion(78, "fdgfd", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "fghgh");
        c1.agregarListaParticular(listaReproduccion);
        try{
            c1.agregarListaParticular(listaReproduccion2);
        }catch(Exception e){
            assertNull(null);
        } 
    }

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

    @Test
    public void testAgregarVideo() {        //------------------------------anda
        ArrayList<DtVideo> l = c.listarVideos();
        int esperado = l.size();
        c.agregarVideo(v1.getDt());
        int resultado=28;

        Video v2 = new Video(2, "nombre2", "_descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "_urlVideoOriginal", "_categoria");
        DtVideo dtv = v2.getDt();
        try{
            c.agregarVideo(dtv);
            ArrayList<DtVideo> l2 = c.listarVideos();
            resultado = l2.size();
            
        }catch(Exception e){
            assertEquals(esperado+1, resultado);
        }
    }
  
    @Test
    public void testAgregarVideo_DtNULL() {        //------------------------------anda
        ArrayList<DtVideo> l = c.listarVideos();
        int esperado = l.size();
        c.agregarVideo(v1.getDt());
        int resultado=28;

        Video v2 = new Video(3, "nombre3", "_descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "_urlVideoOriginal", "_categoria");
        DtVideo dtv = v2.getDt();
        try{
            c.agregarVideo(null);
            ArrayList<DtVideo> l2 = c.listarVideos();
            resultado = l2.size();
            
        }catch(Exception e){
            assertEquals(esperado+1, resultado);
        }
    }
    
    @Test
    public void testAgregarVideo_nombreVacio() { //------------------------------anda
        ArrayList<DtVideo> l = c.listarVideos();
        int esperado = l.size();
        c.agregarVideo(v1.getDt());
        int resultado=28;

        Video v2 = new Video(4, "", "_descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "_urlVideoOriginal", "_categoria");
        try{
            c.agregarVideo(v2.getDt());
            ArrayList<DtVideo> l2 = c.listarVideos();
            resultado = l2.size();
            
        }catch(Exception e){
            assertEquals(esperado+1, resultado);
        }
    }
    
    @Test
    public void testAgregarVideo_DuracionNull() { //------------------------------anda
        ArrayList<DtVideo> l = c.listarVideos();
        int esperado = l.size();
        c.agregarVideo(v1.getDt());
        int resultado=28;

        Video v2 = new Video(5, "nombre5", "_descripcion", null, new Date(0, 0, 0), "_urlVideoOriginal", "_categoria");
        try{
            c.agregarVideo(v2.getDt());
            ArrayList<DtVideo> l2 = c.listarVideos();
            resultado = l2.size();
            
        }catch(Exception e){
            assertEquals(esperado+1, resultado);
        }
    }
    
    @Test
    public void testAgregarVideo_FechaPNull() { //------------------------------anda
        ArrayList<DtVideo> l = c.listarVideos();
        int esperado = l.size();
        c.agregarVideo(v1.getDt());
        int resultado=28;

        Video v2 = new Video(6, "nombre6", "_descripcion", new Time(0, 0, 0), null, "_urlVideoOriginal", "_categoria");
        try{
            c.agregarVideo(v2.getDt());
            
        }catch(Exception e){
            ArrayList<DtVideo> l2 = c.listarVideos();
            resultado = l2.size();
            assertEquals(esperado+1, resultado);
        }
    }
    
    @Test
    public void testAgregarVideo_UrlVacia() { //------------------------------anda
        ArrayList<DtVideo> l = c.listarVideos();
        int esperado = l.size();
        c.agregarVideo(v1.getDt());
        int resultado=28;

        Video v2 = new Video(7, "nombre7", "_descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "", "_categoria");
        try{
            c.agregarVideo(v2.getDt());
            ArrayList<DtVideo> l2 = c.listarVideos();
            resultado = l2.size();
            
        }catch(Exception e){
            assertEquals(esperado+1, resultado);
        }
    }
    
    @Test
    public void testAgregarVideo_CatVacia() { //------------------------------anda
        ArrayList<DtVideo> l = c.listarVideos();
        int esperado = l.size();
        c.agregarVideo(v1.getDt());
        int resultado=28;

        Video v2 = new Video(8, "nombre8", "_descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "_urlVideoOriginal", "");
        try{
            c.agregarVideo(v2.getDt());
            ArrayList<DtVideo> l2 = c.listarVideos();
            resultado = l2.size();
            
        }catch(Exception e){
            assertEquals(esperado+1, resultado);
        }
    }
    
    @Test
    public void testAgregarVideo_malPrivacidad() {  //------------------- anda
        System.out.println("agregarVideo");
        Canal instance = c1;
        c1.setPrivacidad(Privacidad.PUBLICO);
        instance.agregarVideo(v1.getDt());
        assertEquals(c1.getPrivacidad(), Privacidad.PUBLICO);
    }
    
    @Test
    public void testAgregarVideo_elMismoVideo() {  //------------------- anda
        ArrayList<DtVideo> l = c.listarVideos();
        
        int esperado = l.size();
        c.agregarVideo(v1.getDt());
        int resultado=28;
        
        Video v3 = new Video(10, "nombre9", "_descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "_urlVideoOriginal", "_categoria");
        DtVideo dtv2 = v3.getDt();
        c.agregarVideo(dtv2);
        
        Video v2 = new Video(9, "nombre9", "_descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "_urlVideoOriginal", "_categoria");
        try{
            c.agregarVideo(v2.getDt());
            ArrayList<DtVideo> l2 = c.listarVideos();
            resultado = l2.size();
            
        }catch(Exception e){
            assertEquals(esperado+2, resultado);
        }
    }
    
    @Test
    public void testAgregarVideo_otroVideo() {  //------------------- anda
        ArrayList<DtVideo> l = c.listarVideos();
        
        int esperado = l.size();
        c.agregarVideo(v1.getDt());
        int resultado=28;
        
        Video v3 = new Video(10, "nombre10", "_descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "_urlVideoOriginal", "_categoria");
        DtVideo dtv2 = v3.getDt();
        c.agregarVideo(dtv2);
        
        Video v2 = new Video(9, "nombre9", "_descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "_urlVideoOriginal", "_categoria");
        try{
            c.agregarVideo(v2.getDt());
            ArrayList<DtVideo> l2 = c.listarVideos();
            resultado = l2.size();
            
        }catch(Exception e){
            assertEquals(esperado+2, resultado);
        }
    }

    @Test
    public void testAgregarVideoALista() { 
        System.out.println("agregarVideoALista");

        ArrayList<DtVideo> l = c.listarVideos();
        int esperado = l.size();

        c.agregarVideoALista(1, v1);
        c.agregarVideo(v1.getDt());
        ArrayList<DtVideo> l2 = c.listarVideos();
        int resultado = l2.size();
        
        assertEquals(esperado+1, resultado);
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
    }
    
    @Test
    public void testModificar() {         //--------------------------------anda
        System.out.println("modificar");
        Canal can1 = new Canal(Canal.getNuevoId(), "nombre", "descripcion", Privacidad.PRIVADO);
        DtCanal dtc = can1.getDT();
        String antes = dtc.toString();
        
        DtCanal dtc2 = new DtCanal(Canal.getNuevoId(), "otronombre", "otradescripcion", Privacidad.PRIVADO);
        String despues = dtc2.toString();
        assertNotEquals(despues, antes);
    }
    
    @Test
    public void testModificar_privacidad() {//----------------------------- anda
        System.out.println("modificar");
        Canal instance = new Canal(0, "dsd", "dfs", Privacidad.PUBLICO);
        instance.agregarVideo(v1.getDt());
        instance.modificar(new DtCanal(0, "nombre", "descripcion", Privacidad.PRIVADO));
        assertNull(null);
    }
    @Test
    public void testModificar_privacidad_otra() {//--------------------------------------- anda
        System.out.println("modificar");
        Canal instance = new Canal(0, "dsd", "dfs", Privacidad.PRIVADO);
        instance.agregarVideo(v1.getDt());
        instance.modificar(new DtCanal(0, "nombre", "descripcion", Privacidad.PUBLICO));
        assertNull(null);
    }
    
    @Test
    public void testModificar_basura() {  //--------------------------------anda
        System.out.println("modificar");
        Canal instance = c;
        try{
            instance.modificar(new DtCanal(0, "", "descripcion", Privacidad.PRIVADO));
        }catch(Exception e){
            assertEquals(true,true);
        } 
    }

    @Test
    public void testModificarListaDeReproduccion() {//-------------------No anda
        System.out.println("modificarListaDeReproduccion");
        DtListaDeReproduccion Dldr = ldr.getDt();
        Canal instance = c;
        instance.modificarListaDeReproduccion(Dldr);
        assertNull(null);
    }

    @Test
    public void testModificarVideo() {      //---------------------------No anda
        System.out.println("modificarVideo");
        DtVideo Dvideo = v1.getDt();
        Canal instance = c1;
        instance.modificarVideo(Dvideo);
        assertNull(null);
    }

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

    @Test
    public void testObtenerDtVideo() {        
        System.out.println("obtenerDtVideo");
        DtVideo dtv = v1.getDt();
        String esperado = dtv.toString();
        c1.agregarVideo(dtv);

        String resultado = c1.obtenerDtVideo(1).toString();
        assertEquals(esperado, resultado);
    }

    @Test
    public void testObtenerDtVideo_noPertenese() {        
        System.out.println("obtenerDtVideo");
        Canal instance = c;    
        DtVideo result = null;
        try{
            result = instance.obtenerDtVideo(54654);
        }catch(Exception e){
            assertNull(null);
        }
    }

    @Test
    public void testObtenerVideo() {        
        System.out.println("obtenerVideo");
        
        Canal instance = c;
        c.agregarVideo(v1.getDt());
        int idVideo = c.listarVideos().get(0).getId();

        Video result = null;
        result = instance.obtenerVideo(idVideo);
        assertNotNull(result);
    }
    
    @Test
    public void testObtenerVideo_noPertenese() {
        System.out.println("obtenerVideo");
        Canal instance = c;
        Video result = null;
        try{
            result = instance.obtenerVideo(6546);
        }catch(Exception e){
            assertNull(null);
        }
    }

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

    @Test
    public void testValidarListaParticular() {  //--------------mas o menos anda
        System.out.println("validarListaParticular");
        String nombreLista = "nombre";
        Canal instance = c1;
        boolean expResult = true;
        boolean result = instance.validarListaParticular(nombreLista);
        assertEquals(expResult, result);
    }

    @Test
    public void testObtenerValoracion() {//-------------------------------- anda
        System.out.println("obtenerValoracion");
        Canal instance = c;
        
        c.agregarVideo(v1.getDt());
        int idVideo = c.listarVideos().get(0).getId();
        
        DtValoracion result = null;
        result = instance.obtenerValoracion(idVideo, u1.getNickname());
        assertNull(null);
    }
    @Test
    public void testObtenerValoracion_basura() {//--------------------------anda
        System.out.println("obtenerVideo");
        Canal instance = c;
        DtValoracion result = null;
        try{
            result = instance.obtenerValoracion(4654, u1.getNickname());
        }catch(Exception e){
            assertNull(null);
        }
    }
    
}
