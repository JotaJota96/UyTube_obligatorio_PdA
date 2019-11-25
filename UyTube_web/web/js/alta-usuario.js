
//Lee lo que se escribe en el campo usuario
$("#input_Nickname").keyup(function(){
    //Obtiene el valor ingresaro
    var valorIngresado = $("#input_Nickname").val();
    $("#input_Nombre_canal").val($("#input_Nickname").val());
    
    //Realiza la consulta utilizando AJAX al servidor
    $.get("consultar",
        {
          dato: valorIngresado,
          accion: "validarNickname" 
        }, function(respuesta, status){
        //alert("Data: " + respuesta + "\nStatus: " + status);
        $("#msjNickname").text(respuesta);
        if(respuesta == "Este nickname no está disponible"){
          $("#msjNickname").css("color","#dc3545");
        }
    });
}); 


//Lee lo que se escribe en el campo usuario
$("#email").keyup(function(){
    //Obtiene el valor ingresaro
    var valorIngresado = $("#email").val();
    
    //Realiza la consulta utilizando AJAX al servidor
    $.get("consultar",
        {
          dato: valorIngresado,
          accion: "validarEmail" 
        }, function(respuesta, status){
        //alert("Data: " + respuesta + "\nStatus: " + status);
        $("#msjEmail").text(respuesta);
        $("#msjEmail").css("color","#dc3545");
    });
}); 

var check = function () {
  if (document.getElementById('input_Contrasenia').value ==document.getElementById('input_Repetir_contraseña').value) {
      document.getElementById('message').style.color = 'green';
      document.getElementById('message').innerHTML = 'Correcto';
      document.getElementById("btn_Registrarme").disabled = false;
      if (document.getElementById('input_Contrasenia').value == ""){
          document.getElementById('message').style.color = '#dc3545';
          document.getElementById('message').innerHTML = 'Ingrese la contraseña';
          document.getElementById("btn_Registrarme").disabled = true;
      }
  } else {
      document.getElementById('message').style.color = '#dc3545';
      document.getElementById('message').innerHTML = 'No son iguales';
      document.getElementById("btn_Registrarme").disabled = true;
  }
}

var borrar = function(){
  $("#message").text("");
  $("#input_Contrasenia").val("");
  $("#input_Repetir_contraseña").val("");
};