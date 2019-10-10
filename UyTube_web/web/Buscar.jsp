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


                                    <!-- BOTONES DESPLEGABLES-->

                                    <%@ include file='include/filtro-visible.html' %>

                                    <!--FIN DE LOS BOTONES-->

                                    <hr class="mb-2">

                                    <!--LISTA DE CONTENIDO-->

                                    <div class="tab-pane fade show active" id="videos" role="tabpanel" aria-labelledby="nav-VIDEO-tab">

                                        <br><div class="lista bd-highlight">
                                            <div class="bd-highlight caja-imagen">
                                                <div class="bd-highlight ">
                                                    <img src="imagenes/lista.jpg" alt="lista">
                                                </div>
                                            </div>
                                            <div class=" bd-highlight caja-texto">
                                                <div class="overflow-auto bg-light" >
                                                    <h5 class="mt-0">Titulo de la Lista</h5>
                                                    <p>Descripcion de la lista: EMI Music Publish molestias nesciunt quisquam non et. Esse dolor natus nostrum eveniet eos. Eius facilis beatae dignissimos voluptate culpa placeat debitis est fuga! obcaecati molestias itaque tempora excepturi est minima provident qui, sit atque iusto. eaque officiis libero laborum accusamus quia praesentium porro architecto corrupti! Chappell, UNIAO BRASILEIRA DE EDITORAS DE MUSICA - UBEM, LatinAutor, ASCAP, LatinAutor - SonyATV y 4 sociedades de derechos musicales</p>
                                                </div>
                                            </div>
                                        </div><br>

                                        <div class="video bd-highlight">
                                            <div class="bd-highlight caja-imagen">
                                                <div class="bd-highlight">
                                                    <a href="/uytube/video-consulta&id=1234"><img src="https://i.ytimg.com/vi/OVjbqdm_JVI/hqdefault.jpg"></a>
                                                </div>
                                            </div>
                                            <div class="bd-highlight caja-texto">
                                                <div class="overflow-auto bg-light" >
                                                    <h5 class="mt-0">Titulo del video</h5>
                                                    <p>Descripcion del video: EMI Music Publishing, Warner Chappell, UNIAO BRASILEIRA DE EDITORAS DE MUSICA - UBEM, LatinAutor, ASCAP, LatinAutor - SonyATV y 4 sociedades de derechos musicales</p>
                                                </div>
                                            </div>
                                        </div><br>

                                        <div class="canal bd-highlight">
                                            <div class="bd-highlight caja-imagen">
                                                <div class="bd-highlight">
                                                    <img src="imagenes/mestruli.jpg" class="align-self-center rounded-circle" alt="Cinque Terre" >
                                                </div>
                                            </div>
                                            <div class="bd-highlight caja-texto">
                                                <div class="overflow-auto bg-light">
                                                    <h5 class="mt-0">Nombre del canal Lorem ipsum dolor sit amet consectetur adipisicing elit. Dicta, voluptate quis dolor sunt ea vero illo repellendus. Hic, ex quidem.</h5>
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