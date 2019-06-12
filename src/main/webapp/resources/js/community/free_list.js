$(document).ready(function(){
	$(".Search").click(function(){
		if($("#freeSearch").val() != ""){
			$("#hidSearchType").val($("#searchType").val());
			$("#hidSearchWord").val($("#freeSearch").val());
			$("#hidSearchForm").attr("action", "./freelist");
			$("#hidSearchForm").submit();
		}//if
	});//click
});//ready