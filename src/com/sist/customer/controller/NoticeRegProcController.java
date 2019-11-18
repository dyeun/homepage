package com.sist.customer.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.controller.Controller;
import com.sist.dao.NoticeDAO;
import com.sist.vo.Notice;

public class NoticeRegProcController implements Controller{

	


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String path = "/customer/upload";
		String realPath = request.getServletContext().getRealPath(path);
		System.out.println("realPath : "+realPath);
		
		MultipartRequest mulReq = new MultipartRequest(request, realPath, 10*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		String fileSrc = mulReq.getFilesystemName("file");
		String orifileSrc = mulReq.getOriginalFileName("file");
		System.out.println("fileSrc : "+fileSrc);
		System.out.println("orifileSrc : "+orifileSrc);
		
		
		
		String mid = (String)session.getAttribute("mid");
		String title = mulReq.getParameter("title");
		String content = mulReq.getParameter("content");

		String _pg = request.getParameter("pg");
		String field = request.getParameter("f");
		String query = request.getParameter("q");

		
		
		
		
		int pg ;	
		if(_pg!=null && !_pg.equals("")){
			pg = Integer.parseInt(_pg);
		}else{
			pg=1;
		}

		if(field==null || field.equals("")){
			field="TITLE";
		}

		if(query==null || query.equals("")){
			query="";
		}

		NoticeDAO dao = new NoticeDAO();
		Notice n = new Notice();
		List<Notice> list = new ArrayList<>();
		list = dao.getNotices(pg, field, query);
		


		n.setTitle(title);
		n.setContent(content);
		n.setWriter(mid);
		n.setFileSrc(fileSrc);

		int check=0;
		for(int i=0; i<list.size(); i++){
			int iSeq = Integer.parseInt(list.get(i).getSeq());
			if(iSeq>check){
				check=iSeq;
			} 
		}

		String seq = Integer.toString(check+1);

		n.setSeq(seq);
		int af = dao.addNotice(n);
		if(af==1){
			System.out.println("게시글추가성공");
			return "redirect:notice.do";
			
		}else{
			System.out.println("게시글추가실패");
			return "redirect:notice.do";
		}
			
		

		

	}


}
