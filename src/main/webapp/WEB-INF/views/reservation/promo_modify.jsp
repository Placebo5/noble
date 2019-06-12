<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홍보글 작성</title>
<link rel="stylesheet" href="./resources/puppy_css/hoswrite.css">
<script type="text/javascript" src="http://openapi.map.naver.com/openapi/v3/maps.js?clientId=6ujHGYR9NwvKobqZL5Kq"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="./resources/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" href="resources/css/reservation/promo_write.css">
</head>
<body>
	<%@ include file="../home/menu.jsp" %>
	<form id="testForm" name="testForm" enctype="multipart/form-data">
	<div class="main">
		<div class="title_nm">병원 미용실 카페 홍보글 작성</div>
		<div class="list">
			<input type="hidden" id="user_no" name="user_no" value="${userSession.user_no}" />
			<table style="width: 700px;">
				<colgroup>
					<col width="200px">
					<col width="500px">
				</colgroup>
				<tbody>
					<tr>
						<td>사업자 형태</td>
						<td>
							<select id="pro_type" name="pro_type" style="height:25px;" >
								 <option value="0">선택</option>
								 <option value="병원">병원</option>
								 <option value="미용실">미용실</option>
								 <option value="카페">카페</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>상호</td>
						<td><input type="text" readonly="readonly" value="${userSession.comp_name}" /></td>
					</tr>	
					<tr>
						<td>사업자 주소</td>
						<td><input type="text" readonly="readonly" value="${userSession.comp_add}"  /></td>
					</tr>
					<tr>
						<td>사업자 전화번호</td> 
						<td><input type="text" id="user_tel" name="user_tel" readonly="readonly" value="${userSession.user_tel}" /></td>
					</tr>
					<tr>
				</tr>
				</tbody>
			</table>
		</div>
		<div class="promo" style="width: 700px;">
			<section id="write" style="width: 700px;">
				<table class="writetable">
				<colgroup>
					<col width="100">
					<col width="600">
				</colgroup>
				<tr>
					<th>소개</th>
					<td colspan="2" style="width: 600px;">
						<textarea rows="30" cols="95" id="pro_contents1" name="pro_contents1" maxlength="100"></textarea>
						<script> 
							CKEDITOR.replace('pro_contents1',{
			 					filebrowserUploadUrl:'./potoupload' 
			 				});
						</script>	
					</td>
				</tr>
				<tr>
					<th>파일 첨부</th>
					<td><input type="file" id="atch_file1" name="atch_file1"
							style="width:100%" /></td>
				</tr>
				<tr> 
		 			<th>파일 첨부</th> 
		 			<td><input type="file" id="atch_file2" name="atch_file2" /></td> 
		 		</tr> 
				</table>		
		
				<div>	
					<div class="add">
							<p>예약단위</p>
							<select id="pro_unit" name="pro_unit">
								 <option value="0">선택</option>
								 <option value="10">10분</option>
								 <option value="20">20분</option>
								 <option value="30">30분</option>
							</select>
					</div>
					<%@ include file="./promoday.jsp" %>
					<input type="button" id="upd_promo_btn" value="작성완료" style="font-size: 15px; float: right;" />
				</div>
			</section>
		</div>
	</div>
	</form>

<%@ include file="../home/footer.jsp" %>
</body>
<script type="text/javascript" src="./resources/js/reservation/promo_modift.js"></script>
</html>