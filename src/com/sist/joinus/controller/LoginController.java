package com.sist.joinus.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.dao.NoticeDAO;
import com.sist.util.CookieManager;
import com.sist.vo.Notice;

public class LoginController implements Controller{



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] coos = request.getCookies();
		String cookieMid = CookieManager.getCookie(coos, "mid");
		String cookiePwd = CookieManager.getCookie(coos, "pwd");


		System.out.println("cookieMid : "+cookieMid);
		System.out.println("cookiePwd : "+cookiePwd);

		/*if((cookieMid!=null && !cookieMid.equals("")) && (cookiePwd!=null && !cookiePwd.equals(""))){
			return "redirect:login.do?mid="+cookieMid+"&pwd"+cookiePwd;
		} else {*/

			if(cookieMid!=null && !cookieMid.equals("")){
				request.setAttribute("cookieMid", cookieMid);
			}

			if(cookiePwd!=null && !cookiePwd.equals("")){
				request.setAttribute("cookiePwd", cookiePwd);
			}

			String error = request.getParameter("error");
			if(error != null && !error.equals("")) {	
				if(error.equals("IDx")){
					error="아이디 오류";
				} else if(error.equals("PWDx")){
					error="비밀번호 오류";
				}
				request.setAttribute("error", error);
			}

			return "login.jsp";

		}

	//}


}
