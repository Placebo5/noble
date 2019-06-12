<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c99bf0aefa7b92ee2d6320ed4f6fdff7&libraries=services,clusterer,drawing"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/reservation/hoslist.css">
</head>
<body>
 <%@ include file="../home/menu.jsp" %>
	<div class="main">
		<div class="title_nm"><a href="./hoslist">병원 미용실 카페</a></div>
		<div class="add">
			<form id="hidProSearchForm" name="hidProSearchForm" method="get">
				<input type="hidden" id="hidProSearchType" name="hidProSearchType" />
				<input type="hidden" id="hidProSearchWord" name="hidProSearchWord" />
			</form>	
				<select class="pro-control" id=prosearchType name="prosearchType" style="width: 80px;"> 
					<option value="mutual"<c:out value="${response['hidProSearchType']=='mutual'?'selected':''}" />>상호</option>
					<option value="classify"<c:out value="${response['hidProSearchType']=='classify'?'selected':''}" />>분류</option>
					<option value="addr"<c:out value="${response['hidProSearchType']=='addr'?'selected':''}" />>주소</option>
				</select>
				
				<input type="search" id="freeProSearch" name="freeProSearch" value="${response['hidProSearchWord']}"/>
				<button type="submit" class="proSearch">검색</button>
		</div>
		
		 <div id="map" style="width:400px;height:600px; float: right; border: 1px solid gray;"></div>
		<div class="list">	
			<table style="width: 600px; padding: 15px;">
				<colgroup>
					<col width="200px">
					<col width="100px">
					<col width="300px">
				</colgroup>
					<tr>
						<th>상호</th>
						<th>분류</th>
						<th>주소</th>
					</tr>
 				<tbody> 
 					<c:forEach var="invo" items="${response['hoslist']}" varStatus="status"> 
 						<tr style="border-bottom: 1px solid gray;"> 
 							<td style="text-align: center; height: 30px;"><a href="./hosdetail?pro_no=${invo.pro_no}">${invo.comp_name}</a></td> 
 							<td style="text-align: center; height: 30px;">${invo.pro_type}</td> 
 							<td style="text-align: center; height: 30px;">
 								${invo.comp_add}
 								<input type="hidden" id="hidForAddr" value="${invo.comp_add}" />
 								<input type="hidden" id="hidForNm" value="${invo.comp_name}" />
 							</td> 
 						</tr>
 					</c:forEach> 
 				</tbody> 
				
			</table>
		</div>
		<h3 style="text-align: center;">
			<c:forEach begin="1" end="${response['pagingEnd']}" step="1" varStatus="status">
				<c:choose>
					<c:when test="${page == status.index}">
						<a href="./hoslist?page=${status.index}&hidProSearchType=${response['hidProSearchType']}&hidProSearchWord=${response['hidProSearchWord']}">
							<u>${status.index}</u>
						</a>
					</c:when>
					<c:otherwise>
						<a href="./hoslist?page=${status.index}&hidProSearchType=${response['hidProSearchType']}&hidProSearchWord=${response['hidProSearchWord']}">
							${status.index}
						</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:choose>
				<c:when test="${userSession != null && userSession.mng_yn == '2'}">
					<a href="javascript:alert('접근 권한이 없습니다.');" class="reservBtn">글쓰기</a>
				</c:when>
				<c:when test="${userSession == null}">
					<a href="javascript:alert('로그인 후 이용가능합니다');" class="reservBtn">글쓰기</a>
				</c:when>
				<c:otherwise>
					<a href="./promowrite" class="reservBtn">글쓰기</a>
				</c:otherwise>
			</c:choose>
		</h3>
		<input type="hidden" id="objectCompAddr" name="objectCompAddr" value="${hos_detail_vo.comp_add}" />
		<input type="hidden" id="objectCompName" name="objectCompName" value="${hos_detail_vo.comp_name}" />
	</div>
<%@ include file="../home/footer.jsp" %>
</body>
<script type="text/javascript" src="./resources/js/reservation/hoslist.js"></script>
</html>