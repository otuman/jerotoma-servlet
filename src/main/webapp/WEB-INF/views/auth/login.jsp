<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
  <div class="container">
      <div class="row row-content-wrapper">
          <div class="col-6">
                <h3>Here Is what you can do</h3>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                 Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
                when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
                <ul class="list-group-login">
				  <li class="list-item active">Cras justo odio</li>
				  <li class="list-item">Dapibus ac facilisis in</li>
				  <li class="list-item">Morbi leo risus</li>
				  <li class="list-item">Porta ac consectetur ac</li>
				  <li class="list-item">Vestibulum at eros</li>
				</ul>
            </div>
            <div class="col-6">
                 <div class="card">
	                  <div class="card-header text-center">
					    Login
					  </div>
                      <div class="card-body">
                            <form method="POST" action="<c:url value='/account/login'></c:url>">
							  <div class="form-group">
							    <label for="email">Email address:</label>
							    <input type="email" class="form-control" name="username" id="email">
							  </div>
							  <div class="form-group">
							    <label for="pwd">Password:</label>
							    <input type="password" class="form-control" name="password" id="pwd">
							  </div>
							  <div class="checkbox">
							    <label><input type="checkbox"> Remember me</label>
							  </div>
							  <button type="submit" class="btn btn-primary">Submit</button>
							</form>
                      </div>
                 </div>
                
            </div>
      </div>  
  </div>
<%@ include file="../footer.jsp" %>