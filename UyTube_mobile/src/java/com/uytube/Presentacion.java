/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import logica.controladores.Filtrado;
import logica.controladores.Ordenacion;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.controladores.CUsuario;
import logica.controladores.CUsuarioService;
import logica.controladores.DtUsuario;

/**
 *
 * @author administrador
 */
@WebServlet(name = "Presentacion", urlPatterns = {"/"})
public class Presentacion extends HttpServlet {

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
        Funciones.Funciones.showLog(request, response);
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
            
            boolean sesionIniciada = sys.sesionIniciada();
            ArrayList<Object> videos = (ArrayList<Object>) sys.buscar("", Filtrado.VIDEOS, Ordenacion.FECHA_DESCENDENTE);

            request.setAttribute("sesionIniciada", sesionIniciada);
            request.setAttribute("videos", videos);

            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/Presentacion.jsp");
            rd.forward(request, response);
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
