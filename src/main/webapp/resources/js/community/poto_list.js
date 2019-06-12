$(document).ready(function(){
	$(".Search").click(function(){
		if($("#potoSearch").val() != ""){
			$("#hidSearchType").val($("#searchType").val());
			$("#hidSearchWord").val($("#potoSearch").val());
			$("#hidSearchForm").attr("action", "./potolist");
			$("#hidSearchForm").submit();
		}//if
	});//click
});//ready