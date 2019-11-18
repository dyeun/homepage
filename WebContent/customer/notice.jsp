<%@page import="java.net.URLEncoder"%>
<%@page import="com.sist.vo.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.sist.dao.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<%

	/* List<Notice> list = (List<Notice>)request.getAttribute("list");
	int pg = (int)request.getAttribute("pg");
	String field = (String)request.getAttribute("field");
	String query = (String)request.getAttribute("query");
	String urlQuery = (String)request.getAttribute("urlQuery");
	int sPage = (int)request.getAttribute("sPage");
	int finalPage = (int)request.getAttribute("finalPage"); 
	*/
	
	


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="notice.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		
		<div id="main">
			<div class="top-wrapper clear">
				<div id="content">
					<h2>공지사항</h2>
					<h3 class="hidden">방문페이지 로그</h3>
					<ul id="breadscrumb" class="block_hlist clear">
						<li>HOME</li>
						<li>
							고객센터
						</li>
						<li>
							공지사항목록
						</li>
					</ul>
					<h3 class="hidden">공지사항 목록</h3>
					<form id="content-searchform" class="article-search-form" action="notice.do" method="get">
						<fieldset>
							<legend class="hidden">
								목록 검색 폼
							</legend>
							<input type="hidden" name="pg" value="" />
							<label for="f" class="hidden">검색필드</label>
							<select name="f">
							
								<c:if test="${field=='TITLE'}">
									<option value="TITLE" selected="selected">제목</option>
									<option value="CONTENT">내용</option>
								</c:if>
								
								<c:if test="${field=='CONTENT'}">
									<option value="TITLE">제목</option>
									<option value="CONTENT" selected="selected">내용</option>
								</c:if>
								
								
							</select>
							<label class="hidden" for="q">검색어</label>
							<input type="text" name="q" value="" />
							<input type="submit" value="검색" />
						</fieldset>
					</form>
					<table class="article-list margin-small">
						<caption class="hidden">
							공지사항
						</caption>
						<thead>
							<tr>
								<th class="seq">번호</th>
								<th class="title">제목</th>
								<th class="writer">작성자</th>
								<th class="regdate">작성일</th>
								<th class="hit">조회수</th>
							</tr>
						</thead>
						<tbody>
							<%-- <% for(int i=0; i<list.size(); i++) { %> --%>
							<c:forEach var="n" items="${list}">
								<tr>
									<td class="seq">${n.seq}</td>
									<td class="title"><a href="noticeDetail.do?seq=${n.seq}&pg=${pg}&f=${field}&q=${urlQuery}&hitUp=on">${n.title}</a></td>
									<td class="writer">${n.writer}</td>
									<td class="regdate">${n.regdate}</td>
									<td class="hit">${n.hit}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<p class="article-comment margin-small">
						<a class="btn-write button" href="noticeReg.do">글쓰기</a>
						<a href="../index2.jsp">되돌아가기</a>
					</p>
					<p id="cur-page" class="margin-small">
						<span class="strong">${pg}</span> / ${finalPage} page
					</p>
					<div id="pager-wrapper" class="margin-small">
						<div class="pager clear">
							<p id="btnPrev">
							<%-- <%if(sPage != 1){ %> --%>
							<c:if test="${sPage != 1}">
								<a class="button btn-prev" href="notice.do?pg=${sPage-1}&pg=${pg}&f=${field}&q=${urlQuery}">이전</a>
							</c:if>
							</p>
							<ul>
							<%-- <% for(int i=0; i<5; i++){ %> --%>
							<c:forEach var="i" begin="0" end="4" >
								<li>
								<c:if test="${i+sPage<=finalPage}">
									<c:if test="${i+sPage == pg}">
										<a class="strong" >${sPage+i}</a>
									</c:if>
									<c:if test="${i+sPage != pg}">
										<a  href="notice.do?pg=${i+sPage}&pg=${pg}&f=${field}&q=${urlQuery}">${i+sPage}</a>
									</c:if>
								</c:if>
								</li>
							</c:forEach>
							</ul>
							<p id="btnNext">
								<%-- <%if(sPage+4 < finalPage){ %> --%>
								<c:if test="${sPage+4 < finalPage}">
								<a class="button btn-next" href="notice.do?pg=${sPage+5}&pg=${pg}&f=${field}&q=${urlQuery}">다음</a>
								</c:if>
							</p>
						</div>
					</div>
				</div>
				
			</div>
		</div>
		
	</body>
</html>
							