package Logica.Clases;
import java.util.Date;
import Logica.DataType.*;
import java.util.ArrayList;

public class Usuario extends Persona{
    private String nikname;
    private String correo;
    private Date fechaNacimiento;
    private String imagen;
    private int seguidores;

    public Usuario() {
    }
    
    public Usuario(String nikname, String correo, Date fechaNacimiento, String imagen) {
        this.nikname = nikname;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.imagen = imagen;
        this.seguidores = 0;
    }

    public String getNikname() {
        return nikname;
    }

    public void setNikname(String nikname) {
        this.nikname = nikname;
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
        return new DtUsuario();//Es el otro constructor
    }
    public void actualizarListasPorDefecto(){}
    public void agregarComentarioAVideo(int id, DtComentario DtComentario, Usuario Usu){}
    public void agregarComentarioAVideo(int id,int idCom, DtComentario DtComentario, Usuario Usu){}
    public void agregarListaParticular(DtListaDeReproduccion DtValoracion){}
    public void agregarModificarValoracionDeVideo(int id, DtValoracion DtValoracion, Usuario Usu){}
    public void agregarOQuitarSeguido(Usuario Usu){}
    public void agregarOQuitarSeguidor(Usuario Usu){}
    public void agregarVideoACanal(DtVideo DtVideo){}
    public void agregarVideoALista(int idLista , int idVideo, Usuario Usu){}
    
   // public ArrayList<DtComentario> listarComentariosDeVideo(int id){}
   // public ArrayList<DtListasDeReproduccion> listarListasDeReproduccionDeCanal(bool porDefecto){}
   // public ArrayList<DtUsuario> listarUsuariosSeguidores(){}
   // public ArrayList<DtUsuario> listarUsuariosSeguidos(){}
   // public ArrayList<DtValoracion> listarValoracionesDeVideo(int id){}
   // public ArrayList<DtVideo> listarVideosDeCanal(){}
   // public ArrayList<DtVideo> listarVideosDeListaDeReproduccion(int id){}

    public void modificar(DtUsuario Usu, DtCanal DtCanal){}
    public void modificarListaDeReproduccionDeCanal(DtListaDeReproduccion DtListaDeReproduccion){}
    public void modificarVideoDeCanal(DtVideo DtVideo){}
    
   // public DtCanal obtenerCanal(){}
   // public ArrayList<DtListaDeReproduccion> obtenerListasEnCategoria(cat:string){}
   // public DtValoracion obtenerValoracion(int id, string nickname){}
   // public Video obtenerVideo(int id){}
   // public DtVideo obtenerVideoDeCanal(int id){}
   // public ArrayList<DtVideo> obtenerVideosEnCategoria(cat:string){}
    
     public void quitarVideoDeListaDeReproduccion(int idLista, int idVideo){}
   // public boolean validarListaParticular(String nombre){}
}

