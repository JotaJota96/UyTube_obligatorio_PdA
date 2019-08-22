package Logica.Clases;
import java.sql.Date;
import Logica.DataType.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Usuario extends Persona{
    
    private String nickname;
    private String correo;
    private Date fechaNacimiento;
    private String imagen;
    private int seguidores;
    private Canal MiCanal;
    private Map<String, Usuario> misSeguidores;
    private Map<String, Usuario> seguidos;
    

    public Usuario() {}
    
    public Usuario(String nickname, String correo, Date fechaNacimiento, String imagen, String contrasenia, String nombre, String apellido ,DtCanal DTC) {
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
        
        if(contrasenia == ""){
                throw new RuntimeException("La contraseña no puede ser Vacio");
        }
        
        
        this.nickname = nickname;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.imagen = imagen;
        this.seguidores = 0;
        this.MiCanal = new Canal(Canal.getNuevoId(),DTC.getNombre(),DTC.getDescripcion(),DTC.getPrivacidad());
        this.misSeguidores = new TreeMap();
        this.seguidos = new TreeMap();
    }

    public String getNickname() {
        return nickname;
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
        return new DtUsuario(this.nickname, this.contrnia, this.nombre, this.apellido, this.correo, this.fechaNacimiento, this.imagen, this.seguidores);//Es el otro constructor
    }
    
    public void actualizarListasPorDefecto(){
        this.MiCanal.actualizarListasPorDefecto();
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
        
        if (this.seguidos.containsKey(Usu.getNickname())){
            this.seguidos.remove(Usu.getNickname());
        }else{
            this.seguidos.put(Usu.getNickname(), Usu);
        }
        
        Usu.agregarOQuitarSeguidor(this);
    }
    
    public void agregarOQuitarSeguidor(Usuario Usu){
        if(Usu == null){
            throw new RuntimeException("El usuario no puede ser null");
        }
        
        if (this.misSeguidores.containsKey(Usu.nickname)){
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
    }
    
    public void agregarVideoALista(int idLista , int idVideo, Usuario Usu){
        if(Usu == null){
            throw new RuntimeException("El usuario no puede ser null");
        }
        
        this.agregarVideoALista(idLista, idVideo, Usu);
    }
    
    public ArrayList<DtComentario> listarComentariosDeVideo(int idVideo){
        return this.MiCanal.listarComentariosDeVideo(idVideo);
    }
    
    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccionDeCanal(boolean porDefecto){
        return this.MiCanal.listarListasDeReproduccion(porDefecto);
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
        if(DtCanal == null){
            throw new RuntimeException("El canal no puede ser null");
        }
        
        this.nombre = DtUsu.getNombre();
        this.apellido = DtUsu.getApellido();
        this.contrnia = DtUsu.getContrasenia();
        this.fechaNacimiento = DtUsu.getFechaNacimiento();
        this.imagen = DtUsu.getImagen();
        
        this.MiCanal.modificar(DtCanal);
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
        
        //return this.MiCanal.obtenerValoracion(id, nickname);
        return null;//Esto se saca
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

