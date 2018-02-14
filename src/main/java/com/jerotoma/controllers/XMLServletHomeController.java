package com.jerotoma.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XMLServletHomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
				
		System.out.println("Hello from xml config"); 
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String username  = req.getParameter("username");
		if(!username.equals("")) {
			out.println("Hello "+ username);	
		}else {
			out.println("No user was posted");
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String username  = req.getParameter("username");
		String password  = req.getParameter("password");
		
		
		if(username != null && password != null) {
			out.println("Hello "+ username);
			out.println("Password "+ password);	
		}else {
			out.println("No user was posted");
		}
	}

	
	
	

}
