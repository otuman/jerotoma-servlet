<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="nav flex-column left-nav-menu">
  <li class="nav-item active"><a href='<c:url value="/"></c:url>' class="nav-link">Home</a></li>
  <li class="nav-item"><a href="#" class="nav-link" id="user-menu" data-toggle="collapse" data-target="#user-submenu" aria-controls="#user-submenu" aria-expanded="false">Users</a>
	<ul class="collapse flex-column" id="user-submenu" role="menu" aria-labelledby="user-menu">
		<li class="nav-item"><a href='<c:url value="/dashboard/users"></c:url>' class="nav-link">All Users</a></li>
		<li class="nav-item"><a href='<c:url value="/dashboard/users/create"></c:url>' class="nav-link">Add New</a></li>
		<li class="nav-item"><a href='<c:url value="/dashboard/users/edit"></c:url>' class="nav-link">Edit</a></li>
	</ul>
  </li>
  <li class="nav-item"><a href="#" class="nav-link" id="product-menu" data-toggle="collapse" data-target="#product-submenu" aria-controls="#product-submenu" aria-expanded="false">Products</a>
	<ul class="collapse flex-column" id="product-submenu" role="menu" aria-labelledby="product-menu">
		<li class="nav-item"><a href='<c:url value="/dashboard/products"></c:url>' class="nav-link">All</a></li>
		<li class="nav-item"><a href='<c:url value="/dashboard/products/create"></c:url>' class="nav-link">Add New</a></li>
		<li class="nav-item"><a href='<c:url value="/dashboard/products/edit"></c:url>' class="nav-link">Edit</a></li>
	</ul>
  </li>
  <li class="nav-item"><a href="#" class="nav-link" id="media-menu" data-toggle="collapse" data-target="#media-submenu" aria-controls="#media-submenu" aria-expanded="false">Media</a>
	<ul class="collapse flex-column" id="media-submenu" role="menu" aria-labelledby="media-menu">
		<li class="nav-item"><a href='<c:url value="/dashboard/media"></c:url>' class="nav-link">All</a></li>
		<li class="nav-item"><a href='<c:url value="/dashboard/media/create"></c:url>' class="nav-link">Add New</a></li>
		<li class="nav-item"><a href='<c:url value="/dashboard/media/edit"></c:url>' class="nav-link">Edit</a></li>
	</ul>
  </li>
  <li class="nav-item"><a href='<c:url value="/dashboard/settings"></c:url>' class="nav-link">Settings</a></li>
  
</ul>