package Logica.Interfaces;

import Logica.DataType.*;
import java.util.ArrayList;

public interface IAdmin {

    /**
     * Agrega el video idVideoSeleccionado a la lista indicada
     *
     * @param idLista ID de la lista a la cual se agrega el video
     */
    public void agregarVideoAListaDeReproduccion(int idLista);

    /**
     * Crea la categoria con el nombre indicado
     *
     * @param categoria nombre de la categoria
     */
    public void altaCategoria(String categoria);

    /**
    * Comenta el video idVideoSeleccionado a nombre de usuarioActual
     *
     * @param dtCom Comentario a agregar
     */
    public void altaComentario(DtComentario dtCom);

    /**
    * Comenta el comentario con dicho ID a nombre de usuarioActual
     *
     * @param dtCom Comentario a agregar
     * @param idComPadre ID del comentario a responder
     */
    public void altaComentario(DtComentario dtCom, int idComPadre);

    /**
    * Crea la lista de reproduccion para usuarioSeleccionado
     *
     * @param lista Lista particular a agregar
     */
    public void altaListaDeReproduccionParticular(DtListaDeReproduccion lista);

    /**
     * Crea la lista de reproduccion para todos los usuarios del sistema y la
     * agrega listas por defecto (para que se creen al crear un usuario nuevo)
     *
     * @param lista Lista por defecto a agregar
     */
    public void altaListaDeReproduccionPorDefecto(DtListaDeReproduccion lista);

    /**
     * Crea un usuario y su canal a partir de los datos recibidos
     *
     * @param usr Datos del usuario a dar de alta
     * @param canal Datos del canal del usuario
     */
    public void altaUsuarioCanal(DtUsuario usr, DtCanal canal);

    /**
     * Se ingresa la nueva valoracion dada por usuarioActual al video
     * idVideoSeleccionado Si el usuario ya habia valorado, se actualiza la
     * valoracion dada
     *
     * @param val Valoracion dada
     */
    public void altaValoracion(DtValoracion val);

    /**
     * Se crea un video nuevo en el canal de usuarioSeleccionado
     *
     * @param video Datos del video a dar de alta
     */
    public void altaVideo(DtVideo video);

    /**
     * Elimina el usuario actual seleccionado
     */
    public void bajaUsuario();

    /**
     * Verifica si existe una categoria con el nombre recibido
     *
     * @param cat Nombre de la categoria a verificar
     * @return true si la categoria ya existe
     */
    public boolean existeCategoria(String cat);

    /**
     * Verifica si existe un usuario con el mail recibido
     *
     * @param email Correo a verificar
     * @return true si el correo ya esta en uso
     */
    public boolean existeEmail(String email);

    /**
     * Verifica si existe un usuario con el nickname recibido
     *
     * @param nickname Nickname a verificar
     * @return true si el nickname ya esta en uso
     */
    public boolean existeNickname(String nickname);

    /**
     * Inicio de sesion para administradores
     *
     * @param id ID del administrador
     * @param pass contraseña del administrador
     * @return true si el ID existe y la contraseña es correcta
     */
    public boolean iniciarSesionAdministrador(int id, String pass);

    /**
     * Libera memoria de la lista de reproduccion seleccionada
     */
    public void liberarMemoriaListaDeReproduccion();

    /**
     * Libera memoria del usuario seleccionado
     */
    public void liberarMemoriaUsuario();

    /**
     * Libera memoria del usuario actual seleccionado
     */
    public void liberarMemoriaUsuarioActual();

    /**
     * Libera memoria del video seleccionado
     */
    public void liberarMemoriaVideo();

    /**
     * Devuelve todas las categorias existentes en el sistema
     *
     * @return Conjunto de nombres de categorías
     */
    public ArrayList<String> listarCategorias();

    /**
     * Devuelve en forma ordenada (recursiva ) todos los comentarios de
     * idVideoSeleccionado
     *
     * @return Conjunto de comentarios
     */
    public ArrayList<DtComentario> listarComentariosDeVideo();

    /**
     * Devuelve todos las listas de reproduccion del sistema que pertenezcan a
     * la categoria indicada
     *
     * @param cat Nombre de categoría
     * @return Conjunto de listas de reproduccion
     */
    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccionEnCategoria(String cat);

    /**
     * Devuelve todas las listas de reproduccion de usuarioSeleccionado o de
     * usuarioActual segun el nickname indicado
     *
     * @param nickname Nickname del usuario seleccionado o del usuario actual
     * @return Conjunto de listas de reproduccion
     */
    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccionDeUsuario(String nickname);

    /**
     * Devuelve las listas de reproduccion particulares de usuarioSeleccionado
     *
     * @return Conjunto de listas de reproduccion
     */
    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccionParticularesDeUsuario();

    /**
     * Devuelve todos los usuarios que siguen a usuarioSeleccionado
     *
     * @return Conjunto de usuarios
     */
    public ArrayList<DtUsuario> listarUsuarioSeguidores();

    /**
     * Devuelve todos los usuarios a quienes NO sigue usuarioSeleccionado
     *
     * @return Conjunto de usuarios
     */
    public ArrayList<DtUsuario> listarUsuarioNoSeguidos();

    /**
     * Devuelve todos los usuarios a quienes sigue usuarioSeleccionado
     *
     * @return Conjunto de usuarios
     */
    public ArrayList<DtUsuario> listarUsuarioSeguidos();

    /**
     * Devuelve todos los datos de todos los usuarios
     *
     * @return Conjunto de usuarios
     */
    public ArrayList<DtUsuario> listarUsuarios();

    /**
     * Devuelve todos los datos de todos los usuarios eliminados
     *
     * @return Conjunto de usuarios
     */
    public ArrayList<DtUsuario> listarUsuariosEliminados();

    /**
     * Devuelve todos los videos del sistema que pertenezcan a la categoria
     * indicada
     *
     * @param cat Nombre de categoría
     * @return Conjunto de videos
     */
    public ArrayList<DtVideo> listarVideosEnCategoria(String cat);

    /**
     * Devuelve todos los videos de usuarioSeleccionado
     *
     * @return Conjunto de videos
     */
    public ArrayList<DtVideo> listarVideosDeUsuario();

    /**
     * Devuelve los videos de la lista de reproduccion idListaSeleccionada
     *
     * @return Conjunto de videos
     */
    public ArrayList<DtVideo> listarVideosDeListaDeReproduccion();

    /**
     * Se modifican los datos de la lista idListaSeleccionada
     *
     * @param lista Datos de la lista de reproduccion
     */
    public void modificarListaDeReproduccion(DtListaDeReproduccion lista);

    /**
     * Se modifican los datos de usuarioActual y su canal
     *
     * @param usr Datos del usuario
     * @param canal Datos del canal
     */
    public void modificarUsuarioYCanal(DtUsuario usr, DtCanal canal);

    /**
     * Se modifican los datos del video idVideoSeleccionado
     *
     * @param video Datos del video
     */
    public void modificarVideo(DtVideo video);

    /**
     * Busca entre todos los usuarios al propietario del video con ese ID
     *
     * @param idVideo ID del video
     * @return Datos del usuario
     */
    public DtUsuario obtenerPropietarioDeVideo(int idVideo);

    /**
     * Devuelve los datos del canal del usuario en memoria usuarioSeleccionado
     *
     * @return Datos del canal
     */
    public DtCanal obtenerCanalDeUsuario();

    /**
     * Devuelve las valoraciones de idVideoSeleccionado
     *
     * @return Conjunto de valoraciones
     */
    public ArrayList<DtValoracion> obtenerValoracionesDeVideo();

    /**
     * Devuelve la valoracion dada por usuarioActual al video
     * idVideoSeleccionado
     *
     * @return Valoracion dada o null si no ha valorado
     */
    public DtValoracion obtenerValoracionDada();

    /**
     * Quita el video idVideoSeleccionado de la lista idListaSeleccionada
     * @param idVideo ID del video
     */
    public void quitarVideoDeListaDeReproduccion(int idVideo);

    /**
     * Quita el video idVideoSeleccionado de la lista idListaSeleccionada
     *
     * @param nickname Nickname del usuario
     * @return Datos del usuario
     */
    public DtUsuario seleccionarUsuario(String nickname);

    /**
     * El sistema recuerda un link al usuario como usuarioActual Devuelve los
     * datos de usuarioActual
     *
     * @param nickname Nickname del usuario
     * @return Datos del usuario
     */
    public DtUsuario seleccionarUsuarioActual(String nickname);

    /**
     * El sistema recuerda un link al usuario eliminado como usuarioSeleccionado
     * Devuelve los datos de usuarioActual
     *
     * @param nickname Nickname del usuario
     * @return Datos del usuario
     */
    public DtUsuario seleccionarUsuarioEliminado(String nickname);

    /**
     * El sistema recuerda el ID del video como idVideoSeleccionado Devuelve los
     * datos del video seleccionado
     *
     * @param idVideo ID del video
     * @return Datos del video
     */
    public DtVideo seleccionarVideo(int idVideo);

    /**
     * El sistema recuerda el ID de la lista como idListaSeleccionada Devuelve
     * los datos de la lista de reproduccion seleccionada perteneciente a
     * usuarioSeleccionado
     *
     * @param idLista ID de la lista de reproduccion
     * @return Datos de la lista de reproduccion
     */
    public DtListaDeReproduccion seleccionarListaDeReproduccion(int idLista);

    /**
     * El usuario usuarioActual comienza a seguir a usuarioSeleccionado En caso
     * de que este ya lo este siguiendo, lo deja de seguir
     */
    public void seguirUsuario();

    /**
     * Devuelve false si usuarioSeleccionado posee una lista de reproducion con
     * ese nombre
     *
     * @param nombre Nombre de la lista de reproduccion
     * @return true si el usuario no posee ya una lista de reproduccion con ese
     * nombre
     */
    public boolean validarNuevaListaParticular(String nombre);

    /**
     * Devuelve false si existe algun usuario en el sistema que posea una lista
     * de reproduccion con ese nombre
     *
     * @param nombre Nombre de la lista de reproduccion
     * @return true si ningun usuario posee una lista con ese nombre, y ademas
     * no existen listas por defecto con ese nombre
     */
    public boolean validarNuevaListaPorDefecto(String nombre);

    ///////// Operaciones con imagenes de usuarios //////////////////////
    /**
     * Devuelve los datos de la imagen del usuario con ese ID
     *
     * @param id ID del usuario del cual se quiere obtener la imagen
     * @return Datos del usuario si existe, o null si no se encontro
     */
    public DtImagenUsuario obtenerImagenDeUsuario(String id) throws RuntimeException;

    /**
     * Persiste una nueva imagen de usuario
     *
     * @param iu Datos de la imagen del usuario
     */
    public void altaImagenDeUsuario(DtImagenUsuario iu) throws RuntimeException;

    /**
     * Modifica los datos de la imagen de usuario
     *
     * @param iu Datos de la imagen del usuario
     */
    public void modificarImagenDeUsuario(DtImagenUsuario iu) throws RuntimeException;

    /**
     * Elimina la imagen del usuario
     *
     * @param id ID del usuario
     */
    public void eliminarImagenDeUsuario(String id) throws RuntimeException;

    /**
     * Comprueba si el usuario con el ID indicado posee imagen de perfil
     * persistida
     *
     * @param id ID del usuario
     * @return true si el usuario tiene una imagen de perfil persistida
     */
    public boolean existeImagenDeUsuario(String id) throws RuntimeException;
    
    /**
     * Devuelve la imagen de usuario por defecto
     * 
     * @return Imagen de usuario por defecto
     */
    public DtImagenUsuario obtenerImagenDeUsuarioPorDefecto();
    
}
