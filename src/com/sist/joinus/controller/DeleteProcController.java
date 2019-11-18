package com.sist.joinus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.dao.MemberDAO;
import com.sist.vo.Member;

public class DeleteProcController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		MemberDAO dao = new MemberDAO();
		Member m=dao.getMember(mid);
		
		
		int af = dao.deleteMember(m);
		if (af == 1) {
			System.out.println("È¸¿øÅ»Åð¼º°ø");
			return "../index2.jsp";
		} else {
			System.out.println("È¸¿øÅ»Åð½ÇÆÐ");
			return null;
		}
		
		
	}

}
