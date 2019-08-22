package Logica.Clases;

import Logica.Enumerados.Privacidad;
import Logica.DataType.DtComentario;
import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtValoracion;
import Logica.DataType.DtVideo;
import Logica.DataType.DtCanal;
import Logica.Enumerados.TipoListaDeReproduccion;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Canal {
    
    private static int contadorCanal = 1;
    private int id;
    private String nombre;
    private String descripcion;
    private Privacidad privacidad;
    private Map<Integer,ListaDeReproduccion> misListas;
    private Map<Integer,Video> misVideos;
    
    
    public Canal() {
        this.id = getNuevoId();
        this.misListas = new TreeMap();
        this.misVideos = new TreeMap();
    }
    
    public Canal(int id, String nombre, String descripcion, Privacidad privacidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.privacidad = privacidad;
        this.misListas = new TreeMap();
        this.misVideos = new TreeMap();

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
    public void actualizarListasPorDefecto(){
    
    }

    public void agregarComentarioAVideo(int id, DtComentario comentario, Usuario usuario){
        this.misVideos.get(id).agregarComentario(comentario, usuario);
    }
    
    public void agregarComentarioAVideo(int id, int idComentario, DtComentario comentario, Usuario usuario){
        this.misVideos.get(id).agregarComentario(idComentario, comentario, usuario);
    }
    
    public void agregarListaParticular(DtListaDeReproduccion listaReproduccion){
        int id = ListaDeReproduccion.getNuevoId();
        ListaDeReproduccion ldr = new ListaDeReproduccion(id, listaReproduccion.getNombre(), listaReproduccion.getPrivacidad(),listaReproduccion.getTipo(), listaReproduccion.getCategoria());
        this.misListas.put(id, ldr);
    }
    
    public void quitarValoracion(int id, String nickname){

    }
    
    public void agregarModificarValoracion(int id, DtValoracion valoracion, Usuario usuario){
        this.misVideos.get(id).agregarModificarValoracion(valoracion, usuario);
    }
    
    public void agregarVideo(DtVideo video){
        int id = Video.getNuevoId();
        Video vd = new Video(id, video.getNombre(), video.getDescripcion(), video.getDuracion(), video.getFechaPublicacion(), video.getUrlVideoOriginal(), video.getCategoria());
        this.misVideos.put(id, vd);
    }
    
    public void agregarVideoALista(int id, Video video){
        this.misListas.get(video.getId()).agregarVideoA(video);
    }

    public DtCanal getDT(){
        return new DtCanal(this.id, this.nombre, this.descripcion, this.privacidad);
    }

    public ArrayList<DtComentario> listarComentariosDeVideo(int id){
        return this.misVideos.get(id).listarComentarios();
    }

    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccion(boolean x){
         ArrayList<DtListaDeReproduccion> ret = new ArrayList();

            // para cada elemento en misVideos
            /**
             * este for no es normal, se declara la variable m que es de tipo
             * Entrada de Map (como un nodo arbol), y autmaticamente la hace avanzar
             * por todas las entradas de la coleccion.
             * De la entrada actual se puede obtener la Key y el Valor almacenado
             */
            for (Map.Entry<Integer, ListaDeReproduccion> m : misListas.entrySet()){
                // hace un getDT y lo agrega a la coleccion de retorno
                ret.add(m.getValue().getDt());
            }

            return ret;
    }
    
    public ArrayList<DtValoracion> listarValoracionesDeVideo(int id){
            return this.misVideos.get(id).listarValoraciones();

    }
    
    public ArrayList<DtVideo> listarVideos(){
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

    public ArrayList<DtVideo> listarVideosDeListaDeReproduccion(int id){
        return this.misListas.get(id).listarVideos();
    }
    
    public void modificar(DtCanal canal){
            this.nombre = canal.getNombre();
            this.descripcion = canal.getDescripcion();
            this.privacidad = canal.getPrivacidad();
    }
    
    public void modificarListaDeReproduccion(DtListaDeReproduccion ldr){
            this.misListas.get(ldr.getId()).modificar(ldr);
    }

    public void modificarVideo(DtVideo video){

    } 

    public ArrayList<DtListaDeReproduccion> obtenerListasEnCategoria(String cat){
        return new ArrayList();
    }
    
    public DtVideo obtenerDtVideo(int id){
        return this.misVideos.get(id).getDt();
    }
    public Video obtenerVideo(int id){
        return null;
    }
    
    public ArrayList<DtVideo> obtenerVideosEnCategoria(String cat){
        return new ArrayList();
    }
    
    public void quitarVideoDeListaDeReproduccion(int idLista, int idVideo){
        
    }
    
    public boolean validarListaParticular(String lista){
        return false;
    }

}