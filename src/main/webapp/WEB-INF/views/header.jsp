<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="isAuth" value="${user.isValidUser()}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${pageTitle}</title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css">  -->
<link rel="stylesheet" href="<c:url value='/resources/assets/css/app.css'></c:url>">
</head>
<body>
<div id="app">
 <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container">
      <a class="navbar-brand" href="<c:url value='/'/>">Jerotoma</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" 
			  data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
			  aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	        <a class="nav-link" href="<c:url value='/shop'/>">Shop Now</a>
	      </li>
	      <li class="nav-item"> 
	        <a class="nav-link" href="<c:url value='/shop/on-sale'/>">On Sale Items</a>       
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="<c:url value='/aboutus'/>">About Us</a>
	      </li>
	    </ul>
	    <ul class="navbar-nav ml-auto">
	      <li class="nav-item">
	        <a class="nav-link" href="<c:url value='/shop/wishlist'/>">Wishlist</a>
	      </li>
	       <li class="nav-item">
	        <a class="nav-link" href="<c:url value='/shop/cart'/>">Cart</a>
	      </li>
	       <c:if test="${!isAuth}">
		    <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
		           role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">My Account	       
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="<c:url value='/account/login'/>">Login</a>
		          <a class="dropdown-item" href="<c:url value='/account/register'/>">Register</a>
		          <div class="dropdown-divider"></div>
		          <a class="dropdown-item" href="<c:url value='/support'/>">Support</a>
		        </div>
		      </li>	
	       </c:if>
          <c:if test="${isAuth}">
          <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
	           role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${user.getFullName()}	       
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="<c:url value='/dashboard'/>">Dashboard</a>
	          <a class="dropdown-item" href="<c:url value='/support'/>">Support</a>
	          <div class="dropdown-divider"></div>
	          <a class="dropdown-item" href="<c:url value='/account/logout'/>">Logout</a>
	        </div>
	      </li>	
          </c:if>
	           
	    </ul>	    
	  </div>
  </div>  
</nav>