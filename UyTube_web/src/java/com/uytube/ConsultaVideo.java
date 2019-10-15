package com.uytube;

import Funciones.Funciones;
import Logica.DataType.DtCanal;
import Logica.DataType.DtComentario;
import Logica.DataType.DtUsuario;
import Logica.DataType.DtValoracion;
import Logica.DataType.DtVideo;
import Logica.Enumerados.TipoValoracion;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import Logica.Interfaces.IUsuario;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConsultaVideo extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            IUsuario sys = Fabrica.getInstancia().getIUsuario();
            String strIDVideo = request.getParameter("id");
            int idVideo = Integer.valueOf(strIDVideo);

            DtUsuario usuario = sys.obtenerPropietarioDeVideo(idVideo);
            sys.seleccionarUsuario(usuario.getNickname());
            DtCanal canal = sys.obtenerCanalDeUsuario();
            DtVideo video = sys.seleccionarVideo(idVideo);
            ArrayList<DtComentario> comentarios = sys.listarComentariosDeVideo();
            DtValoracion valoracionDada = null;
            boolean sesionIniciada = sys.sesionIniciada();
            boolean propietarioDelVideo = false;
            if (sesionIniciada) {
                propietarioDelVideo = usuario.getNickname().equals(sys.obtenerUsuarioActual().getNickname());
                valoracionDada = sys.obtenerValoracionDada();
            }

            
            String htmlComentarios = htmlDeSeccionDeComentarios(comentarios, obtenerImagenesDeUsuarios(comentarios), sesionIniciada);
            // no se si la siguiente linea es necesaria, pero por las dudas la pongo, para no dejar incoherencias en la logica
            sys.seleccionarUsuario(usuario.getNickname());
            request.setAttribute("usuario", usuario);
            request.setAttribute("canal", canal);
            request.setAttribute("video", video);
            request.setAttribute("comentarios", htmlComentarios);
            request.setAttribute("sesionIniciada", sesionIniciada);
            request.setAttribute("propietarioDelVideo", propietarioDelVideo);
            request.setAttribute("valoracionDada", valoracionDada);
            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/ConsultaVideo.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("---- Exception ----");
            System.out.println(e.getMessage());
            System.out.println("-------------------");
            RequestDispatcher rd; //objeto para despachar
            request.setAttribute("mensajeError", e.getMessage());
            rd = request.getRequestDispatcher("/404.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            IUsuario sys = Fabrica.getInstancia().getIUsuario();
            String accion = request.getParameter("accion");
            String respuesta;
            response.setContentType("text/html");  // Tipo de dato de la respuesta
            response.setCharacterEncoding("UTF-8"); // Tipo de Codificación de caracteres
            
            // ---- Acciones relacionadas a VALORAR VIDEO ----
            switch (accion) {
                case "like":
                case "disLike": {
                    /**
                     * Estimado programador que está leyendo esto:
                     * El codigo que comento a continuacion deberia ser el
                     * correcto para esta funcionalidad, pero por alguna extraña
                     * razon no funciona y debi implementar un parche. El codigo
                     * en cuestion falla al hacer la siguiente secuencia de
                     * pasos: 1- Iniciar sesion en el sitio web 2- Consultar un
                     * video que no posee ninguna valoracion 3- Indicar que te
                     * gusta el video Sibien la página muestra los contadores
                     * correctamente, este cambio no se ve reflejado en la base
                     * de datos, lo cual genera inconsistencias al recargar la
                     * página
                     * Si
                     * usted encuentra el verdadero problema y lo logra
                     * solucionar de manera correcta, por favor comuniquese
                     * conmigo
                     */
                    /*
                    int idVideo = Integer.valueOf(request.getParameter("idVideo"));
                    DtValoracion dtVal = null;
                    switch (accion) {
                        case "like":
                            dtVal = new DtValoracion(TipoValoracion.LIKE, "");
                            break;
                        case "disLike":
                            dtVal = new DtValoracion(TipoValoracion.DISLIKE, "");
                            break;
                    }       // se seleccionan el usuario due;o del video y el video (por las dudas)
                    DtUsuario usuarioDuenioDelVideo = sys.obtenerPropietarioDeVideo(idVideo);
                    sys.seleccionarUsuario(usuarioDuenioDelVideo.getNickname());
                    sys.seleccionarVideo(idVideo);
                    sys.valorarVideo(dtVal);
                    // obtiene las cantidades de valoraciones
                    DtVideo dtv = sys.seleccionarVideo(idVideo);
                    String strCantLikes = String.valueOf(dtv.getCantLikes());
                    String strCantDisLikes = String.valueOf(dtv.getCantDisLikes());
                    // Las concatena para devolverlas
                    respuesta = strCantLikes + ":" + strCantDisLikes;
                    response.getWriter().write(respuesta);
                    break;
                    */
                    
                    IAdmin parche = Fabrica.getInstancia().getIAdmin();
                    
                    int idVideo = Integer.valueOf(request.getParameter("idVideo"));
                    DtValoracion dtVal = null;
                    switch (accion) {
                        case "like":
                            dtVal = new DtValoracion(TipoValoracion.LIKE, "");
                            break;
                        case "disLike":
                            dtVal = new DtValoracion(TipoValoracion.DISLIKE, "");
                            break;
                    }       // se seleccionan el usuario due;o del video y el video (por las dudas)
                    DtUsuario usuarioDuenioDelVideo = parche.obtenerPropietarioDeVideo(idVideo);
                    parche.seleccionarUsuarioActual(((DtUsuario)request.getSession().getAttribute("usuario")).getNickname());
                    parche.seleccionarUsuario(usuarioDuenioDelVideo.getNickname());
                    parche.seleccionarVideo(idVideo);
                    parche.altaValoracion(dtVal);
                    // obtiene las cantidades de valoraciones
                    DtVideo dtv = parche.seleccionarVideo(idVideo);
                    String strCantLikes = String.valueOf(dtv.getCantLikes());
                    String strCantDisLikes = String.valueOf(dtv.getCantDisLikes());
                    // Las concatena para devolverlas
                    respuesta = strCantLikes + ":" + strCantDisLikes;
                    response.getWriter().write(respuesta);
                    break;
                }
                // ---- Acciones relacionadas a COMENTAR VIDEO ----
                case "comentarVideo":
                case "responderComentario": {
                    // Se extraen los datos recibidos
                    String texto = request.getParameter("texto");
                    int idVideo = Integer.valueOf(request.getParameter("idVideo"));
                    int idComentario = -1;
                    if (request.getParameter("idComentario") != null) {
                        idComentario = Integer.valueOf(request.getParameter("idComentario"));
                    }       // se seleccionan el usuario due;o del video y el video (por las dudas)
                    DtUsuario usuarioDuenioDelVideo = sys.obtenerPropietarioDeVideo(idVideo);
                    sys.seleccionarUsuario(usuarioDuenioDelVideo.getNickname());
                    sys.seleccionarVideo(idVideo);
                    // Crea el DT y lo manda al sistema
                    DtComentario dtc = new DtComentario(0, "", Funciones.fechaActual(), texto, 0);
                    if (idComentario <= 0) {
                        sys.altaComentario(dtc);
                    } else {
                        sys.altaComentario(dtc, idComentario);
                    }       // se obtienen los comentarios y se genera el HTML para actualizar la p'pagina
                    ArrayList<DtComentario> comentarios = sys.listarComentariosDeVideo();
                    String htmlComentarios = htmlDeSeccionDeComentarios(comentarios, obtenerImagenesDeUsuarios(comentarios), true);
                    // la funcion 'obtenerImagenesDeUsuarios' selecciona usuarios asi que por las dudas lo vuelvo a seleccionar para que la logica quede coherente
                    sys.seleccionarUsuario(usuarioDuenioDelVideo.getNickname());
                    respuesta = htmlComentarios;
                    response.getWriter().write(respuesta);
                    break;
                }
                // ---- Acciones relacionadas a AGREGAR VIDEO A LISTA DE REPRODUCCION----
                case "agregarALista":
                    /*
                    int idVideo = Integer.valueOf(request.getParameter("idVideo"));
                    int idLista = Integer.valueOf(request.getParameter("idLista"));
                    
                    sys.seleccionarUsuario(sys.obtenerPropietarioDeVideo(idVideo).getNickname());
                    sys.agregarVideoAListaDeReproduccion(idLista);
                     */
                    respuesta = "Esta funcionalidad no ha sido implementada aun...";
                    response.getWriter().write(respuesta);
                    break;
                case "listarValoraciones":
                    respuesta = "";
                    ArrayList<DtValoracion> valoraciones = sys.obtenerValoracionesDeVideo();
                    for (DtValoracion val : valoraciones){
                        respuesta += val.getNickname() + " le ha dado " + val.getVal() + "\n";
                    }
                    if (valoraciones.isEmpty()){
                        respuesta = "Este video no tiene valoraciones";
                    }
                    
                    response.getWriter().write(respuesta);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("---- Exception ----");
            System.out.println(e.getMessage());
            System.out.println("-------------------");
            RequestDispatcher rd; //objeto para despachar
            request.setAttribute("mensajeError", e.getMessage());
            rd = request.getRequestDispatcher("/404.jsp");
            rd.forward(request, response);
        }
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    private ArrayList<String> obtenerImagenesDeUsuarios(ArrayList<DtComentario> comentarios){
        ArrayList<String> ret = new ArrayList();
        IUsuario sys = Fabrica.getInstancia().getIUsuario();
        for (DtComentario c : comentarios){
            ret.add(sys.seleccionarUsuario(c.getNickname()).getImagen());
        }
        return ret;
    }
    
    private String htmlDeSeccionDeComentarios(ArrayList<DtComentario> comentarios, ArrayList<String> imagenes, boolean  mostrarBotonResponder){
        if (comentarios == null || comentarios.isEmpty()){
            return "";
        }
        
        String ret = "";
        DtComentario c = comentarios.remove(0);
        String imgPerfil = "imagenes/ukp.png";
        if ( ! imagenes.isEmpty())  imgPerfil = imagenes.remove(0);
        String strFecha = new SimpleDateFormat("dd/MM/yyyy").format(c.getFecha());
        
        ret += "    <div class=\"media\">";
        ret += "        <img class=\"mr-3\" src=\"" + imgPerfil + "\" width=\"50\" height=\"50\">";
        ret += "        <div class=\"media-body\">";
        ret += "            <h5 class=\"mt-0\">";
        ret += "                <a href=\"usuario-consultar?id=" + c.getNickname() + "\">";
        ret += "                   " + c.getNickname();
        ret += "                </a>";
        ret += "            </h5>";
        ret += "            " + c.getTexto() + " (" + strFecha + ")";
        ret += "            <br>";
        if (mostrarBotonResponder){
            ret += "            <button type=\"button\" onmouseover=\"idComentario = this.getAttribute('value');\" value=\"" + c.getId() + "\" class=\"btn btn-primary responder\" data-toggle=\"modal\" data-target=\"#exampleModal\" data-whatever=\"@mdo\">Responder</button>";
        }
        ret += "            <br>";
        
        if ( (!comentarios.isEmpty()) && (comentarios.get(0).getNivelSubComentario() > c.getNivelSubComentario())){
                ret += htmlDeSeccionDeComentarios(comentarios, imagenes, mostrarBotonResponder);
        }
        
        ret += "    </div>";
        ret += "</div>";
        
        if ( (!comentarios.isEmpty()) && (comentarios.get(0).getNivelSubComentario() == c.getNivelSubComentario())){
                ret += htmlDeSeccionDeComentarios(comentarios, imagenes, mostrarBotonResponder);
        }
        return ret;
    }
    /*
    // ESTRUCTURA DE UN COMENTARIO: 
    <div class="media">
        <img class="mr-3" src="IMAGEN DE PERFIL" width="50" height="50">
        <div class="media-body">
            <h5 class="mt-0">
                <a href="usuario-consulta?id=NICKNAME DEL USUARIO">
                    NICKNAME DEL USUARIO
                </a>
            </h5>
            TEXTO DEL COMENTARIO (dd/mm/yyyy)
            <br>
            <button type="button" onmouseover="idComentario = this.getAttribute('value');" value="ID DE COMENTARIO" class="btn btn-primary responder" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Responder</button>
            <br>
            // RESPUESTAS DEL COMENTARIO
        </div>
    </div>
    */
    
    
    
}
