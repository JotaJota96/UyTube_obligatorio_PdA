<%-- 
    Document   : IniciarSesion
    Created on : 02/10/2019, 09:01:59 AM
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
        <link rel="stylesheet" type="text/css" href="css/contenido-iniciar-sesion.css">	
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
                                <!-- <div class="flex-row justify-content-lg-space-between alig-content-center m-1">
                                        <p class="pr-2 pt-4" id="nombrePerfil">Homero Simpson</p>
                                </div>					  
                                <div>
                                        <img id="fotoPerfil" src="imagenes/homero.jpg" alt="Perfil">
                                </div> -->
                                <button type="button" id="btnRegistrarse" class="btn btn-outline-primary"><span class="icon-user-tie"></span> Registrarse</button>
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
                        <aside class="menu" >							
                            <ul>
                                <li>
                                    <span>
                                        <label class="icon-menu1"></label>
                                        <img class="fotoLogo" src="imagenes/logoChico.jpeg" alt="UyTube">
                                    </span>		
                                </li>							
                                <li><a href="#"><span class="icon-user"></span> Mi Perfil</a></li>
                                <li class="titulo">VIDEOS</li>
                                <li><a href=""><span class="icon-upload3"></span> Subir video</a></li>
                                <li><a href=""><span class="icon-video-camera"></span> Ver videos</a></li>
                                <li class="titulo">LISTAS</li>
                                <li><a href=""><span class="icon-add-to-list"></span> Crear lista</a></li>
                                <li><a href="">Ver más tarde</a></li>
                                <li><a href=""><span class="icon-like"></span> Me gusta</a></li>
                                <li><a href="">Música para estudiar</a></li>
                                <li class="titulo">CATEGORIAS</li>
                                <li><a href="">Música</a></li>
                                <li><a href="">Juegos</a></li>
                                <li><a href="">Deportes</a></li>
                                <li class="salir"><a href=""><span class="icon-exit"></span> SALIR</a></li>
                            </ul>					  
                        </aside>

                        <div class="contenido">
                            <section class="contenido-flexible">									
                                <div class="principal d-flex flex-row justify-content-center">
                                    <section class="d-flex  flex-lg-row flex-wrap justify-content-lg-between">	
                                        <form class="form-signin" action="validar-login" method="post">
                                            <img class="mb-4" src="imagenes/UyTubeAlfa.png" alt="UyTube" >
                                            <h1 class="h3 mb-3 font-weight-normal" id="Texto_ingrese">Ingrese por favor</h1>
                                            <label for="inputEmail" class="sr-only" id="label_email">Nickname/Email</label>
                                            <input type="text"name="user" id="txtUsuario" class="form-control mb-4" placeholder="nickname/email" required autofocus>
                                            <label for="inputPassword" name="password" class="sr-only" id="label_contrasenia">Contraseña</label>
                                            <input type="password" name="password" id="input_contraseña" class="form-control mb-4" placeholder="Contraseña" required>
                                            <div class="checkbox mb-3">
                                                <label>
                                                    <input type="checkbox" value="remember-me" id="check_recuerdarme"> Recuerdarme
                                                    <p id="mitexto"></p>
                                                </label>
                                            </div>
                                            <button class="btn btn-lg btn-primary btn-block mb-4" type="submit" id="btn_Ingresar">Ingresar</button>

                                            <a href="/uytube/alta-usuario" >Registrase</a>

                                            <br><br>
                                            <p class="mt-5 mb-3 text-muted" id="texto_copy">&copy; 2019-2020</p>
                                            
                                        </form>	
                                    </section>
                                </div>										
                            </section>
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
        <<script src="js/iniciar-sesion.js"></script>
    </body>
</html>