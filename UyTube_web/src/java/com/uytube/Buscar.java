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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.controladores.CUsuario;
import logica.controladores.CUsuarioService;

/**
 *
 * @author administrador
 */
public class Buscar extends HttpServlet {

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
            //-----------------------------------------------------
            String Categoria = request.getParameter("categoria");
            String Texto = request.getParameter("texto");
            String Filtro = request.getParameter("filtro");
            String Orden = request.getParameter("orden");
            //------------------------------------------------------
            ArrayList<Object> Ret = null;
            
            if (Categoria == null || Categoria.equalsIgnoreCase("")) {
                Filtrado Fil = Filtrado.TODO;
                Ordenacion ord = Ordenacion.FECHA_DESCENDENTE;

                if (Filtro != null && Filtro.equalsIgnoreCase("CANALES")) {
                    Fil = Filtrado.CANALES;
                }
                if (Filtro != null && (Filtro.equalsIgnoreCase("LISTAS DE REPRODUCCION") || Filtro.equalsIgnoreCase("LISTAS_DE_REPRODUCCION") || Filtro.equalsIgnoreCase("LISTAS DE REPRODUCCIóN") || Filtro.equalsIgnoreCase("LISTAS_DE_REPRODUCCIÓN"))) {
                    Fil = Filtrado.LISTAS_DE_REPRODUCCION;
                }
                if (Filtro != null && Filtro.equalsIgnoreCase("VIDEOS")) {
                    Fil = Filtrado.VIDEOS;
                }
                if (Orden != null && (Orden.equalsIgnoreCase("ALFABÉTICO") || Orden.equalsIgnoreCase("ALFABETICO"))) {
                    ord = Ordenacion.ALFABETICA_ASCENDENTE;
                }

                String comilla = "" + (char) 34;
                String vacio = "";

                if (Texto == null){
                    Texto = "";
                }else{
                    Texto = Texto.replaceAll(comilla, vacio);
                }
                
                Ret = (ArrayList<Object>) sys.buscar(Texto, Fil, ord);
            } else {
                Categoria = Categoria.toUpperCase();
                Ret = (ArrayList<Object>) sys.buscarPorCategoria(Categoria);
            }
            Funciones.Funciones.showLog("Cantidad de resultados a devolver: ", String.valueOf(Ret.size()));

            request.setAttribute("Lista", Ret);

            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/Buscar.jsp");
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
