package Presentacion;

import Logica.Clases.Canal;
import Logica.Clases.Usuario;
import Logica.Clases.Video;
import Logica.DataType.DtCanal;
import Logica.DataType.DtComentario;
import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtUsuario;
import Logica.Enumerados.Privacidad;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Pryevas {
    
    public static void main(String[] args) {
        
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        
        try {
            factory = Persistence.createEntityManagerFactory("UyTubePU");
            manager = factory.createEntityManager();
            
        } catch (Exception e) {
            System.out.println("//////////////////////////");
            System.out.println(e.getMessage());
            System.out.println("//////////////////////////");
        }
        
    }
}
