<%@page import="logica.controladores.CUsuario"%>
<%@page import="logica.controladores.CUsuarioService"%>
<%@page import="logica.controladores.DtUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<div class="container-fluid" style="padding-left: 0; padding-right: 0px;">
    <%
        CUsuarioService servicio = new CUsuarioService();
        CUsuario sys = servicio.getCUsuarioPort();
        DtUsuario usu = sys.obtenerUsuarioActual();

    %>
    <div class="row">
        <div class="col-12">
            <header class="header">
                <nav>
                    <div class="navbar-dark item-header item-header1" id="navLogo">
                        <label class="icon-menu1"></label>
                        <a href="/uytube/presentacion"><img class="fotoLogo" src="imagenes/logoChico.jpeg" alt="UyTube"></a>					
                    </div>	
                    <div class="navbar-dark item-header item-header2">					  
                        <div id="navbarSupportedContent">		
                            <form class="form-inline my-2 my-lg-0 formBuscar" action="/uytube/buscar" id="formBuscar" method="get">
                                <input class=" mr-sm-2" name="texto" type="search" placeholder="Buscar" aria-label="Search">
                                <button class="btn btn-primary" id="btnBuscar" type="submit">Buscar</button>
                            </form>
                        </div>
                    </div>
                    <div class="perfil item-header item-header3 flex-row justify-content-lg-space-between">
                        <div class="flex-row justify-content-lg-space-between alig-content-center" id="nombrePerfil">
                            <a href="/uytube/usuario-consultar?id=<%= usu.getNickname()%>">
                                <%= usu.getNickname()%>
                            </a>
                        </div>	
                        <div class="fotoPerfil">
                            <a href="/uytube/usuario-consultar?id=<%= usu.getNickname()%>">
                                <img id="fotoPerfil" src="usuario-imagen?id=<%= usu.getNickname() %>" alt="Perfil">
                            </a>
                        </div>
                    </div>
                </nav>					
            </header>
        </div>
    </div>		
</div>