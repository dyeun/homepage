<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="join.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<div id="main">
			<div class="top-wrapper clear">
				<div id="content">
					<form action="joinProc.do" method="post">
						<h2>회원가입</h2>
						<h3 class="hidden">방문페이지 로그</h3>
						<p id="breadscrumb" class="block_hlist clear"><img alt="Step1 개인정보 등록" src="images/step2.png" /></p>
						<h3 class="hidden">회원가입 폼</h3>
						
						<div id="join-form" class="join-form margin-large" >
							
							<dl class="join-form-row">
								<dt class="join-form-title">
									*아이디
								</dt>
								<dd class="join-form-data">
									<input type="text" name="mid" /><span> 4~12자리 영문자(단 영어로 시작)</span>
									
								</dd>
							</dl>
							<dl class="join-form-row">
								<dt class="join-form-title">
									*비밀번호
								</dt>
								<dd class="join-form-data">
									<input type="password" name="pwd"  />
								</dd>
							</dl>
							<dl class="join-form-row">
								<dt class="join-form-title">
									*비밀번호 확인
								</dt>
								<dd class="join-form-data" >
									<input type="password" name="pwd2" />
								</dd>
							</dl>
							<dl class="join-form-row">
								<dt class="join-form-title">
									*이름
								</dt>
								<dd class="join-form-data">
									<input type="text" name="name"  />
								</dd>
							</dl>
							<dl class="join-form-row">
								<dt class="join-form-title">
									*성별
								</dt>
								<dd class="join-form-data">
									<input type="radio" name="gender" id="male" value="MALE" />남자
	                                <input type="radio" name="gender" id="female" value="FEMALE" checked="checked"/>여자
								</dd>
							</dl>
							<dl class="join-form-row birthday">
								<dt class="join-form-title">
									*생년월일
								</dt>
								<dd class="join-form-data">								
	                                <span>
	                                    <input type="text" name="year" id="year"  />년
	                                    <input type="text" name="month" id="month"   />월
	                                    <input type="text" name="day" id="day"  />일
	                                </span>
	                                
								</dd>
							</dl>
							<dl class="join-form-row">
								<dt class="join-form-title">
									*나이
								</dt>
								<dd class="join-form-data">
									<input type="text" name="age"  />
								</dd>
							</dl>
							<dl class="join-form-row">
								<dt class="join-form-title">
									*핸드폰 번호
								</dt>
								<dd class="join-form-data">
									<input type="text" name="phone"  /><span> 대시(-)를 포함할 것: 예) 010-3456-2934 </span>
								</dd>
							</dl>
						
						</div>
						
					<div id="buttonLine">
						<input class="btn-okay button" type="submit" value="가입" />
						<a href="../index2.jsp">되돌아가기</a>
					</div>
					</form>
				</div>
				
			</div>
		</div>
		
	</body>
</html>
