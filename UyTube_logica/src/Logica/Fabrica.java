package Logica;

import Logica.Controladores.CAdmin;
import Logica.Controladores.CPersistenciaDeImagenes;
import Logica.Controladores.CUsuario;
import Logica.Interfaces.IAdmin;
import Logica.Interfaces.IPersistenciaDeImagenes;
import Logica.Interfaces.IUsuario;


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
    
    /* Crea una unicia instancia del controlador CUsuario */
    public IUsuario getIUsuario(){
        return CUsuario.getInstancia();
    }
    
    /* Crea una unicia instancia del controlador CPersistenciaDeImagenes */
    public IPersistenciaDeImagenes getIPersistenciaDeImagenes(){
        return CPersistenciaDeImagenes.getInstancia();
    }
}
