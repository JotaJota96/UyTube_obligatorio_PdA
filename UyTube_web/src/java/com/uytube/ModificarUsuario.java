/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import logica.controladores.DtCanal;
import logica.controladores.DtImagenUsuario;
import logica.controladores.DtUsuario;
import logica.controladores.Privacidad;
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
import logica.controladores.CUsuario;
import logica.controladores.CUsuarioService;
import logica.controladores.Fecha;

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
            
            if (!sys.sesionIniciada()){
                String msj = "No puedes acceder a esta página";
                Funciones.Funciones.showLog("Acceso denegado", msj);
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
            
            DtCanal CanUsu = new DtCanal();
            CanUsu.setId(0);
            CanUsu.setNombre(pCanal);
            CanUsu.setDescripcion(pDescripcion);
            CanUsu.setPrivacidad(Priv);
            
            DtUsuario Usu = new DtUsuario();
            Fecha f = new Fecha();
            f.setAnio(fecha_Nac.getYear()-1900);
            f.setDia(fecha_Nac.getDate());
            f.setMes(fecha_Nac.getMonth());
            
            
            Usu.setNickname(pNickname);
            Usu.setContrasenia(pPassword);
            Usu.setNombre(pNombre);
            Usu.setApellido(pApellido);
            Usu.setCorreo(pEmail);
            Usu.setFechaNacimiento(f);
            Usu.setImagen(pImaguen);
            Usu.setCantSeguidores(0);

            sys.modificarUsuarioYCanal(Usu, CanUsu);

            Part partImagen = request.getPart("imagen");
            String nombreArchivo = Paths.get(partImagen.getSubmittedFileName()).getFileName().toString();
            InputStream archivoContenido = partImagen.getInputStream();
            if (archivoContenido.available() > 0) {
                byte[] byteArr = new byte[archivoContenido.available()];
                archivoContenido.read(byteArr);
                DtImagenUsuario dtiu = new DtImagenUsuario();
                dtiu.setNickname(Usu.getNickname());
                dtiu.setImagen(byteArr);
                dtiu.setNombreArchivo(nombreArchivo);
                sys.altaImagenDeUsuario(dtiu);
            }
            
            response.sendRedirect("usuario-consultar?id=" + Usu.getNickname());

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
