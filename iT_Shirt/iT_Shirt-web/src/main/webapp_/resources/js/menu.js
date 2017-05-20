/**
 * Código JS del menú.
 */


$( ".nav li" ).click(function() {
	alert("click");
        $('.nav li').removeClass('active');
        $(this).addClass('active');
    });