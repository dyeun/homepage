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

public class NoticeEditProcController implements Controller{




	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
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



		String seq = request.getParameter("seq");
		System.out.println("seq= "+seq);
		NoticeDAO dao = new NoticeDAO();
		Notice n = dao.getNotice(seq);

		String title = request.getParameter("title");
		String txtContent = request.getParameter("content");

		n.setTitle(title);
		n.setContent(txtContent);

		int af = dao.modifyNotice(n);
		if (af == 1) {
			System.out.println("수정완료");
			//response.sendRedirect("noticeDetail.do?seq="+seq+"&pg="+pg+"&f="+field+"&q="+urlQuery);
			return "redirect:noticeDetail.do?seq="+seq+"&pg="+pg+"&f="+field+"&q="+urlQuery;
		} else {
			System.out.println("수정실패");
			return null;
		}


		
		
		
	}










}
