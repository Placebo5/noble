<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="./resources/ckeditor/ckeditor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/join/join_gate.css">
</head>
<body>
<%@ include file="../home/menu.jsp" %>

	<div class="box">
		<h2 id="joinmb">회원가입</h2>
		<div class="joinmember">
			<div class="person">
				<div style="padding: 8%; box-sizing: border-box; line-height: 30px; ">
					<p style="font-size: 15pt; font-weight: bold;">개인 회원</p>
					<p style="font-size: 12pt;">만 14세 이상 가능</p>
					<a id="joinperson" href="./join">회원가입</a>
				</div>
			</div>
			
			<div class="company">
				<div style="padding: 8%; box-sizing: border-box; line-height: 30px;">
					<p style="font-size: 15pt; font-weight: bold;">사업자 회원</p>
					<p style="font-size: 12pt;">사업자등록증을 보유한 구매회원</p>
					<a id="joincompany" href="./joincompany">회원가입</a>
				</div>
			</div>
		</div>
	</div>
<%@ include file="../home/footer.jsp" %>
</body>
</html>