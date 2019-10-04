package Logica;

import JPAControllerClasses.BusquedaEnBDD;
import Logica.Clases.Canal;
import Logica.Clases.ListaDeReproduccion;
import Logica.Clases.Video;
import Logica.DataType.DtCanal;
import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtVideo;
import Logica.Enumerados.Filtrado;
import Logica.Enumerados.Ordenacion;
import Logica.Interfaces.IAdmin;
import Logica.Interfaces.IUsuario;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatosDePrueba {
    private static IAdmin adminSys = null;
    private static IUsuario usuSys = null;
    
    public static void main(String[] args) {
        probar();
        System.exit(0);
    }
    
    private static void probar(){
        Fabrica f = Fabrica.getInstancia();
        usuSys = f.getIUsuario();
        //CUsuario su = CUsuario.getInstancia();
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("UyTubePU");
            EntityManager manager = factory.createEntityManager();
            /*
            // Prueba de búsqueda por categoría
            for (Object o : new BusquedaEnBDD().buscarPorCategoria("GAMING")){
                if (o.getClass() == DtVideo.class){
                    System.out.println(((DtVideo) o).toString());
                }else if (o.getClass() == DtListaDeReproduccion.class){
                    System.out.println(((DtListaDeReproduccion) o).toString());
                }else if (o.getClass() == DtCanal.class){
                    System.out.println(((DtCanal) o).toString());
                }
            }
            */
            
            /*
            // Prueba de búsqueda general
            for (Object o : new BusquedaEnBDD().buscar("", Filtrado.CANALES, Ordenacion.ALFABETICA_ASCENDENTE)){
                if (o.getClass() == DtVideo.class){
                    System.out.println(((DtVideo) o).toString());
                }else if (o.getClass() == DtListaDeReproduccion.class){
                    System.out.println(((DtListaDeReproduccion) o).toString());
                }else if (o.getClass() == DtCanal.class){
                    System.out.println(((DtCanal) o).toString());
                }
            }
            */
            
            
        } catch (Exception e) {
            System.out.println("//////////////////////////");
            System.out.println(e.getMessage());
            System.out.println("//////////////////////////");
        }
    }
    
}