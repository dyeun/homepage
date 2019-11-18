<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String mid = (String)session.getAttribute("mid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<p class="p-3 mb-2 bg-secondary text-white"><%=mid %> 님 환영합니다.</p>
	<a href="order.do" class="btn btn-danger">주문하기</a>
	<a href="update.do" class="btn btn-dark">회원정보수정</a>
	<a href="delete.do" class="btn btn-danger">회원탈퇴</a>
	<a href="../index2.jsp" class="btn btn-dark">메인으로이동</a>
</body>
</html>