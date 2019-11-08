package Logica.Controladores;

import JPAControllerClasses.BusquedaEnBDD;
import JPAControllerClasses.CategoriaJpaController;
import JPAControllerClasses.ImagenUsuarioJpaController;
import JPAControllerClasses.ListaPorDefectoJpaController;
import JPAControllerClasses.UsuarioJpaController;
import JPAControllerClasses.exceptions.NonexistentEntityException;
import Logica.Clases.Categoria;
import Logica.Clases.ImagenUsuario;
import Logica.Clases.ListaPorDefecto;
import Logica.Clases.Usuario;
import Logica.DataType.DtCanal;
import Logica.DataType.DtComentario;
import Logica.DataType.DtImagenUsuario;
import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtListaDeReproduccionHistorial;
import Logica.DataType.DtUsuario;
import Logica.DataType.DtValoracion;
import Logica.DataType.DtVideo;
import Logica.Enumerados.Filtrado;
import Logica.Enumerados.Ordenacion;
import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoListaDeReproduccion;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import Logica.Interfaces.IUsuario;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "Logica.Controladores.CUsuario")
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
  
    //***************** Traer datos de la base de datos *******************
    /**
     * Lista los usuarios no eliminados desde la base de datos
     * @return Mapa de usuarios indexados por nickname
     */
    private Map<String, Usuario> obtenerUsuarios(){
        Map<String, Usuario> usuarios = new TreeMap();
        try {
            List<Usuario> usuariosEnBDD = new UsuarioJpaController().findUsuarioEntities();
            for (Usuario u : usuariosEnBDD){
                usuarios.put(u.getNickname(), u);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return usuarios;
    }

    /**
     * Lista las categorias desde la base de datos
     * @return Mapa de categorias indexados por nombre
     */
    private Map<String, Categoria> obtenerCategorias(){
        Map<String, Categoria> categorias = new TreeMap();
        try {
            List<Categoria> categoriasEnBDD = new CategoriaJpaController().findCategoriaEntities();
            for (Categoria c : categoriasEnBDD){
                categorias.put(c.getNombre(), c);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return categorias;
    }
    
    /**
     * Lista los nombres de las listas por defecto desde la base de datos
     * @return Mapa de listas por defecto indexados por nombre
     */
    private Map<String, ListaPorDefecto> obtenerListasPorDefecto(){
        Map<String, ListaPorDefecto> ListasPorDefecto = new TreeMap();
        try {
            List<ListaPorDefecto> listasPorDefectoEnBDD = new ListaPorDefectoJpaController().findListaPorDefectoEntities();
            for (ListaPorDefecto l : listasPorDefectoEnBDD){
                ListasPorDefecto.put(l.getNombre(), l);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return ListasPorDefecto;
    }

    //******************** Funciones de la interfaz ************************
    @Override
    public DtListaDeReproduccionHistorial agregarVideoAHistorial() {
        if (usuarioActual == null){
            throw new RuntimeException("No se ha iniciado sesión");
        }
        if (usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        usuarioActual.agregarVideoAHistorial(idVideoSeleccionado, usuarioSeleccionado);
        //Siempre retorna null. 
        // si la hacia void el Web Service no publicaba la clase 'DtListaDeReproduccionHistorial'
        return null;
    }

    @Override
    public void agregarVideoAListaDeReproduccion(int idLista) {
        if (usuarioActual == null){
            throw new RuntimeException("No se ha iniciado sesión");
        }
        if (usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        if (idLista == 0){
            throw new RuntimeException("El ID de la lista de reproduccion no es valido");
        }
        usuarioActual.agregarVideoALista(idLista, idVideoSeleccionado, usuarioSeleccionado);
    }

    @Override
    public void altaComentario(DtComentario dtCom) {
        if (usuarioActual == null){
            throw new RuntimeException("No se ha iniciado sesión");
        }
        if (usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (dtCom == null){
            throw new RuntimeException("El DataType comentario no puede ser null");
        }
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        usuarioSeleccionado.agregarComentarioAVideo(idVideoSeleccionado, dtCom, usuarioActual);
    }

    @Override
    public void altaSubComentario(DtComentario dtCom, int idComPadre) {
        if (usuarioActual == null){
            throw new RuntimeException("No se ha iniciado sesión");
        }
        if (usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (dtCom == null){
            throw new RuntimeException("El DataType comentario no puede ser null");
        }
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        usuarioSeleccionado.agregarComentarioAVideo(idVideoSeleccionado, idComPadre, dtCom, usuarioActual);
    }

    @Override
    public void altaListaDeReproduccionParticular(DtListaDeReproduccion lista) {
        if (usuarioActual == null) {
            throw new RuntimeException("No se ha iniciado sesión");
        }
        if (lista == null) {
            throw new RuntimeException("El DataType recibido es null");
        }
        if ( ! this.obtenerCategorias().containsKey(lista.getCategoria())) {
            throw new RuntimeException("La categoria no existe");
        }
        usuarioActual.agregarListaParticular(lista);
    }

    @Override
    public void altaUsuarioCanal(DtUsuario usr, DtCanal canal) {
        // valida datos recibidos
        if (sesionIniciada()){
            throw new RuntimeException("Ya hay una sesión iniciada");
        }
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
        // obtiene las listas por defecto que el usuario debera crear
        ArrayList<String> listasDefault = new ArrayList();
        for (Map.Entry<String, ListaPorDefecto> lpd : this.obtenerListasPorDefecto().entrySet()) {
            listasDefault.add(lpd.getKey());
        }
        // Crea al usuario
        Usuario nuevoUsuario = new Usuario(
                usr.getNickname(), 
                usr.getCorreo(), 
                usr.getFechaNacimiento(), 
                usr.getImagen(), 
                usr.getContrasenia(), 
                usr.getNombre(), 
                usr.getApellido(), 
                canal
        );
        // persiste el usuario
        try {
            new UsuarioJpaController().create(nuevoUsuario);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        // Actualiza sus listas por defecto
        nuevoUsuario.actualizarListasPorDefecto(listasDefault);
        // Le inicia la sesion
        this.iniciarSesionUsuario(usr.getNickname(), usr.getContrasenia());
    }

    @Override
    public void altaVideo(DtVideo video) {
        if(usuarioActual == null){
            throw new RuntimeException("No se a iniciado sesión");
        }
        if (video == null) {
            throw new RuntimeException("El video no puede ser null");
        }
        if(!obtenerCategorias().containsKey(video.getCategoria())){
            throw new RuntimeException("La categoria no existe");
        }
        usuarioActual.agregarVideoACanal(video);
    }

    @Override
    public void bajaUsuario() {
        if(usuarioActual == null){
            throw new RuntimeException("No se a iniciado sesión");
        }
        // Bienvenido al parche
        // La verdad no sabia bien como implementar esta funcion, asi que mejor no reinventar la rueda, uso la que ya existe  aunque implique llamar al otro controlador...
        IAdmin ca = Fabrica.getInstancia().getIAdmin();
        ca.seleccionarUsuarioActual(usuarioActual.getNickname());
        cerrarSesion();
        ca.bajaUsuario();
    }

    @Override
    public ArrayList<Object> buscar(String busqueda, Filtrado filtro, Ordenacion orden) {
        //Cambiar la linea de abajo cuando se implemente la funcion de juan
        // hecho
        ArrayList<Object> ret = new BusquedaEnBDD().buscar(busqueda, filtro, orden);

        for (int i = 0; i < ret.size(); i++) {

            if (ret.get(i) instanceof DtVideo) {
                DtVideo vid = (DtVideo) ret.get(i);
                if (vid.getPrivacidad() == Privacidad.PRIVADO) {
                    try {
                        // Si el usuarioActual es null, o no posee un video con ese ID, se quita el elemento de la lista
                        this.usuarioActual.obtenerVideo(vid.getId());
                    } catch (Exception e) {
                        ret.remove(i);
                        i--;
                    }
                }
            } else if (ret.get(i) instanceof DtListaDeReproduccion) {
                DtListaDeReproduccion list = (DtListaDeReproduccion) ret.get(i);
                if (list.getPrivacidad() == Privacidad.PRIVADO) {
                    if (list.getTipo() == TipoListaDeReproduccion.POR_DEFECTO) {
                        ret.remove(i);
                        i--;
                    } else {
                        try {
                            // Si el usuarioActual es null, o no posee una lista con ese ID, se quita el elemento de la lista
                            this.usuarioActual.obtenerListaDeReproduccion(list.getId());
                        } catch (Exception e) {
                            ret.remove(i);
                            i--;
                        }
                    }
                }
            } else if (ret.get(i) instanceof DtCanal) {
                DtCanal canal = (DtCanal) ret.get(i);
                if (canal.getPrivacidad() == Privacidad.PRIVADO) { // Si el canal es privado...
                    if (sesionIniciada()) { // Si hay una sesion iniciada
                        if (this.usuarioActual.obtenerCanal().getId() != canal.getId()) { // si el canal no es el propio, se remueve
                            ret.remove(i);
                            i--;
                        }
                        // si no entro al if, el canal esprivado pero es propio, entonces no se quita
                    } else { // Si no hay una sesion iniciada, se quita el canal
                        ret.remove(i);
                        i--;
                    }
                }
            }
        }
        return ret;
    }

    @Override
    public ArrayList<Object> buscarPorCategoria(String categoria) {
        //Cambiar la linea de abajo cuando se implemente la funcion de juan
        // hecho
        ArrayList<Object> ret = new BusquedaEnBDD().buscarPorCategoria(categoria);

        for (int i = 0; i < ret.size(); i++) {
            
            if (ret.get(i) instanceof DtVideo) {
                DtVideo vid = (DtVideo) ret.get(i);
                if (vid.getPrivacidad() == Privacidad.PRIVADO) {
                    try {
                        // Si el usuarioActual es null, o no posee un video con ese ID, se quita el elemento de la lista
                        this.usuarioActual.obtenerVideo(vid.getId());
                    } catch (Exception e) {
                        ret.remove(i);
                        i--;
                    }
                }
            } else if (ret.get(i) instanceof DtListaDeReproduccion) {
                DtListaDeReproduccion list = (DtListaDeReproduccion) ret.get(i);
                if (list.getPrivacidad() == Privacidad.PRIVADO) {
                    if (list.getTipo() == TipoListaDeReproduccion.POR_DEFECTO) {
                        ret.remove(i);
                        i--;
                    } else {
                        try {
                            // Si el usuarioActual es null, o no posee una lista con ese ID, se quita el elemento de la lista
                            this.usuarioActual.obtenerListaDeReproduccion(list.getId());
                        } catch (Exception e) {
                            ret.remove(i);
                            i--;
                        }
                    }
                }
            }
        }
        return ret;
    }

    @Override
    public void cerrarSesion() {
        if(usuarioActual == null){
            throw new RuntimeException("No puedes cerrar sesión sin haberla iniciado");
        }
        usuarioActual = null;
    }


    @Override
    public boolean elUsuarioSeleccionadoEsElUsuarioActual(){
        if (usuarioActual == null || usuarioSeleccionado == null){
            return false;
        }
        return usuarioActual.getNickname().equals(usuarioSeleccionado.getNickname());
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
        if (usuarioActual != null){
            throw new RuntimeException("Ya hay un usuario con la sesión iniciada");
        }
        Map<String, Usuario> usuarios = obtenerUsuarios();
        boolean usuarioEncontrado = false;
        // Intenta obtener al usuario por nickname
        usuarioActual = usuarios.get(nickOEmail);
        if (usuarioActual == null){ // si NO lo encuentra por nickname
            // Recorre todos los usuarios buscandolo por su correo
            for (Map.Entry<String, Usuario> u : usuarios.entrySet()) {
                // Si encuentra al usuario con ese correo
                if (u.getValue().getCorreo().equals(nickOEmail)){
                    usuarioActual = u.getValue();
                    usuarioEncontrado = true;
                    break;
                }
            }
        }else{ // si lo encuentra por nickname
            usuarioEncontrado = true;
        }
        
        if (usuarioEncontrado){
            if (usuarioActual.validarContrasenia(contrasenia)){
                return true;
            }else{
                usuarioActual = null;
            }
        }
        return false;
    }

    @Override
    public void liberarMemoriaListaDeReproduccion(){
        idListaSeleccionada = 0;
    }
    
    @Override
    public void liberarMemoriaUsuario(){
        usuarioSeleccionado = null;
    }
    
    @Override
    public void liberarMemoriaVideo(){
        idVideoSeleccionado = 0;
    }
    
    @Override
    public ArrayList<String> listarCategorias() {
       Map<String, Categoria> categorias = obtenerCategorias();
       ArrayList<String> ret = new ArrayList<>();
       
        for (Map.Entry<String, Categoria> entry : categorias.entrySet()) {
           ret.add(entry.getKey());
        }
        return ret;
    }

    @Override
    public ArrayList<DtComentario> listarComentariosDeVideo() {
        if (this.usuarioSeleccionado == null) {
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        return usuarioSeleccionado.listarComentariosDeVideo(idVideoSeleccionado);
    }

    @Override
    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccionDeUsuario(boolean incluirListasPorDefecto) {
        if (this.usuarioSeleccionado == null) {
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        
       ArrayList<DtListaDeReproduccion> ret = usuarioSeleccionado.listarListasDeReproduccionDeCanal(false);
       
        if (elUsuarioSeleccionadoEsElUsuarioActual()) {
            // Se incluyen las privadas pero se quitan las POR_DEFECTO segun el parametro recibido
            if (incluirListasPorDefecto) {
                // se retorna todo
                return ret;
            } else {
                // Se quitan las listas POR_DEFECTO
                for (int i = 0; i < ret.size(); i++) {
                    if (ret.get(i).getTipo() == TipoListaDeReproduccion.POR_DEFECTO) {
                        ret.remove(i);
                        i--;
                    }
                }
                return ret;
            }
        } else {
            // si no se ha iniciado sesion, o si se inicio sesion pero el usuarioSeleccionado no es el usuarioActual
            // Solo se incluyen las listas Publicas, osea que se quitan todas las Privadas
            for (int i = 0; i < ret.size(); i++) {
                if (ret.get(i).getPrivacidad() == Privacidad.PRIVADO) {
                    ret.remove(i);
                    i--;
                }
            }
            return ret;
        }
    }

    @Override
    public ArrayList<DtUsuario> listarUsuarioSeguidores() {
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        return usuarioSeleccionado.listarUsuariosSeguidores();
    }

    @Override
    public ArrayList<DtUsuario> listarUsuarioSeguidos() {
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        return usuarioSeleccionado.listarUsuariosSeguidos();
    }

    @Override
    public ArrayList<DtUsuario> listarUsuarios() {
        ArrayList<DtUsuario> ret = new ArrayList<>();
        for (Map.Entry<String, Usuario> usuario : obtenerUsuarios().entrySet()) {
              ret.add(usuario.getValue().getDT());
        }
        return ret;
    }

    @Override
    public ArrayList<DtVideo> listarVideosDeListaDeReproduccion() {
        if (this.usuarioSeleccionado == null) {
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        ArrayList<DtVideo> ret = this.usuarioSeleccionado.listarVideosDeListaDeReproduccion(idListaSeleccionada);
        if (elUsuarioSeleccionadoEsElUsuarioActual()) {
            // incluye los videos privados si y solo si son del usuario actual
            // dicho de otra manera: quita los videos privados que no son del usuarioActual
            for (int i = 0; i < ret.size(); i++) {
                if (ret.get(i).getPrivacidad() == Privacidad.PRIVADO) {
                    try {
                        this.usuarioActual.obtenerVideo(ret.get(i).getId());
                    } catch (Exception e) {
                        ret.remove(i);
                        i--;
                    }
                }
            }
            return ret;
        } else {
            // Se devuelven solo los videos Publicos
            for (int i = 0; i < ret.size(); i++) {
                if (ret.get(i).getPrivacidad() == Privacidad.PRIVADO) {
                    ret.remove(i);
                    i--;
                }
            }
            return ret;
        }
    }

    @Override
    public ArrayList<DtVideo> listarVideosDeUsuario() {
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        
        if(elUsuarioSeleccionadoEsElUsuarioActual()){
            // se incluyen todos los videos
            return usuarioSeleccionado.listarVideosDeCanal();
        }else{
            // Se quitan los videos privados
            ArrayList<DtVideo> ret = this.usuarioSeleccionado.listarVideosDeCanal();
            for (int i = 0 ; i < ret.size(); i++) {
                if(ret.get(i).getPrivacidad() == Privacidad.PRIVADO){
                    ret.remove(i);
                    i--;
                }
            }
            return ret;
        }
    }

    @Override
    public void modificarListaDeReproduccion(DtListaDeReproduccion lista) {
         /**
         * Se modifican los datos de la lista idListaSeleccionada
         */
        if (this.usuarioActual == null){
            throw new RuntimeException("No se ha iniciado sesión");
        }
        if (idListaSeleccionada == 0){
            throw new RuntimeException("El sistema no tiene una lista de reproduccion seleccionado");
        }
        if (lista == null){
            throw new RuntimeException("El DataType recibido es null");
        }
        if (!this.obtenerCategorias().containsKey(lista.getCategoria())) {
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
        usuarioActual.modificarListaDeReproduccionDeCanal(dtl);
    }

    @Override
    public void modificarUsuarioYCanal(DtUsuario usr, DtCanal canal) {
        if (usuarioActual == null) {
            throw new RuntimeException("No se a iniciado la sesión");
        }
        if (usr == null) {
            throw new RuntimeException("Todos los datos del Usuario no pueden ser vacios");
        }
        if (canal == null) {
            throw new RuntimeException("Todos los datos del Canal no pueden ser vacios");
        }
        usuarioActual.modificar(usr, canal);
        
        try {
            new UsuarioJpaController().edit(usuarioActual);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void modificarVideo(DtVideo video) {
        if (usuarioActual == null) {
            throw new RuntimeException("No se a iniciado la sesión");
        }
        if (video == null) {
            throw new RuntimeException("Todos los datos del video no pueden ser vacios");
        }
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        if (!this.obtenerCategorias().containsKey(video.getCategoria())) {
            throw new RuntimeException("La categoria no existe");
        }
         
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
        usuarioActual.modificarVideoDeCanal(dtv);
    }

    @Override
    public DtCanal obtenerCanalDeUsuario() {
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        return usuarioSeleccionado.obtenerCanal();
    }
    
    @Override
    public DtUsuario obtenerPropietarioDeCanal(int idCanal){
        for (Map.Entry<String, Usuario> u : this.obtenerUsuarios().entrySet()){
            if (u.getValue().obtenerCanal().getId() == idCanal){
                return u.getValue().getDT();
            }
        }
        throw new RuntimeException("El iID de canal no crresponde a ningun usuario");
    }
    
    @Override
    public DtUsuario obtenerPropietarioDeVideo(int idVideo) {
        // Esto es un parche, pero de los que nunca se despegan...
        // A tiempos desesperados, medidas desesperadas
        for (Map.Entry<String, Usuario> u : this.obtenerUsuarios().entrySet()){
            try {
                u.getValue().obtenerVideo(idVideo);
                return u.getValue().getDT();
            } catch (Exception e) {
                // a seguir buscando
            }
        }
        throw new RuntimeException("El iID de video no crresponde a ningun usuario");
    }

    @Override
    public DtUsuario obtenerPropietarioDeListaDeReproduccion(int idLista) {
        // Esto es un parche, pero de los que nunca se despegan...
        // A tiempos desesperados, medidas desesperadas
        for (Map.Entry<String, Usuario> u : this.obtenerUsuarios().entrySet()){
            try {
                u.getValue().obtenerListaDeReproduccion(idLista);
                return u.getValue().getDT();
            } catch (Exception e) {
                // a seguir buscando
            }
        }
        throw new RuntimeException("El iID de video no crresponde a ningun usuario");
    }
    @Override
    public DtUsuario obtenerUsuarioActual(){
        if (usuarioActual == null){
            throw new RuntimeException("No se a iniciado la sesión");
        }
        return usuarioActual.getDT();
    }
    
    @Override
    public DtValoracion obtenerValoracionDada() {
        if (usuarioActual == null) {
            throw new RuntimeException("No se a iniciado la sesión");
        }
        if(usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        return usuarioSeleccionado.obtenerValoracion(idVideoSeleccionado, usuarioActual.getNickname());
    }

    @Override
    public ArrayList<DtValoracion> obtenerValoracionesDeVideo() {
        if(usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        return usuarioSeleccionado.listarValoracionesDeVideo(idVideoSeleccionado);
    }

    @Override
    public void quitarVideoDeListaDeReproduccion(int idVideo) {
        if(usuarioActual == null){
             throw new RuntimeException("No se a iniciado la sesión");
        }
        if (idListaSeleccionada == 0){
            throw new RuntimeException("El sistema no tiene una lista de reproduccion seleccionada");
        }
        usuarioActual.quitarVideoDeListaDeReproduccion(idListaSeleccionada,idVideo);
     
    }

    @Override
    public void seguirUsuario() {
        if (this.usuarioActual == null){
            throw new RuntimeException("No se ha iniciado sesión");
        }
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        usuarioActual.agregarOQuitarSeguido(usuarioSeleccionado);
        try {
            new UsuarioJpaController().edit(usuarioSeleccionado);
            new UsuarioJpaController().edit(usuarioActual);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public DtUsuario seleccionarUsuario(String nickname) {
        if (usuarioActual != null && usuarioActual.getNickname().equals(nickname)){
            usuarioSeleccionado = usuarioActual;
        }else{
            usuarioSeleccionado = obtenerUsuarios().get(nickname);
            if (usuarioSeleccionado == null){
                throw new RuntimeException("No se encontro ningun usuario con ese nickname");
            }
            if (usuarioSeleccionado.obtenerCanal().getPrivacidad() == Privacidad.PRIVADO){
                throw new RuntimeException("El canal seleccionado es privado");
            }
        }
        return usuarioSeleccionado.getDT();
    }

    @Override
    public DtListaDeReproduccion seleccionarListaDeReproduccion(int idLista) {
        if (this.usuarioSeleccionado == null){
            String nick = this.obtenerPropietarioDeListaDeReproduccion(idLista).getNickname();
            this.seleccionarUsuario(nick);
        }
        DtListaDeReproduccion ret = usuarioSeleccionado.obtenerListaDeReproduccion(idLista);
        if (ret.getPrivacidad() == Privacidad.PRIVADO){
            if ( ! elUsuarioSeleccionadoEsElUsuarioActual()){
                throw new RuntimeException("La lista de reproduccion seleccionada es privada");
            }
        }
        idListaSeleccionada = idLista;
        return ret;
    }

    @Override
    public DtVideo seleccionarVideo(int idVideo) {
        if (this.usuarioSeleccionado == null){
            String nick = this.obtenerPropietarioDeVideo(idVideo).getNickname();
            this.seleccionarUsuario(nick);
        }
        DtVideo ret = usuarioSeleccionado.obtenerVideoDeCanal(idVideo);
        if (ret.getPrivacidad() == Privacidad.PRIVADO){
            if ( ! elUsuarioSeleccionadoEsElUsuarioActual()){
                throw new RuntimeException("El video seleccionado es privado");
            }
        }
        idVideoSeleccionado = idVideo;
        return ret;
    }

    @Override
    public boolean sesionIniciada(){
        return (usuarioActual != null);
    }
    
    @Override
    public boolean validarNuevaListaParticular(String nombre, int idExcepcion) {
        if (this.usuarioActual == null){
            throw new RuntimeException("No se ha iniciado sesión");
        }
        if (obtenerListasPorDefecto().containsKey(nombre)) {
            return false;
        }
        for (DtListaDeReproduccion it : usuarioActual.listarListasDeReproduccionDeCanal(true)){
            if (it.getId() != idExcepcion){
                if (it.getNombre().equals(nombre)){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean validarNuevoVideo(String nombre, int idExcepcion) {
        if (this.usuarioActual == null){
            throw new RuntimeException("No se ha iniciado sesión");
        }
        for (DtVideo it : usuarioActual.listarVideosDeCanal()){
            if (it.getId() != idExcepcion){
                if (it.getNombre().equals(nombre)){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void valorarVideo(DtValoracion val) {
        if (this.usuarioActual == null){
            throw new RuntimeException("No se ha iniciado sesión");
        }
        if (usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        if (val == null){
            usuarioSeleccionado.quitarValoracion(idVideoSeleccionado, usuarioActual.getNickname());
        }else{
            usuarioSeleccionado.agregarModificarValoracionDeVideo(idVideoSeleccionado, val, usuarioActual);
        }
    }
    
    
    ///////// Operaciones con imagenes de usuarios //////////////////////
    
    @Override
    public DtImagenUsuario obtenerImagenDeUsuario(String id) throws RuntimeException {
        if ( ! existeImagenDeUsuario(id)){
            return obtenerImagenDeUsuarioPorDefecto();
        }
        try {
            ImagenUsuario iu = new ImagenUsuarioJpaController().findImagenUsuario(id);
            return new DtImagenUsuario(iu.getNickname(), iu.getImagen(), iu.getNombreArchivo());
        } catch (Exception ex) {
            Logger.getLogger(CUsuario.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Algo falló al intentar consultar la imagen\n" + ex.getMessage());
        }
    }

    @Override
    public void altaImagenDeUsuario(DtImagenUsuario iu) throws RuntimeException {
        if (existeImagenDeUsuario(iu.getNickname())) {
            modificarImagenDeUsuario(iu);
            return;
        }
        try {
            new ImagenUsuarioJpaController().create(
                    new ImagenUsuario(iu.getNickname(), iu.getImagen(), iu.getNombreArchivo())
            );
        } catch (Exception ex) {
            Logger.getLogger(CUsuario.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Algo falló al intentar guardar la imagen\n" + ex.getMessage());
        }
    }

    //new ImagenUsuarioJpaController().
    @Override
    public void modificarImagenDeUsuario(DtImagenUsuario iu) throws RuntimeException {
        if (!existeImagenDeUsuario(iu.getNickname())) {
            altaImagenDeUsuario(iu);
            return;
        }
        try {
            new ImagenUsuarioJpaController().edit(
                    new ImagenUsuario(iu.getNickname(), iu.getImagen(), iu.getNombreArchivo())
            );
        } catch (Exception ex) {
            Logger.getLogger(CUsuario.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Algo falló al intentar modificar la imagen\n" + ex.getMessage());
        }
    }

    @Override
    public void eliminarImagenDeUsuario(String id) throws RuntimeException {
        try {
            new ImagenUsuarioJpaController().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CUsuario.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Algo falló al intentar remover la imagen\n" + ex.getMessage());
        }
    }

    @Override
    public boolean existeImagenDeUsuario(String id) throws RuntimeException {
        return new ImagenUsuarioJpaController().findImagenUsuario(id) != null;
    }

    @Override
    public DtImagenUsuario obtenerImagenDeUsuarioPorDefecto() {
        try {
            InputStream in = getClass().getResourceAsStream("/imagenes/ukp.png");
            //File f = new File(getClass().getResource("/imagenes/ukp.png").getFile());
            //File f = new File(connection.getJarFileURL().toURI()); //asociamos el archivo fisico
            //InputStream is = new FileInputStream(f); //lo abrimos. Lo importante es que sea un InputStream
            byte[] buffer = new byte[(int) in.available()]; //creamos el buffer
            int readers = in.read(buffer); //leemos el archivo al buffer
            
            return new DtImagenUsuario("", buffer, "ukp.png");
            
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
