package com.sist.customer.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.dao.NoticeDAO;
import com.sist.vo.Notice;

public class NoticeDetailController implements Controller {



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pg = request.getParameter("pg");
		String field = request.getParameter("f");
		String query = request.getParameter("q");
		String urlQuery="";
		String seq = request.getParameter("seq");
		String hitUp = request.getParameter("hitUp");
		String fileSrc = request.getParameter("fileSrc");

		if(field==null || field.equals("")){
			field="TITLE";
		}

		if(query==null || query.equals("")){
			query="";
		} else{
			urlQuery = URLEncoder.encode(query, "UTF-8");
		}

	
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("mid")==null){
			session.setAttribute("returnURL", "/customer/noticeDetail.do?seq="+seq+"&pg="+pg+"&f="+field+"&q="+urlQuery);
			return "redirect:../joinus/login.do";
		} else{
			
			String mid = (String)session.getAttribute("mid");
			System.out.println("mid= "+mid);

			NoticeDAO dao = new NoticeDAO();
			if(hitUp != null && !hitUp.equals("")){
				dao.hitUp(seq);
			}			
			
			
			Notice n = dao.getNotice(seq);

			seq = request.getParameter("seq");

			request.setAttribute("n", n);
			request.setAttribute("pg", pg);
			request.setAttribute("field", field);
			request.setAttribute("query", query);
			request.setAttribute("urlQuery", urlQuery);
			request.setAttribute("fileSrc", fileSrc);
			
		
			
			if(n.getFileSrc()!=null){
				String urlFileName = URLEncoder.encode(n.getFileSrc(), "UTF-8");
				System.out.println("urlFileName = "+urlFileName);
				request.setAttribute("urlFileName", urlFileName);
			}


			
		}
		
		return "noticeDetail.jsp";
	}


}
