<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약상세</title>
<link rel="stylesheet" href="resources/css/reservation/reslist.css">
</head>
<body>
<%@ include file="../home/menu.jsp" %>
	<div class="box">
		<div class="title_nm">예약확인</div><br>
			<c:forEach var="vo" items="${response['res_list']}" varStatus="status" >							
				<div class="table">
					<table rules="groups" style="width: 938px;">
						<colgroup>
							<col width="150px;">
							<col width="200px;">
							<col width="250px;">
								<col width="150px;">
						</colgroup>		
						<tr style="background-color: #b3f0ff;">
							<th>승인여부</th>
							<th>예약날짜</th>
							<th>예약장소</th>
							<th>예약시간</th>
						</tr>
						
						<tbody>
							<tr>
								<td style="text-align: center;">${vo.res_yn}</td>
								<td style="text-align: center;">${vo.res_date}</td>
								<td style="text-align: center;">${vo.comp_name}</td>
								<td style="text-align: center;">${vo.res_time}</td>
							</tr>
							<tr id="postnTr" class="hide postnTr">
	
								<td colspan="2" style="border-top-width: 0px; text-align: center;">
									<strong style="padding: 8px;">예약자</strong>
									<input type="text" readonly="readonly" value="${vo.res_nm}">
								</td>
								<td colspan="2" style="border-top-width: 0px; text-align: center;">
									<strong>예약장소</strong>
									<input type="text" readonly="readonly" value="${vo.comp_add}">
								</td>
							</tr>
							<tr id="postnTr" class="hide postnTr">
	
								<td colspan="2" style="border-top-width: 0px; text-align: center;">
									<strong>예약날짜</strong>
									<input type="text" readonly="readonly" value="${vo.res_date}">
								</td>
								<td colspan="2" style="border-top-width: 0px; text-align: center;">
									<strong style="padding: 8px;">연락처</strong>
									<input type="text" readonly="readonly" value="${vo.res_tel}">
								</td>
							</tr>	
							<tr id="postnTr" class="hide postnTr">
	
								<td colspan="2" style="border-top-width: 0px; text-align: center;">
									<strong>예약시간</strong>
									<input type="text" readonly="readonly" value="${vo.res_time}">
								</td>
								<td colspan="2" style="border-top-width: 0px; text-align: center;">
									<strong>요청사항</strong>
									<input type="text" readonly="readonly" value="${vo.res_contents}">
								</td>
							</tr>	
							<tr>
								<td colspan="4" style="border-top-width: 0px; text-align: right;">
									<strong></strong><font class="postnTab" style="cursor:pointer;">상세▼</font>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</c:forEach>
			<div>
				<h3 style="text-align: center;">
				<c:forEach begin="1" end="${response['pagingEnd']}" step="1" varStatus="status">
					<c:choose>
						<c:when test="${page == status.index}">
							<a href="./reslist?page=${status.index}&user_no=${userSession.user_no}">
								<u>${status.index}</u>
							</a>
						</c:when>
						<c:otherwise>
							<a href="./reslist?page=${status.index}&user_no=${userSession.user_no}">
								${status.index}
							</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</h3>
			</div>	
	</div>		
<%@ include file="../home/footer.jsp" %>
</body>
<script type="text/javascript" src="./resources/js/reservation/reslist.js"></script>
</html>