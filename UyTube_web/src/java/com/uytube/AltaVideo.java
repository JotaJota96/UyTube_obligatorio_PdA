/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author administrador
 */
@WebServlet("/video-agregar")
public class AltaVideo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AltaVideo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaVideo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        RequestDispatcher rd; //objeto para despachar
        rd = request.getRequestDispatcher("/AltaVideo.jsp");
        rd.forward(request, response);
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
        //Se guardan los datos del usuario en la base de datos
        // Y se redigire por ahora al JSP presentacion
        
       
        String pNombre = request.getParameter("nombre");
        String pDuracion = request.getParameter("duracion");
        String pUrl = request.getParameter("url");
        String pFecha = request.getParameter("fecha");        
        String pDescripcion = request.getParameter("descripcion");
        String pCategoria = request.getParameter("categoria");
        
        System.out.println(request.getParameter("nombre: "+pNombre));
        System.out.println(request.getParameter("duracion: "+pDuracion));
        System.out.println(request.getParameter("url: "+pUrl));
        System.out.println(request.getParameter("fecha: "+pFecha));
        System.out.println(request.getParameter("descripcion: "+pDescripcion));
        System.out.println(request.getParameter("categoria: "+pCategoria));
        
        RequestDispatcher rd; //objeto para despachar
        rd = request.getRequestDispatcher("/Presentacion.jsp");
        rd.forward(request, response);
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
