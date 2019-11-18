<%@page import="com.sist.dao.MemberDAO"%>
<%@page import="com.sist.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mid = (String)session.getAttribute("mid");
	MemberDAO dao = new MemberDAO();
	
	Member m = dao.getMember(mid);
	
	

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="updateProc.do" method="post"> 
			<p>아이디: <%=mid %>(수정불가)</p>
			<p>비밀번호: <input type="password" name="pwd"/></p>
			<p>비밀번호확인: <input type="password" name="pwd2"/></p>
			<p>이름: <input type="text" name="name"/></p>
			<p>성별: <input type="text" name="gender"/></p>
			<p>생년월일: <input type="text" name="birthday"/></p>
			<p>핸드폰번호: <input type="text" name="phone"/></p>
			<p>가입날짜: <%=m.getRegdate()%>(수정불가)</p>
			<input type="submit" class="btn btn-danger" value="확인"/>
			<a href="welcomelogin.do" class="btn btn-dark">되돌아가기</a>
		</form>
	</div>
	
</body>
</html>