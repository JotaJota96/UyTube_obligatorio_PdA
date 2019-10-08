package Logica.Clases;
import JPAControllerClasses.CanalJpaController;
import java.sql.Date;
import Logica.DataType.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario extends Persona{
    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "correo")
    private String correo;
    
    @Basic
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    
    @Column(name = "imagen")
    private String imagen;
    
    @Column(name = "seguidores")
    private int seguidores;
    
    @Column(name = "eliminado")
    private boolean eliminado;
    
    @Basic
    @Column(name = "fecha_eliminado")
    private Date fechaEliminado;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_canal")
    private Canal MiCanal;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="usuarios_seguidores",
            joinColumns={@JoinColumn(name="nick_seguido", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="nick_seguidor", referencedColumnName="id")})
    @MapKey(name = "id")
    private Map<String, Usuario> misSeguidores;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="usuarios_seguidos",
            joinColumns={@JoinColumn(name="nick_seguidor", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="nick_seguido", referencedColumnName="id")})
    @MapKey(name = "id")
    private Map<String, Usuario> seguidos;
    
    //----------------------------------------------------------------------------------
    public Usuario() {
        super();
    }

    public Usuario(String nickname, String correo, Date fechaNacimiento, String imagen, String contrasenia, String nombre, String apellido, DtCanal DTC) {
        super(nombre,apellido,contrasenia);
        
        if(fechaNacimiento == null){
            throw new RuntimeException("la fecha no puede ser nill");
        }
        if(DTC == null){
            throw new RuntimeException("El canal no puede ser null");
        }
        if(nickname == ""){
            throw new RuntimeException("El nickname no puede ser Vacio");
        }
        
        if(correo == ""){
            throw new RuntimeException("El correo no puede ser Vacio");
        }
        
        this.id = nickname;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.imagen = imagen;
        this.seguidores = 0;
        this.MiCanal = new Canal(0,DTC.getNombre(),DTC.getDescripcion(),DTC.getPrivacidad());
        this.misSeguidores = new TreeMap();
        this.seguidos = new TreeMap();
        this.eliminado = false;
        this.fechaEliminado = null;
    }

    public String getNickname() {
        return id;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public String getImagen() {
        return imagen;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public DtUsuario getDT(){
        return new DtUsuario(this.id, super.getContrasenia(), super.getNombre(), super.getApellido(), this.correo, this.fechaNacimiento, this.fechaEliminado, this.imagen, this.seguidores);
    }
    
    public void eliminar(Date fecha) {
        this.fechaEliminado = fecha;
        this.eliminado = true;
        this.MiCanal.eliminar();
        try {
            new CanalJpaController().edit(this.MiCanal);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public void eliminarTodoRastroDelUsuario(String nickname) {
        // Esta funcion que estas leyendo NO se encarga de eliminar vinculos de seguimiento
        this.MiCanal.eliminarTodoRastroDelUsuario(nickname);
        try {
            new CanalJpaController().edit(this.MiCanal);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public void actualizarListasPorDefecto(ArrayList<String> listas){
        this.MiCanal.actualizarListasPorDefecto(listas);
        try {
            new CanalJpaController().edit(this.MiCanal);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public void agregarComentarioAVideo(int idVideo, DtComentario DtComentario, Usuario Usu){
        if(DtComentario == null){
            throw new RuntimeException("El comentario no puede ser null");
        }
        if(Usu == null){
            throw new RuntimeException("El usuario no puede ser null");
        }
        
        this.MiCanal.agregarComentarioAVideo(idVideo, DtComentario, Usu);
    }
    
    public void agregarComentarioAVideo(int idVideo, int idCom, DtComentario DtComentario, Usuario Usu){
        if(DtComentario == null){
            throw new RuntimeException("El comentario no puede ser null");
        }
        if(Usu == null){
            throw new RuntimeException("El usuario no puede ser null");
        }
        
        this.MiCanal.agregarComentarioAVideo(idVideo, idCom, DtComentario, Usu);
    }
    
    public void agregarListaParticular(DtListaDeReproduccion DtValoracion){
        if(DtValoracion == null){
            throw new RuntimeException("La valoracion no puede ser null");
        }
        this.MiCanal.agregarListaParticular(DtValoracion);
        try {
            new CanalJpaController().edit(this.MiCanal);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public void agregarModificarValoracionDeVideo(int idVideo, DtValoracion DtValoracion, Usuario Usu){
        if(DtValoracion == null){
            throw new RuntimeException("La valoracion no puede ser null");
        }
        if(Usu == null){
            throw new RuntimeException("El usuario no puede ser null");
        }
        
        this.MiCanal.agregarModificarValoracion(idVideo , DtValoracion, Usu);
    }
    
    public void agregarOQuitarSeguido(Usuario Usu){
        if(Usu == null){
            throw new RuntimeException("El usuario no puede ser null");
        }
        if(Usu == this){
            throw new RuntimeException("Un usuario no se puede seguir a si mismo");
        }
        
        if (this.seguidos.containsKey(Usu.getNickname())){
            this.seguidos.remove(Usu.getNickname());
        }else{
            this.seguidos.put(Usu.getNickname(), Usu);
        }
        
        Usu.agregarOQuitarSeguidor(this);
    }
    
    // si, esta si es private, no es un error
    private void agregarOQuitarSeguidor(Usuario Usu){
        if(Usu == null){
            throw new RuntimeException("El usuario no puede ser null");
        }
        
        if (this.misSeguidores.containsKey(Usu.id)){
            this.misSeguidores.remove(Usu.getNickname());
            this.seguidores--;
        }else{
            this.misSeguidores.put(Usu.getNickname(), Usu);
            this.seguidores++;
        }
    }
    
    public void agregarVideoACanal(DtVideo DtVideo){
        if(DtVideo == null){
            throw new RuntimeException("El video no puede ser null");
        }
        this.MiCanal.agregarVideo(DtVideo);
        try {
            new CanalJpaController().edit(this.MiCanal);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public void agregarVideoALista(int idLista , int idVideo, Usuario Usu){
        if(Usu == null){
            throw new RuntimeException("El usuario no puede ser null");
        }
        Video v = null;
        try {
            v = Usu.obtenerVideo(idVideo);
        } catch (Exception e) {
            throw new RuntimeException("El video no pertenece al usuario: " + Usu.getNickname());
        }
        this.MiCanal.agregarVideoALista(idLista, v);
    }
    
    public ArrayList<DtComentario> listarComentariosDeVideo(int idVideo){
        return this.MiCanal.listarComentariosDeVideo(idVideo);
    }
    
    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccionDeCanal(boolean soloParticulares){
        return this.MiCanal.listarListasDeReproduccion(soloParticulares);
    }
    
    public ArrayList<DtUsuario> listarUsuariosSeguidos(){
        // crea una lista de retorno
        ArrayList<DtUsuario> ret = new ArrayList();
        
        for (Map.Entry<String,Usuario> i : this.seguidos.entrySet()){
            // hace un getDT y lo agrega a la coleccion de retorno
            ret.add(i.getValue().getDT());
        }
        return ret;
    }//(Ctrl + C Ctrl + V) De la clase video
    
    public ArrayList<DtUsuario> listarUsuariosSeguidores(){
        // crea una lista de retorno
        ArrayList<DtUsuario> ret = new ArrayList();
        
        for (Map.Entry<String,Usuario> i : this.misSeguidores.entrySet()){
            // hace un getDT y lo agrega a la coleccion de retorno
            ret.add(i.getValue().getDT());
        }
        return ret;
    }//(Ctrl + C Ctrl + V) De la clase lirRepro
    
    public ArrayList<DtValoracion> listarValoracionesDeVideo(int id){
        return this.MiCanal.listarValoracionesDeVideo(id);
    }
    
    public ArrayList<DtVideo> listarVideosDeCanal(){
        return this.MiCanal.listarVideos();
    }
    
    public ArrayList<DtVideo> listarVideosDeListaDeReproduccion(int id){
        return this.MiCanal.listarVideosDeListaDeReproduccion(id);
    }
    
    public void modificar(DtUsuario DtUsu, DtCanal DtCanal){
        if(DtUsu == null){
            throw new RuntimeException("El usuario no puede ser null");
        }
        if(DtUsu.getFechaNacimiento() == null){
            throw new RuntimeException("La fecha no puede ser null");
        }
        if(DtCanal == null){
            throw new RuntimeException("El canal no puede ser null");
        }
        if (this.id != DtUsu.getNickname()){
            throw new RuntimeException("El nickname no puede ser modificado");
        }
        if (this.correo != DtUsu.getCorreo()){
            throw new RuntimeException("El correo no puede ser modificado");
        }
        super.setNombre(DtUsu.getNombre());
        super.setApellido(DtUsu.getApellido());
        super.setContrasenia(DtUsu.getContrasenia());
        this.fechaNacimiento = DtUsu.getFechaNacimiento();
        this.imagen = DtUsu.getImagen();
        
        this.MiCanal.modificar(DtCanal);
        try {
            new CanalJpaController().edit(this.MiCanal);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public void modificarListaDeReproduccionDeCanal(DtListaDeReproduccion DtListaDeReproduccion){
        if(DtListaDeReproduccion == null){
            throw new RuntimeException("La lista de reproduccion no puede ser null");
        }
        
        this.MiCanal.modificarListaDeReproduccion(DtListaDeReproduccion);
    }
    
    public void modificarVideoDeCanal(DtVideo DtVideo){
        if(DtVideo == null){
            throw new RuntimeException("El video no puede ser null");
        }
        this.MiCanal.modificarVideo(DtVideo);
    }
    
    public DtCanal obtenerCanal(){
        return this.MiCanal.getDT();
    }
    
    
    public DtListaDeReproduccion obtenerListaDeReproduccion(int id){
        return MiCanal.obtenerListaDeReproduccion(id);
    }
    
    
    public ArrayList<DtListaDeReproduccion> obtenerListasEnCategoria(String cat){
        if(cat == ""){
            throw new RuntimeException("La categoria no puede ser vacia");
        }
        
        return this.MiCanal.obtenerListasEnCategoria(cat);
    }
    
    public DtValoracion obtenerValoracion(int id, String nickname){
        if(nickname == ""){
            throw new RuntimeException("El nickname no puede ser vacio");
        }
        
        return this.MiCanal.obtenerValoracion(id, nickname);
    }
    
    public Video obtenerVideo(int id){
        return this.MiCanal.obtenerVideo(id);
    }
    
    public DtVideo obtenerVideoDeCanal(int idVideo){
        return this.MiCanal.obtenerDtVideo(idVideo);
    }
    
    public ArrayList<DtVideo> obtenerVideosEnCategoria(String cat){
        if(cat == ""){
            throw new RuntimeException("La categoria no puede ser vacia");
        }
        
        return this.MiCanal.obtenerVideosEnCategoria(cat);
        
    }
    
    public void quitarValoracion(int id, String nickname){
        if(nickname == ""){
            throw new RuntimeException("El nickname no puede ser vacia");
        }
        this.MiCanal.quitarValoracion(id, nickname);
    }
    
    public void quitarVideoDeListaDeReproduccion(int idLista, int idVideo){
        this.MiCanal.quitarVideoDeListaDeReproduccion(idLista, idVideo);
    }
    
    public boolean validarListaParticular(String nombre){
        if(nombre == ""){
            throw new RuntimeException("El nombre de la lista no puede ser vacia");
        }
        return this.MiCanal.validarListaParticular(nombre);
    }
}

