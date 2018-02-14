package com.jerotoma.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jerotoma.helpers.AppConfig;
import com.jerotoma.helpers.DateProcessor;
import com.jerotoma.model.User;
import com.jerotoma.services.UserService;

@WebServlet(
		description="This is the Register Controller",
		urlPatterns= {"/dashboard/users","/dashboard/users/create","/dashboard/users/edit","/account/register"}
	)
public class RegisterServletController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserService userService;

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 if(req.getRequestURI().endsWith("users")) {
			 requestUsers(req, resp);
		 }else if(req.getRequestURI().endsWith("edit")) {
			 
			 RequestDispatcher dispatcher = req.getRequestDispatcher(AppConfig.baseViewPath+"dashboard/users/edit.jsp");
			 dispatcher.forward(req, resp);
			 return;
			 
		 }else if(req.getRequestURI().endsWith("create")) {
			 RequestDispatcher dispatcher = req.getRequestDispatcher(AppConfig.baseViewPath+"dashboard/users/create.jsp");
			 dispatcher.forward(req, resp);
			 return;
		 }
		 else if(req.getRequestURI().endsWith("register")) {
			 RequestDispatcher dispatcher = req.getRequestDispatcher(AppConfig.baseViewPath+"auth/register.jsp");
			 dispatcher.forward(req, resp);
			 return;
		 }
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		userService = new UserService();
		String username  = req.getParameter("username");
		String password  = req.getParameter("password");
		String firstName = req.getParameter("first_name");
		String lastName  = req.getParameter("last_name");;
		String confirmPassword =req.getParameter("confim_password");;
		
		if(!username.equals("") && !password.equals("") && !firstName.equals("") && 
		   !lastName.equals("") && !confirmPassword.equals("")) {
			
			if(confirmPassword.equals(password)) {
				
				user.setUsername(username);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setPassword(password);
				user.setCreatedOn(DateProcessor.getCurrentSQLDate());
				user.setUpdatedOn(DateProcessor.getCurrentSQLDate());
		        
				User userSaved = userService.save(user);
				
				System.out.println(userSaved.getFirstName());
				
			}			
		}		
		RequestDispatcher dispatcher = req.getRequestDispatcher(AppConfig.baseViewPath+"dashboard/users/create.jsp");
		dispatcher.forward(req, resp);
		return;
		
		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	public void requestUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 userService = new UserService();
	     req.setAttribute("users", userService.getUsers());
		 RequestDispatcher dispatcher = req.getRequestDispatcher(AppConfig.baseViewPath+"dashboard/users/index.jsp");
		 dispatcher.forward(req, resp);
		 return;
	}
   
	
}
