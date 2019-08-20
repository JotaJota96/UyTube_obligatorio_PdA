package Logica.Clases;
import Logica.Enumerados.Privacidad;
import Logica.DataType.DtComentario;
import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtValoracion;
import Logica.DataType.DtVideo;
import Logica.DataType.DtCanal;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Canal {
    private static int contadorCanal = 1;
    private int id;
    private String nombre;
    private String descripcion;
    private Privacidad privacidad;
    private Map<Integer,ListaDeReproduccion> listasDeReproducciones;
    private Map<Integer,Video> Videos;
    
    
    public Canal() {
        this.id = getNuevoId();
    }
    public Canal(int id, String nombre, String descripcion, Privacidad privacidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.privacidad = privacidad;
        this.listasDeReproducciones = new TreeMap();
        this.Videos = new TreeMap();

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Privacidad getPrivacidad() {
        return privacidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrivacidad(Privacidad privacidad) {
        this.privacidad = privacidad;
    }

 public static int getNuevoId(){
     return contadorCanal++;
 }
public void actualizarListasPorDefecto(){}
public void agregarComentarioAVideo(int id, DtComentario comentario, int idUsuario){}
public void agregarComentarioAVideo(int id, int idComentario, DtComentario comentario, int idUsuario){}
public void agregarListaParticular(DtListaDeReproduccion listaReproduccion){}
//public DtValoracion agregarModificarValoracion(int id, string nickname){}
public void agregarValoracionAVideo(int id, DtValoracion valoracion, int idUsuario){}
public void agregarVideo(DtVideo video){}
public void agregarVideoALista(int id, DtVideo video){}
//public DtCanal getDT(){}

//public ArrayList<DtComentario> listarComentariosDeVideo(int id){}
//public ArrayList<DtListaDeReproduccion> listarListasDeReproduccion(bool x){}
//public ArrayList<DtValoracion> listarValoracionesDeVideo(int id){}
//public ArrayList<DtVideo> listarVideos(){}
//public ArrayList<DtVideo> listarVideosDeListaDeReproduccion(int id){}
public void modificar(DtCanal canal){}
public void modificarListaDeReproduccion(DtListaDeReproduccion listaDeReproduccion){}
public void modificarVideo(DtVideo video){} 
//public ArrayList<DtListaDeReproduccion> obtenerListasEnCategoria(string cat){}
//public DtVideo obtenerVideo(int id){}
//public DtVideo obtenerVideo(int id){}
//public ArrayList<DtVideo> obtenerVideosEnCategoria(string cat){}
public void quitarVideoDeListaDeReproduccion(int idLista, int idVideo){}
//public bool validarListaParticular(string lista){}

}

