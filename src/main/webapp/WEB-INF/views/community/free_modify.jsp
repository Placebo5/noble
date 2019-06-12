<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫 TALK</title>
<script src="./resources/ckeditor/ckeditor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/community/free_modify.css">
</head>
<body>
<%@ include file="../home/menu.jsp" %>
	<div class="writebox">
		<h2>펫 TALK</h2>
		<table class="writetable" style="width: 938px;">
			<colgroup>
				<col width="100">
				<col width="700">
			</colgroup>
			<tr>
				<th>제목
				<td><input type="text" id="comm_title" name="comm_title" 
					size="114" maxlength="30" value="${vo.comm_title}"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" id="writer" name="writer"  
						size="114" readonly="readonly" value="${vo.user_id}"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="30" cols="95" id="comm_contents" 
					name="comm_contents" maxlength="1000" >${vo.comm_contents}</textarea></td>
			</tr>
		</table>
		<input type="hidden" id="hidNo" value="${vo.comm_no}">	
		<br>
		<button id="modifyFree" style="cursor:pointer;">
			수정	
		</button>
	</div>
<%@ include file="../home/footer.jsp" %>
<script type="text/javascript" src="./resources/js/community/free_modify.js"></script>
</body>
</html>