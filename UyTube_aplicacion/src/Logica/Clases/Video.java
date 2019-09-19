package Logica.Clases;
import JPAControllerClasses.ComentarioJpaController;
import JPAControllerClasses.ValoracionJpaController;
import Logica.DataType.DtComentario;
import Logica.DataType.DtValoracion;
import Logica.DataType.DtVideo;
import java.sql.Time;
import java.sql.Date;
import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoValoracion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public class Video implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Basic
    @Column(name = "duracion")
    private Time duracion;
    
    @Basic
    @Column(name = "fecha_publicacion")
    private Date fechaPublicacion;
    
    
    @Column(name = "url")
    private String urlVideoOriginal;
    
    @Enumerated(EnumType.STRING)
    private Privacidad privacidad = Privacidad.PRIVADO;
    
    
    @Column(name = "categoria")
    private String categoria;
    
    
    @Column(name = "cant_likes")
    private int cantLikes = 0;
    
    
    @Column(name = "cant_dislikes")
    private int cantDisLikes = 0;
    
    @Column(name = "eliminado")
    private boolean eliminado;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_video")
    private List<Valoracion> valoraciones;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_video")
    @MapKey(name = "id")
    private Map<Integer, Comentario> comentarios;
    
    //------------------------------------------------------------------------
    public Video(){
        
    }
    /********************** Constructor *********************/
    public Video(int _id, String _nombre, String _descripcion,Time _duracion, Date _fechaPublicacion,String _urlVideoOriginal,String _categoria ){
        if (_nombre == "") {
            throw new RuntimeException("Error, el nombre del video está vacío");
        }
        if (_duracion == null) {
            throw new RuntimeException("Error, la duración del video es null.");
        }
        if (_fechaPublicacion == null) {
            throw new RuntimeException("Error, la fecha de publicación del video es null.");
        }
        if (_urlVideoOriginal == "") {
            throw new RuntimeException("Error, la url del video está vacía.");
        }
        if (_categoria == "") {
            throw new RuntimeException("Error, la descripción del video está vacía.");
        }

        this.id = _id;
        this.nombre = _nombre;
        this.descripcion = _descripcion;
        this.duracion = _duracion;
        this.fechaPublicacion = _fechaPublicacion;
        this.urlVideoOriginal = _urlVideoOriginal;    
        this.categoria = _categoria;
        this.valoraciones = new ArrayList<Valoracion>();
        this.comentarios = new TreeMap<Integer, Comentario>();
        this.eliminado = false;
    }
    
    /** Agregar un nuevo comentario **/
    public void agregarComentario(DtComentario dtComentario, Usuario usuario){
        if (dtComentario == null){
            throw new RuntimeException("El DataType es null");
        }
        if (usuario == null){
            throw new RuntimeException("El usuario es null");
        }
        
        Comentario nuevoComentario = new Comentario(0, dtComentario.getFecha(), dtComentario.getTexto(), 0, usuario);
         // crea la tupla en la base de datos
         // asi se genera el ID y se puede agregar al Map
        new ComentarioJpaController().create(nuevoComentario);
        comentarios.put(nuevoComentario.getId(), nuevoComentario);
    }
    
    /*  Agregar un subcomentario a un comentario existente  */
    public void agregarComentario(int idCom, DtComentario dtComentario, Usuario usuario){
        if (dtComentario == null){
            throw new RuntimeException("El DataType es null");
        }
        if (usuario == null){
            throw new RuntimeException("El usuario es null");
        }
        boolean comentarioComentado;
        for (Map.Entry<Integer, Comentario> coment : comentarios.entrySet()) {
            comentarioComentado = coment.getValue().agregarSubComentario(idCom, dtComentario, usuario);
            if (comentarioComentado) {
                try {
                    new ComentarioJpaController().edit(coment.getValue());
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
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
            
            // Si te estas preguntando por que esta parte de la cobertura esta en amarillo
            // te comento que es porque al for siempre se entra al menos una vez, dado que
            // si se esta en este bloque del if, significa que el usuario ya ha valorado el 
            // video, pero para no entrar al for, ningun usuario debe haberlo hecho.
            // Con el if dentro del for sucede lo mismo, tarde o temprano encuentra al 
            // usuario que quiere modificar su valoracion
            for (Valoracion val : valoraciones) {
                if (val.modificar(dtValoracion, nickname)) {
                    try {
                        new ValoracionJpaController().edit(val);
                    } catch (Exception e) {
                        throw new RuntimeException(e.getMessage());
                    }
                    break;
                }
            }
        } else {
            Valoracion nuevaValoracion = new Valoracion(dtValoracion.getVal(), usuario);
            new ValoracionJpaController().create(nuevaValoracion);
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
        this.urlVideoOriginal = dtVideo.getUrlVideoOriginal();
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
                Valoracion borrada = valoraciones.remove(i);
                try {
                    new ValoracionJpaController().destroy(borrada.getId());
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
                break;
            }

        }
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
