/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import Logica.DataType.DtCanal;
import Logica.DataType.DtImagenUsuario;
import Logica.DataType.DtUsuario;
import Logica.Enumerados.Privacidad;
import Logica.Fabrica;
import Logica.Interfaces.IUsuario;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author administrador
 */
@MultipartConfig
public class ModificarUsuario extends HttpServlet {

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
            
            if (!sys.sesionIniciada()){
                String msj = "No puedes acceder a esta página";
                System.out.println("---- Exception ----");
                System.out.println(msj);
                System.out.println("-------------------");
                RequestDispatcher rd; //objeto para despachar
                request.setAttribute("mensajeError", msj);
                rd = request.getRequestDispatcher("/401.jsp");
                rd.forward(request, response);
                return;
            }
            
            String nick = request.getParameter("id");

            DtUsuario usuario = sys.seleccionarUsuario(nick);
            DtCanal canal = sys.obtenerCanalDeUsuario();
            boolean sesionIniciada = sys.sesionIniciada();

            boolean usuarioPropietario = false;
            if (sesionIniciada) {
                usuarioPropietario = sys.obtenerUsuarioActual().getNickname().equals(nick);
            }

            request.setAttribute("sesionIniciada", sesionIniciada);
            request.setAttribute("usuario", usuario);
            request.setAttribute("canal", canal);

            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/ModificarUsuario.jsp");
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
        try {
            IUsuario sys = Fabrica.getInstancia().getIUsuario();
            
            if (!sys.sesionIniciada()){
                String msj = "No puedes acceder a esta página";
                System.out.println("---- Exception ----");
                System.out.println(msj);
                System.out.println("-------------------");
                RequestDispatcher rd; //objeto para despachar
                request.setAttribute("mensajeError", msj);
                rd = request.getRequestDispatcher("/401.jsp");
                rd.forward(request, response);
                return;
            }
            
            String pNickname = request.getParameter("nickname");
            String pNombre = request.getParameter("nombre");
            String pApellido = request.getParameter("apellido");
            String pEmail = request.getParameter("email");
            String pFechaNa = request.getParameter("fechaNa");
            String pPassword = request.getParameter("password");
            String pPrivacidad = request.getParameter("privacidad");
            String pCanal = request.getParameter("canal");
            String pDescripcion = request.getParameter("descripcion");
            String pImaguen = request.getParameter("imagen");

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
            Date fechaDate = null;
            try {
                fechaDate = formato.parse(pFechaNa);
            } catch (ParseException ex) {
                RequestDispatcher rd; //objeto para despachar
                rd = request.getRequestDispatcher("/");
                rd.forward(request, response);
            }
            java.sql.Date fecha_Nac = new java.sql.Date(fechaDate.getTime());

            Privacidad Priv = Privacidad.PRIVADO;
            if (pPrivacidad != null && pPrivacidad.equals("PUBLICO")) {
                Priv = Privacidad.PUBLICO;
            }

            System.out.println(pNickname);

            DtCanal CanUsu = new DtCanal(0, pCanal, pDescripcion, Priv);
            DtUsuario Usu = new DtUsuario(pNickname, pPassword, pNombre, pApellido, pEmail, fecha_Nac, pImaguen, 0);

            sys.modificarUsuarioYCanal(Usu, CanUsu);

            Part partImagen = request.getPart("imagen");
            String nombreArchivo = Paths.get(partImagen.getSubmittedFileName()).getFileName().toString();
            InputStream archivoContenido = partImagen.getInputStream();
            if (archivoContenido.available() > 0) {
                byte[] byteArr = new byte[archivoContenido.available()];
                archivoContenido.read(byteArr);
                DtImagenUsuario dtiu = new DtImagenUsuario(Usu.getNickname(), byteArr, nombreArchivo);
                Fabrica.getInstancia().getIPersistenciaDeImagenes().edit(dtiu);
            }
            
            response.sendRedirect("/uytube/usuario-consultar?id=" + Usu.getNickname());

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
