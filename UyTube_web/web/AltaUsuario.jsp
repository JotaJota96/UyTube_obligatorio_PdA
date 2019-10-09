<%-- 
    Document   : AltaUsuario
    Created on : 06/10/2019, 11:40:19 PM
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
        <link rel="stylesheet" type="text/css" href="css/principal.css">
        <link rel="stylesheet" type="text/css" href="css/menu.css">
        <link rel="stylesheet" type="text/css" href="css/widget.css">
        <link rel="stylesheet" type="text/css" href="css/footer.css">
        <link rel="stylesheet" type="text/css" href="css/contenido-alta-usuario.css">
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
                        <%@ include file='include/menu-visitante.html' %>
                        <div class="contenido">
                            <section class="contenido-flexible">							
                                <div class="principal d-flex flex-row justify-content-center">
                                    <section class="d-flex  flex-lg-row flex-wrap justify-content-lg-between">					
                                        <form class="form-signin">

                                            <h1 class="h3 mb-3 font-weight-normal" id="Texto_ingrese">Complete el formulario por favor</h1><br>

                                            <input class="form-control" type="text" placeholder="Nickname" id="input_Nickname" required><span id="msjNickname"></span> <br>
                                            <div class="row">
                                                <div class="col-md-6 mb-3">
                                                    <input type="text" class="form-control" id="input_Nombre" placeholder="Nombre" value="" required>
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <input type="text" class="form-control" id="input_Apellido" placeholder="Apellido" value="" required>
                                                </div>
                                            </div>


                                            <div class="mb-3">
                                                <input type="email" class="form-control" id="email" placeholder="Email">
                                            </div>

                                            <input class="form-control" type="date" id="input_fecha" name="trip-start"><br>
                                            <input class="form-control" type="password" placeholder="Contraseña" id="input_Contraseña" required><br>
                                            <input class="form-control" type="password" placeholder="Repetir contraseña" id="input_Repetir_contraseña" required>

                                            <div class="d-block my-3">
                                                <label for="cc-name">Privacidad del canal</label>
                                                <div class="custom-control custom-radio">
                                                    <input id="publico" name="paymentMethod" type="radio" class="custom-control-input" checked required>
                                                    <label class="custom-control-label" for="publico">Publico</label>
                                                </div>
                                                <div class="custom-control custom-radio">
                                                    <input id="privado" name="paymentMethod" type="radio" class="custom-control-input" required>
                                                    <label class="custom-control-label" for="privado">Privado</label>
                                                </div>
                                            </div>
                                            <hr class="mb-4">

                                            <input class="form-control" type="text" placeholder="Nombre del Canal" id="input_Nombre_canal" required>
                                            <small class="text-muted">Opcional*</small><br><br>

                                            <textarea class="form-control" id="input_descripcion" placeholder="Descripción del Canal" rows="3"></textarea>
                                            <small class="text-muted">Opcional*</small><br><br>

                                            <div class="form-group">
                                                <select class="custom-select d-block w-100" id="categoria" required>
                                                    <option value="">Categoria</option>
                                                    <option>Musica</option>
                                                    <option>Deportes</option>
                                                    <option>Entretenimiento</option>
                                                </select>
                                                <small class="text-muted" >Opcional*</small><br>
                                            </div>

                                            <label id="label_email">Imagen de perfil</label>	
                                            <div class="form-group">
                                                <input id="input_Imagen_Perfil" type="file" class="file" multiple=false data-preview-file-type="any"><br>
                                                <small class="text-muted">Opcional*</small>
                                            </div>


                                            <hr class="mb-4">

                                            <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                                <div class="btn-group mr-2" role="group" aria-label="First group">
                                                    <button class="btn btn-lg btn-primary btn-block" type="reset" id="btn_Limpiar">Limpiar</button>
                                                </div>
                                                <div class="btn-group mr-2" role="group" aria-label="Second group">
                                                    <button class="btn btn-lg btn-primary btn-block" type="submit" id="btn_Registrarme">Registrarme</button>
                                                </div>
                                            </div>

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

        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/funciones.js"></script>
        <<script src="js/alta-usuario.js"></script>
    </body>
</html>