/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import logica.controladores.DtListaDeReproduccion;
import logica.controladores.DtVideo;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
public class ConsultaListaReproducion extends HttpServlet {

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
            String lista = request.getParameter("id");
            int idLista = Integer.parseInt(lista);
            String usuario = sys.obtenerPropietarioDeListaDeReproduccion(idLista).getNickname();
            
            sys.seleccionarUsuario(usuario);
            
            DtListaDeReproduccion listas = sys.seleccionarListaDeReproduccion(idLista);
            ArrayList <DtVideo> videos = (ArrayList <DtVideo>) sys.listarVideosDeListaDeReproduccion();
            
            boolean usuarioPropietario = false;
            if (sesionIniciada) {
                usuarioPropietario = sys.obtenerUsuarioActual().getNickname().equals(usuario);
            }
            
            request.setAttribute("usuario", usuario);
            request.setAttribute("propietario", usuarioPropietario);
            request.setAttribute("videos", videos);
            request.setAttribute("sesionIniciada", sesionIniciada);
            request.setAttribute("listas", listas);
            
            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/ConsultarListaReproduccion.jsp");
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
