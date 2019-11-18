package com.sist.customer.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.dao.NoticeDAO;
import com.sist.vo.Notice;

public class NoticeDelProcController implements Controller {

	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pg = request.getParameter("pg");
		String field = request.getParameter("f");
		String query = request.getParameter("q");


		String urlQuery="";
		if(field==null || field.equals("")){
			field="TITLE";
		}

		if(query==null || query.equals("")){
			urlQuery = URLEncoder.encode(query, "UTF-8");
		}

		String seq = request.getParameter("seq");
		
		NoticeDAO dao = new NoticeDAO();
		int af = dao.deleteNotice(seq);

		
		if(af==1){
			System.out.println("게시글 삭제중 성공");
			//response.sendRedirect("notice.do?pg="+pg+"&f="+field+"&q="+urlQuery);
			return "redirect:notice.do?pg="+pg+"&f="+field+"&q="+urlQuery;
		} else{
			System.out.println("게시글 삭제중 오류 발생");
			return null;
		}
		
		
		
	}
	
	
	
	
}
