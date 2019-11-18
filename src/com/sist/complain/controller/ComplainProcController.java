package com.sist.complain.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.dao.ComplainDAO;
import com.sist.vo.Complain;

public class ComplainProcController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String content = request.getParameter("content");
		
		ComplainDAO dao = new ComplainDAO();
		Complain c = new Complain();
		List<Complain> list = new ArrayList<>();
		list=dao.getComplains();
		
		c.setTitle(title);
		c.setName(name);
		c.setPhone(phone);
		c.setEmail(email);
		c.setPwd(pwd);
		c.setContent(content);
		
		int check=0;
		for(int i=0; i<list.size(); i++){
			int iSeq = Integer.parseInt(list.get(i).getSeq());
			if(iSeq>check){
				check=iSeq;
			} 
		}
		
		String seq = Integer.toString(check+1);
		c.setSeq(seq);
		
		int af = dao.addComplain(c);
		
		if(af==1){
			System.out.println("컴플레인추가성공");
			return "../index2.jsp";
			
		}else{
			System.out.println("컴플레인추가실패");
			return "../index2.jsp"; 
		}
		
		
		
	}

}
