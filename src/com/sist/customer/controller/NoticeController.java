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

public class NoticeController implements Controller {
	

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String _pg = request.getParameter("pg");
		String field = request.getParameter("f");
		String query = request.getParameter("q");
		


		int pg ;	
		if(_pg!=null && !_pg.equals("")){
			 pg = Integer.parseInt(_pg);
		}else{
			pg=1;
		}
		
		String urlQuery="";
		if(field==null || field.equals("")){
			field="TITLE";
		}
		
		if(query==null || query.equals("")){
			query="";
		} else{
			urlQuery = URLEncoder.encode(query, "UTF-8");
		}
		
		NoticeDAO dao = new NoticeDAO();
		int sPage = pg - (pg-1)%5;
		int seqCount = dao.getSeqCount(field,query);
		int finalPage = seqCount/10 + (seqCount%10==0?0:1);
		
		List<Notice> list = dao.getNotices(pg, field, query);
				
		request.setAttribute("list", list);
		request.setAttribute("pg", pg);
		request.setAttribute("field", field);
		request.setAttribute("query", query);
		request.setAttribute("urlQuery", urlQuery);
		request.setAttribute("sPage", sPage);
		request.setAttribute("finalPage", finalPage);
		
		System.out.println("field =" + field);
		
		//request.getRequestDispatcher("notice.jsp").forward(request, response);
		return "notice.jsp";
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
