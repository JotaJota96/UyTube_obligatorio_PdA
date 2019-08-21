package Logica.Clases;
import java.sql.Date;
import Logica.DataType.*;
import java.util.ArrayList;
import java.util.Map;

public class Usuario extends Persona{
    private String nickname;
    private String correo;
    private Date fechaNacimiento;
    private String imagen;
    private int seguidores;
    private Canal MiCanal;
    private Map<String, Usuario> misSeguidores;
    private Map<String, Usuario> SiguiendoA;
    

    public Usuario() {}
    
    public Usuario(String nickname, String correo, Date fechaNacimiento, String imagen, String contrasenia, String nombre, String apellido ,DtCanal DTC) {
        super(nombre,apellido,contrasenia);
        
        this.nickname = nickname;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.imagen = imagen;
        this.seguidores = 0;
        this.MiCanal = new Canal(DTC.getId(),DTC.getNombre(),DTC.getDescripcion(),DTC.getPrivacidad());
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }
    public DtUsuario getDT(){
        return new DtUsuario(this.nickname, this.contraseña, this.nombre, this.apellido, this.correo, this.fechaNacimiento, this.imagen, this.seguidores);//Es el otro constructor
    }
    public void actualizarListasPorDefecto(){
        this.MiCanal.actualizarListasPorDefecto();
    }
    public void agregarComentarioAVideo(int idVideo, DtComentario DtComentario, Usuario Usu){
        //this.MiCanal.agregarComentarioAVideo(idVideo, DtComentario, Usu);
    }
    public void agregarComentarioAVideo(int idVideo,int idCom, DtComentario DtComentario, Usuario Usu){
        //this.MiCanal.agregarComentarioAVideo(idVideo, idCom, DtComentario, Usu);
    }
    public void agregarListaParticular(DtListaDeReproduccion DtValoracion){
        this.MiCanal.agregarListaParticular(DtValoracion);
    }
    public void agregarModificarValoracionDeVideo(int idVideo, DtValoracion DtValoracion, Usuario Usu){
       // this.MiCanal.agregarModificarValoracion(idVideo , DtValoracion, Usu);
    }
    public void agregarOQuitarSeguido(Usuario Usu){
        if(this.misSeguidores.isEmpty()){
            this.misSeguidores.put(Usu.getNickname(), Usu);
        }
        
        if (this.misSeguidores.containsKey(Usu.nickname)){
            this.misSeguidores.remove(Usu.getNickname());
        }else{
            this.misSeguidores.put(Usu.getNickname(), Usu);
        }
    }
    public void agregarOQuitarSeguidor(Usuario Usu){
        if(this.misSeguidores.isEmpty()){
            this.misSeguidores.put(Usu.getNickname(), Usu);
            this.seguidores++;
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
        this.MiCanal.agregarVideo(DtVideo);
    }
    
    public void agregarVideoALista(int idLista , int idVideo, Usuario Usu){
        this.agregarVideoALista(idLista, idVideo, Usu);
    }
    
    public ArrayList<DtComentario> listarComentariosDeVideo(int idVideo){
        //return this.MiCanal.listalistarComentariosDeVideo(idVideo);
        return null;//Esto se saca
    }
    
    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccionDeCanal(boolean porDefecto){
        //return this.MiCanal.listarListasDeReproduccion(porDefecto);
        return null;//Esto se saca
    }
    
    public ArrayList<DtUsuario> listarUsuariosSeguidores(){
        // crea una lista de retorno
        ArrayList<DtUsuario> ret = new ArrayList();
        
        for (Map.Entry<String,Usuario> i : this.misSeguidores.entrySet()){
            // hace un getDT y lo agrega a la coleccion de retorno
            ret.add(i.getValue().getDT());
        }
        return ret;
    }//(Ctrl + C Ctrl + V) De la clase video
    
    public ArrayList<DtUsuario> listarUsuariosSeguidos(){
        // crea una lista de retorno
        ArrayList<DtUsuario> ret = new ArrayList();
        
        for (Map.Entry<String,Usuario> i : this.SiguiendoA.entrySet()){
            // hace un getDT y lo agrega a la coleccion de retorno
            ret.add(i.getValue().getDT());
        }
        return ret;
    }//(Ctrl + C Ctrl + V) De la clase video
    
    public ArrayList<DtValoracion> listarValoracionesDeVideo(int id){
        //this.MiCanal.listarValoracionesDeVideo(id);
        return null;//Esto se saca
    }
    
    public ArrayList<DtVideo> listarVideosDeCanal(){
        //this.MiCanal.listarVideos();
        return null;//Esto se saca
    }
    
    public ArrayList<DtVideo> listarVideosDeListaDeReproduccion(int id){
        //return this.MiCanal.listarVideosDeListaDeReproduccion(id);
        return null;//Esto se saca
    }
    
    public void modificar(DtUsuario DtUsu, DtCanal DtCanal){
        this.nombre = DtUsu.getNombre();
        this.apellido = DtUsu.getApellido();
        this.contraseña = DtUsu.getContrasenia();
        this.fechaNacimiento = DtUsu.getFechaNacimiento();
        this.imagen = DtUsu.getImagen();
        
        this.MiCanal.modificar(DtCanal);
    }
    
    public void modificarListaDeReproduccionDeCanal(DtListaDeReproduccion DtListaDeReproduccion){
        this.MiCanal.modificarListaDeReproduccion(DtListaDeReproduccion);
    }
    
    public void modificarVideoDeCanal(DtVideo DtVideo){
        this.MiCanal.modificarVideo(DtVideo);
    }
    
    public DtCanal obtenerCanal(){
       // return this.MiCanal.getDT();
        return null;//Esto se saca
    }
    public ArrayList<DtListaDeReproduccion> obtenerListasEnCategoria(String cat){
        //return this.MiCanal.obtenerListasEnCategoria(string cat);
        return null;//Esto se saca
    }
    public DtValoracion obtenerValoracion(int id, String nickname){
        //return this.MiCanal.obtenerValoracion(id, nickname);
        return null;//Esto se saca
    }
    public Video obtenerVideo(int id){
       // return this.MiCanal.obtenerVideo(id);
        return null;//Esto se saca
    }
    public DtVideo obtenerVideoDeCanal(int id){
        //return this.MiCanal.obtenerVideo(id);
        return null;//Esto se saca
    }
    public ArrayList<DtVideo> obtenerVideosEnCategoria(String cat){
        //return this.MiCanal.obtenerVideosEnCategoria(String cat){
        return null;//Esto se saca
    }
    
     public void quitarVideoDeListaDeReproduccion(int idLista, int idVideo){
         this.MiCanal.quitarVideoDeListaDeReproduccion(idLista, idVideo);
     }
     
    public boolean validarListaParticular(String nombre){
        //return this.MiCanal.validarListaParticular(nombre);
        return false;//Esto se saca
    }
}

