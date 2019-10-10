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
                        <%@ include file='include/menu-usuario.html' %>

                        <div class="contenido">
                            <section class="contenido-flexible">
                                
                                <div class="container">

                                    <div class="d-flex bd-highlight ">
                                        <div class="p-4 flex-fill bd-highlight">
                                            <div class="d-flex justify-content-center">
                                                <img src="imagenes/mestruli.jpg" class="rounded-circle" alt="Cinque Terre" width="180" height="180"> 
                                            </div>
                                        </div>
                                        <div class="p-1 flex-fill bd-highlight ">
                                            <div class="p-2 bd-highlight ">
                                                <br><h3>Maestruli Garrido</h3>
                                                <hr class="mb-1">
                                            </div>
                                            <div class="p-1 bd-highlight ">
                                                <div class="d-flex bd-highlight ">
                                                    <div class="p-1 flex-fill bd-highlight ">
                                                        <p class="text-info">El_Canal_ReLoco &#x2714</p>
                                                    </div>
                                                    <div class="p-1 flex-fill bd-highlight ">
                                                        <p>69,420,420.5 seguidores</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="p-1 bd-highlight ">
                                                <div class="d-flex bd-highlight ">
                                                    <div class="p-1 flex-fill bd-highlight ">
                                                        <p>PRIVACIDAD: PUBLICO</p>
                                                    </div>
                                                    <div class="p-1 flex-fill bd-highlight ">
                                                        <p>CATEGORIA: HUMOR</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div><br>

                                    <div class="bd-example bd-example-tabs">
                                        <nav class="">
                                            <div class="nav nav-tabs " id="nav-tab" role="tablist">
                                                <a class="nav-item nav-link active" id="refVideos" data-toggle="tab" href="#videos" role="tab" aria-controls="nav-VIDEO" aria-selected="true">VIDEOS</a>
                                                <a class="nav-item nav-link " id="refListas" data-toggle="tab" href="#listas" role="tab" aria-controls="nav-LISTAS" aria-selected="false">LISTAS</a>
                                                <a class="nav-item nav-link " id="refSeguidores" data-toggle="tab" href="#seguidores" role="tab" aria-controls="nav-SEGUIDORES" aria-selected="false">SEGUIDORES</a>
                                                <a class="nav-item nav-link " id="refSeguidos" data-toggle="tab" href="#seguidos" role="tab" aria-controls="nav-SEGUIDOS" aria-selected="false">SEGUIDOS</a>
                                            </div>
                                        </nav>
                                    </div>

                                    <div class="tab-content" id="nav-tabContent">
                                        <div class="tab-pane fade show active" id="videos" role="tabpanel" aria-labelledby="nav-VIDEO-tab">

                                            <br><div class="d-flex bd-highlight ">
                                                <div class="p-1 flex-shrink-1 bd-highlight ">
                                                    <div class="p-1 bd-highlight ">
                                                        <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/fepmsnGBwJo" allowfullscreen></iframe>
                                                    </div>
                                                </div>
                                                <div class="p-1 flex-shrink-1 bd-highlight ">
                                                    <div class="overflow-auto p-1 mb-3 mb-md-0 mr-md-3 bg-light" style="max-width: 530px; max-height: 170px;">
                                                        <h5 class="mt-0">NTVG A las nueve Letra</h5>
                                                        <p>DashGo/Audiobee, The Orchard Music (en nombre de Elefante Blanco); EMI Music Publishing, Warner Chappell, UNIAO BRASILEIRA DE EDITORAS DE MUSICA - UBEM, LatinAutor, ASCAP, LatinAutor - SonyATV y 4 sociedades de derechos musicales</p>
                                                    </div>
                                                </div>
                                            </div><br>

                                            <div class="d-flex bd-highlight ">
                                                <div class="p-1 flex-shrink-1 bd-highlight ">
                                                    <div class="p-1 bd-highlight ">
                                                        <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/9Ni-Eea8n48" allowfullscreen></iframe>
                                                    </div>
                                                </div>
                                                <div class="p-1 flex-shrink-1 bd-highlight ">
                                                    <div class="overflow-auto p-1 mb-3 mb-md-0 mr-md-3 bg-light" style="max-width: 530px; max-height: 170px;">
                                                        <h5 class="mt-0">El maestruli 10 horas</h5>
                                                        <p>DashGo/Audiobee, The Orchard Music (en nombre de Elefante Blanco); EMI Music Publishing, Warner Chappell, UNIAO BRASILEIRA DE EDITORAS DE MUSICA - UBEM, LatinAutor, ASCAP, LatinAutor - SonyATV y 4 sociedades de derechos musicales</p>
                                                    </div>
                                                </div>
                                            </div><br>

                                            <div class="d-flex bd-highlight ">
                                                <div class="p-1 flex-shrink-1 bd-highlight ">
                                                    <div class="p-1 bd-highlight ">
                                                        <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/v0YIROg_DSY" allowfullscreen></iframe>
                                                    </div>
                                                </div>
                                                <div class="p-1 flex-shrink-1 bd-highlight ">
                                                    <div class="overflow-auto p-1 mb-3 mb-md-0 mr-md-3 bg-light" style="max-width: 530px; max-height: 170px;">
                                                        <h5 class="mt-0">lamento boliviano-enanitos verdes (letra)</h5>
                                                        <p>DashGo/Audiobee, The Orchard Music (en nombre de Elefante Blanco); EMI Music Publishing, Warner Chappell, UNIAO BRASILEIRA DE EDITORAS DE MUSICA - UBEM, LatinAutor, ASCAP, LatinAutor - SonyATV y 4 sociedades de derechos musicales</p>
                                                    </div>
                                                </div>
                                            </div><br>





                                        </div>

                                        <div class="tab-pane fade show" id="listas" role="tabpanel" aria-labelledby="nav-LISTAS-tab">
                                            <br><ul class="list-group">
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    Ver mas tarde
                                                    <span class="badge badge-primary badge-pill">14 videos</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    Faboritos
                                                    <span class="badge badge-primary badge-pill">2 videos</span>
                                                </li><br>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    Maruja
                                                    <span class="badge badge-primary badge-pill">5 videos</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    Maruja 2
                                                    <span class="badge badge-primary badge-pill">2 videos</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    Maruja 3
                                                    <span class="badge badge-primary badge-pill">36 videos</span>
                                                </li>
                                            </ul>
                                        </div>

                                        <div class="tab-pane fade show " id="seguidores" role="tabpanel" aria-labelledby="nav-SEGUIDORES-tab">

                                            <br><ul class="list-group">
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    El_mafuba@242
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    Elsa_lame_23
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    Maruja_mela
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    profe_pol_vaso
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    Maruja420
                                                </li>
                                            </ul>
                                        </div>

                                        <div class="tab-pane fade show " id="seguidos" role="tabpanel" aria-labelledby="nav-SEGUIDOS-tab">


                                            <br><ul class="list-group">
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    TOTAL DE USUARIOS SEGUIDOS: 
                                                    <span class="badge badge-primary badge-pill">5</span>
                                                </li><br>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    El_mafuba@242
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    Elsa_lame_23
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    Maruja_mela
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    profe_pol_vaso	
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                                    Maruja420
                                                </li>
                                            </ul>
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