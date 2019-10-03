package Logica;

import JPAControllerClasses.BusquedaEnBDD;
import Logica.Clases.ListaDeReproduccion;
import Logica.Clases.Video;
import Logica.Interfaces.IAdmin;
import Logica.Interfaces.IUsuario;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * Esta clase fue hecha para cargar datos de prueba en el sistema
 * @author Juan
 */
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
            for (Object o : new BusquedaEnBDD().buscarPorCategoria("MUSICA")){
                if (o.getClass() == Video.class){
                    Video i = (Video) o;
                    System.out.println(i.getNombre());
                }else if (o.getClass() == ListaDeReproduccion.class){
                    ListaDeReproduccion i = (ListaDeReproduccion) o;
                    System.out.println(i.getNombre());
                }
                
                
                
            }
            */
            
            
            
            
            
            for (Object o : new BusquedaEnBDD().buscarPorCategoria("MUSICA")){
                if (o.getClass() == Video.class){
                    Video i = (Video) o;
                    System.out.println(i.getNombre());
                }else if (o.getClass() == ListaDeReproduccion.class){
                    ListaDeReproduccion i = (ListaDeReproduccion) o;
                    System.out.println(i.getNombre());
                }
            }
            
            
            
        } catch (Exception e) {
            System.out.println("//////////////////////////");
            System.out.println(e.getMessage());
            System.out.println("//////////////////////////");
        }
    }
    
    
    
    /**
     * Busca contenido por coincidencia de texto en nombre o descripcion de los
     * contenidos del sistema que pertenezcan a la categoria indicada
     *
     * @param categoria Nombre de la categoria a buscar
     * @return Resultado de la busqueda. Puede contener DtVideo y
     * DtListaDeReproduccion. (para usar los elementos devueltos hay que
     * castearlos)
     */
    public static ArrayList<Object> buscar(String categoria){
        return null;
    }
    
    
    
}