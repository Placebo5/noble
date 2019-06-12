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
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.5.0/css/all.css' integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU' crossorigin='anonymous'>
<link rel="stylesheet" href="resources/css/home/main.css">
</head> 
<body>
<%@ include file="./menu.jsp" %>	
	<div class="image">
		 <img src="./resources/images/main.png" alt="5Terre" width="1000" height="700">
	</div>
	
	<div class="mainhadan">
		<section class="mainleft">
			<h2>
				<a href="./hoslist" class="sectionmore">예약 바로가기</a>
			</h2>
			<span class="more">
				<a href="./hoslist" style="font-size:13pt; font-weight: bold;" class="sectionmore">+</a>
			</span>
			<a href="./hoslist"><i class='far fa-hospital' style='font-size:65px; padding: 30px;'></i></a>
			<a href="./cafelist"><i class='fas fa-coffee' style='font-size:65px; padding: 30px; ' ></i></a>
			<a href="./salonlist">
			<img src="./resources/images/salon.png" style="width: 68px; height: 68px; margin: 15px 0px 0px 30px;">
			</a>
		</section>
		
		<section class="maincenter">
			<h2>
				<a href="./potolist" class="sectionmore">오늘의 셀럽</a>
			</h2>
			<span class="more">
				<a href="./potolist" style="font-size: 13pt; font-weight: bold;" class="sectionmore">+</a>
			</span>
			<div class="todaypoto">	
				<c:forEach var="vo" items="${response['potolist']}" varStatus="status">
					<div class="potobox">
						<div>
							<img alt="엑박" src="/${vo.fileat}" width="100px" height="100px">					
						</div>
						<div>
							<a href="./potodetail?comm_no=${vo.comm_no}" class="sectionmore" >
								${vo.comm_title}</a>
						</div>						
					</div>
				</c:forEach>
			</div>
		</section>
		
		<section class="mainright">
			<h2>
				<a href="./freelist" class="sectionmore" >펫 TALK</a>
			</h2>	
			<span class="more">
				<a href="./freelist" style="font-size: 13pt; font-weight: bold;" class="sectionmore">+</a>
			</span>
			<ul class="ptalk">
				<li class="fixptalk">
					<c:forEach var="vo" items="${response['list']}" varStatus="status">
						<dl>
							<dt>
								<a href="./freedetail?comm_no=${vo.comm_no}" class="sectionmore" >${vo.comm_title}</a>
							</dt>
							<dd style="float: right;" >${vo.comm_date}</dd>
						</dl>
					</c:forEach>
				</li>
			</ul>
		</section>
	</div>
<%@ include file="./footer.jsp" %>	
</body>
</html>