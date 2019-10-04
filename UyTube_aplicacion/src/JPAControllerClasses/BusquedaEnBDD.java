package JPAControllerClasses;

import Logica.Clases.Canal;
import Logica.Clases.ListaDeReproduccion;
import Logica.Clases.ListaDeReproduccion_;
import Logica.Clases.Usuario;
import Logica.Clases.Video;
import Logica.DataType.DtVideo;
import Logica.Enumerados.Filtrado;
import Logica.Enumerados.Ordenacion;
import Logica.Enumerados.TipoListaDeReproduccion;
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
     * Busca contenido por coincidencia de texto en nombre o descripcion de los
     * contenidos del sistema En el resultado se incluirán (si corresponde segun
     * el filtrado) los videos privados del usuarioActual
     *
     * @param busqueda Texto a buscar (si es vacío incluye todo el contenido)
     * @param filtro Tipo de contenido en el cual se realizará la búsqueda
     * @param orden Manera de ordenar el resultado de la búsqueda
     * @return Resultado de la busqueda. Puede contener DtVideo,
     * DtListaDeReproduccion y/o DtCanal. (para usar los elementos devueltos hay
     * que castearlos)
     */
    public ArrayList<Object> buscar(String busqueda, Filtrado filtro, Ordenacion orden){
        EntityManager em = getEntityManager();
        List<Object> ret = new ArrayList();
        if (busqueda == null || busqueda.equals("")) {
        }else{
            busqueda = "%" + busqueda + "%";
        }
        try {
            Query q;
            // Segun la opcion de filtrado, se obtienen los contenidos que contengan el texto a buscar
            // Busca los Canales
            if (filtro == Filtrado.TODO || filtro == Filtrado.CANALES){
                if (busqueda == null || busqueda.equals("")){
                   q = em.createQuery("SELECT e FROM Canal e");
                }else{
                   q = em.createQuery("SELECT e FROM Canal e WHERE (UPPER(e.nombre)) LIKE (UPPER(?1)) OR (UPPER(e.descripcion)) LIKE (UPPER(?1))");
                    q.setParameter(1, busqueda);
                }
                ret.addAll(q.getResultList());
            }
            // Busca los Listas de reproduccion
            if (filtro == Filtrado.TODO || filtro == Filtrado.LISTAS_DE_REPRODUCCION){
                if (busqueda == null || busqueda.equals("")){
                   q = em.createQuery("SELECT e FROM ListaDeReproduccion e WHERE e.tipo = ?1");
                    q.setParameter(1, TipoListaDeReproduccion.PARTICULAR);
                }else{
                   q = em.createQuery("SELECT e FROM ListaDeReproduccion e WHERE e.tipo = ?1 AND (UPPER(e.nombre)) LIKE (UPPER(?2)) ");
                    q.setParameter(1, TipoListaDeReproduccion.PARTICULAR);
                    q.setParameter(2, busqueda);
                }
                ret.addAll(q.getResultList());
            }
            // Busca los Videos
            if (filtro == Filtrado.TODO || filtro == Filtrado.VIDEOS){
                if (busqueda == null || busqueda.equals("")){
                   q = em.createQuery("SELECT e FROM Video e");
                }else{
                   q = em.createQuery("SELECT e FROM Video e WHERE (UPPER(e.nombre)) LIKE (UPPER(?1)) OR (UPPER(e.descripcion)) LIKE (UPPER(?1))");
                    q.setParameter(1, busqueda);
                }
                ret.addAll(q.getResultList());
            }
            
            // En este punto ret contiene todos los contenidos que contienen la busqueda en su nombre o descripcion
            ArrayList<ParDeObjetos> pares = null;
            ArrayList<ParDeObjetos> paresOrdenados;
            switch (orden){
                case ALFABETICA_ASCENDENTE:
                    pares = nombrarElementos((ArrayList<Object>) ret);
                    break;
                case FECHA_DESCENDENTE:
                    pares = fecharElementos((ArrayList<Object>) ret);
                    break;
            }
            return ParDeObjetos.extraerElementos(
                    ordenar(pares)
            );
        } finally {
            em.close();
        }
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
     * Asocia los objetos recibidos a una fecha
     * Canal se asocia a la fecha del video mas reciente
     * Video a su propia fecha
     * ListaDeReproduccion fecha del video con fecha mas reciente
     * @param lista Lista de objetos a ordenar (Canal, Video o ListaDeReproduccion)
     * @return Lista de los objetos recibidos pero asociados a una fecha
     */
    public ArrayList<ParDeObjetos> nombrarElementos(ArrayList<Object> lista){
        ArrayList<ParDeObjetos> ret = new ArrayList();
        for (Object o : lista){
            ret.add(new ParDeObjetos(o, nombreParaOrdenar(o)));
        }
        return ret;
    }
    
    /**
     * Devuelve el nombre del objeto
     * Canal su nombre
     * Video su nombre
     * ListaDeReproduccion su nombre
     * @param o Objeto a dar nombre
     * @return Nombre del objeto
     */
    private String nombreParaOrdenar(Object o){
        java.sql.Date ret = null;
        if (o.getClass() == Canal.class){
            Canal c = (Canal) o;
            return c.getNombre();
        }else if (o.getClass() == ListaDeReproduccion.class){
            ListaDeReproduccion l = (ListaDeReproduccion) o;
            return l.getNombre();
        }else if (o.getClass() == Video.class){
            Video v = (Video) o;
            return v.getNombre();
        }
        return "";
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
            return (str1.compareToIgnoreCase(str2)) * -1;
        }else if (a.getOrderField().getClass() == java.sql.Date.class){
            java.sql.Date date1 = (java.sql.Date) a.getOrderField();
            java.sql.Date date2 = (java.sql.Date) b.getOrderField();
            return date1.compareTo(date2);
        }
        return 0;
    }
    
}
