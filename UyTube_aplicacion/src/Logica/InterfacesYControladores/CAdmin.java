/*
 Controlador para la interfaz de administrador Idmin
 */
package Logica.InterfacesYControladores;

import Logica.DataType.DtCanal;
import Logica.DataType.DtComentario;
import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtUsuario;
import Logica.DataType.DtValoracion;
import Logica.DataType.DtVideo;
import java.util.ArrayList;

/**
 *
 * @author administrador
 */
public class CAdmin implements IAdmin{
    private static CAdmin instancia;
    
    private CAdmin(){
        
    }
    
    public static CAdmin getInstancia(){
        if( instancia == null ){
            instancia = new CAdmin();
        }
        return instancia;        
    }
    
    public void agregarVideoAListaDeReproduccion(){
        
    }
    public void altaCategoria(String categoria){
        
    }
    
    public void altaComentario(DtComentario dtCom){
        
    }
    
    public void altaComentario(DtComentario dtCom, int idComPadre){
        
    }
    
    public void altaListaDeReproduccionParticular(DtListaDeReproduccion lista){
        
    }
    
    public void altaListaDeReproduccionPorDefecto(DtListaDeReproduccion lista){
        
    }
    
    public void altaUsuarioCanal(DtUsuario usr, DtCanal canal){
        
    }
    
    public void altaValoracion(DtValoracion val){
        
    }
    
    public void altaVideo(DtVideo video){
        
    }
    
    public boolean existeCategoria(String cat){
        
        return true;
    }
    
    public boolean existeEmail(String email){
        return true;
    }
    
    public boolean existeNickname(String nickname){
        return true;
    }
    
    public ArrayList<String> listarCategorias(){
        return new ArrayList<String>();
    }
    
    public ArrayList<DtComentario> listarComentariosDeVideo(){
        return new ArrayList<DtComentario>();

    }
    
    public ArrayList<DtVideo> listarListasDeReproduccionEnCategoria(String cat){
        return new ArrayList<DtVideo>();

    }
    
    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccionDeUsuario(String nickname){
        return new ArrayList<DtListaDeReproduccion>();
    }
    
    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccionParticularesDeUsuario(){
        return new ArrayList<DtListaDeReproduccion>();
    }
    
    public ArrayList<DtUsuario> listarUsuarioSeguidores(){
        return new ArrayList<DtUsuario>();
    }
    
    public ArrayList<DtUsuario> listarUsuarioSeguidos(){
        return new ArrayList<DtUsuario>();
    }
    
    public ArrayList<DtUsuario> listarUsuarios(){
        return new ArrayList<DtUsuario>();
    }
    public ArrayList<DtVideo> listarVideosEnCategoria(String cat){
        return new ArrayList<DtVideo>();
    }
    
    public ArrayList<DtVideo> listarVideosDeUsuario(){
        return new ArrayList<DtVideo>();
    }
    
    public ArrayList<DtVideo> listarVideosDeListaDeReproduccion(){
        return new ArrayList<DtVideo>();
    }
    
    public void modificarListaDeReproduccion(DtListaDeReproduccion lista){
        
    }
    
    public void modificarUsuarioYCanal(DtUsuario usr,DtCanal canal){
        
    }
    
    public void modificarVideo(DtVideo video){
        
    }
    
    public DtCanal obtenerCanalDeUsuario(){
        return new DtCanal();
    }
    
    public ArrayList<DtValoracion> obtenerValoracionesDeVideo(){
        return new ArrayList<DtValoracion>();
    }
    
    public DtValoracion obtenerValoracionDada(){
        return new DtValoracion();
    }
    
    public void quitarVideoDeListaDeReproduccion(){
        
    }
    
    public DtUsuario seleccionarUsuario(String nickname){
        return new DtUsuario();
    }
    
    public DtUsuario seleccionarUsuarioActual(String nickname){
        return new DtUsuario();
    }
    public DtVideo seleccionarVideo(int idVideo){
        return new DtVideo();
    }
    
    public DtListaDeReproduccion seleccionarListaDeReproduccion(int idLista){
        return new DtListaDeReproduccion();
    }
    
    public void seguirUsuario(){
        
    }
    
    public boolean validarNuevaListaParticular(String nombre){
        return true;
    }
    public boolean validarNuevaListaPorDefecto(String nombre){
        return true;
    }
}
