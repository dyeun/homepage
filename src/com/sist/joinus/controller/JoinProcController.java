package com.sist.joinus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.dao.MemberDAO;
import com.sist.vo.Member;

public class JoinProcController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String pwd = request.getParameter("pwd");
		String pwd2 = request.getParameter("pwd2");
		if (!pwd.equals(pwd2)) {
			System.out.println("비밀번호가 서로 다릅니다.");
		}
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String birthday = String.format("%s-%s-%s", year, month, day);

		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		int iage = Integer.parseInt(age);

		String[] habits = request.getParameterValues("habit");

		String habit = "";
		if (habits != null && habits.length > 1) {
			for (int i = 0; i < habits.length; i++) {
				if (i == habits.length - 1) {
					habit = habit + habits[i];
				} else {
					habit = habit + habits[i] + ",";
				}
			}
		}

		Member m = new Member();
		m.setMid(mid);
		m.setPwd(pwd);
		m.setName(name);
		m.setGender(gender);
		m.setBirthday(birthday);
		m.setPhone(phone);

		MemberDAO dao = new MemberDAO();
		int af = dao.addMember(m);
		if (af == 1) {
			System.out.println("회원가입 성공");
			//response.sendRedirect("login.jsp");
			return "../index2.jsp";
		} else {
			System.out.println("회원가입 실패");
			return null;
		}
	
	
	}

	
	
}
