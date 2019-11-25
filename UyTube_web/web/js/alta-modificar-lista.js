$("#nombreLista").keyup(function(){
    var valorIngresado = $("#nombreLista").val();
    
    $.get("consultar",
        {
          accion: "validarNombreLista",
          dato: valorIngresado
        }, function(respuesta, status){
        $("#msjNombre").text(respuesta);
    });
}); 
