/* 
 * Código para los botones 
 *  Me gusta, No me gusta, Comentar, Cancelar, Agregar Lista Reproduccion
 */


//Boton me gusta
$("#btnLike").on('click',function(){
    var idVideo = $("#video").attr("value");
    $.post("video-consultar",
        {
          accion: "like",
          idVideo: idVideo
        }, function(respuesta, status){
        // Separa las dos cantidades recibidas
        var likes = respuesta.split(":")[0];
        var disLikes = respuesta.split(":")[1];
        // muestra las cantidades 
        $("#txtLike").text(likes);
        $("#txtDisLike").text(disLikes);
        
        // Actualiza los textos de los botones
        $("#txtMeGusta").text("TE GUSTA");
        $("#btnLike").attr("disabled", "true");
        $("#txtNoMeGusta").text("NO ME GUSTA");
        $("#btnDisLike").removeAttr("disabled");
    });
});

//boton no me gusta
$("#btnDisLike").on('click',function(){
    var idVideo = $("#video").attr("value");
    $.post("video-consultar",
        {
          accion: "disLike",
          idVideo: idVideo
        }, function(respuesta, status){
        // Separa las dos cantidades recibidas
        var likes = respuesta.split(":")[0];
        var disLikes = respuesta.split(":")[1];
        // muestra las cantidades 
        $("#txtLike").text(likes);
        $("#txtDisLike").text(disLikes);
        
        // Actualiza los textos de los botones
        $("#txtNoMeGusta").text("NO TE GUSTA");
        $("#btnDisLike").attr("disabled", "true");
        $("#txtMeGusta").text("ME GUSTA");
        $("#btnLike").removeAttr("disabled");
    });
});
