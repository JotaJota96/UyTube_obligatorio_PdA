<%-- 
    Document   : ConsultaUsuario
    Created on : 07/10/2019, 01:25:13 AM
    Author     : administrador
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <%
        boolean sesionIniciada = (boolean) (request.getSession().getAttribute("usuario") != null);
        ArrayList<String> Categorias = (ArrayList) request.getAttribute("Categorias");
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
        <link rel="stylesheet" type="text/css" href="css/contenido-alta-lista.css">
        <link rel="stylesheet" type="text/css" href="iconos/style.css">
        <link rel="icon" type="image/png" href="imagenes/icono.png" />
        <title>UyTube - Nueva Lista</title>
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
                    <%                    } else {
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
                        <!-- Inclusion del menu lateral -->
                        <%
                            if (sesionIniciada) {
                        %>
                        <jsp:include page="include/menu-usuario.jsp" />
                        <%                        } else {
                        %>
                        <jsp:include page="include/menu-visitante.jsp" />
                        <%
                            }
                        %>
                        <div class="contenido">
                            <section class="contenido-flexible">								
                                <div class="container">

                                    <!-- Agregar Listas-->
                                    <div class="">
                                        <form class="form-signin" action="/uytube/lista-agregar" method="post">
                                            <br>
                                            <br>
                                            <h1 class="h3 mb-4 font-weight-normal" id="Texto_ingrese">Ingrese sus datos</h1>
                                            <div class="mb-8 row">
                                                <div class="col-md-12">
                                                    <input type="text" class="form-control" name="nombreL" id="nombreLista" placeholder="Nombre de la lista" required>
                                                    <span class="small" id="msjNombre"></span>
                                                </div>                                               
                                            </div>
                                            
                                            
                                            <div class="row">
                                                <div class="col-4 col-md-3">
                                                    <label class="">Privacidad</label>
                                                </div>
                                                <div class="custom-control custom-radio col-4 col-md-3">
                                                    <input id="publico" name="privacidad" value="PUBLICO" type="radio" class="custom-control-input" checked>
                                                    <label class="custom-control-label" for="publico">Publico</label>
                                                </div>
                                                <div class="custom-control custom-radio col-4  col-md-3">
                                                    <input id="privado" name="privacidad" value="PRIVADO" type="radio" class="custom-control-input">
                                                    <label class="custom-control-label" for="privado">Privado</label>
                                                </div>
                                                <div class="col-0 col-md-3"></div>
                                            </div>
                                            <div class=" bd-light row">
                                                <div class="col-md-12">
                                                    <select class="custom-select d-block w-100" name="categoria" id="categoria" required>
                                                        <%
                                                            for (String l : Categorias) {
                                                        %>
                                                        <option> <%= l%>  </option> 
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </div>                                                
                                            </div>

                                            <hr class="mb-4">

                                            <div class="bd-light">
                                                <div class="btn-toolbar justify-content-end" role="toolbar" aria-label="Toolbar with button groups">
                                                    <div class=" btn-group mr-2" role="group" aria-label="Third group">
                                                        <a href="/uytube/presentacion"> 
                                                            <button type="button" class="btn btn-danger">CANCELAR</button>
                                                        </a>
                                                    </div> 
                                                    <div class=" btn-group" role="group" aria-label="Third group">
                                                        <button type="submit" class="btn btn-primary">ACEPTAR</button>
                                                    </div>  
                                                </div>
                                            </div>
                                        </form>
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
        <script src="js/alta-modificar-lista.js"></script>
    </body>
</html>
