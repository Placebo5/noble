<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫 TALK</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/community/free_list.css">
</head>
<body>
<%@ include file="../home/menu.jsp" %>
	<div class="main">
		<div>
			<h2>펫 TALK</h2>
			<div class="Searchbox">
				<form id="hidSearchForm" name="hidSearchForm" method="get">
					<input type="hidden" id="hidSearchType" name="hidSearchType" />
					<input type="hidden" id="hidSearchWord" name="hidSearchWord" />
				</form>
				<select class="form-control" id="searchType" name="searchType">
					<option value="title"<c:out value="${requestScope.response['hidSearchType']=='title'?'selected':''}" />>제목</option>
					<option value="contents"<c:out value="${requestScope.response['hidSearchType']=='contents'?'selected':''}" />>내용</option>
					<option value="write"<c:out value="${requestScope.response['hidSearchType']=='write'?'selected':''}" />>작성자</option>
					<option value="tc"<c:out value="${requestScope.response['hidSearchType']=='tc'?'selected':''}" />>제목+내용</option>
				</select>
				<input type="search" style="margin: 0px 3px;" id="freeSearch" name="freeSearch" value="${requestScope.response['hidSearchWord']}" />
				<button type="submit" class="Search" style="margin: 0px 3px;">검색 </button>
			</div>
		</div>
		<table style="width: 938px;" class="listtable">
			<colgroup>
				<col width="100px">
				<col width="300px">
				<col width="150px">
				<col width="100px">
				<col width="100px">
				<col width="100px">
			</colgroup>
			<tr style="border-top: 1px solid gray; border-bottom: 1px solid gray; height: 30px; background: lightblue;">
				<th>no</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>등록일</th>
				<th>조회수</th>
				<th>추천</th>
			</tr>
			<tbody>
				<c:forEach var="vo" items="${response['best_list']}" varStatus="status">
					<tr style="border-bottom: 1px solid gray; background: lightgoldenrodyellow;">
							<td style="text-align: center;">${vo.comm_no}</td>
							<td><b><a href="./freedetail?comm_no=${vo.comm_no}">${vo.comm_title}</a></b></td>
							<td style="text-align: center;">${vo.user_id}</td>
							<td style="text-align: center;">${vo.comm_date}</td>
							<td style="text-align: center;">${vo.comm_view}</td>
							<td style="text-align: center;">${vo.comm_like}</td>
					</tr>
				</c:forEach>
				<c:forEach var="vo" items="${response['free_list']}" varStatus="status">
					<tr style="border-bottom: 1px solid gray;">
							<td style="text-align: center;">${vo.comm_no}</td>
							<td><a href="./freedetail?comm_no=${vo.comm_no}">${vo.comm_title}</a></td>
							<td style="text-align: center;">${vo.user_id}</td>
							<td style="text-align: center;">${vo.comm_date}</td>
							<td style="text-align: center;">${vo.comm_view}</td>
							<td style="text-align: center;">${vo.comm_like}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<h3 style="text-align: center;">
			<c:forEach begin="1" end="${requestScope.response['pagingEnd']}" step="1" varStatus="status">
			<c:choose>
				<c:when test="${page == status.index}">
					<a href="./freelist?page=${status.index}&hidSearchType=${requestScope.response['hidSearchType']}&hidSearchWord=${requestScope.response['hidSearchWord']}">
						<u>${status.index}</u>
					</a>
				</c:when>
				<c:otherwise>
					<a href="./freelist?page=${status.index}&hidSearchType=${requestScope.response['hidSearchType']}&hidSearchWord=${requestScope.response['hidSearchWord']}">
						${status.index}
					</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
			<c:choose>
				<c:when test="${userSession != null && userSession.mng_yn == '3'}">
					<a href="javascript:alert('접근 권한이 없습니다.');" class="writeBtn">글쓰기</a>
				</c:when>
				<c:when test="${userSession == null}">
					<a href="javascript:alert('로그인 후 이용가능합니다');" class="writeBtn">글쓰기</a>
				</c:when>
				<c:otherwise>
					<a href="./freewrite" class="writeBtn">글쓰기</a>
				</c:otherwise>
			</c:choose>
		</h3>
	</div>	
<%@ include file="../home/footer.jsp" %>
</body>
<script type="text/javascript" src="./resources/js/community/free_list.js"></script>	
</html>