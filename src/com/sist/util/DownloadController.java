package com.sist.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import com.sist.controller.Controller;

public class DownloadController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getParameter("p");
		String fname = request.getParameter("f");
		
		String urlPath = path+"/"+fname;
		String realPath = request.getServletContext().getRealPath(urlPath);
		System.out.println("urlPath = "+urlPath);
		System.out.println("realPath = "+realPath);
		
		
		String newfname = new String(fname.getBytes(), "ISO-8859-1");
		
		
		response.setHeader("Content-Disposition", "attachment;filename="+newfname);
		
		
		FileInputStream fis = new FileInputStream(realPath);
		ServletOutputStream sout = response.getOutputStream();
		
		byte[] buf = new byte[1024];
		int size=0;
		while((size=fis.read(buf)) != -1){
			sout.write(buf);
		}
		fis.close();
		sout.close();
		
		
		return "void:";
	}

}
