<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/reservation/reschose.css">
</head>
<body>
<%@ include file="../home/menu.jsp" %>	
	<div class="box">
		<c:choose>
			<c:when test="${chose['hos_pro_no'] == null && chose['salon_pro_no'] == null && chose['cafe_pro_no'] == null}">
				<h2>등록된 프로모션이 없습니다.</h2><br>
			</c:when>
			<c:otherwise>
				<h2>선택하세요</h2><br>
				<div class="btnBox">
					<c:if test="${chose['hos_pro_no'] != null}">
						<a href="./reslistcomp?pro_no=${chose['hos_pro_no']}&user_no=${userSession.user_no}">병원</a>
					</c:if>
					<c:if test="${chose['salon_pro_no'] != null}">
						<a href="./reslistcomp?pro_no=${chose['salon_pro_no']}&user_no=${userSession.user_no}">미용실</a>
					</c:if>
					<c:if test="${chose['cafe_pro_no'] != null}">
						<a href="./reslistcomp?pro_no=${chose['cafe_pro_no']}&user_no=${userSession.user_no}">카페</a>
					</c:if>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
<%@ include file="../home/footer.jsp" %>
</body>
</html>