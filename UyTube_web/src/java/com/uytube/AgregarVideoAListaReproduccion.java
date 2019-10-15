/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import Logica.DataType.DtUsuario;
import Logica.Fabrica;
import Logica.Interfaces.IUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author administrador
 */
public class AgregarVideoAListaReproduccion extends HttpServlet {
    // Ejemplo: localhost:8084/uytube/lista-agregar-video?idvideo=13&idlista=10

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            IUsuario sys = Fabrica.getInstancia().getIUsuario();
            String pIDVideo = request.getParameter("idvideo");
            String pIDLista = request.getParameter("idlista");
            int IDVideo = Integer.valueOf(pIDVideo);
            int IDLista = Integer.valueOf(pIDLista);

            DtUsuario usuActual = sys.obtenerUsuarioActual();
            sys.seleccionarUsuario(sys.obtenerPropietarioDeVideo(IDVideo).getNickname());
            sys.seleccionarVideo(IDVideo);
            sys.agregarVideoAListaDeReproduccion(IDLista);

            response.sendRedirect("lista-consultar?id="+IDLista);
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
