$(document).ready(function(){ 
	$(".proSearch").click(function(){ 
		if($("#freeProSearch").val() != ""){ 
//  					$("#hidProSearchType").val($("#citysearchType").val());
//  					$("#hidProSearchType").val($("#protypesearchType").val());
			$("#hidProSearchType").val($("#prosearchType").val());
			$("#hidProSearchWord").val($("#freeProSearch").val()); 
			$("#hidProSearchForm").attr("action", "./hoslist"); 
			$("#hidProSearchForm").submit(); 
		}//if 
	});//click 
});//ready 

var compAddr = $("#objectCompAddr").val();
var compNm = $("#objectCompName").val();
var container = document.getElementById('map');
var options = {
	center: new daum.maps.LatLng(33.450701, 126.570667),
	level: 7
};

var map = new daum.maps.Map(container, options);

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new daum.maps.services.Geocoder();

if (navigator.geolocation) {
    
    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
    navigator.geolocation.getCurrentPosition(function(position) {
        
        var lat = position.coords.latitude, // 위도
            lon = position.coords.longitude; // 경도
        
        var locPosition = new daum.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
            message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
        
        // 마커와 인포윈도우를 표시합니다
        displayMarker(locPosition, message);
            
      });
    
} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
    
    var locPosition = new daum.maps.LatLng(33.450701, 126.570667),    
        message = 'geolocation을 사용할수 없어요..'
        
    displayMarker(locPosition, message);
}

// 지도에 마커와 인포윈도우를 표시하는 함수입니다
function displayMarker(locPosition, message) {

    // 마커를 생성합니다
    var marker = new daum.maps.Marker({  
        map: map, 
        position: locPosition
    }); 
    
    var iwContent = message, // 인포윈도우에 표시할 내용
        iwRemoveable = true;

    // 인포윈도우를 생성합니다
    var infowindow = new daum.maps.InfoWindow({
        content : iwContent,
        removable : iwRemoveable
    });
    
    // 인포윈도우를 마커위에 표시합니다 
    infowindow.open(map, marker);
    
    // 지도 중심좌표를 접속위치로 변경합니다
    map.setCenter(locPosition);      
}

function chgAddr(compAddr,compNm) {
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(compAddr, function(result, status) {

	    // 정상적으로 검색이 완료됐으면 
	     if (status === daum.maps.services.Status.OK) {

	        var coords = new daum.maps.LatLng(result[0].y, result[0].x);

	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new daum.maps.Marker({
	            map: map,
	            position: coords
	        });

	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new daum.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+compNm+'</div>'
	        });
	        infowindow.open(map, marker);

	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        //map.setCenter(coords);
	    } 
	});
}

$(document).ready(function(){
	for(i=0; i<$("input[id=hidForAddr]").length; i++){
		//alert($("input[id=hidForAddr]")[i].value);
	/////////////////마커 표시
		chgAddr($("input[id=hidForAddr]")[i].value, $("input[id=hidForNm]")[i].value);
	}
});