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

public class NoticeEditController implements Controller{


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String _pg = request.getParameter("pg");
		String field = request.getParameter("f");
		String query = request.getParameter("q");

		int pg;	

		if(_pg!=null && !_pg.equals("")){
			pg = Integer.parseInt(_pg);
		}else{
			pg=1;
		}	


		if(field==null || field.equals("")){
			field="TITLE";
		}

		String urlQuery="";
		if(query==null || query.equals("")){
			query="";
		} else{
			urlQuery = URLEncoder.encode(query, "UTF-8");
		}


		NoticeDAO dao = new NoticeDAO();
		String seq = request.getParameter("seq");
		Notice n = dao.getNotice(seq);


		List<Notice> list = dao.getNotices(pg, field, urlQuery);


		request.setAttribute("n", n);
		request.setAttribute("pg", pg);
		request.setAttribute("field", field);
		request.setAttribute("query", query);
		request.setAttribute("urlQuery", urlQuery);
		request.setAttribute("list", list);


		//request.getRequestDispatcher("noticeEdit.jsp").forward(request, response);

		
		return "noticeEdit.jsp";
	}



}
