<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="./resources/ckeditor/ckeditor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/join/mypage_login.css">
<title>마이페이지</title>
</head>
<body>
<%@ include file="../home/menu.jsp" %>
	<div class="pwdcheck">
		<h4 class="h4">비밀번호 확인, 회원님의 정보를 안전하게 보호하기 위해 비밀번호를 다시 한 번 확인합니다.</h4>
			<form method="post">
				<div style="padding: 20px; text-align: center;">
					<dl style="padding: 10px;">
						<dt style="padding:5px; float:left; width:75px; margin-left:50px;">
							아이디
						</dt>
						<dd>
							<div>
								<input type="text" id="user_id" readonly="readonly" value="${userSession.user_id}" style=" width: 358px; height:36px; padding: 10px; margin-right: 100px; "> 
							</div>
						</dd>
					</dl>
					<dl style="padding: 10px;">
						<dt style="float: left; padding: 5px; margin-left:45px; ">
							비밀번호
						</dt>
						<dd>
							<div>
								<input type="password" id="user_pwd" placeholder="비밀번호" id="user_pwd" style="width: 358px; height:36px; padding: 10px; margin-right: 92px; "> 
							</div>
						</dd>
					</dl>
					<div style="height: 50px; margin-right: 55px;">
						<input type="button" value="확인" class="pwd_btn" id="pwd_btn">
					</div>
				</div>
			</form>		
		<p class="p1">회원님의 개인정보를 신중히 취급하며, 회원님의 동의 없이는 기재하신 회원정보를 공개 및 변경하지 않습니다.</p>
	</div>
<%@ include file="../home/footer.jsp" %>
</body>
<script type="text/javascript" src="./resources/js/join/mypage_login.js"></script>
</html>
