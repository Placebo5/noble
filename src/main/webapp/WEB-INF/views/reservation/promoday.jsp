<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="resources/css/reservation/promoday.css">
<table style="padding:20px;">
	<colgroup>
		<col width="50px">
		<col width="200px">
		<col>
	</colgroup>		
	
	<tbody>
		<tr>
			<th style="width: 150px;">요일</th>
			<th style="width: 400px;">영업시간</th>
			<th style="width: 150px;">휴무</th>
		</tr>

		<c:forEach var="day" items="${listDay}" varStatus="status">
			<tr class="trselect">
				<td><input type="hidden" id="week_day" name="week_day" value="${status.index}" />${day}</td>
				<td>
					<select id="start_time" name="start_time" style="height: 25px;" >
						 <option value="0">시간 선택</option>
						 <option value="800">08:00</option>
						 <option value="900">09:00</option>
						 <option value="1000">10:00</option>
						 <option value="1100">11:00</option>
						 <option value="1200">12:00</option>
					</select>
					~
					<select id="end_time" name="end_time" style="height: 25px;">
						 <option value="0">시간 선택</option>
						 <option value="1200">12:00</option>
					 	 <option value="1300">13:00</option>
						 <option value="1400">14:00</option>
						 <option value="1500">15:00</option>
						 <option value="1600">16:00</option>
						 <option value="1700">17:00</option>
						 <option value="1800">18:00</option>        
					</select>
				</td>
				<td>
					<input type="checkbox" id="holiday" name="holiday" value="0" />
				</td>
			</tr>
		</c:forEach>

	</tbody>
</table>
