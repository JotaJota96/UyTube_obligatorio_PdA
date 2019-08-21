package Logica.Clases;
import Logica.DataType.DtComentario;
import Logica.DataType.DtValoracion;
import Logica.DataType.DtVideo;
import java.sql.Time;
import java.sql.Date;
import Logica.Enumerados.Privacidad;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Video {
    
    private int id;
    private String nombre;
    private String descripcion;
    private Time duracion;
    private Date fechaPublicacion;
    private String urlVideoOriginal;
    private Privacidad privacidad = Privacidad.PRIVADO;
    private String categoria;
    private int cantLikes = 0;
    private int cantDisLikes = 0;
    private Map<Integer, Valoracion> valoraciones;
    private Map<Integer, Comentario> comentarios;
    private static int idActual = 1;
    
    /********************** Constructor *********************/
    public Video(int _id, String _nombre, String _descripcion,Time _duracion, Date _fechaPublicacion,String _urlVideoOriginal,String _categoria ){
        this.id = _id;
        this.nombre = _nombre;
        this.descripcion = _descripcion;
        this.duracion = _duracion;
        this.fechaPublicacion = _fechaPublicacion;
        this.urlVideoOriginal = _urlVideoOriginal;    
        this.categoria = _categoria;
        this.valoraciones = new TreeMap<Integer, Valoracion>();
        this.comentarios = new TreeMap<Integer, Comentario>();        
    }
    
    public void agregarComentario(DtComentario dtComentario, Usuario usuario){
        
    }
    
    public void agregarComentario(int idCom, DtComentario dtComentario, Usuario usuario){
        
    }
    
    public void agregarModificarValoracion(DtValoracion dtValoracion, Usuario usuario){
        
    }
    
    public DtVideo getDtVideo(){
        
        
    }
    
    public ArrayList<DtComentario> listarComentarios(){
        
    }
   
    public ArrayList<DtValoracion> listarValoraciones(){
        
    }
    
    public void modificar(DtVideo dtVideo){
        
    }
    
    public DtValoracion obtenerValoracion(String nickname){
        
    }
    
    public static int obtenerNuevoId(){
        int nuevoId = idActual ++;
        return nuevoId;        
    }
    
//============================  Get and Set ================================
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getUrlVideoOriginal() {
        return urlVideoOriginal;
    }

    public void setUrlVideoOriginal(String urlVideoOriginal) {
        this.urlVideoOriginal = urlVideoOriginal;
    }

    public Privacidad getPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(Privacidad privacidad) {
        this.privacidad = privacidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantLikes() {
        return cantLikes;
    }

    public void setCantLikes(int cantLikes) {
        this.cantLikes = cantLikes;
    }

    public int getCantDisLikes() {
        return cantDisLikes;
    }

    public void setCantDisLikes(int cantDisLikes) {
        this.cantDisLikes = cantDisLikes;
    }
    
    
    

}
