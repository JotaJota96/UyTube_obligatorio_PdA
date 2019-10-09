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
@WebServlet("/usuario-agregar")
public class AltaUsuario extends HttpServlet {

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
            out.println("<title>Servlet AltaUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaUsuario at " + request.getContextPath() + "</h1>");
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
        rd = request.getRequestDispatcher("/AltaUsuario.jsp");
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
        
        String pNickname = request.getParameter("nickname");
        String pNombre = request.getParameter("nombre");
        String pApellido = request.getParameter("apellido");
        String pEmail = request.getParameter("email");
        String pFechaNa = request.getParameter("fechaNa");
        String pPassword = request.getParameter("password");
        String pPrivacidad = request.getParameter("privacidad");
        String pCanal = request.getParameter("canal");
        String pDescripcion = request.getParameter("descripcion");
        System.out.println(request.getParameter("nickname: "+pNickname));
        System.out.println(request.getParameter("nombre: "+pNombre));
        System.out.println(request.getParameter("apellido: "+pApellido));
        System.out.println(request.getParameter("email: "+pEmail));
        System.out.println(request.getParameter("fecha: "+pFechaNa));
        System.out.println(request.getParameter("password: "+pPassword));
        System.out.println(request.getParameter("privacidad: "+pPrivacidad));
        System.out.println(request.getParameter("canal: "+pCanal));
        System.out.println(request.getParameter("descripcion: "+pDescripcion));
        
        RequestDispatcher rd; //objeto para despachar
        rd = request.getRequestDispatcher("/Presentacion.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
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
