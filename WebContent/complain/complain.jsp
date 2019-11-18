<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>게시판글쓰기</title>
<style type="text/css">
* {
	font size: 9pt;
}

p {
	width: 600px;
	text-align: right;
}

table therd tr td {
	background-color: gray;
}
</style>

</head>
<body>
	<form action="complainProc.do" method="post" >
			<div class="p-3 mb-2 bg-danger text-white">컴플레인등록</div>
		<table border="1" summary="게시판 등록 폼">
			<colgroup>
				<col width="100" />
				<col width="500" />
			</colgroup>

			<tbody>
				<tr>
					<th align="center">제목</th>
					<td><input type="text" id="title" name="title" maxlength="50" value="" /></td>
				</tr>
				<tr>
					<th align="center">작성자</th>
					<td><input type="text" id="name" name="name" maxlength="50" value="" /></td>
				</tr>
				<tr>
					<th align="center">핸드폰번호</th>
					<td><input type="text" id="phone" name="phone" maxlength="50" value="" /></td>
				</tr>
				<tr>
					<th align="center">이메일</th>
					<td><input type="text" id="email" name="email" maxlength="50" value="" /></td>
				</tr>
				<tr>
					<th align="center">비밀번호</th>
					<td><input type="password" id="pwd" name="pwd" maxlength="50" value="" /></td>
				</tr>
				<tr>
					<td colspan="2"><textarea name="content" rows="15" cols="75"></textarea></td>
				</tr>
			</tbody>
		</table>
		<p>
			<input type="submit" value="등록" />
			<a href="../index2.jsp">취소</a>
		</p>
	</form>
</body>
</html>

