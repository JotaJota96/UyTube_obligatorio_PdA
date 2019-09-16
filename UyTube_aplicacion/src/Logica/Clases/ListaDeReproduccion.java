package Logica.Clases;

import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtVideo;
import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoListaDeReproduccion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lista_de_reproduccion")
public class ListaDeReproduccion {
    private static int contadorListasDeReproduccion = 1;
    
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "privacidad")
    private Privacidad privacidad;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoListaDeReproduccion tipo;
    
    @Column(name = "categoria")
    private String categoria;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "videos_en_listas",
            joinColumns = @JoinColumn(name = "id_lista"),
            inverseJoinColumns = @JoinColumn(name = "id_video"))
    private Map<Integer, Video> misVideos;
    
    //-----------------------------------------------------------------------------
    public ListaDeReproduccion() {
    }

    public ListaDeReproduccion(int id, String nombre, Privacidad privacidad, TipoListaDeReproduccion tipo, String categoria) {
        if (nombre.equals("")){
            throw new RuntimeException("El nombre de la lista de reproduccion no puede ser vacio");
        }
        if (categoria.equals("")){
            throw new RuntimeException("La Categoria de la lista de reproduccion no puede ser vacia");
        }
        if (tipo == TipoListaDeReproduccion.POR_DEFECTO && privacidad != Privacidad.PRIVADO){
            throw new RuntimeException("No se puede crear una lista de reproduccion por defecto publica");
        }
        if (tipo == TipoListaDeReproduccion.POR_DEFECTO && !categoria.equals("UNDEFINED")){
            throw new RuntimeException("No se puede crear una lista de reproduccion por defecto en una categoria");
        }
        this.id = id;
        this.nombre = nombre;
        this.privacidad = privacidad;
        this.tipo = tipo;
        this.categoria = categoria;
        this.misVideos = new TreeMap();
    }

    public static int getNuevoId() {
        return contadorListasDeReproduccion++;
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
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

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "ListaDeReproduccion{" + "id=" + id + ", nombre=" + nombre + ", privacidad=" + privacidad + ", tipo=" + tipo + ", categoria=" + categoria + ", misVideos.size=" + misVideos.size() + '}';
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////

    public void agregarVideoA(Video v){
        if (v == null){
            throw new RuntimeException("El video recibido para agregar a la lista es NULL");
        }
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
        if (this.tipo == TipoListaDeReproduccion.POR_DEFECTO){
            throw new RuntimeException("No se puede modificar una lista por defecto");
        }
        if (ldr == null){
            throw new RuntimeException("El DataTyppe recibido para modificar la lista de reproduccion es NULL");
        }
        if (ldr.getNombre().equals("")){
            throw new RuntimeException("El nombre de la lista de reproduccion no puede ser vacio");
        }
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
