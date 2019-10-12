<%-- 
    Document   : Buscar
    Created on : 09/10/2019, 07:55:42 PM
    Author     : administrador
--%>

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

                    <%@ include file='include/header-visitante.jsp' %>



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
                        <%@ include file='include/menu-visitante.jsp' %>

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
                                            <h5>Las_pindongas_playList</h5>
                                            <h5>PARTICULAR</h5>
                                            <h5>PÚBLICA</h5>
                                            <h5>MUSICA</h5> 
                                        </div>
                                        <div class="p-2 d-flex align-items-end">
                                            <button type="button" class="btn btn-primary">Modificar</button>
                                        </div>
                                    </div>
                                    
                                    <!--FIN INFORMACION LISTA.REP-->
                                    <hr>
                                    <h3>VIDEOS:</h3>


                                    <!--LISTA DE CONTENIDO-->

                                    <div class="tab-pane fade show active" id="videos" role="tabpanel" aria-labelledby="nav-VIDEO-tab">
                                        <!--PRIMER VIDEO-->
                                        <div class="video">
                                            <div class="bd-highlight caja-imagen">
                                                <div class="bd-highlight">
                                                    <a href="#">
                                                        <img src="imagenes/ukp.jpg" width="246" height="138">
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="bd-highlight caja-texto justify-content-start">
                                                <div class="bg-light" >
                                                    <h5 class="mt-0">
                                                        <a href="#">

                                                        </a>
                                                    </h5>
                                                    <h4>Descripcion:</h4>
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                                </div>
                                            </div>
                                        </div>
                                        <!--SEGUNDO VIDEO-->
                                        <div class="video">
                                            <div class="bd-highlight caja-imagen">
                                                <div class="bd-highlight">
                                                    <a href="#">
                                                        <img src="imagenes/ukp.jpg" width="246" height="138">
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="bd-highlight caja-texto justify-content-start">
                                                <div class="bg-light" >
                                                    <h5 class="mt-0">
                                                        <a href="#">

                                                        </a>
                                                    </h5>
                                                    <h4>Descripcion:</h4>
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                                </div>
                                            </div>
                                        </div>
                                        <br>                 
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