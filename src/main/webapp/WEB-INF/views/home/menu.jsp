<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고귀하개</title>
<script src="./resources/ckeditor/ckeditor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/home/menu.css">
</head>
<body>

	<header class="header">
		<div class="logo" style="text-align: center;">
			<a href="./main"><img src="./resources/images/logo2.png" width="180" height="150"></a>
		</div>
		<c:choose>
			<c:when test="${userSession != null && 
			userSession.user_no != ''}">${userSession.user_nm}님
				<a href="./logout">로그아웃</a> |
				<a href="./mypagelogin">마이페이지</a>
			</c:when>
			<c:otherwise>
				<a href="./login">로그인</a> |
				<a href="./joingate">회원가입</a>
			</c:otherwise>
		</c:choose>
	</header>
	<div>
	</div>
	<nav>
		<ul>
			<li><a href="./main">HOME</a></li>
			<li class="dropdown" >
				<a href="./hoslist" class="dropbtn">예약</a>
				<div class="dropdown-content" style="z-index: 2">
						<a href="./hoslist">예약</a>
					<c:choose>
						<c:when test="${userSession == null }">
							<a href="javascript:alert('로그인 후 이용가능합니다.');">예약 확인</a>
						</c:when>
						<c:otherwise>
							<a href="./reslist?user_no=${userSession.user_no}">예약 확인</a>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${userSession != null && userSession.mng_yn == '3' }">	
							<a href="./reschose?user_no=${userSession.user_no}">예약-사업자</a>
						</c:when>
					</c:choose>	
					<c:choose>
						<c:when test="${userSession != null && userSession.mng_yn == '1' }">
							<a href="./reslistmng">예약-관리자</a>							
						</c:when>
					</c:choose>	
				</div>
			</li>
			
			<li class="dropdown">
			<a href="./potolist" class="dropbtn">커뮤니티</a>
			<div class="dropdown-content">
				<a href="./potolist">오늘의 셀럽</a>
				<a href="./freelist">펫 톡</a>
			</div>
			</li>
			
			<li class="dropdown">
			<a href="#" class="dropbtn">고객센터</a>
			<div class="dropdown-content">
				<a href="#">공지사항</a>
				<a href="#">Q&A</a>
			</div>
			</li>
		</ul>
	</nav>	
</body>
</html>