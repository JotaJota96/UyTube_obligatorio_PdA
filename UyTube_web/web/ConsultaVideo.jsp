<%-- 
    Document   : Buscar
    Created on : 09/10/2019, 07:55:42 PM
    Author     : administrador
--%>

<%@page import="Logica.Enumerados.Privacidad"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Logica.Enumerados.TipoValoracion"%>
<%@page import="Logica.DataType.DtValoracion"%>
<%@page import="org.eclipse.persistence.jpa.jpql.tools.model.query.DerivedPathVariableDeclarationStateObject"%>
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
        <div class="container-fluid" style="padding-left: 0; padding-right: 0px;">
            <div class="row">
                <div class="col-12">
                    <!-- Inclusion de la barra superior -->
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
                        <%                            }
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


                                    <!-- BOTONES PARA LIKE, DISLIKE y AGREGAR A LISTA-->
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
                                        <div class="p-2 btn-group mr-3" role="group" aria-label="Third group">                                            
                                            <button data-toggle="modal" type="button" id="btnAgregarALista" data-target="#ventanaModalAgregarALista" class="btn btn-info icon-add-to-list">
                                                LISTA DE REPRODUCCIÓN
                                            </button>
                                        </div>

                                        <%
                                            if (propietarioDelVideo) {
                                        %>
                                        <!-- Boton modificar video -->
                                        <div class="p-2 btn-group" role="group" aria-label="Third group">
                                            <a href="video-modificar?id=<%= video.getId()%>">
                                                <button type="button" id="btnModificarVideo" class="btn btn-primary icon-cog mr-2">
                                                    MODIFICAR
                                                </button>
                                            </a>
                                            <button href="#ventanaModalValoraciones" data-toggle="modal" type="button" id="btnListarValoraciones" class="btn btn-info icon-info-with-circle">
                                                QUIÉN VALORÓ
                                            </button>
                                        </div>
                                        <%
                                            }
                                        %>

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
                                            <a href="usuario-consultar?id=<%= usuario.getNickname()%>">
                                                <h5><%= canal.getNombre()%></h5>
                                            </a>
                                        </div>
                                    </div>
                                    <br>

                                    <!-- DESCRIPCION DEL VIDEO -->
                                    <div class="bd-highlight" >
                                        <h5>Fecha de publicación: <%= new SimpleDateFormat("dd/MM/yyyy").format(video.getFechaPublicacion())%></h5>
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
                                                    <button type="button" id="btnCancelar" class="btn btn-danger">CANCELAR</button>
                                                </div> 
                                                <div class="p-2 btn-group" role="group" aria-label="Third group">
                                                    <button type="button" id="btnComentar" class="btn btn-success">COMENTAR</button>
                                                </div>  
                                            </div>
                                        </div>
                                    </div>
                                    <%
                                        }
                                    %>
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

        <!-- Tabla emergente de valoraciones -->
        <%
            if (propietarioDelVideo) {
        %>
        <div class="modal fade" id="ventanaModalValoraciones">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title">Valoraciones</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    </div>
                    <table class="table table-striped table-fixed" id="tblValoraciones">
                        <thead id="tblHead">
                            <tr>
                                <th>Usuario</th>
                                <th>Valoración</th>
                            </tr>
                        </thead>
                        <tbody id="tblValoraciones-bodyRows">
                            <!-- El contenido es obtenido por jQuery -->
                        </tbody>
                    </table>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <%
            }
        %>
        <!-- FIN de Tabla emergente de valoraciones -->

        <style>
            .table-fixed tbody {
                display:block;
                height:250px; /* Altura a la cual aparece el scroll */
                overflow:auto;
            }
            .table-fixed thead, .table-fixed tbody tr {
                display:table;
                width:100%;
            }
        </style>

        <!-- Modal Agregar a lista de reproduccion -->
        <%    
            if (sesionIniciada){
        %>
        <div class="modal fade" id="ventanaModalAgregarALista" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalScrollableTitle">Guardar en ...</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <% 
                            IUsuario sys = Fabrica.getInstancia().getIUsuario();
                            String idLista, nombreList, icono, checked, idCheckbox; 
                            sys.seleccionarUsuario(sys.obtenerUsuarioActual().getNickname());
                            for (DtListaDeReproduccion dl : listas) {
                                idLista = String.valueOf(dl.getId());
                                idCheckbox = "checkbox"+idLista;
                                nombreList = dl.getNombre();
                                if( dl.getPrivacidad() == Privacidad.PRIVADO){
                                    icono = "icon-lock1";
                                }else{
                                    icono = "icon-earth";
                                }
                                sys.seleccionarListaDeReproduccion(dl.getId());
                                checked = "";
                                for (DtVideo dv : sys.listarVideosDeListaDeReproduccion()) {
                                    if( video.getId() == dv.getId()){
                                        checked = "checked";
                                        break;
                                    }
                                }    
                        %>
                        <div class="form-check">
                            <input class="form-check-input checkLista" type="checkbox" <%= checked %> value="<%= idLista %>" id="<%=idCheckbox%>">
                            <label class="form-check-label" for="<%=idCheckbox%>"><%= nombreList %> <span class="<%= icono%>"></span></label>
                        </div>
                        <%
                            }
                            sys.seleccionarUsuario(sys.obtenerPropietarioDeVideo(video.getId()).getNickname());
                        %>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info" data-dismiss="modal">Cerrar</button>

                    </div>
                </div>
            </div>
        </div>

        <%
            }
        %>
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
