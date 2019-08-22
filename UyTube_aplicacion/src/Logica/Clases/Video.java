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
    private ArrayList<Valoracion> valoraciones;
    private Map<Integer, Comentario> comentarios;
    private static int idActual = 1;
    
    public Video(){
        
    }
    /********************** Constructor *********************/
    public Video(int _id, String _nombre, String _descripcion,Time _duracion, Date _fechaPublicacion,String _urlVideoOriginal,String _categoria ){
        this.id = _id;
        this.nombre = _nombre;
        this.descripcion = _descripcion;
        this.duracion = _duracion;
        this.fechaPublicacion = _fechaPublicacion;
        this.urlVideoOriginal = _urlVideoOriginal;    
        this.categoria = _categoria;
        this.valoraciones = new ArrayList<Valoracion>();
        this.comentarios = new TreeMap<Integer, Comentario>();        
    }
    
    /** Agregar un nuevo comentario **/
    public void agregarComentario(DtComentario dtComentario, Usuario usuario){
        int nuevoId = Comentario.getNuevoID();
        Comentario nuevoComentario = new Comentario(nuevoId, dtComentario.getFecha(), dtComentario.getTexto(), 0, usuario);
        comentarios.put(nuevoId, nuevoComentario);
    }
    
    /*  Agregar un subcomentario a un comentario existente  */
    public void agregarComentario(int idCom, DtComentario dtComentario, Usuario usuario){
        for (Map.Entry<Integer, Comentario> coment : comentarios.entrySet()) {
            if(coment.getValue().agregarSubComentario(idCom, dtComentario, usuario)){
                break;
            }
        }
    }
    
    /* Agrega o midifica una valoración */
    public void agregarModificarValoracion(DtValoracion dtValoracion, Usuario usuario){
        String nickname = usuario.getNickname();
        for(Valoracion val: valoraciones){
            if(val.modificar(dtValoracion, nickname)){
                break;
            }
        }
    }
    
    public DtVideo getDt(){
        return new DtVideo(this.id, this.nombre, this.descripcion, this.duracion, this.fechaPublicacion, this.urlVideoOriginal, this.privacidad, this.categoria, this.cantLikes, this.cantDisLikes);
    }
    
    public ArrayList<DtComentario> listarComentarios(){
        ArrayList<DtComentario> listaComent = new ArrayList<DtComentario>();        
        for (Map.Entry<Integer, Comentario> coment : comentarios.entrySet()) {            
            DtComentario dtComent = new DtComentario(coment.getValue().getId(), coment.getValue().getUsr().getNickname(), coment.getValue().getFecha(), coment.getValue().getTexto(), coment.getValue().getNivelSubComentario());
            listaComent.add(dtComent);            
        }
        return listaComent;
    }
   
    public ArrayList<DtValoracion> listarValoraciones(){
        // provisorio
        return new ArrayList();
        
    }
    
    public void modificar(DtVideo dtVideo){
        
    }
    
    /*   Sin terminar */
    public DtValoracion obtenerValoracion(String nickname){
        return new DtValoracion();
    }
    
    public static int getNuevoId(){
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

    @Override
    public String toString() {
        return "Video{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", duracion=" + duracion + ", fechaPublicacion=" + fechaPublicacion + ", urlVideoOriginal=" + urlVideoOriginal + ", privacidad=" + privacidad + ", categoria=" + categoria + ", cantLikes=" + cantLikes + ", cantDisLikes=" + cantDisLikes + '}';
    }
    
    
    

}
