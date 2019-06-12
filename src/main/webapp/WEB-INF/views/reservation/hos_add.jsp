<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="resources/css/reservation/hos_add.css">
</head>
<body>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c99bf0aefa7b92ee2d6320ed4f6fdff7&libraries=services,clusterer,drawing"></script>
<%@ include file="../home/menu.jsp" %>
	 <div id="map"></div>
	 <input type="hidden" id="objectAdd" name="objectAdd" value="${vo.comp_add}">
	 <input type="hidden" id="objectName" name="objectName" value="${vo.comp_name}">	
<%@ include file="../home/footer.jsp" %>
</body>
<script type="text/javascript" src="./resources/js/reservation/hos_add.js"></script>
</html>