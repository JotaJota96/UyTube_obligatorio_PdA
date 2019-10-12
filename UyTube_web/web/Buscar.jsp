<%-- 
    Document   : Buscar
    Created on : 09/10/2019, 07:55:42 PM
    Author     : administrador
--%>

<%@page import="Logica.DataType.DtUsuario"%>
<%@page import="Logica.Fabrica"%>
<%@page import="Logica.DataType.DtVideo"%>
<%@page import="Logica.DataType.DtListaDeReproduccion"%>
<%@page import="Logica.DataType.DtCanal"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="es">
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
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <!-- Inclusion de la barra superior -->
                    <%
                        if (false){
                    %>
                    <%@ include file='include/header-usuario.html' %>
                    <%
                        }else{
                    %>
                    <%@ include file='include/header-visitante.html' %>
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
                        <%@ include file='include/menu-usuario.html' %>

                        <div class="contenido">
                            <section class="contenido-flexible">								
                                <div class="container">


                                    <!-- BOTONES DESPLEGABLES-->

                                    <%@ include file='include/filtro-visible.html' %>

                                    <!--FIN DE LOS BOTONES-->

                                    <hr class="mb-2">

                                    <!--LISTA DE CONTENIDO-->

                                    <div class="tab-pane fade show active" id="videos" role="tabpanel" aria-labelledby="nav-VIDEO-tab">
                                        <%
                                            ArrayList<Object> lista = (ArrayList) request.getAttribute("Lista");
                                            for (Object o : lista){
                                                if (o instanceof DtVideo){
                                                    DtVideo e = (DtVideo) o;
                                                    String miniatura = Funciones.Funciones.obtenerImagenDeVideo(
                                                            Funciones.Funciones.extraerIDYoutube(e.getUrlVideoOriginal()),
                                                            2
                                                    );
                                        %>
                                        <div class="video">
                                            <div class="bd-highlight caja-imagen">
                                                <div class="bd-highlight">
                                                    <a href="video-consultar?id=<%= e.getId() %>">
                                                        <img src="<%= miniatura %>" width="246" height="138">
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="bd-highlight caja-texto justify-content-start">
                                                <div class="bg-light" >
                                                    <h5 class="mt-0">
                                                        <a href="video-consultar?id=<%= e.getId() %>">
                                                            <%= e.getNombre() %>
                                                        </a>
                                                    </h5>
                                                    <p><%= e.getDescripcion() %></p>
                                                </div>
                                            </div>
                                        </div>
                                        <br>
                                        <%
                                                }else if (o instanceof DtListaDeReproduccion){
                                                    DtListaDeReproduccion e = (DtListaDeReproduccion) o;
                                        %>
                                        <br><div class="lista bd-highlight">
                                            <div class="bd-highlight caja-imagen">
                                                <div class="bd-highlight ">
                                                    <a href="lista-consultar?id=<%= e.getId()%>">
                                                        <img src="imagenes/lista.jpg" alt="lista" width="246" height="138">
                                                    </a>

                                                </div>
                                            </div>
                                            <div class=" bd-highlight caja-texto justify-content-start">
                                                <div class="overflow-auto bg-light" >
                                                    <h5 class="mt-0">
                                                        <a href="lista-consultar?id=<%= e.getId() %>">
                                                            <%= e.getNombre() %>
                                                        </a>
                                                    </h5>
                                                    <p>Categoría: <%= e.getCategoria() %></p>
                                                </div>
                                            </div>
                                        </div>
                                        <br>
                                        <%
                                                }else if (o instanceof DtCanal){
                                                    DtCanal e = (DtCanal) o;
                                                    // buena suerte entendiendo esto...
                                                    DtUsuario usu = Fabrica.getInstancia().getIUsuario().obtenerPropietarioDeCanal(e.getId());
                                                    String imagenCanal;
                                                    if (usu.getImagen() == null || usu.getImagen().equals("")){
                                                        imagenCanal = "imagenes/ukp.png";
                                                    }else{
                                                        imagenCanal = usu.getImagen();
                                                    }
                                        %>
                                        <div class="canal bd-highlight">
                                            <div class="bd-highlight caja-imagen">
                                                <div class="bd-highlight">
                                                    <a href="usuario-consultar?id=<%= usu.getNickname() %>">
                                                       <img src="<%= imagenCanal %>" class="align-self-center rounded-circle" alt="Cinque Terre" >
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="bd-highlight caja-texto justify-content-start">
                                                <div class="overflow-auto bg-light">
                                                    <h5 class="mt-0">
                                                        <a href="usuario-consultar?id=<%= usu.getNickname() %>">
                                                            <%= e.getNombre() %>
                                                        </a>
                                                    </h5>
                                                    <p><%= e.getDescripcion() %></p>
                                                </div>
                                            </div>
                                        </div>
                                        <br> 
                                        <%
                                                }
                                            }
                                        %>


                                        
                                        
                                    </div>

                                    <!--FIN de LISTA DE CONTENIDO-->

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