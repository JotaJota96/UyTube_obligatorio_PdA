package Logica.DataType;

import Logica.Enumerados.Privacidad;
import java.sql.Date;
import java.sql.Time;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos BM
 */
public class DtVideoTest {
    
    DtVideo dtv;
    public DtVideoTest() {
        dtv = new DtVideo(2, "video1", "un_video", new Time(1,1,1), new Date(190,1,2), "https://sdsd.com", Privacidad.PRIVADO, "futbol", 0, 0);
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
    public void testGetId() {
        System.out.println("getId");
        DtVideo instance = dtv;
        int expResult = 2;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        DtVideo instance = dtv;
        String expResult = "video1";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        DtVideo instance = dtv;
        String expResult = "un_video";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDuracion() {
        System.out.println("getDuracion");
        DtVideo instance = dtv;
        Time expResult = new Time(1,1,1);
        Time result = instance.getDuracion();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFechaPublicacion() {
        System.out.println("getFechaPublicacion");
        DtVideo instance = dtv;
        Date expResult = new Date(190,1,2);
        Date result = instance.getFechaPublicacion();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetUrlVideoOriginal() {
        System.out.println("getUrlVideoOriginal");
        DtVideo instance = dtv;
        String expResult = "https://sdsd.com";
        String result = instance.getUrlVideoOriginal();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPrivacidad() {
        System.out.println("getPrivacidad");
        DtVideo instance = dtv;
        Privacidad expResult = Privacidad.PRIVADO;
        Privacidad result = instance.getPrivacidad();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        DtVideo instance = dtv;
        String expResult = "futbol";
        String result = instance.getCategoria();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCantLikes() {
        System.out.println("getCantLikes");
        DtVideo instance = dtv;
        int expResult = 0;
        int result = instance.getCantLikes();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCantDisLikes() {
        System.out.println("getCantDisLikes");
        DtVideo instance = dtv;
        int expResult = 0;
        int result = instance.getCantDisLikes();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        DtVideo instance = dtv;
        String expResult = "DtVideo{id=2, nombre=video1, descripcion=un_video, duracion=01:01:01, fechaPublicacion=2090-02-02, urlVideoOriginal=https://sdsd.com, privacidad=PRIVADO, categoria=futbol, cantLikes=0, cantDisLikes=0}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
