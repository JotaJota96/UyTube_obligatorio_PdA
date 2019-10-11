<%-- 
    Document   : Buscar
    Created on : 09/10/2019, 07:55:42 PM
    Author     : administrador
--%>

<%@page import="java.util.TreeMap"%>
<%@page import="javax.swing.text.Document"%>
<%@page import="Logica.DataType.DtComentario"%>
<%@page import="Logica.DataType.DtUsuario"%>
<%@page import="Logica.Fabrica"%>
<%@page import="Logica.DataType.DtVideo"%>
<%@page import="Logica.DataType.DtListaDeReproduccion"%>
<%@page import="Logica.DataType.DtCanal"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="es">
    <%
        boolean sesionIniciada = (boolean) request.getAttribute("sesionIniciada");
        //sesionIniciada = true;
        boolean propietarioDelVideo = (boolean) request.getAttribute("propietarioDelVideo");
        DtUsuario usuario = (DtUsuario) request.getAttribute("usuario");
        DtCanal canal = (DtCanal) request.getAttribute("canal");
        DtVideo video = (DtVideo) request.getAttribute("video");
        ArrayList<DtComentario> comentarios = (ArrayList) request.getAttribute("comentarios");
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
        <title>UyTube - <%= video.getNombre() %></title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <!-- Inclusion de la barra superior -->
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
                                <div class="container">

                                    <!--INICIO DEL VIDEO-->
                                    
                                    <div>
                                        <br>
                                        <h3>
                                            <%= video.getNombre() %>   
                                        </h3>
                                    </div>

                                    <div class="embed-responsive embed-responsive-16by9">
                                        <%
                                            String videoEmbebido = Funciones.Funciones.obtenerEnlaceEmbebido(
                                                    Funciones.Funciones.extraerIDYoutube(video.getUrlVideoOriginal())
                                            );
                                        %>
                                        <iframe class="embed-responsive-item" src="<%= videoEmbebido %>" allowfullscreen></iframe>
                                    </div>

                                    <%
                                        if (sesionIniciada) {
                                    %>
                                    <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                        <div class="p-2 btn-group mr-5" role="group" aria-label="Third group">
                                            <button type="button" class="btn btn-info">+ LISTA DE REPRODUCCIÓN</button>
                                        </div>
                                        <div class="p-2 btn-group mr-2" role="group" aria-label="Third group">
                                            <button type="button" class="btn btn-success">
                                                ME GUSTÓ <span class="badge badge-light"><%= video.getCantLikes() %></span>
                                            </button>
                                            <button type="button" class="btn btn-danger">
                                                NO ME GUSTÓ <span class="badge badge-light"><%= video.getCantDisLikes() %></span>
                                            </button>
                                        </div>  
                                    </div>
                                    <%
                                        }
                                    %>
                                    
                                    <br><hr class="mb-2"><br>
                                    
                                    <div class="row">
                                        <%
                                            String textoAlternativo;
                                            String rutaDeImagenDePerfil;
                                            if (usuario.getImagen() == null || usuario.getImagen().equals("")) {
                                                rutaDeImagenDePerfil = "imagenes/ukp.png";
                                                textoAlternativo = "Imagen de perfil por defecto";
                                            } else {
                                                rutaDeImagenDePerfil = usuario.getImagen();
                                                textoAlternativo = "Imagen de perfil de " + usuario.getNickname();
                                            }
                                        %>
                                        <div class="bd-highlight">
                                            <img class="align-self-center mr-3" src="<%= rutaDeImagenDePerfil %>" width="70" height="70" alt="<%= textoAlternativo %>">
                                        </div>
                                        <div class="bd-highlight" >
                                            <a href="usuario-consultar?id=<%= usuario.getNickname() %>">
                                             <h5><%= canal.getNombre() %></h5>
                                            </a>
                                        </div>
                                    </div>
                                    <br>
                                    
                                    <div class="bd-highlight" >
                                        <h3><small class="text-muted">DESCRIPCIÓN</small></h3>
                                    </div>
                                    <div class="bd-highlight" >
                                        <h5><%= video.getDescripcion() %></h5>
                                    </div>
                                    <!--FIN DEL VIDEO-->
                                    <br><hr class="mb-2"><br>
                                    
                                     <!--INGRESO DE COMENTARIOS-->

                                    <%
                                        if (sesionIniciada) {
                                    %>
                                     <div class="bd-highlight" >
                                        <div class="bd-light" >
                                            <h5>COMENTARIOS</h5>
                                        </div>
                                        <div class="bd-light" >
                                            <textarea class="form-control" name="descripcion" id="input_descripcion" placeholder="Agrega un comentario.." rows="3"></textarea>
                                        </div>
                                        <div class="bd-light " >
                                            <div class="btn-toolbar justify-content-end" role="toolbar" aria-label="Toolbar with button groups">
                                                <div class="p-2 btn-group mr-2" role="group" aria-label="Third group">
                                                    <button type="button" class="btn btn-danger">CANCELAR</button>
                                                </div> 
                                                <div class="p-2 btn-group" role="group" aria-label="Third group">
                                                    <button type="button" class="btn btn-success">COMENTAR</button>
                                                </div>  
                                            </div>
                                        </div>
                                    </div>
                                    <%
                                        }
                                    %>+
                                     
                                    <!--FIN DE INGRESO DE COMENTARIOS-->
                                     
                                    <br>
                                     
                                    <!--COMENTARIOS EN SI-->
                                    
                                    <!--A CONTINUACION UN EJEMPLO DE COMO PODRIAN SER LOS COMENTARIOS (NO DEFINITIVO)-->
                                    
                                    <!--
                                        TreeMap<Integer, Boolean> historial = new TreeMap();
                                        int proximoNivel = -1;
                                        DtComentario c;
                                        for (int i = 0; i < comentarios.size(); i++){
                                            c = comentarios.get(i);
                                            if (historial.)
                                            
                                            if (i+1 == comentarios.size()){
                                                proximoNivel = -1;
                                            }else{
                                                proximoNivel = comentarios.get(+1).getNivelSubComentario();
                                            }
                                            
                                           // mostrar primera parte
                                            
                                           if (proximoNivel == c.getNivelSubComentario()){
                                               
                                           }else if (proximoNivel == c.getNivelSubComentario()){
                                               
                                           }else{
                                               
                                           }
                                           
                                           
                                        }
                                    -->
                                    
                                    
                                    <div class="media">
                                        <img class="mr-3" src="imagenes/ukp.png" width="50" height="50">
                                        <div class="media-body">
                                            <h5 class="mt-0">Media heading</h5>
                                            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.

                                            <div class="media mt-3">
                                                <a class="mr-3" href="#">
                                                    <img class="mr-3" src="imagenes/ukp.png" width="50" height="50">
                                                </a>
                                                <div class="media-body">
                                                    <h5 class="mt-0">Media heading</h5>
                                                    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                                                    <div class="media mt-3">
                                                        <a class="mr-3" href="#">
                                                            <img class="mr-3" src="imagenes/ukp.png" width="50" height="50">
                                                        </a>
                                                        <div class="media-body">
                                                            <h5 class="mt-0">Media heading</h5>
                                                            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="media">
                                        <img class="mr-3" src="imagenes/ukp.png" width="50" height="50">
                                        <div class="media-body">
                                            <h5 class="mt-0">Media heading</h5>
                                            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.

                                            <div class="media mt-3">
                                                <a class="mr-3" href="#">
                                                    <img class="mr-3" src="imagenes/ukp.png" width="50" height="50">
                                                </a>
                                                <div class="media-body">
                                                    <h5 class="mt-0">Media heading</h5>
                                                    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <!--FIN de COMENTARIOS-->

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
