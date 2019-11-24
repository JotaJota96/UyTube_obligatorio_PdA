<%@page import="logica.controladores.DtListaDeReproduccion"%>
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
        <li><a href="buscar?texto=&filtro=Videos&orden=Fecha"><span class="icon-video-camera"></span> Ver Videos</a></li> 
        <li><a href="buscar?texto=&filtro=Listas&orden=Fecha"><span class="icon-list"></span> Ver Listas</a></li> 
        <li class="titulo"> Salir </li>
        <li class="salir"><a href="cerrar-sesion"><span class="icon-exit"></span> Cerrar sesión</a></li>
    </ul>					  
</aside>