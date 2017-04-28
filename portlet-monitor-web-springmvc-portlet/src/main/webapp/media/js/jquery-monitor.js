(function($){
	up.jQuery(document).ready(function(){

		up.jQuery('.affichListe').click(function() {
		var index =  up.jQuery(this.parentNode).parent().index();
		var numIndex = index + 1;
		
		up.jQuery("tr:eq("+index+") td:nth-child(7) .affichListe").attr("style"," display: none;");
		up.jQuery("tr:eq("+index+") td:nth-child(7) .noAffichListe").attr("style"," ");
		up.jQuery("tr:eq("+numIndex+")").attr("style","");
		 
		})
		up.jQuery('.noAffichListe').click(function() {
			var index =  up.jQuery(this.parentNode).parent().index();
			var numIndex = index + 1;
			up.jQuery("tr:eq("+index+") td:nth-child(7) .affichListe").attr("style"," ");
			up.jQuery("tr:eq("+index+") td:nth-child(7) .noAffichListe").attr("style","display: none;");
			up.jQuery("tr:eq("+numIndex+")").attr("style","display: none;");
		})
})
})(jQuery);