package com.uytube;

import Funciones.Funciones;
import logica.controladores.DtCanal;
import logica.controladores.DtComentario;
import logica.controladores.DtListaDeReproduccion;
import logica.controladores.DtUsuario;
import logica.controladores.DtValoracion;
import logica.controladores.DtVideo;
import logica.controladores.TipoValoracion;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.controladores.CUsuario;
import logica.controladores.CUsuarioService;
import logica.controladores.Fecha;

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
        Funciones.showLog(request, response);
        try {
            
            CUsuarioService servicio = new CUsuarioService();
            CUsuario sys = servicio.getCUsuarioPort();
            
            if (!sys.sesionIniciada()){
                response.sendRedirect("inicio-sesion");
                return;
            }else{
                HttpSession sesion = request.getSession();
                DtUsuario usuario = sys.obtenerUsuarioActual();
                sesion.setMaxInactiveInterval(14400);
                sesion.setAttribute("usuario", usuario);
            }
            
            String strIDVideo = request.getParameter("id");
            int idVideo = Integer.valueOf(strIDVideo);
            
            DtUsuario usuario = sys.obtenerPropietarioDeVideo(idVideo);
            sys.seleccionarUsuario(usuario.getNickname());
            DtCanal canal = sys.obtenerCanalDeUsuario();
            DtVideo video = sys.seleccionarVideo(idVideo);
            ArrayList<DtComentario> comentarios = (ArrayList<DtComentario>) sys.listarComentariosDeVideo();
            DtValoracion valoracionDada = null;
            ArrayList<DtValoracion> valoraciones = null;
            boolean sesionIniciada = sys.sesionIniciada();
            boolean propietarioDelVideo = false;
            ArrayList<DtListaDeReproduccion> listas = null;
            if (sesionIniciada) {
                propietarioDelVideo = usuario.getNickname().equals(sys.obtenerUsuarioActual().getNickname());
                valoracionDada = sys.obtenerValoracionDada();
                if (propietarioDelVideo){
                    valoraciones = (ArrayList<DtValoracion>) sys.obtenerValoracionesDeVideo();
                }
                sys.seleccionarUsuario(sys.obtenerUsuarioActual().getNickname());
                listas = (ArrayList<DtListaDeReproduccion>) sys.listarListasDeReproduccionDeUsuario(true);
                sys.seleccionarUsuario(sys.obtenerPropietarioDeVideo(idVideo).getNickname());
                sys.agregarVideoAHistorial();
            }
            
            String htmlComentarios = htmlDeSeccionDeComentarios(comentarios, sesionIniciada);
            // no se si la siguiente linea es necesaria, pero por las dudas la pongo, para no dejar incoherencias en la logica
            sys.seleccionarUsuario(usuario.getNickname());
            request.setAttribute("usuario", usuario);
            request.setAttribute("canal", canal);
            request.setAttribute("video", video);
            request.setAttribute("comentarios", htmlComentarios);
            request.setAttribute("sesionIniciada", sesionIniciada);
            request.setAttribute("propietarioDelVideo", propietarioDelVideo);
            request.setAttribute("valoracionDada", valoracionDada);
            request.setAttribute("valoraciones", valoraciones);
            request.setAttribute("listas", listas);
            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/ConsultaVideo.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            Funciones.showLog(e);
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
        Funciones.showLog(request, response);
        try {
            CUsuarioService servicio = new CUsuarioService();
            CUsuario sys = servicio.getCUsuarioPort();
            
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
                    /**
                     * En respuesta al comentario anterior:
                     * Parece ser que el
                     * error estaba en la logica, JPA hacia cosas raras.
                     * Modifiqué la funcion seleccionarUsuario(nickname) en la
                     * Logica para que si se intenta seleccionar al usuario que
                     * tiene la sesion iniciada, se apunte a usuarioActual y no
                     * a una copia de la entidad (generada por JPA)
                     * Descomento
                     * el codigo que parecia no funcionar y comento el otro
                     * (aunque sospecho que tampoco funcionaba)
                     */
                    int idVideo = Integer.valueOf(request.getParameter("idVideo"));
                    DtValoracion dtVal = null;
                    switch (accion) {
                        case "like":
                            dtVal = new DtValoracion();
                            dtVal.setVal(TipoValoracion.LIKE);
                            dtVal.setNickname("");
                            break;
                        case "disLike":
                            dtVal = new DtValoracion();
                            dtVal.setVal(TipoValoracion.DISLIKE);
                            dtVal.setNickname("");
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
                    
                    /*
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
                    */
                }
                default:
                    break;
            }
        } catch (Exception e) {
            Funciones.showLog(e);
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
    
    
    private String htmlDeSeccionDeComentarios(ArrayList<DtComentario> comentarios, boolean  mostrarBotonResponder){
        if (comentarios == null || comentarios.isEmpty()){
            return "";
        }
        
        String ret = "";
        DtComentario c = comentarios.remove(0);
        String imgPerfil = "usuario-imagen?id=" + c.getNickname();
        String strFecha = (c.getFecha().getAnio()) + "-" + (c.getFecha().getMes()) + "-" + (c.getFecha().getDia());
        
        ret += "    <div class=\"media\">";
        ret += "        <img class=\"mr-3\" src=\"" + imgPerfil + "\" width=\"50\" height=\"50\">";
        ret += "        <div class=\"media-body\">";
        ret += "            <h5 class=\"mt-0\">";
        ret += "               " + c.getNickname();
        ret += "            </h5>";
        ret += "            " + c.getTexto() + " (" + strFecha + ")";
        ret += "            <br>";
        ret += "    </div>";
        ret += "</div>";
        
        ret += htmlDeSeccionDeComentarios(comentarios, mostrarBotonResponder);
        
        return ret;
    }
    /*
    // ESTRUCTURA DE UN COMENTARIO: 
    <div class="media">
        <img class="mr-3" src="IMAGEN DE PERFIL" width="50" height="50">
        <div class="media-body">
            <h5 class="mt-0">
                NICKNAME DEL USUARIO
            </h5>
            TEXTO DEL COMENTARIO (dd/mm/yyyy)
            <br>
            // RESPUESTAS DEL COMENTARIO
        </div>
    </div>
    */
    
}
