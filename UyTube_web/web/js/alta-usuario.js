
//Lee lo que se escribe en el campo usuario
$("#input_Nickname").keyup(function(){
    //Obtiene el valor ingresaro
    var valorIngresado = $("#input_Nickname").val();
    //Realiza la consulta utilizando AJAX al servidor
    $.get("/uytube/consultar",
        {
          nombre: valorIngresado,
          accion: validarNombre 
        }, function(respuesta, status){
        //alert("Data: " + respuesta + "\nStatus: " + status);
        $("#msjNickname").text(respuesta);
    });
    
}); 




