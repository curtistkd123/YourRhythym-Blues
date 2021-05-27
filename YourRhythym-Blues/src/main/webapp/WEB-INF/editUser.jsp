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

</head>
<body>


	<header class="section-header">
		<section class="header-main border-bottom">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-2 col-4">
						<a href="http://bootstrap-ecommerce.com" class="brand-wrap"> <img
							class="logo" src="images/logo.png">
						</a>
						<!-- brand-wrap.// -->
					</div>
					<div class="col-lg-6 col-sm-12">
						<form action="#" class="search">
							<div class="input-group w-100">
								<input type="text" class="form-control" placeholder="Search">
								<div class="input-group-append">
									<button class="btn btn-primary" type="submit">
										<i class="fa fa-search"></i> Search
									</button>
								</div>
							</div>
						</form>
						<!-- search-wrap .end// -->
					</div>
					<!-- col.// -->
					<div class="col-lg-4 col-sm-6 col-12">
						<div class="widgets-wrap float-md-right">
							<div class="widget-header  mr-3">
								<a href="#" class="icon icon-sm rounded-circle border"><i
									class="fa fa-shopping-cart"></i></a> <span
									class="badge badge-pill badge-danger notify">0</span>
							</div>
							<div class="widget-header icontext">
								<a href="#" class="icon icon-sm rounded-circle border"><i
									class="fa fa-user"></i></a>
								<div class="text">
									<span class="text-muted">Welcome!</span>
									<div>
										<a href="#">Sign in</a> | <a href="#"> Register</a>
									</div>
								</div>
							</div>

						</div>
						<!-- widgets-wrap.// -->
					</div>
					<!-- col.// -->
				</div>
				<!-- row.// -->
			</div>
			<!-- container.// -->
		</section>
		<!-- header-main .// -->
	</header>
	<!-- section-header.// -->



	<!-- ========================= SECTION CONTENT ========================= -->
	<section class="section-content padding-y">

		<!-- ============================ COMPONENT REGISTER   ================================= -->
		<div class="card mx-auto" style="max-width: 520px; margin-top: 40px;">
			<div class="card-body">
      <h4 class="card-title mb-4">Profile</h4>
     <form:form action="" method="Post" modelAttribute="user">
     	<div class="form-group">
	     	<img src="bootstrap-ecommerce-html/images/avatars/avatar1.jpg" class="img-sm rounded-circle border">
	     </div>
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
								placeholder="${user.firstName }"  />
						</div>
						<!-- form-group end.// -->
						<div class="col form-group">
							<label>Last name</label>
							<form:input path="lastName" type="text" class="form-control"
								placeholder="${user.lastName }"  />
						</div>
						<!-- form-group end.// -->
					</div>
					<!-- form-row end.// -->
					<div class="form-group">
						<label>Email</label>
						<form:input path="email" type="email" class="form-control"
							placeholder="${user.email }"  />
						<small class="form-text text-muted">We'll never share your
							email with anyone else.</small>
					</div>
					<!-- form-group end.// -->
					<div class="form-group">
						<label>Phone</label>
						<form:input path="telephone" type="tel" class="form-control"
							placeholder="${user.telephone }"  />
					</div>
					<!-- form-group end.// -->
					

		<button class="btn btn-primary btn-block">Save info</button>
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