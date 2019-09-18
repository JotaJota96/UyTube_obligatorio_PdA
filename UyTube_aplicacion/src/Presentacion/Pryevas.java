package Presentacion;

import Logica.Clases.Canal;
import Logica.Clases.Usuario;
import Logica.Clases.Video;
import Logica.DataType.DtCanal;
import Logica.DataType.DtComentario;
import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtUsuario;
import Logica.DataType.DtVideo;
import Logica.Enumerados.Privacidad;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Pryevas {
    
    public static void main(String[] args) {
        
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("UyTubePU");
            EntityManager manager = factory.createEntityManager();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(
                    "Ocurrió un error al conectar con la base de datos" + "\n" +
                    "Es posible que la información no haya sido almacenada");
        }

    }
}
