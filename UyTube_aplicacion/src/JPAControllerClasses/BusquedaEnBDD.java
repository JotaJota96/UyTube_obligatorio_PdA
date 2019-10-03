package JPAControllerClasses;

import Logica.Clases.Canal;
import Logica.Clases.ListaDeReproduccion;
import Logica.Clases.ListaDeReproduccion_;
import Logica.Clases.Usuario;
import Logica.Clases.Video;
import Logica.DataType.DtVideo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Persistence;

public class BusquedaEnBDD implements Serializable {
    private EntityManagerFactory emf = null;

    public BusquedaEnBDD() {
        this.emf = Persistence.createEntityManagerFactory(NombreManejador.getNombreManejador());
    }
    public BusquedaEnBDD(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Object> buscarPorCategoria(String cat) {
        EntityManager em = getEntityManager();
        List<Object> ret = new ArrayList();
        try {
            Query q;
            // Obtiene los videos en esa categoria
            q = em.createQuery("SELECT v FROM Video v WHERE v.categoria = ?1");
            q.setParameter(1, cat);
            ret.addAll(q.getResultList());
            // obtiene las listas de reproduccion en esa categoria
            q = em.createQuery("SELECT l FROM ListaDeReproduccion l WHERE l.categoria = ?1");
            q.setParameter(1, cat);
            ret.addAll(q.getResultList());
            
            return ret;
        } finally {
            em.close();
        }
    }
    
    /**
     * Asocia los objetos recibidos a una fecha
     * Canal se asocia a la fecha del video mas reciente
     * Video a su propia fecha
     * ListaDeReproduccion fecha del video con fecha mas reciente
     * @param lista Lista de objetos a ordenar (Canal, Video o ListaDeReproduccion)
     * @return Lista de los objetos recibidos pero asociados a una fecha
     */
    public ArrayList<ParDeObjetos> fecharElementos(ArrayList<Object> lista){
        ArrayList<ParDeObjetos> ret = new ArrayList();
        for (Object o : lista){
            ret.add(new ParDeObjetos(o, ultimaActividad(o)));
        }
        return ret;
    }
    
    /**
     * Devuelve la fecha de la ultima actividad del objeto
     * Canal es la fecha del video mas reciente
     * Video su propia fecha
     * ListaDeReproduccion la fecha del video con fecha mas reciente
     * @param o
     * @return 
     */
    private java.sql.Date ultimaActividad(Object o){
        java.sql.Date ret = null;
        if (o.getClass() == Canal.class){
            Canal c = (Canal) o;
            ArrayList<DtVideo> videos = c.listarVideos();
            for (DtVideo dtv : videos){
                if (ret == null || dtv.getFechaPublicacion().compareTo(ret) > 0){
                    ret = dtv.getFechaPublicacion();
                }
            }
        }else if (o.getClass() == ListaDeReproduccion.class){
            ListaDeReproduccion l = (ListaDeReproduccion) o;
            ArrayList<DtVideo> videos = l.listarVideos();
            for (DtVideo dtv : videos){
                if (ret == null || dtv.getFechaPublicacion().compareTo(ret) > 0){
                    ret = dtv.getFechaPublicacion();
                }
            }
        }else if (o.getClass() == Video.class){
            Video v = (Video) o;
            ret = v.getFechaPublicacion();
        }
        return ret;
    }
    
}
