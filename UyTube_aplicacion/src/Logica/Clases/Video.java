package Logica.Clases;
import Logica.DataType.DtComentario;
import Logica.DataType.DtValoracion;
import Logica.DataType.DtVideo;
import java.sql.Time;
import java.sql.Date;
import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoValoracion;
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
        if( _id < 0){ throw new RuntimeException("Error, el id del video es un negativo o cero."); }
        if( _nombre == ""){ throw new RuntimeException("Error, el nombre del video está vacío");}
         if( _descripcion == ""){ throw new RuntimeException("Error, la descripción del video está vacía.");}
        if( _duracion == null){ throw new RuntimeException("Error, la duración del video es null.");}
        if( _fechaPublicacion == null){ throw new RuntimeException("Error, la fecha de publicación del video es null.");}
        if( _urlVideoOriginal == ""){ throw new RuntimeException("Error, la url del video está vacía.");}
        if( _categoria == "" ){ throw new RuntimeException("Error, la categoría del video está vacía.");}
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
        if (dtComentario == null){
            throw new RuntimeException("El DataType es null");
        }
        if (usuario == null){
            throw new RuntimeException("El usuario es null");
        }
        
        int nuevoId = Comentario.getNuevoID();
        Comentario nuevoComentario = new Comentario(nuevoId, dtComentario.getFecha(), dtComentario.getTexto(), 0, usuario);
        comentarios.put(nuevoId, nuevoComentario);
    }
    
    /*  Agregar un subcomentario a un comentario existente  */
    public void agregarComentario(int idCom, DtComentario dtComentario, Usuario usuario){
        if (dtComentario == null){
            throw new RuntimeException("El DataType es null");
        }
        if (usuario == null){
            throw new RuntimeException("El usuario es null");
        }
        
        for (Map.Entry<Integer, Comentario> coment : comentarios.entrySet()) {
            if(coment.getValue().agregarSubComentario(idCom, dtComentario, usuario)){
                break;
            }
        }
    }
    
    /* Agrega o midifica una valoración */
    public void agregarModificarValoracion(DtValoracion dtValoracion, Usuario usuario) {
        if (dtValoracion == null) {
            throw new RuntimeException("El DataType es null");
        }
        if (usuario == null){
            throw new RuntimeException("El usuario es null");
        }
        
        String nickname = usuario.getNickname();
        // por las dudas, para que los contadores de likes no queden inconsistentes:
        // obtengo la valoracion que le habia dado antes el usuario (si es que lo habia alorado)
        DtValoracion dtv = this.obtenerValoracion(nickname);
        // si el usuario ya lo valoro
        if (dtv != null) {
            // segun cual fuera la valoracion anterior, resta 1 al contador
            if (dtv.getVal() == TipoValoracion.LIKE) {
                cantLikes--;
            } else {
                cantDisLikes--;
            }

            for (Valoracion val : valoraciones) {
                if (val.modificar(dtValoracion, nickname)) {
                    break;
                }
            }
        } else {
            Valoracion nuevaValoracion = new Valoracion(dtValoracion.getVal(), usuario);
            valoraciones.add(nuevaValoracion);
        }

        // segun cual sea la nueva valoracion, suma 1 al contador
        if (dtValoracion.getVal() == TipoValoracion.LIKE) {
            cantLikes++;
        } else {
            cantDisLikes++;
        }

    }

    public DtVideo getDt(){
        return new DtVideo(this.id, this.nombre, this.descripcion, this.duracion, this.fechaPublicacion, this.urlVideoOriginal, this.privacidad, this.categoria, this.cantLikes, this.cantDisLikes);
    }
    
    public ArrayList<DtComentario> listarComentarios(){
        ArrayList<DtComentario> listaComent = new ArrayList<DtComentario>();
        // recorro los comentarios sobre el video
        for (Map.Entry<Integer, Comentario> coment : comentarios.entrySet()) {
            // le obtengo el DT y lo agrego a la lista resultado
            listaComent.add(coment.getValue().getDT());
            // agrego a la lista resultado, la lista de sub comentarios
            listaComent.addAll(coment.getValue().listarSubComentarios());
        }
        return listaComent;
    }
   
    public ArrayList<DtValoracion> listarValoraciones(){
        ArrayList<DtValoracion> listaValoraciones = new ArrayList();
        // recorre todo el array de valoraciones
        for(int i = 0; i < this.valoraciones.size(); i++){
            // para cada elemento le pide el DT (al llamar esa funcion es que hace el new) y lo agrega a la coleccion de retorno
            listaValoraciones.add(this.valoraciones.get(i).getDT());
        }
        return listaValoraciones;
    }
    
    public void modificar(DtVideo dtVideo){
        if(dtVideo == null){
            throw new RuntimeException("El DtVideo es vacío");
        }
        // Perdon julio pero no entendi nada xD
        
        if(dtVideo.getNombre()== ""){
            throw new RuntimeException("El nombre no puede ser vacío");
        } 
        
        if (dtVideo.getDuracion()== null) {
            throw new RuntimeException("La duracion no puede ser vacía");
        }
        
        if (dtVideo.getFechaPublicacion() == null) {
            throw new RuntimeException("La fecha no puede ser vacía");
        }
        
        if (dtVideo.getCategoria() == "") {
            throw new RuntimeException("La categoria no puede ser vacía");
        }
        
        this.nombre = dtVideo.getNombre();
        this.descripcion = dtVideo.getDescripcion();
        this.duracion = dtVideo.getDuracion();
        this.fechaPublicacion = dtVideo.getFechaPublicacion();
        this.privacidad = dtVideo.getPrivacidad();
        this.categoria = dtVideo.getCategoria();
        
    }
    
    /*   Obtiene la valoracion que hizo un usuario */
    public DtValoracion obtenerValoracion(String nickname) {
        if (nickname.equals("")) {
            throw new RuntimeException("El nickname no puede ser vacio");
        }
        for(int i = 0; i < this.valoraciones.size(); i++){
            if( valoraciones.get(i).getNicknameDeUsuario() == nickname){
                return valoraciones.get(i).getDT();
            }
        }
        return null;
    }
    
    public void quitarValoracion(String nickname){
        if (nickname.equals("")){
            throw new RuntimeException("El nickname no puede ser vacio");
        }
        // Recorrer todas las valoraciones hasta encontrar la valoracion cuyo usuario sea el que tiene ese nickname
        // cuando la encuentre, la saca de la coleccion

        for(int i = 0; i < this.valoraciones.size(); i++){
            if(valoraciones.get(i).getNicknameDeUsuario().equals(nickname) ){

                // segun cual fuera la valoracion anterior, resta 1 al contador
                if (valoraciones.get(i).getVal() == TipoValoracion.LIKE) {
                    cantLikes--;
                } else {
                    cantDisLikes--;
                }
                
                // remueve de la coleccion
                valoraciones.remove(i);
                break;
            }

        }
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
