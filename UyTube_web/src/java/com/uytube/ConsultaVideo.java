package com.uytube;

import Logica.DataType.DtCanal;
import Logica.DataType.DtComentario;
import Logica.DataType.DtUsuario;
import Logica.DataType.DtValoracion;
import Logica.DataType.DtVideo;
import Logica.Enumerados.TipoValoracion;
import Logica.Fabrica;
import Logica.Interfaces.IUsuario;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConsultaVideo extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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

            boolean sesionIniciada = sys.sesionIniciada();
            boolean propietarioDelVideo = false;
            if (sesionIniciada) {
                propietarioDelVideo = usuario.getNickname().equals(sys.obtenerUsuarioActual);
            }

            request.setAttribute("usuario", usuario);
            request.setAttribute("canal", canal);
            request.setAttribute("video", video);
            request.setAttribute("comentarios", comentarios);
            request.setAttribute("sesionIniciada", sesionIniciada);
            request.setAttribute("propietarioDelVideo", propietarioDelVideo);

            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/ConsultaVideo.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/");
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
            String accion = request.getParameter("accion");
            String respuesta;
            response.setContentType("text/html");  // Tipo de dato de la respuesta
            response.setCharacterEncoding("UTF-8"); // Tipo de Codificación de caracteres

            if (accion.equals("like")) {
                //agregar codigo para dar me gusta al video
                //en la respuesta mandar la cantidad de me gusta del video

                String idVideo = request.getParameter("idVideo");
                System.out.println("accion: " + accion + ", idVideo" + idVideo);
                respuesta = "200"; //ejemplo
                response.getWriter().write(respuesta);

            } else if (accion.equals("disLike")) {
                //agregar codigo para dar no me gusta al video
                //en la respuesta mandar la cantidad de no me gusta del video

                String idVideo = request.getParameter("idVideo");
                System.out.println("accion: " + accion + ", idVideo" + idVideo);
                respuesta = "10"; //ejemplo                
                response.getWriter().write(respuesta);
            } else if (accion.equals("comentarVideo")) {
                String texto = request.getParameter("texto");
                String idVideo = request.getParameter("idVideo");
                //agregar codigo para comentar un video
                System.out.println("accion: " + accion + ", idVideo: " + idVideo + ", texto: " + texto);
                respuesta = ""
                        + "<div class=\"media\">\n"
                        + "                                        <img class=\"mr-3\" src=\"imagenes/ukp.png\" width=\"50\" height=\"50\">\n"
                        + "                                        <div class=\"media-body\">\n"
                        + "                                            <h5 class=\"mt-0\">Media heading</h5>\n"
                        + "                                            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.\n"
                        + "                                            <br>\n"
                        + "                                            <button type=\"button\" onmouseover=\"idComentario=this.getAttribute('value');\" value=\"1\" class=\"btn btn-primary responder\" data-toggle=\"modal\" data-target=\"#exampleModal\" data-whatever=\"@mdo\">Responder</button>\n"
                        + "                                        </div>\n"
                        + "                                    </div>";
                response.getWriter().write(respuesta);
            } else if (accion.equals("responderComentario")) {
                String texto = request.getParameter("texto");
                String idVideo = request.getParameter("idVideo");
                String idComentario = request.getParameter("idComentario");
                //agregar codigo para comentar un video
                System.out.println("accion: " + accion + ", idVideo" + idVideo + ", texto: " + texto + ", idComentario: " + idComentario);
                respuesta = ""
                        + "<div class=\"media\">\n"
                        + "                                        <img class=\"mr-3\" src=\"imagenes/ukp.png\" width=\"50\" height=\"50\">\n"
                        + "                                        <div class=\"media-body\">\n"
                        + "                                            <h5 class=\"mt-0\">Media heading</h5>\n"
                        + "                                            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.\n"
                        + "                                            <br>\n"
                        + "                                            <button type=\"button\" onmouseover=\"idComentario=this.getAttribute('value');\" value=\"1\" class=\"btn btn-primary responder\" data-toggle=\"modal\" data-target=\"#exampleModal\" data-whatever=\"@mdo\">Responder</button>\n"
                        + "                                        </div>\n"
                        + "                                    </div>";
                response.getWriter().write(respuesta);
            } else if (accion.equals("agregarALista")) {

                //agregar codigo para comentar un video
                System.out.println("accion " + accion);

                respuesta = "El video ha sido agregado a su lista de reproducción";
                response.getWriter().write(respuesta);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/");
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

}
