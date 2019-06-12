<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫 TALK</title>
<script src="./resources/ckeditor/ckeditor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/community/free_write.css">
</head>
<body>
	<%@ include file="../home/menu.jsp" %>
	<div class="write">
		<h2>펫 TALK</h2><br>
		<input type="hidden" id="user_no" name="user_no" value="${userSession.user_no}">
		<table class="writetable" style="width: 938px" >
			<colgroup>
				<col width="100">
				<col width="700">
			</colgroup>
			<tr>
				<th>제목
				<td><input type="text" id="comm_title" name="comm_title" size="114" maxlength="30"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" id="writer" name="writer"  size="114" 
							style="background-color:lightgray;" readonly="readonly" value="${userSession.user_id}"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="30" cols="95" id="comm_contents" style="width: 914px;" 
										name="comm_contents" maxlength="1000"></textarea></td>
			</tr>
		</table>
				
		<br>
		<button id="writeBtn"
			style="cursor:pointer;">
			저장	
		</button>
	</div>
	<%@ include file="../home/footer.jsp" %>
</body>
<script type="text/javascript" src="./resources/js/community/free_write.js"></script>	
</html>