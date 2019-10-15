/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import Logica.DataType.DtVideo;
import Logica.Enumerados.Privacidad;
import Logica.Fabrica;
import Logica.Interfaces.IUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author administrador
 */
public class AltaVideo extends HttpServlet {

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
            boolean sesionIniciada = sys.sesionIniciada();
            ArrayList<String> cate = sys.listarCategorias();

            request.setAttribute("Categorias", cate);
            request.setAttribute("sesionIniciada", sesionIniciada);

            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/AltaVideo.jsp");
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
            String pNombre = request.getParameter("nombre");
            String pDuracion = request.getParameter("duracion");
            String pUrl = request.getParameter("url");
            String pFecha = request.getParameter("fecha");
            String pDescripcion = request.getParameter("descripcion");
            String pCategoria = request.getParameter("categoria");
            
            //============ Casteo de string a date =================================
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
            Date fechaDate = null;
            try {
                fechaDate = formato.parse(pFecha);
            } catch (ParseException ex) {
                RequestDispatcher rd; //objeto para despachar
                rd = request.getRequestDispatcher("/");
                rd.forward(request, response);
            }
            java.sql.Date data = new java.sql.Date(fechaDate.getTime());
            //======================================================================
            
            //============= Casteo de string a Time ================================
            Time duracion = java.sql.Time.valueOf(pDuracion);
            //======================================================================
            DtVideo vid = new DtVideo(0, pNombre, pDescripcion, duracion, data, pUrl,Privacidad.PRIVADO, pCategoria, 0, 0);

            sys.altaVideo(vid);
            
            sys.seleccionarUsuario(sys.obtenerUsuarioActual().getNickname());
            ArrayList<DtVideo> videos = sys.listarVideosDeUsuario();
            
            int idNuevoVideo = 0;
            for (DtVideo v : videos){
                if (v.getId() > idNuevoVideo){
                    idNuevoVideo = v.getId();
                }
            }
            
            response.sendRedirect("/uytube/video-consultar?id=" + idNuevoVideo);
            
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

}
