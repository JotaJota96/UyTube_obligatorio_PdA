<%@page import="Logica.DataType.DtUsuario"%>
<%@page import="Logica.Interfaces.IUsuario"%>
<%@page import="Logica.Fabrica"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
Menú para el usuario logueado
-->
<aside class="menu" >	
    <% 
        IUsuario sys = Fabrica.getInstancia().getIUsuario();
        DtUsuario usu = sys.obtenerUsuarioActual();
    %>
    <ul>
        <li>
            <span>
                <label class="icon-menu1"></label>
                <img class="fotoLogo" src="imagenes/logoChico.jpeg" alt="UyTube">
            </span>		
        </li>		
        <li class="titulo"> Inicio </li>
        <li><a href="/uytube/presentacion"><span class="icon-home1"></span> Inicio</a></li>
        <li class="titulo"> <%= usu.getNickname() %> </li>
        <li><a href="/uytube/usuario-consultar?id=<%= usu.getNickname()%>" ><span class="icon-user"></span> Mi perfil</a></li>
        <li><a href="usuario-consultar?id=<%= usu.getNickname()%>&ps=VIDEOS"><span class="icon-video-camera"></span> Mis videos</a></li> 
        <li><a href="usuario-consultar?id=<%= usu.getNickname()%>&ps=LISTAS"><span class="icon-list"></span> Mis listas</a></li> 
        <li class="titulo">Agregar</li>
        <li><a href="/uytube/video-agregar"><span class="icon-upload3"></span> Subir video</a></li>
        <li><a href="/uytube/lista-agregar"><span class="icon-add-to-list"></span> Crear lista</a></li>
        <li class="salir"><a href="/uytube/cerrar-sesion"><span class="icon-exit"></span> SALIR</a></li>
    </ul>					  
</aside>