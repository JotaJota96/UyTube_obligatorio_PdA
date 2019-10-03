package Logica.Controladores;

import JPAControllerClasses.CategoriaJpaController;
import JPAControllerClasses.ListaPorDefectoJpaController;
import JPAControllerClasses.UsuarioJpaController;
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
import java.util.List;
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

    public static CUsuario getInstancia() {
        if (instancia == null) {
            instancia = new CUsuario();
        }
        return instancia;
    }

    //** Traer datos de la base de datos **
    private Map<String, Usuario> obtenerUsuarios() {
        Map<String, Usuario> usuarios = new TreeMap();
        try {
            List<Usuario> usuariosEnBDD = new UsuarioJpaController().findUsuarioEntities();
            for (Usuario u : usuariosEnBDD) {
                usuarios.put(u.getNickname(), u);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return usuarios;
    }

    private Map<String, Categoria> obtenerCategorias() {
        Map<String, Categoria> categorias = new TreeMap();
        try {
            List<Categoria> categoriasEnBDD = new CategoriaJpaController().findCategoriaEntities();
            for (Categoria c : categoriasEnBDD) {
                categorias.put(c.getNombre(), c);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return categorias;
    }

    private Map<String, ListaPorDefecto> obtenerListasPorDefecto() {
        Map<String, ListaPorDefecto> ListasPorDefecto = new TreeMap();
        try {
            List<ListaPorDefecto> listasPorDefectoEnBDD = new ListaPorDefectoJpaController().findListaPorDefectoEntities();
            for (ListaPorDefecto l : listasPorDefectoEnBDD) {
                ListasPorDefecto.put(l.getNombre(), l);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
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
        if (video == null) {
            throw new RuntimeException("El video no puede ser null");
        }
        if(!obtenerCategorias().containsKey(video.getCategoria())){
            throw new RuntimeException("La categoria no existe");
        }
        if(usuarioActual == null){
            throw new RuntimeException("No se a iniciado la sesión");
        }
        
        usuarioActual.agregarVideoACanal(video);
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
        if(usuarioActual == null){
            throw new RuntimeException("No puedes cerrar sesión sin haberla iniciado");
        }
        usuarioActual = null;
    }

    @Override
    public boolean existeEmail(String email) {
        if (email.equals("")){
            return false;
        }
        Map<String, Usuario> Usuarios = obtenerUsuarios();
       
        for (Map.Entry<String, Usuario> u : Usuarios.entrySet()) {
            if (u.getValue().getCorreo().equals(email)) {
                return true;
            }
        }
        
        for (Usuario u : new UsuarioJpaController().findUsuarioEliminadoEntities()) {
            if (u.getCorreo().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existeNickname(String nickname) {
        if (nickname.equals("")){
            return false;
        }
        Map<String, Usuario> Usuarios = obtenerUsuarios();
        if (Usuarios.containsKey(nickname)) {
            return true;
        }

        for (Usuario u : new UsuarioJpaController().findUsuarioEliminadoEntities()) {
            if (u.getNickname().equals(nickname)) {
                return true;
            }
        }
        return false;
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
