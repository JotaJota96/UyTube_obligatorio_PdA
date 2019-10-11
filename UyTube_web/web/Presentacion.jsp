<%-- 
    Document   : Presentacion
    Created on : 07/10/2019, 03:40:03 PM
    Author     : administrador
--%>

<%@page import="Logica.DataType.DtVideo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <%
        ArrayList<Object> video = (ArrayList) request.getAttribute("videos");
        boolean sesionIniciada = (boolean) request.getAttribute("sesionIniciada");
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
       	<link rel="stylesheet" type="text/css" href="css/contenido-index.css">
        <link rel="stylesheet" type="text/css" href="iconos/style.css">
        <link rel="icon" type="image/png" href="imagenes/icono.png" />
        <title>UyTube</title>
    </head>
    <body>
        <%
            if (sesionIniciada) {
        %>
        <%@ include file='include/header-usuario.html' %>
        <%
        } else {
        %>
        <%@ include file='include/header-visitante.html' %>
        <%
            }
        %>
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

                        <%
                            if (sesionIniciada) {
                        %>
                        <%@ include file='include/menu-usuario.html' %>
                        <%
                        } else {
                        %>
                        <%@ include file='include/menu-visitante.html' %>
                        <%
                            }
                        %>
                        <div class="contenido">
                            <section class="contenido-flexible">
                                <!--================== Aca va el contenido central para agregar ========================== -->					
                                <h3>Lo nuevo</h3>
                                <%
                                    for (Object elem : video) {
                                        
                                        DtVideo vid = (DtVideo) elem;
                                        String idV = Funciones.Funciones.extraerIDYoutube(vid.getUrlVideoOriginal());
                                        String Imagen = Funciones.Funciones.obtenerImagenDeVideo(idV, 4);
                                %> 
                                <div class="card" >
                                    <a href="/uytube/video-consulta&id=<%= vid.getId()%>"><img src="<%= Imagen%>" class="card-img-top" alt="Nombre del video"></a>										
                                    <div class="card-body">
                                        <h6 class="card-title"><%= vid.getNombre()%></h6>
                                    </div>
                                </div>   
                                <%
                                    }
                                %>
                        </div>

                    </section>	
                </div>
            </div>
        </div>

        <%@ include file='include/widgets.html' %>
        <%@ include file='include/footer.html' %>

        <script src="js/jquery-3.4.1.min_1.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/funciones.js"></script>
        <script src="js/index.js"></script>
    </body>
</html>
