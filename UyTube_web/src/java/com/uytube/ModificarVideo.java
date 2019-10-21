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
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author administrador
 */
public class ModificarVideo extends HttpServlet {

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
            
            if (!sys.sesionIniciada()){
                String msj = "No puedes acceder a esta página";
                System.out.println("---- Exception ----");
                System.out.println(msj);
                System.out.println("-------------------");
                RequestDispatcher rd; //objeto para despachar
                request.setAttribute("mensajeError", msj);
                rd = request.getRequestDispatcher("/401.jsp");
                rd.forward(request, response);
                return;
            }
            
            int id = Integer.parseInt(request.getParameter("id"));

            boolean sesionIniciada = sys.sesionIniciada();
            ArrayList<String> cate = sys.listarCategorias();
            DtVideo video = sys.seleccionarVideo(id);

            request.setAttribute("video", video);
            request.setAttribute("Categorias", cate);
            request.setAttribute("sesionIniciada", sesionIniciada);
            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/ModificarVideo.jsp");
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
            
            if (!sys.sesionIniciada()){
                String msj = "No puedes acceder a esta página";
                System.out.println("---- Exception ----");
                System.out.println(msj);
                System.out.println("-------------------");
                RequestDispatcher rd; //objeto para despachar
                request.setAttribute("mensajeError", msj);
                rd = request.getRequestDispatcher("/401.jsp");
                rd.forward(request, response);
                return;
            }
            
            String pNombre = request.getParameter("nombre");
            String pDuracion = request.getParameter("duracion");
            String pUrl = request.getParameter("url");
            String pDescripcion = request.getParameter("descripcion");
            String pCategoria = request.getParameter("categoria");
            String pPrivacidad = request.getParameter("privacidad");
            String pFecha = request.getParameter("fecha");

            Privacidad Priv = Privacidad.PRIVADO;
            if (pPrivacidad != null && pPrivacidad.equals("PUBLICO")) {
                Priv = Privacidad.PUBLICO;
            }
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
            DtVideo vid = new DtVideo(0, pNombre, pDescripcion, duracion, data, pUrl, Priv, pCategoria, 0, 0);
            
            sys.modificarVideo(vid);
            
            
            sys.seleccionarUsuario(sys.obtenerUsuarioActual().getNickname());
            ArrayList<DtVideo> videos = sys.listarVideosDeUsuario();
            int idNuevoVideo = 0;
            for (DtVideo v : videos){
                if (v.getNombre().equals(vid.getNombre())){
                    idNuevoVideo = v.getId();
                    break;
                }
            }
            
            response.sendRedirect("video-consultar?id=" + idNuevoVideo);
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
