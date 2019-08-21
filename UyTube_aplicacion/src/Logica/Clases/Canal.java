package Logica.Clases;

import Logica.Enumerados.Privacidad;
import Logica.DataType.DtComentario;
import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtValoracion;
import Logica.DataType.DtVideo;
import Logica.DataType.DtCanal;
//import java.util.ArrayList;
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
        this.listasDeReproducciones = new TreeMap();
        this.Videos = new TreeMap();
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
public ArrayList<DtValoracion> quitarValoracion(int id, String nickname){
    return new ArrayList();
}
public void agregarModificarValoracion(int id, DtValoracion valoracion, Usuario usuario){}
public void agregarVideo(DtVideo video){}
public void agregarVideoALista(int id, DtVideo video){}
public DtCanal getDT(){
    return new DtCanal(this.id, this.nombre, this.descripcion, this.privacidad);
}


public ArrayList<DtComentario> listarComentariosDeVideo(int id){
    return new ArrayList();
}
public ArrayList<DtListaDeReproduccion> listarListasDeReproduccion(boolean x){
    return new ArrayList();
}
public ArrayList<DtValoracion> listarValoracionesDeVideo(int id){
    return new ArrayList();
}
public ArrayList<DtVideo> listarVideos(){
    return new ArrayList();
}
public ArrayList<DtVideo> listarVideosDeListaDeReproduccion(int id){
    return new ArrayList();
}
public void modificar(DtCanal canal){
        this.nombre = canal.getNombre();
        this.descripcion = canal.getDescripcion();
        this.privacidad = canal.getPrivacidad();
}
public void modificarListaDeReproduccion(DtListaDeReproduccion ldr){
    
}
public void modificarVideo(DtVideo video){} 
public ArrayList<DtListaDeReproduccion> obtenerListasEnCategoria(String cat){
    return new ArrayList();
}
public DtVideo obtenerDtVideo(int id){
    return new DtVideo();
}
public Video obtenerVideo(int id){
    return new Video();
}
public ArrayList<DtVideo> obtenerVideosEnCategoria(String cat){
    return new ArrayList();
}
public void quitarVideoDeListaDeReproduccion(int idLista, int idVideo){}
public boolean validarListaParticular(String lista){
    return false;
}

}

