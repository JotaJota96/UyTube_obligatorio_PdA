/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.controladores.CUsuario;
import logica.controladores.CUsuarioService;

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
            CUsuarioService servicio = new CUsuarioService();
            CUsuario sys = servicio.getCUsuarioPort();
            
            // datos recibidos
            String accion = request.getParameter("accion"); // obtiene lo enviado por AJAX
            String dato = request.getParameter("dato"); // obtiene lo enviado por AJAX
            
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
                case "validarNombreVideo":
                    int idVideo = 0;
                    if (request.getParameter("idVideo") != null){
                        idVideo = Integer.valueOf(request.getParameter("idVideo"));
                    }
                    
                    if (dato == null || dato.equals("")){
                        break;
                    }
                    if ( ! sys.validarNuevoVideo(dato, idVideo)){
                        respuesta = "El canal ya posee un video con ese nombre";
                    }
                    break;
                case "validarNombreLista":
                    int idLista = 0;
                    if (request.getParameter("idLista") != null){
                        idLista = Integer.valueOf(request.getParameter("idLista"));
                    }
                    
                    if ( ! sys.validarNuevaListaParticular(dato, idLista)){
                        respuesta = "El canal ya posee una lista con ese nombre";
                    }
                    break;
            }
            Funciones.Funciones.showLog(request, response);
            Funciones.Funciones.showLog("Respuesta", respuesta);
            response.getWriter().write(respuesta);
        } catch (Exception e) {
            Funciones.Funciones.showLog(e);
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
