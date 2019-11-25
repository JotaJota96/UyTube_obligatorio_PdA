<%-- 
    Document   : Buscar
    Created on : 09/10/2019, 07:55:42 PM
    Author     : administrador
--%>

<%@page import="logica.controladores.DtListaDeReproduccionHistorial"%>
<%@page import="logica.controladores.CUsuario"%>
<%@page import="logica.controladores.CUsuarioService"%>
<%@page import="logica.controladores.Privacidad"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.controladores.TipoValoracion"%>
<%@page import="logica.controladores.DtValoracion"%>
<%@page import="java.util.TreeMap"%>
<%@page import="javax.swing.text.Document"%>
<%@page import="logica.controladores.DtComentario"%>
<%@page import="logica.controladores.DtUsuario"%>
<%@page import="logica.controladores.DtVideo"%>
<%@page import="logica.controladores.DtListaDeReproduccion"%>
<%@page import="logica.controladores.DtCanal"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="es">
    <%
        boolean sesionIniciada = (boolean) (request.getSession().getAttribute("usuario") != null);
        //sesionIniciada = true;
        boolean propietarioDelVideo = (boolean) request.getAttribute("propietarioDelVideo");
        DtUsuario usuario = (DtUsuario) request.getAttribute("usuario");
        DtCanal canal = (DtCanal) request.getAttribute("canal");
        DtVideo video = (DtVideo) request.getAttribute("video");
        String htmlComentarios = (String) request.getAttribute("comentarios");
        DtValoracion valoracionDada = (DtValoracion) request.getAttribute("valoracionDada");
        ArrayList<DtValoracion> valoraciones = (ArrayList) request.getAttribute("valoraciones");
        ArrayList<DtListaDeReproduccion> listas = (ArrayList) request.getAttribute("listas");
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
        <title>UyTube - <%= video.getNombre()%></title>
    </head>
    <body>
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
        <div class="container-fluid" style="padding-left: 0; padding-right: 0px;">
            <div class="row">
                <div class="col-12">
                    <div class="relleno-header"></div>
                </div>
            </div>
        </div>
        <div class="container-fluid" style="padding-left: 0; padding-right: 0px; ">
            <div class="row">
                <div class="col-12">
                    <section class="principal">						

                        <%
                            if (sesionIniciada) {
                        %>
                        <jsp:include page="include/menu-usuario.jsp" />
                        <%
                        } 
                        %>

                        <div class="contenido">
                            <section class="contenido-flexible">								
                                <div class="container">

                                    <!-- Ventana emergente para responder comentario, no borrar -->
                                    <%@ include file='include/ventana-modal.html' %>

                                    <!--==================== INICIO DATOS DEL VIDEO ====================-->
                                    <div>
                                        <br>
                                        <h3>
                                            <%= video.getNombre()%>   
                                        </h3>
                                    </div>
                                    
                                    <%
                                        // obtiene URL para enbeber el video
                                        String videoEmbebido = Funciones.Funciones.obtenerEnlaceEmbebido(
                                                Funciones.Funciones.extraerIDYoutube(video.getUrlVideoOriginal())
                                        );
                                    %>
                                    <div class="embed-responsive embed-responsive-16by9">
                                        <iframe id="video" value="<%= video.getId()%>" class="embed-responsive-item" src="<%= videoEmbebido%>" allowfullscreen></iframe>
                                    </div>
                                    
                                    <!-- BOTONES PARA LIKE, DISLIKE -->
                                    <%
                                        if (sesionIniciada) {
                                    %>
                                    <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                        <!-- Botones Me gusta y no me gusta -->
                                        <div class="p-2 btn-group mr-2" role="group" aria-label="Third group">
                                            <%
                                                String textoBtnLike = "ME GUSTA";
                                                String textoBtnDisLike = "NO ME GUSTA";
                                                String deshabilitarBtnLike = "";
                                                String deshabilitartextoBtnDisLike = "";

                                                if (valoracionDada == null) {
                                                    // quedan como fueron declaradas
                                                } else if (valoracionDada.getVal() == TipoValoracion.LIKE) {
                                                    textoBtnLike = "TE GUSTA";
                                                    textoBtnDisLike = "NO ME GUSTA";
                                                    deshabilitarBtnLike = "disabled=\"true\"";
                                                    deshabilitartextoBtnDisLike = "";
                                                } else if (valoracionDada.getVal() == TipoValoracion.DISLIKE) {
                                                    textoBtnLike = "ME GUSTA";
                                                    textoBtnDisLike = "NO TE GUSTA";
                                                    deshabilitarBtnLike = "";
                                                    deshabilitartextoBtnDisLike = "disabled=\"true\"";
                                                }
                                            %>
                                            <button <%= deshabilitarBtnLike%> type="button" id="btnLike" class="btn btn-success icon-thumbs-up">
                                                <span id="txtMeGusta"><%= textoBtnLike%></span>
                                                <span id="txtLike" class="badge badge-light"><%= video.getCantLikes()%></span>
                                            </button>
                                            <button <%= deshabilitartextoBtnDisLike%> type="button" id="btnDisLike" class="btn btn-danger icon-thumbs-down">
                                                <span id="txtNoMeGusta"><%= textoBtnDisLike%></span>
                                                <span id="txtDisLike" class="badge badge-light"><%= video.getCantDisLikes()%></span>
                                            </button>
                                        </div>

                                        <!-- Boton agregar a lista de reproduccion -->
                                        <!-- Boton modificar video -->
                                        <!-- Se sacaron, no van -->
                                    </div>
                                    <%
                                        }
                                    %>

                                    <br><hr class="mb-2"><br>

                                    <!-- IMAGEN DEL USUARIO Y NOMBRE DEL CANAL -->
                                    <div class="row">
                                        <%
                                            String textoAlternativo = "Imagen de perfil de " + usuario.getNickname();
                                            String rutaDeImagenDePerfil = "usuario-imagen?id=" + usuario.getNickname();
                                        %>
                                        <div class="bd-highlight">
                                            <img class="align-self-center mr-3" src="<%= rutaDeImagenDePerfil%>" width="70" height="70" alt="<%= textoAlternativo%>">
                                        </div>
                                        <div class="bd-highlight" >
                                            <h5><%= canal.getNombre()%></h5>
                                        </div>
                                    </div>
                                    <br>
                                    
                                    <!-- DESCRIPCION DEL VIDEO -->
                                    <div class="bd-highlight" >
                                        <h5>Fecha de publicación: <%= Funciones.Funciones.darFormatoFecha(video.getFechaPublicacion()) %></h5>
                                    </div>
                                    <div class="bd-highlight" >
                                        <h3><small class="text-muted">DESCRIPCIÓN</small></h3>
                                    </div>
                                    <div class="bd-highlight" >
                                        <h5><%= video.getDescripcion()%></h5>
                                    </div>
                                    <!--==================== FIN DEL VIDEO ====================-->

                                    <br><hr class="mb-2"><br>

                                    <!--==================== INGRESO DE COMENTARIOS ====================-->
                                    <!-- Se saca, aca no va -->
                                    <!--==================== FIN DE INGRESO DE COMENTARIOS ====================-->

                                    <br>

                                    <!--==================== SECCION DE COMENTARIOS ====================-->
                                    <div id="seccion-comentarios">  
                                        <% out.print(htmlComentarios);%>
                                    </div>

                                    <!-- -------- Ejemplo de estructura de comentarios-------- -->
                                    <!--
                                    <div id="seccion-comentarios">    
                                        <div class="media">
                                            <img class="mr-3" src="imagenes/ukp.png" width="50" height="50">
                                            <div class="media-body">
                                                <h5 class="mt-0">Media heading</h5>
                                                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                                                <br>
                                                <button type="button" onmouseover="idComentario = this.getAttribute('value');" value="1" class="btn btn-primary responder" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Responder</button>
                                                <br>
                                            </div>
                                        </div>
                                        <div class="media">
                                            <img class="mr-3" src="imagenes/ukp.png" width="50" height="50">
                                            <div class="media-body">
                                                <h5 class="mt-0">Media heading</h5>
                                                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                                                <br>
                                                <button type="button" onmouseover="idComentario = this.getAttribute('value');" value="2" class="btn btn-primary responder" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Responder</button>
                                                <br>
                                                <div class="media">
                                                    <img class="mr-3" src="imagenes/ukp.png" width="50" height="50">
                                                    <div class="media-body">
                                                        <h5 class="mt-0">Media heading</h5>
                                                        Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                                                        <button type="button" onmouseover="idComentario = this.getAttribute('value');" value="3" class="btn btn-primary responder" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Responder</button>
                                                    </div>                                        
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    -->
                                    <!--==================== FIN DE SECCION DE COMENTARIOS ====================-->
                                </div>							
                            </section>
                        </div> 
                    </section>	
                </div>
            </div>
        </div>
        
        <%@ include file='include/widgets.html' %>
        <%@ include file='include/footer.html' %>

        <script src="js/captura-comentario.js"></script>
        <script src="js/jquery-3.4.1.min_1.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/funciones.js"></script>
        <script src="js/consultar-video.js"></script>
    </body>
</html>
