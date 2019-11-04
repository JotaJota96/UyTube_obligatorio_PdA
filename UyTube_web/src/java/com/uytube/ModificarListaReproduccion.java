/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtUsuario;
import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoListaDeReproduccion;
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
public class ModificarListaReproduccion extends HttpServlet {

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
            IUsuario sys = Fabrica.getInstancia().getIUsuario();
            
            if (!sys.sesionIniciada()){
                String msj = "No puedes acceder a esta página";
                Funciones.Funciones.showLog("Acceso denegado", msj);
                RequestDispatcher rd; //objeto para despachar
                request.setAttribute("mensajeError", msj);
                rd = request.getRequestDispatcher("/401.jsp");
                rd.forward(request, response);
                return;
            }
            
            boolean sesionIniciada = sys.sesionIniciada();
            ArrayList<String> cate = sys.listarCategorias();
            String usuario = request.getParameter("idUsu");
            String lista = request.getParameter("idList");
            
            sys.seleccionarUsuario(usuario);
            int idLista = Integer.parseInt(lista);
            
            DtListaDeReproduccion listas = sys.seleccionarListaDeReproduccion(idLista);
            
            request.setAttribute("Categorias", cate);
            request.setAttribute("sesionIniciada", sesionIniciada);
            request.setAttribute("listas", listas);
            
            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/ModificarListaReproduccion.jsp");
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
            IUsuario sys = Fabrica.getInstancia().getIUsuario();
            
            if (!sys.sesionIniciada()){
                String msj = "No puedes acceder a esta página";
                Funciones.Funciones.showLog("Acceso denegado", msj);
                RequestDispatcher rd; //objeto para despachar
                request.setAttribute("mensajeError", msj);
                rd = request.getRequestDispatcher("/401.jsp");
                rd.forward(request, response);
                return;
            }
            
            String pPrivacidad = request.getParameter("privacidad");
            String pCategoria = request.getParameter("categoria");
            String pNombre = request.getParameter("nombre");
            
            DtUsuario usu = sys.obtenerUsuarioActual();
            
            Privacidad priv = Privacidad.PRIVADO;
            if (pPrivacidad != null && pPrivacidad.equals("PUBLICO")) {
                priv = Privacidad.PUBLICO;
            }
            
            DtListaDeReproduccion listRepo = new DtListaDeReproduccion(0, pNombre, priv, TipoListaDeReproduccion.PARTICULAR, pCategoria);
            sys.modificarListaDeReproduccion(listRepo);
            
            sys.seleccionarUsuario(sys.obtenerUsuarioActual().getNickname());
            ArrayList<DtListaDeReproduccion> listas = sys.listarListasDeReproduccionDeUsuario(true);
            
            int idNuevaLista = 0;
            for (DtListaDeReproduccion l : listas){
                if (l.getNombre().equals(listRepo.getNombre())){
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
