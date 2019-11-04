/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import logica.controladores.DtListaDeReproduccion;
import logica.controladores.DtUsuario;
import logica.controladores.Privacidad;
import logica.controladores.TipoListaDeReproduccion;
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
public class AltaListaReproduccion extends HttpServlet {

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
            //IUsuario sys = Fabrica.getInstancia().getIUsuario();
            CUsuarioService servicio = new CUsuarioService();
            CUsuario sys = servicio.getCUsuarioPort();

            if (!sys.sesionIniciada()) {
                String msj = "No puedes acceder a esta página";
                Funciones.Funciones.showLog("Acceso denegado", msj);
                RequestDispatcher rd; //objeto para despachar
                request.setAttribute("mensajeError", msj);
                rd = request.getRequestDispatcher("/401.jsp");
                rd.forward(request, response);
                return;
            }

            boolean sesionIniciada = sys.sesionIniciada();
            ArrayList<String> cate = (ArrayList<String>) sys.listarCategorias();

            request.setAttribute("Categorias", cate);
            request.setAttribute("sesionIniciada", sesionIniciada);

            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/AltaListaReproduccion.jsp");
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
        Funciones.Funciones.showLog(request, response);
        try {
            CUsuarioService servicio = new CUsuarioService();
            CUsuario sys = servicio.getCUsuarioPort();

            if (!sys.sesionIniciada()) {
                String msj = "No puedes acceder a esta página";
                Funciones.Funciones.showLog("Acceso denegado", msj);
                RequestDispatcher rd; //objeto para despachar
                request.setAttribute("mensajeError", msj);
                rd = request.getRequestDispatcher("/401.jsp");
                rd.forward(request, response);
                return;
            }

            String pNombreLista = request.getParameter("nombreL");
            String pPrivacidad = request.getParameter("privacidad_1");
            String pCategoria = request.getParameter("categoria");

            DtUsuario usu = sys.obtenerUsuarioActual();

            Privacidad priv = Privacidad.PRIVADO;
            if (pPrivacidad != null && pPrivacidad.equals("PUBLICO")) {
                priv = Privacidad.PUBLICO;
            }

            DtListaDeReproduccion listRepo = new DtListaDeReproduccion();
            listRepo.setId(0);
            listRepo.setNombre(pNombreLista);
            listRepo.setPrivacidad(priv);
            listRepo.setTipo(TipoListaDeReproduccion.PARTICULAR);
            listRepo.setCategoria(pCategoria);
            
            sys.altaListaDeReproduccionParticular(listRepo);

            sys.seleccionarUsuario(sys.obtenerUsuarioActual().getNickname());
            ArrayList<DtListaDeReproduccion> listas = (ArrayList<DtListaDeReproduccion>)sys.listarListasDeReproduccionDeUsuario(true);

            int idNuevaLista = 0;
            for (DtListaDeReproduccion l : listas) {
                if (l.getId() > idNuevaLista) {
                    idNuevaLista = l.getId();
                }
            }

            response.sendRedirect("lista-consultar?id=" + idNuevaLista);

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
