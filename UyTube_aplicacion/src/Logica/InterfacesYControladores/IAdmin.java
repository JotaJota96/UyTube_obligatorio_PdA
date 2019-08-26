package Logica.InterfacesYControladores;
import Logica.DataType.*;
import java.util.ArrayList;


public interface IAdmin {
    public void agregarVideoAListaDeReproduccion();
    public void altaCategoria(String categoria);
    public void altaComentario(DtComentario dtCom);
    public void altaComentario(DtComentario dtCom, int idComPadre);
    public void altaListaDeReproduccionParticular(DtListaDeReproduccion lista);
    public void altaListaDeReproduccionPorDefecto(DtListaDeReproduccion lista);
    public void altaUsuarioCanal(DtUsuario usr, DtCanal canal);
    public void altaValoracion(DtValoracion val);
    public void altaVideo(DtVideo video); 
    public boolean existeCategoria(String cat);
    public boolean existeEmail(String email);
    public boolean existeNickname(String nickname);
    public boolean iniciarSesionAdministrador(int id, String pass);
    //public boolean iniciarSesionUsuario(String nickname, String pass); // el admin no necesita esta funcion, pero la pongo comentada porque puedo
    public void liberarMemoriaListaDeReproduccion();
    public void liberarMemoriaUsuario();
    public void liberarMemoriaUsuarioActual();
    public void liberarMemoriaVideo();
    public ArrayList<String> listarCategorias();
    public ArrayList<DtComentario> listarComentariosDeVideo();
    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccionEnCategoria(String cat);
    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccionDeUsuario(String nickname);
    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccionParticularesDeUsuario();
    public ArrayList<DtUsuario> listarUsuarioSeguidores();
    public ArrayList<DtUsuario> listarUsuarioSeguidos();
    public ArrayList<DtUsuario> listarUsuarios();
    public ArrayList<DtVideo> listarVideosEnCategoria(String cat);
    public ArrayList<DtVideo> listarVideosDeUsuario();
    public ArrayList<DtVideo> listarVideosDeListaDeReproduccion();
    public void modificarListaDeReproduccion(DtListaDeReproduccion lista);
    public void modificarUsuarioYCanal(DtUsuario usr,DtCanal canal);
    public void modificarVideo(DtVideo video);
    public DtCanal obtenerCanalDeUsuario();
    public ArrayList<DtValoracion> obtenerValoracionesDeVideo();
    public DtValoracion obtenerValoracionDada();
    public void quitarVideoDeListaDeReproduccion();
    public DtUsuario seleccionarUsuario(String nickname);
    public DtUsuario seleccionarUsuarioActual(String nickname);
    public DtVideo seleccionarVideo(int idVideo);
    public DtListaDeReproduccion seleccionarListaDeReproduccion(int idLista);
    public void seguirUsuario();
    public boolean validarNuevaListaParticular(String nombre);
    public boolean validarNuevaListaPorDefecto(String nombre);
    
}
