/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import logica.controladores.DtUsuario;
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
public class AgregarVideoAListaReproduccion extends HttpServlet {
    // Ejemplo: localhost:8084/uytube/lista-agregar-video?idvideo=13&idlista=10

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Funciones.Funciones.showLog(request, response);
        try {
            CUsuarioService servicio = new CUsuarioService();
            CUsuario sys = servicio.getCUsuarioPort();
            
            if (!sys.sesionIniciada()){
                String msj = "No puedes acceder a esta página";
                Funciones.Funciones.showLog("Acceso denegado", msj);
                RequestDispatcher rd; //objeto para despachar
                request.setAttribute("mensajeError", msj);
                rd = request.getRequestDispatcher("/401.jsp");
                rd.forward(request, response);
                return;
            }
            
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
