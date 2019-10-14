/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtVideo;
import Logica.Fabrica;
import Logica.Interfaces.IUsuario;
import java.io.IOException;
import java.io.PrintWriter;
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
        try {
            IUsuario sys = Fabrica.getInstancia().getIUsuario();
            boolean sesionIniciada = sys.sesionIniciada();
            String usuario = request.getParameter("idUsu");
            String lista = request.getParameter("idList");
            
            sys.seleccionarUsuario(usuario);
            int idLista = Integer.parseInt(lista);
            sys.seleccionarListaDeReproduccion(idLista);
            
            DtListaDeReproduccion listas = sys.seleccionarListaDeReproduccion(idLista);
            
            ArrayList <DtVideo> videos = sys.listarVideosDeListaDeReproduccion();
            
            
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
