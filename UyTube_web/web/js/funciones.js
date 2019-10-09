// Muesta u oculta el menu
$(".icon-menu1").on("click", function(){
    $(".menu").toggleClass('abrir');   
}); 

/*
$(".icon-menu1").on("click", function(){
    var posicion = $(".icon-menu1").offset().top;
    $("html, body").animate({
        scrollTop: posicion
    }, 2000); 
});
*/