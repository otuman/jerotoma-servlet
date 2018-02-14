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
					    Add New User
					  </div>
                      <div class="card-body">
                            <form method="POST" action="<c:url value='/dashboard/users/create'></c:url>">
							  <div class="form-group">
							    <label for="first_name">First Name:</label>
							    <input type="text" class="form-control" name="first_name" id="first_name" placeholder="First Name">
							  </div>
							  <div class="form-group">
							    <label for="last_name">Last Name:</label>
							    <input type="text" class="form-control" name="last_name" id="last_name" placeholder="Last Name">
							  </div>
							  <div class="form-group">
							    <label for="email">Email Address:</label>
							    <input type="email" class="form-control" name="username" id="email" placeholder="Email Address (Username)">
							  </div>
							  <div class="form-group">
							    <label for="pwd">Password:</label>
							    <input type="password" class="form-control" name="password" id="pwd" placeholder="Password">
							  </div>
							  <div class="form-group">
							    <label for="cpwd">Confirm Password:</label>
							    <input type="password" class="form-control" name="confim_password" id="cpwd" placeholder="Confirm Password">
							  </div>
							  <button type="submit" class="btn btn-primary">Submit</button>
							</form>
                      </div>
                 </div>
            </div>
      </div>  
  </div>
<%@ include file="../../footer.jsp" %>