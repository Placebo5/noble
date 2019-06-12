$(document).ready(function(){	
	var noTime = $.fullCalendar.moment();
	var ctn_no = 1;
	$('#calendar').fullCalendar({	
	 selectable: true, //클릭 가능여부
	 dayNames: ['0', '1', '2', '3', '4', '5', '6'],

	 dayClick: function(date, jsEvent) {
					
			$.post(
					"./resCompList"
					,{
						pro_no:$("#pro_no").val()
						,user_no:$("#user_no").val()
		      			,res_date:date.format()
					},
					function(data, status) {
							$(".daylist").empty();
						$.each(data, function(index, vo) {
							$(".daylist").append(
							'<table id="reslist" rules="groups" style="width: 938px; border:1px solid gray;">'
								+'<colgroup>'
									+'<col width="200px;">'
									+'<col width="280px;">'
									+'<col width="280px;">'
									+'<col width="100px;">'
									+'<col width="78px;">'
								+'</colgroup>'			
								+'<tr style="background-color: #b3f0ff;">'
									+'<th>승인여부</th>'
									+'<th>예약날짜</th>'
									+'<th>예약장소</th>'
									+'<th colspan="2">예약시간</th>'
								+'</tr>'
								+'<tbody>'
									+'<tr>'
										+'<td style="text-align: center;"><span id="CheckList'+ctn_no+'">'+vo.yn+'</span></td>'
										+'<td style="text-align: center;">'+vo.date+'</td>'
										+'<td style="text-align: center;">'+vo.comp_nm+'</td>'
										+'<td colspan="2" style="text-align: center;">'+vo.time+'</td>'
									+'</tr>'
									+'<tr class="hide1 postnTr1">'
										+'<td colspan="2" style="border-top-width: 0px; text-align: center;">'
										+'<strong style="padding: 8px;">예약자 </strong>'
										+'<input type="text" readonly="readonly" value="'+vo.nm+'">'
										+'</td>'
										+'<td style="border-top-width: 0px; text-align: center;">'
										+'<strong>예약장소 </strong>'	
										+'<input type="text" readonly="readonly" value="'+vo.add+'">'	
										+'</td>'
										+'<td colspan="2" rowspan="2" style="border-top-width: 5px; text-align: center;">'
										+'<button id="checkBtn'+ctn_no+'" name="checkBtn'+ctn_no+'" value="'+ctn_no+'">예약승인 </button>'	
										+'</td>'
									+'</tr>'
									+'<tr class="hide1 postnTr1">'
									+'<td colspan="2" style="border-top-width: 0px; text-align: center;">'
										+'<strong>예약날짜 </strong>'	
										+'<input type="text" readonly="readonly" value="'+vo.date+'">'	
										+'</td>'
										+'<td style="border-top-width: 0px; text-align: center;">'
										+'<strong style="padding: 8px;">연락처 </strong>'	
										+'<input type="text" readonly="readonly" value="'+vo.tel+'">'	
										+'</td>'
										
									+'</tr>'	
									+'<tr class="hide1 postnTr1">'
										+'<td colspan="2" style="border-top-width: 0px; text-align: center;">'
										+'<strong>예약시간 </strong>'	
										+'<input type="text" readonly="readonly" value="'+vo.time+'">'	
										+'</td>'
										+'<td style="border-top-width: 0px; text-align: center;">'
											+'<strong>요청사항 </strong>'
											+'<input type="text" readonly="readonly" value="'+vo.contents+'">'
										+'</td>'
										+'<td colspan="2" rowspan="2" style="text-align: center;">'
										+'<button id="canselBtn'+ctn_no+'" name="canselBtn'+ctn_no+'" '
										+'value="'+ctn_no+'">취&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;소</button>'	
										+'</td>'
									+'</tr>'
									+'<tr class="hide1 postnTr1">'
										+'<td colspan="2" style="border-top-width: 0px; text-align: center;">'
										+'<strong>예약자ID </strong>'	
										+'<input type="text" readonly="readonly" value="'+vo.user_id+'">'	
										+'</td>'
										+'<td style="border-top-width: 0px; text-align: center;">'
											+'<strong>예약 NO </strong>'
											+'<input type="text" readonly="readonly" id="res_no'+ctn_no+'" name="res_no" value="'+vo.res_no+'">'
										+'</td>'
									+'</tr>'	
									+'<tr>'
										+'<td colspan="5" style="border-top-width: 0px; text-align: right;">'
										+'<strong></strong><font class="postnTab1" style="cursor:pointer;">상세▼</font>'	
										+'</td>'
									+'</tr>'	
								+'</tbody>'
								+'</table>'
								+'<br>'
							);
							ctn_no++;							
						});//each
						$(".postnTab1").bind("click", function(){
							$(this).parents("#reslist").toggleClass("block1");
							if($(this).text() == "상세▼"){
								$(this).text("상세▲");
							}
							else{
								$(this).text("상세▼");
							}
						});
					}
				,"json"
			);
	  },//dayclick 	

	  events : {
	    	url:'./holidaychklist?pro_no='+$("#pro_no").val()+'&nowDate='+noTime.format(),

	  }

	  });//fullCalendar
});	  




$(document).ready(function() {
	$("#searchBtn").click(function() {
		if($("#searchcompbox").val() != ""){
			$("#hidSearchType").val($("#searchType").val());
			$("#hidSearchWord").val($("#searchcompbox").val());
			$("#pro_no").val();
			$("#user_no").val();
			$("#hidSearchForm").attr("action","./reslistcomp");
			$("#hidSearchForm").submit();
		}
	});
	
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
	
	
});//ready