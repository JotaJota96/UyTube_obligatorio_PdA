package Logica;

import Logica.Controladores.CAdmin;
import Logica.Controladores.CUsuario;
import Logica.Interfaces.IAdmin;
import Logica.Interfaces.IUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.Endpoint;


/* Clase Singleton */
public class Fabrica {
    public static void main(String[] args) {
        try {
            getInstancia().publicarWebService();
            System.out.println("Servicio OK");
        } catch (Exception ex) {
            Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static Fabrica instancia = null;

    private Fabrica() {
    }

    /**
     * Crea una unicia instancia de Fabrica
     *
     * @return instancia de Fabrica
     */
    public static Fabrica getInstancia() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }

    /**
     * Crea una unicia instancia del controlador IAdmin
     *
     * @return instancia del controlador IAdmin
     */
    public IAdmin getIAdmin() {
        return CAdmin.getInstancia();
    }

    /**
     * Crea una unicia instancia del controlador IUsuario
     *
     * @return instancia del controlador IUsuario
     */
    public IUsuario getIUsuario() {
        return CUsuario.getInstancia();
    }

    /**
     * Publica el Web Service de la interfaz de usuario IUsuario
     *
     * @return URL en la que se publica el servicio
     * @throws java.lang.Exception
     */
    public String publicarWebService() throws Exception {
        // url en la cual se publicara el Web Service
        String url = "http://localhost:9789/UyTube_ws";
        // publica en la URL la instancia de IUsuario obtenida
        Endpoint.publish(url, this.getIUsuario());
        return url;
    }

}
