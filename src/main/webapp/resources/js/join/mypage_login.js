$(document).ready(function(){ 
	$("#pwd_btn").click(function(){ 
		if($.trim($("#user_pwd").val()) == ""){
			alert("비밀번호를 확인하세요."); 
			$("#user_pwd").focus(); 
			return; 
		} 
		
		$.post(
				"./mypageloginCheck"
				,{
					user_id:$("#user_id").val()
					,user_pwd:$("#user_pwd").val()
				}
				,function(data,status){
					if(status == "success"){
						if(data > 0){
							location.href="./mypagemodify";
						} else if(data == 0){
							alert("비밀번호가 일치하지 않습니다.");
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