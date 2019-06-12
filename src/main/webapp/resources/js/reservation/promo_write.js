$(document).ready(function() {
	$("#ins_promo_btn").click(function() {

		var holidayArr = new Array();
		var holidaylen = document.getElementsByName("holiday").length;
		for(i=0; i<holidaylen; i++){
			if(document.getElementsByName("holiday")[i].checked == true){
				holidayArr.push('1');
			}else{
				holidayArr.push('0');
			}
		}//for

		if($("#pro_type").val() == 0){
			alert("사업자 형태를 선택하세요.");
			$("#pro_type").focus();
			return;
		}
		if($.trim($("#user_tel").val()) == ""){
			alert("사업자 전화번호를 입력하세요.");
			$("#user_tel").focus();
			return;
		}
		if($("#pro_unit").val() == 0){
			alert("예약 시간 단위를 선택하세요.");
			$("#pro_unit").focus();
			return;
		}
		
		if($("#start_time").val() == 0){
			alert("영업 시작 시간을 선택하세요.");
			$("#start_time").focus();
			return;
		}
		
		if($("#end_time").val() == 0){
			alert("영업 마감 시간을 선택하세요.");
			$("#end_time").focus();
			return;
		}

		var cnts = CKEDITOR.instances.pro_contents1;
		if(cnts.getData() == ""){
			alert("내용을 확인 하세요.");
			cnts.focus();
			return;
		}	
		var goYN = confirm("홍보 글을 입력하시겠습니까?");
		if(goYN == false){
			return;
		}

		var form = new FormData(document.getElementById("testForm"));
		form.append('pro_contents1',cnts.getData());
		form.append('holidayArr',holidayArr);
	
		
		$.ajax({
			url:"./inspromowrite"
			, data:form
			, dataType:'text'
			, processData:false
			, contentType:false
			, type:'POST'
			, success:function(result){
				if(result > 0){
					alert("글이 저장되었습니다.");
					location.href="./hoslist";
				} else {
					alert("잠시 후, 다시 시도해 주세요.");
				}
			}
			, error:function(xhr){
				alert("시스템 관리자에게 문의 바랍니다.");
			}
		});//ajax
	});//click
});//ready