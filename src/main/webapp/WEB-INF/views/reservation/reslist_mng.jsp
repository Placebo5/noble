<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약상세</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/reservation/reslist_mng.css">
</head>
<body>
<%@ include file="../home/menu.jsp" %>
	<div class="box">
		<h2>전체 예약리스트</h2><br>
		<c:forEach var="vo" items="${response['res_list']}" varStatus="status" >
			<div class="table">
				<table rules="groups" style="width: 938px;" >
					<colgroup>
						<col width="200px;">
						<col width="280px;">
						<col width="280px;">
						<col width="100px;">
						<col width="78px;">
					</colgroup>		
					<tr style="background-color: #b3f0ff;">
						<th>승인여부</th>
						<th>예약날짜</th>
						<th>예약장소</th>
						<th colspan="2">예약시간</th>
					</tr>
					
					<tbody>
						<tr>
							<td style="text-align: center;"><span id="CheckList${status.count}">${vo.res_yn}</span></td>
							<td style="text-align: center;">${vo.res_date}</td>
							<td style="text-align: center;">${vo.comp_name}</td>
							<td colspan="2" style="text-align: center;">${vo.res_time}</td>
						</tr>
						<tr id="postnTr" class="hide postnTr">
	
							<td colspan="2" style="border-top-width: 0px; text-align: center;">
								<strong style="padding: 8px;">예약자</strong>
								<input type="text" readonly="readonly" value="${vo.res_nm}">
							</td>
							<td style="border-top-width: 0px; text-align: center;">
								<strong>예약장소</strong>
								<input type="text" readonly="readonly" value="${vo.comp_add}">
							</td>
							<td colspan="2"  rowspan="2" style="border-top-width: 5px; text-align: center;">
								<button id="checkBtn${status.count}" name="checkBtn${status.count}" value="${status.count}">예약승인</button>
							</td>
						</tr>
						<tr id="postnTr" class="hide postnTr">
	
							<td colspan="2" style="border-top-width: 0px; text-align: center;">
								<strong>예약날짜</strong>
								<input type="text" readonly="readonly" value="${vo.res_date}">
							</td>
							<td style="border-top-width: 0px; text-align: center;">
								<strong style="padding: 8px;">연락처</strong>
								<input type="text" readonly="readonly" value="${vo.res_tel}">
							</td>
							
						</tr>	
						<tr id="postnTr" class="hide postnTr">
	
							<td colspan="2" style="border-top-width: 0px; text-align: center;">
								<strong>예약시간</strong>
								<input type="text" readonly="readonly" value="${vo.res_time}">
							</td>
							<td style="border-top-width: 0px; text-align: center;">
								<strong>요청사항</strong>
								<input type="text" readonly="readonly" value="${vo.res_contents}">
							</td>
							<td colspan="2" rowspan="2" style="text-align: center;">
								<button id="canselBtn${status.count}" name="canselBtn${status.count}" 
									value="${status.count}">취&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;소</button>
							</td>
						</tr>
						<tr id="postnTr" class="hide postnTr">
	
							<td colspan="2" style="border-top-width: 0px; text-align: center;">
								<strong>예약자ID</strong>
								<input type="text" readonly="readonly" value="${vo.user_id}">
							</td>
							<td style="border-top-width: 0px; text-align: center;">
								<strong>예약 NO</strong>
								<input type="text" readonly="readonly" id="res_no${status.count}" name="res_no" value="${vo.res_no}">
							</td>
						</tr>		
						<tr>
							<td class="postnTd" colspan="5" style="border-top-width: 0px; text-align: right;">
								<strong></strong><font class="postnTab" style="cursor:pointer;">상세▼</font>
							</td>
						</tr>
					</tbody>
				</table>							
			</div>	
		</c:forEach>

		<h3 style="text-align: center;">
		<c:forEach begin="1" end="${response['pagingEnd']}" step="1" varStatus="status">
			<c:choose>
				<c:when test="${requestScope.page == status.index}">
					<a href="./reslistmng?page=${status.index}&hidSearchType=${response['hidSearchType']}&hidSearchWord=${response['hidSearchWord']}">
						<u>${status.index}</u>
					</a>
				</c:when>
				<c:otherwise>
					<a href="./reslistmng?page=${status.index}&hidSearchType=${response['hidSearchType']}&hidSearchWord=${response['hidSearchWord']}">
						${status.index}
					</a>
				</c:otherwise>
			</c:choose>	
		</c:forEach>
		</h3>	

		<div class="search">
			<form id="hidSearchForm" name="hidSearchForm" method="get">
				<input type="hidden" id="hidSearchType" name="hidSearchType">
				<input type="hidden" id="hidSearchWord" name="hidSearchWord">
			</form>
			<select class="control" id="searchType" name="searchType" style="margin: 0px 3px;">
				<option value="name"<c:out value="${response['hidSearchType']=='name'?'selected':''}" />>이름</option>
				<option value="add"<c:out value="${response['hidSearchType']=='add'?'selected':''}" />>예약장소</option>
				<option value="day"<c:out value="${response['hidSearchType']=='day'?'selected':''}" />>예약날짜</option>
				<option value="chk"<c:out value="${response['hidSearchType']=='chk'?'selected':''}" />>승인여부</option>
			</select>
			<input type="search" id="searchbox" name="searchbox" value="${response['hidSearchWord']}" /> 
			<button type="submit" id="searchBtn" name="searchBtn" style="margin: 0px 3px;">검색</button>		
		</div>	
	</div>	
<%@ include file="../home/footer.jsp" %>
</body>
<script type="text/javascript" src="./resources/js/reservation/reslist_mng.js"></script>
</html>