<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="deleteProc.do" method="post"> 
		<p>정말 탈퇴하시겠습니까?</p>
		<input type="submit" class="btn btn-danger" value="확인"/>
		<a href="welcomelogin.do" class="btn btn-dark">되돌아가기</a>
		</form>
	</div>

</body>
</html>