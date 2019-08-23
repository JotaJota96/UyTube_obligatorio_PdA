
package Logica.Clases;

/* Clase Singleton */
public class Fabrica {
    private static Fabrica instancia;
    
    private Fabrica(){
        
    }
    
    public static Fabrica getInstancia(){
        if( instancia == null ){
            instancia = new Fabrica();
        }
        return instancia;        
    }
            
}
