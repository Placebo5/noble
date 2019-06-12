$(document).ready(function() {
	//예약승인
	$("body").on("click", "[id^=checkBtn]", function(event) { 
            var cnt = $(this).val();
			$.post(
					"./rescheck"
					,{
						res_no:$("#res_no" + cnt).val()
					}
					,function(data,status){
						$("#CheckList" + cnt).text(data);
					}

			);//post
	});//on
   
	//취소
	$("body").on("click", "[id^=canselBtn]", function(event) { 
        var cnt = $(this).val();
		$.post(
				"./rescansel"
				,{
					res_no:$("#res_no" + cnt).val()
				}
				,function(data,status){
			  		$("#CheckList" + cnt).text(data);
				}

		);//post
	});//on	

	
	$(".postnTab").click(function() {
		$(this).parents("div.table").toggleClass("block");
		if($(this).text() == "상세▼"){
			$(this).text("상세▲");
		}
		else{
			$(this).text("상세▼");
		}
	});//postnTab click 

	$("#searchBtn").click(function() {
		if($("#search").val() != ""){
			$("#hidSearchType").val($("#searchType").val());
			$("#hidSearchWord").val($("#searchbox").val());
			$("#hidSearchForm").attr("action","./reslistmng");
			$("#hidSearchForm").submit();
		}//if
	});
});//ready