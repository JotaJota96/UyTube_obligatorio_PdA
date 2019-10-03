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
    
    /**
     * Devuelve un listado de Video y ListaDeReproduccion que pertenezcan ala
     * categoria indicada, ordenado por fecha de actividasd reciente
     * @param cat Categoria a buscar
     * @return Lista ordenada Video y ListaDeReproduccion
     */
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
            
            return ParDeObjetos.extraerElementos(
                    ordenar(
                            fecharElementos(
                                    (ArrayList<Object>) ret
                            )
                    )
            );
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
    
    /**
     * Ordena la lista de pares recibida
     * @param lista Lista a ordenar
     * @return Lista ordenada
     */
    public ArrayList<ParDeObjetos> ordenar(ArrayList<ParDeObjetos> lista){
        if (lista == null || lista.isEmpty()){
            return new ArrayList();
        }
        
        ParDeObjetos par = lista.remove(0);
        ArrayList<ParDeObjetos> listaOrdenada = ordenar(lista);
        
        int i = 0;
        for (; i < listaOrdenada.size(); i++){
            ParDeObjetos p = listaOrdenada.get(i);
            if (comparar(p, par) < 0){
                break;
            }
        }
        listaOrdenada.add(i, par);
        return listaOrdenada;
    }
    
    /**
     * Compara dos pares de objetos
     * @param a Primer par a comparar
     * @param b Segundo par a comparar
     * @return 0 si (a == b), -1 si (a < b), 1 si (a > b)
     */
    private int comparar(ParDeObjetos a, ParDeObjetos b){
        if (a.getOrderField().getClass() == String.class){
            String str1 = (String) a.getOrderField();
            String str2 = (String) b.getOrderField();
            return str1.compareToIgnoreCase(str2);
        }else if (a.getOrderField().getClass() == java.sql.Date.class){
            java.sql.Date date1 = (java.sql.Date) a.getOrderField();
            java.sql.Date date2 = (java.sql.Date) b.getOrderField();
            return date1.compareTo(date2);
        }
        return 0;
    }
    
}
