<%-- 
    Document   : prueba
    Created on : 08/10/2019, 06:25:09 PM
    Author     : administrador
--%>

<%@page import="Logica.Fabrica"%>
<%@page import="Logica.DataType.DtUsuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.Interfaces.IAdmin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1>Usuarios de UyTube!</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Nickname</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>e-Mail</th>
                </tr>
            </thead>
            <%
                ArrayList<DtUsuario> usuarios = Fabrica.getInstancia().getIAdmin().listarUsuarios() ;
                for (DtUsuario u : usuarios) {
            %>
            <tbody>
                <tr>
                    <td><%= u.getNickname()%></td>
                    <td><%= u.getNombre()%></td>
                    <td><%= u.getApellido()%></td>
                    <td><%= u.getCorreo()%></td>
                </tr>
            </tbody>
            <%
                }
            %>
        </table>
    </body>
</html>
