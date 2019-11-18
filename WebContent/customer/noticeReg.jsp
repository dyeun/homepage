<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	/* int pg = (int)request.getAttribute("pg");
	String field = (String)request.getAttribute("field");
	String query = (String)request.getAttribute("query");
	String urlQuery = (String)request.getAttribute("urlQuery"); */
	
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="../css/customer.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<div id="main">
			<div class="top-wrapper clear">
				<div id="content">
					<h2>공지사항</h2>
					<h3 class="hidden">방문페이지위치</h3>
					<ul id="breadscrumb" class="block_hlist">
						<li>HOME</li>
						<li>
							고객센터
						</li>
						<li>
							공지사항등록
						</li>
					</ul>
					<form action="noticeRegProc.do" method="post" enctype="multipart/form-data">
						<div id="notice-article-detail" class="article-detail margin-large" >
							<dl class="article-detail-row">
								<dt class="article-detail-title">
									제목
								</dt>
								<dd class="article-detail-data">
									&nbsp;<input name="title"/>
								</dd>
							</dl>				
							
							<dl class="article-detail-row">
								<dt class="article-detail-title">
									첨부파일
								</dt>
								<dd class="article-detail-data">
									&nbsp;<input type="file" name="file"/>
								</dd>
							</dl>	
	
							<div class="article-content" >
								<textarea id="txtContent" class="txtContent" name="content"></textarea>
							</div>
						</div>
						<p class="article-comment margin-small">	
							<%-- <input type="hidden" name="mid" value="<%=mid %>"  /> --%>					
							<input class="btn-save button" type="submit" />
							<a class="btn-cancel button" href="notice.do">취소</a>						
						</p>	
					</form>
											
				</div>				
							
			</div>
		</div>
		
	</body>
</html>
