<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘의 셀럽</title>
<script src="./resources/ckeditor/ckeditor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/community/poto_modify.css">
</head>
<body>
<%@ include file="../home/menu.jsp" %>
	<div class="total">	
		<div class="writebox">
			<h2>오늘의 셀럽</h2>
			<br>
			<form id="modifyform" name="modifyform">
				<table class="writetable">
					<colgroup>
						<col width="100">
						<col width="700">
					</colgroup>
					<tr>
						<th>제목
						<td><input type="text" id="comm_title" name="comm_title" size="95" maxlength="" value="${poto_vo.comm_title}"></td>
					</tr>
					<tr>
						<th>작성자
						<td><input type="text" id="writer" name="writer"  size="95" value="${poto_vo.user_id}" readonly="readonly"></td>
					</tr>
					<tr>
						<td colspan="2">
							<textarea rows="30" cols="95" id="comm_contents" name="comm_contents" 
								maxlength="100">${poto_vo.comm_contents}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							&nbsp;메인이미지 : 
<%-- 							${poto_vo.fileat} --%>
							<input type="file" id="fileat_nm" name="fileat_nm">
						</td>
					</tr>
				</table>
			</form>			
				<input type="hidden" id="user_no" name="user_no" value="${userSession.user_no}">	
				<input type="hidden" id="comm_no" name="comm_no" value="${poto_vo.comm_no}">
				<div class="modiBtn">
					<button class="Btn" style="cursor:pointer;">
					수정	
					</button>			
				</div>
		</div>
	</div>
<%@ include file="../home/footer.jsp" %>
</body>
<script type="text/javascript" src="./resources/js/community/poto_modify.js"></script>
</html>