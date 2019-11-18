package com.sist.customer.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.dao.NoticeDAO;

public class NoticeRegController implements Controller{
	

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pg = request.getParameter("pg");
		String field = request.getParameter("f");
		String query = request.getParameter("q");
		String urlQuery="";
		
		if(query==null || query.equals("")){
			query="";
		} else{
			urlQuery = URLEncoder.encode(query, "UTF-8");
		}
		
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		if(mid == null){
			session.setAttribute("returnURL", "/customer/noticeReg.do?pg="+pg+"&f="+field+"&q="+urlQuery);
			return "redirect:../mypage/login.do";
		} else{
			
	         System.out.println("mid =" +mid);
	         
	         request.setAttribute("pg", pg);
	         return "noticeReg.jsp";
		}
		
		
		
		

	
	}
	
	
	
	
}
