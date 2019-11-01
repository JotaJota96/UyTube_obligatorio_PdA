package Logica.Interfaces;

import Logica.DataType.*;
import Logica.Enumerados.*;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface IUsuario {

    /**
     * Agrega el video idVideoSeleccionado que pertenece a usuarioSeleccionado,
     * a la lista indicada perteneciente a usuarioActual
     *
     * @param idLista ID de la lista de reproduccon
     */
    @WebMethod
    public void agregarVideoAListaDeReproduccion(int idLista);

    /**
     * Comenta el video idVideoSeleccionado perteneciente a usuarioSeleccionado,
     * a nombre de usuarioActual
     *
     * @param dtCom Comentario a agregar
     */
    @WebMethod
    public void altaComentario(DtComentario dtCom);

    /**
     * Comenta a nombre de usuarioActual, el comentario con el ID indicado, que
     * pertenece al video idVideoSeleccionado, que pertenece a
     * usuarioSeleccionado
     *
     * @param dtCom Comentario a agregar
     * @param idComPadre ID del comentario a responder
     */
    @WebMethod
    public void altaSubComentario(DtComentario dtCom, int idComPadre);

    /**
     * Da de alta la lista de reproduccion particular para usuarioActual
     *
     * @param lista Lista particular a dar de alta
     */
    @WebMethod
    public void altaListaDeReproduccionParticular(DtListaDeReproduccion lista);

    /**
     * Da de alta un usuario y su canal a partir de los datos recibidos
     * Luego de darlo de alta, el usuario queda con la sesión iniciada
     *
     * @param usr Datos del usuario a dar de alta
     * @param canal Datos del canal del usuario
     */
    @WebMethod
    public void altaUsuarioCanal(DtUsuario usr, DtCanal canal);

    /**
     * Da de alta un video en el canal de usuarioActual
     *
     * @param video Datos del video a dar de alta
     */
    @WebMethod
    public void altaVideo(DtVideo video);

    /**
     * Da de baja al usuarioActual
     * En el proceso se cierra la sesion
     */
    @WebMethod
    public void bajaUsuario();

    /**
     * Busca contenido por coincidencia de texto en nombre o descripcion de los
     * contenidos del sistema En el resultado se incluirán (si corresponde segun
     * el filtrado) los videos privados del usuarioActual
     * Si no se ha iniciado sesión, se muestran sólo los contenidos públicos
     * 
     * @param busqueda Texto a buscarPorCategoria (si es vacío incluye todo el contenido)
     * @param filtro Tipo de contenido en el cual se realizará la búsqueda
     * @param orden Manera de ordenar el resultado de la búsqueda
     * @return Resultado de la busqueda. Puede contener DtVideo,
     * DtListaDeReproduccion y/o DtCanal. (para usar los elementos devueltos hay
     * que castearlos)
     */
    @WebMethod
    public ArrayList<Object> buscar(String busqueda, Filtrado filtro, Ordenacion orden);

    /**
     * Busca contenido que pertenezcan a la categoria indicada El Resultado
     * contendrá todos los contenidos publicos, y los contenidos privados del
     * usuarioActual
     * Si no se ha iniciado sesión, se muestran sólo los contenidos públicos
     * 
     * @param categoria Nombre de la categoria a buscarPorCategoria
     * @return Resultado de la busqueda. Puede contener DtVideo y
     * DtListaDeReproduccion. (para usar los elementos devueltos hay que
     * castearlos)
     */
    @WebMethod
    public ArrayList<Object> buscarPorCategoria(String categoria);

    /**
     * Cierra la sesión del usuarioActual (lo quita de memoria)
     */
    @WebMethod
    public void cerrarSesion();

    /**
     * Como el nombre de la funcion lo indica, es para saber si el usuario que
     * se ha seleccionado, es el usuario que tiene la inicion sesiada
     *
     * @return true si el usuario seleccionado es el usuario que inicio la
     * sesion
     */
    @WebMethod
    public boolean elUsuarioSeleccionadoEsElUsuarioActual();
    
    /**
     * Verifica si existe un usuario con el email indicado
     *
     * @param email Email a verificar
     * @return true si el email ya esta en uso
     */
    @WebMethod
    public boolean existeEmail(String email);

    /**
     * Verifica si existe un usuario con el nickname indicado
     *
     * @param nickname Nickname a verificar
     * @return true si el nickname ya esta en uso
     */
    @WebMethod
    public boolean existeNickname(String nickname);

    /**
     * Inicia la sesión del usuario. Si los datos son correctos se guarda al
     * usuario como usuarioActual
     *
     * @param nickOEmail Nickname o email del usuario
     * @param contrasenia Contraseña del usuario
     * @return true si el usuario con el nickname o email existe y ademas la
     * contrasenia es correcta
     */
    @WebMethod
    public boolean iniciarSesionUsuario(String nickOEmail, String contrasenia);

    /**
     * Libera memoria de la lista de reproduccion seleccionada
     */
    @WebMethod
    public void liberarMemoriaListaDeReproduccion();

    /**
     * Libera memoria del usuario seleccionado
     */
    @WebMethod
    public void liberarMemoriaUsuario();

    /**
     * Libera memoria del video seleccionado
     */
    @WebMethod
    public void liberarMemoriaVideo();

    /**
     * Devuelve todas las categorias existentes en el sistema
     *
     * @return Conjunto de nombres de categorías
     */
    @WebMethod
    public ArrayList<String> listarCategorias();

    /**
     * Devuelve en forma ordenada (recursiva) todos los comentarios de
     * idVideoSeleccionado perteneciente a usuarioSeleccionado
     *
     * @return Conjunto de comentarios
     */
    @WebMethod
    public ArrayList<DtComentario> listarComentariosDeVideo();

    /**
     * Devuelve las listas de reproduccion del usuarioSeleccionado Si el
     * usuarioSeleccionado es el usuarioActual, y se incluyen las listas por
     * defecto: devuelve todas las listas del usuarioSeleccionado. Si el
     * usuarioSeleccionado es el usuarioActual, y NO se incluyen las listas por
     * defecto: devuelve las listas particulares (privadas y publicas) del
     * usuarioSeleccionado Si el usuarioSeleccionado NO ES el usuarioActual:
     * devuelve solo las listas publicas
     *
     * @param incluirListasPorDefecto True si se desea incluir en el listado las
     * listas por defecto
     * @return Conjunto de listas de reproduccion
     */
    @WebMethod
    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccionDeUsuario(boolean incluirListasPorDefecto);

    /**
     * Devuelve todos los usuarios que siguen a usuarioSeleccionado
     *
     * @return Conjunto de usuarios
     */
    @WebMethod
    public ArrayList<DtUsuario> listarUsuarioSeguidores();

    /**
     * Devuelve todos los usuarios a los que sigue usuarioSeleccionado
     *
     * @return Conjunto de usuarios
     */
    @WebMethod
    public ArrayList<DtUsuario> listarUsuarioSeguidos();

    /**
     * Devuelve todos los datos de todos los usuarios del sistema
     *
     * @return Conjunto de usuarios
     */
    @WebMethod
    public ArrayList<DtUsuario> listarUsuarios();

    /**
     * Lista los videos contenidos en la lista idListaSeleccionada perteneciente
     * al usuarioSeleccionado Si la lista contiene video privado que no
     * pertenezca a usuarioActual, estos no se incluiran en el resultado
     * Si no se ha iniciado sesion solo lista los videos publicos
     * 
     * @return Conjunto de videos
     */
    @WebMethod
    public ArrayList<DtVideo> listarVideosDeListaDeReproduccion();

    /**
     * Devuelve los videos públicos del usuarioSeleccionado Si el
     * usuarioSeleccionado es el usuarioActual: Se incluirán los videos privados
     *
     * @return Conjunto de videos
     */
    @WebMethod
    public ArrayList<DtVideo> listarVideosDeUsuario();

    /**
     * Se modifican los datos de la lista idListaSeleccionada que pertenece a
     * usuarioActual
     *
     * @param lista Nuevos datos de la lista de reproduccion
     */
    @WebMethod
    public void modificarListaDeReproduccion(DtListaDeReproduccion lista);

    /**
     * Se modifican los datos de usuarioActual y su canal
     *
     * @param usr Nuevos datos del usuario
     * @param canal Nuevos datos del canal
     */
    @WebMethod
    public void modificarUsuarioYCanal(DtUsuario usr, DtCanal canal);

    /**
     * Se modifican los datos del video idVideoSeleccionado que pertenece a
     * usuarioActual
     *
     * @param video Nuevos datos del video
     */
    @WebMethod
    public void modificarVideo(DtVideo video);

    /**
     * Devuelve los datos del canal del usuarioSeleccionado
     *
     * @return Datos del canal
     */
    @WebMethod
    public DtCanal obtenerCanalDeUsuario();
    
    /**
     * Busca entre todos los usuarios al propietario del canal con el ID indicado
     *
     * @param idCanal ID del canal
     * @return Datos del usuario
     */
    @WebMethod
    public DtUsuario obtenerPropietarioDeCanal(int idCanal);
    
    /**
     * Busca entre todos los usuarios al propietario del video con el ID indicado
     *
     * @param idVideo ID del video
     * @return Datos del usuario
     */
    @WebMethod
    public DtUsuario obtenerPropietarioDeVideo(int idVideo);
    
    /**
     * Busca entre todos los usuarios al propietario de la lista de reproduccion con el ID indicado
     *
     * @param idLista ID de la lista de reproduccion
     * @return Datos del usuario
     */
    @WebMethod
    public DtUsuario obtenerPropietarioDeListaDeReproduccion(int idLista);
    
    /**
     * Devuelve los datos del usuario que inició sesión
     * @return Datos del usuario actual
     */
    @WebMethod
    public DtUsuario obtenerUsuarioActual();
    
    /**
     * Devuelve la valoracion dada por usuarioActual al video
     * idVideoSeleccionado perteneciente al usuarioSeleccionado
     *
     * @return Valoracion dada o null si no ha valorado
     */
    @WebMethod
    public DtValoracion obtenerValoracionDada();

    /**
     * Devuelve las valoraciones de idVideoSeleccionado perteneciente a
     * usuarioSeleccionado
     *
     * @return Conjunto de valoraciones
     */
    @WebMethod
    public ArrayList<DtValoracion> obtenerValoracionesDeVideo();

    /**
     * Quita el video indicado de la lista idListaSeleccionada perteneciente al
     * usuarioActual
     *
     * @param idVideo ID del video a quitar
     */
    @WebMethod
    public void quitarVideoDeListaDeReproduccion(int idVideo);

    /**
     * El usuarioActual comienza a seguir a usuarioSeleccionado En caso de que
     * este ya lo esté siguiendo, lo deja de seguir
     */
    @WebMethod
    public void seguirUsuario();

    /**
     * Selecciona un usuario del sistema El sistema recuerda el usuario como
     * usuarioSeleccionado Devuelve los datos de usuarioSeleccionado
     *
     * @param nickname Nickname del usuario
     * @return Datos del usuario
     */
    @WebMethod
    public DtUsuario seleccionarUsuario(String nickname);

    /**
     * Selecciona una lista de reproduccion del usuarioSeleccionado El sistema
     * recuerda el ID de la lista como idListaSeleccionada. Si no hay un
     * usuarioSeleccionado, el sistema busca al propietario de la lista y lo
     * selecciona
     *
     * @param idLista ID de la lista de reproduccion
     * @return Datos de la lista de reproduccion seleccionada
     */
    @WebMethod
    public DtListaDeReproduccion seleccionarListaDeReproduccion(int idLista);

    /**
     * Selecciona un video del usuarioSeleccionado El sistema recuerda el ID del
     * video como idVideoSeleccionado. Si no hay un usuarioSeleccionado, el
     * sistema busca al propietario del video y lo selecciona
     *
     * @param idVideo ID del video
     * @return Datos del video seleccionado
     */
    @WebMethod
    public DtVideo seleccionarVideo(int idVideo);

    /**
     * Permite saber si hay una sesion iniciada
     * @return true si hay una sesion iniciada
     */
    @WebMethod
    public boolean sesionIniciada();
    
    /**
     * Verifica si el usuarioActual puede agregar una lista de reproduccion con
     * el nombre indicado. Si se está modificando una lista, se puede
     * especificar el ID de la lista que se está modificando para una validacion
     * correcta
     *
     * @param nombre Nombre de la lista de reproduccion
     * @param idExcepcion ID de la lista a ignorar (0 si no se decea ignorar ninguna)
     * @return true si el usuarioActual puede agregar una lista de reproduccion
     * con ese nombre
     */
    @WebMethod
    public boolean validarNuevaListaParticular(String nombre, int idExcepcion);

    /**
     * Verifica si el usuarioActual puede agregar un video con el nombre
     * indicado. Si se está modificando un video, se puede especificar el ID del
     * video que se está modificando para una validacion correcta
     * 
     * @param nombre Nombre del video
     * @param idExcepcion ID del video a ignorar (0 si no se decea ignorar ninguno)
     * @return true si el usuarioActual puede agregar un video con ese nombre
     */
    @WebMethod
    public boolean validarNuevoVideo(String nombre, int idExcepcion);

    /**
     * Se ingresa la nueva valoracion dada por usuarioActual al video
     * idVideoSeleccionado perteneciente a usuarioSeleccionado Si el usuario ya
     * habia valorado, se actualiza la valoracion dada Si la valoracion recibida
     * es null, se quita la valoracion dada
     *
     * @param val Valoracion dada (puede ser null)
     */
    @WebMethod
    public void valorarVideo(DtValoracion val);
    
    ///////// Operaciones con imagenes de usuarios //////////////////////
    /**
     * Devuelve los datos de la imagen del usuario con ese ID
     *
     * @param id ID del usuario del cual se quiere obtener la imagen
     * @return Datos del usuario si existe, o null si no se encontro
     */
    @WebMethod
    public DtImagenUsuario obtenerImagenDeUsuario(String id) throws RuntimeException;

    /**
     * Persiste una nueva imagen de usuario
     *
     * @param iu Datos de la imagen del usuario
     */
    @WebMethod
    public void altaImagenDeUsuario(DtImagenUsuario iu) throws RuntimeException;

    /**
     * Modifica los datos de la imagen de usuario
     *
     * @param iu Datos de la imagen del usuario
     */
    @WebMethod
    public void modificarImagenDeUsuario(DtImagenUsuario iu) throws RuntimeException;

    /**
     * Elimina la imagen del usuario
     *
     * @param id ID del usuario
     */
    @WebMethod
    public void eliminarImagenDeUsuario(String id) throws RuntimeException;

    /**
     * Comprueba si el usuario con el ID indicado posee imagen de perfil
     * persistida
     *
     * @param id ID del usuario
     * @return true si el usuario tiene una imagen de perfil persistida
     */
    @WebMethod
    public boolean existeImagenDeUsuario(String id) throws RuntimeException;
    
    /**
     * Devuelve la imagen de usuario por defecto
     * 
     * @return Imagen de usuario por defecto
     */
    @WebMethod
    public DtImagenUsuario obtenerImagenDeUsuarioPorDefecto();
    
}
