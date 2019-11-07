<%@page import="logica.controladores.CUsuarioService"%>
<%@page import="logica.controladores.CUsuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.controladores.DtUsuario"%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
Menú para el usuario logueado   <%%>
-->
<aside class="menu" >	
    <%
        CUsuarioService servicio = new CUsuarioService();
        CUsuario sys = servicio.getCUsuarioPort();
        
        DtUsuario usu = sys.obtenerUsuarioActual();
        ArrayList<String> cate = (ArrayList<String>) sys.listarCategorias();
    %>
    <ul>	
        <li class="titulo"> Inicio </li>
        <li><a href="presentacion"><span class="icon-home1"></span> Inicio</a></li>
        <li class="titulo"> <%= usu.getNickname()%> </li>
        <li><a href="usuario-consultar?id=<%= usu.getNickname()%>" ><span class="icon-user"></span> Mi perfil</a></li>
        <li><a href="usuario-consultar?id=<%= usu.getNickname()%>&ps=VIDEOS"><span class="icon-video-camera"></span> Mis videos</a></li> 
        <li><a href="usuario-consultar?id=<%= usu.getNickname()%>&ps=LISTAS"><span class="icon-list"></span> Mis listas</a></li> 
        <li class="titulo">Agregar</li>
        <li><a href="video-agregar"><span class="icon-upload3"></span> Subir video</a></li>
        <li><a href="lista-agregar"><span class="icon-add-to-list"></span> Crear lista</a></li>
        <li class="titulo">Categorias</li>
        <% 
            for (String elem : cate) {
                if(!elem.equals("UNDEFINED")){
        %> 
                <li><a href="buscar?categoria=<%= elem %>"><span class="icon-tag"></span> <%= elem %></a></li>
        <%
                }
            }
        %>
        <li class="titulo"> Salir </li>
        <li class="salir"><a href="cerrar-sesion"><span class="icon-exit"></span> Cerrar sesión</a></li>
    </ul>					  
</aside>