<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src="./resources/ckeditor/ckeditor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/join/mypage_modify.css">
</head>
<body>
<%@ include file="../home/menu.jsp" %>
	<div>
		<h2>회원정보 수정</h2>
	</div>
	<div class="membermodify">
		<h3 style="text-align: center; padding: 10px;">기본 정보</h3>
		<table class="info">
			<tbody>
				<tr>
					<th>아이디</th>
					<td style="width: 380px; height:35px;">
						<div>
							<input type="text" id="user_id" style="width:250px; height:30px; " readonly="readonly" value="${userSession.user_id}" />
						</div>	
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<div>
							<input type="text"  style="width:250px; height:30px;" readonly="readonly" value="${userSession.user_nm}" />
						</div>	
					</td>
				</tr>
				<tr>
					<th>현재 비밀번호</th>
					<td>
						<div>
							<input type="password" id="user_updpwd" style="width:250px; height:30px;" />
							<span id="pwd_span"></span>
						</div>	
					</td>
				</tr>
				<tr>
					<th>신규 비밀번호</th>
					<td>
						<div>
							<input type="password" id="user_pwd" style="width:250px; height:30px;">
							<input type="hidden" id="hidUsrPwd" value="${userSession.user_pwd}" />
						</div>	
					</td>
				</tr>
				<tr>
					<th>신규 비밀번호 확인</th>
					<td>
						<div>
							<input type="password" id="user_updpwd2" style="width:250px; height:30px;">
						</div>	
					</td>
				</tr>
				<tr>
					<th>휴대폰 번호</th>
					<td>
						<div>
							<input type="tel" id="user_tel" style="width:250px; height:30px;" value="${userSession.user_tel}" />
						</div>	
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<div>
							<input type="email" id="user_email" style="width:250px; height:30px;" readonly="readonly" value="${userSession.user_email}" />
						</div>	
					</td>
				</tr>
			</tbody>
		</table>
		</div>
	<div class="out">
		<input type="button" id="btnDelete" value="회원탈퇴">
	</div>
	<div class="modi">
	<span id="updMypage"
		style="width: 120px; border-radius:7px; cursor: pointer;">수정</span>
	</div>
<%@ include file="../home/footer.jsp" %>
</body>
<script type="text/javascript" src="./resources/js/join/mypage_modify.js"></script>
</html>