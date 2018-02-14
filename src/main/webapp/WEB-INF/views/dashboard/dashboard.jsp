<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
 <div class="container">    
      <div class="row row-content-wrapper">
            <div class="col-3">
                 <%@ include file="left-navigation.jsp" %>
            </div>
            <div class="col-9">
                 <div class="card">
				  <div class="card-header">
				   Hello ${user.getFullName()}!
				  </div>
				  <div class="card-body">
				    <h5 class="card-title">Special title treatment</h5>
				    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
				    <a href="#" class="btn btn-primary">Go somewhere</a>
				  </div>
				</div>
            </div>
      </div>  
  </div>
<%@ include file="../footer.jsp" %>