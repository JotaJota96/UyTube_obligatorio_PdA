package Presentacion;

import JPAControllerClasses.ComentarioJpaController;
import JPAControllerClasses.VideoJpaController;
import Logica.Clases.Canal;
import Logica.Clases.Comentario;
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
            
            
            
            /*
            manager.getTransaction().begin();
            Usuario usu = manager.find(Usuario.class, "camilillo15");
            Video vid = manager.find(Video.class, 18);
            manager.getTransaction().commit();
            
            vid.agregarComentario(
                    new DtComentario(0, "", new Date(90, 5, 5), "texto", 0), 
                    usu
            );
            new VideoJpaController().edit(vid);
            
            */
            
            
            //Comentario c = new Comentario(0, new Date(90, 5, 5), "texto", 0, usu);
            //new ComentarioJpaController().create(c);
            
        } catch (Exception e) {
            System.out.println("*************************************************");
            System.out.println(e.getMessage());
            System.out.println("*************************************************");
        }

    }
}
