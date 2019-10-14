<%-- 
    Document   : ConsultaUsuario
    Created on : 07/10/2019, 01:25:13 AM
    Author     : administrador
--%>

<%@page import="Logica.Enumerados.Privacidad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.DataType.DtListaDeReproduccion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <%
        DtListaDeReproduccion listasRep = (DtListaDeReproduccion) request.getAttribute("listas");
        boolean sesionIniciada = (boolean) request.getAttribute("sesionIniciada");
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
        <link rel="stylesheet" type="text/css" href="css/contenido-consulta-usuario.css">
        <link rel="stylesheet" type="text/css" href="iconos/style.css">
        <link rel="icon" type="image/png" href="imagenes/icono.png" />
        <title>UyTube - Mod.Lista</title>
    </head>
    <body>

        <div class="container-fluid" style="padding-left: 0; padding-right: 0px;">
            <div class="row">
                <div class="col-12">
                    <%
                        if (sesionIniciada) {
                    %>
                    <%@ include file='include/header-usuario.jsp' %>
                    <%                    } else {
                    %>
                    <%@ include file='include/header-visitante.jsp' %>
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
                        <%@ include file='include/menu-usuario.jsp' %>
                        <%                        } else {
                        %>
                        <%@ include file='include/menu-visitante.jsp' %>
                        <%
                            }
                        %>
                        <div class="contenido">
                            <section class="contenido-flexible">								
                                <div class="container">
                                    <form class="form-modificar-lista" action="/uytube/lista-modificar" method="post" >
                                        <br>
                                        <h4>Lista de reproducción particulares</h4>
                                        <br>
                                        <!-- Inicio de las Listas-->
                                        <ul class="list-group">
                                            <!-- Lista por defecto -->
                                            <%
                                                if (listasRep == null) {
                                            %>  
                                            <li class="list-group-item  list-group-item-danger">Este usuario no tiene Listas particulares</li>
                                            <br>
                                            <%
                                            } else {

                                            %>
                                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                                <div class="col-md-4">
                                                    <input value="<%=listasRep.getNombre()%>" class="form-control" type="text" name="nombre" readonly="readonly" placeholder="Nickname" id="input_Nickname" required>
                                                </div>
                                                <div class="form-group col-md-4">

                                                    <label  for="cc-name">Privacidad del video</label>
                                                    <%
                                                        if (listasRep.getPrivacidad() == Privacidad.PRIVADO) {
                                                    %>
                                                    <div class="custom-control custom-radio">
                                                        <input id="publico" name="privacidad" value="PUBLICO" type="radio" class="custom-control-input" >
                                                        <label class="custom-control-label" for="publico">Publico</label>
                                                    </div>
                                                    <div class="custom-control custom-radio">
                                                        <input id="privado" name="privacidad" value="PRIVADO" type="radio" class="custom-control-input" checked>
                                                        <label class="custom-control-label" for="privado">Privado</label>
                                                    </div>
                                                    <%
                                                        }

                                                    %>

                                                    <% if (listasRep.getPrivacidad() == Privacidad.PUBLICO) {
                                                    %>
                                                    <div class="custom-control custom-radio">
                                                        <input id="publico" name="privacidad" value="PUBLICO" type="radio" class="custom-control-input" checked>
                                                        <label class="custom-control-label" for="publico">Publico</label>
                                                    </div>
                                                    <div class="custom-control custom-radio">
                                                        <input id="privado" name="privacidad" value="PRIVADO" type="radio" class="custom-control-input">
                                                        <label class="custom-control-label" for="privado">Privado</label>
                                                    </div>
                                                    <%
                                                        }
                                                    %>

                                                </div>


                                                <div class=" bd-light">
                                                    <select class="custom-select d-block w-100" name="categoria" id="categoria" required>
                                                        <%
                                                            for (String l : Categorias) {
                                                                if (listasRep.getCategoria().equals(l)) {
                                                        %>
                                                        <option  selected = "selected"> <%= l%>  </option> 
                                                        <%
                                                        } else {
                                                        %>
                                                        <option> <%= l%>  </option> 
                                                        <%
                                                                }
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                            </li>
                                            <%
                                                }
                                            %>

                                            <!-- Lista 1 -->

                                            <!-- Fin de las listas. -->
                                            <br>
                                            <hr class="mb-2">
                                            <br>
                                            <!-- BOTONES (ACEPTAR / CANCELAR) -->

                                            <div class="bd-light " >
                                                <div class="btn-toolbar justify-content-end" role="toolbar" aria-label="Toolbar with button groups">
                                                    <div class="p-2 btn-group mr-2" role="group" aria-label="Third group">
                                                        <a href="/uytube/presentacion"> 
                                                            <button type="button" class="btn btn-danger">CANCELAR</button>
                                                        </a>
                                                    </div> 
                                                    <div class="p-2 btn-group" role="group" aria-label="Third group">
                                                        <button type="submit" class="btn btn-primary">ACEPTAR</button>
                                                    </div>  
                                                </div>
                                            </div>
                                    </form>
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