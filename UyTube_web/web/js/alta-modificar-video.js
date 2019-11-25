$("#inputNombre").keyup(function(){
    var idVideo = $("#inputNombre").attr("idVideo");
    var valorIngresado = $("#inputNombre").val();
    
    if (idVideo === undefined){
        idVideo = 0;
    }
    
    $.get("consultar",
        {
          idVideo: idVideo,
          accion: "validarNombreVideo",
          dato: valorIngresado
        }, function(respuesta, status){
        $("#msjNombre").text(respuesta);
    });
}); 
