<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>육선포차(정발산점)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
   <!--<img src="images/kk.jpg" class="btn btn-danger"><br> 
   <a href="menu/menulist.jsp" class="btn btn-dark">메뉴</a>
   <a href="customer/storeMenu.jsp" class="btn btn-danger">매장</a>
   <a href="startup/startupMenu.jsp" class="btn btn-dark">창업안내</a>
   <a href="complain/complainMain.jsp" class="btn btn-danger">고객의소리</a>
   <a href="joinus/mypageMenu.jsp" class="btn btn-dark">마이페이지</a>
   -->
  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">육선포차</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">홈</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">메뉴<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${pageContext.request.contextPath }/menu/setMenu.jsp">세트메뉴</a></li>
          <li><a href="${pageContext.request.contextPath }/menu/menu2.jsp">닭발류</a></li>
          <li><a href="${pageContext.request.contextPath }/menu/menu3.jsp">찌개류, 탕류</a></li>
          <li><a href="${pageContext.request.contextPath }/menu/menu4.jsp">볶음류, 구이류</a></li>
          <li><a href="${pageContext.request.contextPath }/menu/sideMenu.jsp">사이드메뉴</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">매장<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${pageContext.request.contextPath }/customer/searchStore.jsp">다른매장찾기</a></li>
          <li><a href="${pageContext.request.contextPath }/customer/notice.do">매장이용후기</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">창업안내<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${pageContext.request.contextPath }/startup/startupProcess.jsp">창업절차</a></li>
          <li><a href="${pageContext.request.contextPath }/startup/startupApply.do">창업신청</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">고객의소리<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${pageContext.request.contextPath }/complain/complain.do">컴플레인등록</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">마이페이지<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${pageContext.request.contextPath }/joinus/login.do">로그인</a></li>
          <li><a href="${pageContext.request.contextPath }/joinus/join.do">회원가입</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>
  
<div class="container">
   <h2 class="p-3 mb-2 bg-danger text-white">육선포차(정발산점) 홈페이지에 오신걸 환영합니다.</h2>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="item active">
        <img src="${pageContext.request.contextPath }/images/11.jpg" alt="닭발" style="height: 641px; width:1141px;">
        <div class="carousel-caption">
         
        </div>
      </div>

      <div class="item">
        <img src="${pageContext.request.contextPath }/images/12.jpg" alt="로고" style="height: 641px; width:1141px;">
        <div class="carousel-caption">
         
        </div>
      </div>
    
      <div class="item">
        <img src="${pageContext.request.contextPath }/images/13.jpg" alt="육선포차" style="height: 641px; width:1141px;">
        <div class="carousel-caption">
         
        </div>
      </div>
      
      <div class="item">
        <img src="${pageContext.request.contextPath }/images/14.jpg" alt="육선포차" style="height: 641px; width:1141px;">
        <div class="carousel-caption">
         
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
	

	<div><p align="center" style="font-size:15pt;">COPYRIGHT(C) 2017 육선포차. All rights reserved</p></div>

</body>