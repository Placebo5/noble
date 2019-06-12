$(document).ready(function(){ 
	$("#login_btn").click(function(){ 
		if($.trim($("#user_id").val()) == ""){ 
			alert("아이디를 확인하세요."); 
			$("#user_id").focus(); 
			return; 
		} 
		if($.trim($("#user_pwd").val()) == ""){
			alert("비밀번호를 확인하세요."); 
			$("#user_pwd").focus(); 
			return; 
		} 
		
	
		$.post(
				"./logincheck"
				,{
					user_id:$("#user_id").val()
					,user_pwd:$("#user_pwd").val()
				}
				,function(data,status){
					if(status == "success"){
						if(data > 0){
							alert("로그인 되었습니다.");
							location.href="./main";
						} else if(data == 0){
							alert("존재하지 않는 아이디 또는 비밀번호 입니다.");
						} else {
							alert("잠시 후, 다시 시도해 주세요.");
						}
					} else {
						alert("시스템 관리자에게 문의 바랍니다.");
					}
				}
		);//post
	});//click
});//ready 