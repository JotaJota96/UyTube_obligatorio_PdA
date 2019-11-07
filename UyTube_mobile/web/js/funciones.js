
// Muestra u oculta el menu y ajusta su posicion en altura
$(".icon-menu1").on("click", function () {
    $(".menu").toggleClass('abrir');
    // screenHeight = $(window).height();
    // altoHeader = parseFloat($(".header").css('height'));
    // altoMenu = parseFloat($(".menu").css('height'));
    // if(screenHeight < (altoHeader+altoMenu) ){
    //     console.log('el alto de menu es superior a la pantalla');
    //     $(".menu").css('height',(screenHeight-altoHeader));
    // }else{
    //    // $(".menu").css('height:350px');
    //     console.log('el alto de menu es: '+ $(".menu").css('height:350px'));
    // }
    // console.log(" alto de pantalla: " + screenHeight+", alto del menu: "+altoMenu);
});

/*
$(".icon-menu1").on("click", function(){
    var posicion = $(".icon-menu1").offset().top;
    $("html, body").animate({
        scrollTop: posicion
    }, 2000); 
});
*/


// setInterval(function () {
//     if ($(window).width() !== screenWidth || $(window).height() !== screenHeight) {
//         screenHeight = 0;
//         altoMenu = 0;
//         screenHeight = $(window).height();
//         altoHeader = parseFloat($(".header").css('height'));
//         altoMenu = parseFloat($(".menu").css('height'));
//         if(screenHeight < (altoHeader+altoMenu) ){
//             console.log('el alto de menu es superior a la pantalla');
//             $(".menu").css('height',(screenHeight-altoHeader));
//         }else{
//             $(".menu").css('height','350px');
//             console.log('el alto de menu es: 350px');
//         }
//         console.log('ancho: ' + screenWidth + ", alto: " + screenHeight);
//     }
// }, 50);