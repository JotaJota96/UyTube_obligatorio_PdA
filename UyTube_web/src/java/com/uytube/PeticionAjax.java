/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import Logica.Fabrica;
import Logica.Interfaces.IUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author administrador
 */
public class PeticionAjax extends HttpServlet {

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
            /*
         Aca debe recibir un parametor de nombre accion el cual define cual es la funcion
         que se debe ejecutar
             */
            IUsuario sys = Fabrica.getInstancia().getIUsuario();
            
            // datos recibidos
            String accion = request.getParameter("accion"); // obtiene lo enviado por AJAX
            String dato = request.getParameter("dato"); // obtiene lo enviado por AJAX
            
            System.out.println("-- Peticion AJAX --");
            System.out.println("accion: " + accion);
            System.out.println("dato: " + dato);
            
            // prepara respuesta
            response.setContentType("text/plain");  //Set content type of the response so that jQuery knows what it can expect.
            response.setCharacterEncoding("UTF-8"); //You want world domination, huh?
            String respuesta = "";
            
            
            switch (accion){
                case "validarNickname":
                    if (sys.existeNickname(dato)){
                        respuesta = "Este nickname no está disponible";
                    }
                    break;
                case "validarEmail":
                    if (sys.existeEmail(dato)){
                        respuesta = "Este email no está disponible";
                    }
                    break;
            }
            System.out.println("Respuesta: " + respuesta);
            response.getWriter().write(respuesta);
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
