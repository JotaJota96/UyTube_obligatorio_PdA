package com.uytube;

import Logica.DataType.DtCanal;
import Logica.DataType.DtComentario;
import Logica.DataType.DtUsuario;
import Logica.DataType.DtVideo;
import Logica.Fabrica;
import Logica.Interfaces.IUsuario;
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
            if (sesionIniciada){
                propietarioDelVideo = usuario.getNickname().equals(sys.obtenerUsuarioActual().getNickname());
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
