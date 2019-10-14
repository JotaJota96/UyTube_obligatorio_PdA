<%-- 
    Document   : ConsultaUsuario
    Created on : 07/10/2019, 01:25:13 AM
    Author     : administrador
--%>

<%@page import="Logica.DataType.DtListaDeReproduccion"%>
<%@page import="Logica.DataType.DtVideo"%>
<%@page import="Logica.DataType.DtCanal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.DataType.DtUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <%
        boolean propietario = (boolean) request.getAttribute("propietario");
        boolean sesionIniciada = (boolean) (request.getSession().getAttribute("usuario") != null);
        DtUsuario usuario = (DtUsuario) request.getAttribute("usuario");
        DtCanal canal = (DtCanal) request.getAttribute("canal");
        ArrayList<DtUsuario> seguidos = (ArrayList) request.getAttribute("seguidos");
        ArrayList<DtUsuario> seguidores = (ArrayList) request.getAttribute("seguidores");
        ArrayList<DtVideo> videos = (ArrayList) request.getAttribute("videos");
        ArrayList<DtListaDeReproduccion> listasRep = (ArrayList) request.getAttribute("listasRep");
        String ps = (String) request.getAttribute("ps");
    %>
      
    
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/body.css">
        <link rel="stylesheet" type="text/css" href="css/header.css">
        <link rel="stylesheet" type="text/css" href="css/menu.css">
        <link rel="stylesheet" type="text/css" href="css/widget.css">
        <link rel="stylesheet" type="text/css" href="css/footer.css">
        <link rel="stylesheet" type="text/css" href="css/contenido-consulta-usuario.css">
        <link rel="stylesheet" type="text/css" href="iconos/style.css">
        <link rel="icon" type="image/png" href="imagenes/icono.png" />
        <title>UyTube - <%= usuario.getNickname()%></title>
    </head>
    <body>
        <%@ include file='include/ventana-modal_baja.html' %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <!-- Inclusion de la barra superior -->
                    <%
                        if (sesionIniciada){
                    %>
                    <%@ include file='include/header-usuario.jsp' %>
                    <%
                        }else{
                    %>
                    <%@ include file='include/header-visitante.jsp' %>
                    <%
                        }
                    %>
                </div>
            </div>		
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="relleno-header"></div>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <section class="principal">	
                        <!-- Inclusion del menu lateral -->
                        <%
                            if (sesionIniciada) {
                        %>
                        <%@ include file='include/menu-usuario.jsp' %>
                        <%
                        } else {
                        %>
                        <%@ include file='include/menu-visitante.jsp' %>
                        <%
                            }
                        %>
                        <div class="contenido">
                            <section class="contenido-flexible">
                                <div class="container">
                                    <div class="d-flex bd-highlight ">
                                        <div class="p-4 flex-fill bd-highlight">
                                            <div class="d-flex justify-content-center">
                                                <%
                                                    String textoAlternativo;
                                                    String rutaDeImagenDePerfil;
                                                    if (usuario.getImagen() == null || usuario.getImagen().equals("")) {
                                                        rutaDeImagenDePerfil = "imagenes/ukp.png";
                                                        textoAlternativo = "Imagen de perfil por defecto";
                                                    } else {
                                                        rutaDeImagenDePerfil = usuario.getImagen();
                                                        textoAlternativo = "Imagen de perfil de " + usuario.getNickname();
                                                        //char contrabarra = 92;
                                                        //char barra = 47;
                                                        //rutaImagenPerfil = rutaImagenPerfil = rutaImagenPerfil.replace(contrabarra, barra);
                                                    }
                                                %>
                                                <img src="<%=rutaDeImagenDePerfil%>" class="rounded-circle" alt="<%=textoAlternativo%>" width="180" height="180"> 
                                            </div>
                                        </div>
                                            
                                            
                                        <div class="p-1 flex-fill bd-highlight ">
                                            
                                            <div class="d-flex bd-highlight ">
                                                <div class="p-1 d-flex flex-fill bd-highlight">
                                                    <br><h3><%= usuario.getNombre() + " " + usuario.getApellido()%></h3>
                                                    <%
                                                    if (sesionIniciada && propietario) {
                                                    %>
                                                        <button  data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo" class=" ml-5 btn btn-danger icon-remove-user" id="btnBaja">
                                                            Darse de baja
                                                        </button>
                                                    <%  
                                                    }
                                                    %>
                                                </div>
                                            </div>
                                                <hr class="mb-2">
                                                
                                            <div class="p-1 bd-highlight ">
                                                <div class="d-flex bd-highlight ">
                                                    
                                                    <div class="p-1 flex-fill bd-highlight ">
                                                        <p class="text-info"><%= canal.getNombre()%> &#x2714</p>
                                                    </div>
                                                    <div class="p-1 flex-fill bd-highlight ">
                                                        <p><%= usuario.getCantSeguidores()%> seguidores</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="p-1 bd-highlight ">
                                                <div class="d-flex bd-highlight ">
                                                    <div class="p-1 flex-fill bd-highlight ">
                                                        <p>PRIVACIDAD: <%= canal.getPrivacidad()%></p>
                                                    </div>
                                                    <div class="p-1 flex-fill bd-highlight ">
                                                        <%
                                                            if (sesionIniciada && propietario) {
                                                        %>
                                                        <a href="usuario-modificar?id=<%= usuario.getNickname()%>">
                                                            <button class="icon-cog btn btn-primary" id="btnBuscar" type="submit">
                                                                Modificar usuario
                                                            </button>
                                                        </a>    
                                                        <%
                                                            }
                                                        %>
                                                        <%
                                                        if (sesionIniciada && !propietario) {
                                                                boolean Sigue = false;
                                                                DtUsuario actual = (DtUsuario)request.getSession().getAttribute("usuario");
                                                                for (DtUsuario elem : seguidores){
                                                                    if (elem.getNickname().equals(actual.getNickname())){
                                                                        Sigue = true;
                                                                    }
                                                                }
                                                                if (Sigue) {
                                                                %>
                                                                    <a href="usuario-seguir?id=<%= usuario.getNickname()%>">
                                                                        <button class="btn btn-danger" id="btnBuscar" type="submit">
                                                                            Dejar de seguir
                                                                        </button>
                                                                    </a>
                                                                <%
                                                                }else{
                                                                %>
                                                                    <a href="usuario-seguir?id=<%= usuario.getNickname()%>">
                                                                        <button class="btn btn-primary" id="btnBuscar" type="submit">
                                                                            Seguir
                                                                        </button>
                                                                    </a>
                                                                <%
                                                                }  
                                                            }
                                                        %>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div><br>

                                    <div class="bd-example bd-example-tabs">
                                        <nav class="">
                                            <div class="nav nav-tabs " id="nav-tab" role="tablist">
                                            <%
                                            if (ps.equals("VIDEOS")) {
                                            %>    

                                                <a class="nav-item nav-link active" id="refVideos" data-toggle="tab" href="#videos" role="tab" aria-controls="nav-VIDEO" aria-selected="true">VIDEOS</a>
                                            <%
                                            } else {
                                            %> 
                                                <a class="nav-item nav-link" id="refVideos" data-toggle="tab" href="#videos" role="tab" aria-controls="nav-VIDEO" aria-selected="true">VIDEOS</a>
                                            <%
                                            }
                                            %>
                                            
                                            <%
                                            if (ps.equals("LISTAS")) {
                                            %>    
                                                <a class="nav-item nav-link active" id="refListas" data-toggle="tab" href="#listas" role="tab" aria-controls="nav-LISTAS" aria-selected="false">LISTAS</a>
                                            <%
                                            } else {
                                            %> 
                                                <a class="nav-item nav-link " id="refListas" data-toggle="tab" href="#listas" role="tab" aria-controls="nav-LISTAS" aria-selected="false">LISTAS</a>
                                            <%
                                            }
                                            %> 
                                                <a class="nav-item nav-link " id="refSeguidores" data-toggle="tab" href="#seguidores" role="tab" aria-controls="nav-SEGUIDORES" aria-selected="false">SEGUIDORES</a>
                                                <a class="nav-item nav-link " id="refSeguidos" data-toggle="tab" href="#seguidos" role="tab" aria-controls="nav-SEGUIDOS" aria-selected="false">SEGUIDOS</a>
                                            </div>
                                        </nav>
                                    </div>

                                    <div class="tab-content" id="nav-tabContent">
                                        <!-- Pestaña de videos -->
                                        <%
                                            if (ps.equals("VIDEOS")) {
                                        %>    

                                                <div class="tab-pane fade show active" id="videos" role="tabpanel"  aria-labelledby="nav-VIDEO-tab">
                                                <br>
                                        <%
                                            } else {
                                            %> 
                                                <div class="tab-pane fade show" id="videos" role="tabpanel"  aria-labelledby="nav-VIDEO-tab">
                                                <br>
                                            <%
                                            }
                                        %>   

                                            <%
                                                for (DtVideo v : videos) {
                                                    String miniatura = Funciones.Funciones.obtenerImagenDeVideo(
                                                            Funciones.Funciones.extraerIDYoutube(v.getUrlVideoOriginal()), 2
                                                    );
                                            %>
                                            <!-- Video individual en la lista -->
                                            <div class="d-flex bd-highlight ">
                                                <div class="p-1 flex-shrink-1 bd-highlight ">
                                                    <div class="p-1 bd-highlight ">
                                                        <a href="video-consultar?id=<%= v.getId() %>">
                                                            <img src="<%= miniatura %>" width="246" height="138">
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="p-1 caja-texto bd-highlight ">
                                                    <div class="overflow-auto p-1 mb-3 mb-md-0 mr-md-3 bg-light" style="max-width: 530px; max-height: 170px;">
                                                        <a href="video-consultar?id=<%= v.getId()%>">
                                                            <h5 class="mt-0"><%= v.getNombre()%></h5>
                                                        </a>
                                                        <p><%= v.getDescripcion()%></p>
                                                    </div>
                                                </div>
                                            </div>
                                            <%
                                                }
                                            %><%
                                                if (videos.isEmpty()) {
                                            %>
                                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                                El usuario no tiene videos
                                            </li>
                                            <%
                                                }
                                            %>
                                            <br>
                                        </div>

                                        <!-- Pestaña de listas de reproduccion -->
                                        
                                        <%
                                            if (ps.equals("LISTAS")) {
                                        %>    

                                                <div class="tab-pane fade show active" id="listas" role="tabpanel" aria-labelledby="nav-LISTAS-tab">
                                            <br><ul class="list-group">
                                        <%
                                            } else {
                                            %> 
                                                <div class="tab-pane fade show" id="listas" role="tabpanel" aria-labelledby="nav-LISTAS-tab">
                                                <br><ul class="list-group">
                                            <%
                                            }
                                        %>
                                                <%
                                                    for (DtListaDeReproduccion l : listasRep) {
                                                %>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    <a href="lista-consultar?idUsu=<%= usuario.getNickname() %>&idList=<%= l.getId() %>">
                                                        <%= l.getNombre()%>
                                                    </a>
                                                </li>
                                                <%
                                                    }
                                                %><%
                                                    if (listasRep.isEmpty()) {
                                                %>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    El usuario no tiene listas de reproducción
                                                </li>
                                                <%
                                                    }
                                                %>
                                            </ul>
                                        </div>

                                        <!-- Pestaña de usuarios seguidores -->
                                        <div class="tab-pane fade show " id="seguidores" role="tabpanel" aria-labelledby="nav-SEGUIDORES-tab">

                                            <br><ul class="list-group">
                                                <%
                                                    for (DtUsuario u : seguidores) {
                                                %>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    <a href="usuario-consultar?id=<%= u.getNickname()%>">
                                                        <%= u.getNickname()%>
                                                    </a>
                                                </li>
                                                <%
                                                    }
                                                %><%
                                                    if (seguidores.isEmpty()) {
                                                %>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    El usuario no tiene seguidores
                                                </li>
                                                <%
                                                    }
                                                %>
                                            </ul>
                                        </div>

                                        <!-- Pestaña de usuarios seguidos -->
                                        <div class="tab-pane fade show " id="seguidos" role="tabpanel" aria-labelledby="nav-SEGUIDOS-tab">
                                            <br><ul class="list-group">
                                                <%
                                                    for (DtUsuario u : seguidos) {
                                                %>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    <a href="usuario-consultar?id=<%= u.getNickname()%>">
                                                        <%= u.getNickname()%>
                                                    </a>
                                                </li>
                                                <%
                                                    }
                                                %><%
                                                    if (seguidos.isEmpty()) {
                                                %>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    El usuario no sigue a nadie
                                                </li>
                                                <%
                                                    }
                                                %>
                                            </ul>
                                        </div>
                                    </div>
                                </div>							
                            </section>
                        </div> 
                    </section>	
                </div>
            </div>
        </div>

        <%@ include file='include/widgets.html' %>
        <%@ include file='include/footer.html' %>

        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/funciones.js"></script>
    </body>
</html>