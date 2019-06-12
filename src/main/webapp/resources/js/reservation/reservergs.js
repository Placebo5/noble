$(document).ready(function(){	
	var noTime = $.fullCalendar.moment();
// 		var week_day = date.day();
	  $('#calendar').fullCalendar({		  
// 			  businessHours: true,//특정요일 시간 강조
		  selectable: true, //클릭 가능여부
		  dayNames: ['0', '1', '2', '3', '4', '5', '6'],

		  dayClick: function(date, jsEvent) {
 			      	$("#res_date").val(date.format());//날짜입력
// 						alert('clicked ' + date.format()+" : "+date.day());		
 			      		 			      	
 			      	$.post(
 			      			"./promoreservestat"
 			      			,{
 			      				pro_no:$("#pro_no").val()
 			      				,week_day:date.day()
 			      				,res_date:date.format()
 			      			},
 			      			function(data, status){
								$("#tiem").empty();
 								$.each(data, function(index,vo){
 									if(vo.reserve_yn == -1){
 										
 										return;
 									} else
									if(vo.reserve_yn == 1){
										$("#tiem").append(
 												'<li class="item" id="item">'
 												+'<button class = "notBtn" style="background-color:gray;' 
 												+'cursor:not-allowed; border: 1px solid gray; ">'+vo.reserve_time+'</button>'
 												+'</li>'
 										);
									} else {
										$("#tiem").append(	
 												'<li class="item" id="timeid">'
 												+'<button class="timeBtn">'+vo.reserve_time+'</button>'
 												+'</li>'
 										);
									}
 								});//each
 								$(".item").addClass("lst_time li");
 								$("#tiem").addClass("lst_time");
 								$(".timeBtn").bind("click",function() {
 									btnText = $(this).text();
 									$("#res_time").val(btnText);
 								});
 			      			}
 			      			,"json"
 			      	);
 			      	
		  },//dayclick 	

		  events : {
		    	url:'./holidaychklist?pro_no='+$("#pro_no").val()+'&nowDate='+noTime.format(),

		  },

		  validRange: function(nowDate) {
		      return {
		    	start:nowDate,
		        end: nowDate.clone().add(1, 'months')
		      }
		  }
		    
	  });//fullCalendar
	 

	  
	
	  $("#insresBtn").click(function() {
		if($.trim($("#res_nm").val()) == ""){
			alert("예약자를 확인하세요");
			$("#res_nm").focus();
			return;
		}
		if($.trim($("#res_tel").val()) == ""){
			alert("연락처를 확인하세요");
			$("#res_tel").focus();
			return;
		}
		if($.trim($("#res_time").val()) == ""){
			alert("예약시간을 선택해 주세요");
			$("#res_time").focus();
			return;
		}
		if($.trim($("#res_date").val()) == ""){
			alert("날짜를 선택해 주세요");
			$("#res_date").focus();
			return;
		}
		$.post(
				"./insreservergs"	
				,{
					user_no:$("#user_no").val()
					,pro_no:$("#pro_no").val()	
					,res_nm:$("#res_nm").val()
					,res_tel:$("#res_tel").val()
					,res_contents:$("#res_contents").val()
					,res_date:$("#res_date").val()
					,res_time:$("#res_time").val()
					
				}
				,function(data,status){
					if(status == "success"){
						if(data > 0){
							alert("예약신청이 완료되었습니다.");
							location.href="./reslist?user_no="+$("#user_no").val()
						}else{
							alert("잠시후 다시 시도해주세요");
						}
					}else{
						alert("시스템 관리자에게 문의 바랍니다.");
					}
				}
		);//post  
	});//click
});