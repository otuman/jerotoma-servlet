package com.jerotoma.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jerotoma.helpers.AppConfig;
import com.jerotoma.model.User;
import com.jerotoma.services.UserService;

@WebServlet(
	description="This is the Login Controller",
	urlPatterns="/account/login"
)
public class LoginServletController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService mLoginService;
	public LoginServletController(){
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(AppConfig.baseViewPath+"auth/login.jsp");
		dispatcher.forward(req, resp);
		return;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/html");
		//PrintWriter out = resp.getWriter();
		String username  = req.getParameter("username");
		String password  = req.getParameter("password");
		
		mLoginService = new UserService();
		RequestDispatcher dispatcher;
		User authUser = mLoginService.authentication(username, password);
		if(authUser.isValidUser()) {
			//System.out.println(req.getMethod());
			HttpSession session = req.getSession();
			session.setMaxInactiveInterval(20*60);
			session.setAttribute("user", authUser);
			resp.sendRedirect(req.getContextPath()+"/dashboard");
			return;
		}
		dispatcher = req.getRequestDispatcher(AppConfig.baseViewPath+"auth/login.jsp");
		dispatcher.forward(req, resp);
		return;
				
	}
	
	
	
	
	

}
