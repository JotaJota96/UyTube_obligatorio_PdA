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
        <title>UyTube - Mod.Lista</title>
    </head>
    <body>

        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <!-- Inclusion de la barra superior -->
                    <%@ include file='include/header-usuario.html' %>
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
                        <!-- Inclusion del menu lateral -->
                        <%@ include file='include/menu-usuario.html' %>
                        <div class="contenido">
                            <section class="contenido-flexible">								
                                <div class="container">
                                    <br>
                                    <h4>Listas de reproducción particulares del usuario</h4>
                                    <br>
                                    <!-- Inicio de las Listas-->
                                    <ul class="list-group">
                                        <!-- Lista por defecto -->
                                        <li class="list-group-item  list-group-item-danger">Este usuario no tiene Listas particulares</li>
                                        <br>
                                        <!-- Lista 1 -->
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            Cras justo odio
                                            <div class="row">
                                                <div class="col-md-6 custom-control custom-radio">
                                                    <input id="publico_1" name="privacidad_1" type="radio" class="custom-control-input" checked >
                                                    <label class="custom-control-label" for="publico_1">Publico</label>
                                                </div>
                                                <div class="col-md-6 custom-control custom-radio">
                                                    <input id="privado_1" name="privacidad_1" type="radio" class="custom-control-input" >
                                                    <label class="custom-control-label" for="privado_1">Privado</label>
                                                </div>
                                            </div>
                                            <div class=" bd-light">
                                                <select class="custom-select d-block w-100" name="categoria" id="categoria" required>
                                                    <option value="">Categoria</option>
                                                    <option>Musica</option>
                                                    <option>Deportes</option>
                                                    <option>Entretenimiento</option>
                                                </select>
                                            </div>
                                        </li>
                                        <!-- Lista 2 -->
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            Cras justo odio
                                            <div class="row">
                                                <div class="col-md-6 custom-control custom-radio">
                                                    <input id="publico_2" name="privacidad_2" type="radio" class="custom-control-input" checked >
                                                    <label class="custom-control-label" for="publico_2">Publico</label>
                                                </div>
                                                <div class="col-md-6 custom-control custom-radio">
                                                    <input id="privado_2" name="privacidad_2" type="radio" class="custom-control-input" >
                                                    <label class="custom-control-label" for="privado_2">Privado</label>
                                                </div>
                                            </div>
                                            <div class=" bd-light">
                                                <select class="custom-select d-block w-100" name="categoria" id="categoria" required>
                                                    <option value="">Categoria</option>
                                                    <option>Musica</option>
                                                    <option>Deportes</option>
                                                    <option>Entretenimiento</option>
                                                </select>
                                            </div>
                                        </li>
                                        <!-- Lista n -->
                                    </ul>
                                    <!-- Fin de las listas. -->
                                    <br>
                                    <hr class="mb-2">
                                    <br>
                                    <!-- BOTONES (ACEPTAR / CANCELAR) -->
                                   
                                    <div class="bd-light " >
                                        <div class="btn-toolbar justify-content-end" role="toolbar" aria-label="Toolbar with button groups">
                                            <div class="p-2 btn-group mr-2" role="group" aria-label="Third group">
                                                <button type="button" class="btn btn-danger">CANCELAR</button>
                                            </div> 
                                            <div class="p-2 btn-group" role="group" aria-label="Third group">
                                                <button type="button" class="btn btn-primary">ACEPTAR</button>
                                            </div>  
                                        </div>
                                    </div>
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