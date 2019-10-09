/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Selecciona el boton iniciar sesion
var btnIniciarSesion = document.getElementById("iniciar-sesion");
//Redirecciona a la pagina para iniciar sesion
btnIniciarSesion.addEventListener('click',function(){
    window.location.href = "/uytube/iniciar-sesion";
});
