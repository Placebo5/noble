<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%-- <% request.setCharacterEncoding("UTF-8"); %>    --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.css'rel='stylesheet'/>
	<link href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.print.css' rel='stylesheet' media='print'/>
	<script src='https://fullcalendar.io/releases/fullcalendar/3.9.0/lib/moment.min.js'></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="resources/css/reservation/reservergs.css">
</head>
<body>
<%@ include file="../home/menu.jsp" %>
	<div class="box">
		<h2>예약</h2><br>
		<div class="middle_box">
			<div id="calendar"></div>		
		 	
	  		<div class="time_select">
	  			<div class="time_title"  id="tiem" >
	  				날짜를 선턱해주세요	
	  			</div>
	  				<ul id="tiem" class="lst_time" style="text-align: left;" >	

		  			</ul>	
	  		</div><!-- time_select	 -->  
		</div><!-- middle_box -->  
				
  		<div class="middle_box">
	  		<div class="addition">
	  			<h4>예약시 참고사항</h4> <hr>	
	  			<div style="font-size: 15px;">
		  			승인여부를 필히 확인바라며<br>
		  			취소는 전화로 문의주세요
	  			</div>		
	  		</div>	<!-- addition -->  
	  		<div class="info">
	  			<h4>예약자 정보</h4> <hr>
	  			<table >
	  				<thead>
	  					<tr>
		  					<th>예약자</th>
		  					<td><input type="text" id="res_nm" name="res_nm" maxlength="6" style="width: 130px" ></td>			
		  					<th>날짜</th>
		  					<td><input type="text" readonly="readonly" id="res_date" name="res_date" style="width: 130px" /></td>
	  					</tr>
	  				</thead>
		  			<tbody id="date_tbl">
	  					<tr>
	  						<th>연락처</th>
	  						<td><input type="tel" maxlength="13" id="res_tel" name="res_tel" style="width: 130px" ></td>
		  					<th>시간</th>
		  					<td><input type="text" readonly="readonly" id="res_time" name="res_time" style="width: 130px" /></td>
		  				</tr>
		  				<tr>
		  					<th>요청사항</th>
		  					<td colspan="3"><input type="text" size="38px" id="res_contents" name="res_contents"></td>
		  				</tr>
	  				</tbody>
	  			</table>
	  		</div>	<!-- info -->  
	  		<div class="insres">
	  			<button id="insresBtn" style="font-size: 15px;">예약 신청</button>
			</div>
  		</div>	<!-- middle_box -->  
		<div hidden="">
			<input type="text" id="pro_no" name="pro_no" value="${pro_no}" >
			<input type="text" id="user_no" name="user_no" value="${userSession.user_no}" >
			<br><br>
		</div>
	</div><!-- box -->	
<%@ include file="../home/footer.jsp" %>	
<script src='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.js'></script>
</body>
<script type="text/javascript" src="./resources/js/reservation/reservergs.js"></script>
</html>