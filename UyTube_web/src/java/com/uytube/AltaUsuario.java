/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import Logica.DataType.DtCanal;
import Logica.DataType.DtImagenUsuario;
import Logica.DataType.DtUsuario;
import Logica.Enumerados.Filtrado;
import Logica.Enumerados.Privacidad;
import Logica.Fabrica;
import Logica.Interfaces.IUsuario;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Formatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class AltaUsuario extends HttpServlet {

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
            RequestDispatcher rd; //objeto para despachar
            rd = request.getRequestDispatcher("/AltaUsuario.jsp");
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
            String pNickname = request.getParameter("nickname");
            String pNombre = request.getParameter("nombre");
            String pApellido = request.getParameter("apellido");
            String pEmail = request.getParameter("email");
            String pFechaNa = request.getParameter("fechaNa");
            String pPassword = request.getParameter("password");
            String pImaguen = request.getParameter("imagen");
            String pPrivacidad = request.getParameter("privacidad");
            String pCanal = request.getParameter("canal");
            String pDescripcion = request.getParameter("descripcion");
            
            IUsuario sys = Fabrica.getInstancia().getIUsuario();

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
            Date fechaDate = null;

            try {
                fechaDate = formato.parse(pFechaNa);
            } catch (ParseException ex) {
                RequestDispatcher rd; //objeto para despachar
                rd = request.getRequestDispatcher("/");
                rd.forward(request, response);
            }
            java.sql.Date data = new java.sql.Date(fechaDate.getTime());

            DtUsuario Usu = new DtUsuario(pNickname, pPassword, pNombre, pApellido, pEmail, data, pImaguen, 0);

            Privacidad Priv = Privacidad.PRIVADO;
            if (pPrivacidad != null && pPrivacidad.equals("PUBLICO")) {
                Priv = Privacidad.PUBLICO;
            }

            DtCanal CanUsu = new DtCanal(0, pCanal, pDescripcion, Priv);
            sys.altaUsuarioCanal(Usu, CanUsu);
            DtUsuario nuevoUsuario = sys.obtenerUsuarioActual();
            
            Part partImagen = request.getPart("imagen");
            String nombreArchivo = Paths.get(partImagen.getSubmittedFileName()).getFileName().toString();
            InputStream archivoContenido = partImagen.getInputStream();
            if (archivoContenido.available() > 0) {
                byte[] byteArr = new byte[archivoContenido.available()];
                archivoContenido.read(byteArr);
                DtImagenUsuario dtiu = new DtImagenUsuario(nuevoUsuario.getNickname(), byteArr, nombreArchivo);
                Fabrica.getInstancia().getIPersistenciaDeImagenes().create(dtiu);
            }
            
            request.getSession().setMaxInactiveInterval(14400);
            request.getSession().setAttribute("usuario", nuevoUsuario);
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

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
