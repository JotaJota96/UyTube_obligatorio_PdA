
//Lee lo que se escribe en el campo usuario
$("#input_Nickname").keyup(function(){
    //Obtiene el valor ingresaro
    var valorIngresado = $("#input_Nickname").val();
    $("#input_Nombre_canal").val($("#input_Nickname").val());
    
    //Realiza la consulta utilizando AJAX al servidor
    $.get("/uytube/consultar",
        {
          dato: valorIngresado,
          accion: "validarNickname" 
        }, function(respuesta, status){
        //alert("Data: " + respuesta + "\nStatus: " + status);
        $("#msjNickname").text(respuesta);
    });
}); 


//Lee lo que se escribe en el campo usuario
$("#email").keyup(function(){
    //Obtiene el valor ingresaro
    var valorIngresado = $("#email").val();
    
    //Realiza la consulta utilizando AJAX al servidor
    $.get("/uytube/consultar",
        {
          dato: valorIngresado,
          accion: "validarEmail" 
        }, function(respuesta, status){
        //alert("Data: " + respuesta + "\nStatus: " + status);
        $("#msjEmail").text(respuesta);
    });
}); 

