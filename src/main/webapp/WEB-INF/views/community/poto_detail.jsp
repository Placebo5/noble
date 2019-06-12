<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘의 셀럽</title>
<script src="./resources/ckeditor/ckeditor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/community/poto_detail.css">
</head>
<body>
<%@ include file="../home/menu.jsp" %>
	<div class="detailbox">
		<h2>오늘의 셀럽</h2>
		<br>
		<table class="tablebox" style="width: 938px;">
			<colgroup>
				<col width="500">
				<col width="138">
				<col width="100">
				<col width="200">
			</colgroup>
			<tr>
				<th style="text-align: left; font-size: 18px; padding-bottom: 5px;">${response['poro_detail_vo'].comm_title}</th>
				<td>작성자 : ${response['poro_detail_vo'].user_id}</td>
				<td colspan="2" style="text-align: right;">${response['poro_detail_vo'].comm_date}&nbsp;</td>
			</tr>
			<tr style="border-top: 1px solid gray;	border-bottom: 1px solid gray; ">
				<td colspan="4">
					<span style="display: block; min-height: 400px; max-width: 960px; overflow:overlay;padding: 10px;">
						${response['poro_detail_vo'].comm_contents}
					</span>
				</td>			
			</tr>
			<tr>
				<td colspan="4">
				댓글▼ 
	 			조회수 : ${response['poro_detail_vo'].comm_view} 
				좋아요 : <span id="potoLikeCnt"> ${response['poro_detail_vo'].comm_like}</span>
				<font color ="red"><span id="potoLike" style="cursor:pointer;">♥</span></font>
				</td>
			</tr>
			<tr>
				<td colspan="3">
	 			<textarea cols="120" rows="4" id="come_contents" style="resize: none;"></textarea>
				</td>				
				<td align="center" style="cursor:pointer;"><span id="commbtn">등록</span></td>
			</tr>
		</table>
		<input type="hidden" id="hidNo" value="${response['poro_detail_vo'].user_no}" >
		<input type="hidden" id="hidCommNo" value="${response['poro_detail_vo'].comm_no}" >
		<textarea id="hidComm_contents" style="display:none;">${response['poro_detail_vo'].comm_contents}</textarea>
		<input type="hidden" id="hidFileNm" value="${response['poro_detail_vo'].fileat}">
		<br>
		<div class="box">
			<c:if test="${userSession != null && userSession.user_no ==
					poro_detail_vo.user_no || userSession.mng_yn == 1}">
				<span style="cursor:pointer;">
					<a href="./potomodify?comm_no=${response['poro_detail_vo'].comm_no}" id="modifypoto">수정</a>
				</span>
				&nbsp;&nbsp;
				<span id="delpoto" style="cursor:pointer;">
					삭제
				</span>
			</c:if>
		</div>
		<h3>댓글▼</h3>
		<table width="100%">
			<colgroup>
				<col width="15%">
				<col width="75%">
				<col width="10%">
			</colgroup>
			<tbody id="replyTable">
				<c:forEach var ="vo" items="${response['reply_list']}" varStatus="status">
					<tr>
						<td style="padding-left: 10px;">${vo.user_id}</td>
						<td>${vo.come_contents}</td>
						<td style="text-align: center;">${vo.come_date}</td>
					</tr>
					<tr>
						<td colspan="3">
							<hr width="100%">
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>				
	</div>
<%@ include file="../home/footer.jsp" %>
</body>
<script type="text/javascript" src="./resources/js/community/poto_detail.js"></script>
</html>