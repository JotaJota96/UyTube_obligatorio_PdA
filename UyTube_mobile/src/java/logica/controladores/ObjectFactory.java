
package logica.controladores;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the logica.controladores package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ObtenerPropietarioDeVideo_QNAME = new QName("http://Controladores.Logica/", "obtenerPropietarioDeVideo");
    private final static QName _ObtenerValoracionDada_QNAME = new QName("http://Controladores.Logica/", "obtenerValoracionDada");
    private final static QName _ModificarVideoResponse_QNAME = new QName("http://Controladores.Logica/", "modificarVideoResponse");
    private final static QName _AltaComentarioResponse_QNAME = new QName("http://Controladores.Logica/", "altaComentarioResponse");
    private final static QName _BuscarPorCategoria_QNAME = new QName("http://Controladores.Logica/", "buscarPorCategoria");
    private final static QName _LiberarMemoriaListaDeReproduccion_QNAME = new QName("http://Controladores.Logica/", "liberarMemoriaListaDeReproduccion");
    private final static QName _IniciarSesionUsuario_QNAME = new QName("http://Controladores.Logica/", "iniciarSesionUsuario");
    private final static QName _ListarVideosDeUsuario_QNAME = new QName("http://Controladores.Logica/", "listarVideosDeUsuario");
    private final static QName _AgregarVideoAHistorialResponse_QNAME = new QName("http://Controladores.Logica/", "agregarVideoAHistorialResponse");
    private final static QName _SesionIniciadaResponse_QNAME = new QName("http://Controladores.Logica/", "sesionIniciadaResponse");
    private final static QName _LiberarMemoriaUsuario_QNAME = new QName("http://Controladores.Logica/", "liberarMemoriaUsuario");
    private final static QName _LiberarMemoriaUsuarioResponse_QNAME = new QName("http://Controladores.Logica/", "liberarMemoriaUsuarioResponse");
    private final static QName _EliminarImagenDeUsuario_QNAME = new QName("http://Controladores.Logica/", "eliminarImagenDeUsuario");
    private final static QName _ListarUsuarioSeguidoresResponse_QNAME = new QName("http://Controladores.Logica/", "listarUsuarioSeguidoresResponse");
    private final static QName _CerrarSesion_QNAME = new QName("http://Controladores.Logica/", "cerrarSesion");
    private final static QName _ObtenerImagenDeUsuarioResponse_QNAME = new QName("http://Controladores.Logica/", "obtenerImagenDeUsuarioResponse");
    private final static QName _AltaImagenDeUsuarioResponse_QNAME = new QName("http://Controladores.Logica/", "altaImagenDeUsuarioResponse");
    private final static QName _QuitarVideoDeListaDeReproduccion_QNAME = new QName("http://Controladores.Logica/", "quitarVideoDeListaDeReproduccion");
    private final static QName _ListarUsuariosResponse_QNAME = new QName("http://Controladores.Logica/", "listarUsuariosResponse");
    private final static QName _ListarVideosDeListaDeReproduccionResponse_QNAME = new QName("http://Controladores.Logica/", "listarVideosDeListaDeReproduccionResponse");
    private final static QName _ListarVideosDeListaDeReproduccion_QNAME = new QName("http://Controladores.Logica/", "listarVideosDeListaDeReproduccion");
    private final static QName _AltaImagenDeUsuario_QNAME = new QName("http://Controladores.Logica/", "altaImagenDeUsuario");
    private final static QName _AltaListaDeReproduccionParticularResponse_QNAME = new QName("http://Controladores.Logica/", "altaListaDeReproduccionParticularResponse");
    private final static QName _BajaUsuario_QNAME = new QName("http://Controladores.Logica/", "bajaUsuario");
    private final static QName _ObtenerValoracionDadaResponse_QNAME = new QName("http://Controladores.Logica/", "obtenerValoracionDadaResponse");
    private final static QName _ModificarListaDeReproduccionResponse_QNAME = new QName("http://Controladores.Logica/", "modificarListaDeReproduccionResponse");
    private final static QName _BuscarPorCategoriaResponse_QNAME = new QName("http://Controladores.Logica/", "buscarPorCategoriaResponse");
    private final static QName _Buscar_QNAME = new QName("http://Controladores.Logica/", "buscar");
    private final static QName _ObtenerPropietarioDeCanalResponse_QNAME = new QName("http://Controladores.Logica/", "obtenerPropietarioDeCanalResponse");
    private final static QName _ModificarImagenDeUsuarioResponse_QNAME = new QName("http://Controladores.Logica/", "modificarImagenDeUsuarioResponse");
    private final static QName _ValorarVideo_QNAME = new QName("http://Controladores.Logica/", "valorarVideo");
    private final static QName _ExisteEmailResponse_QNAME = new QName("http://Controladores.Logica/", "existeEmailResponse");
    private final static QName _ListarListasDeReproduccionDeUsuario_QNAME = new QName("http://Controladores.Logica/", "listarListasDeReproduccionDeUsuario");
    private final static QName _AltaListaDeReproduccionParticular_QNAME = new QName("http://Controladores.Logica/", "altaListaDeReproduccionParticular");
    private final static QName _ObtenerImagenDeUsuarioPorDefecto_QNAME = new QName("http://Controladores.Logica/", "obtenerImagenDeUsuarioPorDefecto");
    private final static QName _ModificarListaDeReproduccion_QNAME = new QName("http://Controladores.Logica/", "modificarListaDeReproduccion");
    private final static QName _ValidarNuevoVideoResponse_QNAME = new QName("http://Controladores.Logica/", "validarNuevoVideoResponse");
    private final static QName _ListarUsuarioSeguidosResponse_QNAME = new QName("http://Controladores.Logica/", "listarUsuarioSeguidosResponse");
    private final static QName _ListarUsuarioSeguidos_QNAME = new QName("http://Controladores.Logica/", "listarUsuarioSeguidos");
    private final static QName _SeleccionarListaDeReproduccion_QNAME = new QName("http://Controladores.Logica/", "seleccionarListaDeReproduccion");
    private final static QName _AltaComentario_QNAME = new QName("http://Controladores.Logica/", "altaComentario");
    private final static QName _AgregarVideoAListaDeReproduccionResponse_QNAME = new QName("http://Controladores.Logica/", "agregarVideoAListaDeReproduccionResponse");
    private final static QName _ModificarImagenDeUsuario_QNAME = new QName("http://Controladores.Logica/", "modificarImagenDeUsuario");
    private final static QName _ListarCategorias_QNAME = new QName("http://Controladores.Logica/", "listarCategorias");
    private final static QName _ModificarUsuarioYCanalResponse_QNAME = new QName("http://Controladores.Logica/", "modificarUsuarioYCanalResponse");
    private final static QName _ModificarUsuarioYCanal_QNAME = new QName("http://Controladores.Logica/", "modificarUsuarioYCanal");
    private final static QName _ListarListasDeReproduccionDeUsuarioResponse_QNAME = new QName("http://Controladores.Logica/", "listarListasDeReproduccionDeUsuarioResponse");
    private final static QName _ObtenerPropietarioDeVideoResponse_QNAME = new QName("http://Controladores.Logica/", "obtenerPropietarioDeVideoResponse");
    private final static QName _ExisteNicknameResponse_QNAME = new QName("http://Controladores.Logica/", "existeNicknameResponse");
    private final static QName _ObtenerImagenDeUsuarioPorDefectoResponse_QNAME = new QName("http://Controladores.Logica/", "obtenerImagenDeUsuarioPorDefectoResponse");
    private final static QName _ValidarNuevoVideo_QNAME = new QName("http://Controladores.Logica/", "validarNuevoVideo");
    private final static QName _CerrarSesionResponse_QNAME = new QName("http://Controladores.Logica/", "cerrarSesionResponse");
    private final static QName _ObtenerPropietarioDeListaDeReproduccion_QNAME = new QName("http://Controladores.Logica/", "obtenerPropietarioDeListaDeReproduccion");
    private final static QName _ObtenerUsuarioActual_QNAME = new QName("http://Controladores.Logica/", "obtenerUsuarioActual");
    private final static QName _ObtenerPropietarioDeCanal_QNAME = new QName("http://Controladores.Logica/", "obtenerPropietarioDeCanal");
    private final static QName _ObtenerCanalDeUsuario_QNAME = new QName("http://Controladores.Logica/", "obtenerCanalDeUsuario");
    private final static QName _SeleccionarUsuarioResponse_QNAME = new QName("http://Controladores.Logica/", "seleccionarUsuarioResponse");
    private final static QName _ExisteEmail_QNAME = new QName("http://Controladores.Logica/", "existeEmail");
    private final static QName _AltaUsuarioCanalResponse_QNAME = new QName("http://Controladores.Logica/", "altaUsuarioCanalResponse");
    private final static QName _ElUsuarioSeleccionadoEsElUsuarioActualResponse_QNAME = new QName("http://Controladores.Logica/", "elUsuarioSeleccionadoEsElUsuarioActualResponse");
    private final static QName _ListarVideosDeUsuarioResponse_QNAME = new QName("http://Controladores.Logica/", "listarVideosDeUsuarioResponse");
    private final static QName _ListarComentariosDeVideo_QNAME = new QName("http://Controladores.Logica/", "listarComentariosDeVideo");
    private final static QName _ListarComentariosDeVideoResponse_QNAME = new QName("http://Controladores.Logica/", "listarComentariosDeVideoResponse");
    private final static QName _AgregarVideoAHistorial_QNAME = new QName("http://Controladores.Logica/", "agregarVideoAHistorial");
    private final static QName _ObtenerImagenDeUsuario_QNAME = new QName("http://Controladores.Logica/", "obtenerImagenDeUsuario");
    private final static QName _BuscarResponse_QNAME = new QName("http://Controladores.Logica/", "buscarResponse");
    private final static QName _ExisteImagenDeUsuario_QNAME = new QName("http://Controladores.Logica/", "existeImagenDeUsuario");
    private final static QName _ObtenerValoracionesDeVideo_QNAME = new QName("http://Controladores.Logica/", "obtenerValoracionesDeVideo");
    private final static QName _ListarCategoriasResponse_QNAME = new QName("http://Controladores.Logica/", "listarCategoriasResponse");
    private final static QName _SeleccionarVideo_QNAME = new QName("http://Controladores.Logica/", "seleccionarVideo");
    private final static QName _SeleccionarVideoResponse_QNAME = new QName("http://Controladores.Logica/", "seleccionarVideoResponse");
    private final static QName _ValidarNuevaListaParticularResponse_QNAME = new QName("http://Controladores.Logica/", "validarNuevaListaParticularResponse");
    private final static QName _AltaUsuarioCanal_QNAME = new QName("http://Controladores.Logica/", "altaUsuarioCanal");
    private final static QName _ValorarVideoResponse_QNAME = new QName("http://Controladores.Logica/", "valorarVideoResponse");
    private final static QName _AgregarVideoAListaDeReproduccion_QNAME = new QName("http://Controladores.Logica/", "agregarVideoAListaDeReproduccion");
    private final static QName _AltaSubComentarioResponse_QNAME = new QName("http://Controladores.Logica/", "altaSubComentarioResponse");
    private final static QName _AltaSubComentario_QNAME = new QName("http://Controladores.Logica/", "altaSubComentario");
    private final static QName _ModificarVideo_QNAME = new QName("http://Controladores.Logica/", "modificarVideo");
    private final static QName _Reset_QNAME = new QName("http://Controladores.Logica/", "reset");
    private final static QName _ObtenerCanalDeUsuarioResponse_QNAME = new QName("http://Controladores.Logica/", "obtenerCanalDeUsuarioResponse");
    private final static QName _QuitarVideoDeListaDeReproduccionResponse_QNAME = new QName("http://Controladores.Logica/", "quitarVideoDeListaDeReproduccionResponse");
    private final static QName _LiberarMemoriaListaDeReproduccionResponse_QNAME = new QName("http://Controladores.Logica/", "liberarMemoriaListaDeReproduccionResponse");
    private final static QName _AltaVideo_QNAME = new QName("http://Controladores.Logica/", "altaVideo");
    private final static QName _AltaVideoResponse_QNAME = new QName("http://Controladores.Logica/", "altaVideoResponse");
    private final static QName _SeguirUsuario_QNAME = new QName("http://Controladores.Logica/", "seguirUsuario");
    private final static QName _SeleccionarListaDeReproduccionResponse_QNAME = new QName("http://Controladores.Logica/", "seleccionarListaDeReproduccionResponse");
    private final static QName _LiberarMemoriaVideo_QNAME = new QName("http://Controladores.Logica/", "liberarMemoriaVideo");
    private final static QName _SeguirUsuarioResponse_QNAME = new QName("http://Controladores.Logica/", "seguirUsuarioResponse");
    private final static QName _IniciarSesionUsuarioResponse_QNAME = new QName("http://Controladores.Logica/", "iniciarSesionUsuarioResponse");
    private final static QName _ListarUsuarios_QNAME = new QName("http://Controladores.Logica/", "listarUsuarios");
    private final static QName _SesionIniciada_QNAME = new QName("http://Controladores.Logica/", "sesionIniciada");
    private final static QName _ElUsuarioSeleccionadoEsElUsuarioActual_QNAME = new QName("http://Controladores.Logica/", "elUsuarioSeleccionadoEsElUsuarioActual");
    private final static QName _ObtenerUsuarioActualResponse_QNAME = new QName("http://Controladores.Logica/", "obtenerUsuarioActualResponse");
    private final static QName _ObtenerPropietarioDeListaDeReproduccionResponse_QNAME = new QName("http://Controladores.Logica/", "obtenerPropietarioDeListaDeReproduccionResponse");
    private final static QName _ListarUsuarioSeguidores_QNAME = new QName("http://Controladores.Logica/", "listarUsuarioSeguidores");
    private final static QName _ExisteImagenDeUsuarioResponse_QNAME = new QName("http://Controladores.Logica/", "existeImagenDeUsuarioResponse");
    private final static QName _SeleccionarUsuario_QNAME = new QName("http://Controladores.Logica/", "seleccionarUsuario");
    private final static QName _ObtenerValoracionesDeVideoResponse_QNAME = new QName("http://Controladores.Logica/", "obtenerValoracionesDeVideoResponse");
    private final static QName _EliminarImagenDeUsuarioResponse_QNAME = new QName("http://Controladores.Logica/", "eliminarImagenDeUsuarioResponse");
    private final static QName _LiberarMemoriaVideoResponse_QNAME = new QName("http://Controladores.Logica/", "liberarMemoriaVideoResponse");
    private final static QName _ResetResponse_QNAME = new QName("http://Controladores.Logica/", "resetResponse");
    private final static QName _BajaUsuarioResponse_QNAME = new QName("http://Controladores.Logica/", "bajaUsuarioResponse");
    private final static QName _ValidarNuevaListaParticular_QNAME = new QName("http://Controladores.Logica/", "validarNuevaListaParticular");
    private final static QName _ExisteNickname_QNAME = new QName("http://Controladores.Logica/", "existeNickname");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: logica.controladores
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExisteNickname }
     * 
     */
    public ExisteNickname createExisteNickname() {
        return new ExisteNickname();
    }

    /**
     * Create an instance of {@link ValidarNuevaListaParticular }
     * 
     */
    public ValidarNuevaListaParticular createValidarNuevaListaParticular() {
        return new ValidarNuevaListaParticular();
    }

    /**
     * Create an instance of {@link BajaUsuarioResponse }
     * 
     */
    public BajaUsuarioResponse createBajaUsuarioResponse() {
        return new BajaUsuarioResponse();
    }

    /**
     * Create an instance of {@link ResetResponse }
     * 
     */
    public ResetResponse createResetResponse() {
        return new ResetResponse();
    }

    /**
     * Create an instance of {@link LiberarMemoriaVideoResponse }
     * 
     */
    public LiberarMemoriaVideoResponse createLiberarMemoriaVideoResponse() {
        return new LiberarMemoriaVideoResponse();
    }

    /**
     * Create an instance of {@link EliminarImagenDeUsuarioResponse }
     * 
     */
    public EliminarImagenDeUsuarioResponse createEliminarImagenDeUsuarioResponse() {
        return new EliminarImagenDeUsuarioResponse();
    }

    /**
     * Create an instance of {@link ObtenerValoracionesDeVideoResponse }
     * 
     */
    public ObtenerValoracionesDeVideoResponse createObtenerValoracionesDeVideoResponse() {
        return new ObtenerValoracionesDeVideoResponse();
    }

    /**
     * Create an instance of {@link SeleccionarUsuario }
     * 
     */
    public SeleccionarUsuario createSeleccionarUsuario() {
        return new SeleccionarUsuario();
    }

    /**
     * Create an instance of {@link ExisteImagenDeUsuarioResponse }
     * 
     */
    public ExisteImagenDeUsuarioResponse createExisteImagenDeUsuarioResponse() {
        return new ExisteImagenDeUsuarioResponse();
    }

    /**
     * Create an instance of {@link ListarUsuarioSeguidores }
     * 
     */
    public ListarUsuarioSeguidores createListarUsuarioSeguidores() {
        return new ListarUsuarioSeguidores();
    }

    /**
     * Create an instance of {@link ObtenerPropietarioDeListaDeReproduccionResponse }
     * 
     */
    public ObtenerPropietarioDeListaDeReproduccionResponse createObtenerPropietarioDeListaDeReproduccionResponse() {
        return new ObtenerPropietarioDeListaDeReproduccionResponse();
    }

    /**
     * Create an instance of {@link ElUsuarioSeleccionadoEsElUsuarioActual }
     * 
     */
    public ElUsuarioSeleccionadoEsElUsuarioActual createElUsuarioSeleccionadoEsElUsuarioActual() {
        return new ElUsuarioSeleccionadoEsElUsuarioActual();
    }

    /**
     * Create an instance of {@link ObtenerUsuarioActualResponse }
     * 
     */
    public ObtenerUsuarioActualResponse createObtenerUsuarioActualResponse() {
        return new ObtenerUsuarioActualResponse();
    }

    /**
     * Create an instance of {@link ListarUsuarios }
     * 
     */
    public ListarUsuarios createListarUsuarios() {
        return new ListarUsuarios();
    }

    /**
     * Create an instance of {@link SesionIniciada }
     * 
     */
    public SesionIniciada createSesionIniciada() {
        return new SesionIniciada();
    }

    /**
     * Create an instance of {@link IniciarSesionUsuarioResponse }
     * 
     */
    public IniciarSesionUsuarioResponse createIniciarSesionUsuarioResponse() {
        return new IniciarSesionUsuarioResponse();
    }

    /**
     * Create an instance of {@link LiberarMemoriaVideo }
     * 
     */
    public LiberarMemoriaVideo createLiberarMemoriaVideo() {
        return new LiberarMemoriaVideo();
    }

    /**
     * Create an instance of {@link SeguirUsuarioResponse }
     * 
     */
    public SeguirUsuarioResponse createSeguirUsuarioResponse() {
        return new SeguirUsuarioResponse();
    }

    /**
     * Create an instance of {@link SeleccionarListaDeReproduccionResponse }
     * 
     */
    public SeleccionarListaDeReproduccionResponse createSeleccionarListaDeReproduccionResponse() {
        return new SeleccionarListaDeReproduccionResponse();
    }

    /**
     * Create an instance of {@link AltaVideoResponse }
     * 
     */
    public AltaVideoResponse createAltaVideoResponse() {
        return new AltaVideoResponse();
    }

    /**
     * Create an instance of {@link SeguirUsuario }
     * 
     */
    public SeguirUsuario createSeguirUsuario() {
        return new SeguirUsuario();
    }

    /**
     * Create an instance of {@link AltaVideo }
     * 
     */
    public AltaVideo createAltaVideo() {
        return new AltaVideo();
    }

    /**
     * Create an instance of {@link LiberarMemoriaListaDeReproduccionResponse }
     * 
     */
    public LiberarMemoriaListaDeReproduccionResponse createLiberarMemoriaListaDeReproduccionResponse() {
        return new LiberarMemoriaListaDeReproduccionResponse();
    }

    /**
     * Create an instance of {@link ObtenerCanalDeUsuarioResponse }
     * 
     */
    public ObtenerCanalDeUsuarioResponse createObtenerCanalDeUsuarioResponse() {
        return new ObtenerCanalDeUsuarioResponse();
    }

    /**
     * Create an instance of {@link QuitarVideoDeListaDeReproduccionResponse }
     * 
     */
    public QuitarVideoDeListaDeReproduccionResponse createQuitarVideoDeListaDeReproduccionResponse() {
        return new QuitarVideoDeListaDeReproduccionResponse();
    }

    /**
     * Create an instance of {@link Reset }
     * 
     */
    public Reset createReset() {
        return new Reset();
    }

    /**
     * Create an instance of {@link ModificarVideo }
     * 
     */
    public ModificarVideo createModificarVideo() {
        return new ModificarVideo();
    }

    /**
     * Create an instance of {@link AltaSubComentario }
     * 
     */
    public AltaSubComentario createAltaSubComentario() {
        return new AltaSubComentario();
    }

    /**
     * Create an instance of {@link AltaSubComentarioResponse }
     * 
     */
    public AltaSubComentarioResponse createAltaSubComentarioResponse() {
        return new AltaSubComentarioResponse();
    }

    /**
     * Create an instance of {@link AgregarVideoAListaDeReproduccion }
     * 
     */
    public AgregarVideoAListaDeReproduccion createAgregarVideoAListaDeReproduccion() {
        return new AgregarVideoAListaDeReproduccion();
    }

    /**
     * Create an instance of {@link ValorarVideoResponse }
     * 
     */
    public ValorarVideoResponse createValorarVideoResponse() {
        return new ValorarVideoResponse();
    }

    /**
     * Create an instance of {@link AltaUsuarioCanal }
     * 
     */
    public AltaUsuarioCanal createAltaUsuarioCanal() {
        return new AltaUsuarioCanal();
    }

    /**
     * Create an instance of {@link ValidarNuevaListaParticularResponse }
     * 
     */
    public ValidarNuevaListaParticularResponse createValidarNuevaListaParticularResponse() {
        return new ValidarNuevaListaParticularResponse();
    }

    /**
     * Create an instance of {@link SeleccionarVideoResponse }
     * 
     */
    public SeleccionarVideoResponse createSeleccionarVideoResponse() {
        return new SeleccionarVideoResponse();
    }

    /**
     * Create an instance of {@link ListarCategoriasResponse }
     * 
     */
    public ListarCategoriasResponse createListarCategoriasResponse() {
        return new ListarCategoriasResponse();
    }

    /**
     * Create an instance of {@link SeleccionarVideo }
     * 
     */
    public SeleccionarVideo createSeleccionarVideo() {
        return new SeleccionarVideo();
    }

    /**
     * Create an instance of {@link BuscarResponse }
     * 
     */
    public BuscarResponse createBuscarResponse() {
        return new BuscarResponse();
    }

    /**
     * Create an instance of {@link ExisteImagenDeUsuario }
     * 
     */
    public ExisteImagenDeUsuario createExisteImagenDeUsuario() {
        return new ExisteImagenDeUsuario();
    }

    /**
     * Create an instance of {@link ObtenerValoracionesDeVideo }
     * 
     */
    public ObtenerValoracionesDeVideo createObtenerValoracionesDeVideo() {
        return new ObtenerValoracionesDeVideo();
    }

    /**
     * Create an instance of {@link ObtenerImagenDeUsuario }
     * 
     */
    public ObtenerImagenDeUsuario createObtenerImagenDeUsuario() {
        return new ObtenerImagenDeUsuario();
    }

    /**
     * Create an instance of {@link AgregarVideoAHistorial }
     * 
     */
    public AgregarVideoAHistorial createAgregarVideoAHistorial() {
        return new AgregarVideoAHistorial();
    }

    /**
     * Create an instance of {@link ListarComentariosDeVideo }
     * 
     */
    public ListarComentariosDeVideo createListarComentariosDeVideo() {
        return new ListarComentariosDeVideo();
    }

    /**
     * Create an instance of {@link ListarComentariosDeVideoResponse }
     * 
     */
    public ListarComentariosDeVideoResponse createListarComentariosDeVideoResponse() {
        return new ListarComentariosDeVideoResponse();
    }

    /**
     * Create an instance of {@link ElUsuarioSeleccionadoEsElUsuarioActualResponse }
     * 
     */
    public ElUsuarioSeleccionadoEsElUsuarioActualResponse createElUsuarioSeleccionadoEsElUsuarioActualResponse() {
        return new ElUsuarioSeleccionadoEsElUsuarioActualResponse();
    }

    /**
     * Create an instance of {@link ListarVideosDeUsuarioResponse }
     * 
     */
    public ListarVideosDeUsuarioResponse createListarVideosDeUsuarioResponse() {
        return new ListarVideosDeUsuarioResponse();
    }

    /**
     * Create an instance of {@link AltaUsuarioCanalResponse }
     * 
     */
    public AltaUsuarioCanalResponse createAltaUsuarioCanalResponse() {
        return new AltaUsuarioCanalResponse();
    }

    /**
     * Create an instance of {@link ExisteEmail }
     * 
     */
    public ExisteEmail createExisteEmail() {
        return new ExisteEmail();
    }

    /**
     * Create an instance of {@link ObtenerCanalDeUsuario }
     * 
     */
    public ObtenerCanalDeUsuario createObtenerCanalDeUsuario() {
        return new ObtenerCanalDeUsuario();
    }

    /**
     * Create an instance of {@link SeleccionarUsuarioResponse }
     * 
     */
    public SeleccionarUsuarioResponse createSeleccionarUsuarioResponse() {
        return new SeleccionarUsuarioResponse();
    }

    /**
     * Create an instance of {@link ObtenerPropietarioDeCanal }
     * 
     */
    public ObtenerPropietarioDeCanal createObtenerPropietarioDeCanal() {
        return new ObtenerPropietarioDeCanal();
    }

    /**
     * Create an instance of {@link ObtenerUsuarioActual }
     * 
     */
    public ObtenerUsuarioActual createObtenerUsuarioActual() {
        return new ObtenerUsuarioActual();
    }

    /**
     * Create an instance of {@link CerrarSesionResponse }
     * 
     */
    public CerrarSesionResponse createCerrarSesionResponse() {
        return new CerrarSesionResponse();
    }

    /**
     * Create an instance of {@link ObtenerPropietarioDeListaDeReproduccion }
     * 
     */
    public ObtenerPropietarioDeListaDeReproduccion createObtenerPropietarioDeListaDeReproduccion() {
        return new ObtenerPropietarioDeListaDeReproduccion();
    }

    /**
     * Create an instance of {@link ObtenerImagenDeUsuarioPorDefectoResponse }
     * 
     */
    public ObtenerImagenDeUsuarioPorDefectoResponse createObtenerImagenDeUsuarioPorDefectoResponse() {
        return new ObtenerImagenDeUsuarioPorDefectoResponse();
    }

    /**
     * Create an instance of {@link ValidarNuevoVideo }
     * 
     */
    public ValidarNuevoVideo createValidarNuevoVideo() {
        return new ValidarNuevoVideo();
    }

    /**
     * Create an instance of {@link ExisteNicknameResponse }
     * 
     */
    public ExisteNicknameResponse createExisteNicknameResponse() {
        return new ExisteNicknameResponse();
    }

    /**
     * Create an instance of {@link ObtenerPropietarioDeVideoResponse }
     * 
     */
    public ObtenerPropietarioDeVideoResponse createObtenerPropietarioDeVideoResponse() {
        return new ObtenerPropietarioDeVideoResponse();
    }

    /**
     * Create an instance of {@link ListarListasDeReproduccionDeUsuarioResponse }
     * 
     */
    public ListarListasDeReproduccionDeUsuarioResponse createListarListasDeReproduccionDeUsuarioResponse() {
        return new ListarListasDeReproduccionDeUsuarioResponse();
    }

    /**
     * Create an instance of {@link ModificarUsuarioYCanal }
     * 
     */
    public ModificarUsuarioYCanal createModificarUsuarioYCanal() {
        return new ModificarUsuarioYCanal();
    }

    /**
     * Create an instance of {@link ModificarUsuarioYCanalResponse }
     * 
     */
    public ModificarUsuarioYCanalResponse createModificarUsuarioYCanalResponse() {
        return new ModificarUsuarioYCanalResponse();
    }

    /**
     * Create an instance of {@link ListarCategorias }
     * 
     */
    public ListarCategorias createListarCategorias() {
        return new ListarCategorias();
    }

    /**
     * Create an instance of {@link ModificarImagenDeUsuario }
     * 
     */
    public ModificarImagenDeUsuario createModificarImagenDeUsuario() {
        return new ModificarImagenDeUsuario();
    }

    /**
     * Create an instance of {@link AgregarVideoAListaDeReproduccionResponse }
     * 
     */
    public AgregarVideoAListaDeReproduccionResponse createAgregarVideoAListaDeReproduccionResponse() {
        return new AgregarVideoAListaDeReproduccionResponse();
    }

    /**
     * Create an instance of {@link AltaComentario }
     * 
     */
    public AltaComentario createAltaComentario() {
        return new AltaComentario();
    }

    /**
     * Create an instance of {@link SeleccionarListaDeReproduccion }
     * 
     */
    public SeleccionarListaDeReproduccion createSeleccionarListaDeReproduccion() {
        return new SeleccionarListaDeReproduccion();
    }

    /**
     * Create an instance of {@link ListarUsuarioSeguidos }
     * 
     */
    public ListarUsuarioSeguidos createListarUsuarioSeguidos() {
        return new ListarUsuarioSeguidos();
    }

    /**
     * Create an instance of {@link ListarUsuarioSeguidosResponse }
     * 
     */
    public ListarUsuarioSeguidosResponse createListarUsuarioSeguidosResponse() {
        return new ListarUsuarioSeguidosResponse();
    }

    /**
     * Create an instance of {@link ValidarNuevoVideoResponse }
     * 
     */
    public ValidarNuevoVideoResponse createValidarNuevoVideoResponse() {
        return new ValidarNuevoVideoResponse();
    }

    /**
     * Create an instance of {@link ModificarListaDeReproduccion }
     * 
     */
    public ModificarListaDeReproduccion createModificarListaDeReproduccion() {
        return new ModificarListaDeReproduccion();
    }

    /**
     * Create an instance of {@link AltaListaDeReproduccionParticular }
     * 
     */
    public AltaListaDeReproduccionParticular createAltaListaDeReproduccionParticular() {
        return new AltaListaDeReproduccionParticular();
    }

    /**
     * Create an instance of {@link ObtenerImagenDeUsuarioPorDefecto }
     * 
     */
    public ObtenerImagenDeUsuarioPorDefecto createObtenerImagenDeUsuarioPorDefecto() {
        return new ObtenerImagenDeUsuarioPorDefecto();
    }

    /**
     * Create an instance of {@link ListarListasDeReproduccionDeUsuario }
     * 
     */
    public ListarListasDeReproduccionDeUsuario createListarListasDeReproduccionDeUsuario() {
        return new ListarListasDeReproduccionDeUsuario();
    }

    /**
     * Create an instance of {@link ExisteEmailResponse }
     * 
     */
    public ExisteEmailResponse createExisteEmailResponse() {
        return new ExisteEmailResponse();
    }

    /**
     * Create an instance of {@link ValorarVideo }
     * 
     */
    public ValorarVideo createValorarVideo() {
        return new ValorarVideo();
    }

    /**
     * Create an instance of {@link ModificarImagenDeUsuarioResponse }
     * 
     */
    public ModificarImagenDeUsuarioResponse createModificarImagenDeUsuarioResponse() {
        return new ModificarImagenDeUsuarioResponse();
    }

    /**
     * Create an instance of {@link Buscar }
     * 
     */
    public Buscar createBuscar() {
        return new Buscar();
    }

    /**
     * Create an instance of {@link ObtenerPropietarioDeCanalResponse }
     * 
     */
    public ObtenerPropietarioDeCanalResponse createObtenerPropietarioDeCanalResponse() {
        return new ObtenerPropietarioDeCanalResponse();
    }

    /**
     * Create an instance of {@link BuscarPorCategoriaResponse }
     * 
     */
    public BuscarPorCategoriaResponse createBuscarPorCategoriaResponse() {
        return new BuscarPorCategoriaResponse();
    }

    /**
     * Create an instance of {@link ModificarListaDeReproduccionResponse }
     * 
     */
    public ModificarListaDeReproduccionResponse createModificarListaDeReproduccionResponse() {
        return new ModificarListaDeReproduccionResponse();
    }

    /**
     * Create an instance of {@link BajaUsuario }
     * 
     */
    public BajaUsuario createBajaUsuario() {
        return new BajaUsuario();
    }

    /**
     * Create an instance of {@link ObtenerValoracionDadaResponse }
     * 
     */
    public ObtenerValoracionDadaResponse createObtenerValoracionDadaResponse() {
        return new ObtenerValoracionDadaResponse();
    }

    /**
     * Create an instance of {@link AltaListaDeReproduccionParticularResponse }
     * 
     */
    public AltaListaDeReproduccionParticularResponse createAltaListaDeReproduccionParticularResponse() {
        return new AltaListaDeReproduccionParticularResponse();
    }

    /**
     * Create an instance of {@link AltaImagenDeUsuario }
     * 
     */
    public AltaImagenDeUsuario createAltaImagenDeUsuario() {
        return new AltaImagenDeUsuario();
    }

    /**
     * Create an instance of {@link ListarVideosDeListaDeReproduccion }
     * 
     */
    public ListarVideosDeListaDeReproduccion createListarVideosDeListaDeReproduccion() {
        return new ListarVideosDeListaDeReproduccion();
    }

    /**
     * Create an instance of {@link ListarVideosDeListaDeReproduccionResponse }
     * 
     */
    public ListarVideosDeListaDeReproduccionResponse createListarVideosDeListaDeReproduccionResponse() {
        return new ListarVideosDeListaDeReproduccionResponse();
    }

    /**
     * Create an instance of {@link ListarUsuariosResponse }
     * 
     */
    public ListarUsuariosResponse createListarUsuariosResponse() {
        return new ListarUsuariosResponse();
    }

    /**
     * Create an instance of {@link QuitarVideoDeListaDeReproduccion }
     * 
     */
    public QuitarVideoDeListaDeReproduccion createQuitarVideoDeListaDeReproduccion() {
        return new QuitarVideoDeListaDeReproduccion();
    }

    /**
     * Create an instance of {@link AltaImagenDeUsuarioResponse }
     * 
     */
    public AltaImagenDeUsuarioResponse createAltaImagenDeUsuarioResponse() {
        return new AltaImagenDeUsuarioResponse();
    }

    /**
     * Create an instance of {@link CerrarSesion }
     * 
     */
    public CerrarSesion createCerrarSesion() {
        return new CerrarSesion();
    }

    /**
     * Create an instance of {@link ObtenerImagenDeUsuarioResponse }
     * 
     */
    public ObtenerImagenDeUsuarioResponse createObtenerImagenDeUsuarioResponse() {
        return new ObtenerImagenDeUsuarioResponse();
    }

    /**
     * Create an instance of {@link ListarUsuarioSeguidoresResponse }
     * 
     */
    public ListarUsuarioSeguidoresResponse createListarUsuarioSeguidoresResponse() {
        return new ListarUsuarioSeguidoresResponse();
    }

    /**
     * Create an instance of {@link EliminarImagenDeUsuario }
     * 
     */
    public EliminarImagenDeUsuario createEliminarImagenDeUsuario() {
        return new EliminarImagenDeUsuario();
    }

    /**
     * Create an instance of {@link LiberarMemoriaUsuarioResponse }
     * 
     */
    public LiberarMemoriaUsuarioResponse createLiberarMemoriaUsuarioResponse() {
        return new LiberarMemoriaUsuarioResponse();
    }

    /**
     * Create an instance of {@link LiberarMemoriaUsuario }
     * 
     */
    public LiberarMemoriaUsuario createLiberarMemoriaUsuario() {
        return new LiberarMemoriaUsuario();
    }

    /**
     * Create an instance of {@link SesionIniciadaResponse }
     * 
     */
    public SesionIniciadaResponse createSesionIniciadaResponse() {
        return new SesionIniciadaResponse();
    }

    /**
     * Create an instance of {@link AgregarVideoAHistorialResponse }
     * 
     */
    public AgregarVideoAHistorialResponse createAgregarVideoAHistorialResponse() {
        return new AgregarVideoAHistorialResponse();
    }

    /**
     * Create an instance of {@link IniciarSesionUsuario }
     * 
     */
    public IniciarSesionUsuario createIniciarSesionUsuario() {
        return new IniciarSesionUsuario();
    }

    /**
     * Create an instance of {@link ListarVideosDeUsuario }
     * 
     */
    public ListarVideosDeUsuario createListarVideosDeUsuario() {
        return new ListarVideosDeUsuario();
    }

    /**
     * Create an instance of {@link LiberarMemoriaListaDeReproduccion }
     * 
     */
    public LiberarMemoriaListaDeReproduccion createLiberarMemoriaListaDeReproduccion() {
        return new LiberarMemoriaListaDeReproduccion();
    }

    /**
     * Create an instance of {@link BuscarPorCategoria }
     * 
     */
    public BuscarPorCategoria createBuscarPorCategoria() {
        return new BuscarPorCategoria();
    }

    /**
     * Create an instance of {@link AltaComentarioResponse }
     * 
     */
    public AltaComentarioResponse createAltaComentarioResponse() {
        return new AltaComentarioResponse();
    }

    /**
     * Create an instance of {@link ModificarVideoResponse }
     * 
     */
    public ModificarVideoResponse createModificarVideoResponse() {
        return new ModificarVideoResponse();
    }

    /**
     * Create an instance of {@link ObtenerValoracionDada }
     * 
     */
    public ObtenerValoracionDada createObtenerValoracionDada() {
        return new ObtenerValoracionDada();
    }

    /**
     * Create an instance of {@link ObtenerPropietarioDeVideo }
     * 
     */
    public ObtenerPropietarioDeVideo createObtenerPropietarioDeVideo() {
        return new ObtenerPropietarioDeVideo();
    }

    /**
     * Create an instance of {@link DtVideo }
     * 
     */
    public DtVideo createDtVideo() {
        return new DtVideo();
    }

    /**
     * Create an instance of {@link DtRegistroHistorial }
     * 
     */
    public DtRegistroHistorial createDtRegistroHistorial() {
        return new DtRegistroHistorial();
    }

    /**
     * Create an instance of {@link DtUsuario }
     * 
     */
    public DtUsuario createDtUsuario() {
        return new DtUsuario();
    }

    /**
     * Create an instance of {@link DtListaDeReproduccionHistorial }
     * 
     */
    public DtListaDeReproduccionHistorial createDtListaDeReproduccionHistorial() {
        return new DtListaDeReproduccionHistorial();
    }

    /**
     * Create an instance of {@link DtComentario }
     * 
     */
    public DtComentario createDtComentario() {
        return new DtComentario();
    }

    /**
     * Create an instance of {@link Duracion }
     * 
     */
    public Duracion createDuracion() {
        return new Duracion();
    }

    /**
     * Create an instance of {@link DtListaDeReproduccion }
     * 
     */
    public DtListaDeReproduccion createDtListaDeReproduccion() {
        return new DtListaDeReproduccion();
    }

    /**
     * Create an instance of {@link DtValoracion }
     * 
     */
    public DtValoracion createDtValoracion() {
        return new DtValoracion();
    }

    /**
     * Create an instance of {@link Fecha }
     * 
     */
    public Fecha createFecha() {
        return new Fecha();
    }

    /**
     * Create an instance of {@link DtCanal }
     * 
     */
    public DtCanal createDtCanal() {
        return new DtCanal();
    }

    /**
     * Create an instance of {@link DtImagenUsuario }
     * 
     */
    public DtImagenUsuario createDtImagenUsuario() {
        return new DtImagenUsuario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerPropietarioDeVideo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerPropietarioDeVideo")
    public JAXBElement<ObtenerPropietarioDeVideo> createObtenerPropietarioDeVideo(ObtenerPropietarioDeVideo value) {
        return new JAXBElement<ObtenerPropietarioDeVideo>(_ObtenerPropietarioDeVideo_QNAME, ObtenerPropietarioDeVideo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerValoracionDada }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerValoracionDada")
    public JAXBElement<ObtenerValoracionDada> createObtenerValoracionDada(ObtenerValoracionDada value) {
        return new JAXBElement<ObtenerValoracionDada>(_ObtenerValoracionDada_QNAME, ObtenerValoracionDada.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarVideoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "modificarVideoResponse")
    public JAXBElement<ModificarVideoResponse> createModificarVideoResponse(ModificarVideoResponse value) {
        return new JAXBElement<ModificarVideoResponse>(_ModificarVideoResponse_QNAME, ModificarVideoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaComentarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "altaComentarioResponse")
    public JAXBElement<AltaComentarioResponse> createAltaComentarioResponse(AltaComentarioResponse value) {
        return new JAXBElement<AltaComentarioResponse>(_AltaComentarioResponse_QNAME, AltaComentarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarPorCategoria }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "buscarPorCategoria")
    public JAXBElement<BuscarPorCategoria> createBuscarPorCategoria(BuscarPorCategoria value) {
        return new JAXBElement<BuscarPorCategoria>(_BuscarPorCategoria_QNAME, BuscarPorCategoria.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LiberarMemoriaListaDeReproduccion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "liberarMemoriaListaDeReproduccion")
    public JAXBElement<LiberarMemoriaListaDeReproduccion> createLiberarMemoriaListaDeReproduccion(LiberarMemoriaListaDeReproduccion value) {
        return new JAXBElement<LiberarMemoriaListaDeReproduccion>(_LiberarMemoriaListaDeReproduccion_QNAME, LiberarMemoriaListaDeReproduccion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IniciarSesionUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "iniciarSesionUsuario")
    public JAXBElement<IniciarSesionUsuario> createIniciarSesionUsuario(IniciarSesionUsuario value) {
        return new JAXBElement<IniciarSesionUsuario>(_IniciarSesionUsuario_QNAME, IniciarSesionUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarVideosDeUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "listarVideosDeUsuario")
    public JAXBElement<ListarVideosDeUsuario> createListarVideosDeUsuario(ListarVideosDeUsuario value) {
        return new JAXBElement<ListarVideosDeUsuario>(_ListarVideosDeUsuario_QNAME, ListarVideosDeUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarVideoAHistorialResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "agregarVideoAHistorialResponse")
    public JAXBElement<AgregarVideoAHistorialResponse> createAgregarVideoAHistorialResponse(AgregarVideoAHistorialResponse value) {
        return new JAXBElement<AgregarVideoAHistorialResponse>(_AgregarVideoAHistorialResponse_QNAME, AgregarVideoAHistorialResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SesionIniciadaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "sesionIniciadaResponse")
    public JAXBElement<SesionIniciadaResponse> createSesionIniciadaResponse(SesionIniciadaResponse value) {
        return new JAXBElement<SesionIniciadaResponse>(_SesionIniciadaResponse_QNAME, SesionIniciadaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LiberarMemoriaUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "liberarMemoriaUsuario")
    public JAXBElement<LiberarMemoriaUsuario> createLiberarMemoriaUsuario(LiberarMemoriaUsuario value) {
        return new JAXBElement<LiberarMemoriaUsuario>(_LiberarMemoriaUsuario_QNAME, LiberarMemoriaUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LiberarMemoriaUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "liberarMemoriaUsuarioResponse")
    public JAXBElement<LiberarMemoriaUsuarioResponse> createLiberarMemoriaUsuarioResponse(LiberarMemoriaUsuarioResponse value) {
        return new JAXBElement<LiberarMemoriaUsuarioResponse>(_LiberarMemoriaUsuarioResponse_QNAME, LiberarMemoriaUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarImagenDeUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "eliminarImagenDeUsuario")
    public JAXBElement<EliminarImagenDeUsuario> createEliminarImagenDeUsuario(EliminarImagenDeUsuario value) {
        return new JAXBElement<EliminarImagenDeUsuario>(_EliminarImagenDeUsuario_QNAME, EliminarImagenDeUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarUsuarioSeguidoresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "listarUsuarioSeguidoresResponse")
    public JAXBElement<ListarUsuarioSeguidoresResponse> createListarUsuarioSeguidoresResponse(ListarUsuarioSeguidoresResponse value) {
        return new JAXBElement<ListarUsuarioSeguidoresResponse>(_ListarUsuarioSeguidoresResponse_QNAME, ListarUsuarioSeguidoresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CerrarSesion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "cerrarSesion")
    public JAXBElement<CerrarSesion> createCerrarSesion(CerrarSesion value) {
        return new JAXBElement<CerrarSesion>(_CerrarSesion_QNAME, CerrarSesion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerImagenDeUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerImagenDeUsuarioResponse")
    public JAXBElement<ObtenerImagenDeUsuarioResponse> createObtenerImagenDeUsuarioResponse(ObtenerImagenDeUsuarioResponse value) {
        return new JAXBElement<ObtenerImagenDeUsuarioResponse>(_ObtenerImagenDeUsuarioResponse_QNAME, ObtenerImagenDeUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaImagenDeUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "altaImagenDeUsuarioResponse")
    public JAXBElement<AltaImagenDeUsuarioResponse> createAltaImagenDeUsuarioResponse(AltaImagenDeUsuarioResponse value) {
        return new JAXBElement<AltaImagenDeUsuarioResponse>(_AltaImagenDeUsuarioResponse_QNAME, AltaImagenDeUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuitarVideoDeListaDeReproduccion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "quitarVideoDeListaDeReproduccion")
    public JAXBElement<QuitarVideoDeListaDeReproduccion> createQuitarVideoDeListaDeReproduccion(QuitarVideoDeListaDeReproduccion value) {
        return new JAXBElement<QuitarVideoDeListaDeReproduccion>(_QuitarVideoDeListaDeReproduccion_QNAME, QuitarVideoDeListaDeReproduccion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarUsuariosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "listarUsuariosResponse")
    public JAXBElement<ListarUsuariosResponse> createListarUsuariosResponse(ListarUsuariosResponse value) {
        return new JAXBElement<ListarUsuariosResponse>(_ListarUsuariosResponse_QNAME, ListarUsuariosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarVideosDeListaDeReproduccionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "listarVideosDeListaDeReproduccionResponse")
    public JAXBElement<ListarVideosDeListaDeReproduccionResponse> createListarVideosDeListaDeReproduccionResponse(ListarVideosDeListaDeReproduccionResponse value) {
        return new JAXBElement<ListarVideosDeListaDeReproduccionResponse>(_ListarVideosDeListaDeReproduccionResponse_QNAME, ListarVideosDeListaDeReproduccionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarVideosDeListaDeReproduccion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "listarVideosDeListaDeReproduccion")
    public JAXBElement<ListarVideosDeListaDeReproduccion> createListarVideosDeListaDeReproduccion(ListarVideosDeListaDeReproduccion value) {
        return new JAXBElement<ListarVideosDeListaDeReproduccion>(_ListarVideosDeListaDeReproduccion_QNAME, ListarVideosDeListaDeReproduccion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaImagenDeUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "altaImagenDeUsuario")
    public JAXBElement<AltaImagenDeUsuario> createAltaImagenDeUsuario(AltaImagenDeUsuario value) {
        return new JAXBElement<AltaImagenDeUsuario>(_AltaImagenDeUsuario_QNAME, AltaImagenDeUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaListaDeReproduccionParticularResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "altaListaDeReproduccionParticularResponse")
    public JAXBElement<AltaListaDeReproduccionParticularResponse> createAltaListaDeReproduccionParticularResponse(AltaListaDeReproduccionParticularResponse value) {
        return new JAXBElement<AltaListaDeReproduccionParticularResponse>(_AltaListaDeReproduccionParticularResponse_QNAME, AltaListaDeReproduccionParticularResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BajaUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "bajaUsuario")
    public JAXBElement<BajaUsuario> createBajaUsuario(BajaUsuario value) {
        return new JAXBElement<BajaUsuario>(_BajaUsuario_QNAME, BajaUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerValoracionDadaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerValoracionDadaResponse")
    public JAXBElement<ObtenerValoracionDadaResponse> createObtenerValoracionDadaResponse(ObtenerValoracionDadaResponse value) {
        return new JAXBElement<ObtenerValoracionDadaResponse>(_ObtenerValoracionDadaResponse_QNAME, ObtenerValoracionDadaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarListaDeReproduccionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "modificarListaDeReproduccionResponse")
    public JAXBElement<ModificarListaDeReproduccionResponse> createModificarListaDeReproduccionResponse(ModificarListaDeReproduccionResponse value) {
        return new JAXBElement<ModificarListaDeReproduccionResponse>(_ModificarListaDeReproduccionResponse_QNAME, ModificarListaDeReproduccionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarPorCategoriaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "buscarPorCategoriaResponse")
    public JAXBElement<BuscarPorCategoriaResponse> createBuscarPorCategoriaResponse(BuscarPorCategoriaResponse value) {
        return new JAXBElement<BuscarPorCategoriaResponse>(_BuscarPorCategoriaResponse_QNAME, BuscarPorCategoriaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Buscar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "buscar")
    public JAXBElement<Buscar> createBuscar(Buscar value) {
        return new JAXBElement<Buscar>(_Buscar_QNAME, Buscar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerPropietarioDeCanalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerPropietarioDeCanalResponse")
    public JAXBElement<ObtenerPropietarioDeCanalResponse> createObtenerPropietarioDeCanalResponse(ObtenerPropietarioDeCanalResponse value) {
        return new JAXBElement<ObtenerPropietarioDeCanalResponse>(_ObtenerPropietarioDeCanalResponse_QNAME, ObtenerPropietarioDeCanalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarImagenDeUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "modificarImagenDeUsuarioResponse")
    public JAXBElement<ModificarImagenDeUsuarioResponse> createModificarImagenDeUsuarioResponse(ModificarImagenDeUsuarioResponse value) {
        return new JAXBElement<ModificarImagenDeUsuarioResponse>(_ModificarImagenDeUsuarioResponse_QNAME, ModificarImagenDeUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValorarVideo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "valorarVideo")
    public JAXBElement<ValorarVideo> createValorarVideo(ValorarVideo value) {
        return new JAXBElement<ValorarVideo>(_ValorarVideo_QNAME, ValorarVideo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExisteEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "existeEmailResponse")
    public JAXBElement<ExisteEmailResponse> createExisteEmailResponse(ExisteEmailResponse value) {
        return new JAXBElement<ExisteEmailResponse>(_ExisteEmailResponse_QNAME, ExisteEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarListasDeReproduccionDeUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "listarListasDeReproduccionDeUsuario")
    public JAXBElement<ListarListasDeReproduccionDeUsuario> createListarListasDeReproduccionDeUsuario(ListarListasDeReproduccionDeUsuario value) {
        return new JAXBElement<ListarListasDeReproduccionDeUsuario>(_ListarListasDeReproduccionDeUsuario_QNAME, ListarListasDeReproduccionDeUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaListaDeReproduccionParticular }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "altaListaDeReproduccionParticular")
    public JAXBElement<AltaListaDeReproduccionParticular> createAltaListaDeReproduccionParticular(AltaListaDeReproduccionParticular value) {
        return new JAXBElement<AltaListaDeReproduccionParticular>(_AltaListaDeReproduccionParticular_QNAME, AltaListaDeReproduccionParticular.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerImagenDeUsuarioPorDefecto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerImagenDeUsuarioPorDefecto")
    public JAXBElement<ObtenerImagenDeUsuarioPorDefecto> createObtenerImagenDeUsuarioPorDefecto(ObtenerImagenDeUsuarioPorDefecto value) {
        return new JAXBElement<ObtenerImagenDeUsuarioPorDefecto>(_ObtenerImagenDeUsuarioPorDefecto_QNAME, ObtenerImagenDeUsuarioPorDefecto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarListaDeReproduccion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "modificarListaDeReproduccion")
    public JAXBElement<ModificarListaDeReproduccion> createModificarListaDeReproduccion(ModificarListaDeReproduccion value) {
        return new JAXBElement<ModificarListaDeReproduccion>(_ModificarListaDeReproduccion_QNAME, ModificarListaDeReproduccion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidarNuevoVideoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "validarNuevoVideoResponse")
    public JAXBElement<ValidarNuevoVideoResponse> createValidarNuevoVideoResponse(ValidarNuevoVideoResponse value) {
        return new JAXBElement<ValidarNuevoVideoResponse>(_ValidarNuevoVideoResponse_QNAME, ValidarNuevoVideoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarUsuarioSeguidosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "listarUsuarioSeguidosResponse")
    public JAXBElement<ListarUsuarioSeguidosResponse> createListarUsuarioSeguidosResponse(ListarUsuarioSeguidosResponse value) {
        return new JAXBElement<ListarUsuarioSeguidosResponse>(_ListarUsuarioSeguidosResponse_QNAME, ListarUsuarioSeguidosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarUsuarioSeguidos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "listarUsuarioSeguidos")
    public JAXBElement<ListarUsuarioSeguidos> createListarUsuarioSeguidos(ListarUsuarioSeguidos value) {
        return new JAXBElement<ListarUsuarioSeguidos>(_ListarUsuarioSeguidos_QNAME, ListarUsuarioSeguidos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeleccionarListaDeReproduccion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "seleccionarListaDeReproduccion")
    public JAXBElement<SeleccionarListaDeReproduccion> createSeleccionarListaDeReproduccion(SeleccionarListaDeReproduccion value) {
        return new JAXBElement<SeleccionarListaDeReproduccion>(_SeleccionarListaDeReproduccion_QNAME, SeleccionarListaDeReproduccion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaComentario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "altaComentario")
    public JAXBElement<AltaComentario> createAltaComentario(AltaComentario value) {
        return new JAXBElement<AltaComentario>(_AltaComentario_QNAME, AltaComentario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarVideoAListaDeReproduccionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "agregarVideoAListaDeReproduccionResponse")
    public JAXBElement<AgregarVideoAListaDeReproduccionResponse> createAgregarVideoAListaDeReproduccionResponse(AgregarVideoAListaDeReproduccionResponse value) {
        return new JAXBElement<AgregarVideoAListaDeReproduccionResponse>(_AgregarVideoAListaDeReproduccionResponse_QNAME, AgregarVideoAListaDeReproduccionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarImagenDeUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "modificarImagenDeUsuario")
    public JAXBElement<ModificarImagenDeUsuario> createModificarImagenDeUsuario(ModificarImagenDeUsuario value) {
        return new JAXBElement<ModificarImagenDeUsuario>(_ModificarImagenDeUsuario_QNAME, ModificarImagenDeUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarCategorias }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "listarCategorias")
    public JAXBElement<ListarCategorias> createListarCategorias(ListarCategorias value) {
        return new JAXBElement<ListarCategorias>(_ListarCategorias_QNAME, ListarCategorias.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarUsuarioYCanalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "modificarUsuarioYCanalResponse")
    public JAXBElement<ModificarUsuarioYCanalResponse> createModificarUsuarioYCanalResponse(ModificarUsuarioYCanalResponse value) {
        return new JAXBElement<ModificarUsuarioYCanalResponse>(_ModificarUsuarioYCanalResponse_QNAME, ModificarUsuarioYCanalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarUsuarioYCanal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "modificarUsuarioYCanal")
    public JAXBElement<ModificarUsuarioYCanal> createModificarUsuarioYCanal(ModificarUsuarioYCanal value) {
        return new JAXBElement<ModificarUsuarioYCanal>(_ModificarUsuarioYCanal_QNAME, ModificarUsuarioYCanal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarListasDeReproduccionDeUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "listarListasDeReproduccionDeUsuarioResponse")
    public JAXBElement<ListarListasDeReproduccionDeUsuarioResponse> createListarListasDeReproduccionDeUsuarioResponse(ListarListasDeReproduccionDeUsuarioResponse value) {
        return new JAXBElement<ListarListasDeReproduccionDeUsuarioResponse>(_ListarListasDeReproduccionDeUsuarioResponse_QNAME, ListarListasDeReproduccionDeUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerPropietarioDeVideoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerPropietarioDeVideoResponse")
    public JAXBElement<ObtenerPropietarioDeVideoResponse> createObtenerPropietarioDeVideoResponse(ObtenerPropietarioDeVideoResponse value) {
        return new JAXBElement<ObtenerPropietarioDeVideoResponse>(_ObtenerPropietarioDeVideoResponse_QNAME, ObtenerPropietarioDeVideoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExisteNicknameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "existeNicknameResponse")
    public JAXBElement<ExisteNicknameResponse> createExisteNicknameResponse(ExisteNicknameResponse value) {
        return new JAXBElement<ExisteNicknameResponse>(_ExisteNicknameResponse_QNAME, ExisteNicknameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerImagenDeUsuarioPorDefectoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerImagenDeUsuarioPorDefectoResponse")
    public JAXBElement<ObtenerImagenDeUsuarioPorDefectoResponse> createObtenerImagenDeUsuarioPorDefectoResponse(ObtenerImagenDeUsuarioPorDefectoResponse value) {
        return new JAXBElement<ObtenerImagenDeUsuarioPorDefectoResponse>(_ObtenerImagenDeUsuarioPorDefectoResponse_QNAME, ObtenerImagenDeUsuarioPorDefectoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidarNuevoVideo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "validarNuevoVideo")
    public JAXBElement<ValidarNuevoVideo> createValidarNuevoVideo(ValidarNuevoVideo value) {
        return new JAXBElement<ValidarNuevoVideo>(_ValidarNuevoVideo_QNAME, ValidarNuevoVideo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CerrarSesionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "cerrarSesionResponse")
    public JAXBElement<CerrarSesionResponse> createCerrarSesionResponse(CerrarSesionResponse value) {
        return new JAXBElement<CerrarSesionResponse>(_CerrarSesionResponse_QNAME, CerrarSesionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerPropietarioDeListaDeReproduccion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerPropietarioDeListaDeReproduccion")
    public JAXBElement<ObtenerPropietarioDeListaDeReproduccion> createObtenerPropietarioDeListaDeReproduccion(ObtenerPropietarioDeListaDeReproduccion value) {
        return new JAXBElement<ObtenerPropietarioDeListaDeReproduccion>(_ObtenerPropietarioDeListaDeReproduccion_QNAME, ObtenerPropietarioDeListaDeReproduccion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerUsuarioActual }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerUsuarioActual")
    public JAXBElement<ObtenerUsuarioActual> createObtenerUsuarioActual(ObtenerUsuarioActual value) {
        return new JAXBElement<ObtenerUsuarioActual>(_ObtenerUsuarioActual_QNAME, ObtenerUsuarioActual.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerPropietarioDeCanal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerPropietarioDeCanal")
    public JAXBElement<ObtenerPropietarioDeCanal> createObtenerPropietarioDeCanal(ObtenerPropietarioDeCanal value) {
        return new JAXBElement<ObtenerPropietarioDeCanal>(_ObtenerPropietarioDeCanal_QNAME, ObtenerPropietarioDeCanal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerCanalDeUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerCanalDeUsuario")
    public JAXBElement<ObtenerCanalDeUsuario> createObtenerCanalDeUsuario(ObtenerCanalDeUsuario value) {
        return new JAXBElement<ObtenerCanalDeUsuario>(_ObtenerCanalDeUsuario_QNAME, ObtenerCanalDeUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeleccionarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "seleccionarUsuarioResponse")
    public JAXBElement<SeleccionarUsuarioResponse> createSeleccionarUsuarioResponse(SeleccionarUsuarioResponse value) {
        return new JAXBElement<SeleccionarUsuarioResponse>(_SeleccionarUsuarioResponse_QNAME, SeleccionarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExisteEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "existeEmail")
    public JAXBElement<ExisteEmail> createExisteEmail(ExisteEmail value) {
        return new JAXBElement<ExisteEmail>(_ExisteEmail_QNAME, ExisteEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaUsuarioCanalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "altaUsuarioCanalResponse")
    public JAXBElement<AltaUsuarioCanalResponse> createAltaUsuarioCanalResponse(AltaUsuarioCanalResponse value) {
        return new JAXBElement<AltaUsuarioCanalResponse>(_AltaUsuarioCanalResponse_QNAME, AltaUsuarioCanalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ElUsuarioSeleccionadoEsElUsuarioActualResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "elUsuarioSeleccionadoEsElUsuarioActualResponse")
    public JAXBElement<ElUsuarioSeleccionadoEsElUsuarioActualResponse> createElUsuarioSeleccionadoEsElUsuarioActualResponse(ElUsuarioSeleccionadoEsElUsuarioActualResponse value) {
        return new JAXBElement<ElUsuarioSeleccionadoEsElUsuarioActualResponse>(_ElUsuarioSeleccionadoEsElUsuarioActualResponse_QNAME, ElUsuarioSeleccionadoEsElUsuarioActualResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarVideosDeUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "listarVideosDeUsuarioResponse")
    public JAXBElement<ListarVideosDeUsuarioResponse> createListarVideosDeUsuarioResponse(ListarVideosDeUsuarioResponse value) {
        return new JAXBElement<ListarVideosDeUsuarioResponse>(_ListarVideosDeUsuarioResponse_QNAME, ListarVideosDeUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarComentariosDeVideo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "listarComentariosDeVideo")
    public JAXBElement<ListarComentariosDeVideo> createListarComentariosDeVideo(ListarComentariosDeVideo value) {
        return new JAXBElement<ListarComentariosDeVideo>(_ListarComentariosDeVideo_QNAME, ListarComentariosDeVideo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarComentariosDeVideoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "listarComentariosDeVideoResponse")
    public JAXBElement<ListarComentariosDeVideoResponse> createListarComentariosDeVideoResponse(ListarComentariosDeVideoResponse value) {
        return new JAXBElement<ListarComentariosDeVideoResponse>(_ListarComentariosDeVideoResponse_QNAME, ListarComentariosDeVideoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarVideoAHistorial }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "agregarVideoAHistorial")
    public JAXBElement<AgregarVideoAHistorial> createAgregarVideoAHistorial(AgregarVideoAHistorial value) {
        return new JAXBElement<AgregarVideoAHistorial>(_AgregarVideoAHistorial_QNAME, AgregarVideoAHistorial.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerImagenDeUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerImagenDeUsuario")
    public JAXBElement<ObtenerImagenDeUsuario> createObtenerImagenDeUsuario(ObtenerImagenDeUsuario value) {
        return new JAXBElement<ObtenerImagenDeUsuario>(_ObtenerImagenDeUsuario_QNAME, ObtenerImagenDeUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "buscarResponse")
    public JAXBElement<BuscarResponse> createBuscarResponse(BuscarResponse value) {
        return new JAXBElement<BuscarResponse>(_BuscarResponse_QNAME, BuscarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExisteImagenDeUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "existeImagenDeUsuario")
    public JAXBElement<ExisteImagenDeUsuario> createExisteImagenDeUsuario(ExisteImagenDeUsuario value) {
        return new JAXBElement<ExisteImagenDeUsuario>(_ExisteImagenDeUsuario_QNAME, ExisteImagenDeUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerValoracionesDeVideo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerValoracionesDeVideo")
    public JAXBElement<ObtenerValoracionesDeVideo> createObtenerValoracionesDeVideo(ObtenerValoracionesDeVideo value) {
        return new JAXBElement<ObtenerValoracionesDeVideo>(_ObtenerValoracionesDeVideo_QNAME, ObtenerValoracionesDeVideo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarCategoriasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "listarCategoriasResponse")
    public JAXBElement<ListarCategoriasResponse> createListarCategoriasResponse(ListarCategoriasResponse value) {
        return new JAXBElement<ListarCategoriasResponse>(_ListarCategoriasResponse_QNAME, ListarCategoriasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeleccionarVideo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "seleccionarVideo")
    public JAXBElement<SeleccionarVideo> createSeleccionarVideo(SeleccionarVideo value) {
        return new JAXBElement<SeleccionarVideo>(_SeleccionarVideo_QNAME, SeleccionarVideo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeleccionarVideoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "seleccionarVideoResponse")
    public JAXBElement<SeleccionarVideoResponse> createSeleccionarVideoResponse(SeleccionarVideoResponse value) {
        return new JAXBElement<SeleccionarVideoResponse>(_SeleccionarVideoResponse_QNAME, SeleccionarVideoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidarNuevaListaParticularResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "validarNuevaListaParticularResponse")
    public JAXBElement<ValidarNuevaListaParticularResponse> createValidarNuevaListaParticularResponse(ValidarNuevaListaParticularResponse value) {
        return new JAXBElement<ValidarNuevaListaParticularResponse>(_ValidarNuevaListaParticularResponse_QNAME, ValidarNuevaListaParticularResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaUsuarioCanal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "altaUsuarioCanal")
    public JAXBElement<AltaUsuarioCanal> createAltaUsuarioCanal(AltaUsuarioCanal value) {
        return new JAXBElement<AltaUsuarioCanal>(_AltaUsuarioCanal_QNAME, AltaUsuarioCanal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValorarVideoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "valorarVideoResponse")
    public JAXBElement<ValorarVideoResponse> createValorarVideoResponse(ValorarVideoResponse value) {
        return new JAXBElement<ValorarVideoResponse>(_ValorarVideoResponse_QNAME, ValorarVideoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarVideoAListaDeReproduccion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "agregarVideoAListaDeReproduccion")
    public JAXBElement<AgregarVideoAListaDeReproduccion> createAgregarVideoAListaDeReproduccion(AgregarVideoAListaDeReproduccion value) {
        return new JAXBElement<AgregarVideoAListaDeReproduccion>(_AgregarVideoAListaDeReproduccion_QNAME, AgregarVideoAListaDeReproduccion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaSubComentarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "altaSubComentarioResponse")
    public JAXBElement<AltaSubComentarioResponse> createAltaSubComentarioResponse(AltaSubComentarioResponse value) {
        return new JAXBElement<AltaSubComentarioResponse>(_AltaSubComentarioResponse_QNAME, AltaSubComentarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaSubComentario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "altaSubComentario")
    public JAXBElement<AltaSubComentario> createAltaSubComentario(AltaSubComentario value) {
        return new JAXBElement<AltaSubComentario>(_AltaSubComentario_QNAME, AltaSubComentario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarVideo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "modificarVideo")
    public JAXBElement<ModificarVideo> createModificarVideo(ModificarVideo value) {
        return new JAXBElement<ModificarVideo>(_ModificarVideo_QNAME, ModificarVideo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reset }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "reset")
    public JAXBElement<Reset> createReset(Reset value) {
        return new JAXBElement<Reset>(_Reset_QNAME, Reset.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerCanalDeUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerCanalDeUsuarioResponse")
    public JAXBElement<ObtenerCanalDeUsuarioResponse> createObtenerCanalDeUsuarioResponse(ObtenerCanalDeUsuarioResponse value) {
        return new JAXBElement<ObtenerCanalDeUsuarioResponse>(_ObtenerCanalDeUsuarioResponse_QNAME, ObtenerCanalDeUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuitarVideoDeListaDeReproduccionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "quitarVideoDeListaDeReproduccionResponse")
    public JAXBElement<QuitarVideoDeListaDeReproduccionResponse> createQuitarVideoDeListaDeReproduccionResponse(QuitarVideoDeListaDeReproduccionResponse value) {
        return new JAXBElement<QuitarVideoDeListaDeReproduccionResponse>(_QuitarVideoDeListaDeReproduccionResponse_QNAME, QuitarVideoDeListaDeReproduccionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LiberarMemoriaListaDeReproduccionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "liberarMemoriaListaDeReproduccionResponse")
    public JAXBElement<LiberarMemoriaListaDeReproduccionResponse> createLiberarMemoriaListaDeReproduccionResponse(LiberarMemoriaListaDeReproduccionResponse value) {
        return new JAXBElement<LiberarMemoriaListaDeReproduccionResponse>(_LiberarMemoriaListaDeReproduccionResponse_QNAME, LiberarMemoriaListaDeReproduccionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaVideo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "altaVideo")
    public JAXBElement<AltaVideo> createAltaVideo(AltaVideo value) {
        return new JAXBElement<AltaVideo>(_AltaVideo_QNAME, AltaVideo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaVideoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "altaVideoResponse")
    public JAXBElement<AltaVideoResponse> createAltaVideoResponse(AltaVideoResponse value) {
        return new JAXBElement<AltaVideoResponse>(_AltaVideoResponse_QNAME, AltaVideoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeguirUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "seguirUsuario")
    public JAXBElement<SeguirUsuario> createSeguirUsuario(SeguirUsuario value) {
        return new JAXBElement<SeguirUsuario>(_SeguirUsuario_QNAME, SeguirUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeleccionarListaDeReproduccionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "seleccionarListaDeReproduccionResponse")
    public JAXBElement<SeleccionarListaDeReproduccionResponse> createSeleccionarListaDeReproduccionResponse(SeleccionarListaDeReproduccionResponse value) {
        return new JAXBElement<SeleccionarListaDeReproduccionResponse>(_SeleccionarListaDeReproduccionResponse_QNAME, SeleccionarListaDeReproduccionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LiberarMemoriaVideo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "liberarMemoriaVideo")
    public JAXBElement<LiberarMemoriaVideo> createLiberarMemoriaVideo(LiberarMemoriaVideo value) {
        return new JAXBElement<LiberarMemoriaVideo>(_LiberarMemoriaVideo_QNAME, LiberarMemoriaVideo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeguirUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "seguirUsuarioResponse")
    public JAXBElement<SeguirUsuarioResponse> createSeguirUsuarioResponse(SeguirUsuarioResponse value) {
        return new JAXBElement<SeguirUsuarioResponse>(_SeguirUsuarioResponse_QNAME, SeguirUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IniciarSesionUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "iniciarSesionUsuarioResponse")
    public JAXBElement<IniciarSesionUsuarioResponse> createIniciarSesionUsuarioResponse(IniciarSesionUsuarioResponse value) {
        return new JAXBElement<IniciarSesionUsuarioResponse>(_IniciarSesionUsuarioResponse_QNAME, IniciarSesionUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarUsuarios }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "listarUsuarios")
    public JAXBElement<ListarUsuarios> createListarUsuarios(ListarUsuarios value) {
        return new JAXBElement<ListarUsuarios>(_ListarUsuarios_QNAME, ListarUsuarios.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SesionIniciada }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "sesionIniciada")
    public JAXBElement<SesionIniciada> createSesionIniciada(SesionIniciada value) {
        return new JAXBElement<SesionIniciada>(_SesionIniciada_QNAME, SesionIniciada.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ElUsuarioSeleccionadoEsElUsuarioActual }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "elUsuarioSeleccionadoEsElUsuarioActual")
    public JAXBElement<ElUsuarioSeleccionadoEsElUsuarioActual> createElUsuarioSeleccionadoEsElUsuarioActual(ElUsuarioSeleccionadoEsElUsuarioActual value) {
        return new JAXBElement<ElUsuarioSeleccionadoEsElUsuarioActual>(_ElUsuarioSeleccionadoEsElUsuarioActual_QNAME, ElUsuarioSeleccionadoEsElUsuarioActual.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerUsuarioActualResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerUsuarioActualResponse")
    public JAXBElement<ObtenerUsuarioActualResponse> createObtenerUsuarioActualResponse(ObtenerUsuarioActualResponse value) {
        return new JAXBElement<ObtenerUsuarioActualResponse>(_ObtenerUsuarioActualResponse_QNAME, ObtenerUsuarioActualResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerPropietarioDeListaDeReproduccionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerPropietarioDeListaDeReproduccionResponse")
    public JAXBElement<ObtenerPropietarioDeListaDeReproduccionResponse> createObtenerPropietarioDeListaDeReproduccionResponse(ObtenerPropietarioDeListaDeReproduccionResponse value) {
        return new JAXBElement<ObtenerPropietarioDeListaDeReproduccionResponse>(_ObtenerPropietarioDeListaDeReproduccionResponse_QNAME, ObtenerPropietarioDeListaDeReproduccionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarUsuarioSeguidores }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "listarUsuarioSeguidores")
    public JAXBElement<ListarUsuarioSeguidores> createListarUsuarioSeguidores(ListarUsuarioSeguidores value) {
        return new JAXBElement<ListarUsuarioSeguidores>(_ListarUsuarioSeguidores_QNAME, ListarUsuarioSeguidores.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExisteImagenDeUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "existeImagenDeUsuarioResponse")
    public JAXBElement<ExisteImagenDeUsuarioResponse> createExisteImagenDeUsuarioResponse(ExisteImagenDeUsuarioResponse value) {
        return new JAXBElement<ExisteImagenDeUsuarioResponse>(_ExisteImagenDeUsuarioResponse_QNAME, ExisteImagenDeUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeleccionarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "seleccionarUsuario")
    public JAXBElement<SeleccionarUsuario> createSeleccionarUsuario(SeleccionarUsuario value) {
        return new JAXBElement<SeleccionarUsuario>(_SeleccionarUsuario_QNAME, SeleccionarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerValoracionesDeVideoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "obtenerValoracionesDeVideoResponse")
    public JAXBElement<ObtenerValoracionesDeVideoResponse> createObtenerValoracionesDeVideoResponse(ObtenerValoracionesDeVideoResponse value) {
        return new JAXBElement<ObtenerValoracionesDeVideoResponse>(_ObtenerValoracionesDeVideoResponse_QNAME, ObtenerValoracionesDeVideoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarImagenDeUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "eliminarImagenDeUsuarioResponse")
    public JAXBElement<EliminarImagenDeUsuarioResponse> createEliminarImagenDeUsuarioResponse(EliminarImagenDeUsuarioResponse value) {
        return new JAXBElement<EliminarImagenDeUsuarioResponse>(_EliminarImagenDeUsuarioResponse_QNAME, EliminarImagenDeUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LiberarMemoriaVideoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "liberarMemoriaVideoResponse")
    public JAXBElement<LiberarMemoriaVideoResponse> createLiberarMemoriaVideoResponse(LiberarMemoriaVideoResponse value) {
        return new JAXBElement<LiberarMemoriaVideoResponse>(_LiberarMemoriaVideoResponse_QNAME, LiberarMemoriaVideoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "resetResponse")
    public JAXBElement<ResetResponse> createResetResponse(ResetResponse value) {
        return new JAXBElement<ResetResponse>(_ResetResponse_QNAME, ResetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BajaUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "bajaUsuarioResponse")
    public JAXBElement<BajaUsuarioResponse> createBajaUsuarioResponse(BajaUsuarioResponse value) {
        return new JAXBElement<BajaUsuarioResponse>(_BajaUsuarioResponse_QNAME, BajaUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidarNuevaListaParticular }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "validarNuevaListaParticular")
    public JAXBElement<ValidarNuevaListaParticular> createValidarNuevaListaParticular(ValidarNuevaListaParticular value) {
        return new JAXBElement<ValidarNuevaListaParticular>(_ValidarNuevaListaParticular_QNAME, ValidarNuevaListaParticular.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExisteNickname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Controladores.Logica/", name = "existeNickname")
    public JAXBElement<ExisteNickname> createExisteNickname(ExisteNickname value) {
        return new JAXBElement<ExisteNickname>(_ExisteNickname_QNAME, ExisteNickname.class, null, value);
    }

}
