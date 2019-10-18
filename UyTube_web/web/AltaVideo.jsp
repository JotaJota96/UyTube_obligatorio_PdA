<%-- 
    Document   : AltaVideo
    Created on : 06/10/2019, 06:14:18 PM
    Author     : administrador
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <%
        ArrayList<String> Categorias = (ArrayList) request.getAttribute("Categorias");
        boolean sesionIniciada = (boolean) (request.getSession().getAttribute("usuario") != null);
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
        <link rel="stylesheet" type="text/css" href="css/contenido-alta-video.css">	
        <link rel="stylesheet" type="text/css" href="iconos/style.css">
        <link rel="icon" type="image/png" href="imagenes/icono.png" />
        <title>UyTube - Agregar video</title>
    </head>
    <body>

        <%
            if (sesionIniciada) {
        %>
        <%@ include file='include/header-usuario.jsp' %>
        <%
        } else {
        %>
        <%@ include file='include/header-visitante.jsp' %>
        <%
            }
        %>
        <div class="container-fluid" style="padding-left: 0; padding-right: 0px;">
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
                                <!--================== Aca va el contenido central para agregar ========================== -->					
                                <h3>Alta de video</h3>			
                                <form class="form-alta-video" action="/uytube/video-agregar" method="post" >
                                    <div class="form-group row">
                                        <div class="form-group col-12 col-md-9">
                                            <label for="inputNombre">Nombre</label>
                                            <input type="text" class="form-control" name="nombre" id="inputNombre" placeholder="Nombre del video">
                                            <span id="msjNombre"></span>
                                        </div>
                                        <div class="form-group col-4 col-md-3">
                                            <label for="inputDuracion">Duración</label>
                                            <input type="time" step='1'class="form-control" name="duracion" id="inputDuracion" placeholder="Duración">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="form-group col-md-12">
                                            <label for="inputUrl">URL</label>
                                            <input type="url" class="form-control" name="url" id="inputUrl" placeholder="URL">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="form-group col-md-12">
                                            <label for="inputDescripcion">Descripción</label>
                                            <textarea class="form-control" name="descripcion" id="inputDescripcion" rows="3"></textarea>
                                        </div>
                                    </div>										
                                    <div class="form-group row">
                                        <div class="form-group col-6 col-md-4">
                                            <label for="inputFecha">Fecha</label>
                                            <input type="date" name="fecha" class="form-control"  id="inputFecha">
                                        </div>
                                        <div class="form-group col-md-2">
                                            
                                        </div>
                                        <div class="form-group col-8 col-md-6">
                                            <label for="inputCategoria">Categoría</label>
                                            <select id="inputCategoria" name="categoria" class="form-control">
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
                                    <button type="submit" class="btn btn-primary">Subir video</button>
                                    </div>											
                                </form>
                                <!-- Fin del contenido central -->
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
        <script src="js/alta-modificar-video.js"></script>
    </body>
</html>