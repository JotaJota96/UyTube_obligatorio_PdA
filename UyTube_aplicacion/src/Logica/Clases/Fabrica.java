
package Logica.Clases;
import Logica.InterfacesYControladores.CAdmin;
import Logica.InterfacesYControladores.IAdmin;

/* Clase Singleton */
public class Fabrica {
    private static Fabrica instancia = null;
    
    private Fabrica(){
        
    }
    
    public static Fabrica getInstancia(){
        if( instancia == null ){
            instancia = new Fabrica();
        }
        return instancia;        
    }
    
    /* Crea una unicia instancia del controlador CAdmin */
    public IAdmin getIAdmin(){
        return CAdmin.getInstancia();
    }
            
}
