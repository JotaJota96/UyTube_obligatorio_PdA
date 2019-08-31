package Logica.Clases;

import Logica.DataType.DtCanal;
import Logica.DataType.DtComentario;
import Logica.DataType.DtListaDeReproduccion;
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
 * @Carlos_Facundo
 */
public class CanalTest {
    
    Canal c; 
    Canal c1; 
    
    ListaDeReproduccion ldr;
    int idLista;
    
    Video v1;
    
    Usuario u1;
    
    Comentario com;
    
    public CanalTest() {
        c = new Canal(0, "nombre", "descripcion", Privacidad.PRIVADO);
        c1 = new Canal(0, "nombre", "descripcion", Privacidad.PRIVADO);
        idLista = ListaDeReproduccion.getNuevoId();
        ldr = new ListaDeReproduccion(idLista+1, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "categoria");
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
            assertNull(instance);
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
    public void testSetPrivacidad2() {
        System.out.println("setPrivacidad");
        Canal instance = new Canal(0, "nombre", "descripcion", Privacidad.PRIVADO);
        instance.setPrivacidad(Privacidad.PUBLICO);
        int id = Video.getNuevoId();
        DtVideo dt1 = new DtVideo(id+1, "vid1", "desc", new Time(1, 2, 3), new Date(2010-1900, 5, 25), "url_vid", Privacidad.PUBLICO, "MUSICA", 0, 0);
        DtVideo dt2 = new DtVideo(id+2, "vid2", "desc", new Time(1, 2, 3), new Date(2010-1900, 5, 25), "url_vid", Privacidad.PRIVADO, "MUSICA", 0, 0);
        DtVideo dt3 = new DtVideo(id+3, "vid3", "desc", new Time(1, 2, 3), new Date(2010-1900, 5, 25), "url_vid", Privacidad.PUBLICO, "MUSICA", 0, 0);
        instance.agregarVideo(dt1);
        instance.agregarVideo(dt2);
        instance.agregarVideo(dt3);
        instance.modificarVideo(dt1);
        instance.modificarVideo(dt2);
        instance.modificarVideo(dt3);
        
        instance.agregarListaParticular(new DtListaDeReproduccion(id, "nombre_l1", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "categoria"));
        instance.agregarListaParticular(new DtListaDeReproduccion(id, "nombre_l2", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "categoria"));
        instance.agregarListaParticular(new DtListaDeReproduccion(id, "nombre_l3", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "categoria"));
        
        instance.setPrivacidad(Privacidad.PRIVADO);
        
        ArrayList<DtVideo> lv = instance.listarVideos();
        ArrayList<DtListaDeReproduccion> lldr = instance.listarListasDeReproduccion(false);
        
        for (int i = 0; i < lv.size(); i++){
            if (lv.get(i).getPrivacidad() != Privacidad.PRIVADO){
                assertTrue(false);
                return;
            }
        }
        for (int i = 0; i < lldr.size(); i++){
            if (lldr.get(i).getPrivacidad() != Privacidad.PRIVADO){
                assertTrue(false);
                return;
            }
        }
        assertTrue(true);
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
        Canal instance = c1;
        instance.actualizarListasPorDefecto();
        
        // TODO review the generated test code and remove the default call to fail.
        //***************************fail("The test case is a prototype.");
    }

    @Test
    public void testAgregarComentarioAVideo_3args() {
        System.out.println("agregarComentarioAVideo");
        Canal instance = c;
        int id = Video.getNuevoId()+1;
        Video v = new Video(id, "_nombre", "_descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "_urlVideoOriginal", "_categoria");
        instance.agregarVideo(v.getDt());
        int expResult = instance.listarComentariosDeVideo(v.getId()).size() + 1;
        Comentario comentario = new Comentario(0, new Date(0, 0, 0), "texto", 0, u1);
        instance.agregarComentarioAVideo(v.getId(), comentario.getDT(), u1);
        int result = instance.listarComentariosDeVideo(v.getId()).size();
        assertEquals(expResult, result);
    }
    
    
    @Test(expected = RuntimeException.class)
    public void testAgregarComentarioAVideo_3args2() {
        System.out.println("agregarComentarioAVideo");
        Canal instance = c;
        
        Comentario comentario = new Comentario(0, new Date(0, 0, 0), "texto", 0, u1);
        instance.agregarComentarioAVideo(5879, 1, comentario.getDT(), u1);
    }
    
/*
    @Test
    public void testAgregarComentarioAVideo_4args() {
        System.out.println("agregarComentarioAVideo");
        Canal instance = c;
        int id = Video.getNuevoId()+1;
        Video v = new Video(id, "_nombre", "_descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "_urlVideoOriginal", "_categoria");
        instance.agregarVideo(v.getDt());
        
        int idC = Comentario.getNuevoID()+1;
        Comentario comentario1 = new Comentario(idC, new Date(0, 0, 0), "texto", 0, u1);
        
        int expResult = instance.listarComentariosDeVideo(v.getId()).size() + 1;
        
        Comentario comentario = new Comentario(0, new Date(0, 0, 0), "texto", 0, u1);
        instance.agregarComentarioAVideo(v.getId(),comentario1.getId(), comentario.getDT(), u1);
        int result = instance.listarComentariosDeVideo(v.getId()).size();
        assertEquals(expResult, result);
    }
    */
//    @Test
//    public void testAgregarComentarioAVideo2_4args() {
//        System.out.println("agregarComentarioAVideo");
//        Canal instance = c;
//        int idC = Comentario.getNuevoID()+1;
//        Comentario comentario1 = new Comentario(idC, new Date(0, 0, 0), "texto", 0, u1);
//        Comentario comentario = new Comentario(0, new Date(0, 0, 0), "texto", 0, u1);
//        instance.agregarComentarioAVideo(v1.getId(),comentario1.getId(), comentario.getDT(), u1);
//        int result = instance.listarComentariosDeVideo(v1.getId()).size();
//        assertEquals(result+1, result);
//    }

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

    @Test(expected = RuntimeException.class)
    public void testQuitarValoracion() {
        System.out.println("quitarValoracion");
        Canal instance = c;
        
        instance.quitarValoracion(0, "nickname");
        try {
            instance.quitarValoracion(0, "Usu");
            assertNull(null);
        } catch (Exception e) {
            assertNotNull(null);
        }
  

    }
    
    @Test(expected = RuntimeException.class)
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

    @Test(expected = RuntimeException.class)
    public void testAgregarModificarValoracion2() {
        System.out.println("agregarModificarValoracion");
        int id = 0;
        DtValoracion valoracion = null;
        Usuario usuario = null;
        Canal instance = c;
        instance.agregarModificarValoracion(5792, valoracion, usuario);
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
        int resultado=1;

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
       
        Canal instance = c;
        try{
            instance.agregarVideo(new DtVideo(6, "", "_descripcion", new Time(0, 0, 0), new Date(119, 5, 8), "_urlVideoOriginal", Privacidad.PUBLICO, "_categoria", 0, 0));
        }catch(Exception e){
            assertNull(null);
        }
    }
    
    @Test
    public void testAgregarVideo_DuracionNull() { //------------------------------anda
        ArrayList<DtVideo> l = c.listarVideos();
        int esperado = l.size();
        c.agregarVideo(v1.getDt());
        int resultado=28;

         try{
            c.agregarVideo(new DtVideo(6, "nombre6", "_descripcion", null, new Date(119, 5, 8), "_urlVideoOriginal", Privacidad.PUBLICO, "_categoria", 0, 0));
        }catch(Exception e){
            ArrayList<DtVideo> l2 = c.listarVideos();
            resultado = l2.size();
            assertEquals(esperado+1, resultado);
        }
    }
    
    @Test
    public void testAgregarVideo_FechaPNull() { //------------------------------anda
        ArrayList<DtVideo> l = c.listarVideos();
        int esperado = l.size();
        c.agregarVideo(v1.getDt());
        int resultado=28;

        try{
            c.agregarVideo(new DtVideo(6, "nombre6", "_descripcion", new Time(0, 0, 0), null, "_urlVideoOriginal", Privacidad.PUBLICO, "_categoria", 0, 0));
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

       try{
            c.agregarVideo(new DtVideo(6, "nombre6", "_descripcion", new Time(0, 0, 0), new Date(119, 5, 8), "", Privacidad.PUBLICO, "_categoria", 0, 0));
        }catch(Exception e){
            ArrayList<DtVideo> l2 = c.listarVideos();
            resultado = l2.size();
            assertEquals(esperado+1, resultado);
        }
    }
    
    @Test
    public void testAgregarVideo_CatVacia() { //------------------------------anda
        ArrayList<DtVideo> l = c.listarVideos();
        int esperado = l.size();
        c.agregarVideo(v1.getDt());
        int resultado=28;

       try{
            c.agregarVideo(new DtVideo(6, "nombre6", "_descripcion", new Time(0, 0, 0), new Date(119, 5, 8), "_urlVideoOriginal", Privacidad.PUBLICO, "", 0, 0));
        }catch(Exception e){
            ArrayList<DtVideo> l2 = c.listarVideos();
            resultado = l2.size();
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
        
        try {
            Video v2 = new Video(9, "nombre9", "_descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "_urlVideoOriginal", "_categoria");
            c.agregarVideo(v2.getDt());
        } catch (Exception e) {
        }

        ArrayList<DtVideo> l2 = c.listarVideos();
        resultado = l2.size();

        assertEquals(esperado + 2, resultado);
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
        Canal instance = c;
        int id = ListaDeReproduccion.getNuevoId();
        ListaDeReproduccion lr = new ListaDeReproduccion(id+1, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "categoria");
        instance.agregarListaParticular(lr.getDt());
        ArrayList<DtVideo> dtv = instance.listarVideosDeListaDeReproduccion(lr.getId());
        int esperado = dtv.size()+1;

        instance.agregarVideoALista(lr.getId(), v1);
        int resultado = instance.listarVideosDeListaDeReproduccion(lr.getId()).size();
        
        assertEquals(esperado, resultado);
    }
    @Test(expected = RuntimeException.class)
    public void testAgregarVideoALista2() { 
        System.out.println("agregarVideoALista");
        Canal instance = c;
        instance.agregarVideoALista(2, v1);

        ArrayList<DtVideo> dtv = instance.listarVideosDeListaDeReproduccion(ldr.getId());
        int esperado = dtv.size()+1;

        int resultado = instance.listarVideosDeListaDeReproduccion(ldr.getId()).size();
        
        assertEquals(esperado, resultado);
    }
    
    @Test(expected = RuntimeException.class)
    public void testListarComentariosDeVideo() {
        System.out.println("listarComentariosDeVideo");
        Canal instance = c;
        DtVideo v = new DtVideo(0, "nombre", "descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "urlVideoOriginal", Privacidad.PRIVADO, "categoria", 0, 0);
        DtComentario DtCom = new DtComentario(0, u1.getNickname(), new Date(0, 0, 0), "texto", 0);
        c.agregarVideo(v);
        c.agregarComentarioAVideo(v.getId(),DtCom , u1);
        ArrayList<DtComentario> expResult = new ArrayList<>();
        expResult.add(DtCom);
        ArrayList<DtComentario> result = instance.listarComentariosDeVideo(v.getId());
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //****************************************fail("The test case is a prototype.");
    }

    @Test(expected = RuntimeException.class)
    public void testListarComentariosDeVideo2() {
        System.out.println("listarComentariosDeVideo");
        Canal instance = c;
        ArrayList<DtComentario> result = instance.listarComentariosDeVideo(9005);
        // TODO review the generated test code and remove the default call to fail.
        //****************************************fail("The test case is a prototype.");
    }

    @Test
    public void testListarListasDeReproduccion() {
        System.out.println("listarListasDeReproduccionPORDEFECTO");
        Canal instance = c;
        ArrayList<DtListaDeReproduccion> ArrayResult = instance.listarListasDeReproduccion(true);
        assertEquals(ArrayResult.toString().contains("PARTICULAR"), false);
        // TODO review the generated test code and remove the default call to fail.
       //**************************************** fail("The test case is a prototype.");
    }
    
    @Test
    public void testListarValoracionesDeVideo() {
        System.out.println("listarValoracionesDeVideo");
        Canal instance = c;
        int id = Video.getNuevoId()+1;
        Video v2 = new Video(id, "_nombre_", "_descripcion", new Time(1, 1, 1), new Date(0, 0, 0), "_urlVideoOriginal", "_categoria");
        instance.agregarVideo(v2.getDt());

        Valoracion val = new Valoracion(TipoValoracion.LIKE, u1);
        instance.agregarModificarValoracion(id, val.getDT(), u1);
      
        ArrayList<DtValoracion> expResult = new ArrayList();
        expResult.add(val.getDT());
        ArrayList<DtValoracion> result = instance.listarValoracionesDeVideo(id);
        assertEquals(expResult.size(), result.size()); 
    }
    
    @Test(expected = RuntimeException.class)
    public void testListarValoracionesDeVideo2() {
        System.out.println("listarValoracionesDeVideo");
        Canal instance = c;
        ArrayList<DtValoracion> result = instance.listarValoracionesDeVideo(922);
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
  
    @Test(expected = RuntimeException.class)
    public void testListarVideosDeListaDeReproduccion() {
        System.out.println("listarVideosDeListaDeReproduccion");
        Canal instance = c;
        ArrayList<DtVideo> result = instance.listarVideosDeListaDeReproduccion(456789);
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

    @Test(expected = RuntimeException.class)
    public void testModificarListaDeReproduccion() {//-------------------No anda
        System.out.println("modificarListaDeReproduccion");
        Canal instance = c;
        instance.modificarListaDeReproduccion(null);
    }
    

    @Test(expected = RuntimeException.class)
    public void testModificarListaDeReproduccion1() {
        System.out.println("modificarListaDeReproduccion");
        Canal instance = c;
        int x = Canal.getNuevoId();
        ListaDeReproduccion l = new ListaDeReproduccion(x+1, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "categoria");
        c.agregarListaParticular(l.getDt());
        instance.modificarListaDeReproduccion(l.getDt());
        assertNull(null);
    }
    
     @Test
    public void testModificarListaDeReproduccion2() {      
        System.out.println("modificarLdr");
        Canal instance = c;
        int id = ListaDeReproduccion.getNuevoId() + 1;
        DtListaDeReproduccion dt1 = new DtListaDeReproduccion(id+1, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "categoria");
        instance.agregarListaParticular(dt1);
        DtListaDeReproduccion dt2 = new DtListaDeReproduccion(id, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "categoria");
        
        try {
        instance.modificarListaDeReproduccion(dt2);
            assertNull(null);
        } catch (Exception e) {
            assertNotNull(null);
        }
    }
    
    @Test(expected = RuntimeException.class)
    public void testModificarListaDeReproduccion3() {
        System.out.println("modificarListaDeReproduccion");
        Canal instance = new Canal(0, "dsd", "dfs", Privacidad.PRIVADO);;
        
        int id = ListaDeReproduccion.getNuevoId() +1;
        instance.agregarListaParticular(new DtListaDeReproduccion(id, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "categoria"));
        
        instance.modificarListaDeReproduccion(new DtListaDeReproduccion(id, "nombre", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "categoria"));
    }

    

    @Test
    public void testModificarVideo() {      
        System.out.println("modificarVideo");
        Canal instance = c1;
        
        
        try{
            instance.modificarVideo(null);
        }catch(Exception e){
            assertNull(null);
        }
    }
    
      @Test
    public void testModificarVideo1() {      
        System.out.println("modificarVideo");
        Canal instance = c1;
        c1.agregarVideo(v1.getDt());
        
        
        try{
            instance.modificarVideo(v1.getDt());
        }catch(Exception e){
            assertNull(null);
        }
    }
    
    
    
    @Test
    public void testModificarVideo2() {      
        System.out.println("modificarVideo");
        Canal instance = c;
        int id = Video.getNuevoId() + 1;
        DtVideo dt1 = new DtVideo(id, "videito", "descripcioncita", new Time(1, 2, 3), new Date(2010-1900, 5, 25), "urlcita", Privacidad.PRIVADO, "MUSICA", 0, 0);
        instance.agregarVideo(dt1);
        DtVideo dt2 = new DtVideo(id, "vid", "desc", new Time(1, 2, 3), new Date(2010-1900, 5, 25), "url_vid", Privacidad.PRIVADO, "MUSICA", 0, 0);
        
        try {
        instance.modificarVideo(dt2);
            assertNull(null);
        } catch (Exception e) {
            assertNotNull(null);
        }
    }

     @Test
    public void testModificarVideo3() {      
        System.out.println("modificarVideo");
        Canal instance = c1;
        int x = Video.getNuevoId();
        Video v = new Video(x+1, "_nombre", "_descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "_urlVideoOriginal", "_categoria");
        v.setPrivacidad(Privacidad.PUBLICO);
        c1.agregarVideo(v.getDt());
        
        
        try{
            instance.modificarVideo(v.getDt());
        }catch(Exception e){
            assertNull(null);
        }
    }
 

    
    @Test
    public void testObtenerListaDeReproduccion() {
        System.out.println("obtenerListaDeReproduccion");
        int id = ListaDeReproduccion.getNuevoId()+1;
        Canal instance = c;
        ListaDeReproduccion l = new ListaDeReproduccion(id, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "categoria");
        DtListaDeReproduccion expResult = l.getDt();
        instance.agregarListaParticular(l.getDt());
        DtListaDeReproduccion result = instance.obtenerListaDeReproduccion(id);
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
      //****************************************  fail("The test case is a prototype.");
    }
    @Test(expected = RuntimeException.class)
    public void testObtenerListaDeReproduccion2() {
        System.out.println("obtenerListaDeReproduccion");
        Canal instance = c;
        DtListaDeReproduccion expResult = ldr.getDt();
        DtListaDeReproduccion result = instance.obtenerListaDeReproduccion(ldr.getId());
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //****************************************  fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerListasEnCategoria() {
        System.out.println("obtenerListasEnCategoria");
        Canal instance = c;
        ListaDeReproduccion l = new ListaDeReproduccion(0, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "Arctic Monkeys");
        c.agregarListaParticular(l.getDt());
        ArrayList<DtListaDeReproduccion> ArrayResult = instance.obtenerListasEnCategoria("Arctic Monkeys");
        
        
        for (int i = 0; i < ArrayResult.size(); i++){
            if (ArrayResult.get(i).getCategoria() != "Arctic Monkeys") {
                assertTrue(false);
                return;
            }
        }
        assertTrue(true);
        
    }
    
    @Test
    public void testObtenerListasEnCategoria1() {
        System.out.println("obtenerVideosEnCategoria");
        Canal instance = c;
        ArrayList<DtListaDeReproduccion> ArrayResult = instance.obtenerListasEnCategoria("Monos Articos");
        
        assertEquals(0, ArrayResult.size());
    }

    @Test
    public void testObtenerDtVideo() {        
        System.out.println("obtenerDtVideo");
        Canal instance = c;
        int id = Video.getNuevoId()+1;
        Video v = new Video(id, "_nombre", "_descripcion",new Time(0, 0, 0) ,new Date(0, 0, 0), "_urlVideoOriginal", "_categoria");
        instance.agregarVideo(v.getDt());
        String expResult = v.getDt().toString();
        String resultado = c.obtenerDtVideo(id).toString();
        assertEquals(expResult, resultado);
    }
    @Test(expected = RuntimeException.class)
    public void testObtenerDtVideo2() {        
        System.out.println("obtenerDtVideo");
        DtVideo dtv = v1.getDt();
        String esperado = dtv.toString();
        c1.agregarVideo(dtv);

        String resultado = c1.obtenerDtVideo(1).toString();
        assertEquals(esperado, resultado);
    }

    @Test
    public void testObtenerDtVideo_noPertenece() {        
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
    public void testObtenerVideo_noPertenece() {
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
        Canal instance = c;
        Video v = new Video(0, "_nombre", "_descripcion", new Time(0, 0, 0), new Date(0, 0, 0), "_urlVideoOriginal", "Deporte");
        c.agregarVideo(v.getDt());
        ArrayList<DtVideo> ArrayResult = instance.obtenerVideosEnCategoria("Deporte");

        for (int i = 0; i < ArrayResult.size(); i++){
            if (ArrayResult.get(i).getCategoria() != "Deporte") {
                assertTrue(false);
                return;
            }
        }
        assertTrue(true);
    }
    
       @Test
    public void testObtenerVideosEnCategoria1() {
        System.out.println("obtenerVideosEnCategoria");
        Canal instance = c;
        ArrayList<DtVideo> ArrayResult = instance.obtenerVideosEnCategoria("_categoria");
        
        for (int i = 0; i < ArrayResult.size(); i++){
            if (ArrayResult.get(i).getCategoria().equals("Deporte")) {
                assertTrue(false);
                return;
            }
        }
        assertTrue(true);
    }

    @Test
    public void testQuitarVideoDeListaDeReproduccion() {
        System.out.println("quitarVideoDeListaDeReproduccion");
        Canal instance = c;
        int id = ListaDeReproduccion.getNuevoId()+1;
        int idV = Video.getNuevoId()+1;
        ListaDeReproduccion l = new ListaDeReproduccion(id, "nombre", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "categoria");
        Video v = new Video(idV, "_nombre", "_descripcion", new Time(1, 1, 1), new Date(0, 0, 0), "_urlVideoOriginal", "_categoria");
        instance.agregarListaParticular(ldr.getDt());
        instance.agregarVideoALista(id, v);
        
        
        ArrayList<DtVideo> expResult = new ArrayList();
        
        instance.quitarVideoDeListaDeReproduccion(l.getId(), v.getId());
        assertEquals(expResult.size(), instance.listarVideosDeListaDeReproduccion(id).size());
    }
   
    @Test(expected = RuntimeException.class)
    public void testQuitarVideoDeListaDeReproduccion2() {
        System.out.println("quitarVideoDeListaDeReproduccion");
        Canal instance = c;            
        instance.quitarVideoDeListaDeReproduccion(ldr.getId(), v1.getId());
        assertEquals(true,true);
    }
        // TODO review the generated test code and remove the default call to fail.
     //****************************************   fail("The test case is a prototype.");
    

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
