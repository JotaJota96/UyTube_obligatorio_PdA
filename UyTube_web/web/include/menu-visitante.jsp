<%@page import="logica.controladores.CUsuario"%>
<%@page import="logica.controladores.CUsuarioService"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Menú para el Visitante
-->
<aside class="menu" >							
    <ul>
        <li class="titulo"> Inicio </li>
        <li><a href="/uytube/presentacion"><span class="icon-home1"></span> Inicio</a></li>
        <li class="titulo">Cuenta</li>
        <li><a href="/uytube/usuario-agregar"><span class="icon-add-user"></span> Crear cuenta</a></li>
        <li><a href="/uytube/inicio-sesion"><span class="icon-login"></span> Iniciar sesion</a></li>
        <li class="titulo">Buscar</li>
        <li><a href="/uytube/buscar"><span class="icon-magnifying-glass"></span> Buscar</a></li>
        <li class="titulo">Categoria</li>
        <%
            CUsuarioService servicio = new CUsuarioService();
            CUsuario sys = servicio.getCUsuarioPort();

            ArrayList<String> cate = (ArrayList<String>) sys.listarCategorias();
            for (String elem : cate) {
                if(!elem.equals("UNDEFINED")){
        %> 
                <li><a href="/uytube/buscar?categoria=<%= elem %>"><span class="icon-tag"></span> <%= elem %></a></li>
        <%
                }
            }
        %>
    </ul>					  
</aside>