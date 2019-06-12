<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="./resources/ckeditor/ckeditor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/join/join.css">
</head>
<body>
 <%@ include file="../home/menu.jsp" %>
	<!-- 회원가입 -->
	<div class="box" style="min-height: 50vh;">
		<h2>회원가입</h2>
		<div class="joinmb" style="padding-top: 30px;">
			<ul class="remove">
				<li>
					<div class="">
						<input type="text" maxlength="30" placeholder="아이디" id="user_id" name="user_id"
								style="width:300px; height: 40px; padding: 10px;">
					</div>
				</li>
				<li>
					<div class="">
						<input type="button" id="id_chk" value="아이디 중복확인" style="width:300px; height: 40px; padding: 10px;"/>
					</div>
				</li>
				<li>
					<div class="">
						<input type="password" maxlength="30" placeholder="비밀번호" id="user_pwd" name="user_pwd" 
								style="width:300px; height: 40px; padding: 10px;">
					</div>
				</li>
				<li>
					<div class="">
						<input type="password" maxlength="30" placeholder="비밀번호 확인" id="user_pwd2" name="user_pwd2" 
								style="width:300px; height: 40px; padding: 10px;">
					</div>
				</li>
				<li>
					<div class="">
						<input type="text" maxlength="10" placeholder="이름" id="user_nm" name="user_nm"
								style="width:300px; height: 40px; padding: 10px;">
					</div>
				</li>
				<li>
					<div class="">
						<input type="number" placeholder="휴대폰 번호" id="user_tel" name="user_tel"
								style="width:300px; height: 40px; padding: 10px;">
					</div>
				</li>
				<li>
					<div class="">
						<input type="email" maxlength="50" placeholder="이메일" id="user_email" name="user_email"
								style="width:300px; height: 40px; padding: 10px;">
					</div>
				</li>
			</ul>
			<div>	
				<button class="joinok">가입하기</button>
			</div>
		</div>	
	</div>
<%@ include file="../home/footer.jsp" %>
</body>
<script type="text/javascript" src="./resources/js/join/join.js"></script>
</html>