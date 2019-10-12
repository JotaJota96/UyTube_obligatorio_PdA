/* 
 * Código para los botones 
 *  Me gusta, No me gusta, Comentar, Cancelar, Agregar Lista Reproduccion
 */


//Boton me gusta
$("#btnLike").on('click',function(){
    var idVideo = $("#video").attr("value");
    $.post("/uytube/video-consultar",
        {
          accion: "like",
          idVideo: idVideo
        }, function(respuesta, status){
        $("#txtLike").text(respuesta);
    });
});

//boton no me gusta
$("#btnDisLike").on('click',function(){
    var idVideo = $("#video").attr("value");
    $.post("/uytube/video-consultar",
        {
          accion: "disLike",
          idVideo: idVideo
        }, function(respuesta, status){
        $("#txtDisLike").text(respuesta);
    });
});

//Comentar video
$("#btnComentar").on('click',function(){
    var texto = $("#input_descripcion");
    var idVideo = $("#video").attr("value");
    if(texto.val().length <= 0 ){
        alert("¡El campo comentario está vacío!");
    }else{
        idVideo = $("#video").attr("value");
        $.post("/uytube/video-consultar",{
            accion: "comentarVideo",
            texto: texto.val(),
            idVideo: idVideo
            }, 
            function(respuesta, status){
                alert("Su comentario ha sido agregado.");
                $("#input_descripcion").val('');
                $("#seccion-comentarios").html(respuesta);
        });
    }    
});

$("#btnCancelar").on('click',function(){
    $("#input_descripcion").val("");
});

//boton agregar lista de reproduccion
$("#btnAgregarALista").on('click',function(){
    $.post("/uytube/video-consultar",
        {
          accion: "agregarALista" 
        }, function(respuesta, status){
        alert(respuesta);
    });
});


//Responeder comentarios, se dispara luego de la ventana modal
var responderComentario = function(){    
        $("#exampleModal .close").click(); //Cierra el modal
        var texto= $('#txtResponder').val(); 
        var idVideo = $("#video").attr("value");
        
        if(texto.length <= 0 ){
            alert("¡El campo comentario está vacío!");
        }else{
            var idVideo = $("#video").attr("value"); 
            console.log("texto: "+texto+", idVideo: "+idVideo+" idComentario: "+idComentario);         
            $.post("/uytube/video-consultar",{
                accion: "responderComentario",
                texto: texto,
                idVideo: idVideo,
                idComentario: idComentario
                }, 
                function(respuesta, status){
                    //$("#seccion-comentarios").remove();
                    $("#seccion-comentarios").html(respuesta);
                    $('#txtResponder').val('');
                    idComentario = "";
            });
        }    
    
};
