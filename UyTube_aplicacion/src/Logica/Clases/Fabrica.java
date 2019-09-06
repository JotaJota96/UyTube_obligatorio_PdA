
package Logica.Clases;
import Logica.Controladores.CAdmin;
import Logica.Interfaces.IAdmin;

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
