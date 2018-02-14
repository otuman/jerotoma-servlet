package com.jerotoma.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jerotoma.helpers.AppConfig;

@WebServlet(
   description="",
   urlPatterns= {
		   "/dashboard/products",
		   "/dashboard/products/create",
		   "/dashboard/products/edit"
		   
   }
)
public class ProductController extends HttpServlet {
	
	

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getRequestURI().endsWith("products")) {
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(AppConfig.baseViewPath+"dashboard/products/index.jsp");
			 dispatcher.forward(req, resp);
			 return;
			 
		 }else if(req.getRequestURI().endsWith("edit")) {
			 
			 RequestDispatcher dispatcher = req.getRequestDispatcher(AppConfig.baseViewPath+"dashboard/products/edit.jsp");
			 dispatcher.forward(req, resp);
			 return;
			 
		 }else if(req.getRequestURI().endsWith("create")) {
			 RequestDispatcher dispatcher = req.getRequestDispatcher(AppConfig.baseViewPath+"dashboard/products/create.jsp");
			 dispatcher.forward(req, resp);
			 return;
		 }
		 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	

}
