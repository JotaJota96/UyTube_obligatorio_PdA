package Logica.Controladores;

// Interfaz que se realizara
import JPAControllerClasses.AdministradorJpaController;
import JPAControllerClasses.CategoriaJpaController;
import JPAControllerClasses.ListaPorDefectoJpaController;
import JPAControllerClasses.UsuarioJpaController;
import Logica.Interfaces.IAdmin;
// DataTypes
import Logica.DataType.*;
// Clases necesarias
import Logica.Clases.Administrador;
import Logica.Clases.Usuario;
import Logica.Clases.Categoria;
import Logica.Clases.ListaPorDefecto;
import Logica.DatosDePrueba;
// Colecciones
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;


public class CAdmin implements IAdmin{
    private static CAdmin instancia = null;
    private Map<String, Usuario> usuarios;
    private Map<Integer, Administrador> administradores;
    private Map<String, Categoria> categorias;
    private Map<String, ListaPorDefecto> listasPorDefecto;
    private Usuario usuarioActual;
    private Usuario usuarioSeleccionado;
    private int idListaSeleccionada;
    private int idVideoSeleccionado;

    
    private CAdmin(){
        this.usuarios = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.administradores = new TreeMap();
        this.categorias = new TreeMap();
        this.listasPorDefecto = new TreeMap();
        this.usuarioActual = null;
        this.usuarioSeleccionado = null;
        this.idListaSeleccionada = 0;
        this.idVideoSeleccionado = 0;
        
        // si la categoria no esta en la BDD, la crea
        if ( ! existeCategoria("UNDEFINED")){
            this.altaCategoria("UNDEFINED");
        }
        
        sincronizarAdministradoresConBDD();
        sincronizarCategoriasConBDD();
        sincronizarListasPorDefectoConBDD();
        sincronizarUsuariosConBDD();
        
        // si en la BDD no hay administrador, lo crea
        if (this.administradores.isEmpty()) {
            // Administrador por defecto (temporal)
            Administrador root = new Administrador(0, "admin", "administrador", "root");
            try {
                new AdministradorJpaController().create(root);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
            this.administradores.put(root.getIdAdmin(), root);
        }
    }
    
    public static CAdmin getInstancia(){
        if( instancia == null ){
            instancia = new CAdmin();
        }
        return instancia;        
    }
    
    private void sincronizarUsuariosConBDD(){
        this.usuarios = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        try {
            List<Usuario> usuariosEnBDD = new UsuarioJpaController().findUsuarioEntities();
            for (Usuario u : usuariosEnBDD){
                // si en BDD hay algo que no este en memoria
                if ( ! this.usuarios.containsKey(u.getNickname())){
                    this.usuarios.put(u.getNickname(), u);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    private void sincronizarAdministradoresConBDD(){
        this.administradores = new TreeMap();
        try {
            List<Administrador> administradoresEnBDD = new AdministradorJpaController().findAdministradorEntities();
            for (Administrador a : administradoresEnBDD){
                // si en BDD hay algo que no este en memoria
                if ( ! this.administradores.containsKey(a.getIdAdmin())){
                    this.administradores.put(a.getIdAdmin(), a);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    private void sincronizarCategoriasConBDD(){
        this.categorias = new TreeMap();
        try {
            List<Categoria> categoriasEnBDD = new CategoriaJpaController().findCategoriaEntities();
            for (Categoria c : categoriasEnBDD){
                // si en BDD hay algo que no este en memoria
                if ( ! this.categorias.containsKey(c.getNombre())){
                    this.categorias.put(c.getNombre(), c);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    private void sincronizarListasPorDefectoConBDD(){
        this.listasPorDefecto = new TreeMap();
        try {
            List<ListaPorDefecto> listasPorDefectoEnBDD = new ListaPorDefectoJpaController().findListaPorDefectoEntities();
            for (ListaPorDefecto l : listasPorDefectoEnBDD){
                // si en BDD hay algo que no este en memoria
                if ( ! this.listasPorDefecto.containsKey(l.getNombre())){
                    this.listasPorDefecto.put(l.getNombre(), l);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    // ////////////////////////////////////////////////////////////////////////////////////////
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
        Categoria cat = new Categoria(categoria);
        categorias.put(cat.getNombre(), cat);
        try {
            new CategoriaJpaController().create(cat);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
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
    
    public void altaListaDeReproduccionParticular(DtListaDeReproduccion lista) {
        /**
         * Crea la lista de reproduccion para usuarioSeleccionado
         */
        if (usuarioSeleccionado == null) {
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        if (lista == null) {
            throw new RuntimeException("El DataType recibido es null");
        }
        if (!existeCategoria(lista.getCategoria())) {
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
        if (listasPorDefecto.containsKey(lista.getNombre())){
            throw new RuntimeException("El sistema ya posee una lista de reproduccion por defecto con ese nombre");
        }
        ListaPorDefecto lpd = new ListaPorDefecto(lista.getNombre());
        try {
            new ListaPorDefectoJpaController().create(lpd);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        listasPorDefecto.put(lista.getNombre(), lpd);
        ArrayList<String> nuevaLista = new ArrayList();
        nuevaLista.add(lista.getNombre());
        for (Map.Entry<String, Usuario> u : usuarios.entrySet()){
            u.getValue().actualizarListasPorDefecto(nuevaLista);
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
        
        ArrayList<String> listasDefault = new ArrayList();
        for (Map.Entry<String, ListaPorDefecto> lpd : listasPorDefecto.entrySet()) {
            listasDefault.add(lpd.getKey());
        }
        
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
        try {
            new UsuarioJpaController().create(nuevoUsuario);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        nuevoUsuario.actualizarListasPorDefecto(listasDefault);
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
        if (idVideoSeleccionado == 0){
            throw new RuntimeException("El sistema no tiene un video seleccionado");
        }
        if (val == null){
            usuarioSeleccionado.quitarValoracion(idVideoSeleccionado, usuarioActual.getNickname());
        }else{
            usuarioSeleccionado.agregarModificarValoracionDeVideo(idVideoSeleccionado, val, usuarioActual);
        }
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
    
    public void bajaUsuario(){
        /**
         * Elimina el usuario actual seleccionado
         */
        /**
         * Este algoritmo debe:
         * Quitar las relaciones con usuarios seguidos y de seguidores
         * Quitar los videos del usuario a eliminar de las listas de otros usuarios.
         * Quitar comentarios en los videos del usuario a eliminar
         * Quitar valoraciones en los videos del usuario a eliminar
         * Quitar las valoraciones dadas por el usuario de todos los videos del sistema
         * Quitar los comentarios hechos por el usuario de todos los videos del sistema
         * 
         */
        
        Usuario elim = usuarioActual;

        // * Quitar las relaciones con usuarios seguidos y de seguidores
        // El usuario que se va a eliminar deja de seguir a todos los que sigue
        ArrayList<DtUsuario> seguidos = usuarioActual.listarUsuariosSeguidos();
        for (DtUsuario u : seguidos) {
            this.seleccionarUsuario(u.getNickname());
            this.seguirUsuario();
        }
        this.liberarMemoriaUsuario();
        
        // Todos los usuarios que siguen al que se va a eliminar, lo dejan de seguir
        ArrayList<DtUsuario> seguidores = usuarioActual.listarUsuariosSeguidores();
        this.seleccionarUsuario(usuarioActual.getNickname());
        for (DtUsuario u : seguidores) {
            this.seleccionarUsuarioActual(u.getNickname());
            this.seguirUsuario();
       }
        this.liberarMemoriaUsuario();
        this.seleccionarUsuarioActual(elim.getNickname());

        // para cada usuario del sistema, recorro todas sus listas y en cada 
        // una manda a quitar todoslos videos del usuario a eliminar
        this.seleccionarUsuario(elim.getNickname());
        ArrayList<DtVideo> videos = this.listarVideosDeUsuario();
        // Para facilitar el algoritmo, agrego a la coleccion (de manera provisoria) los usuarios eliminados
        // ¡Recuerdo los nicknames para sacarlos despues!
        ArrayList<String> nicksProvisorios = new ArrayList();
        try {
            for (Usuario u : new UsuarioJpaController().findUsuarioEliminadoEntities()){
                nicksProvisorios.add(u.getNickname());
                this.usuarios.put(u.getNickname(), u);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        
        for (Map.Entry<String, Usuario> it : usuarios.entrySet()){
            if (it.getValue().getNickname().equals(elim.getNickname())) continue;
            
            // * Quitar los videos del usuario a eliminar de las listas de otros usuarios.
            ArrayList<DtListaDeReproduccion> listas = it.getValue().listarListasDeReproduccionDeCanal(false);
            for (DtListaDeReproduccion l : listas){
                for (DtVideo v : videos){
                    it.getValue().quitarVideoDeListaDeReproduccion(l.getId(), v.getId());
                }
            }
            
            // * Quitar las valoraciones dadas por el usuario de todos los videos del sistema
            // * Quitar los comentarios hechos por el usuario de todos los videos del sistema
            it.getValue().eliminarTodoRastroDelUsuario(elim.getNickname());
            try {
                new UsuarioJpaController().edit(it.getValue());
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        
        // quito de la coleccion los usuarios que estaban eliminados y agregue provisoriamente antes del for
        for (String s : nicksProvisorios){
            this.usuarios.remove(s);
        }
        
        // obtiene la fecha actual
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date hoy = new java.sql.Date(utilDate.getTime());

        // * Quitar comentarios en los videos del usuario a eliminar
        // * Quitar valoraciones en los videos del usuario a eliminar
        usuarioActual.eliminar(hoy);
        try {
            new UsuarioJpaController().edit(usuarioActual);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        this.usuarios.remove(elim.getNickname());
    }
    
    
    public boolean existeCategoria(String cat){
        /**
         * Verifica si existe una categoria con el nombre recibido
         */
        sincronizarCategoriasConBDD();
        return categorias.containsKey(cat);
    }
    
    public boolean existeEmail(String email){
        /**
         * Verifica si existe un usuario con el mail recibido
         */
        sincronizarUsuariosConBDD();
        for (Map.Entry<String, Usuario> u : usuarios.entrySet()){
            if (u.getValue().getCorreo().equals(email)){
                return true;
            }
        }
        for (DtUsuario dtu : this.listarUsuariosEliminados()){
            if (dtu.getCorreo().equals(email)){
                return true;
            }
        }
        return false;
    }
    
    public boolean existeNickname(String nickname){
        /**
         * Verifica si existe un usuario con el nickname recibido
         */
        sincronizarUsuariosConBDD();
        if (usuarios.containsKey(nickname)){
            return true;
        }
        for (DtUsuario dtu : this.listarUsuariosEliminados()){
            if (dtu.getNickname().equals(nickname)){
                return true;
            }
        }
        return false;
    }
    
    public boolean iniciarSesionAdministrador(int id, String pass){
        /**
         * Verifica la contrasenia para el administrador con esa ID y devuelve true si es correcta
         * En cualquier otro caso devuelve false
         */
        sincronizarAdministradoresConBDD();
        Administrador a = administradores.get(id);
        if (a == null){
            return false;
        }
        return a.validarContrasenia(pass);
    }
    
    public boolean iniciarSesionUsuario(String nickname, String pass){
        sincronizarUsuariosConBDD();
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
        sincronizarCategoriasConBDD();
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
        sincronizarUsuariosConBDD();
        sincronizarCategoriasConBDD();
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
        sincronizarUsuariosConBDD();
        ArrayList<DtUsuario> ret = new ArrayList<>();
        for (Map.Entry<String, Usuario> usuario : usuarios.entrySet()) {
              ret.add(usuario.getValue().getDT());
        }
        return ret;
    }
    
    public ArrayList<DtUsuario> listarUsuariosEliminados(){
        /**
         * Devuelve todos los datos de todos los usuarios eliminados
         */
        ArrayList<DtUsuario> ret = new ArrayList();
        try {
            for (Usuario u : new UsuarioJpaController().findUsuarioEliminadoEntities()){
                ret.add(u.getDT());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
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
        sincronizarUsuariosConBDD();
        sincronizarCategoriasConBDD();
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
        try {
            new UsuarioJpaController().edit(usuarioSeleccionado);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
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
    
    public DtUsuario obtenerPropietarioDeVideo(int idVideo){
        /**
         * Busca entre todos los usuarios al propietario del video con ese ID
         */
        
        sincronizarUsuariosConBDD();
        // Esto es un parche, pero de los que nunca se despegan...
        // A tiempos desesperados, medidas desesperadas
        for (Map.Entry<String, Usuario> u : usuarios.entrySet()){
            try {
                u.getValue().obtenerVideo(idVideo);
                return u.getValue().getDT();
            } catch (Exception e) {
                // a seguir buscando
            }
        }
        throw new RuntimeException("El iID de video no crresponde a ningun usuario");
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
        sincronizarUsuariosConBDD();
        usuarioSeleccionado = usuarios.get(nickname);
        if (usuarioSeleccionado == null){
            throw new RuntimeException("No se encontro ningun usuario con ese nickname");
        }
        return usuarioSeleccionado.getDT();
    }
    
    public DtUsuario seleccionarUsuarioEliminado(String nickname){
        /**
         * El sistema recuerda un link al usuario eliminado como usuarioActual Devuelve
         * los datos de usuarioActual
         */
        try {
            usuarioSeleccionado = new UsuarioJpaController().findUsuario(nickname);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        if (usuarioSeleccionado == null){
            throw new RuntimeException("No se encontro ningun usuario con ese nickname");
        }
        return usuarioSeleccionado.getDT();
    }
    
    public DtUsuario seleccionarUsuarioActual(String nickname){
        /**
         * El sistema recuerda un link al usuario como usuarioActual Devuelve
         * los datos de usuarioActual
         */
        sincronizarUsuariosConBDD();
        usuarioActual = usuarios.get(nickname);
        if (usuarioActual == null){
            throw new RuntimeException("No se encontro ningun usuario con ese nickname");
        }
        return usuarioActual.getDT();
    }
    
    public DtVideo seleccionarVideo(int idVideo){
	/**
        El sistema recuerda el ID del video como idVideoSeleccionado Devuelve
         * los datos del video seleccionado
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
        try {
            new UsuarioJpaController().edit(usuarioSeleccionado);
            new UsuarioJpaController().edit(usuarioActual);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public boolean validarNuevaListaParticular(String nombre){
        /**
         * Devuelve false si usuarioSeleccionado posee una lista de reproducion con ese nombre
         */
        if (this.usuarioSeleccionado == null){
            throw new RuntimeException("El sistema no tiene un usuario seleccionado");
        }
        sincronizarListasPorDefectoConBDD();
        if (listasPorDefecto.containsKey(nombre)) {
            return false;
        }
        return usuarioSeleccionado.validarListaParticular(nombre);
    }
    
    public boolean validarNuevaListaPorDefecto(String nombre){
        /**
         * Devuelve false si existe algun usuario en el sistema que posea una
         * lista de reproduccion con ese nombre
         */
        sincronizarListasPorDefectoConBDD();
        sincronizarUsuariosConBDD();
        if (listasPorDefecto.containsKey(nombre)) {
            return false;
        }
        for (Map.Entry<String, Usuario> u : this.usuarios.entrySet()){
            if ( ! u.getValue().validarListaParticular(nombre)){
                return false;
            }
        }
        return true;
    }
}

