/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import logica.controladores.DtCanal;
import logica.controladores.DtListaDeReproduccion;
import logica.controladores.DtUsuario;
import logica.controladores.DtVideo;
import java.io.IOException;
import java.util.ArrayList;
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
public class ConsultaUsuario extends HttpServlet {

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

            String nick = request.getParameter("id");
            String ps = request.getParameter("ps");
            if (ps == null || ps.equals("")) {
                ps = "VIDEOS";
            }

            DtUsuario usuario = sys.seleccionarUsuario(nick);
            DtCanal canal = sys.obtenerCanalDeUsuario();
            ArrayList<DtUsuario> seguidos = (ArrayList<DtUsuario>)sys.listarUsuarioSeguidos();
            ArrayList<DtUsuario> seguidores = (ArrayList<DtUsuario>)sys.listarUsuarioSeguidores();
            ArrayList<DtVideo> videos = (ArrayList<DtVideo>)sys.listarVideosDeUsuario();
            ArrayList<DtListaDeReproduccion> listasRep = (ArrayList<DtListaDeReproduccion>)sys.listarListasDeReproduccionDeUsuario(true);
            boolean sesionIniciada = sys.sesionIniciada();

            boolean usuarioPropietario = false;
            if (sesionIniciada) {
                usuarioPropietario = sys.obtenerUsuarioActual().getNickname().equals(nick);
            }

            request.setAttribute("ps", ps);
            request.setAttribute("usuario", usuario);
            request.setAttribute("canal", canal);
            request.setAttribute("seguidos", seguidos);
            request.setAttribute("seguidores", seguidores);
            request.setAttribute("videos", videos);
            request.setAttribute("listasRep", listasRep);
            request.setAttribute("propietario", usuarioPropietario);
            request.setAttribute("sesionIniciada", sesionIniciada);

            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/ConsultaUsuario.jsp");
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
