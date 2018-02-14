<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../header.jsp" %>
 <div class="container">    
      <div class="row row-content-wrapper">
            <div class="col-3">
                 <%@ include file="../left-navigation.jsp" %>
            </div>
            <div class="col-9">
                 <div class="card">
	                  <div class="card-header text-center">
					    List of All Users <example/>
					  </div>
                      <div class="card-body">
                            <table class="table">
								  <thead>
								    <tr>
								      <th scope="col">#</th>
								      <th scope="col">Full Name</th>
								      <th scope="col">Email Address</th>
								      <th scope="col">Action</th>
								    </tr>
								  </thead>
								  <tbody>
								      <c:forEach items="${users}" var="user" varStatus="loop">
									   <tr>
									      <th scope="row">${loop.index+1}</th>
									      <td>${user.getFullName()}</td>
									      <td>${user.getUsername()}</td>
									      <td>${user.getUsername()}</td>
									    </tr>
									</c:forEach>								    
								  </tbody>
								</table>
                      </div>
                 </div>
            </div>
      </div> 
      
  </div>
<%@ include file="../../footer.jsp" %>