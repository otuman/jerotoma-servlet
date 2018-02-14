package com.jerotoma.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jerotoma.helpers.AppConfig;

/**
 * Servlet implementation class ShopController
 */
@WebServlet(
	description="",
	urlPatterns= {
		"/shop", 
		"/shop/on-sale",
		"/shop/wishlist",
		"/shop/cart"
	})
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getRequestURI().endsWith("shop")) {
			 RequestDispatcher dispatcher = req.getRequestDispatcher(AppConfig.baseViewPath+"pages/shop/index.jsp");
			 dispatcher.forward(req, resp);
			 return;
		 }else if(req.getRequestURI().endsWith("on-sale")) {
			 
			 RequestDispatcher dispatcher = req.getRequestDispatcher(AppConfig.baseViewPath+"pages/shop/on-sale-item.jsp");
			 dispatcher.forward(req, resp);
			 return;
			 
		 }else if(req.getRequestURI().endsWith("wishlist")) {
			 RequestDispatcher dispatcher = req.getRequestDispatcher(AppConfig.baseViewPath+"pages/shop/wishlist/index.jsp");
			 dispatcher.forward(req, resp);
			 return;
		 }else if(req.getRequestURI().endsWith("cart")) {
			 RequestDispatcher dispatcher = req.getRequestDispatcher(AppConfig.baseViewPath+"pages/shop/cart/index.jsp");
			 dispatcher.forward(req, resp);
			 return;
		 }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
