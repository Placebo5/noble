<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="./resources/ckeditor/ckeditor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
	
</style>	
<link rel="stylesheet" href="resources/css/join/login.css">
<%@ include file="../home/menu.jsp" %>		
	<c:choose>
		<c:when test="${usersel_vo != null && usersel_vo.user_no != '' }">
			<h1>${usersel_vo.user_nm}님 </h1>
		</c:when>
		<c:when test="${usersel_vo == null || usersel_vo.user_no == '' }">
		<div class="box">
			<h2 id="login">로그인</h2>
				
			<div class="userLogin" style="padding-top: 55px;">
				<form id="loginForm" name="loginForm" method="post">
					<ul>
						<li>
							<div class="logid">
								<input type="text" id="user_id" name="user_id" placeholder="아이디" style="width: 350px; height: 50px; padding: 10px;" />
							</div>
						</li>
						<li>
							<div class="logpwd">
									<input type="password" id="user_pwd" name="user_pwd" placeholder="비밀번호" style="width: 350px; height: 50px; padding: 10px;" />
							</div>
						</li>
					</ul>
					
					<div class="logingo">	
						<input type="button" value="로그인" id="login_btn" />
					</div>
				</form>
					<div class="findlogin">
						<a href="#" class="find">아이디 찾기</a> |
						<a href="#" class="find">비밀번호 찾기</a> |
						<a href="./joingate" class="find">회원가입</a>
					
					</div>
				</div>
			</div>
		</c:when>
	</c:choose>	
<%@ include file="../home/footer.jsp" %>
<script type="text/javascript" src="./resources/js/join/login.js"></script>