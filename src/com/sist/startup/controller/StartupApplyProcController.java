package com.sist.startup.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.dao.ApplyDAO;
import com.sist.vo.Apply;

public class StartupApplyProcController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String store = request.getParameter("store");
		String content = request.getParameter("content");
		
		ApplyDAO dao = new ApplyDAO();
		Apply a = new Apply();
		List<Apply> list = new ArrayList<>();
		list=dao.getApps();
		
		a.setName(name);
		a.setPhone(phone);
		a.setEmail(email);
		a.setStore(store);
		a.setContent(content);
		System.out.println("오류확인할게요");
		System.out.println(name);
		System.out.println(phone);
		System.out.println(email);
		System.out.println(store);
		System.out.println(content);
		
		
		int af = dao.addApply(a);
		
		if(af==1){
			System.out.println("신청서추가성공");
			return "../index2.jsp";
			
		}else{
			System.out.println("신청서추가실패");
			return "../index2.jsp"; 
		}
		
		
	
	}

}
