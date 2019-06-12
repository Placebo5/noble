<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.css'rel='stylesheet'/>
<link href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.print.css' rel='stylesheet' media='print'/>
<script src='https://fullcalendar.io/releases/fullcalendar/3.9.0/lib/moment.min.js'></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="resources/css/reservation/holiday.css">
</head>
<body>
 <%@ include file="../home/menu.jsp" %>
	<div class="box">
		<h2>휴무일 지정</h2><br>
		
<!-- 		달력 -->
		<div id="calendar"></div>
		
		<div class="tablebox">
		<div hidden="">
			연결되는 외부키 : <input type="text" id="pro_no" name="pro_no" value="${pro_no}">	
			<br><br>
		</div>
			<table border="1">
				<colgroup>
					<col width="100px">
					<col width="300px">
				</colgroup>
				<thead>
					<tr>
						<th>날짜</th>
						<th>설명</th>
					</tr>
				</thead>
				<tbody id="date_tb1">
				</tbody>
			</table>
			<br>
			<input type="button" id="date_in_btn" value="휴무일 입력">
		</div>
	</div>	
<%@ include file="../home/footer.jsp" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.js"></script>
</body>
<script type="text/javascript" src="./resources/js/reservation/holiday.js"></script>	
</html>