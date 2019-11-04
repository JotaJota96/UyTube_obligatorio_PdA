/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube;

import logica.controladores.DtImagenUsuario;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.controladores.CUsuario;
import logica.controladores.CUsuarioService;

/**
 *
 * @author Juan
 */
@WebServlet(name = "ImagenUsuario", urlPatterns = {"/usuario-imagen"})
public class ImagenUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Funciones.Funciones.showLog(request, response);
        try {
            CUsuarioService servicio = new CUsuarioService();
            CUsuario sys = servicio.getCUsuarioPort();
            
            String id = request.getParameter("id");
            if (id == null)  id = "";
            
            byte[] byteArr;
            
            DtImagenUsuario iu = sys.obtenerImagenDeUsuario(id);
            byteArr = iu.getImagen();
            
            
            //byte[] byteArr = ImagePersistController.pathToByteArray("C:\\cnf.jpg");
            
            response.setContentType("image/" + getExtension(iu));
            OutputStream sos = response.getOutputStream();
            sos.write(byteArr);
            sos.flush();
            sos.close();
            
        } catch (Exception e) {
            Funciones.Funciones.showLog(e);
            RequestDispatcher rd; //objeto para despachar
            request.setAttribute("mensajeError", e.getMessage());
            rd = request.getRequestDispatcher("/404.jsp");
            rd.forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
    
    //----------------------------------------
    public String getExtension(DtImagenUsuario dtiu){
        String ret = "";
        String nombreArchivo = dtiu.getNombreArchivo();
        
        // recorre desde el final hacia el principio hasta encontrar un '.'  extrayendo la extension del archivo
        for (int i = nombreArchivo.length() - 1; i >= 0; i--) {
            if (nombreArchivo.charAt(i) == '.') {
                break;
            }
            ret = nombreArchivo.charAt(i) + ret;
        }
        // si la extension obtenida es igual al nombre del archivo, entonces no se encontro ningun punto y el archivo no tienee extension
        if (ret.equals(nombreArchivo)) {
            return "";
        }
        // sino devuelve la extension obtenida
        return ret;
    }
}
