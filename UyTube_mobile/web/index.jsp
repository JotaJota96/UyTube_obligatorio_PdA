<%-- 
    Document   : Presentacion
    Created on : 02/10/2019, 08:56:04 AM
    Author     : administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <%@page import="logica.controladores.CUsuario" %>
    <%@page import="logica.controladores.CUsuarioService" %>
    <%@page import="java.util.*" %>
    <body>
         <% 
            CUsuarioService servicio = new CUsuarioService();
            CUsuario sys = servicio.getCUsuarioPort();
           
            if (sys.sesionIniciada()){
                response.sendRedirect("presentacion");
                return;
            }else{
                response.sendRedirect("inicio-sesion"); 
            }
         %>
    </body>
</html>