<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘의 셀럽</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/community/poto_list.css">
</head>
<body>
 	<%@ include file="../home/menu.jsp" %>
 	<div class="total">
	 	<section class="list"> 	
			<div>
				<h2>오늘의 셀럽</h2>					
				<div class="Searchbox">
					<form id="hidSearchForm" name="hidSearchForm" method="get">
						<input type="hidden" id="hidSearchType" name="hidSearchType" />
						<input type="hidden" id="hidSearchWord" name="hidSearchWord" />
					</form>
					<select class="form-control" id="searchType" name="searchType">
						<option value="title"<c:out value="${response['hidSearchType']=='title'?'selected':''}" />>제목</option>
						<option value="contents"<c:out value="${response['hidSearchType']=='contents'?'selected':''}" />>내용</option>
						<option value="write"<c:out value="${response['hidSearchType']=='write'?'selected':''}" />>작성자</option>
						<option value="tc"<c:out value="${response['hidSearchType']=='tc'?'selected':''}" />>제목+내용</option>
					</select>
					<input type="search" id="potoSearch" name="potoSearch" style="margin: 0px 3px;" value="${response['hidSearchWord']}"/> 
					<button type="submit" class="Search" style="margin: 0px 3px;">검색 </button>
				</div>
			</div>
	 		<div class="box">
				<div class="best">
				 <h3 style="display: flex;">&nbsp;Best 셀럽<img src="./resources/images/king.bmp" style="width: 35px; height: 30px;"></h3>
				  	<c:forEach var="best" items="#{response['best_list']}" varStatus="status">
						  <div class="col-md-best">
						  	<a href="./potodetail?comm_no=${best.comm_no}">
						  	<img src="/${best.fileat}" width="200" height="200">					  	
						  		&nbsp;${best.comm_title}<br><br>
						 		&nbsp;${best.user_id}
						 		<span style="float: right;">
							 		<span  style="color:red;">
							 			♥
							 		</span>
							 		좋아요 ${best.comm_like}&nbsp;				 		
						 		</span>
						 	</a>	
						  </div>
				  	</c:forEach>		  
				</div>
				<div class="row" style="padding-top: 20px;">  
					<c:forEach var="vo" items="${response['potolist']}" varStatus="status">
						<div class="col-md-3">
						  	<a href="./potodetail?comm_no=${vo.comm_no}">
						  	<img src="/${vo.fileat}" width="200" height="200">	
						 		&nbsp;${vo.comm_title}<br><br>
						 		&nbsp;${vo.user_id}
						 		<span style="float: right;">
							 		<span  style="color:red;">
							 			♥
							 		</span>
							 		좋아요 ${vo.comm_like}&nbsp;				 		
						 		</span>
						 	</a>
						</div>
					</c:forEach>
				</div> 
			</div>
			<div>
				<h3 style="text-align: center;">
					<c:forEach begin="1" end="${response['pagingEnd']}" step="1" varStatus="status">
						<c:choose>
							<c:when test="${page == status.index}">
								<a href="./potolist?page=${status.index}&hidSearchType=${response['hidSearchType']}&hidSearchWord=${response['hidSearchWord']}">
									<u>${status.index}</u>
								</a>
							</c:when>
							<c:otherwise>
								<a href="./potolist?page=${status.index}&hidSearchType=${response['hidSearchType']}&hidSearchWord=${response['hidSearchWord']}">
									${status.index}
								</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</h3>	
			</div>
			<c:choose>
				<c:when test="${userSession != null && userSession.mng_yn == '3'}">
					<h3><a href="javascript:alert('접근 권한이 없습니다.');" class="button">글쓰기</a></h3>
				</c:when>
				<c:when test="${userSession == null}">
					<h3><a href="javascript:alert('로그인 후 이용가능합니다');" class="button">글쓰기</a></h3>
				</c:when>
				<c:otherwise>
					<h3><a href="./potowrite" class="button">글작성</a></h3>
				</c:otherwise>
			</c:choose>	
	 	</section>
 	</div>
	<%@ include file="../home/footer.jsp" %>
</body>
<script type="text/javascript" src="./resources/js/community/poto_list.js"></script>
</html>