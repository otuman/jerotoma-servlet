package com.jerotoma.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthenticationFilter",
urlPatterns = {"/*"},
initParams = { @WebInitParam(name = "mood", value = "awake")})
public class AuthenticationFilter implements Filter {

	
	private ServletContext context;


	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		  this.context = filterConfig.getServletContext();
		  this.context.log("AuthenticationFilter initialized");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//Create HttpServletRequest and HtttpServletResponse object from ServletRequest and ServletResponse respectively
			HttpServletRequest mRequest   = (HttpServletRequest) request;
		    HttpServletResponse mResponse = (HttpServletResponse) response;
		
		// Get URI from the request
		     String uri =  mRequest.getRequestURI();
		     context.log("Requested Resource::"+uri);
		     context.log("Contains dashboard? "+uri.contains("dashboard")); 
		    HttpSession session = mRequest.getSession(false);
		   
		    //Check if the URI contains "Dashboard" key word
		    if(uri.contains("dashboard")) {
		    
		    	//Check if the Session is already set
		    	if(null != session && session.getAttribute("user") != null) {
		    		 this.context.log("SESSION::ID "+session.getId());
		    	     chain.doFilter(request, response);
		    	
		    	}else{
	 				this.context.log("Unauthorized access request");
	 				mResponse.sendRedirect(mRequest.getContextPath()+"/account/login");
	 			    return;
	 				
	 			}	    
		    }else if((uri.contains("login") || uri.contains("register")) && (null != session && session.getAttribute("user") != null)) {
		    	
		    	mResponse.sendRedirect(mRequest.getContextPath()+"/dashboard");
 			    return;
		    	
		    }else {
		    	chain.doFilter(request, response);
		    }
		    
		   
		
	}
	
	
	

}
