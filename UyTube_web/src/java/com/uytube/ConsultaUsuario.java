/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import Logica.DataType.DtCanal;
import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtUsuario;
import Logica.DataType.DtVideo;
import Logica.Fabrica;
import Logica.Interfaces.IUsuario;
import java.io.IOException;
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
        try {
            IUsuario sys = Fabrica.getInstancia().getIUsuario();
            String nick = request.getParameter("id");
            String ps = request.getParameter("ps");
            if (ps == null || ps.equals("")) {
                ps = "VIDEOS";
            }

            DtUsuario usuario = sys.seleccionarUsuario(nick);
            DtCanal canal = sys.obtenerCanalDeUsuario();
            ArrayList<DtUsuario> seguidos = sys.listarUsuarioSeguidos();
            ArrayList<DtUsuario> seguidores = sys.listarUsuarioSeguidores();
            ArrayList<DtVideo> videos = sys.listarVideosDeUsuario();
            ArrayList<DtListaDeReproduccion> listasRep = sys.listarListasDeReproduccionDeUsuario(false);
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
