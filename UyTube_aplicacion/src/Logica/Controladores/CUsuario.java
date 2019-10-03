package Logica.Controladores;

import Logica.Clases.Categoria;
import Logica.Clases.ListaPorDefecto;
import Logica.Clases.Usuario;
import Logica.DataType.DtCanal;
import Logica.DataType.DtComentario;
import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtUsuario;
import Logica.DataType.DtValoracion;
import Logica.DataType.DtVideo;
import Logica.Enumerados.Filtrado;
import Logica.Enumerados.Ordenacion;
import Logica.Interfaces.IUsuario;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class CUsuario implements IUsuario {
    private static CUsuario instancia = null;
    private Usuario usuarioActual;
    private Usuario usuarioSeleccionado;
    private int idListaSeleccionada;
    private int idVideoSeleccionado;

    private CUsuario() {
        this.usuarioActual = null;
        this.usuarioSeleccionado = null;
        this.idListaSeleccionada = 0;
        this.idVideoSeleccionado = 0;
    }
    
    public static CUsuario getInstancia(){
        if( instancia == null ){
            instancia = new CUsuario();
        }
        return instancia;        
    }
    
    
    //***************** Traer datos de la base de datos *******************
    private Map<String, Usuario> obtenerUsuarios(){
        Map<String, Usuario> usuarios = new TreeMap();
        return usuarios;
    }
    private Map<String, Categoria> obtenerCategorias(){
        Map<String, Categoria> categorias = new TreeMap();
        return categorias;
    }
    private Map<String, ListaPorDefecto> obtenerListasPorDefecto(){
        Map<String, ListaPorDefecto> ListasPorDefecto = new TreeMap();
        return ListasPorDefecto;
    }
    
    //******************** Funciones de la interfaz ************************
    @Override
    public void agregarVideoAListaDeReproduccion(int idLista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void altaComentario(DtComentario dtCom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void altaComentario(DtComentario dtCom, int idComPadre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void altaListaDeReproduccionParticular(DtListaDeReproduccion lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void altaUsuarioCanal(DtUsuario usr, DtCanal canal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void altaVideo(DtVideo video) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bajaUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> buscar(String busqueda, Filtrado filtro, Ordenacion orden) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> buscar(String categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cerrarSesion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existeEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existeNickname(String nickname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean iniciarSesionUsuario(String nickOEmail, String contrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> listarCategorias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DtComentario> listarComentariosDeVideo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccionDeUsuario(boolean incluirListasPorDefecto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DtUsuario> listarUsuarioSeguidores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DtUsuario> listarUsuarioSeguidos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DtUsuario> listarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DtVideo> listarVideosDeListaDeReproduccion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DtVideo> listarVideosDeUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarListaDeReproduccion(DtListaDeReproduccion lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarUsuarioYCanal(DtUsuario usr, DtCanal canal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarVideo(DtVideo video) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtCanal obtenerCanalDeUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtUsuario obtenerPropietarioDeVideo(int idVideo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtUsuario obtenerPropietarioDeListaDeReproduccion(int idLista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtValoracion obtenerValoracionDada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DtValoracion> obtenerValoracionesDeVideo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void quitarVideoDeListaDeReproduccion(int idVideo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seguirUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtUsuario seleccionarUsuario(String nickname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtListaDeReproduccion seleccionarListaDeReproduccion(int idLista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtVideo seleccionarVideo(int idVideo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarNuevaListaParticular(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarNuevoVideo(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void valorarVideo(DtValoracion val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
