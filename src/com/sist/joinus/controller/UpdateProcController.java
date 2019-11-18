package com.sist.joinus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.dao.MemberDAO;
import com.sist.vo.Member;

public class UpdateProcController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		MemberDAO dao = new MemberDAO();
		Member m = dao.getMember(mid);
		String pwd = request.getParameter("pwd");
		String pwd2 = request.getParameter("pwd2");
			
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		
		int iage= Integer.parseInt(age);
		
		if(!(pwd.equals(pwd2))){
			System.out.println("비밀번호가 서로 다릅니다.");
			return "update.jsp";
		} else{ 
			m.setPwd(pwd);
			m.setName(name);
			m.setGender(gender);
			m.setBirthday(birthday);
			m.setPhone(phone);
			dao.modifyMember(m);
			
			return "redirect:welcomelogin.do";
		}
		
	}

}
