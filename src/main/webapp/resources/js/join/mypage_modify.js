var correctPwd = 0;
$(document).ready(function(){
	$("#user_updpwd").blur(function(){
// 			alert($("#user_updpwd").val());
// 			alert($("#hidUsrPwd").val());
		if($("#user_updpwd").val() == $("#hidUsrPwd").val()){
			$("#pwd_span").text("일치");
			correctPwd = 1;
		} else {
			$("#pwd_span").text("불일치");
			correctPwd = 0;
		}
	});//blur 현재 비밀번호 일치하는지 확인

	$("#updMypage").click(function(){

		if($.trim($("#user_updpwd").val()) == ""){
			alert("비밀번호를 입력해 주세요.");
			$("#user_updpwd").focus();
			return;
		}
		if(correctPwd == 0){
			alert("현재 비밀번호와 일치하지 않습니다.\n다시 비밀번호를 확인 해주세요.");
			$("#user_updpwd").focus();
			return;
		}
		if($.trim($("#user_pwd").val()) == ""){
			alert("비밀번호를 입력해 주세요.");
			$("#user_pwd").focus();
			return;
		}
		if($.trim($("#user_updpwd2").val()) == ""){
			alert("비밀번호를 입력해 주세요.");
			$("#user_updpwd2").focus();
			return;
		}
		if($("#user_pwd").val() != $("#user_updpwd2").val()){
			alert("신규 비밀번호가 일치하지 않습니다.\n다시 비밀번호를 확인 해주세요.");
			$("#user_updpwd2").focus();
			return;
		}

		var goYN = confirm("회원정보를 수정 하시겠습니까?");
		if(goYN == false){
			return;
		}

		$.post(
				"./updmypage"
				,{
					user_id:$("#user_id").val()	
					,user_pwd:$("#user_pwd").val()
					,user_tel:$("#user_tel").val()
				}
				,function(data, status){	
					if(status == "success") {
						if(data > 0) {
							alert("회원정보가 수정 되었습니다.");
							location.href="./main";
						} else {
							alert("잠시 후에 다시 시도해 주세요.");
						}
					} else {
						alert("시스템 관리자에게 문의하세요.");
					}//if
				}
		);//post
	});//click
});//ready
	
	
$(document).ready(function() {
	$("#btnDelete").click(function() {
		var outYN = confirm("탈퇴하시겠습니까?");
		if(outYN == false){
			return;
		}		
		$.post(
				"./mbwithrawal"
				,{
					user_id:$("#user_id").val()	
				}
				,function(data,status){
					if(status == "success"){
						if(data > 0){
							alert("회원정보가 삭제되었습니다.");
							location.href="./main";
							}else if(data == -1){
								alert("회원탈퇴를 할 수 없습니다.");
						}else{
							alert("잠시 후, 다시 시도해 주세요");
						}
					}else{
						alert("관리자에게 문의 바랍니다.");
					}//if					
				}
		);//post		
	})//click
})//ready