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
            
        } catch (Exception e) {
            System.out.println("//////////////////////////");
            System.out.println(e.getMessage());
            System.out.println("//////////////////////////");
        }
    }
    private static void mostrarLista(ArrayList<Object> lst){
        // Prueba de búsqueda por categoría
        for (Object o : lst){
            System.out.println("> " + o.toString());
        }
    }
}
