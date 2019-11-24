/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
public class CerrarSesion extends HttpServlet {

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

            // cierra la sesion HTTP (si es que hay una iniciada)
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.setAttribute("usuario", null);
                session.invalidate();
            }
            // Cierra la sesion en el sistema (si es que hay una iniciada)
            if (sys.sesionIniciada()) {
                sys.cerrarSesion();
            }

            //obtiene array con todas las Cookies del usuario
            Cookie[] misCookies = request.getCookies();
            //Busca las cookies para eliminarlas
            if (misCookies != null) {
                // Elimina una por una todas las cookies
                response.setContentType("text/html");
                for (Cookie miCooki : misCookies) {
                    System.out.println("Borrando cookie nombre: " + miCooki.getName() + ", valor: " + miCooki.getValue());
                    miCooki.setValue("");
                    miCooki.setMaxAge(0);
                    miCooki.setPath("/");
                    response.addCookie(miCooki);

                }
//                response.flushBuffer();
//                response.reset();
            }

            response.sendRedirect("inicio-sesion");
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
