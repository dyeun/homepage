package com.sist.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyDispatcher extends HttpServlet{

	private Map<String, Controller> conMap = new HashMap<String, Controller>();


	@Override
	public void init(ServletConfig config) throws ServletException {
		String path = config.getInitParameter("txtPath");
		String ServletContextA = config.getServletContext().getInitParameter("context_param_test");
		System.out.println("path : "+path);
		System.out.println("ServletContextA : "+ServletContextA);


		Reader rd;

		try {
			rd = new FileReader(path);
			BufferedReader br = new BufferedReader(rd);
			String readMap;
			while((readMap=br.readLine())!=null){
				System.out.println("readMap: "+readMap);
				String[] readMaps = readMap.split(" ");

				String uri = readMaps[0];
				//Controller conObject = readMaps[1];
				Controller conObject = (Controller) Class.forName(readMaps[1]).newInstance();
				conMap.put(uri, conObject);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		System.out.println("requestURI = "+requestURI);

		Controller controller = conMap.get(requestURI);

		System.out.println("controller = "+controller);
		String toMove = controller.execute(request, response);
		String[] toMoves = toMove.split(":");

		if(toMoves[0].equals("redirect")){
			response.sendRedirect(toMoves[1]);
		} else if(toMoves[0].equals("void")){
			System.out.println("void : 이동안함");
		}else{
			request.getRequestDispatcher(toMove).forward(request, response);
		}



	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request, response);
	}
	
	
	
}




