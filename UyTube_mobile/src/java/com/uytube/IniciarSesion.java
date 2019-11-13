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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.controladores.CUsuario;
import logica.controladores.CUsuarioService;

/**
 *
 * @author administrador
 */
@WebServlet("/inicio-sescion")
public class IniciarSesion extends HttpServlet {

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
            
            if (sys.sesionIniciada()){
                response.sendRedirect("presentacion");
                return;
            }
            
            DtUsuario usuario = (DtUsuario) request.getSession().getAttribute("usuario");
            boolean sesReq = usuario != null;
            boolean sesSys = sys.sesionIniciada();

            String tit = "Intento de carga de pagina /inicio-sesion";
            String msj = "Sesion en req: " + sesReq;
            msj += "\nSesion en sys: " + sesSys;
            Funciones.Funciones.showLog(tit, msj);

            /**
             * Descripción del siguiente IF sesReq sesSys accion a realizar 0 0
             * Redirigir a iniciar-sesion 0 1 Cerrar la sesion en sys y
             * redirigir a iniciar-sesion 1 0 Cerrar la sesion en req y
             * redirigir a iniciar-sesion 1 1 Redirigir a la pagina de inicio
             */
            if (!sesReq && !sesSys) {
                // no se hace nada
                // Abajo se envia a iniciar-sesion
            } else if (!sesReq && sesSys) {
                sys.cerrarSesion();
                // Abajo se envia a iniciar-sesion
            } else if (sesReq && !sesSys) {
                request.getSession().invalidate();
                // Abajo se envia a iniciar-sesion
            } else if (sesReq && sesSys) {
                response.sendRedirect("");
                return;
            }

            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/IniciarSesion.jsp");
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

            String paramUser = request.getParameter("user");
            String paramPassword = request.getParameter("password");
            RequestDispatcher rd; //objeto para despachar
            
            HttpSession sesion = request.getSession();
            //sesion.invalidate();
            
            if (sys.iniciarSesionUsuario(paramUser, paramPassword) && sesion.getAttribute("usuario") == null) {
                DtUsuario usuario = sys.obtenerUsuarioActual();
                //si coincide usuario y password y además no hay sesión iniciada
                sesion.setMaxInactiveInterval(14400);
                sesion.setAttribute("usuario", usuario);
                //sesion.setAttribute("sys", sys);
                //redirijo a página con información de login exitoso
                rd = request.getRequestDispatcher("/");
            } else {
                //lógica para login inválido
                request.setAttribute("mostrarMsjError", true);
                rd = request.getRequestDispatcher("/IniciarSesion.jsp");
            }
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
