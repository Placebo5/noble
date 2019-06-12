$(document).ready(function() {
	$(".postnTab").click(function() {
		$(this).parents("div.table").toggleClass("block");
		if($(this).text() == "상세▼"){
			$(this).text("상세▲");
		}
		else{
			$(this).text("상세▼");
		}
	});//postnTab click 
});//ready