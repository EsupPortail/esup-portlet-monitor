(function($){
    $(document).ready(function(){

	$('.affichListe').click(function() {
		var index =  $(this.parentNode).parent().index();
		var numIndex = index + 1;
		
		 $("tr:eq("+index+") td:nth-child(7) .affichListe").attr("style"," display: none;");
		 $("tr:eq("+index+") td:nth-child(7) .noAffichListe").attr("style"," ");
		 $("tr:eq("+numIndex+")").attr("style","");
		 
	})
	$('.noAffichListe').click(function() {
		var index =  $(this.parentNode).parent().index();
		var numIndex = index + 1;
		$("tr:eq("+index+") td:nth-child(7) .affichListe").attr("style"," ");
		$("tr:eq("+index+") td:nth-child(7) .noAffichListe").attr("style","display: none;");
		$("tr:eq("+numIndex+")").attr("style","display: none;");
	})
})
})(jQuery);