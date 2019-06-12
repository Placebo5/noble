<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>병원 홍보 상세</title>
<link rel="stylesheet" href="resources/css/reservation/hosdetail.css">
</head>
<body>
 <%@ include file="../home/menu.jsp" %>
	<div class="mainbox">
		<div class="companyinfo">
			<div>
				<div class="companyname1">
					<img src="/${hos_detail_vo.atch_file1_nm}" width="400" height="248"> 
				</div>
				<div class="companyname2">
					<img src="/${hos_detail_vo.atch_file2_nm}" width="400" height="248"> 
				</div>
			</div>
			<div>	
				<div class="companyname3">
					<br>
					<h3>${hos_detail_vo.comp_name}</h3>
					<br>
					<p>${hos_detail_vo.pro_type}</p>
					<br><br>
					<p>
					<a href="./hosadd?pro_no=${hos_detail_vo.pro_no}">지도</a> | 
					<a href="./reservergs?pro_no=${hos_detail_vo.pro_no}">예약</a>
					</p>
				</div>
				<div class="companyname4" style="padding: 10px;">
					<br>
					<p>주소 : ${hos_detail_vo.comp_add}</p>
					<br>
					<p>전화번호 : ${hos_detail_vo.user_tel}</p>
					<br>
					<p>상세설명</p>
					<p>${hos_detail_vo.pro_contents1}</p>
					<p>${hos_detail_vo.pro_contents2}</p>
				</div>
			</div>	
		</div>
		
		<div class="hosbtn">
			<a href="./hoslist" class="hosderewrite">목록</a> 
			<c:if test="${userSession != null && userSession.user_no ==
				hos_detail_vo.user_no}">
				<span style="cursor:pointer;">
					<a href="./promomodify?pro_no=${hos_detail_vo.pro_no}" class="modifypromo" id="modifypromo">수정</a>
				</span>
				<span class="delpromo" id="delpromo" style="cursor:pointer;">
					삭제
				</span>
			</c:if>
		<input type="hidden" id="user_no" value="${userSession.user_no}" />
		<input type="hidden" id="pro_no" value="${hos_detail_vo.pro_no}" /> 
		</div>
	</div>
<%@ include file="../home/footer.jsp" %>
</body>
<script type="text/javascript" src="./resources/js/reservation/hosdetail.js"></script>
</html>