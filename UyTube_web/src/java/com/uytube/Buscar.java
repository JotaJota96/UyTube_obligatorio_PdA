/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import Logica.Enumerados.Filtrado;
import Logica.Enumerados.Ordenacion;
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
        try {
            IUsuario sys = Fabrica.getInstancia().getIUsuario();
            //-----------------------------------------------------
            String Categoria = request.getParameter("categoria");
            String Texto = request.getParameter("texto");
            String Filtro = request.getParameter("filtro");
            String Orden = request.getParameter("orden");
            //------------------------------------------------------
            ArrayList<Object> Ret = null;

            if (Categoria == null || Categoria.equals("")) {
                Filtrado Fil = Filtrado.TODO;
                Ordenacion ord = Ordenacion.FECHA_DESCENDENTE;

                if (Filtro != null && Filtro.equals("CANALES")) {
                    Fil = Filtrado.CANALES;
                }
                if (Filtro != null && Filtro.equals("LISTAS_DE_REPRODUCCION")) {
                    Fil = Filtrado.LISTAS_DE_REPRODUCCION;
                }
                if (Filtro != null && Filtro.equals("VIDEOS")) {
                    Fil = Filtrado.VIDEOS;
                }
                if (Orden != null && Orden.equals("ALFABETICO")) {
                    ord = Ordenacion.ALFABETICA_ASCENDENTE;
                }
                
                String comilla = "" + (char) 34;
                String vacio = "";
                if (Texto == null){
                    Texto = "";
                }else{
                    Texto = Texto.replaceAll(comilla, vacio);
                }
                
                if (Texto.equals("")){
                    Texto = " ";
                }
                System.out.println("Todo bien hasta aqui");
                Ret = sys.buscar(Texto, Fil, ord);
                
            } else {
                Ret = sys.buscar(Categoria);
            }

            request.setAttribute("Lista", Ret);

            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/Buscar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/");
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
