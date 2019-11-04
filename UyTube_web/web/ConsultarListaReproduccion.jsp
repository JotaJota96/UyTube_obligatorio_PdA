<%-- 
    Document   : Buscar
    Created on : 09/10/2019, 07:55:42 PM
    Author     : administrador
--%>

<%@page import="logica.controladores.TipoListaDeReproduccion"%>
<%@page import="logica.controladores.DtVideo"%>
<%@page import="logica.controladores.DtListaDeReproduccion"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="es">
    <%
        DtListaDeReproduccion listasRep = (DtListaDeReproduccion) request.getAttribute("listas");
        String usuario = (String)request.getAttribute("usuario");
        boolean sesionIniciada = (boolean) (request.getSession().getAttribute("usuario") != null);
        boolean propietario = (boolean) request.getAttribute("propietario");
        ArrayList<DtVideo> videos = (ArrayList<DtVideo>) request.getAttribute("videos");
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
        <link rel="stylesheet" type="text/css" href="css/contenido-buscar.css">
        <link rel="stylesheet" type="text/css" href="iconos/style.css">
        <link rel="icon" type="image/png" href="imagenes/icono.png" />
        <title>UyTube</title>
    </head>
    <body>
        <div class="container-fluid" style="padding-left: 0; padding-right: 0px;">
            <div class="row">
                <div class="col-12">
                    <!-- Inclusion de la barra superior -->
                    <%
                        if (sesionIniciada) {
                    %>
                    <jsp:include page="include/header-usuario.jsp" />
                    <%
                        } else {
                    %>
                    <jsp:include page="include/header-visitante.jsp" />
                    <%
                        }
                    %>

                </div>
            </div>		
        </div>

        <div class="container-fluid" style="padding-left: 0; padding-right: 0px;">
            <div class="row">
                <div class="col-12">
                    <div class="relleno-header"></div>
                </div>
            </div>
        </div>
        <div class="container-fluid" style="padding-left: 0; padding-right: 0px;">
            <div class="row">
                <div class="col-12">
                    <section class="principal">
                        <%
                            if (sesionIniciada) {
                        %>
                        <jsp:include page="include/menu-usuario.jsp" />
                        <%
                        } else {
                        %>
                        <jsp:include page="include/menu-visitante.jsp" />
                        <%
                            }
                        %>
                        <div class="contenido">
                            <section class="contenido-flexible">								
                                <div class="container">

                                    <!-- INFORMACION LISTA.REP-->
                                    <div class="d-flex bd-highlight">
                                        <div class="bd-highlight">
                                            <img src="imagenes/lista.jpg" width="246" height="138">
                                        </div>
                                        <div class="pl-3 p-2 bd-highlight">
                                            <h5>Nombre: </h5>
                                            <h5>Tipo:</h5>
                                            <h5>Privacidad:</h5>
                                            <h5>Categoria:</h5>
                                        </div>
                                        <div class="p-2 bd-highlight">
                                            <h5><%= listasRep.getNombre()%></h5>
                                            <h5><%= listasRep.getTipo()%></h5>
                                            <h5><%= listasRep.getPrivacidad()%></h5>
                                            <h5><%= listasRep.getCategoria()%></h5> 
                                        </div>
                                        <%
                                            if (sesionIniciada && propietario && listasRep.getTipo() != TipoListaDeReproduccion.POR_DEFECTO) {
                                        %>
                                        <div class="p-2 d-flex align-items-end">
                                            <a href="lista-modificar?idUsu=<%= usuario%>&idList=<%= listasRep.getId()%>">
                                                <button type="button" class="btn btn-primary">MODIFICAR</button>
                                            </a>
                                        </div>
                                        <%
                                            }
                                        %>
                                    </div>

                                    <!--FIN INFORMACION LISTA.REP-->
                                    <hr>
                                    <!--LISTA DE CONTENIDO-->
                                    <h3>VIDEOS:</h3>

                                    <div class="tab-pane fade show active" id="videos" role="tabpanel" aria-labelledby="nav-VIDEO-tab">
                                        <!--PRIMER VIDEO-->
                                        <%
                                            for (DtVideo elem : videos) {
                                                String id = Funciones.Funciones.extraerIDYoutube(elem.getUrlVideoOriginal());
                                        %>
                                        <div class="video">
                                            <div class="bd-highlight caja-imagen">
                                                <div class="bd-highlight">
                                                    <a href="video-consultar?id=<%=elem.getId()%>">
                                                        <img src="<%= Funciones.Funciones.obtenerImagenDeVideo(id, 2)%>" width="246" height="138">
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="bd-highlight caja-texto justify-content-start">
                                                <div class="bg-light" >
                                                    <a href="video-consultar?id=<%=elem.getId()%>">
                                                        <h5><%= elem.getNombre() %></h5>
                                                    </a>
                                                    <p><%= elem.getDescripcion()%></p>
                                                </div>
                                            </div>
                                        </div>
                                        <%
                                            }
                                        %>
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