package Logica.Clases;

import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtVideo;
import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoListaDeReproduccion;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ListaDeReproduccion {
    private static int contadorListasDeReproduccion = 1;
    
    private int id;
    private String nombre;
    private Privacidad privacidad;
    private TipoListaDeReproduccion tipo;
    private String categoria;
    private Map<Integer, Video> misVideos;

    public ListaDeReproduccion() {
        this.id = getNuevoId();
        this.misVideos = new TreeMap();
    }
    
    public ListaDeReproduccion(int id, String nombre, Privacidad privacidad, TipoListaDeReproduccion tipo, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.privacidad = privacidad;
        this.tipo = tipo;
        this.categoria = categoria;
        this.misVideos = new TreeMap();
    }

    public static int getNuevoId() {
        return contadorListasDeReproduccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Privacidad getPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(Privacidad privacidad) {
        this.privacidad = privacidad;
    }

    public TipoListaDeReproduccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoListaDeReproduccion tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ListaDeReproduccion{" + "id=" + id + ", nombre=" + nombre + ", privacidad=" + privacidad + ", tipo=" + tipo + ", categoria=" + categoria + ", misVideos.size=" + misVideos.size() + '}';
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////

    public void agregarVideoA(Video v){
        // agrega el video y su clave a la coleccion
        this.misVideos.put(v.getId(), v);
    }
    
    public DtListaDeReproduccion getDt(){
        // devuelve un DT con los datos de la lista
        return new DtListaDeReproduccion(this.id, this.nombre, this.privacidad, this.tipo, this.categoria);
    }

    public ArrayList<DtVideo> listarVideos(){
        // crea una lista de retorno
        ArrayList<DtVideo> ret = new ArrayList();
        
        // para cada elemento en misVideos
        /**
         * este for no es normal, se declara la variable m que es de tipo
         * Entrada de Map (como un nodo arbol), y autmaticamente la hace avanzar
         * por todas las entradas de la coleccion.
         * De la entrada actual se puede obtener la Key y el Valor almacenado
         */
        for (Map.Entry<Integer, Video> m : misVideos.entrySet()){
            // hace un getDT y lo agrega a la coleccion de retorno
            ret.add(m.getValue().getDt());
        }
        
        return ret;
    }
    
    public void modificar(DtListaDeReproduccion ldr) {
        // se sobreescriben los atributos que pueden ser modificados
        this.nombre = ldr.getNombre();
        this.privacidad = ldr.getPrivacidad();
        this.categoria = ldr.getCategoria();
        // el ID y el tipo de lista no se puede modificar
    }
    
    public void quitarVideo(int idVideo) {
        // remueve de la coleccion el video con la clave idVideo
        this.misVideos.remove(idVideo);
    }
    
}
