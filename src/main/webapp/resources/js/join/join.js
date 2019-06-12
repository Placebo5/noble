var chkid = '';
var chkidyn = 0;

//id check
$(document).ready(function(){
	$("#id_chk").click(function(){
		if($.trim($("#user_id").val()) == ''){
			$("#user_id").focus();
			return;
		}
		$.post("./joinidchk",
				{user_id:$("#user_id").val()},
				function(data,status){
					if(data == 0){
						alert("사용 가능한 아이디입니다.");
						chkid = $("#user_id").val();
						chkidyn = 1;
					}else{
						alert("이미 사용 중인 ID 입니다.");
					}
				}
		);
	});//click
});//ready

$(document).ready(function() {
	$(".joinok").click(function() {
		if($.trim($("#user_id").val())==""){
			alert("아이디를 입력하세요");
			$("#user_id").focus();
			return;
		}
		if(chkidyn == 0){
			alert("먼저 아이디 확인을 해주세요.");
			$("#id_chk").focus();
			return;
		}
		if($("#user_id").val() != chkid){
			alert("확인한 아이디를 변경 하셨습니다.\n다시 아이디 확인을 해주세요.");
			$("#user_id").focus();
			return;
		}
		if($.trim($("#user_pwd").val())==""){
			alert("패스워드를 입력하세요");
			$("#user_pwd").focus();
			return;
		}
		if($.trim($("#user_pwd2").val())==""){
			alert("패스워드를 입력하세요");
			$("#user_pwd2").focus();
			return;
		}
		if($("#user_pwd2").val() != $("#user_pwd").val()){
			alert("패스워드가 다릅니다.");
			$("#user_pwd2").focus();
			return;
		}
		if($.trim($("#user_nm").val())==""){
			alert("이름을 입력하세요");
			$("#user_nm").focus();
			return;
		}
		if($.trim($("#user_tel").val())==""){
			alert("전화번호를 입력하세요");
			$("#user_tel").focus();
			return;
		}
		if($.trim($("#user_email").val())==""){
			alert("이메일을 입력하세요");
			$("#user_email").focus();
			return;
		}
		if($("#user_email").val().indexOf('@') == '-1'
			|| $("#user_email").val().lastIndexOf('.') == '-1'){
			alert("eMail 형식이 잘못되었습니다.");
			$("#user_email").focus();
			return;
		}
	$.post(
			"./insjoin"
			,{
				user_id:$("#user_id").val()
				,user_pwd:$("#user_pwd").val()
				,user_nm:$("#user_nm").val()
				,user_tel:$("#user_tel").val()
				,user_email:$("#user_email").val()
			}					
			,function(data, status) {
				if(status == "success"){
					if(data > 0){
						alert("회원가입이 완료되었습니다.");
						location.href="./main"
					}else{
						aleft("잠시후 다시 시도해주세요");
					}
				}else{
					alert("시스템 관리자에게 문의 바랍니다.");
				}
			}
		);//post
	});//click
});//ready