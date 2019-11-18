package com.sist.joinus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.dao.MemberDAO;
import com.sist.vo.Member;

public class LoginProcController implements Controller{

	


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mid = request.getParameter("mid");
	 	String pwd = request.getParameter("pwd");
	 	String checkBoxMid = request.getParameter("checkBoxMid");
	 	
	 	String ServletContextA = request.getServletContext().getInitParameter("context_param_test");
		System.out.println("ServletContextA : "+ServletContextA);
	 	
	 	Member m = new Member();
	 	MemberDAO dao = new MemberDAO();
	 	
	 	m=dao.getMember(mid);
	 	if(m==null){
	 		System.out.println("�������� �ʴ� ���̵��Դϴ�.");
	 		return "redirect:login.do?error=IDx";
	 	} else if(!(m.getPwd().equals(pwd))) {
	 			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
	 			return "redirect:login.do?error=PWDx";
	 	} else {
	 		System.out.println("�α��� ����");
	 		request.getSession().setAttribute("mid", mid);
	 		request.setAttribute("pwd", pwd);
	 		
	 		if(checkBoxMid!=null && !checkBoxMid.equals("")){
	 			Cookie ck = new Cookie("mid", mid);
		 		ck.setMaxAge(60*60*24*30);
		 		System.out.println("mid��Ű����");
		 		response.addCookie(ck);
		 		
		 		Cookie ck2 = new Cookie("pwd", pwd);
		 		ck.setMaxAge(60*60*24*30);
		 		System.out.println("pwd��Ű����");
		 		response.addCookie(ck2);
	 		} else{
	 			Cookie ck = new Cookie("mid", null);
		 		ck.setMaxAge(0);
		 		System.out.println("mid��Ű����");
		 		response.addCookie(ck);
		 		
		 		Cookie ck2 = new Cookie("pwd", null);
		 		ck.setMaxAge(0);
		 		System.out.println("pwd��Ű����");
		 		response.addCookie(ck2);
	 		}
	 		
	 		String returnURL = (String)request.getSession().getAttribute("returnURL");
	 		if(returnURL!=null && !returnURL.equals("")){
	 			String contextRootName=request.getContextPath();
	 			System.out.println("contextRootName = "+contextRootName);
	 			return "redirect:"+contextRootName+returnURL;
	 		}
	 		
	 		return "redirect:welcomelogin.do";
	 		
	 	}
	 	
	 	
	}



	
}
