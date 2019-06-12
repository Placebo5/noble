<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="./resources/ckeditor/ckeditor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="resources/css/join/joincompany.css">
</head>
<body>
<%@ include file="../home/menu.jsp" %>
	<!-- 회원가입 -->
	<h2>회원가입</h2>
	<div class="joinmb" style="padding-top: 30px;">
		<ul class="remove">
			<li>
				<div class="">
					<input type="text" placeholder="사업자등록번호" id="comp_rgnno" name="comp_rgnno"
							style="width:300px; height: 40px; padding: 10px;">
				</div>
			</li>
			<li>
				<div class="">
					<input type="text" placeholder="상호" id="comp_name" name="comp_name"
							style="width:300px; height: 40px; padding: 10px;">
				</div>
			</li>
			<li>
				<div>
					<input type="text" placeholder="사업자주소" id="comp_add1" name="comp_add1"
							readonly="readonly" style="width:300px; height: 40px; padding: 10px;">
					<input type="text" placeholder="사업자 상세주소" id="comp_add2" name="comp_add2"
							maxlength="50" style="width:300px; height: 40px; padding: 10px;">
					<input type="hidden" id="comp_add" name="comp_add" />
				</div>
			</li>
			<li>
				<div>
					<input type="text" placeholder="대표자이름" id="comp_ceonm" name="comp_ceonm"
							style="width:300px; height: 40px; padding: 10px;">
				</div>
			</li>
			<li>
				<div>
					<input type="text" placeholder="아이디" id="user_id" name="user_id"
							style="width:300px; height: 40px; padding: 10px;">
				</div>
			</li>
			<li>
					<div>
						<input type="button" id="id_chk" value="아이디 중복확인" style="width:300px; height: 40px; padding: 10px;"/>
					</div>
				</li>
			<li>
				<div>
					<input type="password" placeholder="비밀번호" id="user_pwd" name="user_pwd" 
							style="width:300px; height: 40px; padding: 10px;">
				</div>
			</li>
			<li>
				<div>
					<input type="password" placeholder="비밀번호 확인" id="user_pwd2" name="user_pwd2" 
							style="width:300px; height: 40px; padding: 10px;">
				</div>
			</li>
			<li>
				<div>
					<input type="text" placeholder="이름" id="user_nm" name="user_nm"
							style="width:300px; height: 40px; padding: 10px;">
				</div>
			</li>
			<li>
				<div>
					<input type="number" placeholder="휴대폰 번호" id="user_tel" name="user_tel"
							style="width:300px; height: 40px; padding: 10px;">
				</div>
			</li>
			<li>
				<div class="">
					<input type="email" placeholder="이메일" id="user_email" name="user_email"
							style="width:300px; height: 40px; padding: 10px;">
				</div>
			</li>
		</ul>
		<div>	
			<button class="joinok">가입하기</button>
		</div>
	</div>	
<%@ include file="../home/footer.jsp" %>
</body>
<script type="text/javascript" src="./resources/js/join/joincompany.js"></script>
</html>