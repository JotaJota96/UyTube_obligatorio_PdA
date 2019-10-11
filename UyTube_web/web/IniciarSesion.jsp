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
                    <%@ include file='include/header-visitante.html' %>
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
                                        <form class="form-signin" action="/uytube/inicio-sesion" method="post">
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

                                            <a href="/uytube/usuario-agregar" >Registrase</a>

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
    </body>
</html>