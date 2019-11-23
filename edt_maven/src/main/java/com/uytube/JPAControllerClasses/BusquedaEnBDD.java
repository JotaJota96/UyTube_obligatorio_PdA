package com.uytube.JPAControllerClasses;

import com.uytube.Logica.Clases.Canal;
import com.uytube.Logica.Clases.ListaDeReproduccion;
import com.uytube.Logica.Clases.Video;
import com.uytube.Logica.DataType.DtVideo;
import com.uytube.Logica.Enumerados.Filtrado;
import com.uytube.Logica.Enumerados.Ordenacion;
import com.uytube.Logica.Enumerados.TipoListaDeReproduccion;
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
                   q = em.createQuery("SELECT e FROM Canal e WHERE NOT e.eliminado");
                }else{
                   q = em.createQuery("SELECT e FROM Canal e WHERE (UPPER(e.nombre)) LIKE (UPPER(?1)) OR (UPPER(e.descripcion)) LIKE (UPPER(?1)) AND NOT e.eliminado");
                    q.setParameter(1, busqueda);
                }
                ret.addAll(q.getResultList());
            }
            // Busca los Listas de reproduccion
            if (filtro == Filtrado.TODO || filtro == Filtrado.LISTAS_DE_REPRODUCCION){
                if (busqueda == null || busqueda.equals("")){
                   q = em.createQuery("SELECT e FROM ListaDeReproduccion e WHERE e.tipo = ?1 AND NOT e.eliminado");
                    q.setParameter(1, TipoListaDeReproduccion.PARTICULAR);
                }else{
                   q = em.createQuery("SELECT e FROM ListaDeReproduccion e WHERE e.tipo = ?1 AND (UPPER(e.nombre)) LIKE (UPPER(?2)) AND NOT e.eliminado");
                    q.setParameter(1, TipoListaDeReproduccion.PARTICULAR);
                    q.setParameter(2, busqueda);
                }
                ret.addAll(q.getResultList());
            }
            // Busca los Videos
            if (filtro == Filtrado.TODO || filtro == Filtrado.VIDEOS){
                if (busqueda == null || busqueda.equals("")){
                   q = em.createQuery("SELECT e FROM Video e WHERE NOT e.eliminado");
                }else{
                   q = em.createQuery("SELECT e FROM Video e WHERE (UPPER(e.nombre)) LIKE (UPPER(?1)) OR (UPPER(e.descripcion)) LIKE (UPPER(?1)) AND NOT e.eliminado");
                    q.setParameter(1, busqueda);
                }
                ret.addAll(q.getResultList());
            }
            
            // En este punto ret contiene todos los contenidos que contienen la busqueda en su nombre o descripcion
            ArrayList<ParDeObjetos> pares = null;
            ArrayList<ParDeObjetos> paresOrdenados;
            // Asocia los elementos a su nombre o su fecha (segun como se desee ordenar)
            switch (orden){
                case ALFABETICA_ASCENDENTE:
                    pares = nombrarElementos((ArrayList<Object>) ret);
                    break;
                case FECHA_DESCENDENTE:
                    pares = fecharElementos((ArrayList<Object>) ret);
                    break;
            }
            
            // Leido de adentro hacia afuera:
            // se ordena por fecha
            // Se desarma el par de objetos
            // se convierte cada objeto a su DataType
            // retorna el resultado
            return convertirClaseADatatype(
                    ParDeObjetos.extraerElementos(
                            ordenar(pares)
                    )
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
    public ArrayList<Object> buscarPorCategoria(String cat) {
        EntityManager em = getEntityManager();
        List<Object> ret = new ArrayList();
        try {
            Query q;
            // Obtiene los videos en esa categoria
            q = em.createQuery("SELECT e FROM Video e WHERE e.categoria = ?1 AND NOT e.eliminado");
            q.setParameter(1, cat);
            ret.addAll(q.getResultList());
            // obtiene las listas de reproduccion en esa categoria
            q = em.createQuery("SELECT e FROM ListaDeReproduccion e WHERE e.categoria = ?1 AND NOT e.eliminado");
            q.setParameter(1, cat);
            ret.addAll(q.getResultList());
            
            // Leido de adentro hacia afuera:
            // Asocia los elementos a una fecha
            // se ordena por fecha
            // Se desarma el par de objetos
            // se convierte cada objeto a su DataType
            // retorna el resultado
            return convertirClaseADatatype(
                    ParDeObjetos.extraerElementos(
                            ordenar(
                                    fecharElementos(
                                            (ArrayList<Object>) ret
                                    )
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
        // Asocia cada elemento del array recibido con su fecha
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
        // Asocia cada elemento del array recibido con su nombre
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
        // Devuelve el nombre del objeto
        if (o instanceof Canal){
            return ((Canal) o).getNombre();
        }else if (o instanceof ListaDeReproduccion){
            return ((ListaDeReproduccion) o).getNombre();
        }else if (o instanceof Video){
            return ((Video) o).getNombre();
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
        // Por si no se pude determinar la fecha, inicializo con una fecha bien vieja
        java.sql.Date ret = new java.sql.Date(-1900, 0, 1);
        // mas viejo que eso solo puede ser algun video de Mirta Legrant, y no creo que ella use UyTube...
        
        if (o instanceof Canal){
           // si el objeto es un Canal
           // busca la fecha de publicacion mas reciente entre los videos del canal
            ArrayList<DtVideo> videos = ((Canal) o).listarVideos();
            for (DtVideo dtv : videos){
                if (ret == null || dtv.getFechaPublicacion().compareTo(ret) > 0){
                    ret = dtv.getFechaPublicacion();
                }
            }
        }else if (o instanceof ListaDeReproduccion){
           // si el objeto es una ListaDeReproduccion
           // busca la fecha de publicacion mas reciente entre los videos de la lista
            ArrayList<DtVideo> videos = ((ListaDeReproduccion) o).listarVideos();
            for (DtVideo dtv : videos){
                if (ret == null || dtv.getFechaPublicacion().compareTo(ret) > 0){
                    ret = dtv.getFechaPublicacion();
                }
            }
        }else if (o instanceof Video){
           // si el objeto es un Video
           // Devuelve su fecha
            ret = ((Video) o).getFechaPublicacion();
        }
        return ret;
    }
    
    /**
     * Ordena la lista de pares recibida
     * @param lista Lista a ordenar
     * @return Lista ordenada
     */
    public ArrayList<ParDeObjetos> ordenar(ArrayList<ParDeObjetos> lista){
        // Caso base, no hay lista o es vacia
        if (lista == null || lista.isEmpty()){
            return new ArrayList();
        }
        
        // Extrae el primer elemento de la lista
        ParDeObjetos par = lista.remove(0);
        // llama a la recursividad
        ArrayList<ParDeObjetos> listaOrdenada = ordenar(lista);
        
        // Recore la lista ya ordenada por la llamada recursiva 
        // compara cada elemento y para cuando encuentra su lugar
        int i = 0;
        for (; i < listaOrdenada.size(); i++){
            ParDeObjetos p = listaOrdenada.get(i);
            if (comparar(p, par) < 0){
                break;
            }
        }
        // Agrega el elemento al resultado
        listaOrdenada.add(i, par);
        return listaOrdenada;
    }
    
    /**
     * Compara dos pares de objetos
     * Se soportan String o java.sql.Date
     * @param a Primer par a comparar
     * @param b Segundo par a comparar
     * @return 0 si (a == b), -1 si (a < b), 1 si (a > b)
     */
    private int comparar(ParDeObjetos a, ParDeObjetos b){
        // Realiza la comparacion dependiendo del tipo de objeto para comparar
        if (a.getOrderField() instanceof String){
            String str1 = (String) a.getOrderField();
            String str2 = (String) b.getOrderField();
            return (str1.compareToIgnoreCase(str2)) * -1;
        }else if (a.getOrderField() instanceof java.sql.Date){
            java.sql.Date date1 = (java.sql.Date) a.getOrderField();
            java.sql.Date date2 = (java.sql.Date) b.getOrderField();
            return date1.compareTo(date2);
        }
        return 0;
    }
    
    /**
     * Reemplaza los objetos de la lista por sus DataType
     * @param lst Lista con clases Canal, ListaDeReproduccion o Video
     * @return Lista de DtCanal, DtListaDeReproduccion o DtVideo
     */
    private ArrayList<Object> convertirClaseADatatype(ArrayList<Object> lst){
        Object o;
        // Recorre todo el array
        for (int i = 0; i < lst.size(); i++) {
            o = lst.get(i);
            // Castea el objeto para llamar a la funcion .getDT()
            if (o instanceof Canal) {
                lst.set(i, ((Canal)o).getDT());
            } else if (o instanceof ListaDeReproduccion) {
                lst.set(i, ((ListaDeReproduccion)o).getDt());
            } else if (o instanceof Video) {
                lst.set(i, ((Video)o).getDt());
            }
        }
        return lst;
    }
}
