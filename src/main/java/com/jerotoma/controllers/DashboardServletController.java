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
 * Servlet implementation class DashboardServletController
 */
@WebServlet("/dashboard")
public class DashboardServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RequestDispatcher dispatcher;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(null == request.getSession().getAttribute("user")) {
			response.sendRedirect(request.getContextPath()+"/account/login");
			return;
		}
		dispatcher = request.getRequestDispatcher(AppConfig.baseViewPath+"dashboard/dashboard.jsp");
		dispatcher.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
