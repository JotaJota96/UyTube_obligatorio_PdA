package Logica;

import Logica.Clases.Usuario;
import Logica.Controladores.CAdmin;
import Logica.Controladores.CUsuario;
import Logica.Interfaces.IAdmin;
import Logica.DataType.*;
import Logica.Enumerados.*;
import Logica.Interfaces.IUsuario;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Map;
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
            
            
            
            
            /**
             *  Escriba aqui el codigo de la prueba que quiera realizar...
             */
            
        } catch (Exception e) {
            System.out.println("//////////////////////////");
            System.out.println(e.getMessage());
            System.out.println("//////////////////////////");
        }
    }
    
}