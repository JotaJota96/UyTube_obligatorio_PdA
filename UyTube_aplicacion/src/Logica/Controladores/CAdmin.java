package Logica.Controladores;

// Interfaz que se realizara
import Logica.Interfaces.IAdmin;
// DataTypes
import Logica.DataType.*;
// Clases necesarias
import Logica.Clases.Administrador;
import Logica.Clases.Usuario;
import Logica.Clases.Categoria;
import Logica.Clases.ListaDeReproduccion;
// Colecciones
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;


public class CAdmin implements IAdmin{
    private static CAdmin instancia = null;
    private Map<String, Usuario> usuarios;
    private Map<Integer, Administrador> administradores;
    private Map<String, Categoria> categorias;
    private Usuario usuarioActual;
    private Usuario usuarioSeleccionado;
    private int idListaSeleccionada;
    private int idVideoSeleccionado;

    
    private CAdmin(){
        this.usuarios = new TreeMap();
        this.administradores = new TreeMap();
        this.categorias = new TreeMap();
        this.usuarioActual = null;
        this.usuarioSeleccionado = null;
        this.idListaSeleccionada = 0;
        this.idVideoSeleccionado = 0;
        
        this.altaCategoria("UNDEFINED");
        
        // Administrador por defecto (temporal)
        int id = 0;
        Administrador root = new Administrador(id, "admin", "administrador", "root");
        this.administradores.put(id, root);
    }
    
    public static CAdmin getInstancia(){
        if( instancia == null ){
            instancia = new CAdmin();
        }
        return instancia;        
    }
    
    public void agregarVideoAListaDeReproduccion(int idLista){
        /**
         * Agrega el video idVideoSeleccionado a la lista idListaSeleccionada
         */
        if (usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (usuarioActual == null){
            throw new RuntimeException("El sistema no tiene un usuario actual seleccionado");
        }
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        if (idLista == 0){
            throw new RuntimeException("El ID de la lista de reproduccion no es valido");
        }
        usuarioActual.agregarVideoALista(idLista, idVideoSeleccionado, usuarioSeleccionado);
    }
    
    public void altaCategoria(String categoria){
        /**
         * Crea la categoria con el nombre indicado
         */
        if (categoria.equals("")){
            throw new RuntimeException("El nombre de la categoria no puede ser vacio");
        }
        if (existeCategoria(categoria)){
            throw new RuntimeException("El sistema ya posee una categoria con ese nombre");
        }
        categorias.put(categoria, new Categoria(categoria));
    }
    
    public void altaComentario(DtComentario dtCom){
        /**
         * Comenta el video idVideoSeleccionado a nombre de usuarioActual
         */
        if (usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (usuarioActual == null){
            throw new RuntimeException("El sistema no tiene un usuario actual seleccionado");
        }
        if (dtCom == null){
            throw new RuntimeException("El DataType comentario no puede ser null");
        }
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        usuarioSeleccionado.agregarComentarioAVideo(idVideoSeleccionado, dtCom, usuarioActual);
        
    }
    
    public void altaComentario(DtComentario dtCom, int idComPadre){
        /**
         * Comenta el comentario con dicho ID a nombre de usuarioActual
         */
        if (usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (usuarioActual == null){
            throw new RuntimeException("El sistema no tiene un usuario actual seleccionado");
        }
        if (dtCom == null){
            throw new RuntimeException("El DataType comentario no puede ser null");
        }
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        usuarioSeleccionado.agregarComentarioAVideo(idVideoSeleccionado, idComPadre, dtCom, usuarioActual);
    }
    
    public void altaListaDeReproduccionParticular(DtListaDeReproduccion lista){
        /**
         * Crea la lista de reproduccion para usuarioSeleccionado
         */
        if (usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (lista == null){
            throw new RuntimeException("El DataType recibido es null");
        }
        if ( ! existeCategoria(lista.getCategoria())){
            throw new RuntimeException("La categoria no existe");
        }
        usuarioSeleccionado.agregarListaParticular(lista);
        
    }
    
    public void altaListaDeReproduccionPorDefecto(DtListaDeReproduccion lista){
        /**
         * Crea la lista de reproduccion para todos los usuarios del sistema y 
         * la agrega listas por defecto (para que se creen al crear un usuario nuevo)
         */
        if (lista == null){
            throw new RuntimeException("El DataType lista de reproduccion no puede ser null");
        }
        if (lista.getNombre().equals("")){
            throw new RuntimeException("El nombre de la nueva lista de reproduccion por defecto no puede ser vacio");
        }
        if (ListaDeReproduccion.listarNombresDeListasPorDefecto().contains(lista.getNombre())){
            throw new RuntimeException("El sistema ya posee una lista de reproduccion por defecto con ese nombre");
        }
        ListaDeReproduccion.agregarListaPorDefecto(lista.getNombre());
        
        for (Map.Entry<String, Usuario> u : usuarios.entrySet()){
            u.getValue().actualizarListasPorDefecto();
        }
    }
    
    public void altaUsuarioCanal(DtUsuario usr, DtCanal canal){
        /**
         * Crea un usuario y su canal a partir de los datos recibidos
         */
        if (usr == null){
            throw new RuntimeException("El DataType usuario no puede ser null");
        }
        if (canal == null){
            throw new RuntimeException("El DataType canal no puede ser null");
        }
        if (existeNickname(usr.getNickname())){
            throw new RuntimeException("El sistema ya tiene un usuario con ese nickname");
        }
        if (existeEmail(usr.getCorreo())){
            throw new RuntimeException("El sistema ya tiene un usuario con ese correo");
        }
        
        Usuario nuevoUsuario = new Usuario(
                usr.getNickname(), 
                usr.getCorreo(), 
                usr.getFechaNacimiento(), 
                usr.getImagen(), 
                usr.getContrasenia(), 
                usr.getNombre(), 
                usr.getApellido(), 
                canal);
        usuarios.put(nuevoUsuario.getNickname(), nuevoUsuario);
    }
    
    public void altaValoracion(DtValoracion val){
        /**
	Se ingresa la nueva valoracion dada por usuarioActual al video idVideoSeleccionado
	Si el usuario ya habia valorado, se actualiza la valoracion dada
        */
        if (usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (usuarioActual == null){
            throw new RuntimeException("El sistema no tiene un usuario actual seleccionado");
        }
        if (val == null){
            throw new RuntimeException("El DataType Valoracion no puede ser null");
        }
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        usuarioSeleccionado.agregarModificarValoracionDeVideo(idVideoSeleccionado, val, usuarioActual);
    }
    
    public void altaVideo(DtVideo video){
        /**
         * Se crea un video nuevo en el canal de usuarioSeleccionado
         */
        if (usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (video == null){
            throw new RuntimeException("El DataType video no puede ser null");
        }
        if ( ! existeCategoria(video.getCategoria())){
            throw new RuntimeException("La categoria no existe");
        }
        usuarioSeleccionado.agregarVideoACanal(video);
    }
    
    public boolean existeCategoria(String cat){
        /**
         * Verifica si existe una categoria con el nombre recibido
         */
        return categorias.containsKey(cat);
    }
    
    public boolean existeEmail(String email){
        /**
         * Verifica si existe un usuario con el mail recibido
         */
        for (Map.Entry<String, Usuario> u : usuarios.entrySet()){
            if (u.getValue().getCorreo() == email){
                return true;
            }
        }
        return false;
    }
    
    public boolean existeNickname(String nickname){
        /**
         * Verifica si existe un usuario con el nickname recibido
         */
        return usuarios.containsKey(nickname);
    }
    public boolean iniciarSesionAdministrador(int id, String pass){
        Administrador a = administradores.get(id);
        if (a == null){
            return false;
        }
        return a.validarContrasenia(pass);
    }
    
    public boolean iniciarSesionUsuario(String nickname, String pass){
        Usuario u = usuarios.get(nickname);
        if (u == null){
            return false;
        }
        boolean ok = u.validarContrasenia(pass);
        if (ok){
            usuarioActual = u;
        }
        return ok;
    }
    
    public void liberarMemoriaListaDeReproduccion(){
        idListaSeleccionada = 0;
    }
    
    public void liberarMemoriaUsuario(){
        usuarioSeleccionado = null;
    }
    
    public void liberarMemoriaUsuarioActual(){
        usuarioActual = null;
    }
    
    public void liberarMemoriaVideo(){
        idVideoSeleccionado = 0;
    }
    
    public ArrayList<String> listarCategorias(){
        /**
         * Devuelve todas las categorias existentes en el sistema
         */
        ArrayList<String> ret = new ArrayList();
        for (Map.Entry<String, Categoria> c : categorias.entrySet()){
            ret.add(c.getValue().getNombre());
        }
        return ret;
    }
    
    public ArrayList<DtComentario> listarComentariosDeVideo(){
        /**
         * Devuelve en forma ordenada (recursiva ) todos los comentarios de idVideoSeleccionado
         */
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        return usuarioSeleccionado.listarComentariosDeVideo(idVideoSeleccionado);
    }
    
    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccionEnCategoria(String cat){
        /**
         * Devuelve todos las listas de reproduccion del sistema que pertenezcan a la categoria indicada
         */
        
        if (cat.equals("")){
            throw new RuntimeException("La categoria no puede ser vacia");
        }
        ArrayList<DtListaDeReproduccion> ret = new ArrayList();
        for (Map.Entry<String, Usuario> u : usuarios.entrySet()){
            ret.addAll(u.getValue().obtenerListasEnCategoria(cat));
        }
        return ret;
    }
    
    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccionDeUsuario(String nickname){
        /**
         * Devuelve todas las listas de reproduccion de usuarioSeleccionado o de usuarioActual segun el nickname indicado
         */
        if (nickname.equals("")){
            throw new RuntimeException("El nickname del usuario no puede ser vacio");
        }
        if (usuarioActual == null && usuarioSeleccionado == null){
        throw new RuntimeException("No hay usuarios seleccionados");
        }
        
        if (usuarioActual != null && usuarioActual.getNickname().equals(nickname)){
            return usuarioActual.listarListasDeReproduccionDeCanal(false);
        }
        if (usuarioSeleccionado != null && usuarioSeleccionado.getNickname().equals(nickname)){
            return usuarioSeleccionado.listarListasDeReproduccionDeCanal(false);
        }
        throw new RuntimeException("El nickname no coincide con los posibles usuarios seleccionados");
    }
    
    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccionParticularesDeUsuario(){
        /**
         * Devuelve las listas de reproduccion particulares de usuarioSeleccionado
         */
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        return usuarioSeleccionado.listarListasDeReproduccionDeCanal(true);
    }
    
    public ArrayList<DtUsuario> listarUsuarioSeguidores(){
        /**
         * Devuelve todos los usuarios que siguen a usuarioSeleccionado
         */
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        return usuarioSeleccionado.listarUsuariosSeguidores();
    }
    
    public ArrayList<DtUsuario> listarUsuarioNoSeguidos(){
        /**
         * Devuelve todos los usuarios a quienes sigue usuarioSeleccionado
         */
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        // creo el array de retorno y obtengo la lista de usuarios seguidos
        ArrayList<DtUsuario> noSeguidos = new ArrayList();
        ArrayList<DtUsuario> seguidos = listarUsuarioSeguidos();
        // para saber si hay que agregar a la lista de retorno o no
        boolean agregar;
        
        // no quiero que incluya al usuario seleccinado, asi que lo agrego para excluirlo
        seguidos.add(usuarioSeleccionado.getDT());
        
        // rrecorro los usuarios del sistema
        for (Map.Entry<String, Usuario> u : usuarios.entrySet()) {
            agregar = true;
            // recorro los usuarios seguidos para ver si debo agregar a u al array de retorno
            for (DtUsuario uSegido : seguidos){
                // si encuentra coincidencia, no debo agregarlo ya que es un usuario seguido
                if (u.getKey().equals(uSegido.getNickname())){
                    // lo saco del array para ahorrar procesamiento
                    seguidos.remove(uSegido);
                    agregar = false;
                    break;
                }
            }
            if (agregar){
                noSeguidos.add(u.getValue().getDT());
            }
        }
        return noSeguidos;
    }
    
    public ArrayList<DtUsuario> listarUsuarioSeguidos(){
        /**
         * Devuelve todos los usuarios a quienes sigue usuarioSeleccionado
         */
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        return usuarioSeleccionado.listarUsuariosSeguidos();
    }
    
    public ArrayList<DtUsuario> listarUsuarios(){
        /**
         * Devuelve todos los datos de todos los usuarios
         */
        ArrayList<DtUsuario> ret = new ArrayList<>();
        for (Map.Entry<String, Usuario> usuario : usuarios.entrySet()) {
              ret.add(usuario.getValue().getDT());
        }
        return ret;
    }
    
    public ArrayList<DtVideo> listarVideosEnCategoria(String cat){
        /**
         * Devuelve todos los videos del sistema que pertenezcan a la categoria indicada
         */
        if (cat.equals("")){
            throw new RuntimeException("La categoria no puede ser vacia");
        }
        ArrayList<DtVideo> ret = new ArrayList();
        for (Map.Entry<String, Usuario> u : usuarios.entrySet()){
            ret.addAll(u.getValue().obtenerVideosEnCategoria(cat));
        }
        return ret;
    }
    
    public ArrayList<DtVideo> listarVideosDeUsuario(){
        /**
         * Devuelve todos los videos de usuarioSeleccionado
         */
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        return usuarioSeleccionado.listarVideosDeCanal();
    }
    
    public ArrayList<DtVideo> listarVideosDeListaDeReproduccion(){
        /**
         * Devuelve los videos de la lista de reproduccion idListaSeleccionada
         */
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (idListaSeleccionada == 0){
            throw new RuntimeException("El sistema no tiene una lista de reproduccion seleccionado");
        }
        return usuarioSeleccionado.listarVideosDeListaDeReproduccion(idListaSeleccionada);
    }
    
    public void modificarListaDeReproduccion(DtListaDeReproduccion lista){
        /**
         * Se modifican los datos de la lista idListaSeleccionada
         */
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (idListaSeleccionada == 0){
            throw new RuntimeException("El sistema no tiene una lista de reproduccion seleccionado");
        }
        if (lista == null){
            throw new RuntimeException("El DataType recibido es null");
        }
        if ( ! existeCategoria(lista.getCategoria())){
            throw new RuntimeException("La categoria no existe");
        }
        // no confio en que el DataType recibido venga con el id del video correcto,
        // asi que creo otro y con el idVideoSeleccionado por las dudas
        DtListaDeReproduccion dtl = new DtListaDeReproduccion(
                idListaSeleccionada, 
                lista.getNombre(), 
                lista.getPrivacidad(), 
                lista.getTipo(), 
                lista.getCategoria());
        usuarioSeleccionado.modificarListaDeReproduccionDeCanal(dtl);
    }
    
    public void modificarUsuarioYCanal(DtUsuario usr,DtCanal canal){
        /**
         * Se modifican los datos de usuarioActual y su canal
         */
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (usr == null){
            throw new RuntimeException("El DataType usuario no puede ser null");
        }
        if (canal == null){
            throw new RuntimeException("El DataType canal no puede ser null");
        }
        usuarioSeleccionado.modificar(usr, canal);
    }
    
    public void modificarVideo(DtVideo video){
        /**
         * Se modifican los datos del video idVideoSeleccionado
         */
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        if (video == null){
            throw new RuntimeException("El DataType video no puede ser null");
        }
        if ( ! existeCategoria(video.getCategoria())){
            throw new RuntimeException("La categoria no existe");
        }
        // no confio en que el DataType recibido venga con el id del video correcto,
        // asi que creo otro y con el idVideoSeleccionado por las dudas
        DtVideo dtv = new DtVideo(
                idVideoSeleccionado, 
                video.getNombre(), 
                video.getDescripcion(), 
                video.getDuracion(), 
                video.getFechaPublicacion(), 
                video.getUrlVideoOriginal(), 
                video.getPrivacidad(), 
                video.getCategoria(), 
                0, 0);
        
        usuarioSeleccionado.modificarVideoDeCanal(dtv);
    }
    
    public DtCanal obtenerCanalDeUsuario(){
        /**
         * Devuelve los datos del canal del usuario en memoria usuarioSeleccionado
         */
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        return usuarioSeleccionado.obtenerCanal();
    }
    
    public ArrayList<DtValoracion> obtenerValoracionesDeVideo(){
        /**
         * Devuelve las valoraciones de idVideoSeleccionado
         */
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        return usuarioSeleccionado.listarValoracionesDeVideo(idVideoSeleccionado);
    }
    
    public DtValoracion obtenerValoracionDada(){
        /**
        *  Devuelve la valoracion dada por usuarioActual al video idVideoSeleccionado
        *
        */
        if (this.usuarioActual == null) {
            throw new RuntimeException("El sistema no tiene un usuario actual seleccionado");
        }
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        // si la funcion retorna null, significa que el usuario no lo ha valorado. Entonces no se considera error
        return usuarioSeleccionado.obtenerValoracion(idVideoSeleccionado, usuarioActual.getNickname());
    }
    
    public void quitarVideoDeListaDeReproduccion(int idVideo){
        /**
         * Quita el video idVideoSeleccionado de la lista idListaSeleccionada
         */
        if (usuarioSeleccionado == null) {
            throw new RuntimeException("El sistema no tiene un usuario actual seleccionado");
        }
        if (idListaSeleccionada == 0){
            throw new RuntimeException("El sistema no tiene una lista de reproduccion seleccionado");
        }
        if (idVideo == 0){
            throw new RuntimeException("El ID de video no es valido");
        }
        usuarioSeleccionado.quitarVideoDeListaDeReproduccion(idListaSeleccionada, idVideo);
    }
    
    public DtUsuario seleccionarUsuario(String nickname){
        /**
	*  El sistema recuerda un link al usuario como usuarioSeleccionado
	*  Devuelve los datos de usuarioSeleccionado
        */
        usuarioSeleccionado = usuarios.get(nickname);
        if (usuarioSeleccionado == null){
            throw new RuntimeException("No se encontro ningun usuario con ese nickname");
        }
        return usuarioSeleccionado.getDT();
    }
    
    public DtUsuario seleccionarUsuarioActual(String nickname){
        /**
        El sistema recuerda un link al usuario como usuarioActual
	Devuelve los datos de usuarioActual
        * */
        usuarioActual = usuarios.get(nickname);
        if (usuarioActual == null){
            throw new RuntimeException("No se encontro ningun usuario con ese nickname");
        }
        return usuarioActual.getDT();
    }
    
    public DtVideo seleccionarVideo(int idVideo){
	/**
        El sistema recuerda el ID del video como idVideoSeleccionado
	Devuelve los datos del video seleccionado
        */
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        DtVideo ret = usuarioSeleccionado.obtenerVideoDeCanal(idVideo);
        idVideoSeleccionado = idVideo;
        return ret;
    }
    
    public DtListaDeReproduccion seleccionarListaDeReproduccion(int idLista){
	/**
         * El sistema recuerda el ID de la lista como idListaSeleccionada
         * Devuelve los datos de la lista de reproduccion seleccionada perteneciente a usuarioSeleccionado
         */
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        DtListaDeReproduccion ret = usuarioSeleccionado.obtenerListaDeReproduccion(idLista);
        idListaSeleccionada = idLista;
        return ret;
    }
    
    public void seguirUsuario(){
        /**
         * El usuario usuarioActual comienza a seguir a usuarioSeleccionado En
         * caso de que este ya lo este siguiendo, lo deja de seguir
         */
        if (this.usuarioActual == null) {
            throw new RuntimeException("El sistema no tiene un usuario actual seleccionado");
        }
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        usuarioActual.agregarOQuitarSeguido(usuarioSeleccionado);
    }
    
    public boolean validarNuevaListaParticular(String nombre){
        /**
         * Devuelve false si usuarioSeleccionado posee una lista de reproducion con ese nombre
         */
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        ArrayList<String> l = ListaDeReproduccion.listarNombresDeListasPorDefecto();
        for (int i = 0; i < l.size(); i++){
            if (l.get(i).equals(nombre)){
                return false;
            }
        }
        return usuarioSeleccionado.validarListaParticular(nombre);
    }
    
    public boolean validarNuevaListaPorDefecto(String nombre){
        /**
         * Devuelve false si existe algun usuario en el sistema que posea una
         * lista de reproduccion con ese nombre
         */
        
        ArrayList<String> l = ListaDeReproduccion.listarNombresDeListasPorDefecto();
        for (int i = 0; i < l.size(); i++){
            if (l.get(i).equals(nombre)){
                return false;
            }
        }
        for (Map.Entry<String, Usuario> u : this.usuarios.entrySet()){
            if ( ! u.getValue().validarListaParticular(nombre)){
                return false;
            }
        }
        return true;
    }
}