<%-- 
    Document   : ModificarUsuario
    Created on : 09/10/2019, 07:29:35 PM
    Author     : administrador
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="Logica.Clases.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.Enumerados.Privacidad"%>
<%@page import="Logica.DataType.DtCanal"%>
<%@page import="Logica.DataType.DtUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    
    <script>
        var check = function() {
          if (document.getElementById('input_Contrasenia').value == document.getElementById('input_Repetir_contraseña').value) {
            document.getElementById('message').style.color = 'green';
            document.getElementById('message').innerHTML = 'Correcto';
            document.getElementById("btn_Registrarme").disabled = false;
            if (document.getElementById('input_Contrasenia').value == ""){
                document.getElementById('message').style.color = 'red';
                document.getElementById('message').innerHTML = 'Ingrese la contraseña';
                document.getElementById("btn_Registrarme").disabled = true;
            }
          } else {
            document.getElementById('message').style.color = 'red';
            document.getElementById('message').innerHTML = 'No son iguales';
            document.getElementById("btn_Registrarme").disabled = true;
          }
        }
    </script>
    
    <%
        DtUsuario usuario = (DtUsuario) request.getAttribute("usuario");
        DtCanal canal = (DtCanal) request.getAttribute("canal");
        boolean sesionIniciada = (boolean) request.getAttribute("sesionIniciada");
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
       	<link rel="stylesheet" type="text/css" href="css/contenido-alta-usuario.css">
        <link rel="stylesheet" type="text/css" href="iconos/style.css">

        <title>UyTube</title>
    </head>
    <body>

        <div class="container-fluid">
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
                        <%
                            if (sesionIniciada) {
                        %>
                        <%@ include file='include/menu-usuario.jsp' %>
                        <%                        } else {
                        %>
                        <%@ include file='include/menu-visitante.jsp' %>
                        <%
                            }
                        %>
                        <div class="contenido">
                            <section class="contenido-flexible">							
                                <div class="principal d-flex flex-row justify-content-center">
                                    <section class="d-flex  flex-lg-row flex-wrap justify-content-lg-between">					
                                        <form class="form-signin" action="/uytube/usuario-modificar" method="post">
                                            <h1 class="h3 mb-3 font-weight-normal" id="Texto_ingrese">Ingrese sus datos</h1><br>
                                            <input value="<%= usuario.getNickname()%>" class="form-control" type="text" name="nickname" readonly="readonly" placeholder="Nickname" id="input_Nickname" required><br>
                                            <div class="row">
                                                <div class="col-md-6 mb-3">
                                                    <input value="<%= usuario.getNombre()%>"  type="text" class="form-control" name="nombre" id="input_Nombre" placeholder="Nombre" required>
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <input value="<%= usuario.getApellido()%>" type="text" class="form-control" name="apellido" id="input_Apellido" placeholder="Apellido" required>
                                                </div>
                                            </div>
                                            <div class="mb-3">
                                                <input value="<%= usuario.getCorreo()%>" type="email" class="form-control" name="email" readonly="readonly" id="email" placeholder="Email" required>
                                            </div>
                                            <%
                                                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                                                String fecha = df.format(usuario.getFechaNacimiento());
                                            %>
                                            <input  value="<%= fecha%>" class="form-control" name="fechaNa" type="date" id="input_fecha" name="trip-start" readonly="readonly"><br>
                                            

                                            <input value="<%= usuario.getContrasenia()%>" class="form-control" type="password" name="password" placeholder="Contraseña" id="input_Contrasenia" onkeyup="check()" required><br>
                                            <input value="<%= usuario.getContrasenia()%>" class="form-control" type="password" placeholder="Repita contraseña" id="input_Repetir_contraseña" onkeyup="check()" required>
                                            <span id='message'></span>
                                            <%
                                                if (canal.getPrivacidad() == Privacidad.PUBLICO) {
                                            %> 
                                            <div class="d-block my-3">
                                                <label for="cc-name">Privacidad del canal</label>
                                                <div class="custom-control custom-radio">
                                                    <input id="publico" name="privacidad" value="PUBLICO" type="radio" class="custom-control-input" checked>
                                                    <label class="custom-control-label" for="publico">Publico</label>
                                                </div>
                                                <div class="custom-control custom-radio">
                                                    <input id="privado" name="privacidad" value="PRIVADO" type="radio" class="custom-control-input">
                                                    <label class="custom-control-label" for="privado">Privado</label>
                                                </div>
                                            </div>
                                            <hr class="mb-4">
                                            <%
                                                }
                                            %>

                                            <%
                                                if (canal.getPrivacidad() == Privacidad.PRIVADO) {
                                            %> 
                                            <div class="d-block my-3">
                                                <label for="cc-name">Privacidad del canal</label>
                                                <div class="custom-control custom-radio">
                                                    <input id="publico" name="privacidad" value="PUBLICO" type="radio" class="custom-control-input" >
                                                    <label class="custom-control-label" for="publico">Publico</label>
                                                </div>
                                                <div class="custom-control custom-radio">
                                                    <input id="privado" name="privacidad" value="PRIVADO" type="radio" class="custom-control-input" checked>
                                                    <label class="custom-control-label" for="privado">Privado</label>
                                                </div>
                                            </div>
                                            <hr class="mb-4">
                                            <%
                                                }
                                            %>

                                            <input value="<%= canal.getNombre()%>" class="form-control" name="canal" type="text" placeholder="Nombre del Canal" readonly="readonly" id="input_Nombre_canal" required><br>

                                            <textarea class="form-control" name="descripcion" id="input_descripcion" placeholder="Descripción del Canal" rows="3"> <%=canal.getDescripcion()%> </textarea>

                                            <br>   
                                            <label id="label_email">Imagen de perfil</label>	
                                            <div class="form-group">
                                                <input value="<%= usuario.getImagen()%>" name="imagen" id="input_Imagen_Perfil" type="file" class="file" multiple=false data-preview-file-type="any"><br>
                                            </div>


                                            <hr class="mb-4">

                                            <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                                <div class="btn-group mr-2" role="group" aria-label="Second group">
                                                    <button class="btn btn-lg btn-primary btn-block" type="submit" id="btn_Registrarme">Modificar usuario</button>
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