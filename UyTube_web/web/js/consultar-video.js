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

//Comentar video
$("#btnComentar").on('click',function(){
    var texto = $("#input_descripcion");
    var idVideo = $("#video").attr("value");
    if(texto.val().length <= 0 ){
        alert("¡El campo comentario está vacío!");
    }else{
        idVideo = $("#video").attr("value");
        $.post("video-consultar",{
            accion: "comentarVideo",
            texto: texto.val(),
            idVideo: idVideo
            }, 
            function(respuesta, status){
                $("#input_descripcion").val('');
                $("#seccion-comentarios").html(respuesta);
        });
    }    
});

$("#btnCancelar").on('click',function(){
    $("#input_descripcion").val("");
});

//boton agregar a lista de reproduccion
var agregarALista = function(){
    //$("#agregarALista .close").click(); //Cierra el modal
    //alert($("#defaultCheck1").value());
    alert("Diste click");
    // $.post("video-consultar",
    //     {
    //       accion: "agregarALista" 
    //     }, function(respuesta, status){
        
    // });
};

// Checkbox para agregar o quitar de la Lista de Reproduccion
$(".checkLista").on('change', function(){
    var id_video = $("#video").attr("value");
    var id_lista = $(this).val();
    if($(this).prop('checked') == true){  
        $.post("video-consultar",
        {
          accion: "agregarALista",
          idVideo: id_video,
          idLista: id_lista
        }, function(respuesta, status){
            if(respuesta != "ok"){
                alert("No se ha podido agregar el video a la lista.")
            }
        });
       
    }else{
        $.post("video-consultar",
        {
          accion: "quitarDeLista",
          idVideo: id_video,
          idLista: id_lista
        }, function(respuesta, status){
            if(respuesta != "ok"){
                alert("No se ha podido quitar el video de la lista.")
            }
        });
    }
});

//boton agregar lista de reproduccion
$("#btnListarValoraciones").on('click',function(){
    // obtengo el id del video
    var idVideo = $("#video").attr("value");
    // mando una peticion post a esa ruta con los parametros entre {}, 
    // y defino una funcion callback (ejecuta al recibir respuesta
    $.post("video-consultar",
        {
          accion: "listarValoraciones" ,
            idVideo: idVideo
        }, function(respuesta, status){
            // esta variable contrendra el htm de las nuevas filas
            var nuevasFilas = '';
            // esta variable es un array con los pares (usuario:valoracion)
            // cada par viene en la respuesta separado por punto y coma
            var filasObtenidas = respuesta.split(";");
            // itero sobre los elementos del array (el ultimo es vacio, por eso el -1)
            for (var i = 0; i < filasObtenidas.length -1; i++){
                // esta variable es un array en cuyo indice 0 esta el nickname de un usuario y en el 1 su valoracion
                var fila = (filasObtenidas[i]).split(":");
                // esta variable sera la fila procesada en esta iteracion, y contendra las dos celdas
                var tr = '';
                tr += '<tr>\n';
                tr += '<td>' + fila[0] + '</td>\n';
                tr += '<td>' + fila[1] + '</td>\n';
                tr += '</tr>\n';
                // concatena la nueva fila con las filas ya procesadas
                nuevasFilas += tr;
            }
            // reemplaza el contenido de la etiqueta <body> con los nuevos datos
           $("#tblValoraciones-bodyRows").html(nuevasFilas);
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
            $.post("video-consultar",{
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
