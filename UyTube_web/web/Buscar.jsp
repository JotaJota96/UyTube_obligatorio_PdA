<%-- 
    Document   : ConsultaUsuario
    Created on : 07/10/2019, 01:25:13 AM
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
        <link rel="stylesheet" type="text/css" href="css/contenido-consulta-usuario.css">
        <link rel="stylesheet" type="text/css" href="iconos/style.css">
        <link rel="icon" type="image/png" href="imagenes/icono.png" />
        <title>UyTube</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <header class="header">
                        <nav>
                            <div class="navbar-dark item-header item-header1" id="navLogo">
                                <label class="icon-menu1"></label>
                                <img class="fotoLogo" src="imagenes/logoChico.jpeg" alt="UyTube">					
                            </div>	
                            <div class="navbar-dark item-header item-header2">					  
                                <div id="navbarSupportedContent">		
                                    <form class="form-inline my-2 my-lg-0 formBuscar" id="formBuscar">
                                        <input class=" mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                                        <button class="btn btn-primary" id="btnBuscar" type="submit">Buscar</button>
                                    </form>
                                </div>
                            </div>
                            <div class="perfil item-header item-header3">
                                <!--<div class="flex-row justify-content-lg-space-between alig-content-center m-1">
                                    <p class="pr-2 pt-4" id="nombrePerfil">Homero Simpson</p>
                                </div>					  
                                <div>
                                    <img id="fotoPerfil" src="imagenes/homero.jpg" alt="Perfil">
                                </div> -->
                                <button type="button" id="iniciar-sesion" class="btn btn-outline-primary"><span class="icon-user-tie"></span> INICIAR SESIÓN</button>
                            </div>
                        </nav>					
                    </header>
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

                                    <div class="d-flex bd-highlight ">
                                        <div class="p-2 bd-highlight ">
                                            <h4>Tipo de contenido</h4>
                                        </div>
                                        <div class="p-1 bd-highlight ">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-primary mr-5 dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    Seleccionar
                                                </button>
                                                <div class="dropdown-menu">
                                                    <a class="dropdown-item" href="#">TODO</a>
                                                    <div class="dropdown-divider"></div>
                                                    <a class="dropdown-item" href="#">CANALES</a>
                                                    <a class="dropdown-item" href="#">VIDEO</a>
                                                    <a class="dropdown-item" href="#">LISTAS</a>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="p-2 bd-highlight ">
                                            <h4>Oredenado por</h4>
                                        </div>
                                        <div class="p-1 bd-highlight ">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    Seleccionar
                                                </button>
                                                <div class="dropdown-menu">
                                                    <a class="dropdown-item" href="#">ALFABETO</a>
                                                    <a class="dropdown-item" href="#">FECHA</a>
                                                </div>
                                            </div>
                                        </div>	
                                    </div>

                                    <!--FIN DE LOS BOTONES-->

                                    <hr class="mb-2">

                                    <!--LISTA DE CONTENIDO-->

                                    <div class="tab-pane fade show active" id="videos" role="tabpanel" aria-labelledby="nav-VIDEO-tab">

                                        <br><div class="Elemento_Lista d-flex bd-highlight ">
                                            <div class="p-1 flex-shrink-1 bd-highlight ">
                                                <div class="p-1 bd-highlight ">
                                                    <img src="imagenes/lista.jpg" alt="lista" width="300" height="160">
                                                </div>
                                            </div>
                                            <div class="p-1 flex-shrink-1 bd-highlight ">
                                                <div class="overflow-auto p-1 mb-3 mb-md-0 mr-md-3 bg-light" style="max-width: 530px; max-height: 170px;">
                                                    <h5 class="mt-0">Titulo de la Lista</h5>
                                                    <p>Descripcion de la lista: EMI Music Publishing, Warner Chappell, UNIAO BRASILEIRA DE EDITORAS DE MUSICA - UBEM, LatinAutor, ASCAP, LatinAutor - SonyATV y 4 sociedades de derechos musicales</p>
                                                </div>
                                            </div>
                                        </div><br>

                                        <div class="Elemento_Video d-flex bd-highlight ">
                                            <div class="p-1 flex-shrink-1 bd-highlight ">
                                                <div class="p-1 bd-highlight ">
                                                    <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/9Ni-Eea8n48" allowfullscreen></iframe>
                                                </div>
                                            </div>
                                            <div class="p-1 flex-shrink-1 bd-highlight ">
                                                <div class="overflow-auto p-1 mb-3 mb-md-0 mr-md-3 bg-light" style="max-width: 530px; max-height: 170px;">
                                                    <h5 class="mt-0">Titulo del video</h5>
                                                    <p>Descripcion del video: EMI Music Publishing, Warner Chappell, UNIAO BRASILEIRA DE EDITORAS DE MUSICA - UBEM, LatinAutor, ASCAP, LatinAutor - SonyATV y 4 sociedades de derechos musicales</p>
                                                </div>
                                            </div>
                                        </div><br>

                                        <div class="Elemento_Canal d-flex bd-highlight ">
                                            <div class="p-1 flex-shrink-1 bd-highlight ">
                                                <div class="p-1 bd-highlight ">
                                                    <img src="imagenes/mestruli.jpg" class="align-self-center rounded-circle" alt="Cinque Terre" width="180" height="180">
                                                </div>
                                            </div>
                                            <div class="p-1 flex-shrink-1 bd-highlight ">
                                                <div class="overflow-auto p-1 mb-3 mb-md-0 mr-md-3 bg-light" style="max-width: 530px; max-height: 170px;">
                                                    <h5 class="mt-0">Nombre del canal</h5>
                                                    <p>Descripcion del canal: EMI Music Publishing, Warner Chappell, UNIAO BRASILEIRA DE EDITORAS DE MUSICA - UBEM, LatinAutor, ASCAP, LatinAutor - SonyATV y 4 sociedades de derechos musicales</p>
                                                </div>
                                            </div>
                                        </div><br>  
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