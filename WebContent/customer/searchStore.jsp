<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Insert title here</title>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBtYK_Eslb31xUQotfbyW0h34btlAdyh8o"></script>
<script >
	
	
	
	
	function initMaps(){
		var mapCanvas = document.getElementById("googleMap");
		var myCenter = new google.maps.LatLng(37.672555, 126.778292);
		var mapOption = {
			center: myCenter,
			zoom: 17
		};
		var mapObj = new google.maps.Map(mapCanvas, mapOption);
		
		var marker = new google.maps.Marker({
			position:myCenter
		});
		marker.setMap(mapObj);
		
		
		//두번째 지도(목동)
		var mapCanvas2 = document.getElementById("googleMap2");
		var mapOption2 = {
			center: new google.maps.LatLng(37.549689, 126.864551),
			zoom: 17
		};
		var map2 = new google.maps.Map(mapCanvas2, mapOption2); //뉴맵을 만들거다
		
		var markerPosition = new google.maps.LatLng(37.549689, 126.864551); //위도,경도찍어줌
		var marker2 = new google.maps.Marker({   //뉴마커를 만들거야
			position:markerPosition  
		});
		marker2.setMap(map2);
		
		
		
		//영등포
		var mapCanvas3 = document.getElementById("googleMap3");
		var mapOption3 = {
			center: new google.maps.LatLng(37.523519, 126.893004),
			zoom: 17
		};
		var map3 = new google.maps.Map(mapCanvas3, mapOption3); //뉴맵을 만들거다
		
		var markerPosition = new google.maps.LatLng(37.523519, 126.893004); //위도,경도찍어줌
		var marker3 = new google.maps.Marker({   //뉴마커를 만들거야
			position:markerPosition  
		});
		marker3.setMap(map3);
		
		
		
		//봉천
		var mapCanvas4 = document.getElementById("googleMap4");
		var mapOption4 = {
			center: new google.maps.LatLng(37.484007, 126.940874),
			zoom: 17
		};
		var map4 = new google.maps.Map(mapCanvas4, mapOption4); //뉴맵을 만들거다
		
		var markerPosition = new google.maps.LatLng(37.484007, 126.940874); //위도,경도찍어줌
		var marker4 = new google.maps.Marker({   //뉴마커를 만들거야
			position:markerPosition  
		});
		marker4.setMap(map4);
		
		
		
		
		
		///김포
		var mapCanvas5 = document.getElementById("googleMap5");
		var mapOption5 = {
			center: new google.maps.LatLng(37.641271, 126.679334),
			zoom: 17
		};
		var map5 = new google.maps.Map(mapCanvas5, mapOption5); //뉴맵을 만들거다
		
		var markerPosition = new google.maps.LatLng(37.641271, 126.679334); //위도,경도찍어줌
		var marker5 = new google.maps.Marker({   //뉴마커를 만들거야
			position:markerPosition  
		});
		marker5.setMap(map5);
	
		
		
	}
	
	google.maps.event.addDomListener(window, 'load', initMaps);





</script>
</head>
<body>
	<h1 class="p-3 mb-2 bg-danger text-white">정발산점</h1>
	<div id="googleMap" style="width: 500px; height: 500px"></div>
	<p class="text-danger" style="font-size:15pt;">&nbsp;&nbsp;&nbsp;&nbsp;경기도 고양시 일산동구 일산로441번길 15-23 </p><br><br><br>
	<h1 class="p-3 mb-2 bg-dark text-white">목동점</h1>
	<div id="googleMap2" style="width: 500px; height: 500px"></div>
	<p class="text-dark" style="font-size:15pt;">&nbsp;&nbsp;&nbsp;&nbsp;서울특별시 양천구 목동중앙북로7가길 55</p><br><br><br>
	<h1 class="p-3 mb-2 bg-dark text-white">영등포점</h1>
	<div id="googleMap3" style="width: 500px; height: 500px"></div>
	<p class="text-dark" style="font-size:15pt;">&nbsp;&nbsp;&nbsp;&nbsp;서울특별시 영등포구 영등포로19길 17 </p><br><br><br>
	<h1 class="p-3 mb-2 bg-dark text-white">봉천점</h1>
	<div id="googleMap4" style="width: 500px; height: 500px"></div>
	<p class="text-dark" style="font-size:15pt;">&nbsp;&nbsp;&nbsp;&nbsp;서울특별시 관악구 봉천로 365 </p><br><br><br>
	<h1 class="p-3 mb-2 bg-dark text-white">김포점</h1>
	<div id="googleMap5" style="width: 500px; height: 500px"></div>
	<p class="text-dark" style="font-size:15pt;">&nbsp;&nbsp;&nbsp;&nbsp;경기도 김포시 김포한강2로23번길 10 라베니체마치에비뉴Ⅰ</p><br>
	
	<a href="../index2.jsp">되돌아가기</a><br>
</body>
</html>