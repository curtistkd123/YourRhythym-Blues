<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="max-age=604800" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Website title - bootstrap html template</title>

<link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon">

<!-- jQuery -->
<script src="js/jquery-2.0.0.min.js" type="text/javascript"></script>

<!-- Bootstrap4 files-->
<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />

<!-- Font awesome 5 -->
<link href="fonts/fontawesome/css/all.min.css" type="text/css"
	rel="stylesheet">

<!-- custom style -->
<link href="css/ui.css" rel="stylesheet" type="text/css" />
<link href="css/responsive.css" rel="stylesheet"
	media="only screen and (max-width: 1200px)" />

<!-- custom javascript -->
<script src="js/script.js" type="text/javascript"></script>

<script type="text/javascript">
	/// some script

	// jquery ready start
	$(document).ready(function() {
		// jQuery code

	});
	// jquery end
</script>
<style >
 body {
  background-image: url("images1/background1.jpg");
  background-repeat: no-repeat; /* Do not repeat the image */
  background-size: cover;}
     .carouselpictures {
     width:400px;
     height: 400px;}
     
     .product img {
     width:100%;
     height: 150px;
      }
     }
      </style>
</head>
<body>
	<!-- Navigation-->
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<c:choose>
				<c:when test="${user.id==null}">
					<a class="navbar-brand " href="/register"><button>Create
							Profile</button></a>
				</c:when>

				<c:otherwise>
					<c:out value="${user.firstName }" />, <a
						class="navbar-brand " href="/edituser${user.id}"><button>Edit
							Profile</button></a>

				</c:otherwise>
			</c:choose>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#!">About</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="/">All Products</a></li>
							<li><hr class="dropdown-divider" /></li>
							<c:forEach items="${categories }" var="c">
								<li><a class="dropdown-item" href="/categories${c.id}"><c:out
											value="${c.name}" /></a></li>
							</c:forEach>
							<li><a class="dropdown-item" href="">Popular Items</a></li>
							<li><a class="dropdown-item" href="#!">New Arrivals</a></li>
						</ul></li>
				</ul>
				<form:form action="/shoppingCart${user.id}" method="get"
					class="d-flex">

					<button class="btn btn-outline-dark"
						onclick="/shoppingCart${user.id}" type="submit">
						<i class="bi-cart-fill me-1"></i> Cart <span
							class="badge bg-dark text-white ms-1 rounded-pill"><c:out
								value="${cartsize }" /></span>
					</button>

				</form:form>
			</div>
		</div>
	</nav>
	<header class="bg-dark py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
				<h1 class="display-4 fw-bolder">Rhythym&Blues</h1>
				<p class="lead fw-normal text-white-50 mb-0">One stop shop for
					all things Guitars</p>
			</div>
		</div>
	</header>



	<!-- ========================= SECTION CONTENT ========================= -->
	<section class="section-content padding-y">

		<!-- ============================ COMPONENT REGISTER   ================================= -->
		<div class="card mx-auto" style="max-width: 520px; margin-top: 40px;">
			<div class="card-body">
				<h4 class="card-title mb-4">Profile</h4>
				<p>
				<form:errors path="user.*" />
			</p>
				<form:form action="edituser${user.id}" method="Post"
					modelAttribute="user">
				
					<div class="form-row">
						<div class="col form-group">
							<label>User Name</label>
							<form:input path="username" type="text" class="form-control"
								placeholder="${user.username }" />
						</div>
						<!-- form-group end.// -->
						<div class="col form-group">
							<label>First name</label>
							<form:input path="firstName" type="text" class="form-control"
								placeholder="${user.firstName }" />
						</div>
						<!-- form-group end.// -->
						<div class="col form-group">
							<label>Last name</label>
							<form:input path="lastName" type="text" class="form-control"
								placeholder="${user.lastName }" />
						</div>
						<!-- form-group end.// -->
					</div>
					<!-- form-row end.// -->
					<div class="form-group">
						<label>Email</label>
						<form:input path="email" type="email" class="form-control"
							placeholder="${user.email }" />
						<small class="form-text text-muted">We'll never share your
							email with anyone else.</small>
					</div>
					<!-- form-group end.// -->
					<div class="form-group">
						<label>Phone</label>
						<form:input path="telephone" type="tel" class="form-control"
							placeholder="${user.telephone }" />
					</div>
					<!-- form-group end.// -->


					<button class="btn btn-primary btn-block">Save info</button>
					<form:hidden path="password" value="${user.password }"/>
				</form:form>
			</div>
			<!-- card-body.// -->
		</div>
		<!-- card .// -->

		<br> <br>
		<!-- ============================ COMPONENT REGISTER  END.// ================================= -->


	</section>
	<!-- ========================= SECTION CONTENT END// ========================= -->


	<!-- ========================= FOOTER ========================= -->
	<footer class="section-footer border-top padding-y">
		<div class="container">
			<p class="float-md-right">&copy Copyright 2019 All rights
				reserved</p>
			<p>
				<a href="#">Terms and conditions</a>
			</p>
		</div>
		<!-- //container -->
	</footer>
	<!-- ========================= FOOTER END // ========================= -->



</body>
</html>